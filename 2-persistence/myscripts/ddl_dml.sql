-- This is a single line comment.

/*
 * This is 
 * a multi-line 
 * comment
 */

/*
 * What is sql? Structured Query language
 * 
 * SQL allows you to access and manipulate databases.
 * Server-side scripting language. The program that interprets it is the RDBMS
 * 
 */	

DROP TABLE IF EXISTS kennyp.employees CASCADE;
/* cascade completely drops the table regardless of whether other tables have
 * a relation with it.
 */


-- DDL - Data Definition Language - Defining table structure

 CREATE TABLE employees ( -- PRIMARY KEY IS the UNIQUE identifier FOR a record
 	id SERIAL PRIMARY KEY, -- Everytime I INSERT an employee OBJECT, I INSERT the id automatically
 	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2), -- IN postgreSQL, VARCHAR represents a string DATATYPE
 	last_name VARCHAR(30) NOT NULL, -- contstraints serve TO FILTER the TYPE OF DATA IN that column
 	email VARCHAR(100) UNIQUE,
 	employee_age INTEGER NOT NULL DEFAULT 0,
 	supervisor INTEGER -- Point TO the other employee that manages one employee
 );

-- here we're manually defining the foreign key
ALTER TABLE employees 
	ADD CONSTRAINT employee_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES employees(id);
 
-- DML - Data Manipulation Language - Insert or delete data from a table.
-- INSERT INTO table_name (column1, column2, ...) VALUES (?, ?);

INSERT INTO employees (first_name, last_name, email, employee_age)
	VALUES ('Tony', 'Stark', 'ironman@mail.com', 44);

INSERT INTO employees (first_name, last_name, email, employee_age, supervisor)
	VALUES ('Peter', 'Parker', 'spiderman@mail.com', 16, 3);

-- DQL - Data Query Language to query all the data inside of our table
SELECT * FROM kennyp.employees; -- adding the SCHEMA AND the . just specifies the SCHEMA 

-- Truncate does not delete the table--it just wipes all the data from the table
TRUNCATE TABLE employees;

CREATE TABLE phonenumbers (
	id SERIAL PRIMARY KEY, -- SERIAL allows us TO increase
	employee_id INTEGER NOT NULL REFERENCES employees(id), -- declaring a FOREIGN KEY
	home varchar(20),
	mobile varchar(20),
	work_num varchar(20)
);

-- let's insert Tony Stark and Peter Parker's numbers

INSERT INTO phonenumbers (employee_id, home, mobile, work_num)
	VALUES (3, '111-111-1111', '222-222-2222', '333-333-3333'),
		   (4, '444-444-4444', '555-555-5555', '666-666-6666');
		   
SELECT * FROM phonenumbers;

-- Interview question what is the difference (in SQL) between truncate, drop, and delete?
-- delete removes 1 record at a time, truncate wipes all records at one time
-- drop removes the entire table

-- DML: DELETE, INSERT, UPDATE
DELETE FROM phonenumbers WHERE employee_id = 4;

/*
 * UPDATE table_name
 * 	SET column1 = value1,
 * 		column2 = value2,
 *  ...
 *  WHERE CONDITION;
 */

-- updating a specific record
UPDATE phonenumbers 
	SET	home = '973-221-8932'
	WHERE employee_id = 7;
	
SELECT * FROM employees;
SELECT first_name, last_name FROM employees WHERE employee_age = 44;

-- concatenating data from two columns and returning under an alias
SELECT first_name || ' ' || last_name AS "Full Name" FROM employees;

-- Views represetn "virtual tables" as the result of a query
CREATE VIEW names AS SELECT first_name, last_name FROM employees;

SELECT * FROM names; -- just a SIMPLE way OF storing the results OF a query

