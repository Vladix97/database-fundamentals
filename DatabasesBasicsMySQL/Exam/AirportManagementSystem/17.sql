DELIMITER $$
CREATE PROCEDURE usp_submit_review(
				customer_id INT, review_content VARCHAR(255), review_grade INT, airline_name VARCHAR(255))
BEGIN
	DECLARE airline_id INT;
	DECLARE review_id INT;
	
	SET airline_id := -1;
	SET review_id := SELECT cr.review_id FROM customer_reviews AS cr ORDER BY cr.review_id DESC LIMIT 1; 
	SET review_id := review_id + 1;
	SET airline_id := SELECT a.airline_id FROM airlines AS a WHERE a.airline_name = airline_name;
	
	IF airline_id = -1 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Airline does not exist.';
	ELSE
		INSERT INTO customer_reviews(review_content, review_grade, airline_id, customer_id)
			VALUES 
				(review_id, review_content, review_grade, airline_id, customer_id)
	END IF;
	
END $$
	
	
