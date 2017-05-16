DELIMITER $$
CREATE TRIGGER tr_new_employee 
AFTER INSERT 
ON employees
FOR EACH ROW
BEGIN 
	UPDATE employees_loans AS el
		SET el.employee_id = new.employee_id
	 WHERE el.employee_id + 1 = new.employee_id;
END $$

DELIMITER ;
