SELECT COUNT(*) AS countr_code
	FROM countries AS cou
  LEFT JOIN mountains_countries AS mc
 	ON cou.country_code = mc.country_code
 WHERE mc.mountain_id IS NULL
