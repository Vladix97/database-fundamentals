DELIMITER $$
CREATE FUNCTION udf_concat_string(first_string VARCHAR(255), second_string VARCHAR(255))
RETURNS VARCHAR(255)
BEGIN
	DECLARE reversed_one VARCHAR(255);
	DECLARE reversed_two VARCHAR(255);
	DECLARE result VARCHAR(255);
	
	SET reversed_one := REVERSE(first_string);
	SET reversed_two := REVERSE(second_string);
	
	SET result := CONCAT(reversed_one, reversed_two);
	RETURN result;
END $$

