SELECT e.first_name, e.last_name, e.job_title
	from employees AS e
	WHERE e.salary >= 20000 AND e.salary <= 30000
