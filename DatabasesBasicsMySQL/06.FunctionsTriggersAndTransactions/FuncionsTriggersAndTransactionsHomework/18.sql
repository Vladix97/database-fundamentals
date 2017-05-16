-- SELECT * FROM games AS g
-- WHERE g.name = 'Bali'
-- 
-- 
-- SELECT ug.id, COUNT(*)
-- FROM users_games AS ug
-- GROUP BY ug.id
-- 
-- 
-- 


SELECT * FROM users AS u
	WHERE u.user_name = 'baleremud' OR
			u.user_name = 'loosenoise' OR
			u.user_name = 'inguinalself' OR
			u.user_name = 'buildingdeltoid' OR
			u.user_name = 'monoxidecos';


UPDATE users_games AS ug
	SET ug.cash = ug.cash + 50000
 WHERE ug.game_id = 212 AND
 		 ug.user_id = 
