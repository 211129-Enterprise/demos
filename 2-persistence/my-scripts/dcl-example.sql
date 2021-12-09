-- -- -- -- -- -- -- -- -- -- -- -- -- --
-- SQL sub languages (5)
-- -- -- -- -- -- -- -- -- -- -- -- -- --
-- 1. DDL: Data Definition Languages
-- 2. DML: Data Manipulation Language
-- 3. TCL: Transaction Control Language
-- 4. DQL: Data Query Language
-- 5. DCL: Data Control Language
-- -- -- -- -- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- DCL EXAMPLE -- -- -- -- -- -- --
CREATE USER harrypotter WITH PASSWORD 'dumbledore';
CREATE USER presidentskroob WITH PASSWORD '12345';

-- GRANT / REVOKE PRIVILEGES
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA aaronm TO harrypotter, presidentskroob;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA aaronm FROM harrypotter, presidentskroob;

-- CREATE A ROLE
CREATE ROLE super_user WITH
	CREATEDB
	CREATEROLE
	LOGIN
	INHERIT;
	
-- GRANTING ROLES
-- We can grant all capabiliites of one role to another (or user)
GRANT super_user TO harrypotter;