SELECT c.ContinentCode, 
	   cc.CurrencyCode, 
	   COUNT(cc.COUNTryCode) AS [CurrencyUsage]
FROM Continents c
JOIN Countries cc ON c.ContinentCode = cc.ContinentCode 
GROUP BY c.ContinentCode , cc.CurrencyCode
HAVING COUNT(cc.CountryCode) = (SELECT MAX(xxx.CurrencyXX) 
                                FROM (SELECT cx.ContinentCode, 
										     ccx.CurrencyCode, 
											 COUNT(ccx.COUNTryCode) AS [CurrencyXX]
    FROM Continents cx
    JOIN Countries ccx ON cx.ContinentCode = ccx.ContinentCode 
    WHERE c.ContinentCode = cx.ContinentCode 
    GROUP BY cx.ContinentCode , ccx.CurrencyCode) AS xxx)
AND COUNT(cc.CountryCode) > 1
ORDER BY c.ContinentCode
