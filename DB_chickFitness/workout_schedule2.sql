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
-- Table structure for table `schedule2`
--

DROP TABLE IF EXISTS `schedule2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule2` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL,
  `course_id` int NOT NULL,
  `week` int NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `sche2member_id_idx` (`member_id`),
  KEY `sche2courses_id_idx` (`course_id`),
  CONSTRAINT `sche2courses_id` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `sche2member_id` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule2`
--

LOCK TABLES `schedule2` WRITE;
/*!40000 ALTER TABLE `schedule2` DISABLE KEYS */;
INSERT INTO `schedule2` VALUES (1,1,1,1),(2,1,1,3),(3,1,1,5),(4,1,1,6),(5,1,2,1),(6,1,2,3),(7,1,2,5),(8,1,2,7),(9,1,3,5),(10,1,3,6),(11,1,3,7),(12,2,1,1),(13,2,1,3),(14,2,1,7),(15,2,2,1),(16,2,2,3),(17,2,2,4),(18,2,3,1),(19,2,3,2),(20,2,3,4),(21,2,3,6),(22,3,1,1),(23,3,1,2),(24,3,1,4),(25,3,2,1),(26,3,2,4),(27,3,3,1),(28,3,3,4);
/*!40000 ALTER TABLE `schedule2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-22 18:17:17
