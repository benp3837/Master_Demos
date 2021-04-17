create schema avengers;
set schema 'avengers';

--This script will demonstrate Normal Forms 0NF - 3NF 

--I also want to go over joins and set ops at the end



-- 0NF
--We have a table. No other rules. Wild West.

CREATE TABLE avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	real_name VARCHAR(30),
	power_level INTEGER, 
	home_base VARCHAR(30),
	hb_address VARCHAR(60)
);

INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level, home_base, hb_address)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve Rogers', 20, 'Stark Tower', '123 Stark Ave New York NY 10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint Barton', 55, 'Stark Tower', '123 Stark Ave New York NY 10709');
	

--1NF
--Tables must have a primary key (can be a composite key!)
--Columns must be atomic 

DROP TABLE IF EXISTS avengers; 

CREATE TABLE avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	power_level INTEGER, 
	home_base VARCHAR(30),
	hb_st_addr VARCHAR(60),
	hb_city VARCHAR(30),
	hb_state VARCHAR(2),
	hb_zip VARCHAR(5)
);

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve', 'Rogers', 20, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton', 55, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709');

ALTER TABLE avengers ADD PRIMARY KEY (superhero_name, first_name, last_name);

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Bucky', 'Barnes', 20, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709');


--2NF
--Remove partial dependencies
--ELIMINATE partial dependencies by having a single column PK

DROP TABLE IF EXISTS avengers; 

CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY, 
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	power_level INTEGER, 
	home_base VARCHAR(30),
	hb_st_addr VARCHAR(60),
	hb_city VARCHAR(30),
	hb_state VARCHAR(2),
	hb_zip VARCHAR(5)
);

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve', 'Rogers', 20, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton', 55, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Capt. America', 'Super Strong Frisbee', 'Bucky', 'Barnes', 20, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709');


--3NF
--remove transitive dependencies
--(by separating them into new tables)
--the only columns depended on should be primary keys!!

DROP TABLE IF EXISTS avengers; 
DROP TABLE IF EXISTS homes CASCADE; 

CREATE TABLE homes (
	home_base VARCHAR(30) PRIMARY KEY,
	hb_st_addr VARCHAR(60),
	hb_city VARCHAR(30),
	hb_state VARCHAR(2),
	hb_zip VARCHAR(5)
);

CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY, 
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	power_level INTEGER,
	home_base_fk VARCHAR(30) REFERENCES homes(home_base) 
);


INSERT INTO homes (home_base, hb_st_addr, hb_city, hb_state, hb_zip) 
	VALUES ('Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Helicarrier', 'bottom of the potomac', 'Washington', 'DC', '00000'),
	('Shawarma Joint', 'Somewhere in Manhattan', 'New York', 'NY', '10709');

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base_fk)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve', 'Rogers', 20, 'Stark Tower'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton', 55, 'Helicarrier'),
	('Capt. America', 'Super Strong Frisbee', 'Bucky', 'Barnes', 20, 'Stark Tower'),
	('Hulk', 'In touch with his emotions', 'Bruce', 'Banner', 104, null);

SELECT * FROM avengers;



--Joins Review

SELECT * FROM avengers JOIN homes ON home_base = home_base_fk;

SELECT * FROM avengers RIGHT JOIN homes ON home_base = home_base_fk;

SELECT * FROM avengers LEFT JOIN homes ON home_base = home_base_fk;

SELECT * FROM avengers FULL JOIN homes ON home_base = home_base_fk;


--Cross Join?


--Set Operators?





