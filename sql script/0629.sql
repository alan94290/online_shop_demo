CREATE DATABASE  IF NOT EXISTS `online_shop_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `online_shop_demo`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: online_shop_demo
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
  `product_image` varchar(100) DEFAULT NULL,
  `product_name` varchar(30) NOT NULL,
  `quantity` int NOT NULL,
  `unit_price` double NOT NULL,
  `order_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
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
  `product_name` varchar(20) NOT NULL,
  `product_image` varchar(100) DEFAULT NULL,
  `price` double NOT NULL,
  `inventory` int NOT NULL,
  `detail` varchar(200) DEFAULT NULL,
  `upload_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'alan94290','queen','',35,4,'test test test',NULL,NULL),(2,'alan94290','test','',50,6,'test test test',NULL,NULL),(3,'alan94290','Witcher','',358,6,'wallpaper from witcher 3 website','2020-06-28 08:27:42','0000-00-00 00:00:00'),(6,'alan94290','Siri','2',364,10,'Siri test1','2020-06-28 15:37:49','0000-00-00 00:00:00');
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
  `modify_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('a12345678','asdfg12345','qwer12345@gmail.com','Quarter',NULL,NULL,'2020-06-27 09:13:43','0000-00-00 00:00:00'),('alan94290','asd12345','alan94290@yahoo.com.tw','郭致綸','0930128578','新北市板橋區','2020-06-21 14:32:02','2020-06-23 02:56:00'),('david0303','qwe23456','david0303@gmail.com','大衛',NULL,NULL,'2020-06-21 14:33:37','2020-06-23 02:52:02'),('eji54jxp6830720','qwe98765','alan94290@gmail.com','Alan',NULL,NULL,'2020-06-24 05:38:20','0000-00-00 00:00:00'),('eji54xjp6','zxc12345','eji54xjp6@gmail.com','郭志豪',NULL,NULL,'2020-06-24 03:38:17','0000-00-00 00:00:00'),('kuo98765','qwe1234','qwe98765@gmail.com','Kuo',NULL,NULL,'2020-06-24 05:43:43','0000-00-00 00:00:00'),('zxc12345','qaz12345','zxc12345@gmail.com','Zack',NULL,NULL,'2020-06-27 09:10:17','0000-00-00 00:00:00');
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

-- Dump completed on 2020-06-29  8:42:49
