--create some homes
INSERT INTO home (homename, city, staddr, state, zip) 
VALUES ('Asgard', 'Norfolk', '123 yes street', 'VA', '22151');

INSERT INTO home (homename, city, staddr, state, zip) 
VALUES ('Box', 'Norfolk', '123 yes street', 'VA', '22151');

--create some avengers
INSERT INTO avenger (av_name, av_power, first_name, last_name, power_level, homename)
VALUES ('Thor', 'Hammer Time', 'Thor', 'Odinson', 2, 'Asgard');

INSERT INTO avenger (av_name, av_power, first_name, last_name, power_level, homename)
VALUES ('Hulk', 'Stronk', 'Bruce', 'Banner', 4, 'Box');

--won't really worry about teams for this, we just want to get the "get all avengers" functionality