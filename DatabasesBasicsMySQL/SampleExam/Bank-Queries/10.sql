SELECT 
	SUM(l.amount) AS 'total_loan_amount',
	MAX(l.interest) AS 'max_interest',
	MIN(e.salary) AS 'min_employee_salary'
	FROM loans as l
  INNER JOIN employees_loans AS el
   ON l.loan_id = el.loan_id
  INNER JOIN employees as e
   ON el.employee_id = e.employee_id;
