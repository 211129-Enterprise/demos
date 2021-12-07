
DROP TABLE IF EXISTS marouane.users CASCADE ;

CREATE TYPE marouane.users_role AS ENUM ('Admin', 'Customer', 'Employee');




CREATE TABLE marouane.users(
user_id  SERIAL  PRIMARY KEY ,
username VARCHAR(50) NOT NULL UNIQUE,
pwd varchar(50) NULL NULL,
user_role marouane.users_role NOT NULL 
);

DROP TABLE IF EXISTS  marouane.accounts CASCADE ;

CREATE  TABLE marouane.accounts(
id SERIAL PRIMARY KEY ,
balance numeric(50, 2 ) DEFAULT 0,
acc_owner integer NOT NULL REFERENCES marouane.users(user_id ),
active boolean DEFAULT FALSE 
);

DROP TABLE IF EXISTS  marouane.users_accounts_jt CASCADE ;

CREATE TABLE marouane.users_accounts_jt(

acc_owner integer NOT NULL REFERENCES marouane.users(user_id ),
account integer NOT NULL REFERENCES marouane.accounts(id)

);





