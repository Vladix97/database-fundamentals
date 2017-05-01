SELECT e.first_name, e.last_name, e.salary FROM employees AS e
	WHERE e.salary > 50000
	ORDER BY e.salary DESC
