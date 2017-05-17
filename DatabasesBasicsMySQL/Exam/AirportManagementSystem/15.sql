SELECT 
	c.customer_id, 
	CONCAT(c.first_name , ' ', c.last_name) AS 'full_name',
	2016 - YEAR(c.date_of_birth) AS 'age'
	FROM customers AS c
  INNER JOIN tickets as t
  	ON t.customer_id = c.customer_id
  INNER JOIN flights AS f
   ON t.flight_id = f.flight_id
 WHERE f.`status` = 'Arrived' AND (2016 - YEAR(c.date_of_birth) < 21)
 GROUP BY c.customer_id, full_name, age
 ORDER BY 
	age DESC,
	c.customer_id ASC;
	
