------------------
-- One-to-Many and Joins
------------------

CREATE TABLE apartments (
    apartment_id INTEGER PRIMARY KEY,
    unit_number TEXT NOT NULL
);

CREATE TABLE tenants (
    tenant_id INTEGER PRIMARY KEY,
    tenant_name TEXT NOT NULL,
    apartment_id_fk INTEGER NOT NULL,
    FOREIGN KEY (apartment_id_fk) REFERENCES apartments(apartment_id)
);

INSERT INTO apartments (apartment_id, unit_number)
VALUES
(1, '32432'),
(2, '23434'),
(3, '23532');


INSERT INTO tenants (tenant_id, tenant_name, apartment_id_fk)
VALUES
(1, 'Finn', 1),
(2, 'Jake', 1),
(3, 'BMO', 2);


SELECT * FROM tenants t INNER JOIN apartments a ON t.apartment_id_fk = a.apartment_id;

SELECT t.tenant_name, a.unit_number FROM tenants t INNER JOIN apartments a ON t.apartment_id_fk = a.apartment_id;

SELECT a.unit_number, t.tenant_name FROM apartments a LEFT JOIN tenants t ON a.apartment_id = t.apartment_id_fk;


------------------
-- Many-to-Many and Joins
----------------------

CREATE TABLE fans (
    fan_id INTEGER PRIMARY KEY,
    fan_name TEXT NOT NULL
);

CREATE TABLE teams (
    team_id INTEGER PRIMARY KEY,
    sport TEXT NOT NULL
);

CREATE TABLE fan_team (
    fan_id_fk INTEGER,
    team_id_fk INTEGER,
    PRIMARY KEY (fan_id_fk, team_id_fk),
	FOREIGN KEY (fan_id_fk) REFERENCES fans(fan_id),
 	FOREIGN KEY (team_id_fk) REFERENCES teams(team_id)
);


INSERT INTO fans (fan_id, fan_name)
VALUES
(1, 'My dad'),
(2, 'My uncle'),
(3, 'Cousin Mike');

INSERT INTO teams (team_id, sport)
VALUES
(1, 'Sumo'),
(2, 'Underwater Sumo'),
(3, 'Skydiving Sumo');


--remember how I said this data on its own isn't super readable. this is where joins are especially important for Reads
INSERT INTO fan_team (fan_id_fk, team_id_fk)
VALUES
(1, 1), 
(1, 2), 
(2, 1), 
(2, 3), 
(3, 2); 


--2 joins in one query. crazy stuff
SELECT f.fan_name, t.sport FROM fans f
INNER JOIN fan_team ft ON f.fan_id = ft.fan_id_fk
INNER JOIN teams t ON ft.team_id_fk = t.team_id;










