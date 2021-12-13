/*
 * TCL Transaction Control Language
 * 
 * A Tx is a unit of work executed against a database at one time 
 * 
 */

CREATE TABLE bank_accounts (
	
	cust_name VARCHAR(50),
	balance NUMERIC(50,2)
	
);

INSERT INTO bank_accounts (cust_name, balance)
	VALUES ('Alice', 100),
		   ('Bob', 50),
		   ('Sam',0);

SELECT * FROM bank_accounts;

-- Alice sends $50 to Bob - 2 different update statements
UPDATE bank_accounts SET balance = balance - 50 WHERE cust_name = 'Alice';

-- What would happen if my server failed and my second statement never executed?
UPDATE bank_accounts SET balance = balance + 50 WHERE cust_name = 'Bob';

/* Transaction is a unit of work to be performed against the DB at one time
 * preventing half-baked statement executions
 */
BEGIN;
	UPDATE bank_accounts SET balance = balance - 50 WHERE cust_name = 'Alice';
	
	SAVEPOINT my_savepoint;

	-- by accident alice sends money to Sam instead of Bob
	UPDATE bank_accounts SET balance = balance + 50 WHERE cust_name = 'Sam';

	ROLLBACK TO my_savepoint;

	UPDATE bank_accounts SET balance = balance + 50 WHERE cust_name = 'Bob';
COMMIT; -- TCL consists OF commands including SAVEPOINT, ROLLBACK, BEGIN, COMMIT

/**
 * Transactions are ACIDic (Properties of Transactions)
 * Atomicity: Either happens or doesn't
 * Consistency: Referential integrity will be maintained
 * Isolation: Transactions occur independently of each other
 * Durability: Ensure that the result of a committed transaction persists in the case of system failure
 */

----------------------------------------------------

/**
 * Transaction Problems!
 * 
 * These are the problems that arise IF 1 transaction interferes with another
 * 
 * Dirty Read: a tx reads data from another tx that hasn't been committed
 * Non-Repeatable Read: 1 tx reads the data while another tx updates the data in between the first and second
 * Phantom Read: tx runs a query twice and gets different data each time (i.e. different number of rows in table)
 */

----------------------------------------------------

/**
 * TCL is a SQL sub-language common in every RDBMS vendor (MariaDB, MySQL, PostgreSQL, etc...)
 * 
 * Transaction Isolation Levels: The higher the isolation level, the more careful the system is about avoiding 
 * conflicts (Serializable is the highest and safest level).
 * BY DEFAULT PostgreSQL is Read Committed
 * 
 * 
 * https://www.geeksforgeeks.org/transaction-isolation-levels-dbms/
 * 
 * Data Control Language, Transaction Control Language
 */
