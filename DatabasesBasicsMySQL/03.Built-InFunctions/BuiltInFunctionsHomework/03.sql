SELECT e.first_name FROM employees as e
	WHERE 
		(e.department_id = 3 OR e.department_id = 10) AND
		(YEAR(e.hire_date) >= 1995 AND YEAR(e.hire_date) <= 2005)
