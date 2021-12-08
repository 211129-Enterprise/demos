DROP TYPE IF EXISTS aaronm.user_role CASCADE;
CREATE TYPE aaronm.user_role AS ENUM ('Admin', 'Customer', 'Employee');



DROP TABLE IF EXISTS aaronm.users CASCADE;
CREATE TABLE aaronm.users (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE, --50 IS standard CHARACTER length
	pwd VARCHAR(50) NOT NULL,
	user_role aaronm.user_role NOT NULL
);



DROP TABLE IF EXISTS aaronm.accounts CASCADE;
CREATE TABLE aaronm.accounts (
	accounts_id SERIAL PRIMARY KEY,
	account_balance NUMERIC(50, 2) DEFAULT 0, --NUMERIC(left side digits, right side digits)
	account_owner INTEGER NOT NULL REFERENCES aaronm.users(user_id),
	active BOOLEAN DEFAULT FALSE --This determines whethe account has been opened

);


--Join table
DROP TABLE IF EXISTS aaronm.users_accounts_jt CASCADE;
CREATE TABLE aaronm.users_accounts_jt (
	account_owner INTEGER NOT NULL REFERENCES aaronm.users(user_id),
	account INTEGER NOT NULL REFERENCES aaronm.accounts(accounts_id)
);

--Later on implement PL/pgsql - functional programming language for Postgres RDBMS
--Create a function so that everytime a new account is entered into the acounts table
--an id is stored in the joins table


INSERT INTO aaronm.users (username, pwd, user_role)
	VALUES ('Larry', 'password', 'Employee'),
	('Mary', '12345', 'Customer'),
	('Barry', 'JillSandwich', 'Customer');
	
SELECT * FROM users;


INSERT INTO aaronm.accounts(account_balance, account_owner)
	VALUES (100, 1), 	-- One account FOR Larry
	(200, 2),  	-- Checking acct FOR Mary (2)
	(2000, 2),	-- Savings acct FOR Mary (2)
	(300, 3); -- One account FOR Barry
	
SELECT * FROM accounts;


INSERT INTO aaronm.users_accounts_jt(account_owner, account)
	VALUES (1, 1),
	(2, 2),
	(2, 3),
	(3, 4);
	
SELECT * FROM users_accounts_jt;


/*
 * The goal IS so that everytime a NEW account IS added TO the
 * account TABLE, the users_accounts_jt IS automatically populated
 * WITH the acc_owner ID AND the account id 
 */

/**
 * PL/pgsql - Procedual LANGUAGE FOR PostreSQL
 * It allows you to create:
 * 		- custom types (like enums)
 * 		- stored functions (return a result)
 * 		- stored procedures (think of it as a void function) since PostreSQL 11 
 * 		- triggers
 */

/**
 *
 * CREATE [or replace] FUNCTION [name] (params)
 * RETURNS [type]
 * AS '
 *	BEGIN 
 *		[logic]
 * 	END
 * '
 * LANGUAGE plpgsql
 */

-- Create a function that inserts the acc_owner id and acc id into the joins table
-- every time a new record is inserted into Accounts table.
CREATE OR REPLACE FUNCTION aaronm.auto_insert_into_jt()
RETURNS TRIGGER 
AS '
	BEGIN
		INSERT INTO aaronm.users_accounts_jt (account_owner, account)
			VALUES (NEW.account_owner, NEW.accounts_id);

			RETURN NEW;
	END
'
LANGUAGE plpgsql;


CREATE TRIGGER trig
	AFTER INSERT ON aaronm.accounts 
	FOR EACH ROW 
	EXECUTE PROCEDURE aaronm.auto_insert_into_jt();

SELECT * FROM aaronm.users;
SELECT * FROM aaronm.accounts;
SELECT * FROM aaronm.users_accounts_jt;

INSERT INTO aaronm.accounts (account_balance, account_owner, active)
	VALUES (5, 4, true);
