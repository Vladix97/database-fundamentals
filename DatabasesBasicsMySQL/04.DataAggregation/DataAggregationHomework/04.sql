SELECT wd.deposit_group
 FROM wizzard_deposits AS wd
 GROUP BY wd.deposit_group
 HAVING AVG(wd.magic_wand_size) = (
    SELECT AVG(wd.magic_wand_size)
    FROM wizzard_deposits AS wd
    GROUP BY wd.deposit_group
    ORDER BY AVG(wd.magic_wand_size)
    LIMIT 1
);
