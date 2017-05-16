CREATE TABLE employees_cities (
	first_name VARCHAR(20),
	city_name VARCHAR(20)
);

INSERT INTO employees_cities (first_name, city_name)
SELECT e.first_name, c.city_name
	FROM employees AS e
  INNER JOIN branches AS b
	ON e.branch_id = b.branch_id
  INNER JOIN cities AS c
   ON b.city_id = c.city_id
 LIMIT 3;
 
INSERT INTO employees_cities (first_name, city_name)
SELECT cu.first_name, ci.city_name
	FROM customers AS cu
  INNER JOIN cities AS ci
   ON cu.city_id = ci.city_id
 LIMIT 3;
 
 
SELECT * FROM employees_cities;
 
DROP TABLE employees_cities;
	
