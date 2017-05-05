SELECT 
	wd.deposit_group, 
	wd.is_deposit_expired,
 	AVG(wd.deposit_interest) AS 'average_interest'
	 FROM wizzard_deposits AS wd
 	WHERE wd.deposit_start_date > '19850101'
 GROUP BY wd.deposit_group, wd.is_deposit_expired
 ORDER BY wd.deposit_group DESC


