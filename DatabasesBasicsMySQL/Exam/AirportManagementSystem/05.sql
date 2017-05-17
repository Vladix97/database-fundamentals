INSERT INTO customer_reviews (review_id, review_content, review_grade, airline_id, customer_id) 
	VALUES
		(1, 'Me is very happy. Me likey this airline. Me good.', 10, 1, 1),
		(2, 'Ja, Ja, Ja... Ja, Gut, Gut, Ja Gut! Sehr Gut!', 10, 1, 4),
		(3, 'Meh...', 5, 4, 3),
		(4, 'Well Ive seen better, but Ive certainly seen a lot worse...', 7, 3, 5);
		
		
INSERT INTO customer_bank_accounts (account_id, account_number, balance, customer_id)
	VALUES
		(1, '123456790', 2569.23, 1),
		(2, '18ABC23672', 14004568.23, 2),
		(3, 'F0RG0100N3', 19345.20, 5);
