DELIMITER $$
CREATE PROCEDURE usp_purchase_ticket(
				customer_id INT, flight_id INT, ticket_price DECIMAL, class VARCHAR(255), seat VARCHAR(255))
BEGIN
	START TRANSACTION;
	
	DECLARE customer_amount DECIMAL;
	DECLARE account_id INT;
	
	SET customer_amount = (SELECT cba.balance
								  		FROM customer_bank_accounts AS cba 
									 WHERE cba.customer_id = customer_id);
									 
	SET ticket_id = (SELECT t.ticket_id + 1
								FROM tickets AS t
							ORDER BY t.ticket_id DESC
							LIMIT 1);		 
	
	INSERT INTO tickets(ticket_id, price, class, seat, customer_id, flight_id)
		VALUES 
			(ticket_id, ticket_price, class, seat, customer_id, flight_id);
			
	IF customer_amount < ticket_price THEN
		ROLLBACK;
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient bank account balance for ticket purchase.';
	ELSE
		UPDATE customer_bank_accounts AS cba
			SET cba.balance = cba.account_id - ticket_price
		 WHERE cba.customer_id = customer_id;
		COMMIT;
	END IF;
						 	
END $$

DELIMITER ;


