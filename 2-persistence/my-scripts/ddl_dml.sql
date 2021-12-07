-- This is a single-line comment
/*
	This is a 
	multi-line comment
*/

/*
 * 
 * Q: WHAT IS SQL?
 * A: Structured Query Language. A server-side scripting language.
 *
 * Q: WHAT IS SQL USED FOR?
 * A: SQL allows you to access and manipulate databases
 * 
 * Q: WHAT INTERPRETS OUR SQL HERE?
 * A: The RDBMS software 
 *
 */

-- DROPPING deletes a TABLE
-- Get rid of table and cascade drops regardless of whether other tables have
-- a relation with it.
DROP TABLE IF EXISTS aaronm.employees CASCADE;






-- DDL - Data Definition Language - Defining table structure
CREATE TABLE employees ( -- PRIMARY KEY IS the UNIQUE identifier FOR a record (by default not null)
	id SERIAL PRIMARY KEY, --Everytime I INSERT an emp OBJECT, I INSERT the id automatically
	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2), --IN PostgreSQL, VARCHAR represents a string DATATYPE AND CONSTRAINT
	last_name VARCHAR(30) NOT NULL, --Constraints serve to filter the type of data in column .
	email VARCHAR(100) UNIQUE, --100 refers TO maximum amount OF characers allowed
	employee_age INTEGER NOT NULL DEFAULT 0,
	supervisor INTEGER -- POINT TO the other EMPLOYEE that MANAGES ONE EMPLOYEE
);

--Here we're manually defining supervisor as the foreign key.
ALTER TABLE employees
	ADD CONSTRAINT employee_supervisor_fk --FK FOR Foriegn KEY
	FOREIGN KEY (supervisor) REFERENCES employees(id);





-- DML - Data Manipulation Language - INSERT or DELETE data from a table
-- INSERT into TABLE_NAME (COLUMN1, COLUMN2, ...) VALUES (?, ? ...);
-- Example:
--		INSERT INTO aaronm.employees (first_name, last_name, email, employee_age)
--			VALUES('Peter', 'Porker', 'therealspiderman@toteslegit.vip', 16);

INSERT INTO aaronm.employees (first_name, last_name, email, employee_age)
	VALUES('Tony', 'Starch', 'thereal.ironman999@toteslegit.vip', 44);
	
INSERT INTO aaronm.employees (first_name, last_name, email, employee_age, supervisor)
	VALUES('Peter', 'Porker', 'therealspiderma69@toteslegit.vip', 16, 1);

-- DQL - Data Query Language - Query all the data inside of our table
SELECT * FROM aaronm.employees; -- adding the SCHEMA AND the . just specifies the SCHEMA.


-- TRUNCATE does not delete the table, it just wipes all the data from the table
TRUNCATE TABLE employees;





--DDL:
CREATE TABLE phonenumbers (
	id SERIAL PRIMARY KEY, --Serial allows us TO increase
	employee_id INTEGER NOT NULL REFERENCES employees(id), --declaring a FOREIGN KEY the SIMPLE way
	home VARCHAR(20),
	mobile VARCHAR(20),
	work_num VARCHAR(20) -- String TYPE because it might look LIKE (555) 867-5309
	
);

--DML
INSERT INTO aaronm.phonenumbers (employee_id, home, mobile, work_num)
	VALUES (1, '(555) 867-5309', '(555) 555-5555', '(555) 123-4567'),
			(2, '(555) 999-5555', '(555) 420-6969', '(555) 123-4567');

--DQL
SELECT * FROM phonenumbers;
