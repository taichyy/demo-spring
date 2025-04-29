-- MySQL dump 10.13  Distrib 9.3.0, for macos15.2 (arm64)
--
-- Host: localhost    Database: social_media
-- ------------------------------------------------------
-- Server version	9.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `post_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh4c7lvsc298whoyd4w9ta25cr` (`post_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKh4c7lvsc298whoyd4w9ta25cr` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'這是一則留言','2025-04-29 15:59:15.037707',2,10);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lidm6cqbc7u4xhqpxm898qme` (`user_id`),
  CONSTRAINT `FK5lidm6cqbc7u4xhqpxm898qme` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (2,'這是我的新貼文','2025-04-29 14:38:38.070982','https://image.url',10),(3,'這是我的新貼文','2025-04-29 14:38:38.675287','https://image.url',10),(4,'這是我的新貼文','2025-04-29 14:38:38.978870','https://image.url',10),(5,'這是我的新貼文','2025-04-29 14:38:39.224004','https://image.url',10),(6,'這是我的新貼文','2025-04-29 14:38:39.434029','https://image.url',10),(7,'這是我的新貼文','2025-04-29 14:38:39.653105','https://image.url',10),(8,'這是我的新貼文','2025-04-29 14:38:39.837588','https://image.url',10),(9,'這是我的新貼文','2025-04-29 14:38:40.067056','https://image.url',10),(10,'這是我的新貼文','2025-04-29 14:38:40.299137','https://image.url',10),(11,'這是我的新貼文','2025-04-29 14:43:43.286881','https://image.url',10);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `biography` varchar(255) DEFAULT NULL,
  `cover_image` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UKdu5v5sr43g5bfnji4vb8hg5s3` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,NULL,'967d5ee76bfe7d1efd68db5a68f4158ea8e8980fff4b7a21f5065206cc4c4761','0912345678','80615cacc26c025a9d043bcdd4e725e9',NULL),(2,NULL,NULL,NULL,'2a5c1f5f4262723b77296848cbc4b7c2d5b87bcee436cc530260ff2d40c4e609','0912345677','aa4622def6443a6a340005f9ae07e137',NULL),(3,NULL,NULL,NULL,'44b1f48b818145bc3365fa306d9bd8b0fb6ef6fcd22ccf9eda346a3ed770a4bb','0912345378','4d4092b57be54ebce3b04faae6c99897',NULL),(4,NULL,NULL,NULL,'86c42900a447763d10f2fed5315379f14e3a6b060d541b2879a8c177134a88fe','0912343378','b058a8a6e54358ba0569ce5fbfb4248d',NULL),(5,NULL,NULL,NULL,'9b315e9ef99f9354b45e2b3a946d576c04f77bb0d2b97184fa3871652c5c7915','0912343478','73b58d08cde4b5deb24331ac93aefdfc',NULL),(6,NULL,NULL,NULL,'e01c23eb2c6fd596e2a0be188f8e145fc7ae2e4f9be2dc528868347cd3a950a1','0912341478','dd59cd33413ce0f0987ebf40760290bf',NULL),(7,NULL,NULL,NULL,'c37fe49901f72c9b8dbc431824618d9fb69a246410904208ec70379d7d2c017c','0911111111','c7d257a41f5f69a1d401649551b75e79',NULL),(8,NULL,NULL,NULL,'77d1781e779a678c214d47501a9f6061d7a93217bae88182ad4a1b621ee09fac','0911111112','13f573ab6ceef1b6fc4494881bd490e3',NULL),(9,NULL,NULL,NULL,'3cea9404f5e05d8479483507c834899e024e3351997cb1e4ff374ceaa96481aa','0911111113','e0ce7cd203b3512154a16eb3f4cd7017',NULL),(10,NULL,NULL,NULL,'1aefbc23ced33fb02b30a7e3a70694aafaa2d7fcfba8c720ee81f5181aa33d42','0911111114','bf59197f7c97d16dce14ad689ec22f30',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-29 16:17:44
