-- This is a Single line Comment

/*
	This is
	a multi-line comment
*/

/*
 * What is SQL - Structured Query Language
 * 
 * SQL allows you to access and manipulate databases.
 * Server-side scripting language. The program that interprets it is the RDBMS
 */

DROP TABLE IF EXISTS sophiag.employees CASCADE;
-- CACADE completely drops the table regardless of whether other tables have
-- a relation with it.

-- DDL - Data Definition Language- Defining table structure
CREATE TABLE employees ( -- PRIMARY KEY IS the UNIQUE identifier FOR a record 
	id SERIAL PRIMARY KEY, -- evreytime i INSERT an emp OBJECT, I INSERT the id automatically
	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2), -- IN PostgreSQL, varchar represents a string DATATYPE AND constraint
	last_name VARCHAR(30) NOT NULL, -- CONSTARINTS SERVe TO FILTER the TYPE OF DATA IN that COLUMN
	email VARCHAR(100) UNIQUE,
	employee_age INTEGER NOT NULL DEFAULT 0,
	supervisor INTEGER -- POINT TO THE OTHER EMPLOYEE THAT MANAGES ONE EMPLOYEE
);

-- here we're manually deifing the foreign key 
ALTER TABLE employees 
	ADD CONSTRAINT employee_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES employees(id);

-- DML: Data Manipulation Language to INSERT or DELETE data within our tables
-- INSERT INTO TABLE_NAME (COLUMN1, COLUM2, ...) VALUES (?, ?);


INSERT INTO employees (first_name, last_name, email, employee_age)
	VALUES ('Tony', 'Stark', 'ironman@mail.com', 44); 

INSERT INTO employees (first_name, last_name, email, employee_age, supervisor)
	VALUES ('Peter', 'Parker', 'spiderman@mail.com', 16, 7);

-- DQL - Data Query Language to query all the data inside of our table
SELECT * FROM sophiag.employees; -- adding the SCHEMA AND the . just spcifies the SCHEMA

-- TRUNCATE does not delete the table, it just wipes all the data from the table
TRUNCATE TABLE employees CASCADE;

CREATE TABLE phonenumbers (
	id SERIAL PRIMARY KEY, -- SERIAL allows us TO increase
	employee_id INTEGER NOT NULL REFERENCES employees(id), -- declaring a FOREIGN KEY that 
	home VARCHAR(20),
	mobile VARCHAR(20),
	work_num VARCHAR(20)
);

-- let's insert Tony Stark's numbers and peter parker's numbers
INSERT INTO phonenumbers (employee_id, home, mobile, work_num)
	VALUES (3, '111-111-1111', '222-222-2222', '333-333-3333'),
		   (4, '555-555-5555', '982-212-8839', '646-337-0172');

SELECT * FROM phonenumbers;
