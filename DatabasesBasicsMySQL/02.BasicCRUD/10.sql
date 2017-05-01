SELECT CONCAT(e.first_name, ' ', e.middle_name, ' ', e.last_name) AS 'full_name' 
	FROM employees AS e
	WHERE e.salary = 25000 OR 
			e.salary = 14000 OR
			e.salary = 12500 OR
			e.salary = 23600;
