DELIMITER \\
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT
BEGIN
	DECLARE start_value INT;
	DECLARE end_value INT;
	DECLARE does_contain INT;
	
	DECLARE current_char VARCHAR(1);
	
	SET does_contain := 1;
	SET start_value := 1;
	SET end_value := CHAR_LENGTH(word);
	
	WHILE (start_value <= end_value AND does_contain = 1) DO
		SET current_char := SUBSTR(word, start_value, 1);
		IF (set_of_letters LIKE CONCAT('%', current_char, '%') = 0) THEN
			SET does_contain := 0;
		END IF;
		
		SET start_value := start_value + 1;
	END WHILE;
	
	RETURN does_contain;
END \\

DELIMITER ;

SELECT 
	'Rob' AS 'word',
	'bobr' AS 'set_of_letters',
	 ufn_is_word_comprised('bobr', 'Rob') AS 'result'


