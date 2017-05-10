SELECT e.employee_id, e.first_name, p.name
 FROM employees AS e
	INNER JOIN employees_projects AS ep
	 ON e.employee_id = ep.employee_id
	LEFT JOIN projects AS p
	 ON ep.project_id = p.project_id AND 
	 	 p.start_date < '20050101'
 WHERE e.employee_id = 24
 
