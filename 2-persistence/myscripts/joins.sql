/*
 * INNER JOIN: Selects all rows from both tables that have a matching common key
 * LEFT JOIN: Uses all rows of the table on the left side (of the statement) and finds matching rows
 * 			  from the table on the right side.
 * RIGHT JOIN: Uses all rows of the table on the right side (of the statement) and finds matching rows
 * 			   from the table on the left side
 * FULL JOIN: Combines all rows from both tables
 */

SELECT * FROM "Artist";
SELECT * FROM "Album";

-- Return the album ID, title, and name(of artist) by joining both album and artist table.
-- INNER JOIN
CREATE VIEW simple_album_artist_view AS 
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art
	ON alb."ArtistId" = art."ArtistId";

SELECT * FROM simple_album_artist_view;

-- natural join
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art
	USING("ArtistId");
	
SELECT * FROM "Employee";

-- self join
SELECT e1."FirstName", e1."Title", e2."FirstName" AS boss_firstname, e2."Title" AS boss_title
	FROM "Employee" e1
	JOIN "Employee" e2
	ON e1."ReportsTo" = e2."EmployeeId";
	
-- left join
SELECT * FROM "Track";
SELECT * FROM "InvoiceLine";

SELECT
	FROM "Track" AS a
	