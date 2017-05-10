SELECT e.employee_id, e.first_name, e.manager_id, emp.first_name 
	FROM employees AS e
 INNER JOIN employees AS emp
 	ON e.manager_id = emp.employee_id AND 
 		emp.employee_id IN (3, 7)
 ORDER BY e.employee_id
