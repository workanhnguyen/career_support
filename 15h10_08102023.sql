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
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhpuw37a1pqxfb6ya1nv5lm4ga` (`user_id`),
  CONSTRAINT `FKhpuw37a1pqxfb6ya1nv5lm4ga` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmation_tokens`
--

LOCK TABLES `confirmation_tokens` WRITE;
/*!40000 ALTER TABLE `confirmation_tokens` DISABLE KEYS */;
INSERT INTO `confirmation_tokens` VALUES (42,'2023-10-01 15:05:18.866785','2023-10-01 15:04:34.041379','2023-10-01 15:19:34.041379','64722248-6a6e-47a8-8cd1-60688a893549',32);
/*!40000 ALTER TABLE `confirmation_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hollands`
--

DROP TABLE IF EXISTS `hollands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hollands` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `abbreviation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `suitable_career` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `strength` longtext COLLATE utf8mb4_unicode_ci,
  `weakness` longtext COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hollands`
--

LOCK TABLES `hollands` WRITE;
/*!40000 ALTER TABLE `hollands` DISABLE KEYS */;
INSERT INTO `hollands` VALUES (1,'R','2023-09-30 07:50:34','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: kỹ thuật, công nghệ, hệ thống, ưa thích làm việc với đồ vật. máy móc, động thực vật, thích làm các công việc ngoài trời.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/kythuat_e8rza1.png','Ngành nghề phù hợp với nhóm này bao gồm: Các nghề về kiến trúc, an toàn lao động, nghề mộc, xây dựng, thủy sản, kỹ thuật, máy tàu thủy, lái xe, huấn luyện viên, nông - lâm nghiệp (quản lý trang trại, nhân giống cá, lâm nghiệp,...), cơ khí (chế tạo máy, bảo trì, sửa chữa thiết bị, luyện kim, cơ khí ứng dụng, tự động,...), điện - điện tử, địa lý - địa chất (đo đạc, vẽ bản đồ địa chính), dầu khí, hải dương học, quản lý công nghiệp...','Realistic - Người thực tế','2023-10-08 08:08:59','Thủ công, cơ khí, nông nghiệp, điện, kỹ thuật,…','Khả năng tương tác xã hội, giáo dục.'),(2,'I','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: quan sát, khám phá, phân tích đánh giá và giải quyết các vấn đề.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059442/backend/nghiencuu_bnkgap.png','Ngành nghề phù hợp với nhóm này bao gồm: Các ngành thuộc lĩnh vực khoa học tự nhiên (toán, lý, hóa, sinh, địa lý, địa chất, thống kê,...); khoa học xã hội (nhân học, tâm lý, địa lý,...); y - dược (bác sĩ gây mê, hồi sức, bác sĩ phẫu thuật, nha sĩ,...); khoa học công nghệ (công nghệ thông tin, môi trường, điện, vật lý kỹ thuật, xây dựng,...); nông lâm (nông học, thú y,...).','Investigative - Người nghiên cứu','2023-10-08 08:08:59','Khoa học, toán học, tư duy phản biện, phân tích,…','Khả năng thuyết phục, tương tác xã hội và những hoạt động lặp đi lặp lại.'),(3,'A','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: nghệ thuật, khả năng về trực giác, khả năng tưởng tượng cao, thích làm việc trong các môi trường mang tính ngẫu hứng, không khuôn mẫu.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/nghethuat_rwabl0.png','Ngành nghề phù hợp với nhóm này bao gồm: Các ngành về văn chương: báo chí (bình luận viên, dẫn chương trình,...); điện ảnh, sân khấu, mỹ thuật, ca nhạc, múa, kiến trúc, thời trang, hội họa, giáo viên dạy sử / Anh văn, bảo tàng, bảo tồn,...','Artistic - Người có tính nghệ sĩ','2023-10-08 08:08:59','Nghệ thuật (ngôn ngữ viết – nói, hội họa, ca hát, trình diễn, diễn xuất,…)','Nghiệp vụ hành chính, kinh doanh.'),(4,'S','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: ngôn ngữ, giảng giải, thích làm những việc như giảng dạy, cung cấp thông tin, sự chăm sóc, giúp đỡ, hoặc huấn luyện cho người khác.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/xahoi_r3e6bf.png','Ngành nghề phù hợp với nhóm này bao gồm: sư phạm, giảng viên; huấn luyện viên điền kinh; tư vấn - hướng nghiệp; công tác xã hội, sức khỏe cộng đồng, thuyền trưởng, thầy tu, thư viện, bác sĩ, chuyên khoa, thẩm định giá, nghiên cứu quy hoạch đô thị, kinh tế gia đình, tuyển dụng nhân sự, cảnh sát, xã hội học, bà đỡ, chuyên gia về X - quang, chuyên gia dinh dưỡng,...','Social - Người có tính xã hội','2023-10-08 08:08:59','Khả năng giao tiếp, giáo dục.','Thủ công, kỹ thuật.'),(5,'E','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: ngôn ngữ, giảng giải, thích làm những việc như giảng dạy, cung cấp thông tin, sự chăm sóc, giúp đỡ, hoặc huấn luyện cho người khác.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/quanly_nk9rff.png','Ngành nghề phù hợp với nhóm này bao gồm: Các ngành về quản trị kinh doanh (quản lý khách sạn, quản trị nhân sự,…), thương mại, marketing, kế toán – tài chính, luật sư, dịch vụ khách hàng, tiếp viên hàng không, thông dịch viên, pha chế rượu, kỹ sư công nghiệp (ngành kỹ thuật hệ thống công nghiệp), bác sĩ cấp cứu, quy hoạch đô thị, bếp trưởng (nấu ăn), báo chí (phóng viên, biên tập viên…).','Enterprising - Dám nghĩ, dám làm','2023-10-08 08:08:59','Lãnh đạo, giao tiếp, thuyết phục.','Khoa học.'),(6,'C','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: số học, thích thực hiện những công việc chi tiết, thích làm việc với những số liệu, công việc chi tiết, thích làm việc với những số liệu, theo chỉ dẫn của người khác hoặc các công việc văn phòng.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/nghiepvu_snp4np.png','Ngành nghề phù hợp với nhóm này bao gồm: Các ngành nghề về hành chính, thống kê, thanh tra ngành, người giữ trẻ, điện thoại viên...','Conventional - Người công chức','2023-10-08 08:08:59','Công việc lặp đi lặp lại, chăm chỉ, cần mẫn.','Khả năng sáng tạo, giao tiếp,…');
/*!40000 ALTER TABLE `hollands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `options` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `question_id` bigint DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
INSERT INTO `options` VALUES (1,'Lựa chọn 1',1,NULL,NULL),(2,'Lựa chọn 2',1,NULL,NULL),(3,'Lựa chọn 3',1,NULL,NULL),(4,'Lựa chọn 4',1,NULL,NULL),(5,'Lựa chọn 5',2,NULL,NULL),(6,'Lựa chọn 6',2,NULL,NULL),(7,'Lựa chọn 7',3,NULL,NULL),(8,'Lựa chọn 8',3,NULL,NULL),(9,'Lựa chọn 9',4,NULL,NULL),(10,'Lựa chọn 10',4,NULL,NULL),(11,'Lựa chọn 11',5,NULL,NULL),(12,'Lựa chọn 12',6,NULL,NULL),(13,'Lựa chọn 13',7,NULL,NULL),(14,'Lựa chọn 14',7,NULL,NULL);
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
  `content` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `survey_id` bigint DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `holland_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnf38uiy78c0g0tmo68btk3y0p` (`survey_id`),
  KEY `FK_question_holland_idx` (`holland_id`),
  CONSTRAINT `FK_question_holland` FOREIGN KEY (`holland_id`) REFERENCES `hollands` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKnf38uiy78c0g0tmo68btk3y0p` FOREIGN KEY (`survey_id`) REFERENCES `surveys` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Câu hỏi 1',1,NULL,NULL,NULL),(2,'Câu hỏi 2',1,NULL,NULL,NULL),(3,'Câu hỏi 3',1,NULL,NULL,NULL),(4,'Câu hỏi 1',2,NULL,NULL,NULL),(5,'Câu hỏi 2',2,NULL,NULL,NULL),(6,'Câu hỏi 3',2,NULL,NULL,NULL),(7,'Câu hỏi 4',2,NULL,NULL,NULL);
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
  `text_response` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
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
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `survey_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
-- Table structure for table `surveys`
--

DROP TABLE IF EXISTS `surveys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveys` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `description` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `title` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveys`
--

LOCK TABLES `surveys` WRITE;
/*!40000 ALTER TABLE `surveys` DISABLE KEYS */;
INSERT INTO `surveys` VALUES (1,'2023-09-29 07:48:02','Mô tả khảo sát 1','Khảo sát 1','2023-09-29 07:48:02'),(2,'2023-09-29 07:48:17','Mô tả khảo sát 2','Khảo sát 2','2023-09-29 07:48:17'),(3,'2023-10-06 03:48:15','Mô tả khảo sát 3','Khảo sát 3','2023-10-06 03:48:15'),(4,'2023-10-06 03:48:15','Mô tả khảo sát 4','Khảo sát 4','2023-10-06 03:48:15');
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
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` enum('ROLE_ADMIN','ROLE_USER') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` bit(1) DEFAULT NULL,
  `locked` bit(1) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (5,NULL,'admin@gmail.com','viên','Quản trị','$2a$10$tZhElB4CQ7.A6GkJ9Xhple1Naak4ATawisFaoh7SBYk8gmoPld9UG','ROLE_ADMIN',NULL,_binary '',_binary '\0',NULL),(6,NULL,'anh@gmail.com','Anh','Nguyen Van','$2a$10$BkaUNE08KXE.Oweqo2lal.OyBUuPVxfpWdSQO7hMVKRQZlZAKaVQy','ROLE_USER',NULL,_binary '',_binary '\0',NULL),(32,NULL,'anhnguyen.per@gmail.com','Anh','Nguyễn Vân','$2a$10$Ex0DIKwKyDjVdOTbmtzcc.JY766RRGaxHn17fsXiIxZUGkauB9r1O','ROLE_USER','2023-10-01 08:04:34',_binary '',_binary '\0','2023-10-06 03:40:42');
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

-- Dump completed on 2023-10-08 15:10:59
