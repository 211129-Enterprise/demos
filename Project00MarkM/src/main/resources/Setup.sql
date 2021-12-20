-- DROP SCHEMA "MarkM";

CREATE SCHEMA "MarkM" AUTHORIZATION postgres;

-- DROP TYPE "MarkM"."Number";

CREATE TYPE "MarkM"."Number" AS ENUM (
	'Checking',
	'Savings');

-- DROP TYPE "MarkM"."user_role";

CREATE TYPE "MarkM"."user_role" AS ENUM (
	'Customers',
	'Employee',
	'Administrator');

-- DROP SEQUENCE "MarkM".accounts_bank_id_seq;

CREATE SEQUENCE "MarkM".accounts_bank_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE "MarkM".accounts_bank_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE "MarkM".accounts_bank_id_seq TO postgres;

-- DROP SEQUENCE "MarkM".accounts_id_seq;

CREATE SEQUENCE "MarkM".accounts_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE "MarkM".accounts_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE "MarkM".accounts_id_seq TO postgres;

-- DROP SEQUENCE "MarkM".bank_id_seq;

CREATE SEQUENCE "MarkM".bank_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE "MarkM".bank_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE "MarkM".bank_id_seq TO postgres;
-- "MarkM".accounts definition
-- Drop table
-- DROP TABLE accounts;

CREATE TABLE accounts (
	id serial4 NOT NULL,
	first_name varchar(20) NOT NULL,
	middle_initial varchar(1) NULL,
	last_name varchar(30) NOT NULL,
	account_ranking numeric(1) NOT NULL DEFAULT 0,
	credit_check numeric(3) NULL DEFAULT 0,
	social_security varchar(9) NOT NULL,
	username varchar(30) NOT NULL,
	pwd varchar(40) NOT NULL,
	"user_role" "MarkM"."user_role" NULL,
	active bool NULL DEFAULT false,
	CONSTRAINT accounts_id PRIMARY KEY (id),
	CONSTRAINT accounts_social_security UNIQUE (social_security)
);

-- Permissions
ALTER TABLE "MarkM".accounts OWNER TO postgres;
GRANT ALL ON TABLE "MarkM".accounts TO postgres;


-- "MarkM".bank definition
-- Drop table
-- DROP TABLE bank;

CREATE TABLE bank (
	id serial4 NOT NULL,
	active bool NOT NULL DEFAULT false,
	balance numeric(50, 2) NULL DEFAULT 0,
	"number" varchar(8) NOT NULL,
	account_type "MarkM"."Number" NULL,
	CONSTRAINT bank_check CHECK ((balance > 5.00)),
	CONSTRAINT bank_number_key UNIQUE (number),
	CONSTRAINT bank_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE "MarkM".bank OWNER TO postgres;
GRANT ALL ON TABLE "MarkM".bank TO postgres;

-- "MarkM".accounts_bank definition
-- Drop table
-- DROP TABLE accounts_bank;

CREATE TABLE accounts_bank (
	id serial4 NOT NULL,
	acc_owner varchar(9) NOT NULL,
	account_number varchar(8) NOT NULL,
	CONSTRAINT accounts_bank_pkey PRIMARY KEY (id),
	CONSTRAINT accounts_bank_acc_owner_fkey FOREIGN KEY (acc_owner) REFERENCES accounts(social_security) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT accounts_bank_account_fkey FOREIGN KEY (account_number) REFERENCES bank("number") ON DELETE CASCADE ON UPDATE CASCADE
);

-- Permissions

ALTER TABLE "MarkM".accounts_bank OWNER TO postgres;
GRANT ALL ON TABLE "MarkM".accounts_bank TO postgres;

-- Permissions

GRANT ALL ON SCHEMA "MarkM" TO postgres;
