CREATE TABLE one (

	col_one INTEGER PRIMARY KEY,
	col_two INTEGER
);

CREATE TABLE two (

	col_one INTEGER PRIMARY KEY,
	col_two INTEGER
);

INSERT INTO one VALUES (1, 1), (2, 2), (3, 3), (4, 4);
INSERT INTO two VALUES (1, 100), (2, 200), (3, 300), (4, 400);

INSERT INTO one VALUES (5,5);
INSERT INTO two VALUES (5,5);

/* 
 * SET operations are a type of DQL in which we can combine data from 2 different tables in one result
 * 
 * Union operator will combine all results together and exclude duplicates
 * SET operations only operate on results that have the same number and type of columns
 */

SELECT * FROM one UNION SELECT * FROM two;

-- UNION ALL -- allows duplicates

SELECT * FROM one UNION ALL SELECT * FROM two;

-- INTERSECT is a set operation that includes only the matching results from tables
SELECT * FROM one INTERSECT SELECT * FROM two;

-- Scalar Function and Aggregate functions in SQL

/**
 * Scalar functions perform one action to each value within a table and return
 * LOWER, research all the scalar functions in postgres
 */
SELECT UPPER(username), pwd FROM users;

-- Aggregate functions - operate on an entire column and produce one OUTPUT 
-- max, avg, sum, count

SELECT MAX(col_two) FROM two;
SELECT AVG(col_one) FROM two;
SELECT COUNT(col_one)FROM two; -- RETURNS the amount OF ROWS IN that COLUMN OF a TABLE

SELECT avg(length(username)) FROM users;