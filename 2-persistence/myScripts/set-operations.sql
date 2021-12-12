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
	

-- set operations

-- SET operations ONLY operate on results that have the same number and type of columns

-- SET operators do not include duplicates EXCEPT FOR UNION ALL 

SELECT * FROM one UNION SELECT * FROM two;
	
-- INCLUDES DUPS
SELECT * FROM one UNION ALL SELECT * FROM two;


-- INTERSECT IS A SET OPERATION that includes only the matching results from the tables

SELECT * FROM one INTERSECT SELECT * FROM two;

-- scalar function and aggregate functions in SQL

/*
scalar functions perform one action to each value within a table and return
*/

SELECT UPPER(username) FROM users;

-- AGGREGATE functions

-- operate on an entire column and produce one OUTPUT 

-- max average sum count.....

SELECT MAX(col_one) FROM two;

