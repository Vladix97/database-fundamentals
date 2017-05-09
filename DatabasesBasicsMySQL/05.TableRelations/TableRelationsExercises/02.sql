CREATE TABLE manufacturers (
	manufacturer_id INT AUTO_INCREMENT,
	name VARCHAR(50),
	manufacturer_on DATE,
	PRIMARY KEY (manufacturer_id)
);
		
CREATE TABLE models (
	id INT,
	name VARCHAR(50),
	manufacturer_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY(manufacturer_id) REFERENCES manufacturers(manufacturer_id)
);

INSERT INTO manufacturers (name, manufacturer_on)
	VALUES 
		('BMW', '1916-07-03'),
		('Tesla', '2003-01-01'),
		('Lada', '1996-01-05');
