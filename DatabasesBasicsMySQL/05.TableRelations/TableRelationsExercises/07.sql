-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.18-0ubuntu0.16.04.1 - (Ubuntu)
-- Server OS:                    Linux
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for online_store
CREATE DATABASE IF NOT EXISTS `online_store` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `online_store`;

-- Dumping structure for table online_store.cities
CREATE TABLE IF NOT EXISTS `cities` (
  `city_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.cities: ~0 rows (approximately)
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;

-- Dumping structure for table online_store.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `customer_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `fk_customers_cities` (`city_id`),
  CONSTRAINT `fk_customers_cities` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.customers: ~0 rows (approximately)
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;

-- Dumping structure for table online_store.items
CREATE TABLE IF NOT EXISTS `items` (
  `item_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `item_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_items_item_types` (`item_type_id`),
  CONSTRAINT `fk_items_item_types` FOREIGN KEY (`item_type_id`) REFERENCES `item_types` (`item_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.items: ~0 rows (approximately)
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
/*!40000 ALTER TABLE `items` ENABLE KEYS */;

-- Dumping structure for table online_store.item_types
CREATE TABLE IF NOT EXISTS `item_types` (
  `item_type_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`item_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.item_types: ~0 rows (approximately)
/*!40000 ALTER TABLE `item_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_types` ENABLE KEYS */;

-- Dumping structure for table online_store.majors
CREATE TABLE IF NOT EXISTS `majors` (
  `major_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.majors: ~0 rows (approximately)
/*!40000 ALTER TABLE `majors` DISABLE KEYS */;
/*!40000 ALTER TABLE `majors` ENABLE KEYS */;

-- Dumping structure for table online_store.oder_items
CREATE TABLE IF NOT EXISTS `oder_items` (
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`item_id`),
  KEY `fk_order_items_items` (`item_id`),
  CONSTRAINT `fk_order_items_items` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`),
  CONSTRAINT `fk_order_items_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.oder_items: ~0 rows (approximately)
/*!40000 ALTER TABLE `oder_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `oder_items` ENABLE KEYS */;

-- Dumping structure for table online_store.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_orders_customers` (`customer_id`),
  CONSTRAINT `fk_orders_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.orders: ~0 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table online_store.payments
CREATE TABLE IF NOT EXISTS `payments` (
  `payment_id` int(11) NOT NULL,
  `payment_date` date DEFAULT NULL,
  `payment_amount` decimal(8,2) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `fk_payments_students` (`student_id`),
  CONSTRAINT `fk_payments_students` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.payments: ~0 rows (approximately)
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;

-- Dumping structure for table online_store.students
CREATE TABLE IF NOT EXISTS `students` (
  `student_id` int(11) NOT NULL,
  `student_number` varchar(12) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `fk_students_majors` (`major_id`),
  CONSTRAINT `fk_students_majors` FOREIGN KEY (`major_id`) REFERENCES `majors` (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table online_store.students: ~0 rows (approximately)
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
