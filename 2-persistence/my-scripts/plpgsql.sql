/**
 * PL/pgsql
 * Procedural Language extension of PostgreSQL
 *
 *	- NOT a sublanguage of SQL
 *
 *	- Allows devs to create:
 *		> stored functions
 *		> stored proceedures
 *		> triggers
 *		> custom types
 *
 *	- Adds procedural features to the normally
 *	  declarative sql scripts
 *		> loops
 *		> exception handling
 *		> if statements
 *
 *	- Stored Functions (return a value) like:
 *		create [or replace] function [name] (params)
 *		returns [type]
 *		as '
 *			begin
 *				[logic]
 *			end
 *		'
 *		language plpgsql;
 *
 */

-- Let's create some type of multiply
CREATE OR REPLACE FUNCTION multiply(x NUMERIC, y NUMERIC)
RETURNS NUMERIC 
AS $$
	BEGIN 
		RETURN x * y;
	END
$$
LANGUAGE plpgsql;

-- Let's call the function we created
SELECT multiply(5, '2') --plpgsql has Type Coercion

CREATE TABLE colors(
	id SERIAL PRIMARY KEY,
	color VARCHAR
);

CREATE TABLE sizes(
	id SERIAL PRIMARY KEY,
	size_desc VARCHAR
);

INSERT INTO sizes (size_desc)
	VALUES ('S'), ('M'), ('L');
	
INSERT INTO colors (color)
	VALUES ('red'), ('orange'), ('yellow'), 
		('green'), ('blue'), ('indigo'), ('violet');
		
	
-- Define a function to occur when an event happens
-- Specifically: prevent purple from being inserted into the color table
CREATE OR REPLACE FUNCTION no_more_purple()
RETURNS TRIGGER 

AS $$
	BEGIN 
		IF(NEW.color = 'purple') THEN 
				--Maybe decrease the sequence so it doesn't always increment the ID
			RETURN NULL;
		END IF; -- IF THE ABOVE CLAUSE IS TRUE, THEN WE RETURN NULL
		
		RETURN NEW; --IF the NEW color IS NOT purple then we ADD it
	END
$$
LANGUAGE plpgsql;


-- We have to define the trigger that would invoke the function. 
-- When does the function occur?
CREATE TRIGGER no_purple
	BEFORE INSERT OR UPDATE ON colors 
	FOR EACH ROW
	EXECUTE FUNCTION no_more_purple();
	

SELECT * FROM colors;
INSERT INTO colors (color) VALUES ('magenta'); --VALID insert
INSERT INTO colors (color) VALUES ('purple'); --INVALID insert (NOT inserted into the color table)

UPDATE color SET color = 'purple' WHERE id = 2;


EXPLAIN SELECT * FROM colors WHERE color = 'magenta';

CREATE INDEX fast_colors
	ON colors(color);
	
-- After creating an index, we're able to fetch color values faster
EXPLAIN SELECT * FROM colors WHERE color = 'magenta';

-- Indexes are pointers that represent the physical address of data.
-- Indexes are only created on columns of a table
-- Unique or primary key columns are automatically made to be indexed.