CREATE TABLE users (
	id INT UNIQUE AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	picture VARBINARY(2048),
	height DOUBLE,
	weight DOUBLE,
	gender CHAR(1),
	birthdate DATE NOT NULL,
	biography VARCHAR(55535)
)
