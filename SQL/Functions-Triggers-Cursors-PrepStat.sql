CREATE SCHEMA krusty_krab;
set schema 'krusty_krab';

--In each demo I want to create a new schema to get them used to creating tables
--It was something I always had to relearn because we'd only ever do it once 


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
			   		  ('Pete', 'Fishman', '1998-01-15', 2),
			   		  ('Squidward', 'Tennisballs', '1998-01-15', 3),
			   		  ('Sheldon', 'Plankton', '1998-01-02', 4),
			   		  ('Pearl', 'Krabs', '1998-01-01', 5); 

	
select * from employees;	
 		 
			   		 

--------------------------------------------

--I want to demonstrate functions, group by/having, 
--limit, aliases (as), and concatenation 


--scalar functions: upper, lower, length, now---------------------------------------------------

select upper(role_title) from roles; --returns data in uppercase

select l_name, length(l_name) from employees; --returns lengths of employee last names 

select f_name from employees where length(f_name) > 8; --returns names longer than 8 chars

select now(); --just for fun, also a scalar function


--aggregate functions: avg, max, min, sum, count-----------------------------------------------------

select avg(role_salary) from roles;

select sum(role_salary) from roles;

select min(hire_date) from employees; --earliest hire date

select max(hire_date) from employees; --latest hire date

select count(employee_id) from employees; --how many employees are there?
--It's common to use count on the primary key, but you can use any column 

--slight aside, the distinct keyword will ignore any duplicate values
select count(distinct hire_date) from employees; --how many different hire dates are there?


--User Defined Functions--------------------------------------------------------------------------------

create function kill_pete() returns void as '
	delete from employees where f_name = ''Pete'';
' language sql;

select kill_pete(); --Pete has been vanquished

select * from employees; 


--Now let's explore using GROUP BY and HAVING-----------------------------------------------------------
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


--Let's also use Order By since Tim forgot >.> ----------------------------------------------------------

--text-based datatypes will order alphabetically, int datatypes will order numerically

select * from employees order by f_name; --order by is ascending by default

select * from employees order by f_name asc; --same as above!

select * from roles order by role_salary desc;

-----------------------------------------------------------------------------


--Prepared Statement
prepare create_employee as 
insert into employees (f_name, l_name, hire_date, role_id) values ($1, $2, $3, $4);

execute create_employee('Pete', 'Fishman', '1998-01-15', 2); --Pete lives!

select * from employees;



--Triggers-------------------------------------------------------------

--saved this for last so we can do some complicated stuff (more realistic use case)

--We want to adjust role salaries every time an employee is added or removed

--creating two functions to put in our triggers
create function employee_removed() returns trigger as '
begin
	update roles set role_salary = role_salary + 10000;
return null;
end;
' language plpgsql; 

create function employee_added() returns trigger as '
begin
	update roles set role_salary = role_salary - 10000;
return null;
end;
' language plpgsql; 

--Now let's create some triggers to update salaries when employees are added/removed
--We're TRIGGERING an event to happen after a certain event happens
create TRIGGER employee_removed after delete on employees
for each row execute procedure employee_removed();

create TRIGGER employee_added after insert on employees
for each row execute procedure employee_added();



select role_salary from roles; --show salaries before manipulation


select kill_pete(); --kill pete function from earlier

select * from roles; --trigger works! salaries are lowered


execute create_employee('Pete', 'Fishman', '1998-01-15', 2); 
--ressurect pete with the prepared statement from earlier

select * from roles; --trigger works! salaries are raised
