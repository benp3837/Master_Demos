-- This demo will show 1st-3rd Normal Form as well as joins.


/* 1st NORMAL FORM (we don't want this)
 * 
 * Rules:
 * 1) Tables must have primary keys (can be a composite key - PK made up of multiple columns)
 * 2) Columns must be atomic (columns must hold the smallest pieces of data possible)
 */


create table videogames(
	--notice no INTEGER autoincrement PK
	name VARCHAR(20), --names can be up to 20 chars
	genre text,
	release_year int,
	developer text,
	developer_hq text,
	developer_size int,
	PRIMARY KEY(name, developer) --composite key. weird. don't do this outisde of a join table
);

insert into videogames(name, genre, release_year, developer, developer_hq, developer_size)
values ('silksong', 'platformer', 2025, 'Team Cherry', 'AUS', 3),
	   ('hollow knight', 'platformer', 2017, 'Team Cherry', 'AUS', 3),
	   ('baldur''s gate', 'D&D for babies', 2023, 'Larian', 'BEL', 500),
	   ('balatro', 'roguelite', 2024, 'LocalThunk', 'CAN', 1);
	  
	  
 select * from videogames;
	   
	  

/* 2nd NORMAL FORM (better, but we still don't want this)
 * 
 * Rules:
 * 1) Be in 1NF (all the same rules from 1NF)
 * 2) Remove partial dependencies (When columns depend on PART of the PK)
 * 	  -Easiest way to avoid partial dependencies is to have single PK
 */
	  
	  
drop table videogames;
	  
	  

create table videogames(
	game_id INTEGER PRIMARY KEY AUTOINCREMENT,
	name VARCHAR(20), --names can be up to 20 chars
	genre text,
	release_year int,
	developer text,
	developer_hq text,
	developer_size int
);

insert into videogames(name, genre, release_year, developer, developer_hq, developer_size)
values ('silksong', 'platformer', 2025, 'Team Cherry', 'AUS', 3),
	   ('hollow knight', 'platformer', 2017, 'Team Cherry', 'AUS', 3),
	   ('baldur''s gate', 'D&D for babies', 2023, 'Larian', 'BEL', 500),
	   ('balatro', 'roguelite', 2024, 'LocalThunk', 'CAN', 1);
	  
	  
 select * from videogames;
	  


/* 3rd NORMAL FORM (this is the goal!)
 * 
 * Rules:
 * 1) Be in 2NF
 * 2) Remove Transitive Dependencies (tables must have a SINGLE RESPONSIBILITY)
 * 	  -Split up your data into separate tables as needed, and just link them with a FK
 */

drop table videogames;


create table developers(
	dev_id INTEGER PRIMARY KEY AUTOINCREMENT,
	developer text,
	developer_hq text,
	developer_size int
);


create table videogames(
	game_id INTEGER PRIMARY KEY AUTOINCREMENT,
	name VARCHAR(20), --names can be up to 20 chars
	genre text,
	release_year int,
	dev_id_fk int,
	FOREIGN KEY(dev_id_fk) REFERENCES developers(dev_id)
);


insert into developers(developer, developer_hq, developer_size)
values ('Team Cherry', 'AUS', 3),
	   ('Larian', 'BEL', 500),
	   ('LocalThunk', 'CAN', 1),
	   ('Ben', 'VA', 1);

insert into videogames(name, genre, release_year, dev_id_fk)
values ('silksong', 'platformer', 2025, 1),
	   ('hollow knight', 'platformer', 2017, 1),
	   ('baldur''s gate', 'D&D for babies', 2023, 2),
	   ('balatro', 'roguelite', 2024, 3);
	  --no games belong to Ben :(
	  
	  
-- one more insert of a game that has no developer (this will help demo joins)
insert into videogames(name, genre, release_year, dev_id_fk)
values ('The Concept of a Game that hasn''t been made yet', 'dunno yet', 2028, null);
	  
 select * from videogames;
 

--------------------------------------------------------------------------------------------
--JOINS: A Query (select) technique that lets us SELECT from MULTIPLE RELATED TABLES at once
--------------------------------------------------------------------------------------------


--INNER JOIN - Gives us ALL RECORDS from both tables, as long as there is a matching FK/PK
SELECT * FROM videogames v INNER JOIN developers d ON v.dev_id_fk  = d.dev_id; 
--Notice no Ben :( He has no games that belong to him, so he won't show up in this query


--LEFT JOIN - Gives us ALL RECORDS from the LEFT table, and only matching records from the right
SELECT * FROM videogames v LEFT JOIN developers d ON v.dev_id_fk  = d.dev_id; 
--"Left" vs "Right" just refers to the table's position around the join syntax


--RIGHT JOIN - Gives us ALL RECORDS from the RIGHT table, and only matching records from the left
SELECT * FROM videogames v RIGHT JOIN developers d ON v.dev_id_fk  = d.dev_id; 


--OUTER JOIN - Gives us all records period
SELECT * FROM videogames v FULL OUTER JOIN developers d ON v.dev_id_fk  = d.dev_id; 


--CROSS JOIN - Cartesian product of both tables (all possible ordered pairs)
SELECT * FROM videogames v CROSS JOIN developers d; --NO "ON" KEYWORD! No filtration




-------------------------------------------
-- TRANSACTIONS - a group of commands that MUST execute together and succeed together.
-- If one command fails, all of the commands fail. 
	--This is good for maintaining integrity of data of making sure longer command sequences don't end half finished
-------------------------------------------

--Let's alter developers to have a games_released column
ALTER TABLE developers add column games_developed int;

select * from developers;


--Transaction below (NOTE: TCL commands - transaction, start, commit)
-- 1 insert that prompts one update. Must happen together!

--very hardcode-y, realistically this transaction may be in a custom function etc.
BEGIN TRANSACTION;

INSERT INTO videogames (name, genre, release_year, dev_id_fk)
values ('solitaire', 'card', 1783, 3);

UPDATE developers SET games_developed = games_developed + 1
where dev_id = 3;

COMMIT; --"save" in other words, kinda like git commit


select * from videogames;
select * from developers;




INSERT INTO videogames (name, genre, release_year, dev_id_fk)
values ('solitaire', 'card', 1783, 3);

UPDATE developers SET games_developed = 1
where dev_id = 3;
