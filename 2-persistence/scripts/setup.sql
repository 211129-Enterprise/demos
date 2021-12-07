DROP TYPE IF EXISTS sophiag.user_role CASCADE;
CREATE TYPE sophiag.user_role AS ENUM ('Admin', 'Customer', 'Employee');


DROP TABLE IF EXISTS sophiag.users CASCADE;
CREATE TABLE sophiag.users (
	
 	id SERIAL PRIMARY KEY,
 	username VARCHAR(50) NOT NULL UNIQUE,
 	pwd VARCHAR(50) NOT NULL,
 	user_role sophiag.user_role NOT NULL
);

DROP TABLE IF EXISTS sophiag.accounts CASCADE;
CREATE TABLE sophiag.accounts (
	
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2) DEFAULT 0, -- 67283467846782364783264823784678.02
	acc_owner INTEGER NOT NULL REFERENCES sophiag.users(id),
	active BOOLEAN DEFAULT FALSE -- this determines whether the account has been opened

);

DROP TABLE IF EXISTS sophiag.users_accounts_jt CASCADE;
CREATE TABLE sophiag.users_accounts_jt (
	acc_owner INTEGER NOT NULL REFERENCES sophiag.users(id), -- 1 - 12
	account INTEGER NOT NULL REFERENCES sophiag.accounts(id) -- 1 - 13
															 -- 2 - 12												 -- 42 - 12
);

-- implement PL/pgsql functional programming langue for Postgres RDBMS
-- create a function so that everytime a new account is entered into the accounts table

INSERT INTO sophiag.users (username, pwd, user_role) 
	VALUES ('Larry', 'pass', 'Employee'),
			('Marry', '1234', 'Customer'),
			('Barry', 'pass', 'Customer');
			
SELECT * FROM users;


INSERT INTO sophiag.accounts (balance, acc_owner)
	VALUES (100, 1),
		    (200, 2),
		    (2000, 2),
		    (300, 3);
		   
SELECT * FROM ACCOUNTS;

INSERT INTO users_accounts_jt (acc_owner, account) 
	VALUES (1, 1),
	 	   (2, 2), -- Marry's account (her id is 2)
	 	   (2, 3), -- Marry's account (her id is 2)
	 	   (3, 4);

SELECT * FROM users_accounts_jt;
	 	  






