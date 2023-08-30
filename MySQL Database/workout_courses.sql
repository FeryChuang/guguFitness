-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: workout
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `course_range` int NOT NULL,
  `difficulty` varchar(45) NOT NULL,
  `calories` int NOT NULL,
  `type` varchar(45) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'超慢跑20分鐘-2','初學者請勿赤足跑，我赤足的目的是為了讓大家看腳的動作，建議初學者練習要穿鞋保護',20,'初階',150,'跑步','nAsKSo93blY'),(2,'超慢跑初學專用','超慢跑初學必看',30,'初階',225,'跑步','25NwcTHvRzQ'),(3,'站立式全身消脂運動','適合大基數減重人士',30,'初階',300,'全身','glJexaQx9C0'),(4,'10分鐘高強度居家運動','只要你肯付出肯努力，你的回報就會反映在你的身材上',10,'中階',80,'全身','7iC8LaBuU1E'),(5,'45分鐘中級流瑜珈','完美的瑜珈是種平衡，動與靜，呼與吸，柔韌與力量，體式與冥想等的平衡。',45,'中階',150,'瑜珈','V9TiRwtj0jA'),(6,'初學瑜伽第一課','零基礎瑜伽入門系列',19,'初階',50,'瑜珈','X4z-NBQCq9E'),(7,'15 分鐘高强度全身肌肉徒手訓練','無需器材又能在家做的運動',15,'中階',50,'徒手','20uf1EcGqjY'),(8,'45分鐘深度鍛煉','腰腹大腿瘦不停',45,'高階',200,'深蹲','FsdNR3agkhg'),(9,'12分鐘進階腹肌訓練','地獄訓練',12,'高階',50,'徒手','4CPNOjRJ4aU'),(10,'15 分鐘居家徒手腹肌訓練','非常適合初學者入門也有效加强核心的訓練',15,'初階',50,'徒手','YGFPr93uaAA'),(11,'12分鐘 站立式開肩背部訓練','即時減低頸痛及圓背',12,'中階',30,'背部','cqEFLH1XPmE'),(12,'18分鐘 初學者之站立式練腹肌','有助增強核心力量提升運動表現',18,'初階',75,'徒手','VdS5UHtmoho');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-30 15:11:14
