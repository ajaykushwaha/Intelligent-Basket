SELECT customer.Customer_id,customer.name,bill.Bill_Date,medicine_list.Trade_name,medicine_list.Price,medicine_list.Mfd,medicine_list.Expd
From customer,bill,medicine_list
WHERE customer.Customer_id = bill.C_id AND bill.Product_id = medicine_list.Product_id
Order By customer.name,bill.Bill_Date,medicine_list.Price;
 
 
 
 SELECT customer.Customer_id,customer.name,bill.Bill_Date,medicine_list.Trade_name,medicine_list.Price,medicine_list.Mfd,medicine_list.Expd
 FROM bill
 INNER JOIN customer ON customer.Customer_id = bill.C_id
 INNER JOIN medicine_list ON bill.Product_id = medicine_list.Product_id
 ORDER BY customer.name,bill.Bill_Date,medicine_list.Price;
 
 
SELECT customer.Customer_id,customer.name,bill.Bill_Date,medicine_list.Trade_name,medicine_list.Price,medicine_list.Mfd,medicine_list.Expd,SUM(Bill.Quantity*Bill.Price_per_peice)
FROM bill
INNER JOIN customer ON customer.Customer_id = bill.C_id
INNER JOIN medicine_list ON bill.Product_id = medicine_list.Product_id
GROUP BY bill.B_id;
ORDER BY customer.name;
 
--------------------(SUB-QUERY)-----------------------INNER JOIN --------GROUP_CONCAT------------------


SELECT * FROM 
(SELECT bill.b_id,bill.Bill_Date,customer.name,GROUP_CONCAT(DISTINCT medicine_list.Trade_name SEPARATOR ',') AS Trade_names,SUM(Bill.Quantity*Bill.Price_per_peice) AS Total_Amount,Doctor_name
FROM bill
INNER JOIN customer ON customer.Customer_id = bill.C_id
INNER JOIN medicine_list ON bill.Product_id = medicine_list.Product_id
GROUP BY bill.B_id) AS c
ORDER BY Bill_Date,name;

--------------------------------------------Union-------------------------------------
SELECT  c.name,c.Address
FROM bill AS b,customer AS c
Where b.C_id = c.Customer_id AND b.Doctor_name = 'Dr.Herbert Humphrey'

UNION

SELECT  c.name,c.Address
FROM bill AS b,customer AS c
Where b.C_id = c.Customer_id AND b.Doctor_name = 'Dr.Gabriel Greathouse';

-----------------------------------------View-------------------------------------------

CREATE OR REPLACE VIEW Expired_medicine  AS
SELECT * 
FROM medicine_list
WHERE Expd < CURDATE()
WITH CHECK OPTION;

SELECT Drug_Name,Price,Quantity,Expd,Medicine_form From Expired_medicine;

DROP VIEW Expired_medicine;

-------------------------------------------Procedure------------------------------------------

DELIMITER $$
CREATE PROCEDURE Put_medicine 
( IN Product_id_p bigint(10) ,
 IN Drug_Name_p varchar(255) ,
 IN Trade_name_p varchar(255) ,
 IN Description_p varchar(255) ,
IN  Price_p bigint(10) ,
IN  Quantity_p bigint(10),
IN  Mfd_p date ,
IN  Expd_p date ,
 IN Medicine_form_p varchar(255) ,
 IN Company_name_p varchar(255) )
 
BEGIN
	
    IF EXISTS(SELECT * 
	FROM medicine_list
	Where Drug_Name =  Drug_Name_p AND  Trade_name = Trade_name_p AND Price = Price_p AND Quantity= Quantity_p AND Expd = Expd_p AND Medicine_form=Medicine_form_p
	LIMIT 1)
THEN 
	UPDATE medicine_list 
	SET Quantity = Quantity + Quantity_p 
	WHERE Drug_Name = Drug_Name_p;
ELSE 
  INSERT INTO medicine_list (Product_id, Drug_Name, Trade_name,Description,Price,Quantity,Mfd,Expd,Medicine_form,Company_name)
  VALUES (Product_id_p, Drug_Name_p, Trade_name_p,Description_p,Price_p,Quantity_p,Mfd_p,Expd_p,Medicine_form_p,Company_name_P);
	
	END IF;
END $$

DELIMITER ;


CALL Put_medicine(500,'Hydrocodone/APAP','Vicodin','Pain Relief',406,29,'2014-10-02','2020-09-18','Cream','Glenmark');

-------------------------------------TRIGGER-------------------------------------------------------
delimiter |
CREATE TRIGGER delete_customer BEFORE DELETE ON Customer
FOR EACH ROW
   BEGIN
     DELETE FROM Bill WHERE C_Name = OLD.Name;
   END;
 |

 delimiter ;

-------------------------------------CURSOR-------------------------------------------------------
DELIMITER $$
 
CREATE PROCEDURE exp_medicine_list (INOUT medicine_list varchar(4000))
BEGIN
 
 DECLARE v_finished INTEGER DEFAULT 0;
        DECLARE medicine varchar(100) DEFAULT "";
		
 DEClARE medicine_cursor CURSOR FOR 
 SELECT Trade_name FROM expired_medicine;

 DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET v_finished = 1;
 
 OPEN medicine_cursor;
 
 get_medicine: LOOP
 
 FETCH medicine_cursor INTO medicine;
 
 IF v_finished = 1 THEN 
 LEAVE get_medicine;
 END IF;
 
 SET medicine_list = CONCAT(medicine,";",medicine_list);
 
 END LOOP get_medicine;
 
 CLOSE medicine_cursor;
 
END$$
 
DELIMITER ;




SET @medicine_list = "";
CALL exp_medicine_list(@medicine_list);
SELECT @medicine_list;


DELIMITER $$
CREATE PROCEDURE short_bill( )
 
BEGIN
	SELECT * FROM 
	(SELECT bill.b_id,bill.Bill_Date,customer.name,GROUP_CONCAT(DISTINCT medicine_list.Trade_name SEPARATOR ',') AS Trade_names,SUM(Bill.Quantity*Bill.Price_per_peice) AS Total_Amount,Doctor_name
	FROM bill	
	INNER JOIN customer ON customer.Customer_id = bill.C_id
	INNER JOIN medicine_list ON bill.Product_id = medicine_list.Product_id
	GROUP BY bill.B_id) AS c
	ORDER BY Bill_Date,name;
   
END $$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE short_order( )
 
BEGIN
	SELECT * FROM 
	(SELECT orders.Order_id,orders.Order_date,staff.Name,GROUP_CONCAT(DISTINCT medicine_list.Trade_name SEPARATOR ',') AS Trade_names,SUM(orders.Quantity*orders.Price_per_peice) AS Total_Amount,Agent_name
	FROM orders	
	INNER JOIN staff ON staff.staff_id = orders.staff_id
	INNER JOIN medicine_list ON orders.Product_id = medicine_list.Product_id
	GROUP BY orders.Order_id) AS c
	ORDER BY Order_date,Name;
   
END $$

DELIMITER ;