SELECT c.city_name, b.name, COUNT(*) AS 'employees_count'
	FROM cities AS c 
  INNER JOIN branches AS b
   ON c.city_id = b.city_id
  INNER JOIN employees AS e
   ON b.branch_id = e.branch_id
   WHERE c.city_id NOT IN(4, 5)
   GROUP BY c.city_name, b.name
 HAVING COUNT(*) >= 3; 
