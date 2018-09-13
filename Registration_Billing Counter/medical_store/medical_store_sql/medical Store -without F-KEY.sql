DROP DATABASE IF EXISTS Medical_store;
CREATE DATABASE Medical_store;

use Medical_store;

CREATE TABLE IF NOT EXISTS `Staff` (
  `Staff_id` varchar(255) NOT NULL PRIMARY KEY,
  `Name` varchar(255) NOT NULL,
  `Contact_no` bigint(10)  unsigned NOT NULL,
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
  `Product_id` bigint(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `Drug_Name` varchar(255) NOT NULL,
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
  `Product_id` bigint(10) NOT NULL,--
  `Quantity` bigint(10) NOT NULL,
  `Price_per_peice` bigint(10) NOT NULL,
  `Doctor_Name` varchar(255) NOT NULL,
  `Selling_price` bigint(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS `Orders` (
  `Order_id` bigint(10) NOT NULL ,
  `Order_date` date NOT NULL,
  `staff_id` varchar(255)NOT NULL,
  `Product_id` bigint(10) NOT NULL,
  `Quantity` bigint(10) NOT NULL,
  `Price_per_peice` bigint(10) NOT NULL,
  `Company_name` varchar(255) NOT NULL,
  `Agent_name` varchar(255) NOT NULL,
  `Retail_price` bigint(10) NOT NULL
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




CREATE OR REPLACE VIEW Expired_medicine  AS
SELECT * 
FROM medicine_list
WHERE Expd < CURDATE()
WITH CHECK OPTION;
 
CREATE OR REPLACE VIEW Active_medicine  AS
SELECT * 
FROM medicine_list
WHERE Expd >= CURDATE()
WITH CHECK OPTION;
 
 DELIMITER $$
 
CREATE PROCEDURE short_bill( )
 
BEGIN
	SELECT * FROM 
	(SELECT bill.b_id,bill.Bill_Date,bill.c_name,GROUP_CONCAT(DISTINCT medicine_list.Drug_name SEPARATOR ',') AS Trade_names,SUM(Bill.Quantity*Bill.Selling_price) AS Total_Amount,Doctor_name
	FROM bill	
	LEFT JOIN customer ON customer.Customer_id = bill.C_id
	INNER JOIN medicine_list ON bill.Product_id = medicine_list.Product_id
	GROUP BY bill.B_id) AS c
	ORDER BY Bill_Date,c_name;
   
END $$

DELIMITER ;
 
 
 DELIMITER $$
CREATE PROCEDURE short_order( )
 
BEGIN
	SELECT * FROM 
	(SELECT orders.Order_id,orders.Order_date,staff.Name,GROUP_CONCAT(DISTINCT medicine_list.Drug_name SEPARATOR ',') AS Trade_names,SUM(orders.Quantity*orders.Retail_price) AS Total_Amount,Agent_name
	FROM orders	
	INNER JOIN staff ON staff.staff_id = orders.staff_id
	INNER JOIN medicine_list ON orders.Product_id = medicine_list.Product_id
	GROUP BY orders.Order_id) AS c
	ORDER BY Order_date,Name;
   
END $$

DELIMITER ;
 
 
 

 
INSERT INTO Staff VALUES('MR01','Merle Rothwell',8975806691,'shinystar61',659628825235,FALSE);
INSERT INTO Staff VALUES('NH02','Nanette Hoover',8814929959,'slowS@lmon99',531459017385,TRUE);
INSERT INTO Staff VALUES('UT03','Ula Tarkington',8913711779,'mi$tyBerry35',248370154512,FALSE);
INSERT INTO Staff VALUES('RT04','Rheba Turpen',7211999015,'lazyFi$h21',358098909053,FALSE);
INSERT INTO Staff VALUES('TM05','Tommye Massingill',9812300788,'slowW!sh34',499876350021,FALSE);
INSERT INTO Staff VALUES('PG06','Paula Girard',7637372081,'ligh+Kitten66',976291988239,FALSE);
INSERT INTO Staff VALUES('FM07','Flo Manly',9121654682,')ampStamp92',140272000796,FALSE);
INSERT INTO Staff VALUES('NU08','Norman Udell',9559042450,'3mptyCorn70',895940309446,FALSE);
INSERT INTO Staff VALUES('CU09','Carlos Ullrich',8082700837,'gian+Ivory71',260099565825,TRUE);
INSERT INTO Staff VALUES('MG10','Myron Geary',8354862423,'d!zzyCamel64',831235006125,FALSE);


INSERT INTO Customer VALUES('DT1','Denese Tison',9711717089,'7453 Euclid Lane ,Savage, MN 55378');
INSERT INTO Customer VALUES('JB2','Josefine Barriere',9704894895,'837 Sugar Street ,Cleveland, TN 37312');
INSERT INTO Customer VALUES('DB3','Darius Bobadilla',7653793868,'8875 El Dorado Court ,Campbell, CA 95008');
INSERT INTO Customer VALUES('DB4','Devorah Badgley',9100108337,'31 Valley Farms Ave. ,Port Richey, FL 34668');
INSERT INTO Customer VALUES('DN5','Dannie Nye',9702898839,'635 Second Drive, Milwaukee, WI 53204');
INSERT INTO Customer VALUES('CV6','Courtney Vanscoy',7354968240,'13 Ketch Harbour St. ,Southington, CT 06489');
INSERT INTO Customer VALUES('VG7','Verla Goforth',9140658594,'282 New Saddle Court ,Tonawanda, NY 14150');
INSERT INTO Customer VALUES('MM8','Marion Marc',7379982247,'9246 S. Trenton Street ,Cumberland, RI 02864');
INSERT INTO Customer VALUES('CR9','Cathy Rivet',7503253508,'36 Hilldale Avenue ,High Point, NC 27265');
INSERT INTO Customer VALUES('JD10','Joelle Dimauro',9997827999,'17 Mechanic Street ,Elmhurst, NY 11373');
INSERT INTO Customer VALUES('PK11','Pamelia Korman',7451179694,'103 Nut Swamp Road ,Ithaca, NY 14850');
INSERT INTO Customer VALUES('JP12','Jackqueline Popp',7782012537,'107 North Leatherwood Dr. ,Bethel Park, PA 15102');
INSERT INTO Customer VALUES('RQ13','Rosenda Quinney',9402549382,'256 Wakehurst St. ,Lakewood, NJ 08701');
INSERT INTO Customer VALUES('EK14','Erinn Kindrick',7676549964,'8658 Madison Ave. ,Willoughby, OH 44094');
INSERT INTO Customer VALUES('TR15','Tatum Rudolf',9196061772,'883 Bridgeton Lane ,Seymour, IN 47274');
INSERT INTO Customer VALUES('ZM16','Zelma Murguia',7582574773,'823 Spring Court ,Oak Park, MI 48237');
INSERT INTO Customer VALUES('BM17','Briana Merkel',8449871662,'6 Oak Street ,Farmingdale, NY 11735');
INSERT INTO Customer VALUES('CS18','Carli Saleh',7156406235,'9156 Orchard Ave. ,Opa Locka, FL 33054');
INSERT INTO Customer VALUES('DT19','Dee Tomasello',7180146990,'8700 Fremont Rd. ,Holly Springs, NC 27540');
INSERT INTO Customer VALUES('MB20','Maryjane Beedle',7425162157,'8640 East Randall Mill Drive ,Orange, NJ 07050');
INSERT INTO Customer VALUES('SH21','Shan Hitz',9982419232,'533 Gregory Lane ,Myrtle Beach, SC 29577');
INSERT INTO Customer VALUES('BS22','Beverley Shirah',9535610246,'70 Lancaster Dr. ,Brunswick, GA 31525');
INSERT INTO Customer VALUES('KG23','Katherin Gaulding',7798597735,'8443 Valley Dr. ,Grove City, OH 43123');
INSERT INTO Customer VALUES('TT24','Terrence Tamayo',9692510082,'778 Peninsula Avenue ,Charleston, SC 29406');
INSERT INTO Customer VALUES('FM25','Faith Miyashiro',7960845271,'9684 Park St. ,Centreville, VA 20120');
INSERT INTO Customer VALUES('BC26','Betsy Colson',9642668862,'854 Leatherwood Ave. ,Stratford, CT 06614');
INSERT INTO Customer VALUES('JH27','Jazmin Hoard',9170007044,'991 Brandywine Street ,Hopewell, VA 23860');
INSERT INTO Customer VALUES('MT28','Melva Tolbert',9134410448,'390 Cedarwood St. ,Rome, NY 13440');
INSERT INTO Customer VALUES('EW29','Emanuel Weitz',8691244112,'555 Homewood St. ,Monroe Township, NJ 08831');
INSERT INTO Customer VALUES('MB30','Marquitta Bevacqua',9198557076,'765 Sherwood St. ,Corpus Christi, TX 78418');
INSERT INTO Customer VALUES('CT31','Caryl Turnquist',7657333260,'7461 Purple Finch Ave. ,Missoula, MT 59801');
INSERT INTO Customer VALUES('LS32','Loreta Stuber',8542833787,'8678 East Leeton Ridge Street ,Winter Springs, FL 32708');
INSERT INTO Customer VALUES('MS33','Micki Subia',8172755758,'330 South Devon Ave. ,Saint Albans, NY 11412');
INSERT INTO Customer VALUES('ID34','Iluminada Dull',7766206660,'121 High Point Lane ,Shirley, NY 11967');
INSERT INTO Customer VALUES('JH35','Jeri Hawes',9923396033,'597 North Rockcrest Drive ,Fayetteville, NC 28303');
INSERT INTO Customer VALUES('MB36','Margareta Burrell',7346680696,'9233 St Louis Rd. ,Sun Prairie, WI 53590');
INSERT INTO Customer VALUES('MD37','Miles Dipalma',7203695009,'85 Brewery Avenue ,Hattiesburg, MS 39401');
INSERT INTO Customer VALUES('LS38','Ludivina Spilman',7698116193,'81 Edgefield Drive ,Herndon, VA 20170');
INSERT INTO Customer VALUES('SS39','Sherrill Seabrook',8228132932,'84 N. Woodside St. ,Hialeah, FL 33010');
INSERT INTO Customer VALUES('HB40','Hunter Bartle',7764614382,'53 Green Ave. ,Reynoldsburg, OH 43068');


INSERT INTO Medicine_list VALUES(1,'Levothyroxine','Synthroid','Thyroid Hormone',1849,25,'2015-01-08','2019-10-14','Tablets','Dr Reddys Labs');
INSERT INTO Medicine_list VALUES(2,'Hydrocodone/APAP','Vicodin','Pain Relief',406,29,'2014-10-02','2018-09-18','Cream','Glenmark');
INSERT INTO Medicine_list VALUES(3,'Amoxicillin','Amoxil','Anti-Biotic',1697,7,'2016-02-01','2018-07-03','Syrup','Dr Reddys Labs');
INSERT INTO Medicine_list VALUES(4,'Lisinopril','Prinivil','A.C.E. Inhibitor',1077,38,'2017-01-28','2018-04-01','Syrup','Wockhardt');
INSERT INTO Medicine_list VALUES(5,'Esomeprazole','Nexium','G.E.R.D.',658,1,'2015-11-05','2019-02-12','Capsules','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(6,'Atorvastatin','Lipitor','Cholesterol',780,31,'2017-04-17','2018-06-01','Cream','Glenmark');
INSERT INTO Medicine_list VALUES(7,'Simvastatin','Zocor','Cholesterol',1612,38,'2015-02-18','2019-11-28','Syrup','Divis Labs');
INSERT INTO Medicine_list VALUES(8,'Clopidogrel','Plavix','Anti-Platelet',538,1,'2015-11-10','2017-07-18','Capsules','Glenmark');
INSERT INTO Medicine_list VALUES(9,'Montelukast','Singulair','Asthma',152,45,'2015-11-11','2017-07-28','Drops','Biocon');
INSERT INTO Medicine_list VALUES(10,'Rosuvastatin','Crestor','Cholesterol',53,37,'2016-08-22','2018-02-03','Drops','Piramal Enter');
INSERT INTO Medicine_list VALUES(11,'Metoprolol','Lopressor','Beta Blocker',277,37,'2016-02-01','2018-12-11','Syrup','Cipla');
INSERT INTO Medicine_list VALUES(12,'Escitalopram','Lexapro','Anti-Depressant',353,17,'2015-07-20','2018-03-01','Syrup','Abbott India');
INSERT INTO Medicine_list VALUES(13,'Azithromycin','Zithromax','Anti-Biotic',1543,11,'2015-11-18','2018-11-20','Tablets','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(14,'Albuterol','ProAir HFA','Asthma Inhaler',292,20,'2015-10-25','2018-07-07','Cream','Wockhardt');
INSERT INTO Medicine_list VALUES(15,'Hydrochlorothiazide','HCTZ','Diuretic',818,46,'2017-06-07','2019-01-09','Syrup','Jubilant Life');
INSERT INTO Medicine_list VALUES(16,'Metformin','Glucophage','Anti-Diabetic',487,43,'2016-08-09','2018-11-21','Drops','Sanofi India');
INSERT INTO Medicine_list VALUES(17,'Sertraline','Zoloft','Anti-Depressant',76,28,'2014-12-06','2019-10-20','Cream','Divis Labs');
INSERT INTO Medicine_list VALUES(18,'Ibuprofen','Advil','N.S.A.I.D.',708,44,'2014-07-09','2018-11-25','Drops','Ipca Labs');
INSERT INTO Medicine_list VALUES(19,'Zolpidem','Ambien','Insomnia',1297,23,'2015-07-23','2019-05-04','Capsules','Lupin');
INSERT INTO Medicine_list VALUES(20,'Furosemide','Lasix','Diuretic',1927,41,'2016-07-04','2018-02-05','Drops','Lupin');
INSERT INTO Medicine_list VALUES(21,'Omeprazole','Prilosec','G.E.R.D.',488,9,'2015-12-24','2019-03-03','Tablets','Abbott India');
INSERT INTO Medicine_list VALUES(22,'Trazodone','Desyrel','Anti-Depressant',1507,41,'2015-07-03','2018-07-11','Syrup','Alkem Lab');
INSERT INTO Medicine_list VALUES(23,'Valsartan','Diovan','A.2.R.B.',1887,19,'2016-01-18','2018-01-28','Syrup','Wockhardt');
INSERT INTO Medicine_list VALUES(24,'Tramadol','Ultram','Pain Relief',896,16,'2017-04-23','2018-11-06','Drops','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(25,'Duloxetine','Cymbalta','Anti-Depressant',1494,11,'2017-06-01','2019-06-14','Drops','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(26,'Warfarin','Coumadin','Blood Thinner',1533,14,'2015-05-05','2018-05-17','Drops','Piramal Enter');
INSERT INTO Medicine_list VALUES(27,'Amlodipine','Norvasc','Calc. Chnl. Blkr.',996,34,'2014-07-14','2019-03-03','Drops','Sun Pharma');
INSERT INTO Medicine_list VALUES(28,'Oxycodone/APAP','Percocet','Pain Relief',1291,20,'2014-07-18','2018-05-28','Syrup','Piramal Enter');
INSERT INTO Medicine_list VALUES(29,'Quetiapine','Seroquel','Anti-Psychotic',1952,11,'2015-04-01','2019-07-20','Syrup','Jubilant Life');
INSERT INTO Medicine_list VALUES(30,'Promethazine','Phenergan','Anti-Histamine',1650,39,'2014-11-26','2018-09-06','Capsules','Sun Pharma');
INSERT INTO Medicine_list VALUES(31,'Fluticasone','Flonase','Allergies -',708,16,'2015-07-22','2018-05-29','Tablets','Sun Pharma');
INSERT INTO Medicine_list VALUES(32,'Alprazolam','Xanax','Anti-Anxiety',80,10,'2015-11-10','2018-07-24','Tablets','Torrent Pharma');
INSERT INTO Medicine_list VALUES(33,'Clonazepam','Klonopin','Anti-Anxiety',1411,11,'2015-10-13','2019-11-17','Cream','Abbott India');
INSERT INTO Medicine_list VALUES(34,'Benazepril','Lotensin','ACE Inhibitor',614,10,'2016-03-26','2019-10-14','Syrup','Piramal Enter');
INSERT INTO Medicine_list VALUES(35,'Meloxicam','Mobic','NSAID (Arthritis)',204,13,'2016-12-05','2018-01-09','Cream','Dr Reddys Labs');
INSERT INTO Medicine_list VALUES(36,'Citalopram','Celexa','Anti-Depressant',1651,7,'2015-07-16','2019-04-13','Capsules','Cadila Health');
INSERT INTO Medicine_list VALUES(37,'Cephalexin','Keflex','Anti-Biotic',1096,8,'2014-11-13','2019-07-23','Drops','Glenmark');
INSERT INTO Medicine_list VALUES(38,'Tiotropium','Spiriva','C.O.P.D.',269,49,'2016-12-12','2019-11-23','Capsules','Alembic Pharma');
INSERT INTO Medicine_list VALUES(39,'Gabapentin','Neurontin','Anti-Epileptic',1307,10,'2016-05-31','2019-01-04','Syrup','Lupin');
INSERT INTO Medicine_list VALUES(40,'Aripiprazole','Abilify','Antipsychotic',1824,18,'2014-08-22','2019-10-15','Cream','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(41,'Potassium','K-Tab','Electrolyte',1162,10,'2016-09-13','2019-11-06','Capsules','Sun Pharma');
INSERT INTO Medicine_list VALUES(42,'Cyclobenzaprine','Flexeril','Muscle Relaxer',974,44,'2017-02-14','2019-03-12','Syrup','Wockhardt');
INSERT INTO Medicine_list VALUES(43,'Methylprednisolone','Medrol','Corticosteroid',840,26,'2016-06-14','2018-07-23','Capsules','Biocon');
INSERT INTO Medicine_list VALUES(44,'Methylphenidate','Concerta','A.D.H.D.',1372,3,'2014-10-24','2018-11-22','Drops','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(45,'Loratadine','Claritin','Allergies',320,42,'2015-03-26','2018-11-15','Drops','Cadila Health');
INSERT INTO Medicine_list VALUES(46,'Carvedilol','Coreg','C.H.F.',419,26,'2017-02-23','2019-03-01','Tablets','Lupin');
INSERT INTO Medicine_list VALUES(47,'Carisoprodol','Soma','Muscle Relaxer',235,24,'2016-02-18','2019-01-07','Cream','Divis Labs');
INSERT INTO Medicine_list VALUES(48,'Digoxin','Lanoxin','C.H.F.',1256,24,'2014-12-13','2019-04-05','Capsules','Sun Pharma');
INSERT INTO Medicine_list VALUES(49,'Memantine','Namenda','Alzheimers',139,2,'2016-09-21','2019-03-11','Drops','Glenmark');
INSERT INTO Medicine_list VALUES(50,'Atenolol','Tenormin','Beta Blocker',1966,9,'2016-12-04','2019-03-28','Capsules','Lupin');
INSERT INTO Medicine_list VALUES(51,'Diazepam','Valium','Anti-Anxiety',1977,35,'2017-06-30','2019-07-27','Syrup','Alkem Lab');
INSERT INTO Medicine_list VALUES(52,'Oxycodone','OxyContin','Pain Relief',335,10,'2015-08-11','2018-12-27','Tablets','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(53,'Risedronate','Actonel','Osteoporosis',1839,42,'2014-08-12','2018-01-15','Cream','Ipca Labs');
INSERT INTO Medicine_list VALUES(54,'Folic Acid','Folvite','Supplement',1341,38,'2015-09-18','2018-04-19','Tablets','Sanofi India');
INSERT INTO Medicine_list VALUES(55,'Losartan + HCTZ','Hyzaar','Hypertension',187,33,'2017-06-05','2019-04-18','Tablets','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(56,'Prednisone','Deltasone','Anti-Inflammatory',1946,36,'2017-02-26','2019-04-06','Drops','Biocon');
INSERT INTO Medicine_list VALUES(57,'Prednisolone','Omnipred','Anti-Inflammatory',1465,42,'2016-05-05','2018-08-22','Capsules','Sun Pharma');
INSERT INTO Medicine_list VALUES(58,'Alendronate','Fosamax','Osteoporosis',892,3,'2016-05-30','2019-07-29','Cream','Strides Shasun');
INSERT INTO Medicine_list VALUES(59,'Pantoprazole','Protonix','G.E.R.D.',1350,44,'2017-04-19','2018-09-18','Cream','Abbott India');
INSERT INTO Medicine_list VALUES(60,'Tamsulosin','Flomax','Freq. Urination',577,18,'2015-01-01','2018-09-28','Cream','Alembic Pharma');
INSERT INTO Medicine_list VALUES(61,'Triamterene + HCTZ','Dyazide','Diuretic Combo',1071,35,'2017-04-04','2019-03-01','Tablets','Strides Shasun');
INSERT INTO Medicine_list VALUES(62,'Paroxetine','Paxil','Anti-Depressant',592,43,'2015-02-01','2019-07-04','Tablets','Wockhardt');
INSERT INTO Medicine_list VALUES(63,'Buprenorphine + Naloxone','Suboxone','Opiate Addiction',482,44,'2015-02-09','2018-11-29','Syrup','Divis Labs');
INSERT INTO Medicine_list VALUES(64,'Enalapril','Vasotec','A.C.E. Inhibitor',714,40,'2015-06-16','2018-11-22','Cream','Cadila Health');
INSERT INTO Medicine_list VALUES(65,'Lovastatin','Mevacor','Cholesterol',340,26,'2015-08-02','2019-08-08','Tablets','Glenmark');
INSERT INTO Medicine_list VALUES(66,'Pioglitazone','Actos','Diabetes',430,41,'2014-09-22','2018-05-21','Syrup','Abbott India');
INSERT INTO Medicine_list VALUES(67,'Pravastatin','Pravachol','Cholesterol',1863,8,'2017-05-28','2018-03-15','Cream','Lupin');
INSERT INTO Medicine_list VALUES(68,'Fluoxetine','Prozac','Anti-Depressant',351,31,'2017-04-13','2019-01-07','Drops','Dr Reddys Labs');
INSERT INTO Medicine_list VALUES(69,'Insulin Detemir','Levemir','Long-Acting Insulin',318,9,'2016-07-10','2018-06-29','Syrup','Jubilant Life');
INSERT INTO Medicine_list VALUES(70,'Fluconazole','Diflucan','Anti-Fungal',88,15,'2016-05-22','2019-08-30','Drops','Sun Pharma');
INSERT INTO Medicine_list VALUES(71,'Levofloxacin','Levaquin','Anti-Biotic',1734,4,'2016-03-26','2019-04-01','Syrup','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(72,'Rivaroxaban','Xarelto','Blood Thinner',1051,16,'2015-08-14','2019-10-29','Syrup','Abbott India');
INSERT INTO Medicine_list VALUES(73,'Celecoxib','Celebrex','N.S.A.I.D.',1684,47,'2015-09-29','2019-10-22','Drops','Cadila Health');
INSERT INTO Medicine_list VALUES(74,'Codeine / APAP','Tylenol #2','Pain Relief',650,14,'2015-05-31','2019-06-20','Tablets','Divis Labs');
INSERT INTO Medicine_list VALUES(75,'Mometasone','Nasonex','Allergies',1401,42,'2017-06-10','2018-03-02','Cream','Abbott India');
INSERT INTO Medicine_list VALUES(76,'Ciprofloxacin','Cipro','Anti-Biotic',1679,31,'2016-06-28','2019-11-22','Tablets','Jubilant Life');
INSERT INTO Medicine_list VALUES(77,'Pregabalin','Lyrica','Anti-Convulsant',237,21,'2016-09-07','2019-11-20','Tablets','Ipca Labs');
INSERT INTO Medicine_list VALUES(78,'Insulin Aspart','Novolog','Rapid-Acting Insulin',571,18,'2015-09-25','2019-02-06','Cream','Biocon');
INSERT INTO Medicine_list VALUES(79,'Venlafaxine','Effexor','Anti-Depressant',1969,1,'2016-07-28','2019-11-22','Syrup','Alembic Pharma');
INSERT INTO Medicine_list VALUES(80,'Lorazepam','Ativan','Anti-Anxiety',619,15,'2014-10-06','2017-04-16','Tablets','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(81,'Ezetimibe','Zetia','Cholesterol',519,28,'2016-11-05','2019-04-10','Capsules','Cipla');
INSERT INTO Medicine_list VALUES(82,'Estrogen','Premarin','Menopause',1946,25,'2017-03-21','2019-10-30','Capsules','Lupin');
INSERT INTO Medicine_list VALUES(83,'Allopurinol','Zyloprim','Anti-gout',24,2,'2015-06-16','2019-02-17','Cream','Sun Pharma');
INSERT INTO Medicine_list VALUES(84,'Penicillin','Pen VK','Anti-Biotic',1871,6,'2015-12-16','2018-04-25','Drops','Biocon');
INSERT INTO Medicine_list VALUES(85,'Sitagliptin','Januvia','Diabetes',711,36,'2015-01-17','2019-01-11','Syrup','Sanofi India');
INSERT INTO Medicine_list VALUES(86,'Amitriptyline','Elavil','Anti-Depressant',1674,1,'2017-07-31','2019-05-03','Tablets','Cipla');
INSERT INTO Medicine_list VALUES(87,'Clonidine','Catapres','Hypertension',1545,2,'2015-09-28','2018-07-09','Capsules','Biocon');
INSERT INTO Medicine_list VALUES(88,'Latanoprost','Xalatan','Glaucoma',576,18,'2014-07-25','2019-08-01','Drops','Sanofi India');
INSERT INTO Medicine_list VALUES(89,'Lisdexamfetamine','Vyvanse','A.D.H.D.',1258,25,'2016-06-11','2018-06-29','Capsules','Sanofi India');
INSERT INTO Medicine_list VALUES(90,'Fluticasone + Salmeterol','Advair','Asthma/COPD',719,29,'2017-05-29','2018-09-06','Drops','Alkem Lab');
INSERT INTO Medicine_list VALUES(91,'Budesonide + Formoterol','Symbicort','Asthma/COPD',826,28,'2016-10-31','2018-08-23','Syrup','Glenmark');
INSERT INTO Medicine_list VALUES(92,'Dexlansoprazole','Dexilant','G.E.R.D.',1388,21,'2016-02-03','2019-11-26','Syrup','Sun Pharma');
INSERT INTO Medicine_list VALUES(93,'Glyburide','Diabeta','Diabetes',1627,9,'2017-04-15','2019-03-07','Tablets','Strides Shasun');
INSERT INTO Medicine_list VALUES(94,'Olanzapine','Zyprexa','Anti-Psychotic',328,3,'2015-11-29','2018-04-09','Cream','Alkem Lab');
INSERT INTO Medicine_list VALUES(95,'Tolterodine','Detrol','Overactive Bladder',154,36,'2015-01-08','2018-08-16','Drops','Alembic Pharma');
INSERT INTO Medicine_list VALUES(96,'Ranitidine','Zantac','G.E.R.D.',955,6,'2016-02-10','2018-05-05','Capsules','Torrent Pharma');
INSERT INTO Medicine_list VALUES(97,'Famotidine','Pepcid','G.E.R.D.',1590,10,'2016-07-06','2018-04-13','Tablets','Piramal Enter');
INSERT INTO Medicine_list VALUES(98,'Diltiazem','Cardizem','Hypertension',560,16,'2015-06-30','2019-08-01','Drops','Sun Pharma');
INSERT INTO Medicine_list VALUES(99,'Insulin Glargine','Lantus','Long-Acting Insulin',1626,2,'2016-11-11','2019-03-17','Drops','Wockhardt');
INSERT INTO Medicine_list VALUES(100,'Lisinopril + HCTZ','Prinizide','Hypertension',745,9,'2015-01-02','2018-06-28','Cream','Biocon');
INSERT INTO Medicine_list VALUES(101,'Bupropion','Wellbutrin','Antidepressant',1457,45,'2017-05-19','2018-12-17','Cream','Lupin');
INSERT INTO Medicine_list VALUES(102,'Cetirizine','Zyrtec','Allergies',382,38,'2016-06-27','2017-01-01','Drops','Sun Pharma');
INSERT INTO Medicine_list VALUES(103,'Topiramate','Topamax','Antiepileptic',141,32,'2016-01-24','2018-10-07','Capsules','Divis Labs');
INSERT INTO Medicine_list VALUES(104,'Valacyclovir','Valtrex','Herpes Mgmt.',789,39,'2014-10-30','2019-06-13','Tablets','Wockhardt');
INSERT INTO Medicine_list VALUES(105,'Eszopiclone','Lunesta','Sleep Aid',562,31,'2015-03-10','2019-11-28','Capsules','Divis Labs');
INSERT INTO Medicine_list VALUES(106,'Acyclovir','Zovirax','Herpes Mgmt.',76,17,'2016-05-16','2019-08-29','Tablets','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(107,'Cefdinir','Omnicef','Antibiotic',1585,12,'2017-07-03','2019-02-05','Capsules','Alembic Pharma');
INSERT INTO Medicine_list VALUES(108,'Clindamycin','Cleocin','Antibiotic',181,31,'2016-11-02','2018-06-28','Drops','Dr Reddys Labs');
INSERT INTO Medicine_list VALUES(109,'Levetiracetam','Keppra','Anti-Seizure',1987,43,'2015-11-28','2018-02-17','Cream','Dr Reddys Labs');
INSERT INTO Medicine_list VALUES(110,'Gemfibrozil','Lopid','Cholesterol',1610,24,'2015-06-08','2019-04-28','Syrup','Biocon');
INSERT INTO Medicine_list VALUES(111,'Guaifenesin','Robitussin','Expectorant',1539,8,'2014-12-20','2019-04-18','Drops','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(112,'Glipizide','Glucotrol','Diabetes(II)',1931,43,'2015-02-08','2019-06-16','Tablets','Cadila Health');
INSERT INTO Medicine_list VALUES(113,'Irbesartan','Avapro','A.2.R.B.',1378,9,'2017-06-23','2019-08-07','Cream','Torrent Pharma');
INSERT INTO Medicine_list VALUES(114,'Metoclopramide','Reglan','G.E.R.D.',166,30,'2017-01-11','2018-06-04','Cream','Cadila Health');
INSERT INTO Medicine_list VALUES(115,'Losartan','Cozaar','Hypertension',231,6,'2015-10-17','2019-05-22','Capsules','Ipca Labs');
INSERT INTO Medicine_list VALUES(116,'Meclizine','Dramamine','Antiemetic',569,14,'2014-07-14','2019-04-03','Cream','Wockhardt');
INSERT INTO Medicine_list VALUES(117,'Metronidazole','Flagyl','Antibiotic',1827,1,'2017-04-08','2018-05-18','Cream','Alembic Pharma');
INSERT INTO Medicine_list VALUES(118,'Vitamin D','Caltrate','Supplement',109,34,'2016-10-14','2018-08-07','Cream','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(119,'Testosterone','AndroGel','Low T',551,41,'2014-11-28','2019-10-12','Capsules','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(120,'Ropinirole','Requip','Parkinsons',1051,16,'2015-08-22','2018-04-07','Syrup','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(121,'Risperidone','Risperdal','Antipsychotic',1624,17,'2016-08-14','2019-10-13','Tablets','Wockhardt');
INSERT INTO Medicine_list VALUES(122,'Olopatadine','Patanol','Antihistamine',960,11,'2017-05-03','2018-07-16','Drops','Dr Reddys Labs');
INSERT INTO Medicine_list VALUES(123,'Donepezil','Aricept','Dementia',279,42,'2015-05-03','2018-07-12','Cream','Sun Pharma');
INSERT INTO Medicine_list VALUES(124,'Dexmethylphenidate','Focalin','ADHD',1368,5,'2016-10-01','2019-09-24','Cream','Piramal Enter');
INSERT INTO Medicine_list VALUES(125,'Enoxaparin','Lovenox','Anti-coagulant',1798,4,'2017-03-12','2019-01-08','Drops','Cipla');
INSERT INTO Medicine_list VALUES(126,'Fentanyl','Duragesic','Narcotic Analgesic',282,8,'2014-08-21','2019-04-06','Tablets','Alkem Lab');
INSERT INTO Medicine_list VALUES(127,'Dicyclomine','Bentyl','I.B.S.',1477,44,'2015-12-19','2018-08-24','Syrup','Biocon');
INSERT INTO Medicine_list VALUES(128,'Levalbuterol','Xopenex','Bronchospasm',1866,1,'2017-06-21','2019-07-16','Syrup','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(129,'Atomoxetine','Strattera','A.D.H.D.',1934,7,'2014-11-20','2018-11-05','Syrup','Biocon');
INSERT INTO Medicine_list VALUES(130,'Ramipril','Altace','Hypertension',1840,25,'2015-10-29','2019-09-28','Syrup','Divis Labs');
INSERT INTO Medicine_list VALUES(131,'Temazepam','Restoril','Sleep Aid',1523,41,'2017-08-13','2019-08-11','Tablets','Torrent Pharma');
INSERT INTO Medicine_list VALUES(132,'Phentermine','Adipex P','Weight Loss',1892,2,'2015-09-08','2018-04-21','Capsules','Torrent Pharma');
INSERT INTO Medicine_list VALUES(133,'Quinapril','Accupril','ACE Inhibitor',269,2,'2016-07-03','2019-10-23','Drops','Jubilant Life');
INSERT INTO Medicine_list VALUES(134,'Sildenafil','Viagra','Impotence',765,16,'2016-01-25','2019-05-28','Cream','Sanofi India');
INSERT INTO Medicine_list VALUES(135,'Ondansetron','Zofran','Antiemetic',1654,41,'2015-01-08','2019-04-01','Cream','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(136,'Oseltamivir','Tamiflu','Antiviral (Flu)',1007,49,'2014-11-09','2019-04-10','Cream','Jubilant Life');
INSERT INTO Medicine_list VALUES(137,'Methotrexate','Rheumatrex','Rheum. arthritis',517,38,'2015-08-27','2019-01-23','Syrup','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(138,'Dabigatran','Pradaxa','Anticoagulant',603,49,'2015-02-14','2019-08-07','Cream','Torrent Pharma');
INSERT INTO Medicine_list VALUES(139,'Budesonide','Uceris','Ulcerative colitis',1656,16,'2015-04-07','2018-04-28','Capsules','Alkem Lab');
INSERT INTO Medicine_list VALUES(140,'Doxazosin','Cardura','Freq. Urination',1638,36,'2016-04-22','2019-04-15','Syrup','Sun Pharma');
INSERT INTO Medicine_list VALUES(141,'Desvenlafaxine','Pristiq','Anti-depressant',1751,48,'2014-07-28','2018-03-28','Cream','Divis Labs');
INSERT INTO Medicine_list VALUES(142,'Insulin Lispro','Humalog','Rapid-Acting Insulin',1083,9,'2016-07-16','2018-01-12','Cream','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(143,'Clarithromycin','Biaxin','Antibiotic',362,4,'2016-04-16','2019-06-14','Capsules','Biocon');
INSERT INTO Medicine_list VALUES(144,'Buspirone','Buspar','Anti-anxiety',422,17,'2015-07-04','2019-02-01','Syrup','Cipla');
INSERT INTO Medicine_list VALUES(145,'Finasteride','Proscar','B.P.H.',67,13,'2016-12-08','2019-04-22','Tablets','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(146,'Ketoconazole','Nizoral','Antifungal',1514,41,'2016-03-22','2019-02-07','Syrup','Abbott India');
INSERT INTO Medicine_list VALUES(147,'Solifenacin','VESIcare','Overactive Bladder',1240,47,'2016-04-02','2018-04-22','Drops','Strides Shasun');
INSERT INTO Medicine_list VALUES(148,'Methadone','Dolophine','Anti-addictive',1562,26,'2014-10-03','2018-10-04','Cream','Divis Labs');
INSERT INTO Medicine_list VALUES(149,'Minocycline','Minocin','Antibiotic',1888,1,'2014-08-13','2018-10-20','Capsules','Biocon');
INSERT INTO Medicine_list VALUES(150,'Phenazopyridine','Pyridium','U.T.I.',814,12,'2014-12-26','2019-04-15','Syrup','Abbott India');
INSERT INTO Medicine_list VALUES(151,'Spironolactone','Aldactone','Diuretic',732,27,'2016-06-24','2019-11-19','Tablets','Alembic Pharma');
INSERT INTO Medicine_list VALUES(152,'Vardenafil','Levitra','Impotence',1083,39,'2017-05-12','2019-08-08','Capsules','Sanofi India');
INSERT INTO Medicine_list VALUES(153,'Clobetasol','Clovate','Corticosteroid',1300,19,'2015-01-31','2019-09-20','Cream','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(154,'Benzonatate','Tessalon','Antitussive',824,0,'2015-09-21','2018-12-10','Drops','Biocon');
INSERT INTO Medicine_list VALUES(155,'Divalproex','Depakote','Antiepileptic',1919,50,'2016-01-08','2018-08-16','Cream','Sanofi India');
INSERT INTO Medicine_list VALUES(156,'Dutasteride','Avodart','B.P.H.',1359,10,'2014-07-16','2018-06-03','Drops','Sanofi India');
INSERT INTO Medicine_list VALUES(157,'Febuxostat','Uloric','Gout',1100,26,'2015-08-25','2019-05-24','Capsules','Lupin');
INSERT INTO Medicine_list VALUES(158,'Lamotrigine','Lamictal','Antiepileptic',1911,1,'2016-12-12','2018-12-15','Drops','Strides Shasun');
INSERT INTO Medicine_list VALUES(159,'Nortriptyline','Pamelor','Antidepressant',805,16,'2015-04-10','2018-06-06','Syrup','Sanofi India');
INSERT INTO Medicine_list VALUES(160,'Glimepiride','Amaryl','Anti-Diabetes',695,17,'2015-01-18','2018-08-24','Cream','Cipla');
INSERT INTO Medicine_list VALUES(161,'Rabeprazole','Aciphex','G.E.R.D.',1412,34,'2014-11-26','2019-01-05','Tablets','Jubilant Life');
INSERT INTO Medicine_list VALUES(162,'Etanercept','Enbrel','Anti-Arthritis',1867,26,'2014-07-13','2019-06-24','Capsules','Piramal Enter');
INSERT INTO Medicine_list VALUES(163,'Nebivolol','Bystolic','Beta Blocker',652,33,'2016-06-12','2019-07-25','Drops','Alkem Lab');
INSERT INTO Medicine_list VALUES(164,'Nabumetone','Relafen','N.S.A.I.D',1663,18,'2014-07-31','2018-04-22','Capsules','Abbott India');
INSERT INTO Medicine_list VALUES(165,'Nifedipine','Procardia','Calc. Chan. Blocker',1165,43,'2015-06-15','2019-08-18','Syrup','Divis Labs');
INSERT INTO Medicine_list VALUES(166,'Nitrofurantoin','Macrobid','Antibiotic',710,38,'2016-12-01','2018-12-28','Cream','Sanofi India');
INSERT INTO Medicine_list VALUES(167,'Nitroglycerine','NitroStat SL','Angina',1654,43,'2016-03-28','2019-07-25','Syrup','Alembic Pharma');
INSERT INTO Medicine_list VALUES(168,'Oxybutynin','Ditropan','Incontinence',1377,35,'2015-11-27','2018-03-13','Tablets','Divis Labs');
INSERT INTO Medicine_list VALUES(169,'Tadalifil','Cialis','Impotence',452,46,'2016-07-04','2019-02-03','Syrup','Alkem Lab');
INSERT INTO Medicine_list VALUES(170,'Triamcinolone','Kenalog','Corticosteroid',572,36,'2015-06-07','2018-02-12','Drops','Biocon');
INSERT INTO Medicine_list VALUES(171,'Rivastigmine','Exelon','Anti-Dimentia',1802,4,'2016-07-08','2018-03-12','Cream','Torrent Pharma');
INSERT INTO Medicine_list VALUES(172,'Lansoprazole','Prevacid','G.E.R.D.',1023,33,'2016-08-22','2018-09-12','Tablets','Torrent Pharma');
INSERT INTO Medicine_list VALUES(173,'Cefuroxime','Ceftin','Antibiotic',652,34,'2016-01-07','2018-04-11','Syrup','Glenmark');
INSERT INTO Medicine_list VALUES(174,'Methocarbamol','Robaxin','Muscle Relaxer',425,47,'2016-03-27','2018-06-30','Syrup','Alkem Lab');
INSERT INTO Medicine_list VALUES(175,'Travoprost','Travatan','Ocular Hypertension',1001,44,'2015-07-25','2018-01-11','Cream','Abbott India');
INSERT INTO Medicine_list VALUES(176,'Lurasidone','Latuda','Antipsychotic',1414,49,'2014-07-30','2019-10-02','Capsules','Sun Pharma');
INSERT INTO Medicine_list VALUES(177,'Terazosin','Hytrin','B.P.H.',931,12,'2015-07-18','2019-01-02','Cream','Alkem Lab');
INSERT INTO Medicine_list VALUES(178,'Sumatriptan','Imitrex','Migraine',125,2,'2017-06-19','2019-05-11','Capsules','Aurobindo Pharm');
INSERT INTO Medicine_list VALUES(179,'Raloxifene','Evista','Osteoporosis',245,46,'2017-06-13','2018-06-05','Cream','Sun Pharma');
INSERT INTO Medicine_list VALUES(180,'Mirtazepine','Remeron','Antidepressant',1132,25,'2015-06-21','2019-11-01','Drops','Torrent Pharma');
INSERT INTO Medicine_list VALUES(181,'Adalimumab','Humira','Anti-inflammatory',632,24,'2016-01-08','2018-12-16','Syrup','Alkem Lab');
INSERT INTO Medicine_list VALUES(182,'Benztropine','Cogentin','Parkinsons',724,1,'2015-09-16','2019-10-22','Drops','Alkem Lab');
INSERT INTO Medicine_list VALUES(183,'Baclofen','Gablofen','Muscle Relaxer',1892,50,'2017-05-09','2018-09-27','Tablets','Divis Labs');
INSERT INTO Medicine_list VALUES(184,'Hydralazine','Apresoline','Hypertension',786,19,'2017-07-16','2019-06-24','Tablets','Lupin');
INSERT INTO Medicine_list VALUES(185,'Mupirocin','Bactroban','Antibacterial',1693,31,'2016-12-25','2019-10-11','Capsules','Abbott India');
INSERT INTO Medicine_list VALUES(186,'Propranolol','Inderal','Hypertension',799,1,'2014-10-02','2018-01-04','Drops','Piramal Enter');
INSERT INTO Medicine_list VALUES(187,'Nystatin','Mycostatin','Candidiasis',1432,8,'2015-02-06','2018-07-02','Tablets','Alembic Pharma');
INSERT INTO Medicine_list VALUES(188,'Verapamil','Verelan','Calc. Chan. Blocker',1555,3,'2015-04-13','2018-11-13','Syrup','Lupin');
INSERT INTO Medicine_list VALUES(189,'Estradiol','Estrace','Menopause',1249,23,'2014-07-17','2018-10-12','Syrup','Lupin');
INSERT INTO Medicine_list VALUES(190,'Phenytoin','Dilantin','Anticonvulsant',840,41,'2014-12-23','2018-10-30','Tablets','Torrent Pharma');
INSERT INTO Medicine_list VALUES(191,'Fenofibrate','Tricor','Cholesterol',1538,21,'2016-11-04','2019-10-18','Capsules','Jubilant Life');
INSERT INTO Medicine_list VALUES(192,'Liraglutide','Victoza','Anti-Diabetic',1837,44,'2016-05-04','2018-02-09','Capsules','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(193,'Ticagrelor','Brilinta','Heart Disease',1353,50,'2017-06-27','2019-03-03','Capsules','Divis Labs');
INSERT INTO Medicine_list VALUES(194,'Diclofenac','Voltaren','NSAID Gel',1603,49,'2014-09-18','2019-08-06','Tablets','Torrent Pharma');
INSERT INTO Medicine_list VALUES(195,'Saxagliptin','Onglyza','Anti-Diabetic',832,34,'2015-11-25','2018-04-10','Capsules','Divis Labs');
INSERT INTO Medicine_list VALUES(196,'Naproxen','Aleve','N.S.A.I.D.',226,36,'2014-07-16','2018-09-05','Capsules','Wockhardt');
INSERT INTO Medicine_list VALUES(197,'Tizanidine','Zanaflex','Muscle Relaxer',557,36,'2014-08-03','2018-05-22','Tablets','Sun Pharma');
INSERT INTO Medicine_list VALUES(198,'Amphetamine /','Adderall','ADHD / Narcolepsy',1566,46,'2016-03-17','2019-02-23','Tablets','Lupin');
INSERT INTO Medicine_list VALUES(199,'Dextro-amphetamine','','',1017,29,'2014-07-20','2019-05-18','Syrup','GlaxoSmithKline');
INSERT INTO Medicine_list VALUES(200,'Amoxicillin +Clavulanate','Augmentin','Bacteria Infection',1864,26,'2014-07-08','2018-04-25','Capsules','Torrent Pharma');
INSERT INTO Medicine_list VALUES(201,'Ezetimibe + Simvastatin','Vytorin','Cholesterol',109,41,'2017-08-15','2019-06-16','Tablets','Lupin');



INSERT INTO Orders VALUES(1,'2017-08-15','NH02',44,14,187,'GlaxoSmithKline','Georgeanna Trisler',150);
INSERT INTO Orders VALUES(1,'2017-08-15','NH02',6,45,538,'Glenmark','Georgeanna Trisler',430);
INSERT INTO Orders VALUES(1,'2017-08-15','NH02',53,96,430,'Abbott India','Georgeanna Trisler',344);
INSERT INTO Orders VALUES(1,'2017-08-15','NH02',12,100,818,'Jubilant Life','Georgeanna Trisler',654);
INSERT INTO Orders VALUES(1,'2017-08-15','NH02',30,79,269,'Alembic Pharma','Georgeanna Trisler',215);
INSERT INTO Orders VALUES(1,'2017-08-15','NH02',120,46,814,'Abbott India','Georgeanna Trisler',651);
INSERT INTO Orders VALUES(2,'2017-08-15','NU08',65,77,519,'Cipla','Earleen Ericksen',415);
INSERT INTO Orders VALUES(2,'2017-08-15','NU08',44,83,187,'GlaxoSmithKline','Earleen Ericksen',150);
INSERT INTO Orders VALUES(2,'2017-08-15','NU08',62,19,237,'Ipca Labs','Earleen Ericksen',190);
INSERT INTO Orders VALUES(2,'2017-08-15','NU08',50,21,592,'Wockhardt','Earleen Ericksen',474);
INSERT INTO Orders VALUES(3,'2017-08-16','CU09',16,42,1927,'Lupin','Ernestine Knepper',1542);
INSERT INTO Orders VALUES(3,'2017-08-16','CU09',33,62,1162,'Sun Pharma','Ernestine Knepper',930);
INSERT INTO Orders VALUES(3,'2017-08-16','CU09',153,98,1538,'Jubilant Life','Ernestine Knepper',1230);
INSERT INTO Orders VALUES(4,'2017-08-17','NU08',8,34,53,'Piramal Enter','Elvira Bartolomeo',42);
INSERT INTO Orders VALUES(4,'2017-08-17','NU08',84,100,562,'Divis Labs','Elvira Bartolomeo',450);
INSERT INTO Orders VALUES(4,'2017-08-17','NU08',42,34,335,'Aurobindo Pharm','Elvira Bartolomeo',268);
INSERT INTO Orders VALUES(4,'2017-08-17','NU08',92,12,231,'Ipca Labs','Elvira Bartolomeo',185);
INSERT INTO Orders VALUES(5,'2017-08-19','UT03',56,78,88,'Sun Pharma','Janee Kwok',70);
INSERT INTO Orders VALUES(5,'2017-08-19','UT03',4,28,658,'Aurobindo Pharm','Janee Kwok',526);
INSERT INTO Orders VALUES(5,'2017-08-19','UT03',87,95,1987,'Dr Reddys Labs','Janee Kwok',1590);
INSERT INTO Orders VALUES(5,'2017-08-19','UT03',50,93,482,'Divis Labs','Janee Kwok',386);
INSERT INTO Orders VALUES(5,'2017-08-19','UT03',121,30,732,'Alembic Pharma','Janee Kwok',586);
INSERT INTO Orders VALUES(5,'2017-08-19','UT03',127,81,805,'Sanofi India','Janee Kwok',644);
INSERT INTO Orders VALUES(5,'2017-08-19','UT03',156,58,832,'Divis Labs','Janee Kwok',666);
INSERT INTO Orders VALUES(5,'2017-08-19','UT03',148,12,1693,'Abbott India','Janee Kwok',1354);
INSERT INTO Orders VALUES(6,'2017-08-19','NH02',102,73,1866,'Aurobindo Pharm','Elvira Bartolomeo',1493);
INSERT INTO Orders VALUES(6,'2017-08-19','NH02',130,75,652,'Alkem Lab','Elvira Bartolomeo',522);
INSERT INTO Orders VALUES(6,'2017-08-19','NH02',60,49,1401,'Abbott India','Elvira Bartolomeo',1121);
INSERT INTO Orders VALUES(6,'2017-08-19','NH02',146,69,1892,'Divis Labs','Elvira Bartolomeo',1514);
INSERT INTO Orders VALUES(6,'2017-08-19','NH02',136,59,572,'Biocon','Elvira Bartolomeo',458);
INSERT INTO Orders VALUES(6,'2017-08-19','NH02',22,22,1291,'Piramal Enter','Elvira Bartolomeo',1033);
INSERT INTO Orders VALUES(7,'2017-08-19','NH02',144,79,1132,'Torrent Pharma','Valentine Burgoon',906);
INSERT INTO Orders VALUES(7,'2017-08-19','NH02',49,41,1071,'Strides Shasun','Valentine Burgoon',857);
INSERT INTO Orders VALUES(8,'2017-08-19','NH02',42,96,335,'Aurobindo Pharm','Tajuana Flippen',268);
INSERT INTO Orders VALUES(8,'2017-08-19','NH02',86,89,1585,'Alembic Pharma','Tajuana Flippen',1268);
INSERT INTO Orders VALUES(9,'2017-08-22','MR01',132,26,1165,'Divis Labs','Janee Kwok',932);
INSERT INTO Orders VALUES(9,'2017-08-22','MR01',130,49,1867,'Piramal Enter','Janee Kwok',1494);
INSERT INTO Orders VALUES(10,'2017-08-22','MG10',14,50,76,'Divis Labs','Raguel Miceli',61);
INSERT INTO Orders VALUES(10,'2017-08-22','MG10',60,71,1401,'Abbott India','Raguel Miceli',1121);
INSERT INTO Orders VALUES(10,'2017-08-22','MG10',76,85,154,'Alembic Pharma','Raguel Miceli',123);
INSERT INTO Orders VALUES(10,'2017-08-22','MG10',78,23,560,'Sun Pharma','Raguel Miceli',448);
INSERT INTO Orders VALUES(11,'2017-08-22','NH02',127,66,805,'Sanofi India','Georgeanna Trisler',644);
INSERT INTO Orders VALUES(11,'2017-08-22','NH02',100,35,1798,'Cipla','Georgeanna Trisler',1438);
INSERT INTO Orders VALUES(11,'2017-08-22','NH02',16,13,1927,'Lupin','Georgeanna Trisler',1542);
INSERT INTO Orders VALUES(11,'2017-08-22','NH02',70,52,576,'Sanofi India','Georgeanna Trisler',461);
INSERT INTO Orders VALUES(12,'2017-08-23','TM05',9,30,277,'Cipla','Elvira Bartolomeo',222);
INSERT INTO Orders VALUES(12,'2017-08-23','TM05',82,15,382,'Sun Pharma','Elvira Bartolomeo',306);
INSERT INTO Orders VALUES(12,'2017-08-23','TM05',97,35,1624,'Wockhardt','Elvira Bartolomeo',1299);
INSERT INTO Orders VALUES(12,'2017-08-23','TM05',103,100,1934,'Biocon','Elvira Bartolomeo',1547);
INSERT INTO Orders VALUES(13,'2017-08-23','UT03',129,86,1412,'Jubilant Life','Janee Kwok',1130);
INSERT INTO Orders VALUES(13,'2017-08-23','UT03',51,54,714,'Cadila Health','Janee Kwok',571);
INSERT INTO Orders VALUES(13,'2017-08-23','UT03',100,23,1798,'Cipla','Janee Kwok',1438);
INSERT INTO Orders VALUES(14,'2017-08-24','TM05',47,26,1350,'Abbott India','Elvira Bartolomeo',1080);
INSERT INTO Orders VALUES(14,'2017-08-24','TM05',110,52,517,'GlaxoSmithKline','Elvira Bartolomeo',414);
INSERT INTO Orders VALUES(14,'2017-08-24','TM05',100,43,1798,'Cipla','Elvira Bartolomeo',1438);
INSERT INTO Orders VALUES(15,'2017-08-24','UT03',103,19,1934,'Biocon','Valentine Burgoon',1547);
INSERT INTO Orders VALUES(15,'2017-08-24','UT03',152,69,840,'Torrent Pharma','Valentine Burgoon',672);
INSERT INTO Orders VALUES(15,'2017-08-24','UT03',113,51,1751,'Divis Labs','Valentine Burgoon',1401);
INSERT INTO Orders VALUES(15,'2017-08-24','UT03',101,17,282,'Alkem Lab','Valentine Burgoon',226);
INSERT INTO Orders VALUES(16,'2017-08-24','MG10',3,50,1077,'Wockhardt','Rey Windle',862);
INSERT INTO Orders VALUES(16,'2017-08-24','MG10',156,77,832,'Divis Labs','Rey Windle',666);
INSERT INTO Orders VALUES(16,'2017-08-24','MG10',33,95,1162,'Sun Pharma','Rey Windle',930);
INSERT INTO Orders VALUES(16,'2017-08-24','MG10',82,95,141,'Divis Labs','Rey Windle',113);
INSERT INTO Orders VALUES(17,'2017-08-26','UT03',17,89,488,'Abbott India','Jestine Mongiello',390);
INSERT INTO Orders VALUES(17,'2017-08-26','UT03',135,25,452,'Alkem Lab','Jestine Mongiello',362);
INSERT INTO Orders VALUES(17,'2017-08-26','UT03',100,39,1798,'Cipla','Jestine Mongiello',1438);
INSERT INTO Orders VALUES(18,'2017-08-26','CU09',89,14,1539,'Aurobindo Pharm','Valentine Burgoon',1231);
INSERT INTO Orders VALUES(18,'2017-08-26','CU09',47,90,1350,'Abbott India','Valentine Burgoon',1080);
INSERT INTO Orders VALUES(18,'2017-08-26','CU09',142,91,125,'Aurobindo Pharm','Valentine Burgoon',100);
INSERT INTO Orders VALUES(19,'2017-08-26','FM07',83,93,789,'Wockhardt','Raguel Miceli',631);
INSERT INTO Orders VALUES(19,'2017-08-26','FM07',90,30,1931,'Cadila Health','Raguel Miceli',1545);
INSERT INTO Orders VALUES(19,'2017-08-26','FM07',94,68,1827,'Alembic Pharma','Raguel Miceli',1462);
INSERT INTO Orders VALUES(19,'2017-08-26','FM07',26,88,80,'Torrent Pharma','Raguel Miceli',64);
INSERT INTO Orders VALUES(20,'2017-08-26','UT03',78,68,1590,'Piramal Enter','Elvira Bartolomeo',1272);
INSERT INTO Orders VALUES(20,'2017-08-26','UT03',3,66,1077,'Wockhardt','Elvira Bartolomeo',862);
INSERT INTO Orders VALUES(20,'2017-08-26','UT03',102,46,1477,'Biocon','Elvira Bartolomeo',1182);
INSERT INTO Orders VALUES(20,'2017-08-26','UT03',18,50,1507,'Alkem Lab','Elvira Bartolomeo',1206);
INSERT INTO Orders VALUES(21,'2017-08-28','MR01',3,19,1077,'Wockhardt','Janee Kwok',862);
INSERT INTO Orders VALUES(21,'2017-08-28','MR01',39,85,139,'Glenmark','Janee Kwok',111);
INSERT INTO Orders VALUES(21,'2017-08-28','MR01',135,59,452,'Alkem Lab','Janee Kwok',362);
INSERT INTO Orders VALUES(21,'2017-08-28','MR01',86,11,181,'Dr Reddys Labs','Janee Kwok',145);
INSERT INTO Orders VALUES(21,'2017-08-28','MR01',7,31,152,'Biocon','Janee Kwok',122);
INSERT INTO Orders VALUES(21,'2017-08-28','MR01',62,49,571,'Biocon','Janee Kwok',457);
INSERT INTO Orders VALUES(22,'2017-08-29','CU09',5,34,780,'Glenmark','Georgeanna Trisler',624);
INSERT INTO Orders VALUES(22,'2017-08-29','CU09',74,31,1627,'Strides Shasun','Georgeanna Trisler',1302);
INSERT INTO Orders VALUES(22,'2017-08-29','CU09',152,53,840,'Torrent Pharma','Georgeanna Trisler',672);
INSERT INTO Orders VALUES(22,'2017-08-29','CU09',70,28,1545,'Biocon','Georgeanna Trisler',1236);
INSERT INTO Orders VALUES(23,'2017-08-29','NH02',37,91,419,'Lupin','Ernestine Knepper',335);
INSERT INTO Orders VALUES(23,'2017-08-29','NH02',101,37,282,'Alkem Lab','Ernestine Knepper',226);
INSERT INTO Orders VALUES(23,'2017-08-29','NH02',125,52,1359,'Sanofi India','Ernestine Knepper',1087);
INSERT INTO Orders VALUES(23,'2017-08-29','NH02',126,19,1911,'Strides Shasun','Ernestine Knepper',1529);
INSERT INTO Orders VALUES(24,'2017-08-30','PG06',49,34,1071,'Strides Shasun','Rey Windle',857);
INSERT INTO Orders VALUES(24,'2017-08-30','PG06',6,70,538,'Glenmark','Rey Windle',430);
INSERT INTO Orders VALUES(24,'2017-08-30','PG06',21,31,1533,'Piramal Enter','Rey Windle',1226);
INSERT INTO Orders VALUES(24,'2017-08-30','PG06',14,62,76,'Divis Labs','Rey Windle',61);
INSERT INTO Orders VALUES(25,'2017-08-31','CU09',110,50,603,'Torrent Pharma','Chaya Strack',482);
INSERT INTO Orders VALUES(25,'2017-08-31','CU09',61,11,1679,'Jubilant Life','Chaya Strack',1343);
INSERT INTO Orders VALUES(25,'2017-08-31','CU09',42,10,335,'Aurobindo Pharm','Chaya Strack',268);
INSERT INTO Orders VALUES(25,'2017-08-31','CU09',35,74,1372,'Aurobindo Pharm','Chaya Strack',1098);
INSERT INTO Orders VALUES(25,'2017-08-31','CU09',5,51,780,'Glenmark','Chaya Strack',624);



INSERT INTO Bill VALUES(1,'2017-08-15','JP12','Jackqueline Popp  ',29,5,1952,'Dr.Coralie Redwood',1757);
INSERT INTO Bill VALUES(1,'2017-08-15','JP12','Jackqueline Popp  ',146,1,1514,'Dr.Coralie Redwood',1363);
INSERT INTO Bill VALUES(1,'2017-08-15','JP12','Jackqueline Popp  ',189,1,1249,'Dr.Coralie Redwood',1124);
INSERT INTO Bill VALUES(1,'2017-08-15','JP12','Jackqueline Popp  ',43,3,840,'Dr.Coralie Redwood',756);
INSERT INTO Bill VALUES(1,'2017-08-15','JP12','Jackqueline Popp  ',71,1,1734,'Dr.Coralie Redwood',1561);
INSERT INTO Bill VALUES(1,'2017-08-15','JP12','Jackqueline Popp  ',157,5,1100,'Dr.Coralie Redwood',990);
INSERT INTO Bill VALUES(2,'2017-08-15','MS33','Micki Subia  ',170,5,572,'Dr.Traci Seddon',515);
INSERT INTO Bill VALUES(2,'2017-08-15','MS33','Micki Subia  ',83,3,24,'Dr.Traci Seddon',22);
INSERT INTO Bill VALUES(2,'2017-08-15','MS33','Micki Subia  ',132,2,1892,'Dr.Traci Seddon',1703);
INSERT INTO Bill VALUES(2,'2017-08-15','MS33','Micki Subia  ',167,1,1654,'Dr.Traci Seddon',1489);
INSERT INTO Bill VALUES(3,'2017-08-16','BC26','Betsy Colson  ',151,5,732,'Dr.Casimira Woodrow',659);
INSERT INTO Bill VALUES(3,'2017-08-16','BC26','Betsy Colson  ',157,2,1100,'Dr.Casimira Woodrow',990);
INSERT INTO Bill VALUES(3,'2017-08-16','BC26','Betsy Colson  ',174,2,425,'Dr.Casimira Woodrow',383);
INSERT INTO Bill VALUES(4,'2017-08-17','MB20','Maryjane Beedle  ',14,2,292,'Dr.Madonna Malcolm',263);
INSERT INTO Bill VALUES(4,'2017-08-17','MB20','Maryjane Beedle  ',90,1,719,'Dr.Madonna Malcolm',647);
INSERT INTO Bill VALUES(4,'2017-08-17','MB20','Maryjane Beedle  ',146,1,1514,'Dr.Madonna Malcolm',1363);
INSERT INTO Bill VALUES(4,'2017-08-17','MB20','Maryjane Beedle  ',164,3,1663,'Dr.Madonna Malcolm',1497);
INSERT INTO Bill VALUES(5,'2017-08-19','DN5','Dannie Nye  ',171,3,1802,'Dr.Naida Sarabia',1622);
INSERT INTO Bill VALUES(5,'2017-08-19','DN5','Dannie Nye  ',177,3,931,'Dr.Naida Sarabia',838);
INSERT INTO Bill VALUES(5,'2017-08-19','DN5','Dannie Nye  ',54,2,1341,'Dr.Naida Sarabia',1207);
INSERT INTO Bill VALUES(5,'2017-08-19','DN5','Dannie Nye  ',170,1,572,'Dr.Naida Sarabia',515);
INSERT INTO Bill VALUES(5,'2017-08-19','DN5','Dannie Nye  ',73,4,1684,'Dr.Naida Sarabia',1516);
INSERT INTO Bill VALUES(5,'2017-08-19','DN5','Dannie Nye  ',88,3,576,'Dr.Naida Sarabia',518);
INSERT INTO Bill VALUES(5,'2017-08-19','DN5','Dannie Nye  ',79,2,1969,'Dr.Naida Sarabia',1772);
INSERT INTO Bill VALUES(5,'2017-08-19','DN5','Dannie Nye  ',198,1,1566,'Dr.Naida Sarabia',1409);
INSERT INTO Bill VALUES(6,'2017-08-19','BC26','Betsy Colson  ',117,1,1827,'Dr.Adria Crail',1644);
INSERT INTO Bill VALUES(6,'2017-08-19','BC26','Betsy Colson  ',158,2,1911,'Dr.Adria Crail',1720);
INSERT INTO Bill VALUES(6,'2017-08-19','BC26','Betsy Colson  ',188,4,1555,'Dr.Adria Crail',1400);
INSERT INTO Bill VALUES(6,'2017-08-19','BC26','Betsy Colson  ',108,4,181,'Dr.Adria Crail',163);
INSERT INTO Bill VALUES(6,'2017-08-19','BC26','Betsy Colson  ',200,3,1864,'Dr.Adria Crail',1678);
INSERT INTO Bill VALUES(6,'2017-08-19','BC26','Betsy Colson  ',157,3,1100,'Dr.Adria Crail',990);
INSERT INTO Bill VALUES(7,'2017-08-19','FM25','Faith Miyashiro  ',57,4,1465,'Dr.Valrie Tague',1319);
INSERT INTO Bill VALUES(7,'2017-08-19','FM25','Faith Miyashiro  ',133,5,269,'Dr.Valrie Tague',242);
INSERT INTO Bill VALUES(8,'2017-08-19','JB2','Josefine Barriere  ',2,1,406,'Dr.Valrie Tague',365);
INSERT INTO Bill VALUES(8,'2017-08-19','JB2','Josefine Barriere  ',35,4,204,'Dr.Valrie Tague',184);
INSERT INTO Bill VALUES(9,'2017-08-22','MB20','Maryjane Beedle  ',77,3,237,'Dr.Na Bennett',213);
INSERT INTO Bill VALUES(9,'2017-08-22','MB20','Maryjane Beedle  ',186,3,799,'Dr.Na Bennett',719);
INSERT INTO Bill VALUES(10,'2017-08-22','MM8','Marion Marc  ',33,5,1411,'Dr.Gabriel Greathouse',1270);
INSERT INTO Bill VALUES(10,'2017-08-22','MM8','Marion Marc  ',119,2,551,'Dr.Gabriel Greathouse',496);
INSERT INTO Bill VALUES(10,'2017-08-22','MM8','Marion Marc  ',172,4,1023,'Dr.Gabriel Greathouse',921);
INSERT INTO Bill VALUES(10,'2017-08-22','MM8','Marion Marc  ',183,2,1892,'Dr.Gabriel Greathouse',1703);
INSERT INTO Bill VALUES(11,'2017-08-22','ZM16','Zelma Murguia  ',193,3,1353,'Dr.Na Bennett',1218);
INSERT INTO Bill VALUES(11,'2017-08-22','ZM16','Zelma Murguia  ',32,1,80,'Dr.Na Bennett',72);
INSERT INTO Bill VALUES(11,'2017-08-22','ZM16','Zelma Murguia  ',86,1,1674,'Dr.Na Bennett',1507);
INSERT INTO Bill VALUES(11,'2017-08-22','ZM16','Zelma Murguia  ',28,4,1291,'Dr.Na Bennett',1162);
INSERT INTO Bill VALUES(12,'2017-08-23','ID34','Iluminada Dull  ',148,2,1562,'Dr.Lissa Shawl',1406);
INSERT INTO Bill VALUES(12,'2017-08-23','ID34','Iluminada Dull  ',93,3,1627,'Dr.Lissa Shawl',1464);
INSERT INTO Bill VALUES(12,'2017-08-23','ID34','Iluminada Dull  ',64,4,714,'Dr.Lissa Shawl',643);
INSERT INTO Bill VALUES(12,'2017-08-23','ID34','Iluminada Dull  ',96,2,955,'Dr.Lissa Shawl',860);
INSERT INTO Bill VALUES(13,'2017-08-23','TT24','Terrence Tamayo  ',118,1,109,'Dr.Adria Crail',98);
INSERT INTO Bill VALUES(13,'2017-08-23','TT24','Terrence Tamayo  ',11,2,277,'Dr.Adria Crail',249);
INSERT INTO Bill VALUES(13,'2017-08-23','TT24','Terrence Tamayo  ',29,5,1952,'Dr.Adria Crail',1757);
INSERT INTO Bill VALUES(14,'2017-08-24','EW29','Emanuel Weitz  ',16,5,487,'Dr.Neda Wilbur',438);
INSERT INTO Bill VALUES(14,'2017-08-24','EW29','Emanuel Weitz  ',175,4,1001,'Dr.Neda Wilbur',901);
INSERT INTO Bill VALUES(14,'2017-08-24','EW29','Emanuel Weitz  ',58,4,892,'Dr.Neda Wilbur',803);
INSERT INTO Bill VALUES(15,'2017-08-24','LS38','Ludivina Spilman  ',22,1,1507,'Dr.Kerry Gaudin',1356);
INSERT INTO Bill VALUES(15,'2017-08-24','LS38','Ludivina Spilman  ',199,4,1017,'Dr.Kerry Gaudin',915);
INSERT INTO Bill VALUES(15,'2017-08-24','LS38','Ludivina Spilman  ',154,5,824,'Dr.Kerry Gaudin',742);
INSERT INTO Bill VALUES(15,'2017-08-24','LS38','Ludivina Spilman  ',65,5,340,'Dr.Kerry Gaudin',306);
INSERT INTO Bill VALUES(16,'2017-08-24','RQ13','Rosenda Quinney  ',141,1,1751,'Dr.Theodore Ricken',1576);
INSERT INTO Bill VALUES(16,'2017-08-24','RQ13','Rosenda Quinney  ',175,5,1001,'Dr.Theodore Ricken',901);
INSERT INTO Bill VALUES(16,'2017-08-24','RQ13','Rosenda Quinney  ',185,5,1693,'Dr.Theodore Ricken',1524);
INSERT INTO Bill VALUES(16,'2017-08-24','RQ13','Rosenda Quinney  ',93,4,1627,'Dr.Theodore Ricken',1464);
INSERT INTO Bill VALUES(17,'2017-08-26','CR9','Cathy Rivet  ',185,2,1693,'Dr.Casimira Woodrow',1524);
INSERT INTO Bill VALUES(17,'2017-08-26','CR9','Cathy Rivet  ',58,2,892,'Dr.Casimira Woodrow',803);
INSERT INTO Bill VALUES(17,'2017-08-26','CR9','Cathy Rivet  ',39,1,1307,'Dr.Casimira Woodrow',1176);
INSERT INTO Bill VALUES(18,'2017-08-26','JP12','Jackqueline Popp  ',88,1,576,'Dr.Annett Hymes',518);
INSERT INTO Bill VALUES(18,'2017-08-26','JP12','Jackqueline Popp  ',78,2,571,'Dr.Annett Hymes',514);
INSERT INTO Bill VALUES(18,'2017-08-26','JP12','Jackqueline Popp  ',175,3,1001,'Dr.Annett Hymes',901);
INSERT INTO Bill VALUES(19,'2017-08-26','ZM16','Zelma Murguia  ',3,3,1697,'Dr.Adria Crail',1527);
INSERT INTO Bill VALUES(19,'2017-08-26','ZM16','Zelma Murguia  ',93,2,1627,'Dr.Adria Crail',1464);
INSERT INTO Bill VALUES(19,'2017-08-26','ZM16','Zelma Murguia  ',183,4,1892,'Dr.Adria Crail',1703);
INSERT INTO Bill VALUES(19,'2017-08-26','ZM16','Zelma Murguia  ',131,1,1523,'Dr.Adria Crail',1371);
INSERT INTO Bill VALUES(20,'2017-08-26','MB36','Margareta Burrell  ',65,2,340,'Dr.Naida Sarabia',306);
INSERT INTO Bill VALUES(20,'2017-08-26','MB36','Margareta Burrell  ',80,5,619,'Dr.Naida Sarabia',557);
INSERT INTO Bill VALUES(20,'2017-08-26','MB36','Margareta Burrell  ',116,5,569,'Dr.Naida Sarabia',512);
INSERT INTO Bill VALUES(20,'2017-08-26','MB36','Margareta Burrell  ',19,3,1297,'Dr.Naida Sarabia',1167);
INSERT INTO Bill VALUES(21,'2017-08-28','MM8','Marion Marc  ',134,2,765,'Dr.Herbert Humphrey',689);
INSERT INTO Bill VALUES(21,'2017-08-28','MM8','Marion Marc  ',136,4,1007,'Dr.Herbert Humphrey',906);
INSERT INTO Bill VALUES(21,'2017-08-28','MM8','Marion Marc  ',23,5,1887,'Dr.Herbert Humphrey',1698);
INSERT INTO Bill VALUES(21,'2017-08-28','MM8','Marion Marc  ',200,4,1864,'Dr.Herbert Humphrey',1678);
INSERT INTO Bill VALUES(21,'2017-08-28','MM8','Marion Marc  ',75,1,1401,'Dr.Herbert Humphrey',1261);
INSERT INTO Bill VALUES(21,'2017-08-28','MM8','Marion Marc  ',68,2,351,'Dr.Herbert Humphrey',316);
INSERT INTO Bill VALUES(22,'2017-08-29','EW29','Emanuel Weitz  ',135,1,1654,'Dr.Herbert Humphrey',1489);
INSERT INTO Bill VALUES(22,'2017-08-29','EW29','Emanuel Weitz  ',17,2,76,'Dr.Herbert Humphrey',68);
INSERT INTO Bill VALUES(22,'2017-08-29','EW29','Emanuel Weitz  ',84,4,1871,'Dr.Herbert Humphrey',1684);
INSERT INTO Bill VALUES(22,'2017-08-29','EW29','Emanuel Weitz  ',155,2,1919,'Dr.Herbert Humphrey',1727);
INSERT INTO Bill VALUES(23,'2017-08-29','ID34','Iluminada Dull  ',116,2,569,'Dr.Herbert Humphrey',512);
INSERT INTO Bill VALUES(23,'2017-08-29','ID34','Iluminada Dull  ',127,4,1477,'Dr.Herbert Humphrey',1329);
INSERT INTO Bill VALUES(23,'2017-08-29','ID34','Iluminada Dull  ',72,2,1051,'Dr.Herbert Humphrey',946);
INSERT INTO Bill VALUES(23,'2017-08-29','ID34','Iluminada Dull  ',198,2,1566,'Dr.Herbert Humphrey',1409);
INSERT INTO Bill VALUES(24,'2017-08-30','MB20','Maryjane Beedle  ',175,3,1001,'Dr.Layla Moench',901);
INSERT INTO Bill VALUES(24,'2017-08-30','MB20','Maryjane Beedle  ',24,3,896,'Dr.Layla Moench',806);
INSERT INTO Bill VALUES(24,'2017-08-30','MB20','Maryjane Beedle  ',75,1,1401,'Dr.Layla Moench',1261);
INSERT INTO Bill VALUES(24,'2017-08-30','MB20','Maryjane Beedle  ',177,4,931,'Dr.Layla Moench',838);
INSERT INTO Bill VALUES(25,'2017-08-31','DT19','Carli Saleh  ',65,1,340,'Dr.Kerry Gaudin',306);
INSERT INTO Bill VALUES(25,'2017-08-31','DT19','Carli Saleh  ',45,2,320,'Dr.Kerry Gaudin',288);
INSERT INTO Bill VALUES(25,'2017-08-31','DT19','Carli Saleh  ',193,5,1353,'Dr.Kerry Gaudin',1218);
INSERT INTO Bill VALUES(25,'2017-08-31','DT19','Carli Saleh  ',116,2,569,'Dr.Kerry Gaudin',512);
INSERT INTO Bill VALUES(25,'2017-08-31','DT19','Carli Saleh  ',193,3,1353,'Dr.Kerry Gaudin',1218);


 delimiter |
CREATE TRIGGER apply_billing_insert_changes AFTER INSERT ON BILL
FOR EACH ROW
   BEGIN
		UPDATE medicine_list 
		SET Quantity = Quantity - NEW.Quantity
		WHERE Product_id = NEW.Product_id;
   END;
 |

 delimiter ;
 
 
 delimiter |
CREATE TRIGGER apply_billing_delete_changes AFTER DELETE ON BILL
FOR EACH ROW
   BEGIN
		UPDATE medicine_list 
		SET Quantity = Quantity + OLD.Quantity
		WHERE Product_id = OLD.Product_id;
   END;
 |

 delimiter ;
 

 
 delimiter |
CREATE TRIGGER apply_order_insert_changes AFTER INSERT ON Orders
FOR EACH ROW
   BEGIN
		UPDATE medicine_list 
		SET Quantity = Quantity + NEW.Quantity
		WHERE Product_id = NEW.Product_id;
   END;
 |

 delimiter ;
 
 
delimiter |
CREATE TRIGGER apply_order_delete_changes AFTER DELETE ON Orders
FOR EACH ROW
   BEGIN
		UPDATE medicine_list 
		SET Quantity = Quantity - OLD.Quantity
		WHERE Product_id = OLD.Product_id;
   END;
 |

 delimiter ;
 