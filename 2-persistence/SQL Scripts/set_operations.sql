--Set operations are a type of DQL in which we combine data from 2 different tables in one result

CREATE TABLE one (
column_one INTEGER  PRIMARY KEY,
column_two INTEGER 
);

CREATE TABLE two (
column_one INTEGER PRIMARY KEY,
column_two INTEGER
);

INSERT INTO one (column_one, column_two)
	VALUES (1, 100),
			(2, 200),
			(3, 300),
			(4, 400);

INSERT INTO two (column_one, column_two)
	VALUES (1, 400),
			(2, 300),
			(3, 200),
			(4, 100);
		
--The UNION operator will combine reults from two tables together and exclude duplicates
--Set operations only operate on results that have the same number and type of coulmns
		
SELECT * FROM one UNION SELECT * FROM two;

--The INTERSECT operator will include only matching results
SELECT * FROM one INTERSECT SELECT * FROM two;

--Scalar functions perform one function to each value within a table and RETURN 

--AGGREGATE functions operate on an entire column and produce one RESULT 
SELECT MAX(column_two) FROM two;
SELECT AVG(column_two) FROM two;
SELECT SUM(column_two) FROM two;

