DELIMITER \\
CREATE PROCEDURE usp_get_employees_salary_above(border DECIMAL)
BEGIN
	SELECT ah.first_name, ah.last_name
		FROM account_holders AS ah
	 INNER JOIN accounts AS a
	  ON ah.id = a.account_holder_id
	 WHERE SUM(a.balance) > border;
END \\

DELIMITER ;

CALL usp_get_employees_salary_above(0);
