-- Homework #5
-- Part 1
-- Group By  Example by Animation: https://dataschool.com/how-to-teach-people-sql/how-sql-aggregations-work/
-- Classicmodels Database 
--  1.use union: show products with buyPrice > 100 and <200
--  2.use subquery: show all customer names with employees in San Francisco office
--  3.use subquery: based on previous query add count(*) to show total of employees in San Francisco office 

-- Part 2
-- Classicmodels Database - Keep working on these queries
-- write sql for #1,2,3,4,5,7
-- 1.how many vendors, product lines, and products exist in the database?
-- 2.what is the average price (buy price, MSRP) per vendor?
-- 3.what is the average price (buy price, MSRP) per customer?
-- 4.what product was sold the most?
-- 5.how much money was made between buyPrice and MSRP?
-- 7.which vendor sells more products?

-- Part 3
-- Library Simple db - Finish 
-- 1.Join all tables and find all release dates for book 'Dog With Money'

-- Part 1
-- 1
SELECT productName, buyPrice FROM classicmodels.products
WHERE buyPrice > 100
UNION
SELECT productName, buyPrice FROM classicmodels.products
WHERE buyPrice < 200;
-- 2
WITH employees_office AS (SELECT e.employeeNumber, e.officeCode, o.city FROM classicmodels.employees e 
																JOIN classicmodels.offices o ON e.officeCode = o.officeCode
                                                                WHERE o.city LIKE "San Francisco")
SELECT customerName FROM classicmodels.customers
WHERE salesRepEmployeeNumber IN (SELECT employeeNumber FROM employees_office);
-- 3
WITH employees_office AS (SELECT e.employeeNumber, e.officeCode, o.city FROM classicmodels.employees e 
																JOIN classicmodels.offices o ON e.officeCode = o.officeCode
                                                                WHERE o.city LIKE "San Francisco")
SELECT COUNT(*) FROM classicmodels.employees
WHERE employeeNumber IN (SELECT employeeNumber FROM employees_office);

-- Part 2
-- 1.
SELECT DISTINCT productVendor FROM classicmodels.products; -- 13
SELECT DISTINCT productLine FROM classicmodels.products; -- 7
SELECT count(*) FROM classicmodels.products; -- 110
-- 2.
SELECT productVendor, AVG(buyPrice) as averageBuyPrice,  AVG(MSRP) as averageMSRP FROM classicmodels.products
GROUP by productVendor;
-- 3.
SELECT customerName, AVG(buyPrice) as averageBuyPrice,  AVG(MSRP) as averageMSRP FROM classicmodels.customers c
JOIN classicmodels.orders o ON c.customerNumber = o.customerNumber 
JOIN classicmodels.orderdetails orde ON o.orderNumber = orde.orderNumber
JOIN classicmodels.products p ON orde.productCode = p.productCode
GROUP by customerName;
-- 4.
WITH ProductCounts AS (
    SELECT p.productName, COUNT(o.orderNumber) AS count
    FROM classicmodels.orderdetails ord
    JOIN classicmodels.products p ON ord.productCode = p.productCode
    JOIN classicmodels.orders o ON ord.orderNumber = o.orderNumber
    GROUP BY p.productName)
SELECT productName, count
FROM ProductCounts
WHERE count = (SELECT MAX(count) FROM ProductCounts); -- # productName, count 1992 Ferrari 360 Spider red, 53
-- 5.
SELECT productName, (MSRP - buyPrice) AS profit FROM classicmodels.products;
-- 7.
WITH ProductCounts AS (
    SELECT p.productVendor, COUNT(o.orderNumber) AS count
    FROM classicmodels.orderdetails ord
    JOIN classicmodels.products p ON ord.productCode = p.productCode
    JOIN classicmodels.orders o ON ord.orderNumber = o.orderNumber
    GROUP BY p.productVendor)
SELECT productVendor, count
FROM ProductCounts
WHERE count = (SELECT MAX(count) FROM ProductCounts); -- 'Classic Metal Creations', '270'

-- Part 3
SELECT b.id, b.ISBN, b.`name`, b.page_num, b.pub_year, a.first_name, a.last_name, c.`name`, copy.`number`, copy.admission_date, i.issue_date, i.release_date, i.deadline_date, r.first_name, r.last_name, r.reader_num  FROM library_simple.book b
LEFT JOIN library_simple.author_has_book ahb ON b.id = ahb.book_id
LEFT JOIN library_simple.author a ON ahb.author_id = a.id
LEFT JOIN library_simple.category_has_book chb ON b.id = chb.book_id
LEFT JOIN library_simple.category c ON chb.category_id = c.id
LEFT JOIN library_simple.copy copy ON b.id = copy.book_id
LEFT JOIN library_simple.issuance i ON copy.id = i.copy_id
LEFT JOIN library_simple.reader r ON i.reader_id = r.id
WHERE b.name LIKE "Dog With Money";
