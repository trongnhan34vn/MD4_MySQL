USE classicmodels;
-- tham số loại IN
DELIMITER //
CREATE PROCEDURE getCusById
(IN cusNum INT(11))

BEGIN 
SELECT * FROM customers WHERE customerNumber = cusNum;
END //
DELIMITER ;

call getCusById(175)

-- tham số loại OUT 
DELIMITER //
CREATE PROCEDURE getCustomersCountByCity(
	IN in_city VARCHAR(50),
    OUT total INT
)

BEGIN
	SELECT COUNT(customerNumber)
    INTO total
    FROM customers
    WHERE city = in_city;
END //
DELIMITER ;

-- GỌI PROCEDURE
CALL getCustomersCountByCity("Lyon", @total);

SELECT @total;

-- tham số loại IN/OUT

DELIMITER //
CREATE PROCEDURE setCounter(
	INOUT counter INT,
    IN inc INT
)
BEGIN 
	SET counter = counter + inc;
END //
DELIMITER ;
-- gọi store Procedure

SET @counter = 1;
call setCounter(@counter, 1);
call setCounter(@counter, 1);
call setCounter(@counter, 5);
SELECT @counter;



	