
-- Role holds User types
DROP TYPE IF EXISTS vishal.role CASCADE;
CREATE TYPE vishal.role AS ENUM ('Admin', 'Employee', 'Customer');

-- Accounttype holds Account Types
DROP TYPE IF EXISTS vishal.accounttype CASCADE;
CREATE TYPE vishal.accounttype AS ENUM ('CHECKING_ACCOUNT', 'SAVING_ACCOUNT', 'JOINT_ACCOUNT');


-- USERS TABLE contains User Information
DROP TABLE IF EXISTS vishal.users CASCADE;
CREATE TABLE vishal.users (
	
 	user_id SERIAL PRIMARY KEY,
 	username VARCHAR(50) NOT NULL UNIQUE,
 	first_name VARCHAR(50) NOT NULL,
 	last_name VARCHAR(50) NOT NULL,
 	user_pass VARCHAR(50) NOT NULL,
 	user_role vishal.role NOT NULL,
-- 	dob Date NOT NULL,
 	ssn INTEGER NOT NULL,
 	address VARCHAR(50) NOT NULL,
 	city VARCHAR(50) NOT NULL,
 	country VARCHAR(50) NOT NULL,
 	postal_code VARCHAR(50) NOT NULL
 	
);

-- ACCOUNTS TABLE contains Accounts Information
DROP TABLE IF EXISTS vishal.accounts CASCADE;
CREATE TABLE vishal.accounts (
	
	acc_id SERIAL PRIMARY KEY,
	acc_num INTEGER NOT NULL UNIQUE,
	balance NUMERIC(50, 2) DEFAULT 0,
	acc_type vishal.accounttype NOT NULL,
	active BOOLEAN DEFAULT FALSE
	--acc_owner INTEGER NOT NULL REFERENCES vishal.users(user_id) ON DELETE CASCADE ON UPDATE CASCADE

);


-- USERS_ACCOUNTS TABLE shows MANY TO MANY RELATIONSHIP Between USERS and ACCOUNTS TABLES
DROP TABLE IF EXISTS vishal.users_accounts CASCADE;
CREATE TABLE vishal.users_accounts (
	acc_owner INTEGER NOT NULL REFERENCES vishal.users(user_id) ON DELETE CASCADE ON UPDATE CASCADE, 
	acc_id INTEGER NOT NULL REFERENCES vishal.accounts(acc_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- STORED PROCEDURE Tto carry out transfer method
CREATE OR REPLACE PROCEDURE vishal.transfer(
   IN sender INT,
   IN receiver INT, 
   IN amount NUMERIC
)
LANGUAGE plpgsql    
AS $$
BEGIN
	--amount2 = CAST(amount AS NUMERIC)
    -- subtracting the amount from the sending account 
    UPDATE vishal.accounts 
    SET balance = balance - amount 
    WHERE acc_num = sender;

    -- adding the amount to the receiving account
    UPDATE vishal.accounts 
    SET balance = balance +  amount--CAST(amount AS NUMERIC)
    WHERE acc_num = receiver;

    COMMIT;
END;$$




--INSERT INTO accounts (acc_num, balance, acc_type, acc_owner, active) VALUES (1234516789, 100.92, 'SAVING_ACCOUNT', 1, true);

--DELETE FROM accounts WHERE acc_id = 1;

--CALL transfer(1,2,20);
	
	SELECT * FROM vishal.users;
	
	SELECT * FROM vishal.accounts;
	
	SELECT * FROM vishal.users_accounts;

--TRUNCATE vishal.users ;
--TRUNCATE vishal.accounts ;
--TRUNCATE vishal.users_accounts ;



