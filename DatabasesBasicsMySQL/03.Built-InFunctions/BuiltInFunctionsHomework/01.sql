SELECT e.first_name, e.last_name FROM employees AS e
	WHERE SUBSTRING(e.first_name, 1, 2) = 'SA'
