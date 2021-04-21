create schema avengers;
set schema 'avengers';

--This script will demonstrate Normal Forms 0NF - 3NF 

--I also want to go over joins and set ops at the end

--I ALSO want to fit a transation in here somewhere (TCL)


--0NF
--We have a table. No other rules, Wild West.

create table avengers (
	hero_name text,
	hero_power text,
	real_name text,
	home_base text,
	home_address text
);

insert into avengers (hero_name, hero_power, real_name, home_base, home_address)
	values ('Spiderman', 'Webby boy', 'Peter Parker', 'Queens', '225 his aunt''s house'),
	--two apostrophes to put one apostrophe in a value
	('Hulk', 'In touch with his emotions', 'David Banner', 'Queens', '123 under a bridge');

select * from avengers;


--1NF
--Tables must have a PK (can be a composite key)
--Columns must be atomic

drop table if exists avengers;

create table avengers (
	hero_name text,
	hero_power text,
	f_name text,
	l_name text,
	home_base text,
	street_address text,
	city text,
	state char(2),
	zip char(5)
);

insert into avengers (hero_name, hero_power, f_name, l_name, home_base, street_address, city, state, zip)
	values ('Spiderman', 'Webby boy', 'Peter', 'Parker', 'his aunt''s house', '123 house street', 'Queens', 'NY', '11365'),
	--two apostrophes to put one apostrophe in a value
	('Hulk', 'In touch with his emotions', 'David', 'Banner', 'under a bridge', '332 bridge', 'Queens', 'NY', '11365');

alter table avengers add primary key (hero_name, real_name); --composite key

insert into avengers (hero_name, hero_power, f_name, l_name home_base, street_address, city, state, zip)
	values ('Spiderman', 'Webby boy', 'Miles', 'Morales', 'his aunt''s house', '123 house street', 'Queens', 'NY', '11365');


--I FORGOT TO MAKE THE FULL NAME COLUMN ATOMIC!!!!!! (during lessons)
--But I refactored it to have a f_name and l_name column


--2NF
--Remove Partial Dependencies
--ELIMINATE partial dependencies by having a single column PK

drop table if exists avengers;

create table avengers (
	hero_id serial primary key,
	hero_name text,
	hero_power text,
	f_name text,
	l_name text,
	home_base text,
	street_address text,
	city text,
	state char(2),
	zip char(5)
);


insert into avengers (hero_name, hero_power, f_name, l_name, home_base, street_address, city, state, zip)
	values ('Spiderman', 'Webby boy', 'Peter', 'Parker', 'his aunt''s house', '123 house street', 'Queens', 'NY', '11365'),
	--two apostrophes to put one apostrophe in a value
	('Hulk', 'In touch with his emotions', 'David', 'Banner', 'under a bridge', '332 bridge', 'Queens', 'NY', '11365'),
	('Spiderman', 'Webby boy', 'Miles', 'Morales', 'his aunt''s house', '123 house street', 'Queens', 'NY', '11365');

select * from avengers;



--3NF
--remove transitive dependencies (by separating them into new tables)
--the only columns depnded on should be primary keys!!

drop table if exists avengers;


create table homes (
	home_base text primary key, --example of non-serial int PK
	street_address text,
	city text,
	state char(2),
	zip char(5)
);

insert into homes (home_base, street_address, city, state, zip)
		values ('Stark Tower', '455 Street street', 'Manhattan', 'NY', '11365'),
			   ('Sanctum Sanctorum', '117A Bleeker Street', 'Manhattan', 'NY', '11365'),
			   ('Pizza Joint', '664 pizza street', 'Staten Island', 'NJ', '11338');

create table avengers (
	hero_id serial primary key,
	hero_name text,
	hero_power text,
	f_name text,
	l_name text,
	home_base_fk text references homes(home_base)
);

insert into avengers (hero_name, hero_power, f_name, l_name home_base_fk) 
				values ('Ironman', 'Money... but at what cost?', 'Tony', 'Stark', 'Stark Tower'),
					   ('Dr. Strange', 'PHD', 'Benedict', 'Cumberbatch', 'Sanctum Sanctorum');

--cool, fully normalized

					  
--this is where our transaction will go...

					  
--some setup for the transaction
alter table avengers add column active boolean;
alter table avengers alter column active set default true;
					  
truncate table avengers;

--NOW we'll make a simple transaction

begin; --transaction starts
insert into avengers (hero_name, hero_power, real_name, home_base_fk)
			values ('Capt. America', 'Big Frisbee', 'Steve Rodgers', 'Stark Tower'),
					('Hawkeye', 'Precise accurate 20/20 eyes', 'Dude Johnson', 'Sanctum Sanctorum');
update avengers set active = false where hero_name = 'Capt. America';
update avengers set active = false where hero_name = 'Hawkeye';
commit; --transaction ends
	
--rollback; 
--until you rollback or commit the transaction, everything you're doing will be blocked
--until you either undo them or successfully finish the transaction

select * from avengers;
--------------------------------------------------------------------------------------------------

					  
--Joins Review
--Remember, joins combine data from two tables

--INNER JOIN (aka natural join)
--returns rows with matching data on in both tables
select * from avengers join homes on home_base = home_base_fk; --inner join is the default join			 
					  
--OUTER JOIN
--return everything from both tables, regardless of matches
select * from avengers full join homes on home_base = home_base_fk;
select * from avengers full outer join homes on home_base = home_base_fk; 

--LEFT OUTER JOIN
--return everything in the left, + matches on the right
select * from avengers left join homes on home_base = home_base_fk;	--pizza joint won't show up!		  
select * from avengers left outer join homes on home_base = home_base_fk;	

--RIGHT OUTER JOIN
--return everything in the right, + matches on the left
select * from avengers right join homes on home_base = home_base_fk; --pizza joint will up!
select * from avengers right outer join homes on home_base = home_base_fk;

--CROSS JOIN 
--Returns the cartesian product (all possible combos) of each table
select * from avengers cross join homes;
select * from avengers, homes;



create table justice_leaguers ( 
	hero_id serial primary key,
	hero_name text,
	hero_power text,
	f_name text,
	l_name text,
	home_base text
);

insert into justice_leaguers (hero_name, hero_power, f_name, l_name home_base) 
				values ('Superman', 'B lister', 'Clark', 'Kent', 'gone'),
					   ('The Flash', 'so fas', 'Barry', 'Allen', 'StarLabs');

					  
--cross joining two unrelated tables will behave similarly
select * from avengers, justice_leaguers;
select * from justice_leaguers, homes;


--------------------------------------------------------------------------------------

--Set Operations
--We use set operations to combine multiple queries
	--Don't confuse them with joins!! (remember joins -> tables, set ops -> queries)

--UNION
--All distinct rows from each query, no duplicates
select home_base_fk from avengers union select home_base from homes;
--there are three unique homes between these two tables
--so only three rows will be returned.

--UNION ALL
--All distinct rows from each query, including duplicates
select home_base_fk from avengers union all select home_base from homes;
--there are only two home bases recorded in the avengers table
--and three home bases recorded in the homes table
--so we get all five with a union all.

--INTERSECT
--Return unique rows found in BOTH queries
select home_base_fk from avengers intersect select home_base from homes;
--Because there's no pizza joint recorded in the avengers table,
--We only get these two homes that are found in both tables

--EXCEPT
--Return unique rows found in the first query that don't appear in the second query
select home_base_fk from avengers except select home_base from homes;
--every home base in avenengers exists in homes
select home_base from homes except select home_base_fk from avengers;
--the pizza joint only exists in the homes table


---------------------------------------------------







