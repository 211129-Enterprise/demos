DROP TYPE IF EXISTS kennyp.user_role CASCADE;
CREATE TYPE kennyp.user_role AS ENUM ('Admin', 'Customer', 'Employee');

DROP TABLE IF EXISTS kennyp.users CASCADE;
CREATE TABLE kennyp.users (
	
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	user_role kennyp.user_role NOT NULL	
);

DROP TABLE IF EXISTS kennyp.accounts CASCADE; 
CREATE TABLE kennyp.accounts (

	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2) DEFAULT 0,
	acc_owner INTEGER NOT NULL REFERENCES kennyp.users(id),
	active BOOLEAN DEFAULT FALSE -- this determines whether the account has been opened
	
);

DROP TABLE IF EXISTS kennyp.users_accounts_jt CASCADE;
CREATE TABLE kennyp.users_accounts_jt (

	acc_owner INTEGER NOT NULL REFERENCES kennyp.users(id),
	account INTEGER NOT NULL REFERENCES kennyp.accounts(id)

);

--implement PL/pgsql functional programming LANGUAGE FOR postgres rdbms
--CREATE a FUNCTION so that EVERY time a NEW account IS entered INTO the accounts table

INSERT INTO kennyp.users (username, pwd, user_role)
	VALUES ('Larry', 'pass', 'Employee'),
		   ('Marry', '1234', 'Customer'),
		   ('Barry', 'pass', 'Customer');

SELECT * FROM users;

INSERT INTO kennyp.accounts (balance, acc_owner)
	VALUES (100, 1),
		   (200, 2),
		   (2000, 2),
		   (300, 3);

SELECT * FROM accounts;

INSERT INTO users_accounts_jt (account, acc_owner)
	VALUES (1, 1),
		   (2, 2),
		   (3, 2),
		   (4, 3);

SELECT * FROM users_accounts_jt;