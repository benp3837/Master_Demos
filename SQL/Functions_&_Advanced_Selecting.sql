create schema krusty_krab;
set schema 'krusty_krab';

--In each demo I want to create a new schema to get them used to creating tables
--It was something I always had to relearn because we'd only ever do it once 

--employees (include plankton as marketing director - it's a conspiracy)

create table roles(
	role_id serial primary key,
	role_title text,
	role_salary int
);

create table employees (
	employee_id serial primary key,
	f_name text,
	l_name text,
	hire_date date, --YYYY-MM-DD
	role_id int references Roles (role_id) --foreign key
);

--remember to show them the ERD


insert into roles (role_title, role_salary) 
		   values ('Supreme Leader', 100000),
		   		  ('Fry Cook', 50000),
		   		  ('Cashier', 40000),
		   		  ('Marketing Director', 100000),
		   		  ('Nepotism', 100000);
		   		  
	   		 
select * from roles;

insert into employees (f_name, l_name, hire_date, role_id)
			   values ('Eugene', 'Krabs', '1998-01-01', 1),
			   		  ('Spongebob', 'Squarepants', '1998-09-20', 2),
			   		  ('Squidward', 'Tennisballs', '1998-01-15', 3),
			   		  ('Sheldon', 'Plankton', '1998-01-02', 4),
			   		  ('Pearl', 'Krabs', '1998-01-01', 5),
			   		  ('Pete', 'Fishman', '1998-01-15', 2);
	
select * from employees;			   		 
			   		 
/*
  Worth mentioning that don't have to name all the columns in your insert, 
  BUT you'd have to specify "default" for the serial primary key field
  
  insert into employees 
  values (default, 'test', 'testington', '1998-04-07', 5);
  
  This WILL work! But it's good practice to just list out the columns 
  for the sake of clarity and your own readability.
  The less readable your code is, the more your coworkers will spite you >:0
 */			   		 
			   		 

--------------------------------------------

--I want to demonstrate functions, group by/having, 
--limit, aliases (as), concatenation, and subqueries 


--scalar functions: upper, lower, length, now

select upper(role_title) from roles; --returns data in uppercase

select l_name, length(l_name) from employees; --returns lengths of employee last names 

select f_name from employees where length(f_name) > 8; --returns names longer than 8 chars

select now(); --just for fun, also a scalar function


--aggregate functions: avg, max, min, sum, count

select avg(role_salary) from roles;

select sum(role_salary) from roles;

select min(hire_date) from employees; --earliest hire date

select max(hire_date) from employees; --latest hire date

select count(employee_id) from employees; --how many employees are there?
--I like to use count on the primary key, but you can use any column 


--Now let's explore using GROUP BY and HAVING
--For the most part, we use these with aggregate functions

--Group by lets us combine records based on equivalent values

select role_salary, count(role_id) 
from roles group by role_salary; --retreives salaries and counts of each salary 

select hire_date, count(employee_id)
from employees group by hire_date; --retreives counts of each hire date

select role_id, count(employee_id)
from employees group by role_id; --retreives counts of each role id


--Having behaves like Where, but it's only used with aggregate functions

select role_id, count(employee_id) from employees 
group by role_id having count(employee_id) > 1; --select roles with more than one employee 

select role_salary, count(role_id) from roles
group by role_salary having count(role_id) >=3; --select salaries assigned to 3 or more roles



--Advanced Selecting concepts below...... we'll try to make some more complicated queries too


--Limit will limit the number of results returned from your query

select * from employees 
order by hire_date desc limit 3; --latest three hires 

select role_title, role_salary from roles 
where role_salary > 40000 order by role_salary limit 1; --lowest salary above 40,000


--Aliases are temporary names given to a column. Use the "as" keyword 

select f_name as "First Name", l_name as "Last Name" from employees;


--Concatenation puts two columns together in a query, often used with aliases
--You can put text between the single quotes, or leave it blank

select f_name ||' '|| l_name as "Full Name" from employees;


--5 minute challenge:
--Select employee first name and hire date as one concatenated column 
--and have the data display in the row as "(name) was hired on (hire date)". 
--Then, give the concatenated column the alias "Hire Info".
--Finally, order the result set by hire date ascending.

select f_name ||' was hired on '|| hire_date as "Hire Info" from employees
order by hire_date;


--Subqueries are queries nested inside another query. woah :o

--This subquery is pointless... but shows subquery syntax.
--selecting employees with role_id 2 from all employee data
select * from (select * from employees) as pointless_subquery
where role_id = 2;


--This one is less pointless
--It would delete all rows where role_id = 2

 /*
 
 delete from employees where role_id in 
 (select role_id from roles where role _id = 2);
 
 */

--subqueries are more useful in big, robust DBs
--not too necessary in schemas of this size
--but make sure you know WHAT they are 
