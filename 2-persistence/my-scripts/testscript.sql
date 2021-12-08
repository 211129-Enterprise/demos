-- This is a single line comment

/*
	This is a
	multi-line comment
*/

-- Drop
drop table if exists employees cascade;

-- DDL
create table employees (
    id serial primary key,
    first_name varchar(30) check(length(first_name) >= 2),
    last_name varchar(30) not null,
    email varchar(100) unique,
    employee_age int not null default 0,
    supervisor int
);

alter table employees
    add constraint employee_supervisor_fk
    foreign key (supervisor) references employees(id);

--DML
insert into employees (first_name, last_name, email, employee_age)
    values ('Tony', 'Stark', 'ironman@gmail.com', 44);

insert into employees (first_name, last_name, email, employee_age, supervisor) 
    values ('Peter', 'Parker', 'spiderman@gmail.com', 16, 2);
	
-- DQL
select * from employees;

-- Truncate
truncate table employees 

create table phone_numbers (
    id serial primary key,
    employee_id int not null references employees(id),
    home varchar(20),
    mobile varchar(20),
    work_num varchar(20)
);

insert into phone_numbers (employee_id, home, mobile, work_num)
    values (2, '111-111-1111', '222-222-2222', '333-333-3333'),
           (3, '555-555-5555', '222-352-5678', '350-313-2363');
		  
select * from phone_numbers;

delete from phone_numbers where employee_i = 8;

update johntb.phone_numbers 
    set home = '123-123-1231'
    where employee_id = 7;

select first_name, last_name from employees where employee_age = 44;

select first_name || ' ' || last_name as "Full Name" from employees;

create view names as select first_name, last_name from employees;
