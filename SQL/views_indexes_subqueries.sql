

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

--I want to select the names tracks of the TV Shows and Jazz
select name from track where genre_id in 
	(select genre_id from genre where name in ('TV Shows', 'Jazz'));


--I want to select names of albums with any tracks of the Hip Hop/Rap genre
select title from album where album_id in 
	(select album_id from track where genre_id in 
		(select genre_id from genre where name in ('Hip Hop/Rap')));


--We can also use subqueries after the "from"
--it requires us to use an alias because they're temporary unnamed tables otherwise
(select name from 
	(select * from track) as "Track Name");
--sort of pointless subquery... but educational!


--I want to update all Comedy tracks to be named something dumb
update track set name = 'snickerboodle' where name in 
--running these two queries below will show what will get effected by the update
	(select name from track where genre_id in
		(select genre_id from genre where name = 'Comedy'));


--I want to delete all invoice lines from a particular person

delete from invoice_line where invoice_id in 
--running these two queries below will show what will get effected by the delete
	(select invoice_id from invoice where customer_id = 7);


	
select * from customer;	
select * from invoice where customer_id = 7; --we want to delete Astrid's invoice lines


--------------------------------------------------------------------------

--indexes

--open the public schema dropdown, there are a bunch of indexes that have already been created
--PKs automatically, Fks in the actual script

--let's create an index on track names, something that may be queried often

create index idx_track_name on track(name);


-----------------------

--test

select name || 'yes', unit_price from track;

select distinct(name) from track;

select * from customer where company is not null;





	

	