DELIMITER \\
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL, 
															yearly_interest_rate DECIMAL, 
															number_of_years DECIMAL)
RETURNS DECIMAL
BEGIN 
	DECLARE result DECIMAL;
	
	SET yearly_interest_rate := yearly_interest_rate + 1;
	SET result := initial_sum * (POW(yearly_interest_rate, number_of_years));
	RETURN result;
END \\

DELIMITER ;

SELECT 1000 * (POW(1 + 0.1, 5)

SELECT ufn_calculate_future_value(1000, 0.1, 5);
