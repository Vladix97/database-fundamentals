SELECT g.name, DATE_FORMAT(g.`start`, '%Y-%m-%d') from games as g
	WHERE YEAR(g.`start`) = 2011 OR YEAR(g.`start`) = 2012
	ORDER BY 
			g.`start`,
			g.name
	LIMIT 50
