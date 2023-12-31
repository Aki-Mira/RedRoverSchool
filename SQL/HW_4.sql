-- Homework for Lesson #4 
-- Part #1 classicmodels database 
-- (write sql for #6, 8, 9, 10, 11, 14, 16, 17, 21) -- easy questions

-- 1.how many vendors, product lines, and products exist in the database?
-- 2.what is the average price (buy price, MSRP) per vendor?
-- 3.what is the average price (buy price, MSRP) per customer?
-- 4.what product was sold the most?
-- 5.how much money was made between buyPrice and MSRP?
-- 6.which vendor sells 1966 Shelby Cobra?
-- 7.which vendor sells more products?
-- 8.which product is the most and least expensive?
-- 9.which product has the most quantityInStock?
-- 10.list all products that have quantity in stock less than 20
-- 11.which customer has the highest and lowest credit limit?
-- 12.rank customers by credit limit
-- 13.list the most sold product by city
-- 14.customers in what city are the most profitable to the company?
-- 15.what is the average number of orders per customer?
-- 16.who is the best customer?
-- 17.customers without payment
-- 18.what is the average number of days between the order date and ship date?
-- 19.sales by year
-- 20.how many orders are not shipped?
-- 21.list all employees by their (full name: first + last) in alpabetical order
-- 22.list of employees  by how much they sold in 2003?
-- 23.which city has the most number of employees?
-- 24.which office has the biggest sales?

-- Part #2  -- library_simple database
-- 1.find all information (query each table seporately for book_id = 252)
-- 2.which books did Van Parks write?
-- 3.which books where published in 2003?

-- SOLUTION:
-- Part 1
-- 1.
-- SELECT DISTINCT productVendor FROM classicmodels.products; -- 13
-- SELECT DISTINCT productLine FROM classicmodels.products; -- 7
-- SELECT count(*) FROM classicmodels.products; -- 110
-- 2.
-- SELECT productVendor, AVG(buyPrice) as averageBuyPrice,  AVG(MSRP) as averageMSRP FROM classicmodels.products
-- GROUP by productVendor;
-- 3.
-- SELECT customerName, AVG(buyPrice) as averageBuyPrice,  AVG(MSRP) as averageMSRP FROM classicmodels.customers c
-- JOIN classicmodels.orders o ON c.customerNumber = o.customerNumber 
-- JOIN classicmodels.orderdetails orde ON o.orderNumber = orde.orderNumber
-- JOIN classicmodels.products p ON orde.productCode = p.productCode
-- GROUP by customerName;
-- 4.
-- WITH ProductCounts AS (
--     SELECT p.productName, COUNT(o.orderNumber) AS count
--     FROM classicmodels.orderdetails ord
--     JOIN classicmodels.products p ON ord.productCode = p.productCode
--     JOIN classicmodels.orders o ON ord.orderNumber = o.orderNumber
--     GROUP BY p.productName)
-- SELECT productName, count
-- FROM ProductCounts
-- WHERE count = (SELECT MAX(count) FROM ProductCounts); -- # productName, count 1992 Ferrari 360 Spider red, 53
-- 5.
-- SELECT productName, (MSRP - buyPrice) AS profit FROM classicmodels.products;
-- 6.
-- SELECT productVendor, productName FROM classicmodels.products
-- WHERE productName like ('%1966 Shelby Cobra%'); -- 'Carousel DieCast Legends', '1966 Shelby Cobra 427 S/C'
-- 7.
-- WITH ProductCounts AS (
--     SELECT p.productVendor, COUNT(o.orderNumber) AS count
--     FROM classicmodels.orderdetails ord
--     JOIN classicmodels.products p ON ord.productCode = p.productCode
--     JOIN classicmodels.orders o ON ord.orderNumber = o.orderNumber
--     GROUP BY p.productVendor)
-- SELECT productVendor, count
-- FROM ProductCounts
-- WHERE count = (SELECT MAX(count) FROM ProductCounts); -- 'Classic Metal Creations', '270'
-- 8.
-- SELECT productName AS most_expensive_product, MSRP FROM classicmodels.products
-- WHERE MSRP = (SELECT MAX(MSRP) FROM classicmodels.products);

-- SELECT productName AS least_expensive_product, MSRP FROM classicmodels.products
-- WHERE MSRP = (SELECT MIN(MSRP) FROM classicmodels.products);
-- 9.
-- SELECT productName, quantityInStock FROM classicmodels.products
-- WHERE quantityInStock = ( SELECT MAX(quantityInStock) FROM classicmodels.products);
-- 10.
-- SELECT productName, quantityInStock FROM classicmodels.products
-- WHERE quantityInStock < 20;
-- 11.
-- SELECT customerName, creditLimit FROM classicmodels.customers
-- WHERE creditLimit = (SELECT MAX(creditLimit) FROM classicmodels.customers);

-- SELECT customerName, creditLimit FROM classicmodels.customers
-- WHERE creditLimit = (SELECT MIN(creditLimit) FROM classicmodels.customers);
-- 12.
-- SELECT customerName, creditLimit FROM classicmodels.customers
-- ORDER BY creditLimit DESC;
-- 13.
-- WITH CityProductRank AS (
--     SELECT
--         c.city,
--         p.productName,
--         SUM(od.quantityOrdered) AS totalQuantity,
--         ROW_NUMBER() OVER (PARTITION BY c.city ORDER BY SUM(od.quantityOrdered) DESC) AS ranking
--     FROM
--         classicmodels.customers c
--     JOIN
--         classicmodels.orders o ON c.customerNumber = o.customerNumber
--     JOIN
--         classicmodels.orderdetails od ON o.orderNumber = od.orderNumber
--     JOIN
--         classicmodels.products p ON od.productCode = p.productCode
--     GROUP BY
--         c.city, p.productCode, p.productName)
-- SELECT
--     city,
--     productName AS mostSoldProduct
-- FROM
--     CityProductRank
-- WHERE
--     ranking = 1;
-- 14.
-- WITH cityAmount AS (
-- SELECT city, SUM(amount) as amount FROM classicmodels.customers c
-- JOIN classicmodels.payments p ON c.customerNumber = p.customerNumber
-- GROUP BY city)
-- SELECT city, amount FROM cityAmount
-- WHERE amount = (SELECT MAX(amount) FROM cityAmount);
-- 15.
-- WITH CountOrders AS (
--     SELECT customerNumber, COUNT(*) AS orderCount
--     FROM classicmodels.orders
--     GROUP BY customerNumber)
-- SELECT AVG(orderCount) AS averageOrder
-- FROM CountOrders;
-- 16.
-- WITH maxAmountTable AS (
-- SELECT MAX(amount) AS maxAmount FROM classicmodels.payments 
-- GROUP BY customerNumber)
-- SELECT c.customerName, p.amount FROM classicmodels.customers c
-- JOIN classicmodels.payments p ON c.customerNumber = p.customerNumber
-- WHERE amount = (SELECT MAX(maxAmount) FROM maxAmountTable);
-- 17.
-- SELECT c.customerName, p.amount FROM classicmodels.customers c
-- LEFT JOIN classicmodels.payments p ON c.customerNumber = p.customerNumber
-- WHERE p.amount IS NULL;
-- 18.
-- WITH orderDay AS (
-- SELECT shippedDate - orderDate AS days FROM classicmodels.orders)
-- SELECT AVG(days) AS averageDays FROM orderDay;
-- 19.
-- SELECT EXTRACT(YEAR FROM orderDate) AS orderYear, COUNT(*) AS orderCount FROM classicmodels.orders
-- GROUP BY orderYear;
-- 20.
-- WITH notShippedStatus AS (
-- SELECT * FROM classicmodels.orders
-- WHERE status != 'Shipped')
-- SELECT COUNT(*) AS countNotShipped FROM notShippedStatus;
-- 21.
-- SELECT concat(firstName, ' ', lastName) AS fullName FROM classicmodels.employees
-- ORDER BY fullName;
-- 22.
-- SELECT DISTINCT concat(e.firstName, e.lastName) AS fullName FROM classicmodels.customers c
-- JOIN classicmodels.employees e ON c.salesRepEmployeeNumber = e.employeeNumber
-- JOIN classicmodels.orders o ON c.customerNumber = o.customerNumber
-- WHERE EXTRACT(YEAR FROM orderDate) = 2003;
-- 23.
-- WITH countEmployees AS (
--     SELECT c.city, COUNT(*) AS countEmployeesCity
--     FROM classicmodels.employees e
--     JOIN classicmodels.customers c ON e.employeeNumber = c.salesRepEmployeeNumber
--     GROUP BY c.city)
-- SELECT city
-- FROM countEmployees
-- WHERE countEmployeesCity = (SELECT MAX(countEmployeesCity) FROM countEmployees);
-- 24. 
-- WITH countOrder AS (
-- SELECT COUNT(*) AS countOrders, CONCAT(office.city, ' ', office.addressLine1, ' ', office.state) AS officeName FROM classicmodels.customers c
-- JOIN classicmodels.orders o ON c.customerNumber = o.customerNumber
-- JOIN classicmodels.employees e ON c.salesRepEmployeeNumber = e.employeeNumber
-- JOIN classicmodels.offices office ON e.officeCode = office.officeCode)
-- SELECT officeName FROM countOrder
-- WHERE countOrders = (SELECT MAX(countOrders) FROM countOrder);
-- Part 2
-- 1.
-- SELECT b.id, b.ISBN, b.`name`, b.page_num, b.pub_year, a.first_name, a.last_name, c.`name`, copy.`number`, copy.admission_date, i.issue_date, i.release_date, i.deadline_date, r.first_name, r.last_name, r.reader_num  FROM library_simple.book b
-- LEFT JOIN library_simple.author_has_book ahb ON b.id = ahb.book_id
-- LEFT JOIN library_simple.author a ON ahb.author_id = a.id
-- LEFT JOIN library_simple.category_has_book chb ON b.id = chb.book_id
-- LEFT JOIN library_simple.category c ON chb.category_id = c.id
-- LEFT JOIN library_simple.copy copy ON b.id = copy.book_id
-- LEFT JOIN library_simple.issuance i ON copy.id = i.copy_id
-- LEFT JOIN library_simple.reader r ON i.reader_id = r.id
-- WHERE b.id = 252;
-- 2.
-- SELECT b.id, b.ISBN, b.`name`, b.page_num, b.pub_year, a.first_name, a.last_name FROM library_simple.book b
-- LEFT JOIN library_simple.author_has_book ahb ON b.id = ahb.book_id
-- LEFT JOIN library_simple.author a ON ahb.author_id = a.id
-- WHERE a.first_name = 'VAN' && a.last_name = 'Parks';
-- 3.
-- SELECT b.id, b.ISBN, b.`name`, b.page_num, b.pub_year, GROUP_CONCAT(CONCAT(a.first_name, a.last_name)) AS authorsName FROM library_simple.book b
-- LEFT JOIN library_simple.author_has_book ahb ON b.id = ahb.book_id
-- LEFT JOIN library_simple.author a ON ahb.author_id = a.id
-- WHERE b.pub_year = 2003
-- GROUP BY b.id;



