--schemas are smaller demoninations within a database - essentially a collection of related tables
CREATE SCHEMA krusty_krab; --remember to refresh before setting the schema
SET SCHEMA 'krusty_krab';


CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	role_title TEXT,
	role_salary INT
);

CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	f_name TEXT,
	l_name TEXT,
	hire_date date, --YYYY-MM-DD
	role_id INT REFERENCES Roles (role_id) --foreign key
);


INSERT INTO roles (role_title, role_salary)
		VALUES ('Supreme Leader', 100000),
			   ('Fry Cook', 50000),
			   ('Cashier', 40000),
			   ('Marketing Director', 100000),
			   ('Nepotism', 100000);
			   
SELECT * FROM roles;
			  
			  
INSERT INTO employees (f_name, l_name, hire_date, role_id)
		VALUES ('Eugene', 'Krabs', '1998-01-01', 1),
			   ('Spongebob', 'Squarepants', '1998-09-20', 2),
			   ('Pete', 'Fishman', '1998-01-15', 2),
			   ('Squidward', 'Tentacles', '1998-01-15', 3),
			   ('Sheldon', 'Plankton', '1998-01-01', 4),
			   ('Pearl', 'Krabs', '1998-01-01', 5);
			   
SELECT * FROM employees;

--End of DDL-----------------------------------------------------
			  
			 
--Scalar Functions: upper, lower, length, now---------------------------------------------

SELECT upper(role_title) FROM roles; --returns data in uppercase
--lower would do the opposite

SELECT l_name, length(l_name) FROM employees; --length returns the length of the string

SELECT f_name FROM employees WHERE length(f_name) > 8;
--returns names longer than 8 chars

SELECT now(); --just for fun, now() returns date and time


--Aggregate Functions: avg, max, min, sum, count-----------------------------------------

SELECT avg(role_salary) FROM roles; --return the average of all role_salaries
--interestingly, the avg was returned as a decimal type, whats up with that

SELECT sum(role_salary) FROM roles; --return the sum of all role salaries

SELECT max(hire_date) FROM employees; --return the latest hire_date

SELECT min(hire_date) FROM employees; --return the earliest hire_date

SELECT count(employee_id) FROM employees; --how many employees are there?
--It's common to use the primary key, to ensure ever row is counted
--But of course you can count on any column

--slight aside, the distinct keyword will ignore duplicate values
SELECT count(DISTINCT hire_date) FROM employees; 
--how many unique/distinct hire dates are there?


--User Defined Functions-----------------------------------------------------------------

CREATE OR REPLACE FUNCTION kill_pete() RETURNS void AS '
	delete from employees where f_name = ''Pete'';
' LANGUAGE SQL;
--function created!

--drop function kill_pete(); you can drop functions like dis

SELECT kill_pete(); --Pete has been vanquished >:0

SELECT * FROM employees;

--Now let's explore using GROUP BY and HAVING------------------------------------------
--For the most part, we'll use these with aggregate functions

--Group By lets us combine records based on equivalent values
--They just help us further filter aggregate function results 

SELECT role_salary, count(role_id) 
FROM roles GROUP BY role_salary; 
--retreives salaries and counts of each salary

SELECT hire_date, count(employee_id)
FROM employees GROUP BY hire_date; 
--retreives counts of each hire date

SELECT role_id, count(employee_id)
FROM employees GROUP BY role_id;
--retreive counts of each role id


--Having behaves like where, but it's only used after aggregate functions

SELECT role_salary, count(role_id) FROM roles
GROUP BY role_salary HAVING count(role_id) > 1;
--selecting salaries assigned to more than 1 role


--Let's also use Order By since Tim forgot >.> -----------------------------

--text-based datatypes will order alphabetically
--number-based dataypes will order numerically

SELECT * FROM employees ORDER BY f_name; --order is ascending by default

SELECT * FROM employees ORDER BY f_name ASC; --you can also specify ascending
--returns the same as above

SELECT * FROM roles ORDER BY role_salary DESC;
--write desc to specify descending order


--Prepared Statements------------------------------------------------------

PREPARE create_employee AS 
INSERT INTO employees (f_name, l_name, hire_date, role_id) 
		VALUES ($1, $2, $3, $4);
	

--DEALLOCATE create_employee; to delete a prepared statement

EXECUTE create_employee('Pete', 'Fishman', '1998-01-15', 2); --Pete lives!!!

SELECT * FROM employees;


/*
PREPARE create_employee_with_id AS 
INSERT INTO employees (employee_id, f_name, l_name, hire_date, role_id) 
		VALUES ($1, $2, $3, $4, $5);
	
EXECUTE create_employee_with_id (3, 'ben', 'p---', '1998-04-09', 2);
*/

--ctrl+shift+backslash to comment out a block


--Triggers-------------------------------------------------------------------
	
--saved this for last just so we can do slightly more complicated stuff
--(more realistic use cases)

--We want to adjust role salaries every time an employee is added or removed.


--create two functions to put in our trigger
--when the trigger is called, it'll execute a function

CREATE FUNCTION employee_removed() RETURNS TRIGGER AS '
begin
	update roles set role_salary = role_salary + 10000;
	return null;
end;
' LANGUAGE plpgsql; 


CREATE FUNCTION employee_added() RETURNS TRIGGER AS '
begin
	update roles set role_salary = role_salary - 10000;
	return null;
end;
' LANGUAGE plpgsql; 


--Now, let's create two triggers to update the salaries when employees are added/removed
--We're TRIGGERING an event to happen after a certain event happens

CREATE TRIGGER employee_removed AFTER DELETE ON employees
FOR EACH ROW EXECUTE PROCEDURE employee_removed();

CREATE TRIGGER employee_added AFTER INSERT ON employees
FOR EACH ROW EXECUTE PROCEDURE employee_added();

--DROP TRIGGER employee_added ON employees;

--Now let's trigger the triggers--------------

SELECT role_salary FROM roles; --show salaries before manipulation


SELECT kill_pete(); --our kill pete user defined function from earlier

SELECT role_salary FROM roles; --trigger works! salaries have been increased


EXECUTE create_employee('Pete', 'Fishman', '1998-01-15', 2); 
--our create_employee prepared statement from earlier

SELECT role_salary FROM roles; --trigger works! salaries have been decreased

			  