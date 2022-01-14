--INNER JOIN select all rows that have matching common key
--LEFT JOIN uses all rows of the table on the left side of the statement and finds matching rows from the right table
--RIGHT JOIN opposite of right join
--FULL JOIN combines all rows from both tables

SELECT * FROM "Artist";
SELECT * FROM "Album";

--Say we want the artist alongside their albums

CREATE VIEW simple_album_artist_view AS 
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art 
	ON alb."ArtistId" = art."ArtistId";
	
SELECT * FROM simple_album_artist_view;

--natural join
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art 
	USING("ArtistId");
	

SELECT e1."First Name", e1."Title", e2."First Name", AS boss_firstName e2."Title" AS boss_title
	FROM "Employee" e1 
	FROM "Employee" e2
	ON e1."ReportsTo" = e2."EmployeeId";

--LEFT Join
SELECT * FROM "Track";
SELECT * FROM "InvoiceLine";

SELECT a."TrackId", a."Name", b."InvoiceLineId", b."InvoiceId" 
	FROM "Track" AS a
	LEFT JOIN "InvoiceLine" AS b
	ON a."TrackId" = b."TrackId";
	