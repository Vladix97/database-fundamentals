SELECT t.name FROM towns AS t
	WHERE CHAR_LENGTH(t.name) = 5 OR CHAR_LENGTH(t.name) = 6
	ORDER BY t.name ASC
