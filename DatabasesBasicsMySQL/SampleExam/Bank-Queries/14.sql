SELECT cu.customer_id, cu.first_name, acc.start_date
	FROM customers AS cu
  INNER JOIN accounts AS acc
  ON cu.customer_id = acc.customer_id
  WHERE acc.start_date = (SELECT MIN(acc.start_date) 
									  FROM accounts AS acc);
