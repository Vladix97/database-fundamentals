SELECT c.country_name, c.iso_code FROM countries as c
	WHERE CHAR_LENGTH(c.country_name) - CHAR_LENGTH(REPLACE(LOWER(c.country_name), 'a', '')) >= 3
	ORDER BY
		c.iso_code
