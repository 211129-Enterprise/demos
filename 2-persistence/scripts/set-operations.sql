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

-- SET operations are a type of DQL in which we can combine dat from 2 diff tables
-- in one result


-- the UNION operator will combine results from 2 tables together and exclude duplicates
-- SET operations ONLY operate on results that have the same number and type of columns

SELECT * FROM one UNION SELECT * FROM two;

-- UNION ALL -- that allows duplicates
SELECT * FROM one UNION ALL SELECT * FROM two;


-- INTERSECT IS a set  OPERATION that includes only the matchin results from tables
SELECT * FROM one INTERSECT SELECT * FROM two;

-- Scalar Function and Aggregate functions in SQL

/**
 * Scalar functions perform one action to EACH value within a table and return
 */
SELECT UPPER(username), pwd FROM users;
-- Lower... research all the built in scalar functions within postgres


-- AGGREGATE functions
-- operate on an entire column and produce 1 output
-- max, avg, sum, count.....

SELECT MAX(col_two) FROM two;
SELECT AVG(col_one) FROM two;
SELECT COUNT(col_one) FROM two; -- RETURNS the amount of ROWS IN that COLUMN OF a TABLE

SELECT AVG(LENGTH(username)) FROM users;













