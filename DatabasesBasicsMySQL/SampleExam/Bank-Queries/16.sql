DELIMITER $$
CREATE PROCEDURE usp_customers_with_unexpired_loans(id INT)
BEGIN
	SELECT c.customer_id, c.first_name, l.loan_id
		FROM customers AS c
		 INNER JOIN loans AS l
		  ON l.customer_id = id
		 WHERE c.customer_id = id 
			AND l.expiration_date IS NULL;
END $$
	
DELIMITER ;

CALL usp_customers_with_unexpired_loans(9);

SELECT * 
	FROM loans AS l
    INNER JOIN customers AS c
   ON l.customer_id = c.customer_id
   WHERE c.first_name = 'Bobby'
