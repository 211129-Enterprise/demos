-- INNER JOIN: Selects all rows from both tables
-- LEFT JOIN: uses all rows of the table on the left side

-- FROM the TABLE ON THE RIGHT SIDE

-- RIGHT JOIN: Uses all the rows of the table on the right side
-- FROM the TABLE ON the LEFT side

-- FULL JOIN: combines all rows from both tables

SELECT * FROM "Artist";
SELECT * FROM "Album";

CREATE VIEW simple_album_artist_view AS 
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art 
	ON alb."ArtistId" = art."ArtistId";
	
	SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art 
	USING("ArtistId");