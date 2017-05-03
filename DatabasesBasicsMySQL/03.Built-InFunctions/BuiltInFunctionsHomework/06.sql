SELECt * FROM towns AS t
	WHERE 
		t.name LIKE 'M%' OR
		t.name LIKE 'K%' OR
		t.name LIKE 'B%' OR
		t.name LIKE 'E%'
	ORDER BY
		t.name ASC;
	
