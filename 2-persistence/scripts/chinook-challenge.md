# Chinook SQL Lab
> *In this exercise you will practice populating a database by running the provided `chinook.sql` scripts in sequential order within DBeaver.  Use SQL Sublanguages to return the requested information below:*

<br>

## 1.0 Access the Chinook Schema
> *You don't have to do this...just use the schema I set up for you in the RDS* 

* In DBeaver,Create a new connection
* Click Postgres
* Enter `enterprise211129.cvtq9j4axrge.us-east-1.rds.amazonaws.com` as *Host*
* Password is `postgres`
* Test Connection > if successful, click finish
* Open a script in the **Chinook** Schema
`
<br>

## 2.0 Challenges


### 2.1 SELECT
* `SELECT` all records from the Employee table.
* `SELECT` all records from the Employee table where last name is King.
* `SELECT` all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

### 2.2 ORDER BY
* `SELECT` all albums in Album table and sort result set in descending order by title.
* `SELECT` first name from Customer and sort result set in ascending order by city

### 2.3 INSERT INTO
* `INSERT` two new records into Genre table 
* `INSERT` two new records into Employee table
* `INSERT` two new records into Customer table

### 2.4 UPDATE
* `UPDATE` Aaron Mitchell in Customer table to Robert Walter
* `UPDATE` name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	

### 2.5 LIKE
* `SELECT` all invoices with a billing address like “T%” 

### 2.6 BETWEEN
* `SELECT` all invoices that have a total between 15 and 50
* `SELECT` all employees hired between 1st of June 2003 and 1st of March 2004

### 2.7 DELETE
* `DELETE` a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
