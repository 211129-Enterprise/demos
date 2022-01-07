CREATE TABLE heroes (
	hero_id SERIAL PRIMARY KEY,
	hero_name VARCHAR(50)
);

INSERT INTO heroes(hero_name) 
	VALUES ('Ant-Man'),
			('The Falcon');

SELECT * FROM heroes;