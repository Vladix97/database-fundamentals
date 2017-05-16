SELECT cu.customer_id, cu.first_name, cu.last_name, cu.gender, ci.city_name
	FROM customers AS cu
	 INNER JOIN cities AS ci
	ON cu.city_id = ci.city_id
 WHERE (LEFT(cu.last_name, 2) = 'Bu' OR RIGHT(cu.first_name, 1) = 'a')
 	AND CHAR_LENGTH(ci.city_name) >= 8
 ORDER BY cu.customer_id;
