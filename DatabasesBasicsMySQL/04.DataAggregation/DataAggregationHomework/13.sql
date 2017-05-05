SELECT e.department_id, MIN(e.salary) AS min_salary
	FROM employees AS e
	WHERE 
		(e.department_id = 2 OR 
		e.department_id = 5 OR 
		e.department_id = 7) AND
		e.hire_date > '20000101'
	GROUP BY e.department_id;
