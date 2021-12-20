DROP TYPE IF EXISTS kennyp.user_role CASCADE;
CREATE TYPE kennyp.user_role AS ENUM ('Admin', 'Customer', 'Employee');

DROP TYPE IF EXISTS kennyp.acc_type CASCADE;
CREATE TYPE kennyp.acc_type AS ENUM ('Checking', 'Savings');

DROP TABLE IF EXISTS kennyp.users CASCADE;
CREATE TABLE kennyp.users (
	
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	ssn VARCHAR(9),
	user_role kennyp.user_role NOT NULL
);

DROP TABLE IF EXISTS kennyp.accounts CASCADE; 
CREATE TABLE kennyp.accounts (

	id SERIAL PRIMARY KEY,
	acc_number INT UNIQUE,
	balance NUMERIC(50, 2) DEFAULT 0 CHECK (balance > 1),
--	acc_owner INTEGER NOT NULL REFERENCES kennyp.users(id),
	acc_type kennyp.acc_type NOT NULL,
	active BOOLEAN DEFAULT FALSE -- this determines whether the account has been opened
	
);

DROP TABLE IF EXISTS kennyp.users_accounts_jt CASCADE;
CREATE TABLE kennyp.users_accounts_jt (
	
	id SERIAL PRIMARY KEY,
	acc_owner INTEGER NOT NULL REFERENCES kennyp.users(id) ON DELETE CASCADE ON UPDATE CASCADE,
	account INTEGER NOT NULL REFERENCES kennyp.accounts(id) ON DELETE CASCADE ON UPDATE CASCADE

);

--implement PL/pgsql functional programming LANGUAGE FOR postgres rdbms
--CREATE a FUNCTION so that EVERY time a NEW account IS entered INTO the accounts table

/*
 * The goal is so that Evrytime a new Acocunt is added to account
 * table, the users_accounts_jt is automatically populated with 
 * the acc_owner ID and the account id
 */

/**
 * PL/pgsql Procedural Language for PostgreSQL 
 * 
 * Allows you to create 
 * 		- custom types
 * 		- stored functions (return a result)
 * 		- stored procedures (think of it as a void function) since Postgres 11
 * 		- triggers
 */

/**
 * 
 *  create [or replace] function [name] (params)
 *  returns [type]
 *  as '
 * 		begin
 * 			[logic]
 * 		end
 *  '
 *  language plpgsql;
 * 
 */

-- create a function that inserts the acc_owner id & acc id into the joins table
-- every time a new record is inserted into Accounts table
CREATE OR REPLACE FUNCTION kennyp.auto_insert_into_jt()
RETURNS TRIGGER 
AS '
	BEGIN
		INSERT INTO kennyp.users_accounts_jt (acc_owner, account)	
			VALUES (NEW.acc_owner, NEW.id);
			
			RETURN NEW;
	END
'
LANGUAGE plpgsql;

-- this is a trigger function - the above function is depeNdent on it
CREATE TRIGGER trig 
	AFTER INSERT ON kennyp.accounts
	FOR EACH ROW
	EXECUTE PROCEDURE kennyp.auto_insert_into_jt();

SELECT * FROM kennyp.users;
SELECT * FROM kennyp.accounts;
SELECT * FROM kennyp.users_accounts_jt;

INSERT INTO kennyp.accounts (balance, acc_owner, active)
	VALUES (500000, 4, TRUE);
	
-- user id, username, password, role, account id, account balance, isActive
SELECT *
	FROM  users
	LEFT JOIN users_accounts_jt ON users.id = users_accounts_jt.acc_owner
	LEFT JOIN accounts ON accounts.id = users_accounts_jt.account;
	
SELECT accounts.id, accounts.balance, accounts.acc_type, accounts.active, users_accounts_jt.acc_owner FROM accounts
	INNER JOIN users_accounts_jt 
		ON accounts.id = users_accounts_jt.account

CREATE PROCEDURE SelectAccountsAndOwners
AS 
SELECT * FROM accounts 
INNER JOIN users_accounts_jt 
ON accounts.id = users_accounts_jt.account GO;


INSERT INTO kennyp.users (username, pwd, user_role)
	VALUES ('Larry', 'pass', 'Employee'),
		   ('Mary', '1234', 'Customer'),
		   ('Barry', 'pass', 'Admin');

SELECT * FROM users;

INSERT INTO kennyp.accounts (balance, acc_type, active)
	VALUES (100, 'Checking', true),
		   (200, 'Savings', false),
		   (2000, 'Savings', true),
		   (300, 'Checking', false);

SELECT * FROM accounts;

INSERT INTO users_accounts_jt (acc_owner, account)
	VALUES (1, 1),
		   (1, 3),
		   (2, 2),
		   (3, 4);

SELECT * FROM users_accounts_jt;


