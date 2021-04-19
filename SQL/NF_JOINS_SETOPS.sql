create schema avengers;
set schema 'avengers';

--This script will demonstrate Normal Forms 0NF - 3NF 

--I also want to go over joins and set ops at the end



-- 0NF
--We have a table. No other rules. Wild West. 

CREATE TABLE avengers (
	superhero_name varchar(30),
	superhero_power varchar(30),
	real_name text,
	home_base varchar(30),
	hb_address text
);

INSERT INTO avengers (superhero_name, superhero_power, real_name, home_base, hb_address)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve Rogers', 20, 'Stark Tower', '123 Stark Ave New York NY 10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint Barton', 55, 'Stark Tower', '123 Stark Ave New York NY 10709');
	

--1NF
--Tables must have a primary key (can be a composite key!) 
--Columns must be atomic 

DROP TABLE IF EXISTS avengers; 

CREATE TABLE avengers (
	superhero_name varchar(30),
	superhero_power varchar(30),
	first_name text,
	last_name text,
	home_base varchar(30),
	hb_st_addr text,
	hb_city text,
	hb_state char(2),
	hb_zip char(5)
);

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve', 'Rogers', 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton', 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709');

ALTER TABLE avengers ADD PRIMARY KEY (superhero_name, first_name, last_name); --composite key!

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Bucky', 'Barnes', 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709');


--2NF
--Remove partial dependencies
--ELIMINATE partial dependencies by having a single column PK

DROP TABLE IF EXISTS avengers; 

CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY, 
	superhero_name varchar(30),
	superhero_power varchar(30),
	first_name text(30),
	last_name text(30),
	home_base varchar(30),
	hb_st_addr text,
	hb_city varchar(30),
	hb_state char(2),
	hb_zip char(5)
);

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve', 'Rogers', 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton','Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Capt. America', 'Super Strong Frisbee', 'Bucky', 'Barnes', 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709');


--3NF
--remove transitive dependencies
--(by separating them into new tables)
--the only columns depended on should be primary keys!!

DROP TABLE IF EXISTS avengers; 
DROP TABLE IF EXISTS homes CASCADE; 

CREATE TABLE homes (
	home_base varchar(30) primary key, --example of non-serial non-int PK
	hb_st_addr text,
	hb_city varchar(30),
	hb_state char(2),
	hb_zip char(5)
);

CREATE TABLE avengers (
	superhero_id SERIAL PRIMARY KEY, 
	superhero_name varchar(30),
	superhero_power varchar(30),
	first_name text,
	last_name text,
	home_base_fk varchar(30) REFERENCES homes(home_base) 
);


INSERT INTO homes (home_base, hb_st_addr, hb_city, hb_state, hb_zip) 
	VALUES ('Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Helicarrier', 'bottom of the potomac', 'Washington', 'DC', '00000'),
	('Shawarma Joint', 'Somewhere in Manhattan', 'New York', 'NY', '10709');

INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, home_base_fk)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve', 'Rogers', 'Stark Tower'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton', 'Helicarrier'),
	('Capt. America', 'Super Strong Frisbee', 'Bucky', 'Barnes', 'Stark Tower'),
	('Hulk', 'In touch with his emotions', 'Bruce', 'Banner', null);

SELECT * FROM avengers;

--Simple Transaction below... (TCL)

alter table avengers add column active boolean; 
alter table avengers alter column active set default true; 
truncate table avengers;
--(not the transaction, just setting up)

--ok NOW here's the transaction
BEGIN;
INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve', 'Rogers'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton');
UPDATE avengers SET active = false WHERE superhero_name = 'Capt. America';
UPDATE avengers SET active = true WHERE superhero_name = 'Hawkeye';
COMMIT; 

--coolz

--------------------------------------------------------------------------


--Joins Review
--Remember, joins combine data from two tables

SELECT * FROM avengers JOIN homes ON home_base = home_base_fk;

SELECT * FROM avengers RIGHT JOIN homes ON home_base = home_base_fk;

SELECT * FROM avengers LEFT JOIN homes ON home_base = home_base_fk;

SELECT * FROM avengers FULL JOIN homes ON home_base = home_base_fk;

SELECT * FROM avengers CROSS JOIN homes; --all combinations of all rows from each table


--Set Operators
--We use set operators to combine multiple queries 
	--Don't confuse them with joins, which combine multiple tables

--Union
--All distinct rows from both queries (no duplicates)
select first_name, last_name from avengers union select home_base, hb_city from homes; 

select home_base_fk from avengers union select home_base from homes; 

--Union All
--All distinct rows from both queries, (including duplicates)
select home_base_fk from avengers union all select home_base from homes; --note how this is different from union!

--Intersect
--Distinct rows that are found in both queries
select home_base_fk from avengers intersect select home_base from homes;

--Except
--Return all rows from the first query that don't appear in the second query
select home_base_fk from avengers except select home_base from homes;

