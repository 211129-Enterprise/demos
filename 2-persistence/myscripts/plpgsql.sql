/**
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
 * 
 	create [or replace] function [name] (params)
 	returns [type]
 	as '
 		begin
 			[logic]
 		end
 	'
 	language plgpsql;
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

SELECT multiply(5, '2'); -- plpgsql has TYPE coercion

DROP TABLE sizes CASCADE;
DROP TABLE colors CASCADE;
CREATE TABLE colors (
	id SERIAL PRIMARY KEY,
	color VARCHAR
);

CREATE TABLE sizes (
	id SERIAL PRIMARY KEY,
	size_desc VARCHAR
);

INSERT INTO sizes(size_desc)
	VALUES ('S'), ('M'), ('L');
	
INSERT INTO colors (color)
	VALUES ('red'), ('orange'), ('yellow');

-- I'm going to define a function to occur when an event happens
-- We will prevent blues from being inserted into the color table
CREATE OR REPLACE FUNCTION no_more_blues()
RETURNS TRIGGER

AS $$
	BEGIN 
		IF(NEW.color = 'blue') THEN
			RETURN NULL;
		END IF; -- IF the Above clause IS TRUE, THEN we RETURN null
		
		RETURN NEW; -- IF NEW color IS NOT blue, ADD it
	END
	
$$
LANGUAGE plpgsql;

-- we have to define the trigger that would invoke the function. When does the function occur?
CREATE TRIGGER no_blue
	BEFORE INSERT OR UPDATE ON colors 
	FOR EACH ROW
	EXECUTE FUNCTION no_more_blues();

SELECT * FROM colors;
SELECT * FROM sizes;

INSERT INTO colors (color) VALUES ('magenta'), ('blue');

UPDATE colors SET color = 'blue' WHERE id = 2;

EXPLAIN SELECT * FROM colors WHERE color = 'magenta';

CREATE INDEX fast_colors 
	ON colors(color);

-- after creating aan index we're able to fetch a color value faster
-- indexes are pointers that represent the physical address of data.
-- Indexes are only created on columns of a table
-- unique or primary key columns automatically create indexes

-- https://www.postgresqltutorial.com/postgresql-indexes/postgresql-create-index/