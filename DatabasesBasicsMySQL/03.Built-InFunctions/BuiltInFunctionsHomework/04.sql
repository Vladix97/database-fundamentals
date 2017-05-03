SELECT e.first_name, e.last_name FROM employees AS e
	WHERE e.job_title NOT LIKE '%engineer%'
