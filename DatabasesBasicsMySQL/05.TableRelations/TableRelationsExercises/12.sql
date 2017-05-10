SELECT e.employee_id, e.first_name, p.name 
 FROM employees AS e
	INNER JOIN employees_projects AS ep 
		ON e.employee_id = ep.employee_id
	INNER JOIN projects AS p 
		ON p.project_id = ep.project_id
	WHERE p.start_date > '2002-08-13'
	  AND p.end_date IS NULL
ORDER BY e.employee_id ASC
LIMIT 5;
