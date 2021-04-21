

--some views based on the chinook script


--We haven't talked about subqueries yet, 
--but this is a good chance to see how views simplify your querying experience


create view acdc_songs as 
	(select * from Track where album_id in 
		(select album_id from album where artist_id in 
			(select artist_id from artist where name like 'AC/DC')));

select * from acdc_songs;

create view aerosmith_songs as 
	(select * from Track where album_id in 
		(select album_id from album where artist_id in 
			(select artist_id from artist where name like 'Aerosmith')));
	
select * from aerosmith_songs;

--drop view aerosmith_songs;

--every time you run the view, it runs the query. 

--you can join views like you join tables!!

------------------------------------------------------------------------------------

--messing around with some subqueries


--I want to select all tracks of the Metal and Jazz genres
select name from track where genre_id in
	(select genre_id from genre where name in ('Metal', 'Jazz'));

--I want to select all albums that have any Classical tracks in them
select title from album where album_id in
	(select album_id from track where genre_id =
		(select genre_id from genre where name = 'Classical'));

--we can also use subqueries after the "from" 	
--it requires us to use an alias
(select name as "Track Names" from 
	(select * from track) as "Track Info");
--pointless subquery... but educational!
	


--I want to update all Comedy tracks to be named something dumb

update track set name = "bogagog" where name in 
--if we run these two tracks alone, we can see what will get updated
	(select name from track where genre_id in
		(select genre_id from genre where name = 'Comedy'));



--I want to delete all invoice lines from some particular person

delete from invoice_line where invoice_id in 
--if we were to just run these two lines alone, we can see what will get deleted
	(select invoice_id from invoice where customer_id = 
		(select customer_id from customer where first_name = 'Astrid')); 



select * from customer;
select * from invoice where customer_id = 7;
---------------------------------------------------------------

--indexes

--open the public schema dropdown, there are probably a bunch of indexes already

--show them how many indexes already exist and maybe even look through the script (ctrl + f)
--good learning opportunity in the foreign keys indexes

--let's create an index on track names, something that may be queried often
create index idx_track_name on track (name);


		