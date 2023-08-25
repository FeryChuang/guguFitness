CREATE DATABASE  IF NOT EXISTS `workout` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `workout`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: workout
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `schedule3`
--

DROP TABLE IF EXISTS `schedule3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule3` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `member_id` int NOT NULL,
  `mon` tinyint NOT NULL DEFAULT '0',
  `tue` tinyint NOT NULL DEFAULT '0',
  `wed` tinyint NOT NULL DEFAULT '0',
  `thu` tinyint NOT NULL DEFAULT '0',
  `fri` tinyint NOT NULL DEFAULT '0',
  `sat` tinyint NOT NULL DEFAULT '0',
  `sun` tinyint NOT NULL DEFAULT '0',
  `course_name` varchar(45) NOT NULL,
  `URL` varchar(45) NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `s2c_idx` (`course_id`),
  KEY `s2m_idx` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule3`
--

LOCK TABLES `schedule3` WRITE;
/*!40000 ALTER TABLE `schedule3` DISABLE KEYS */;
INSERT INTO `schedule3` VALUES (1,1,3,1,1,0,0,0,0,0,'超慢跑20分鐘-2','nAsKSo93blY'),(2,2,3,0,1,1,1,0,0,0,'超慢跑初學專用','25NwcTHvRzQ'),(3,5,3,1,0,1,0,1,0,1,'10分鐘高強度居家運動','7iC8LaBuU1E'),(4,8,3,0,0,1,1,0,0,0,'15 分鐘高强度全身肌肉徒手訓練','20uf1EcGqjY'),(5,6,3,0,0,1,1,0,0,0,'45分鐘中級流瑜珈','V9TiRwtj0jA'),(6,7,3,0,0,1,1,0,0,0,'初學瑜伽第一課','X4z-NBQCq9E');
/*!40000 ALTER TABLE `schedule3` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-25 18:28:25
