DROP TABLE IF EXISTS Purchased_Medicine;
CREATE TEMPORARY TABLE IF NOT EXISTS Purchased_Medicine_Id AS (SELECT Drug_Name FROM medicine_list WHERE Drug_Name IN ('Clopidogrel','Montelukast','Rosuvastatin'));


DELIMITER $$
CREATE PROCEDURE MAKE_BILL 
( ,
 IN Doc_name varchar(255) )
 
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




