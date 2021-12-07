DROP TABLE IF EXISTS somersm.users CASCADE;

CREATE TYPE somersm.user_role AS ENUM ('Admin', 'Customer', 'Employee');


CREATE TABLE somersm.users (
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL;
    user_role somersm.user_role NOT NULL
	
);

DROP TABLE IF EXISTS somersm.accounts CASCADE;
CREATE TABLE somersm.accounts (
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2), DEFAULT 0,
	acc_owner INTEGER NOT NULL REFERENCES somersm.users(id),
	active BOOLEAN DEFAULT FALSE
);

DROP TABLE IF EXISTS somersm.users.accounts_jt CASCADE;
CREATE TABLE somersm.users_accounts_jt (
	acc_owner INTEGER NOT NULL REFERENCES somersm.users(id),
    account INTEGER NOT NULL REFERENCES somersm.accounts(id)
);

-- implement PL/pgsql functional programming language for Postgres
-- create a function so that everytime a new account is entered into the accounts table
-- 
