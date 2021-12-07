--This is a single line comment
/*
 This is a multi line comment.
*/
/*
*What is SQL -Structured Query Language
*-SQL allows you to access and manipulate databases.
*Server-side scripting language. The program that interprets it is the RDBMS
*/

--DROP TABLE IF EXISTS "MarkM".phonenumbers CASCADE;
-- cascade completely drops the table regardless of wether other tables have
-- a relation with it. This is a horrible idea most of the time.
TRUNCATE TABLE "MarkM".phonenumbers;
-- truncate does not delete the table, just the data from within the table.


--DDL - Data definition language defining table structure
CREATE TABLE employees ( --PRIMARY KEY IS the unqie identifier FOR a record
	id SERIAL PRIMARY KEY, --everytime i INSERT an employee OBJECT, i INSERT the id automatically
	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2), --in PostgreSQL, varchar represents a string DATATYPE and constraint 
	last_name VARCHAR(30) NOT NULL, -- CONSTRAINTS serve TO FILTER the TYPE OF DATA IN that column
	email VARCHAR(100) UNIQUE,
	employee_age INTEGER NOT NULL DEFAULT 0,
	supervisor INTEGER--POINT TO OTHER EMPLOYEE THAT MANAGES ONE EMPLOYEE.
);

ALTER TABLE "MarkM".employees 
	ADD CONSTRAINT employees_supervisor_fk
		FOREIGN KEY (supervisor) REFERENCES employees(id);


--dml data manipulation language, insert or delete data from a table.
SELECT * FROM "MarkM".employees;
INSERT INTO "MarkM".employees (first_name, last_name, email, employee_age)
		VALUES ('Tony', 'Stark', 'ironman@mail.com', 44);
INSERT INTO "MarkM".employees (first_name , last_name, email, employee_age, supervisor)
	VALUES ('Peter', 'parker', 'spiderman@mail.com', 16, 3);	


--DQL 	Data query langugage to query all the data inside of our table
 --adding the SCHEMA AND the . just specifies the SCHEMA.
-----------------------------------------------------------------------------------------------
CREATE TABLE "MarkM".phonenumbers ( 
	id SERIAL PRIMARY KEY, 
	employee_id INTEGER NOT NULL REFERENCES employees(id),
	home VARCHAR(20), 
	mobile VARCHAR(20),
	work_num  VARCHAR(20)
);

INSERT INTO "MarkM".phonenumbers (employee_id, home, mobile, work_num)
	VALUES (3, '111-111-3333', '222-222-3333', '333-333-3333'),
			(4, '111-111-4444', '222-222-4444', '333-333-4444');
		
SELECT * FROM "MarkM".phonenumbers; 
-----------------------------------------------------------------------------------------------
--DML: delete, insert, update
DELETE FROM "MarkM".phonenumbers WHERE employee_id = 4; 
UPDATE "MarkM".phonenumbers 
	SET home = '973-221-8932'
	WHERE employee_id = 1;

SELECT * FROM employees;
SELECT * FROM employees WHERE employee_age = 44;

--concatinating DATA from two columns and returning under an alias.
SELECT first_name || ' ' || last_name AS "Full Name" FROM employees

--views represent "virtual tables" as the result of a query
CREATE VIEW names AS SELECT first_name, last_name FROM employees;

SELECT * FROM names; --just a SIMPLE way OF storing the results OF a query.




