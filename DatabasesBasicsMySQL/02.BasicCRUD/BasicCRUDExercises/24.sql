SELECT c.country_name, c.population from countries AS c
	WHERE c.continent_code = 'EU'
	ORDER BY 
		c.population DESC,
		c.country_name ASC
	LIMIT 30;
