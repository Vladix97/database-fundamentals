CREATE TABLE flights (
	flight_id INT PRIMARY KEY,
	departure_time DATETIME NOT NULL,
	arrival_time DATETIME NOT NULL,
	status ENUM('Departing', 'Delayed', 'Arrived', 'Cancelled'),
	origin_airport_id INT,
	destination_airport_id INT,
	airline_id INT,
	CONSTRAINT fk_flights_airports1 FOREIGN KEY(origin_airport_id)
	REFERENCES airports(airport_id),
	CONSTRAINT fk_flights_airports2 FOREIGN KEY(destination_airport_id)
	REFERENCES airports(airport_id),
	CONSTRAINT fk_flights_airports FOREIGN KEY(airline_id)
	REFERENCES airlines(airline_id)
);

CREATE TABLE tickets (
	ticket_id INT PRIMARY KEY,
	price DECIMAL(8, 2) NOT NULL,
	class ENUM('First', 'Second', 'Third'),
	seat VARCHAR(5) NOT NULL,
	customer_id INT,
	flight_id INT,
	CONSTRAINT fk_tickets_customers FOREIGN KEY(customer_id)
	REFERENCES customers(customer_id),
	CONSTRAINT fk_tickets_flights FOREIGN KEY(flight_id)
	REFERENCES flights(flight_id)
);
