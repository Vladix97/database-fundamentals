SELECT SUM(XX.DIFF) AS sum_difference
	FROM (SELECT deposit_amount - (
		SELECT deposit_amount 
			FROM wizzard_deposits WHERE id = g.id + 1) AS DIFF 
				FROM wizzard_deposits g) AS XX
