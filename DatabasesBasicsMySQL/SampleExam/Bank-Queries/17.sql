DELIMITER $$
CREATE PROCEDURE usp_take_loan(
						customer_id INT, loan_amount DECIMAL, interest DECIMAL, start_date DATE)
BEGIN
	START TRANSACTION;
	
	INSERT INTO loans(start_date, amount, interest, expiration_date, customer_id)
	 VALUES (start_date, loan_amount, interest, NULL, customer_id);
	 
	IF (loan_amount NOT BETWEEN 0.01 AND 100000) THEN
		ROLLBACK;
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid Loan Amount.';
	ELSE 
		COMMIT;
	END IF;
END $$

DELIMITER ;

CALL usp_take_loan (1, 0, 1,'20160915');

