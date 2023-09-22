-- Homework #6
-- Part 1  finish queries from classicmodels db: -- 12,13,15,18,19,20,22,23,24 but we'll go over all of them
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
-- Advanched homework: join all tables together 

/* Homework - Part #2 
Find any dataset you want to analyze (csv, xls, etc.) and import the data 
https://www.dataquest.io/blog/free-datasets-for-projects/
https://www.kaggle.com/datasets
https://catalog.data.gov/dataset
https://data.world
https://datasf.org/opendata/

Import this dataset to mysql database: 
1. create a database
2. right click on that database - Table Data Import Wizard - next - next - next ...
*/

/*Film Locations in San Francisco
-- https://data.sfgov.org/Culture-and-Recreation/Film-Locations-in-San-Francisco/yitu-d5am
-- import csv file Film_Locations_in_San_Francisco.csv
-- in MySQL Workbanch: create database Film
-- right click on Film database - Import Table - Wizard - Next ...
-- select * from film.film_locations_in_san_francisco;
Queries:
count distinct movies
count of all films by release year
count of all films by 'production company'
count of all films directed by Woody Allen
how many movies have/don't have fun facts?
in how many movies were Keanu Reeves and Robin Williams?
*/

-- ------------------- ETL (EXTRACT TRANSFORM LOAD) -------------------
-- ------------------- Loading Data via the Command-Line --------------

-- Find the data type of existing columns 
SELECT  column_name, column_type 
FROM INFORMATION_SCHEMA.columns
WHERE TABLE_SCHEMA = 'film';

-- Prepare database and table for CSV data load
DROP DATABASE IF EXISTS film2;
CREATE DATABASE film2;
CREATE TABLE film2.film_locations_in_san_francisco (
`Title`	text,
`Release Year`	int(11),
`Locations`	text,
`Fun Facts`	text,
`Production Company`	text,
`Distributor`	text,
`Director`	text,
`Writer`	text,
`Actor 1`	text,
`Actor 2`	text,
`Actor 3`	text)
;
-- select * from film2.film_locations_in_san_francisco;

-- Set Client and Server ON to load data
-- Instructions for Windows in file 'ETL - Enabling local data load on MySQL Client and Server.docx'

-- Import the CSV file
-- Windows - Search MySQL - command prompt
LOAD DATA LOCAL INFILE 'C:/A_A/A_Tania/SQL/Teaching SQL/film_locations_in_san_francisco.csv'
 INTO TABLE film2.film_locations_in_san_francisco
 FIELDS TERMINATED BY ',' 
 ENCLOSED BY '"' 
 LINES TERMINATED BY '\n' 
 IGNORE 1 ROWS
 (`Title`,`Release Year`,`Locations`,`Fun Facts`,`Production Company`,`Distributor`, `Director`,`Writer`,`Actor 1`,`Actor 2`,`Actor 3`);

-- see records loaded  
-- 1976
  select * from film2.Film_Locations_in_San_Francisco;
-- Linux OS
-- mysqlimport --local -u ваше_имя_пользователя -p --fields-terminated-by=',' --fields-enclosed-by='"' --lines-terminated-by='\n' --ignore-lines=1 имя_базы_данных /путь/к/вашему/файлу.csv
-- or
-- mysql -u ваше_имя_пользователя -p -e "LOAD DATA LOCAL INFILE /home/vasilisa/Загрузки/Film_Locations_in_San_Francisco.csv INTO TABLE film2.film_locations_in_san_francisco FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;"

  
  
  -- Part 1
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
-- 15.
-- WITH CountOrders AS (
--     SELECT customerNumber, COUNT(*) AS orderCount
--     FROM classicmodels.orders
--     GROUP BY customerNumber)
-- SELECT AVG(orderCount) AS averageOrder
-- FROM CountOrders;
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
CREATE DATABASE crime;
select * from crime.Crime_Data_from_2020_to_Present;

CREATE DATABASE film;
select * from film.Film_Locations_in_San_Francisco;

SELECT COUNT(DISTINCT title) FROM film.Film_Locations_in_San_Francisco; -- 326

SELECT `Release Year`, COUNT(DISTINCT title) FROM film.Film_Locations_in_San_Francisco
GROUP BY `Release Year`;

SELECT Director, COUNT(DISTINCT title) FROM film.Film_Locations_in_San_Francisco
WHERE Director LIKE "Woody Allen"
GROUP BY Director;

SELECT COUNT(DISTINCT title) FROM film.Film_Locations_in_San_Francisco
WHERE `Fun Facts` LIKE ""; -- 278

SELECT COUNT(DISTINCT title) FROM film.Film_Locations_in_San_Francisco
WHERE `Fun Facts` != ""; -- 154

SELECT COUNT(DISTINCT title) FROM film.Film_Locations_in_San_Francisco
WHERE `Actor 1` LIKE "Keanu Reeves" OR `Actor 1` LIKE "Robin Williams" 
OR `Actor 2` LIKE "Keanu Reeves" OR `Actor 2` LIKE "Robin Williams"
OR `Actor 3` LIKE "Keanu Reeves" OR `Actor 3` LIKE "Robin Williams";





