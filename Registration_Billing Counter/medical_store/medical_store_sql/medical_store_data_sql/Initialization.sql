DROP DATABASE IF EXISTS Medical_store;
CREATE DATABASE Medical_store;

use Medical_store;

CREATE TABLE IF NOT EXISTS `Staff` (
  `Staff_id` varchar(255) NOT NULL PRIMARY KEY,
  `Name` varchar(255) NOT NULL,
  `Contact_no` bigint(10)  unsigned NOT NULL UNIQUE ,
  `Password` varchar(255) NOT NULL,
  `Adhar_no` bigint(20)  unsigned NOT NULL UNIQUE,
  `Is_Admin` tinyint(1)
);


CREATE TABLE IF NOT EXISTS `Customer` (
	`Customer_id` varchar(255) NOT NULL PRIMARY KEY,
	`Name` varchar(255) NOT NULL,
    `Contact_no` bigint(10)  unsigned NOT NULL,
	`Address` varchar(255) NOT NULL 
);

CREATE TABLE IF NOT EXISTS `Medicine_list` (
  `Product_id` bigint(10) NOT NULL PRIMARY KEY,
  `Drug_Name` varchar(255) NOT NULL ,
  `Trade_name` varchar(255) DEFAULT NULL ,
  `Description` varchar(255) DEFAULT NULL,
  `Price` bigint(10) NOT NULL CHECK(Price > 0),
  `Quantity` bigint(10) NOT NULL CHECK(Price >= 0),
  `Mfd` date NOT NULL,
  `Expd` date NOT NULL ,
  `Medicine_form` varchar(255) NOT NULL,
  `Company_name` varchar(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS `Bill` (
  `B_id` bigint(10) NOT NULL ,
  `Bill_Date` date NOT NULL,
  `C_id` varchar(255) NOT NULL ,
  `C_Name` varchar(255) NOT NULL,
  `Product_id` bigint(10) NOT NULL,
  `Quantity` bigint(10) NOT NULL,
  `Price_per_peice` bigint(10) NOT NULL,
  `Doctor_Name` varchar(255) NOT NULL,
  FOREIGN KEY (C_id) REFERENCES Customer(Customer_id),
  FOREIGN KEY (Product_id) REFERENCES Medicine_list(Product_id)
);

CREATE TABLE IF NOT EXISTS `Orders` (
  `Order_id` bigint(10) NOT NULL ,
  `Order_date` date NOT NULL,
  `staff_id` varchar(255)NOT NULL,
  `Product_id` bigint(10) NOT NULL,
  `Quantity` bigint(10) NOT NULL,
  `Price_per_peice` bigint(10) NOT NULL,
  `Company_name` varchar(255) NOT NULL,
  FOREIGN KEY (staff_id) REFERENCES Staff(Staff_id),
  FOREIGN KEY (Product_id) REFERENCES Medicine_list(Product_id)
);

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


delimiter |
CREATE TRIGGER delete_customer BEFORE DELETE ON Customer
FOR EACH ROW
   BEGIN
     DELETE FROM Bill WHERE C_Name = OLD.Name;
   END;
 |

 delimiter ;

CREATE OR REPLACE VIEW Expired_medicine  AS
SELECT * 
FROM medicine_list
WHERE Expd < CURDATE()
WITH CHECK OPTION;