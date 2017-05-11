DELIMITER \\
CREATE PROCEDURE usp_get_towns_starting_with(startingCharacter VARCHAR(50))
BEGIN
	SELECT t.name
		FROM towns AS t
	 WHERE LEFT(t.name, CHAR_LENGTH(startingCharacter)) = startingCharacter;
END \\

DELIMITER ;

CALL usp_get_towns_starting_with('be');
