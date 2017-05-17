SELECT t.ticket_id, a.airport_name AS 'destination', CONCAT(c.first_name, ' ', c.last_name) AS 'customer_name'
	FROM tickets AS t
  INNER JOIN customers AS c
   ON t.customer_id = c.customer_id
  INNER JOIN flights AS f
   ON t.flight_id = f.flight_id
  INNER JOIN airports AS a
   ON f.destination_airport_id = a.airport_id
   WHERE t.price < 5000 AND t.class = 'First'

