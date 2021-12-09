CREATE TABLE one (

	col_one INTEGER PRIMARY KEY,
	col_two INTEGER

);


CREATE TABLE two (

	col_one INTEGER PRIMARY KEY,
	col_two INTEGER

);




INSERT INTO one VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5);
INSERT INTO two VALUES (1, 100), (2, 200), (3, 300), (4, 400), (5, 500);

-- SET operations are a type of DQL, Data Query Language, in which we can
-- combine data from two different tables into one result.
--
-- The UNION operator will combine results from two tables together and
-- will exclude duplicates.
--
-- SET operations only operate on results that have the same number and
-- type of columns.

SELECT * FROM one UNION SELECT * FROM two;

-- UNION ALL - Allows duplicates
-- For Example: SELECT * FROM one UNION ALL SELECT * FROM two;



-- INTERSECT is a set operation that includes only the matching results from tables
SELECT * FROM one INTERSECT SELECT * FROM two;



-- Scalar and aggregate functions in SQL 

-- SCALAR functions perform one action to each value within a table and return it
SELECT UPPER(username), pwd FROM users;
-- Lower... research allthe built in scalar functions within postgres

-- AGGREGATE functions operate on an entire column and produce one output.
-- max, avg, sum, count, etc
SELECT MAX(col_two) FROM two;
SELECT AVG(col_one) FROM two;
SELECT COUNT(col_one) FROM two;
SELECT COUNT(col_one) FROM two; -- RETURNS the amount OF ROWS IN that COLUMN OF a TABLE

SELECT AVG(LENGTH(username)) FROM users;