-- SELECT * FROM classicmodels.customers
-- WHERE country IN ("Australia");

-- SELECT contactFirstName, contactLastName FROM classicmodels.customers
-- WHERE city IN ("Melbourne");

-- SELECT * FROM classicmodels.customers
-- WHERE creditLimit > 200000;

-- SELECT * FROM classicmodels.employees
-- WHERE jobTitle IN ("President");
-- Murphy Diane

-- SELECT count(*) AS res FROM classicmodels.employees
-- WHERE jobTitle IN ("Sales Rep");
-- 17

-- SELECT * FROM classicmodels.payments
-- ORDER BY paymentDate DESC;

-- SELECT checkNumber FROM classicmodels.payments
-- WHERE paymentDate IN ("2004-12-17");
-- BO864823
-- OU516561

-- SELECT * FROM classicmodels.productlines
-- WHERE textDescription LIKE "%realistic%";
-- Trucks and Buses
-- Vintage Cars

-- SELECT productName FROM classicmodels.products
-- WHERE productVendor IN ("Unimax Art Galleries");

-- SELECT customerNumber FROM classicmodels.payments
-- WHERE amount IN (SELECT MAX(amount) FROM classicmodels.payments);
-- 141





