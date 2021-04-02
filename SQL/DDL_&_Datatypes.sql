--Data Definition Language (DDL): create, alter, truncate, drop
--let's create our first table using the create keyword
--in Postgres, everything defaults to lowercase, unless you use double quotes

/*create table users(
	"USERNAME" text
); 

alter table users add user_age int;

drop table users;*/ --ctrl + shift + backslash

--Not seen: truncate - drops all RECORDS in a table (we added no records here)
--Syntax: truncate table table_name

--this is a very rudimentary table, it's a bit more complicated than this usually
-----------------------------------------------------
--We'll do a more in depth demo using sublanguages later

--Now let's talk about datatypes. Anybody know some types?

--We won't actually use this table but it's good for practice :p
create table datatypes (
	numbers_small int2 check (numbers_small < 100),
	numbers_normal int,
	numbers_also_normal int4,
	numbers_large int8,
	standard_number decimal(10, 2), --2 parameters: #total digits, #decimals
	
	"boolean" boolean, --double quotes lets you use assign keywords to things
	
	fixed_length_text char(10), --will be 10 characters, not best practice
	variable_length_text varchar(10), --from 0-10 characters, ok practice
	unlimited_length_text text, --best practice, unlimited length
	
	"date" date, --YYYY-MM-DD
	"timestamp" timestamp --YYYY-MM-DD HH-MM-SS
	
	--This is NOT all of the datatypes. There are so many.
	--But... most of the time data is just gonna be numbers and text.
);



