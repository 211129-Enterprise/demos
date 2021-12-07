

SELECT * FROM "Artist";
SELECT * FROM "Album";


-- INNER JOIN --
-- Return the album id, title, and name of the artist by joining both the album and artist tables
CREATE VIEW simple_album_artist_view_inner_join AS
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Artist" alb
	JOIN "Artist" art
	ON alb."ArtistId"  = art."ArtistId";
--SELECT * FROM simple_album_artist_view_inner_join;





-- NATURAL JOIN --
CREATE VIEW simple_album_artist_view_natural_join AS
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art
	WHERE ("ArtistId"); --ArtistId IS a COLUMN IN BOTH TABLES 
	
	
	
	
-- SELF JOIN --	
SELECT * FROM "Employee";
SELECT e1."FirstName", e1."Title", e2."FirstName" AS boss_firstName, e2."Title" AS boss_title
	FROM "Employee" e1
	JOIN "Employee" e2
	ON e1."ReportsTo" = e2."EmployeeId";





-- LEFT JOIN --
SELECT * FROM "Track";
SELECT * FROM "InvoiceLine";

SELECT a."TrackId", a."Name", b."InvoiceLineId", b."InvoiceId" 
	FROM "Track" AS a
	LEFT JOIN "InvoiceLine" AS b
	ON a."TrackId" = b."TrackId";