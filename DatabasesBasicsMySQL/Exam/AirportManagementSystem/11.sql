SELECT 
	c.customer_id,
	CONCAT(c.first_name, ' ', c.last_name) AS 'full_name',
	t.town_name AS 'home_town'
  FROM customers AS c 
 	INNER JOIN towns AS t
 	 ON t.town_id = c.home_town_id
   INNER JOIN tickets AS ti
  ON c.customer_id = ti.customer_id
   INNER JOIN flights AS f
  ON ti.flight_id = f.flight_id
   INNER JOIN airports AS a
  ON f.origin_airport_id = a.airport_id
   INNER JOIN towns AS tow
  ON a.town_id = tow.town_id
 WHERE t.town_name = tow.town_name
 GROUP BY c.customer_id, full_name, home_town
ORDER BY c.customer_id ASC;
