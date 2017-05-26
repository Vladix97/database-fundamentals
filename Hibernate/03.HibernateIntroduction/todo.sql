UPDATE employees
  SET salary = salary + salary * 0.12
  WHERE address_id IN(28, 42);
  
  
  
  SELECT e.employee_id FROM departments AS d
    INNER JOIN employees AS e
      ON d.department_id = e.department_id
  WHERE d.name = 'Engineering' OR d.name = 'Tool Design' OR d.name = 'Marketing' OR d.name = 'Information Services'
