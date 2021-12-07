-- This is a single line comment.


/* 
	This is a multi-line comment.

*/


/*
 * What is SQL = Structured Query Language
 * 
 * SQL allows you to access and manipulate databases.
 * 
 * Server-side scripting language.
 * 
 * The program that interprets it is an RDBMS
 */

-- DDL - Data Definition language 

DROP TABLE IF EXISTS somersm.employees CASCADE;
DROP TABLE IF EXISTS somersm.phonenumers CASCADE;
-- CASCADE completely drops the table regardless of whether 


CREATE TABLE employees (
	id SERIAL PRIMARY KEY, -- everytime i INSERT an empty Object i insert the id automatically
	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2),
	last_name VARCHAR(30) NOT NULL,
	email VARCHAR(100) UNIQUE,
	employee_age INTEGER NOT NULL DEFAULT 0,
	supervisor INTEGER
);

ALTER TABLE employees 
	ADD CONSTRAINT employee_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES employees(id);

-- DML - DATA Manipulation Language
INSERT INTO employees (first_name, last_name, email, employee_age)
	VALUES('Tony', 'Stark', 'ironman@email.com', 44);

INSERT INTO employees (first_name, last_name, email, employee_age, supervisor)
	VALUES('Peter', 'Parker', 'spiderman@email.com', 16, 1);


	
-- DQL - DATA Query Language

SELECT * FROM employees;

-- TRUNCATE does not delete the table, it just wipes all data from the table
-- TRUNCATE TABLE employees;

CREATE TABLE phonenumbers (
	id SERIAL PRIMARY KEY,
	employee_id INTEGER NOT NULL REFERENCES employees(id),
	home VARCHAR(20),
	mobile VARCHAR(20),
	work_num VARCHAR(20)
);

INSERT INTO phonenumbers(employee_id, home, mobile, work_num) 
VALUES (1, '111-111-1111', '222-222-2222', '333-333-3333'),
       (2, '555-555-5555', '982-212-8839', '649-337-0172');
       
 SELECT * FROM phonenumbers;
 
-- DML: DELETE, INSERT, UPDATE

-- DELETE FROM phonenumbers WHERE employee_id = 8;

UPDATE phonenumbers SET home = '973, 221-8932' WHERE employee_id  = 7;

SELECT first_name || ' ' || last_name AS "Full Name" FROM employees;

-- views are virtual tables
CREATE VIEW names AS SELECT first_name, last_name FROM employees;

SELECT * FROM names; 
