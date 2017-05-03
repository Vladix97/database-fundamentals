SELECt * FROM towns AS t
	WHERE 
		t.name NOT LIKE 'R%' AND
		t.name NOT LIKE 'B%' AND
		t.name NOT LIKE 'D%'
	ORDER BY
		t.name ASC;
	
