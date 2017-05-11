DELIMITER \\
CREATE PROCEDURE usp_get_employees_salary_above(border INT)
BEGIN
	SELECT e.first_name, e.last_name
		FROM employees AS e
	 WHERE e.salary >= border;
END \\

DELIMITER ;

CALL usp_get_employees_salary_above(48100);
