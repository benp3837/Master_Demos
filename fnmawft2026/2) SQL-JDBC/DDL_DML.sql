--DDL (Data Definition Language)

--CREATE lets us create tables
create table employees(
	user_id integer PRIMARY KEY AUTOINCREMENT, --PRIMARY keys ARE UNIQUE AND NOT NULL BY DEFAULT. They UNIQUELY IDENTIFY A RECORD
	username varchar(12) UNIQUE NOT NULL,
	age integer CHECK(age > 18),
	is_active boolean NOT NULL,
	hire_date datetime DEFAULT CURRENT_TIMESTAMP,
	fav_food text
);


--OH NO! We forgot to add the salary attribute.
--We can ALTER the table to add a column (amongst other things)
ALTER TABLE employees ADD COLUMN salary int;


--DROP lets us delete tables
drop table employees;


--DML (Data Manipulation Language)

-- Describe keyword - shows details about a table (NOT the data)
PRAGMA table_info(employees);


--INSERT lets us insert data into the database
insert into employees (username, age, is_active, fav_food, salary)
values ('Jonah', 35, false, 'Chicken Tendie', 500_000), ('Kush', 42, TRUE, 'Chicken Nuggie', 499_999),
		('Sanket', 19, TRUE, 'Rotisserie Chicken', 200_000), ('Tobi', 95, FALSE, 'Liquid Chicken', 2_000_000);


--SELECT lets us read data from the DB table
select * from employees;

--We can select individual columns too-
SELECT username, age FROM employees;


--The WHERE Clause --------------- (This is how we filter the results of a SELECT)

-- select all employees where is_active is true (=)
SELECT * FROM employees WHERE is_active = TRUE; 

-- select all employees where salary is less than 1 million (<)
SELECT * FROM employees WHERE salary < 1_000_000;

-- quick subquery (a query inside a query). I'll also use a function just for spice
SELECT * FROM employees WHERE salary > (SELECT AVG(salary) FROM employees);

-- select all employees where age is between 20 and 50 (BETWEEN, AND)
SELECT * FROM employees WHERE age BETWEEN 20 AND 50;

-- the wildcard (%) coupled with "LIKE" will let you select things that start with, end with, or contain certain characters
SELECT * FROM employees WHERE fav_food LIKE 'Chicken%';
SELECT * FROM employees WHERE fav_food LIKE '%Chicken';
SELECT * FROM employees WHERE fav_food LIKE '%Chicken%';

-- select employees who are named Jonah or Tobi (OR)
SELECT * FROM employees WHERE username = 'Jonah' OR username = 'Tobi';

-- the IN keyword is a more scaleable way to accomplish this (imagine we had 50 names to check)
SELECT * FROM employees WHERE username IN ('Jonah', 'Tobi');


--ORDER BY - order results numerically or alphabetically

SELECT * FROM employees ORDER BY salary; --ascending BY DEFAULT

SELECT * FROM employees ORDER BY username DESC; --We can choose TO GO IN descending order



--FUNCTIONS -- take in zero or more values and return a single value

-- scalar functions - take in up to one value and return one value
SELECT upper('I will be uppercase');
SELECT lower('I will be LOWERCASE');


-- aggregate functions - take in many values and return one value

-- We saw AVG() above

-- MAX gets maximums (we also have MIN)
SELECT MAX(age) FROM employees;

--COUNT gives us an int representing the number of records that fit our specification
SELECT count(*) FROM employees;
SELECT count(*) AS 'productive guys' FROM employees WHERE is_active = TRUE;
SELECT count(*) AS 'slackers' FROM employees WHERE is_active = FALSE;

--SUM... sums
SELECT SUM(salary) FROM employees;
SELECT SUM(salary) FROM employees WHERE is_active = false;
SELECT SUM(salary) FROM employees WHERE is_active = true;


--GROUP BY/HAVING

-- GROUP BY merges records together based on matching column values
SELECT is_active, count(*) AS 'active status counts' FROM employees GROUP BY is_active;

-- HAVING is like a WHERE clause but for aggregate functions specifically. It's ONLY used after a GROUP BY
SELECT is_active, count(*) AS 'active status counts' FROM employees GROUP BY is_active HAVING is_active = true;


-- HAVING exists because WHERE doesn't work after a group by
-- WHERE only works after raw data selection, not after already-filtered data 


--UPDATE 

-- changes the data in the table
UPDATE employees SET username = 'bingus'; -- this WOULD HAVE SET everyone's name TO bingus

UPDATE employees SET username = 'bingus' WHERE user_id = 1;

SELECT * FROM employees;


--DELETE

--same story with delete, make sure you have the WHERE clause or you can delete everything

DELETE FROM employees WHERE is_active = FALSE; -- your time has come, there's NO way OUT OF this one

SELECT * FROM employees;


-- TRUNCATE - deletes all the data
truncate TABLE employees; -- nvm THIS DOESN'T EXIST IN SQLITE

--It exists in most SQL dialects tho






 