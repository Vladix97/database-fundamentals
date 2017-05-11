DELIMITER //
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL)
RETURNS VARCHAR(50)
BEGIN
   DECLARE salary_level varchar(50);

   IF salary < 30000 THEN
      SET salary_level = 'Low';
   ELSEIF salary >= 30000 AND salary <= 50000 THEN
      SET salary_level = 'Average';
   ELSE
      SET salary_level = 'High';
   END IF;

   RETURN salary_level;

END //

DELIMITER ;

SELECT e.salary, ufn_get_salary_level(e.salary)
	FROM employees AS e


