-- Database Setup

drop type if exists johntb.user_role cascade;
create type johntb.user_role as enum ('Admin', 'Customer', 'Employee');

drop table if exists johntb.users cascade;
create table johntb.users (
    id serial primary key,
    username varchar(50) not null unique,
    pwd varchar(50) not null,
    user_role johntb.user_role not null
);

drop table if exists johntb.accounts cascade;
create table johntb.accounts (
    id serial primary key,
    balance numeric(50, 2) default 0,
    acc_owner int not null references johntb.users(id),
    active boolean default false
);

drop table if exists johntb.users_accounts_jt cascade;
create table johntb.users_accounts_jt (
    acc_owner integer not null references johntb.users(id),
    account integer not null references johntb.accounts(id)
);

-- Database Population

insert into johntb.users (username, pwd, user_role)
    values ('Larry', 'pass', 'Employee'),
           ('Mary', '1234', 'Customer'),
           ('Barry', 'pass', 'Customer');
          
insert into johntb.accounts (balance, acc_owner)
    values ('100', 1),
           ('200', 2),
           ('2000', 2),
           ('400', 3);
           
select * from johntb.accounts;

insert into users_accounts_jt (acc_owner, account)
    values (1, 1),
           (2, 2),
           (2, 3),
           (3, 4);
           
select * from users_accounts_jt 