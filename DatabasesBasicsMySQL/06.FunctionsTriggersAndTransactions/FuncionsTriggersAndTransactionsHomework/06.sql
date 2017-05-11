DELIMITER \\
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(50))
BEGIN
	IF salary_level = 'low' THEN
		SELECT e.first_name, e.last_name
			FROM employees AS e
		 WHERE e.salary < 30000;
	ELSEIF salary_level = 'average' THEN
		SELECT e.first_name, e.last_name
			FROM employees AS e
		 WHERE e.salary >= 30000 AND e.salary <= 50000;
	ELSE 
		SELECT e.first_name, e.last_name
			FROM employees AS e
		 WHERE e.salary > 50000;
	END IF;
END \\

DELIMITER ;

CALL usp_get_employees_by_salary_level('low');



