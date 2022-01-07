-- Create a table in 1NF
CREATE TABLE employees_1nf (
	
	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER,
	dept VARCHAR(50)
	
);

CREATE TABLE employees_2nf (

	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER
);

CREATE TABLE employees_dept_2nf (

	emp_id INTEGER REFERENCES employees_2nf(emp_id),
	dept VARCHAR(50) NOT NULL
	
);

-- 3NF looks like 
CREATE TABLE dept_3nf (
	dept_id SERIAL PRIMARY KEY,
	dept_name VARCHAR(50)
);

CREATE TABLE employees_3nf (

	emp_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(50) NOT NULL,
	ssn INTEGER
);

CREATE TABLE emp_dept_3nf (

	emp_dept_relation SERIAL PRIMARY KEY, -- uniquely defines EACH relationship 
	emp_id INTEGER REFERENCES employees_3nf(emp_id),
	dept_id INTEGER REFERENCES dept_3nf(dept_id)     

);







