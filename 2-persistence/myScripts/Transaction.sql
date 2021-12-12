-- TCL Transaction Control Language
-- A transaction is a unit of work executes against a database at one time

CREATE TABLE bank_accounts (
	cust_name VARCHAR(50);
	balance NUMERIC(50, 2);
);

INSERT INTO bank_accounts (cust_name, balance)
	VALUES ('Alice', 100),
			('Bob', 50),
			('Sam', 0);
			
SELECT * FROM bank_accounts;

-- Alice sends $50 to Bob - 2 different update statements 
UPDATE bank-accounts SET balance = balance = 50 WHERE cust_name = 'Alice';

UPDATE bank-accounts SET balance = balance = 50 WHERE cust_name = 'Bob';

-- first characteristic of a transaction is that it's atomic, either it happens or it doesn't
-- preventing non-atomic (half-baked) executions


BEGIN;
	UPDATE bank_accounts SET balance = balance - 50 WHERE cust_name = 'Alice';
	
	SAVEPOINT my_savepoint;

	UPDATE bank_accounts SET balance = balance + 50 WHERE cust_name = 'Sam'

	ROLLBACK TO my_savepoint;

	UPDATE bank_accounts SET balance = balance + 50 WHERE cust_name = 'Bob'
COMMIT;

--- Transaction are ACIDIC (Properties of Transactions)

-- A = Atomicity: it either happens or it doesn't
-- C = Consitency: Referential integrity is maintained
-- I = Isolation: Transactions occur independently of each OTHERS 
-- D = Durability: Ensure that the result of a commited transaction persists in case of a system failure.


-- Transaction Problems!

-- These are the problems that arise if 1 transaction interferes with another

-- Diry READ : a transaction reads data from another transaction that hasn't been committed
-- Non-Repeatable READ: 1 transaction reads the data twice while another transaction updates the data between the 1st and 2nd
-- Phantom READ: transaction that runs a query twice and gets a different data each time (i. e. different number of rows in each table)

-- TCL is a SQL sub-language common in every RDBMS vendor
-- Transaction isolation levels: The higher the isolation level, the more careful the system is about 
-- conflicts (serializable is the highest and safest level).

-- https://www.geeksforgeeks.org/transaction-isolation-levels-dbms/







