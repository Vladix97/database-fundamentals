CREATE DATABASE talbe_relation;

USE table_ralation;

CREATE TABLE passports (
	passport_id INT,
	passport_number VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE persons (
	id INT,
	first_name VARCHAR(50),
	salary DECIMAL(10,2),
	passport_id INT UNIQUE,
	PRIMARY KEY (id),
	CONSTRAINT fk_persons_passports FOREIGN KEY (passport_id) 
	REFERENCES passports (passport_id)
);

INSERT INTO passports (id, passport_number)
VALUES (101, 'N34FG21B');
INSERT INTO passports (id, passport_number)
VALUES (102, 'K65LO4R7');
INSERT INTO passports (id, passport_number)
VALUES (103, 'ZE657QP2');
		
INSERT INTO persons (id, first_name, salary, passport_id) 
VALUES (1, 'PESHO', 43300.0000, 102);
INSERT INTO persons (id, first_name, salary, passport_id) 
VALUES (2, 'Tom', 56100, 103);
INSERT INTO persons (id, first_name, salary, passport_id) 
VALUES (3, 'Yana', 60200.00, 101);
