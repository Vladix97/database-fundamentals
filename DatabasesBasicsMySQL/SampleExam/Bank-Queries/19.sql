CREATE TABLE account_logs ( 
	account_id INT,
	account_number CHAR(12),
	start_date DATE,
	customer_id INT
);

DELIMITER $$
CREATE TRIGGER tr_log_records
BEFORE DELETE
ON accounts
FOR EACH ROW
BEGIN
	DELETE FROM employees_accounts
	 WHERE account_id = old.account_id;
	INSERT INTO account_logs(account_id, account_number, start_date, customer_id)
		VALUES (old.account_id, old.account_number, old.start_date, old.customer_id);
END $$


