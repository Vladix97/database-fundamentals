SELECT g.name AS 'Game', 
	CASE 
		WHEN HOUR(g.`start`) >= 0 AND HOUR(g.`start`) < 12 THEN 'Morning'
		WHEN HOUR(g.`start`) >= 12 AND HOUR(g.`start`) <18 THEN 'Afternoon'
		ELSE 'Evening' 
   END AS 'Part of the Day', 
	CASE 
		WHEN g.duration <= 3 THEN 'Extra Short'
		WHEN g.duration >= 4 AND g.duration <= 6 THEN 'Short'
		WHEN g.duration > 6 THEN 'Long'
		ELSE 'Extra Long' 
   END AS 'Duration'
FROM games as g
ORDER BY g.name ASC, 'Duration' ASC, 'Part of the Day' ASC
	
