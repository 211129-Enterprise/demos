CREATE TABLE employee_1nf (
emp_id SERIAL PRIMARY KEY,
empname VARCHAR(50),
ssn INTEGER,
department VARCHAR(50)
);

CREATE TABLE employee_2nf( 
	emp_id SERIAL PRIMARY KEY,
	empname VARCHAR(50),
	ssn INTEGER
);

CREATE TABLE department_2nf(
	emp_id INTEGER REFERENCES employee_2nf(emp_id),
	dept VARCHAR(50)
);

CREATE TABLE employee_3nf( 
	emp_id SERIAL PRIMARY KEY,
	empname VARCHAR(50),
	ssn INTEGER
);

CREATE TABLE department_3nf(
	dept_id SERIAL PRIMARY KEY,
	deptname VARCHAR(50)
);

CREATE TABLE emp_dept_3nf(
	emp_dept_relation SERIAL PRIMARY KEY,
	emp_id INTEGER REFERENCES employee_3nf(emp_id),
	dept_id INTEGER REFERENCES department_3nf(dept_id)
);