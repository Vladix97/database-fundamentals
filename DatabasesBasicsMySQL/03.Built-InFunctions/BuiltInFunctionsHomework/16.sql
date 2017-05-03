SELECT
	product_name,
	order_date,
	DATE_ADD(order_date, INTERVAL 3 DAY) AS 'Pay Due',
	DATE_ADD(order_date, INTERVAL 1 MONTH) AS 'Deliver Due'
FROM Orders
