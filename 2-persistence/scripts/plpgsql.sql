/*
 * PL/pgsql - Procedural Language Extension of PostgreSQL 
 * 
 * - NOT a sublanguage of SQL
 * - Allows devs to create:
 * 		- stored functions
 * 		- stored procedures
 * 		- triggers
 * 		- custom types
 * 
 * - Adds procedural features to the normally declarative sql scripts
 * 		- loops
 * 		- exception handling
 * 		- if statements
 * 
 * Stored Functions (return a value)

		create [or replace] function [name] (params)
		returns [type]
		as '
			begin
				[logic]
			end
		'
		language plpgsql;
 */

-- let's create some type of multiply 
CREATE OR REPLACE FUNCTION multiply(x NUMERIC, y NUMERIC) 
RETURNS NUMERIC
AS $$

	BEGIN
		
		RETURN x * y;
		
	END
$$
LANGUAGE plpgsql;


SELECT multiply(5, '2') -- plpgsql has TYPE coercion!


CREATE TABLE colors(
	id SERIAL PRIMARY KEY,
	color VARCHAR 
);

CREATE TABLE sizes (

	id SERIAL PRIMARY KEY,
	size_desc VARCHAR
	
);

INSERT INTO sizes (size_desc)
	VALUES ('S'), ('M'), ('L');

INSERT INTO colors (color)
	VALUES ('red'), ('orange'), ('yellow');

-- I'm going to define a function t  occure when an event happens
-- we will prevent blues from benig inserted into the color table
CREATE OR REPLACE FUNCTION no_more_blues()
RETURNS TRIGGER

AS $$
	BEGIN 
		IF(NEW.color ='blue') THEN
		-- maybe decrease the sequence by one
		
		RETURN NULL;
	
		-- LIKE A } IN JAVA
		END IF; -- IF THE ABOVE CLAUSE IS TRUE, THEN WE RETURN NULL
	
	
		RETURN NEW; -- IF THE NEW COLOR IS *NOT* BLUE, ADD IT
	END

$$
LANGUAGE plpgsql;

-- we have to define the trigger that would invoke that function. When does the function occur?
CREATE TRIGGER no_blue 
	BEFORE INSERT OR UPDATE ON colors 
	FOR EACH ROW 
	EXECUTE FUNCTION no_more_blues();

SELECT * FROM colors;

INSERT INTO colors (color) VALUES ('magenta');
INSERT INTO colors (color) VALUES ('blue');

UPDATE colors SET color = 'blue' WHERE id = 2;

EXPLAIN SELECT * FROM colors WHERE color = 'magenta';
	
CREATE INDEX fast_colors
	ON colors(color);

-- after creating an index we're able to fetch a color value faster
-- INDEXes are POINTERS that represent the physical address of data.
-- INDEXes are only created on columns of a table
-- UNIQUE or PRIMARY KEY columns automatically create indexes

-- https://www.postgresqltutorial.com/postgresql-indexes/postgresql-create-index/












