-- SQL sub languages (5)

-- DDL: Data Definition Language
-- DML: Data Manipulation Language
-- TCL: Transaction Control Language
-- DQL: Data Query Langauge
-- DCL: Data Control Language

CREATE USER harrypotter WITH PASSWORD 'dumbledore';

-- GRANT PRIVILEGES
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA somersm TO harrypotter;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA somersm TO harrypotter;

CREATE ROLE super_user WITH
	CREATEDB
	CREATEROLE
	LOGIN
	INHERIT;
	

GRANT super_user TO harrypotter;