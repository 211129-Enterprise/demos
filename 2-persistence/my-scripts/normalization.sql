-- Create a table in 1NF
CREATE TABLE aaronm.employees_1nf(
	
	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER,
	dept VARCHAR(50)

);





-- Create a table in 2NF
CREATE TABLE aaronm.employees_2nf(

	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER

);

CREATE TABLE aaronm.employees_dept_2nf(

	emp_id INTEGER REFERENCES aaronm.employees_2nf(emp_id),
	dept VARCHAR(50) NOT NULL
	
);





-- Create a table in 3NF
CREATE TABLE aaronm.dept_3nf(

	dept_id SERIAL PRIMARY KEY,
	dept_name VARCHAR(50)

);

CREATE TABLE aaronm.employees_3nf(

	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER

);

CREATE TABLE aaronm.emp_dept_3nf(

	--If employee has more than one department
	emp_dept_relation SERIAL PRIMARY KEY,

	--Otherwise you'd leave it at...
	emp_id INTEGER REFERENCES aaronm.employees_3nf(emp_id),
	dept_id INTEGER REFERENCES aaronm.dept_3nf(dept_id)

);