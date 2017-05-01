SELECT e.first_name, e.last_name FROM employees AS e
	WHERE e.manager_id IS NULL
