SELECT c.country_code, COUNT(*) AS 'mountain_ranges'
	FROM countries AS c
	 INNER JOIN mountains_countries AS mc
		ON c.country_code = mc.country_code
	 INNER JOIN mountains AS m
		ON mc.mountain_id = m.id
	WHERE c.country_name IN ('Bulgaria', 'Russia', 'United States')
 GROUP BY c.country_code
