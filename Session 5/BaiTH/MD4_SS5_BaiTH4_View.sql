USE classicmodels;

CREATE VIEW customers_views AS
SELECT customerNumber, customerName, phone
FROM customers;

select * from customers_views;

CREATE OR REPLACE VIEW customers_views AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = "Nantes";

-- xoá view: DROP ...
DROP VIEW customers_views;