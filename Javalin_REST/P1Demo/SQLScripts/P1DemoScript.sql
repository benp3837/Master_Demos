CREATE TABLE homes (
	home_name VARCHAR(30) PRIMARY KEY, --home_name can be the FK since they'll always be unique
	home_address VARCHAR(60),
	home_city VARCHAR(30),
	home_state VARCHAR(2),
	home_zip VARCHAR(5)
);

CREATE TABLE avengers (
	av_id SERIAL PRIMARY KEY,
	av_name VARCHAR(30),
	av_power VARCHAR(60),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	power_level INTEGER,
	home_fk VARCHAR(30) REFERENCES homes(home_name)
);

INSERT INTO homes (home_name, home_address, home_city, home_state, home_zip)
	VALUES ('Valhalla', '123 Rainbow Way', 'Valhalla', 'BH', '99999'),
	('Stark Tower', '1 Tony Stark Drive', 'New York', 'NY', '10005'),
	('Caps Appartment', '456 Prescott St. Apt 45', 'Brooklyn', 'NY', '11211');
	
INSERT INTO avengers (av_name, av_power, first_name, last_name, power_level, home_fk)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve', 'Rogers', 20, 'Caps Appartment'),
	('Iron Man', 'Money-Good looks-Intelligence', 'Tony', 'Stark', 13, 'Stark Tower'),
	('Hulk', 'Very in touch with his emotions', 'Bruce', 'Banner', 999, 'Stark Tower'),
	('Thor', 'Maybe hes born with it, mayber its Maybelline', 'Thor', 'Odinson', 33, 'Valhalla');