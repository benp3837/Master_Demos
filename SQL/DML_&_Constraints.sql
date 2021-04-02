create schema dawg_pound; --create a new schema
set schema 'dawg_pound'; --assign this script to the newly created schema

--let's create two tables that are related to each other (using PK/FK)


--owner table
create table Owners(
	owner_id serial primary key, --serial is an auto incrementing int4, 
							   --don't need to input a value for it. Convenient!
	owner_name text not null
);

--dog table
create table Dogs(
	dog_id serial primary key, 
	name text,
	breed text,
	age int not null check (age > 1), 
	weight decimal(5, 2) not null,
	owner_id int references Owners (owner_id)
);

--Since the dogs table has a refence to the owner table, there's a relationship
--In this case, one owner can have many dogs. A "one to many" relationship. 
--we'll talk about cardinality later. (one-to-one, one-to-many, many-to-many)

--What if I want to drop the owner table? 
--It's a problem because the dogs table depends on it currently

--Cascade!! Which we'll talk more about later but for now just know what it does

------------------------------------------

--Now let's use some Data Manipulation Language (DML): Select, Insert, Update, Delete

--INSERT some owners into the owner table, and dogs into the dogs table.
--after each insert, use SELECT to show that the tables have been populated

--write out the insert then explain the parts
insert into owners (owner_name) values ('Ben'), ('Gus'), ('Scotty'), ('Nancy');

select * from owners; --returns all the owner records (rows) we just created

insert into dogs (name, breed, age, weight, owner_id)
			values ('Fido', 'Lab', 12, 70.5, 2),
				   ('Sparky', 'Yorkie', 5, 15.0, 1),
				   ('Sammie', 'Beagle', 10, 20.4, 3),
				   ('Spud', 'Dachsund', 2, 12.25, 3);

select * from dogs; --returns all the dog records (rows) we just created

--We can also select data from specific columns instead of the entire table

select name from dogs; --returns all our dog names

select weight, age from dogs; --returns the dogs weights and ages

select name, owner_id from dogs; --returns the names and owner_id of dogs


--Let's explore the WHERE clause, which lets us filter the data we select
--There are lots of operators we can use, all of which filter data differently

--dogs who are Yorkies (=)
select * from dogs where breed = 'Yorkie';
--dogs who aren't Yorkies (!=)
select * from dogs where breed != 'Yorkie';

--dogs younger than 3 (<)
select * from dogs where age < 3;

--dogs names starting with S (like) (%)
select * from dogs where name like 'S%';
--dog names ending in o (like) (%)
select * from dogs where name like '%o';

--dogs who weigh 10-30 pounds (between) (and)
select * from dogs where weight between 10 and 30;

--dogs who are Beagles or Dachsunds (or) (in)
select * from dogs where breed = 'Beagle' or breed = 'Dachsund';
select * from dogs where breed in ('Beagle', 'Dachsund'); 

--dogs who are NOT Beagles (not in)
select * from dogs where breed not in ('Beagle');

--there are other operators you can use, I'll list them in the notes

--Also important is the ORDER BY keyword, which lets us order our selected data

select * from dogs order by age; --ascending by default, but can also specify

select * from dogs order by weight desc;

select name from dogs order by name asc;


--We can also UPDATE values in our tables
--Be careful!! You should ALWAYS use a where clause, or else every row will change

--update Sparky's age to 6
update dogs set age = 6 where name = 'Sparky'; --happy birthday!

--update Spud's name to "Spudwick" **5 minute challenge before a break etc.
--try to use a column besides name after the where clause
update dogs set name = 'Spudwick' where dog_id = 4;

--Finally we can DELETE rows. I usually don't use this, it can be dangerous
--Especially if a table has a relationship with another, it can mess stuff up
--Like with update, remember to always use the where clause, or everything will go.

--delete from dogs where name = 'Fido';