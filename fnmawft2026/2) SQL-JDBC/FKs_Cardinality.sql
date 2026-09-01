--Table for Brands
create table brands(
	brand_id INTEGER PRIMARY KEY AUTOINCREMENT,
	brand_name text
);


--Table for Snacks (Snacks belong to a certain Brand)
create table snacks(
	snack_id INTEGER PRIMARY KEY AUTOINCREMENT,
	snack_name text,
	snack_flavor text,
	brand_id_fk INTEGER,
	CONSTRAINT brand_id_fk FOREIGN KEY (brand_id_fk) REFERENCES brands(brand_id)
);

---------------------------------------------------------------------------------------
--This is a ONE-TO-MANY RELATIONSHIP (one brand can have many snacks that belong to it)
---------------------------------------------------------------------------------------

--Your Loan app DB will be, AT MINIMUM, a table of users, and a table of loans that each belong to one user


-- Insert into Brands
insert into brands(brand_name)
values ('Nestle'), ('Kellogs'), ('General Mills');


-- Insert into Snacks
insert into snacks(snack_name, snack_flavor, brand_id_fk)
values ('KitKat', 'Sweet', 1), ('Rolo', 'Sweet', 1), ('Frosted Flakes', 'Sweet', 2);

--Inserting a snack with a FK that points to a PK that doesn't exist
insert into snacks(snack_name, snack_flavor, brand_id_fk)
values ('Tomato in my Garden', 'Sweet', 0);
--THIS WORKS??? But only in SQLite. SQLite doesn't adhere to the typical rules of SQL 
--(It has less referential integrity than other dialects. Check the notes on that!)


select * from brands;
select * from snacks;


-----------------------------------------------------------------------------------------
-- Let's see a Many to Many relationship (most real world relationships are many-to-many)
-----------------------------------------------------------------------------------------

-- Here's a new table called ingredients - many ingredients can be in many snacks.

--ingredients doesn't have a DIRECT relationship to snacks (no FK to snacks here)
CREATE TABLE ingredients (
    ingredient_id INTEGER PRIMARY KEY AUTOINCREMENT,
    ingredient_name TEXT NOT NULL UNIQUE
);


--insert some ingredients (note there's overlap between the snacks these belong to)
insert into ingredients(ingredient_name)
values ('milk chocolate'), ('sugar'), ('corn');

select * from ingredients;


-- Every many to many relationship needs a JOIN table
-- This table connects the two tables in the Many to Many

-- This is a table of JUST primary keys and foreign keys. Note the multi-column primary key
CREATE TABLE snack_ingredients (
    snack_id_fk INTEGER,
    ingredient_id_fk INTEGER,
    PRIMARY KEY (snack_id_fk, ingredient_id_fk), --composite key - PK made up of multiple columns
    FOREIGN KEY (snack_id_fk)
        REFERENCES snacks(snack_id),
    FOREIGN KEY (ingredient_id_fk)
        REFERENCES ingredients(ingredient_id)
);


--insert into the JOIN table (THIS is how we track relationships in a Many to Many)
insert into snack_ingredients (snack_id_fk, ingredient_id_fk)
values(1, 1), (2, 1), (1, 2), (2, 2), (3, 2), (3, 3); 


select * from snack_ingredients; --MANY ingredients can belong to MANY snacks



--------------------------------------------------------------------
-- Finally, a One to One relationship - rarer type of relationship. 
--ONE record in table A belongs to only one record in table B
-------------------------------------------------------------------

--basic table for users, and user_badges
create table users (
	user_id INTEGER PRIMARY KEY AUTOINCREMENT,
	user_name TEXT
);

create table user_badges(
	badge_id INTEGER PRIMARY KEY AUTOINCREMENT,
	user_id_fk INTEGER UNIQUE, --easiest way to make 1-1 relationship: unique FKs
	FOREIGN KEY (user_id_fk) REFERENCES users(user_id)
);








