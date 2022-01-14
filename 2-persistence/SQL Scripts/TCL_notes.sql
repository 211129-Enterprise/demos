
CREATE TABLE bank_accounts (
	cust_name VARCHAR(50),
	balance NUMERIC(50, 2)
);

INSERT INTO bank_accounts(cust_name, balance)
	VALUES ('Alice', 100),
			('Bob', 50),
			('Cherie', 10000);
			
SELECT * FROM bank_accounts;

--Alice wants to send Bob fifty dollars
--requires a transaction
--transactions are units of work, they can only be completed in full (atmoically)

BEGIN;
SAVEPOINT One;
ROLLBACK One;
COMMIT;

--Transactions are ACID
--Multiple concurrent transactions can cause issues

--Transaction Isolation Levels: The higher the level the more careful the system is to avoid transaction clashes, serializable is the highest and safest
--RDBMS vendors will vary what their default isolation level is