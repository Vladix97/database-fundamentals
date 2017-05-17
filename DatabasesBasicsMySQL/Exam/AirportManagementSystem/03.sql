UPDATE flights
    SET airline_id = 1
    WHERE status = 'Arrived';
    

    
SELECT * FROM tickets
    
UPDATE tickets
    SET price = price + price / 2
    WHERE flight_id IN(SELECT f.flight_id
										FROM flights AS f
										 INNER JOIN airlines AS a
										ON f.airline_id = a.airline_id
										WHERE a.airline_id = (SELECT a.airline_id 
																		FROM airlines AS a
																	  WHERE a.rating = (
																		 		SELECT MAX(a.rating) 
																				 	FROM airlines AS a)))
    
    
    
    
SELECT f.flight_id
	FROM flights AS f
	 INNER JOIN airlines AS a
	ON f.airline_id = a.airline_id
	WHERE a.airline_id = (SELECT a.airline_id 
									FROM airlines AS a
									 WHERE a.rating = (SELECT MAX(a.rating) FROM airlines AS a))	
    

    




