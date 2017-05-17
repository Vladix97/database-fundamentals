SELECT f.flight_id, f.departure_time, f.arrival_time, air1.airport_name, air2.airport_name
	FROM flights AS f
  INNER JOIN airports AS air1
   ON f.origin_airport_id = air1.airport_id
  INNER JOIN airports AS air2
   ON f.destination_airport_id = air2.airport_id
 ORDER BY 
 	f.departure_time DESC,
 	f.flight_id ASC
 	LIMIT 5;
