CREATE TABLE customer_reviews (
	review_id INT PRIMARY KEY,
	review_content VARCHAR(255) NOT NULL,
	review_grade INT,
	airline_id INT,
	customer_id INT,
	CONSTRAINT fk_customer_reviews_airlines FOREIGN KEY(airline_id)
	REFERENCES airlines(airline_id),
	CONSTRAINT fk_customer_reviews_customers FOREIGN KEY(customer_id)
	REFERENCES customers(customer_id)
);

CREATE TABLE customer_bank_accounts (
	account_id INT PRIMARY KEY,
	account_number VARCHAR(10) NOT NULL UNIQUE,
	balance DECIMAL(10, 2),
	customer_id INT,
	CONSTRAINT fk_customer_bank_accounts_customers FOREIGN KEY(customer_id)
	REFERENCES customers(customer_id)
);
