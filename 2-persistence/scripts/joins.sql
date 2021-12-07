-- INNER JOIN: Selects all rows from both tables that have a matching common key
-- LEFT JOIN: Uses all rows of the table on the left side (of the statement) AND finds matching ROWS 
--   FROM the TABLE ON the RIGHT side
-- RIGHT JOIN: Uses all rows of the table on the right side (of the statement) AND finds matching ROWS 
--   FROM the TABLE ON the LEFT side
-- FULL JOIN: combines all rows from both tables

SELECT * FROM "Artist";

SELECT * FROM "Album";


-- RETURN THE ALBUM ID, TITLE, NAME(OF THE ARTIST) BY JOINING BOTH THE ALBUM AND ARTIST TABLES
-- inner join
CREATE VIEW simple_album_artist_view AS
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb,
	JOIN "Artist" art
	ON alb."ArtistId" = art."ArtistId";
	
SELECT * FROM simple_album_artist_view;

-- natural JOIN
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art
	WHERE("ArtistId"); -- ArtistId IS a COLUMN present IN BOTH TABLES

SELECT * FROM "Employee";

-- self JOIN
SELECT e1."FirstName", e1."Title", e2."FirstName" AS boss_firstName, e2."Title" AS boss_title
	FROM "Employee" e1
	JOIN "Employee" e2
	ON e1."ReportsTo" = e2."EmployeeId";

-- LEFT Join
SELECT * FROM "Track";
SELECT * FROM "InvoiceLine";

SELECT a."TrackId" , a."Name", b."InvoiceLineId" , b."InvoiceId" 
	FROM "Track" AS a
	LEFT JOIN "InvoiceLine" AS b
	ON a."TrackId" = b."TrackId";





