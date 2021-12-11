
-- 2.1 SELECT 
select * from chinook."Employee" e ;


select * from chinook."Employee" e 
WHERE e."LastName" = 'King';

SELECT * FROM chinook."Employee" e 
WHERE e."FirstName" = 'Andrew' AND e."ReportsTo" IS NULL;

-- 2.2 ORDER BY

SELECT * FROM chinook."Album" a 
ORDER BY a."Title" DESC;

-- SELECT first name from Customer and sort result set in ascending order by city

SELECT c."FirstName" FROM chinook."Customer" c
ORDER BY c."City"; -- can use ASC


-- 2.3 INSERT INTO

INSERT INTO chinook."Genre" ("GenreId" ,"Name")  VALUES (26, 'Larry'), (27, 'Marry');

INSERT INTO chinook."Employee" VALUES (9,'Parkenson', 'William', 'IT Manager', 1, '1996-03-02', Now(), '771 10 Street', 'Lethbridge', 'AB', 'Canada', 'T1K 5N8', '+1 (321) 231-3123', '+1 (321) 231-3123', 'william@mail.com');


INSERT INTO chinook."Employee" VALUES (10,'James', 'Henry', 'Sales Support Agent', 2, '1986-03-01', Now(), '323 11 Street', 'Calgary', 'AB', 'Canada', 'T3B 5N8', '+1 (321) 431-3123', '+1 (321) 121-3123', 'henry@mail.com');

INSERT INTO chinook."Customer"
VALUES (60, 'Lucas', 'William', NULL, '132 W Street', 'Madrid', 'NSW', 'Spain', '23123', '+1 (123) 231-1231', NULL, 'william@mail.com', 2),(61, 'Lima', 'Sheikh', NULL, '132 E Street', 'London', 'NSW', 'Australia', '23565', '+1 (929) 231-1231', NULL, 'limasheikh@mail.com', 2);



-- 2.4 UPDATE
--UPDATE Aaron Mitchell in Customer table to Robert Walter
--UPDATE name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE chinook."Customer"
SET "FirstName" = 'Robert', "LastName" = 'Walter'
WHERE "FirstName"  = 'Lima' AND "LastName"  = 'Sheikh';


UPDATE chinook."Artist" 
SET "Name" = 'CCR'
WHERE  "Name"  = 'Creedence Clearwater Revival';


SELECT * FROM chinook."Artist" a WHERE a."Name"  = 'CCR';

-- 2.5 LIKE
-- SELECT all invoices with a billing address like “T%”

SELECT * FROM chinook."Invoice" i 
WHERE "BillingAddress" LIKE 'T%';

-- 2.6 BETWEEN
-- SELECT all invoices that have a total between 15 and 50
-- SELECT all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM chinook."Invoice" i 
WHERE "Total" BETWEEN 15 AND 50;

SELECT * FROM chinook."Employee" e 
WHERE "HireDate" BETWEEN '2003-06-01' AND '2004-03-01';

-- 2.7 DELETE
-- DELETE a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).


SELECT * FROM "Customer" c
WHERE c."FirstName" = 'Robert';

-- no contraints found because i added that. 
DELETE FROM chinook."Customer" 
WHERE "FirstName" = 'Robert'AND "LastName" ='Walter';



alter table chinook."Customer" 
drop constraint "FK_CustomerSupportRepId";

alter table chinook."Customer" 
add constraint "FK_CustomerSupportRepId"
foreign key ("SupportRepId")
REFERENCES chinook."Employee"("EmployeeId")
on delete cascade;


alter table chinook."Invoice" 
drop constraint "FK_InvoiceCustomerId";

alter table chinook."Invoice" 
add constraint "FK_InvoiceCustomerId"
foreign key ("CustomerId")
REFERENCES chinook."Customer"("CustomerId")
on delete cascade;


alter table chinook."InvoiceLine"
drop constraint "FK_InvoiceLineInvoiceId";

alter table chinook."InvoiceLine"
add constraint "FK_InvoiceLineInvoiceId1"
foreign key ("InvoiceId")
REFERENCES chinook."Invoice"("InvoiceId")
on delete cascade;



DELETE FROM chinook."Customer" 
WHERE "FirstName" = 'Robert'AND "LastName" ='Brown';
