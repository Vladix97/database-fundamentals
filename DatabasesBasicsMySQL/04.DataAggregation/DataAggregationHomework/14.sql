CREATE TABLE modified_employees(SELECT * FROM employees WHERE salary > 30000);

DELETE FROM modified_employees WHERE manager_id = 42;

UPDATE modified_employees AS me SET me.salary = me.salary + 5000 WHERE me.department_id = 1;

SELECT me.department_id, AVG(me.salary) AS 'average_salary'
	FROM modified_employees AS me
	GROUP BY me.department_id;
