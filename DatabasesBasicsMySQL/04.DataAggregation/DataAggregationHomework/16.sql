SELECT e.department_id, MAX(e.salary) AS 'third_max_salary' FROM employees AS e
JOIN
(SELECT e.department_id, MAX(e.salary) AS 'second_max_salary' FROM employees AS e
JOIN
(SELECT e.department_id, MAX(e.salary) AS 'first_max_salary' 
	FROM employees AS e
 GROUP BY e.department_id) AS first_max_salary
 	ON e.department_id = first_max_salary.department_id
 	AND e.salary < first_max_salary.first_max_salary
 GROUP BY e.department_id) as second_max_salary
	ON e.department_id = second_max_salary.department_id
	AND e.salary < second_max_salary.second_max_salary
 GROUP BY e.department_id
