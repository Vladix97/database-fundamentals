SELECT wd.deposit_group, SUM(wd.deposit_amount) AS 'total_amount'
	 FROM wizzard_deposits AS wd
	 WHERE wd.magic_wand_creator = 'Ollivander family'
 GROUP BY wd.deposit_group
  HAVING total_amount < 150000
ORDER BY total_amount DESC;
