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


