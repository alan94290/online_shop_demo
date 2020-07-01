CREATE DATABASE  IF NOT EXISTS `online_shop_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `online_shop_demo`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: online_shop_demo
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `product_id` int NOT NULL,
  `username` varchar(20) NOT NULL,
  `quantity` int NOT NULL,
  `order_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (15,'alan94290',25,'2020-06-30 13:50:02','2020-06-30 17:27:06'),(15,'david0303',1,'2020-06-30 13:57:44','2020-06-30 13:57:44'),(17,'alan94290',4,'2020-06-30 13:21:15','2020-06-30 13:21:15'),(18,'alan94290',4,'2020-06-30 14:52:59','2020-06-30 14:52:59'),(18,'david0303',10,'2020-06-30 14:04:54','2020-06-30 17:27:47');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_image` varchar(100) DEFAULT NULL,
  `price` double NOT NULL,
  `inventory` int NOT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `upload_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (15,'alan94290','iPhone SE 2020','A6zj0Jsji5',16500,0,'128g','2020-06-30 03:38:03','2020-06-30 17:27:06'),(16,'alan94290','SONY DSC-RX100M6','QMDKuq8owr',8500,6,'camera','2020-06-30 03:41:55','0000-00-00 00:00:00'),(17,'david0303','Timberland','0oh67JRMfZ',3250,4,'商品特色\r\n銀級鞣皮廠製造的優質皮革\r\n防滑橡膠抓地齒大底\r\n加厚鞋領提升舒適度','2020-06-30 09:38:53','2020-06-30 14:52:59'),(18,'alan94290','VANS 衣服 基本款 經典短袖T恤 藍色','6ZcGWfowUs',800,2,'商品特色\r\nvans衣服 中T恤是vans夏裝中的主打款式系列。vansT恤設計上更加前衛時尚!vans衣服是挑戰和藝術并從。','2020-06-30 01:49:53','2020-06-30 17:27:47');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(48) NOT NULL,
  `name` varchar(10) NOT NULL,
  `cellnum` varchar(10) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `register_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('a12345678','asdfg12345','qwer12345@gmail.com','Quarter',NULL,NULL,'2020-06-27 09:13:43','0000-00-00 00:00:00'),('alan94290','asd12345','alan94290@yahoo.com.tw','郭致綸','0930128578','新北市板橋區','2020-06-21 14:32:02','2020-06-23 02:56:00'),('david0303','qwe23456','david0303@gmail.com','大衛','0916764646','新北市三重區','2020-06-21 14:33:37','2020-06-30 03:51:15'),('eji54jxp6830720','qwe98765','alan94290@gmail.com','Alan',NULL,NULL,'2020-06-24 05:38:20','0000-00-00 00:00:00'),('eji54xjp6','zxc12345','eji54xjp6@gmail.com','郭志豪',NULL,NULL,'2020-06-24 03:38:17','0000-00-00 00:00:00'),('kuo98765','qwe1234','qwe98765@gmail.com','Kuo',NULL,NULL,'2020-06-24 05:43:43','0000-00-00 00:00:00'),('zxc12345','qaz12345','zxc12345@gmail.com','Zack',NULL,NULL,'2020-06-27 09:10:17','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 14:33:29
