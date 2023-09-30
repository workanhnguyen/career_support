-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: major_project_db
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `combination`
--

DROP TABLE IF EXISTS `combination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `combination` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combination`
--

LOCK TABLES `combination` WRITE;
/*!40000 ALTER TABLE `combination` DISABLE KEYS */;
INSERT INTO `combination` VALUES (1,'A00'),(2,'A01');
/*!40000 ALTER TABLE `combination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `combinations_subjects`
--

DROP TABLE IF EXISTS `combinations_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `combinations_subjects` (
  `group_id` bigint NOT NULL,
  `subject_id` bigint NOT NULL,
  PRIMARY KEY (`group_id`,`subject_id`),
  KEY `FKv9vj87hacdg9uvnf7yo7m8t` (`subject_id`),
  CONSTRAINT `FK8t2xl0qfmp3329vf1sgylbmip` FOREIGN KEY (`group_id`) REFERENCES `combination` (`id`),
  CONSTRAINT `FKv9vj87hacdg9uvnf7yo7m8t` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combinations_subjects`
--

LOCK TABLES `combinations_subjects` WRITE;
/*!40000 ALTER TABLE `combinations_subjects` DISABLE KEYS */;
INSERT INTO `combinations_subjects` VALUES (1,1),(2,1),(2,3),(1,8),(1,9),(2,9);
/*!40000 ALTER TABLE `combinations_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmation_tokens`
--

DROP TABLE IF EXISTS `confirmation_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `confirmation_tokens` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `confirmed_at` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `expired_at` datetime(6) NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhpuw37a1pqxfb6ya1nv5lm4ga` (`user_id`),
  CONSTRAINT `FKhpuw37a1pqxfb6ya1nv5lm4ga` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmation_tokens`
--

LOCK TABLES `confirmation_tokens` WRITE;
/*!40000 ALTER TABLE `confirmation_tokens` DISABLE KEYS */;
INSERT INTO `confirmation_tokens` VALUES (4,'2023-09-29 18:34:26.188687','2023-09-29 18:31:24.740462','2023-09-29 18:46:24.740462','7e9a6792-d283-41f7-a9ad-215b1a978c94',12),(5,NULL,'2023-09-30 08:34:59.629450','2023-09-30 08:49:59.629450','8e67e9fd-09ee-457e-b785-70e803091bfd',13),(6,NULL,'2023-09-30 08:36:42.408671','2023-09-30 08:51:42.408671','5537c589-3cd4-43ab-8862-3f0b05939326',13),(7,NULL,'2023-09-30 08:40:33.203789','2023-09-30 08:55:33.204898','2b8a306e-c430-48b1-a471-e0f226f28fe9',13),(8,NULL,'2023-09-30 08:42:25.598745','2023-09-30 08:57:25.598745','94551d0a-40da-47dc-a97a-497f573dbf0c',13),(12,NULL,'2023-09-30 09:04:26.790753','2023-09-30 09:19:26.790753','324999b0-47e3-408d-a580-ee076f32fad6',16),(13,'2023-09-30 09:07:17.857907','2023-09-30 09:04:36.638361','2023-09-30 09:19:36.638361','d3a77874-e2fa-4fe4-b71a-e2fa4819e9fd',16);
/*!40000 ALTER TABLE `confirmation_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `falcuties`
--

DROP TABLE IF EXISTS `falcuties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `falcuties` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `falcuties`
--

LOCK TABLES `falcuties` WRITE;
/*!40000 ALTER TABLE `falcuties` DISABLE KEYS */;
INSERT INTO `falcuties` VALUES (1,'Công nghệ thông tin'),(2,'Luật');
/*!40000 ALTER TABLE `falcuties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majors`
--

DROP TABLE IF EXISTS `majors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `majors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `falcuty_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4oeb2dti1phxv44yr2gu8jbbb` (`falcuty_id`),
  CONSTRAINT `FK4oeb2dti1phxv44yr2gu8jbbb` FOREIGN KEY (`falcuty_id`) REFERENCES `falcuties` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majors`
--

LOCK TABLES `majors` WRITE;
/*!40000 ALTER TABLE `majors` DISABLE KEYS */;
INSERT INTO `majors` VALUES (1,'Khoa học máy tính',1),(2,'Công nghệ thông tin',1),(3,'Luật',2),(4,'Luật kinh tế',2);
/*!40000 ALTER TABLE `majors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `options` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` tinytext COLLATE utf8mb4_unicode_ci NOT NULL,
  `question_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5bmv46so2y5igt9o9n9w4fh6y` (`question_id`),
  CONSTRAINT `FK5bmv46so2y5igt9o9n9w4fh6y` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES (1,'Lựa chọn 1',1),(2,'Lựa chọn 2',1),(3,'Lựa chọn 3',1),(4,'Lựa chọn 4',1),(5,'Lựa chọn 5',2),(6,'Lựa chọn 6',2),(7,'Lựa chọn 7',3),(8,'Lựa chọn 8',3),(9,'Lựa chọn 9',4),(10,'Lựa chọn 10',4),(11,'Lựa chọn 11',5),(12,'Lựa chọn 12',6),(13,'Lựa chọn 13',7),(14,'Lựa chọn 14',7);
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` tinytext COLLATE utf8mb4_unicode_ci,
  `survey_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnf38uiy78c0g0tmo68btk3y0p` (`survey_id`),
  CONSTRAINT `FKnf38uiy78c0g0tmo68btk3y0p` FOREIGN KEY (`survey_id`) REFERENCES `surveys` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Câu hỏi 1',1),(2,'Câu hỏi 2',1),(3,'Câu hỏi 3',1),(4,'Câu hỏi 1',2),(5,'Câu hỏi 2',2),(6,'Câu hỏi 3',2),(7,'Câu hỏi 4',2);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response_details`
--

DROP TABLE IF EXISTS `response_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `text_response` tinytext COLLATE utf8mb4_unicode_ci,
  `question_id` bigint DEFAULT NULL,
  `response_id` bigint DEFAULT NULL,
  `selected_option_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3fk1i31c11y3i0frbsssjflq6` (`question_id`),
  KEY `FKl4u78k4t848p6idchojyguf7b` (`response_id`),
  KEY `FKrqg5wah4bdui1upyqx3rd9f6j` (`selected_option_id`),
  CONSTRAINT `FK3fk1i31c11y3i0frbsssjflq6` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKl4u78k4t848p6idchojyguf7b` FOREIGN KEY (`response_id`) REFERENCES `responses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKrqg5wah4bdui1upyqx3rd9f6j` FOREIGN KEY (`selected_option_id`) REFERENCES `options` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_details`
--

LOCK TABLES `response_details` WRITE;
/*!40000 ALTER TABLE `response_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `response_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responses`
--

DROP TABLE IF EXISTS `responses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `survey_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKemug20qu5fygiy69wj7sel8hc` (`survey_id`),
  KEY `FKqf8rt9h0wd5pmaxouhxqsoeuq` (`user_id`),
  CONSTRAINT `FKemug20qu5fygiy69wj7sel8hc` FOREIGN KEY (`survey_id`) REFERENCES `surveys` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKqf8rt9h0wd5pmaxouhxqsoeuq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responses`
--

LOCK TABLES `responses` WRITE;
/*!40000 ALTER TABLE `responses` DISABLE KEYS */;
/*!40000 ALTER TABLE `responses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scores`
--

DROP TABLE IF EXISTS `scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `score` double NOT NULL,
  `major_id` bigint DEFAULT NULL,
  `year_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK709k6uw8e4s1claq9hb9evb5i` (`major_id`),
  KEY `FK3huc6y5nwxpmjsqohftn0bvw8` (`year_id`),
  CONSTRAINT `FK3huc6y5nwxpmjsqohftn0bvw8` FOREIGN KEY (`year_id`) REFERENCES `years` (`id`),
  CONSTRAINT `FK709k6uw8e4s1claq9hb9evb5i` FOREIGN KEY (`major_id`) REFERENCES `majors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scores`
--

LOCK TABLES `scores` WRITE;
/*!40000 ALTER TABLE `scores` DISABLE KEYS */;
INSERT INTO `scores` VALUES (1,NULL,25.9,1,2),(2,NULL,24,1,3),(3,NULL,26.8,1,4);
/*!40000 ALTER TABLE `scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scores_combinations`
--

DROP TABLE IF EXISTS `scores_combinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scores_combinations` (
  `score_id` bigint NOT NULL,
  `combination_id` bigint NOT NULL,
  PRIMARY KEY (`score_id`,`combination_id`),
  KEY `FKw604g65dtx1dgq2uhctugglq` (`combination_id`),
  CONSTRAINT `FKur8fhgp3amedf5utx1pc4h7q` FOREIGN KEY (`score_id`) REFERENCES `scores` (`id`),
  CONSTRAINT `FKw604g65dtx1dgq2uhctugglq` FOREIGN KEY (`combination_id`) REFERENCES `combination` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scores_combinations`
--

LOCK TABLES `scores_combinations` WRITE;
/*!40000 ALTER TABLE `scores_combinations` DISABLE KEYS */;
INSERT INTO `scores_combinations` VALUES (1,1),(2,1),(3,1),(1,2),(2,2),(3,2);
/*!40000 ALTER TABLE `scores_combinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Toán'),(2,'Ngữ văn'),(3,'Tiếng Anh'),(4,'Lịch sử'),(5,'Địa lý'),(6,'Giáo dục công dân'),(7,'Sinh học'),(8,'Hóa học'),(9,'Vật lý');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveys`
--

DROP TABLE IF EXISTS `surveys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveys` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` tinytext COLLATE utf8mb4_unicode_ci,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveys`
--

LOCK TABLES `surveys` WRITE;
/*!40000 ALTER TABLE `surveys` DISABLE KEYS */;
INSERT INTO `surveys` VALUES (1,'2023-09-29 14:48:02.000000','Mô tả khảo sát 1','Khảo sát 1','2023-09-29 14:48:02.000000'),(2,'2023-09-29 14:48:17.000000','Mô tả khảo sát 2','Khảo sát 2','2023-09-29 14:48:17.000000');
/*!40000 ALTER TABLE `surveys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` enum('ROLE_ADMIN','ROLE_USER') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `locked` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (5,NULL,'admin@gmail.com','viên','Quản trị','$2a$10$tZhElB4CQ7.A6GkJ9Xhple1Naak4ATawisFaoh7SBYk8gmoPld9UG','ROLE_ADMIN',NULL,_binary '',_binary '\0'),(6,NULL,'anh@gmail.com','Anh','Nguyen Van','$2a$10$BkaUNE08KXE.Oweqo2lal.OyBUuPVxfpWdSQO7hMVKRQZlZAKaVQy','ROLE_USER',NULL,_binary '',_binary '\0'),(8,NULL,'duy@gmail.com','Duy','Lê Trần Nhật','$2a$10$bQA.liUDWarrJkj.zppNRe5Rav8O5YL1u1HTlAIKMc8jWR7A1zPgy','ROLE_USER',NULL,_binary '\0',_binary '\0'),(11,NULL,'anh5@gmail.com','Anh','Nguyen','$2a$10$lKP/iKbhvXNaOtAHGJfz/.jfe/1v44./r7lmO.9fGV3DSgoNNRu.6','ROLE_USER',NULL,_binary '\0',_binary '\0'),(12,NULL,'anh6@gmail.com','Anh','Nguyen','$2a$10$p5tNNMCVF7Xh88EFZoRU.OJamy1TFt8O/szGkCP/HZZxN9b9E99Ee','ROLE_USER',NULL,_binary '',_binary '\0'),(13,NULL,'anh10@gmail.com','Anh','Nguyen','$2a$10$AsPH1qYBBzHc0IIqaHrVQ.UQp3N0FsrAVVAEAG4XJBzluYln1x3Zu','ROLE_USER',NULL,_binary '\0',_binary '\0'),(16,NULL,'anhnguyen.per@gmail.com','Anh','Nguyen','$2a$10$NMT2CyR2xe5wArAYZIp8qOW/GPIAVPR0e9Gf5DYC.TU3GFm99iK6m','ROLE_USER',NULL,_binary '',_binary '\0');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `years`
--

DROP TABLE IF EXISTS `years`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `years` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `years`
--

LOCK TABLES `years` WRITE;
/*!40000 ALTER TABLE `years` DISABLE KEYS */;
INSERT INTO `years` VALUES (1,'2020'),(2,'2021'),(3,'2022'),(4,'2023');
/*!40000 ALTER TABLE `years` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-30  9:12:25
