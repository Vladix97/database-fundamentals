SELECT 
	c.customer_id, 
	CONCAT(c.first_name, ' ', c.last_name) AS 'full_name',
	2016 - YEAR(c.date_of_birth) AS 'age'
	FROM customers AS c
  LEFT JOIN tickets AS t
   ON t.customer_id = c.customer_id
  INNER JOIN flights AS f
   ON t.flight_id = f.flight_id
 WHERE f.`status` = 'Departing'
  GROUP BY c.customer_id, full_name, age 
 ORDER BY 
 	age ASC, 
 	c.customer_id ASC;
