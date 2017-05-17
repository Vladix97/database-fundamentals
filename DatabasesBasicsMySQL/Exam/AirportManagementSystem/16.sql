SELECT a.airport_id, a.airport_name, COUNT(*) AS 'passengers'
	FROM flights AS f
  INNER JOIN tickets AS t
   ON t.flight_id = f.flight_id
  INNER JOIN airports AS a
   ON f.origin_airport_id = a.airport_id
  WHERE f.`status` = 'Departing' 
 GROUP BY f.flight_id
 HAVING COUNT(*) >= 0
  ORDER BY a.airport_id;
  
