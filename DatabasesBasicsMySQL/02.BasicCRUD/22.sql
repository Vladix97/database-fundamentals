UPDATE employees AS e
	SET e.salary = e.salary + e.salary * 0.12
WHERE 
	e.department_id = 1 OR
	e.department_id = 2 OR
	e.department_id = 4 OR
	e.department_id = 11;
	
SELECT salary FROM employees
