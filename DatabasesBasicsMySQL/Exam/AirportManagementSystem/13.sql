SELECT 
	c.customer_id,
	CONCAT(c.first_name, ' ', c.last_name) AS 'full_name',
	t.price, 
	a.airport_name AS 'destination'
	FROM customers AS c
  INNER JOIN tickets AS t
	ON t.customer_id = c.customer_id	
  INNER JOIN flights AS f
   ON t.flight_id = f.flight_id
  INNER JOIN airports AS a
   ON f.destination_airport_id = a.airport_id
 WHERE f.`status` = 'Delayed'
  ORDER BY 
  	t.price DESC,
  	c.customer_id ASC
 LIMIT 3;
  	
  	
  	
   
