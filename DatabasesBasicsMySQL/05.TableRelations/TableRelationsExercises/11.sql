SELECT e.employee_id, e.first_name
	FROM employees AS e
 LEFT OUTER JOIN employees_projects AS ep
  ON e.employee_id = ep.employee_id
 WHERE ep.project_id IS NULL
 ORDER BY e.employee_id ASC
 LIMIT 3;
