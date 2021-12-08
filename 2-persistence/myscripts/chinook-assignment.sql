-- 2.1 SELECT 
SELECT * FROM "Employee";
SELECT * FROM "Employee" WHERE "LastName" = 'King';
SELECT * FROM "Employee" WHERE "FirstName" = 'Andrew' AND "ReportsTo" = NULL;

-- 2.2 ORDER BY
SELECT * FROM "Album" ORDER BY "Title" DESC;
SELECT "FirstName" FROM "Customer" ORDER BY "City" ASC;

-- 2.3 INSERT INTO
SELECT * FROM "Artist"
INSERT INTO "Artist"
	VALUES (276, 'GARNET CROW');
SELECT * FROM "Artist" WHERE "Name" = 'GARNET CROW'
SELECT * FROM "Album";
INSERT INTO "Album"
	VALUES (348, 'Stay: Yoake no Soul', 276),
		   (349, 'Memories', 276);

INSERT INTO "Employee" ("LastName", "FirstName", "Title")
	VALUES ('Jacobs', 'Joseph', 'Cashier'),
		   ('')