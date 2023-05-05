use classicmodels;

DELIMITER // 
CREATE PROCEDURE findAllCustomer()
BEGIN 
	SELECT * FROM customers;
END //
DELIMITER ;

-- gọi procedure 
call findAllCustomer();

DELIMITER //
-- xoá procedure tạo lại 
DROP PROCEDURE IF EXISTS `findAllCustomer` //
CREATE PROCEDURE findAllCustomer()
BEGIN 
SELECT * FROM customers WHERE customerNumber = 175;
END //

DELIMITER ; 