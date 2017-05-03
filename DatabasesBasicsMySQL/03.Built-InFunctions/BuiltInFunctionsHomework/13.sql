SELECT u.user_name AS 'Username', SUBSTRING(u.email, LOCATE('@', u.email) + 1) AS 'Email Provider' FROM users AS u
	ORDER BY 
		SUBSTRING(u.email, LOCATE('@', u.email) + 1), 
		u.user_name
