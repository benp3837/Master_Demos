-- ==========================================
-- CREATE TABLE
-- ==========================================

CREATE TABLE snacks (
    snack_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE,
    calories INTEGER NOT NULL CHECK (calories > 0),
    flavor VARCHAR(10)
);


-- ==========================================
-- INSERT DATA
-- ==========================================

INSERT INTO snacks (name, calories, flavor)
VALUES ('Pretzels', 110, 'salty');

INSERT INTO snacks (name, calories, flavor)
VALUES ('Apple', 95, 'sweet');

INSERT INTO snacks (name, calories, flavor)
VALUES ('Popcorn', 150, 'butter');

INSERT INTO snacks (name, calories, flavor)
VALUES ('Carrots', 50, NULL);

INSERT INTO snacks (name, calories, flavor)
VALUES ('Trail Mix', 200, 'nutty');


-- ==========================================
-- DQL QUERIES
-- ==========================================

-- Select all snacks
SELECT * FROM snacks;

-- Select all snacks with flavor = sweet
SELECT *
FROM snacks
WHERE flavor = 'sweet';

-- Select snacks with more than 100 calories
SELECT *
FROM snacks
WHERE calories > 100;

-- Select only snack names alphabetically
SELECT name
FROM snacks
ORDER BY name ASC;

-- Select first record in table
SELECT *
FROM snacks
ORDER BY snack_id ASC
LIMIT 1;

-- Select snack with highest calories
SELECT *
FROM snacks
ORDER BY calories DESC
LIMIT 1;

-- Sum of all calories
SELECT SUM(calories) AS calorie_sum
FROM snacks;

-- Average calories
SELECT AVG(calories) AS calorie_average
FROM snacks;

-- Count snacks by flavor
SELECT flavor,
       COUNT(*) AS snack_count
FROM snacks
GROUP BY flavor;


-- ==========================================
-- BONUS
-- ==========================================

-- Snacks with calories greater than average
SELECT *
FROM snacks
WHERE calories > (
    SELECT AVG(calories)
    FROM snacks
);

-- Rename one snack
UPDATE snacks
SET name = 'dubai chocolate Popcorn'
WHERE name = 'Popcorn';

-- Add portability column
ALTER TABLE snacks
ADD COLUMN is_portable INTEGER;

-- Optional updates for portability
UPDATE snacks
SET is_portable = 1
WHERE name IN ('Pretzels', 'Apple', 'Trail Mix');

UPDATE snacks
SET is_portable = 0
WHERE name IN ('Carrots', 'dubai chocolate Popcorn');

-- View final table
SELECT * FROM snacks;