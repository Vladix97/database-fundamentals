SELECT wd.deposit_group, SUM(wd.deposit_amount) 
	FROM wizzard_deposits AS wd
 GROUP BY wd.deposit_group;
