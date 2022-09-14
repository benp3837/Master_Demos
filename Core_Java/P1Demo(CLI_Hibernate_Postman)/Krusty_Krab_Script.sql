--This schema will model a Krusty Krab employee management system (a viable option for P0)

--This will be a one-to-many relationship which is probably what you'll need for P0.

CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	role_title TEXT,
	role_salary int
);

INSERT INTO roles (role_title, role_salary)
VALUES ('Manager', 100000), ('Fry Cook', 50000), ('Cashier', 40000), ('Marketing Director', 100000);

SELECT * FROM roles;


CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	role_id_fk int REFERENCES roles (role_id)
);

INSERT INTO employees (first_name, last_name, role_id_fk)
VALUES ('Eugene', 'Krabs', 1),
	   ('Spongebob', 'Squarepants', 2),
	   ('Squidward', 'Tentacles', 3),
	   ('Patrick', 'Star', 4);

SELECT * FROM employees;


CREATE TABLE users (
	user_id serial PRIMARY KEY,
	username TEXT,
	PASSWORD text
);

INSERT INTO users (username, password)
VALUES ('user', 'password');


