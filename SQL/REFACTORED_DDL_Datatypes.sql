--Feel free to follow along on today's demos, but I'll also just post them in discord later
--Don't have too much time to troubleshoot, missed a whole day
--But if you just pay attention you should be fine

--Data Definition Language (DDL): create, alter, truncate, drop
--DDL is any command related to building the structure of your data
--It doesn't deal directly with the data


create table users( --create will CREATE your tables (you can also create schemas and databases)
	username text
);

alter table users add user_age int; --alter lets you change the columns of a table
--in this case we added a column for user_age

drop table users; --drop delete a table

--not shown: truncate - drops all RECORDS in a table

--very rudimentary table, they're usually more complicated but this was just a quick DDL runthrough

---------------------------------------------------------------------------------------------------

--let's talk datatypes, anybody know some types?


--this is a horribly designed table (no PK, not patricularly normalized)
--we won't use it, it's just to list out some datatypes

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











