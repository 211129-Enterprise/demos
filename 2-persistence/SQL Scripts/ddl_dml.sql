-- This is a single line comment
/*
This is a multiline comment
*/

/*
 * SQL is structured query language
 * Used to define, manipulate, query, contral, and transact data 
 * Server side scripting language
 * Interpreted line by line rather then compiled
*/

--DDL = defining table structure and creating TABLES 
DROP TABLE IF EXISTS employees CASCADE;

CREATE TABLE employees (
	id SERIAL PRIMARY KEY, --I want this TO increase automatically WITH EACH insert
	first_name VARCHAR(30), --VARCHAR is a string TYPE, constrained here TO 30 CHARACTERS AND MORE THEN THEN 2
	last_name VARCHAR(30) NOT NULL,
	email VARCHAR(100) UNIQUE,
	employee_age INTEGER NOT NULL DEFAULT 0,
	supervisor INTEGER --FOREIGN KEY FOR another employee
);

ALTER TABLE employees
	ADD CONSTRAINT employee_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES employees(id);

--DML = data manipulation language
INSERT INTO employees(first_name, last_name, email, employee_age)
	VALUES ('Tony', 'Stark', 'ironman@gmail.com', 40);

INSERT INTO employees(first_name, last_name, email, employee_age, supervisor)
	VALUES ('Peter', 'Parker', 'spiderman@gmail.com', 16, 1);
	
SELECT * FROM aidanh.employees;

--Truncate deletes the data from a table without deleting the table itself
TRUNCATE TABLE employees;

INSERT INTO employees(first_name, last_name, email, employee_age)
	VALUES ('Tony', 'Stark', 'ironman@gmail.com', 40);

INSERT INTO employees(first_name, last_name, email, employee_age, supervisor)
	VALUES ('Peter', 'Parker', 'spiderman@gmail.com', 16, 1);

CREATE TABLE phone_numbers( 
	id SERIAL PRIMARY KEY,
	employee_id INTEGER NOT NULL REFERENCES employees(id),
	home VARCHAR(20),
	mobile VARCHAR(20),
	work_num VARCHAR(20)
);

INSERT INTO phone_numbers(employee_id, home, mobile, work_num)
	VALUES  (1, '123-456-7890', '123-456-7890', '123-456-7890'),
			(2, '123-456-7890', '123-456-7890', '123-456-7890');
			
SELECT * FROM phone_numbers;

TRUNCATE TABLE phone_numbers;