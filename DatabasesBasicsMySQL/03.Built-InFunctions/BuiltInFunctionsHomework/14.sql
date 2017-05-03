SELECT u.user_name AS 'Username', u.ip_address AS 'IP Address' FROM users AS u
	WHERE u.ip_address LIKE '___.1%.%.___'
	ORDER BY u.user_name
