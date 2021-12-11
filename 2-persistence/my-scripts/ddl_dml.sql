
DROP TABLE IF EXISTS employees CASCADE;
-- without cascade the drop might fail if other tables rely on this table

CREATE TABLE employees(
	id SERIAL PRIMARY KEY, -- to auto increment the id
	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2), --we are adding contraints, 
	last_name VARCHAR(30) not NULL,
	email VARCHAR(100) UNIQUE,
	employee_age INTEGER not null default 0,
	supervisor INTEGER
);

ALTER TABLE employees 
	ADD CONSTRAINT employee_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES employees(id);



INSERT INTO employees (first_name,last_name,email,employee_age)
	VALUES ('Tony','Stark', 'ironman@mail.com', 44);

INSERT INTO employees (first_name,last_name,email,employee_age, supervisor)
	VALUES ('Peter','Parker', 'spiderman@mail.com', 16, 3);
	
SELECT * FROM employees e;

-- wipes all the data from table
TRUNCATE TABLE employees ;
-- but the sequence continues


CREATE TABLE phonenumbers(
	id SERIAL PRIMARY KEY,
	employee_id INTEGER NOT NULL REFERENCES employees(id),
	home VARCHAR(20),
	mobile VARCHAR(20),
	work_num VARCHAR(20)
);


INSERT INTO phonenumbers (employee_id, home, mobile, work_num)
	VALUES (3, '111-111-1111','222-222-2222','333-333-3333'),
			(4, '555-555-5555','666-666-6666','777-777-7777');
	
SELECT * FROM phonenumbers p;

-- we are going to manipulate sql from our ide springtool. its incredibly important to know whats hap
-- happening at the back
-- truncate and drop ddl keywords;
-- delete dml, also insert and update
--DELETE FROM phonenumbers; truncate the table

DELETE FROM phonenumbers WHERE employee_id = 4;

UPDATE phonenumbers 
	SET home = '973-221-8932'
	WHERE employee_id = 3;
	

SELECT * FROM employees e ;
SELECT  first_name, last_name FROM employees e WHERE employee_age =44;
SELECT first_name || ' ' || last_name AS "FULL NAME" FROM employees e;


CREATE VIEW names AS SELECT first_name, last_name FROM employees;

SELECT * FROM names;




