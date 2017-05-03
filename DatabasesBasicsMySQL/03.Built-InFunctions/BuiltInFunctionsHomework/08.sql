CREATE VIEW v_employees_hired_after_2000 AS
	SELECT e.first_name, e.last_name FROM employees AS e
	WHERE YEAR(e.hire_date) > 2000
