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
	VALUES (7, '111-111-1111', '222-222-2222', '333-333-3333'),
		   (8, '555-555-5555', '982-212-8839', '646-337-0172');

SELECT * FROM phonenumbers;

-- 
-- Interview question what is the difference (in SQL) between truncate, drop, and delete?
-- delete deletes 1 record at a time, truncate wipes all records at one time
-- drop deltes the entire table

-- DML: DELETE, INSERT, UPDATE
DELETE FROM phonenumbers WHERE employee_id = 8;

/*
 * UPDATE table_name
	SET column1 = value1,
    column2 = value2,
    ...
	WHERE condition;
 */

-- updateing a SPECIFIC record DML 
UPDATE phonenumbers 
	SET home = '973-221-8932'
	WHERE employee_id = 7;

SELECT * FROM employees;
SELECT first_name, last_name FROM employees WHERE employee_age = 44;

-- CONCATENATEING DATA FROM TWO COLUMNSA AND RETURNING UNDER AN ALIAS
SELECT first_name || ' ' || last_name AS "Full Name" FROM employees


-- Views represent "virtual tables" as the result of a query
CREATE VIEW names AS SELECT first_name, last_name FROM employees;

SELECT * FROM names; -- just a SIMPLE way OF storing the results OF a query

CREATE TYPE "MarkM".user_role AS ENUM ('Admin', 'Employee', 'Customer');

--DROP TABLE IF EXISTS "MarkM".Customers CASCADE;
CREATE TABLE "MarkM".Customers (
	first_name VARCHAR (20) NOT NULL,
	middle_initial VARCHAR (1) NOT NULL,
	last_name VARCHAR (30),
	birthdate DATE NOT NULL,
	account_ranking NUMERIC(1,0) DEFAULT 0,
	credit_check NUMERIC (3,0) DEFAULT 0,
	social_security VARCHAR (9) UNIQUE,
	username VARCHAR(30) NOT NULL UNIQUE,
	pwd VARCHAR(40) NOT NULL,
	user_role "MarkM".user_role NOT NULL --enum
);
INSERT INTO "MarkM".Customers (first_name, middle_initial, last_name, birthdate,account_ranking,
		credit_check, social_security, username, pwd, user_role)
	VALUES ('Tony', 'I', 'Stark', '06/06/1966', 2, 730, 222113333, 'tony.stark', 'iamironman01', 'Employee'); 

--UPDATE "MarkM".Customers
--	SET social_security = '222113333'
--	WHERE username = 'tony.stark';


FORMAT(123456789, '###-##-####'),
CREATE TABLE "MarkM".Accounts (
	id SERIAL PRIMARY KEY,
	account_number VARCHAR (10) NOT NULL REFERENCES "MarkM".Customers(social_security),
	balance NUMERIC(50,2) DEFAULT 0,
	acc_owner INTEGER NOT NULL,
	active BOOLEAN DEFAULT FALSE -- this determines whether an account has been opened. 
);

CREATE TABLE "MarkM".Customers_Account_jt (
	account_owner VARCHAR (20) NOT NULL REFERENCES "MarkM".Customers(social_security),	
	account INTEGER NOT NULL REFERENCES "MarkM".Accounts(id)
);

--implement PL/pgsql functional programming language langue for Postgres RDBMS
--create a function so that everytime a new account is enetered into the accounts table.
--