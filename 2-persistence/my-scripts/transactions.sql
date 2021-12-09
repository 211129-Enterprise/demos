-- TCL Transaction Control Language
-- A transaction is a unit of work executed against a database at one time

CREATE TABLE aaronm.some_bank_accounts(

	cust_name VARCHAR(50),
	balance NUMERIC(50, 2)
	

);


INSERT INTO some_bank_accounts(cust_name, balance)
	VALUES ('Alice', 100),
			('Bob', 5),
			('Sam', 0);
		
		
SELECT * FROM aaronm.some_bank_accounts;


-- Alice sends $50 to Bob - 2 different update statements
UPDATE aaronm.some_bank_accounts SET balance = balance - 50 WHERE cust_name = 'Alice';

--What happens if server failed and the second statement never executed?
UPDATE aaronm.some_bank_accounts SET balance = balance + 50 WHERE cust_name = 'Bob';


-- Transaction is a unit of work to be performed against the DB at one time
-- preventing half-baked statement executions
BEGIN;
	UPDATE aaronm.some_bank_accounts SET balance = balance - 50 WHERE cust_name = 'Bob';

	SAVEPOINT my_savepoint;

	-- by accident bob sends money to sam instead of alice
	UPDATE aaronm.some_bank_accounts SET balance = balance + 50 WHERE cust_name = 'Sam';

	ROLLBACK TO my_savepoint;

	UPDATE aaronm.some_bank_accounts SET balance = balance + 50 WHERE cust_name = 'Alice';
COMMIT; --TCL consists OF commands including SAVEPOINT, ROLLBACK, BEGIN, and COMMIT


---------------------------------------------------------------------------------------------
-- Transactions are ACIDic (Properties of Transactions)
--
-- A = Atomicity: It either happens or it doesn't
-- C = Consistency: Referential integrity is maintained
-- I = Isolation: Transactions occur independently of eachother 
-- D = DurabilityL Ensures that the result of a commited transaction persists in case of
--	   system failiure.
---------------------------------------------------------------------------------------------
--
-- Transaction Problems That Can Occur:
-- These are the problems that arise if one transaction interferes with another
--
-- DIRTY READ: A transaction reads data from another transaction that hasn't been committed.
--
-- NON-REPEATABLE READ: One transaction reads the data twice while another transaction
--						updates the data in between the first and second.
--
-- PHANTOM READ: Transaction runs a query twice and gets different data each time
--				 (e.g. different number of rows in a table is returned)
--
---------------------------------------------------------------------------------------------
-- Side Note:
-- TCL is a SQL sub-lnaguage common in every RDBMS vendor (MariaBD, MySQL, PostgreSQL, etc..)
---------------------------------------------------------------------------------------------
-- Transaction Isolation Levels:
-- The higher the isolation level, the more careful the system is about avoiding conflicts.
-- Serializable is the highest and safest level.
--
-- SEE: https://www.geeksforgeeks.org/transaction-isolation-levels-dbms/
---------------------------------------------------------------------------------------------
