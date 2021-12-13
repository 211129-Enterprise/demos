/**
 * SQL sublanguages (5)
 * 
 * DDL: Data Definition Language
 * DML: Data Manipulation Language
 * TCL: Transaction Control Language
 * DQL: Data Query Language
 * DCL: Data Control Language
 * 
 * https://stackoverflow.com/questions/27709456/what-is-the-difference-between-a-user-and-a-role/27709582
 */

CREATE USER harrypotter WITH PASSWORD 'dumbledore';

-- grant priveleges
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA kennyp TO harrypotter;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA kennyp FROM harrypotter;

CREATE ROLE super_user WITH
	CREATEDB
	CREATEROLE
	LOGIN
	INHERIT;
	
GRANT super_user TO harrypotter;