CREATE TYPE vishal.user_role AS ENUM ('Admin','Customer','Employee');

DROP TYPE IF EXISTS vishal.user_role CASCADE; 
DROP TABLE IF EXISTS vishal.users CASCADE;


CREATE TABLE vishal.users(

	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	user_role vishal.user_role NOT NULL
);

DROP TYPE IF EXISTS vishal.accounts CASCADE;
CREATE TABLE vishal.accounts(
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50,2) DEFAULT 0, -- 50 TO the LEFT AND 2 TO the RIGHT FOR decimal.
	acc_owner INTEGER NOT NULL REFERENCES vishal.users(id),
	active BOOLEAN DEFAULT FALSE

);

DROP TYPE IF EXISTS vishal.users_accounts_jt CASCADE;
CREATE TABLE users_accounts_jt(
	acc_owner INTEGER NOT NULL REFERENCES users(id),
	account integer NOT NULL REFERENCES accounts(id) 

);

