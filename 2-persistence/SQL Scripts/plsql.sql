CREATE OR REPLACE FUNCTION multiply (x NUMERIC, y NUMERIC)
RETURNS NUMERIC 
AS $$
	BEGIN
		
		RETURN x * y;
		
	END
$$
LANGUAGE plpgsql;
	
SELECT multiply(5, '10') --plpgsql has TYPE CONVERSION

CREATE TABLE colors(
	id SERIAL PRIMARY KEY,
	color_desc VARCHAR
);

CREATE TABLE sizes(
	id SERIAL PRIMARY KEY,
	size_desc VARCHAR
);

INSERT INTO sizes (size_desc)
	VALUES ('S'), ('M'), ('L');
	
INSERT INTO colors (color_desc)
	VALUES ('red'), ('orange'), ('green');
	
CREATE OR REPLACE FUNCTION no_more_reds()
RETURNS TRIGGER 
AS $$
	BEGIN 
		IF(NEW.color = 'red') THEN 
		RETURN NULL;
	
		END IF;
	
		RETURN NEW;
	END
$$
LANGUAGE plpgsql;

CREATE TRIGGER no_red
	BEFORE INSERT OR UPDATE ON colors
	FOR EACH ROW
	EXECUTE FUNCTION no_more_reds();