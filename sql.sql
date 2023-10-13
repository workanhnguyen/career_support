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
  `strength` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `weakness` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hollands`
--

LOCK TABLES `hollands` WRITE;
/*!40000 ALTER TABLE `hollands` DISABLE KEYS */;
INSERT INTO `hollands` VALUES (1,'R','2023-09-30 07:50:34','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: kỹ thuật, công nghệ, hệ thống, ưa thích làm việc với đồ vật. máy móc, động thực vật, thích làm các công việc ngoài trời.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/kythuat_e8rza1.png','Ngành nghề phù hợp với nhóm này bao gồm: Các nghề về kiến trúc, an toàn lao động, nghề mộc, xây dựng, thủy sản, kỹ thuật, máy tàu thủy, lái xe, huấn luyện viên, nông - lâm nghiệp (quản lý trang trại, nhân giống cá, lâm nghiệp,...), cơ khí (chế tạo máy, bảo trì, sửa chữa thiết bị, luyện kim, cơ khí ứng dụng, tự động,...), điện - điện tử, địa lý - địa chất (đo đạc, vẽ bản đồ địa chính), dầu khí, hải dương học, quản lý công nghiệp...','Realistic - Người thực tế','2023-10-08 08:08:59','Thủ công, cơ khí, nông nghiệp, điện, kỹ thuật,…','Khả năng tương tác xã hội, giáo dục.'),(2,'I','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: quan sát, khám phá, phân tích đánh giá và giải quyết các vấn đề.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059442/backend/nghiencuu_bnkgap.png','Ngành nghề phù hợp với nhóm này bao gồm: Các ngành thuộc lĩnh vực khoa học tự nhiên (toán, lý, hóa, sinh, địa lý, địa chất, thống kê,...); khoa học xã hội (nhân học, tâm lý, địa lý,...); y - dược (bác sĩ gây mê, hồi sức, bác sĩ phẫu thuật, nha sĩ,...); khoa học công nghệ (công nghệ thông tin, môi trường, điện, vật lý kỹ thuật, xây dựng,...); nông lâm (nông học, thú y,...).','Investigative - Người nghiên cứu','2023-10-08 08:08:59','Khoa học, toán học, tư duy phản biện, phân tích,…','Khả năng thuyết phục, tương tác xã hội và những hoạt động lặp đi lặp lại.'),(3,'A','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: nghệ thuật, khả năng về trực giác, khả năng tưởng tượng cao, thích làm việc trong các môi trường mang tính ngẫu hứng, không khuôn mẫu.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/nghethuat_rwabl0.png','Ngành nghề phù hợp với nhóm này bao gồm: Các ngành về văn chương: báo chí (bình luận viên, dẫn chương trình,...); điện ảnh, sân khấu, mỹ thuật, ca nhạc, múa, kiến trúc, thời trang, hội họa, giáo viên dạy sử / Anh văn, bảo tàng, bảo tồn,...','Artistic - Người có tính nghệ sĩ','2023-10-08 08:08:59','Nghệ thuật (ngôn ngữ viết – nói, hội họa, ca hát, trình diễn, diễn xuất,…)','Nghiệp vụ hành chính, kinh doanh.'),(4,'S','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: ngôn ngữ, giảng giải, thích làm những việc như giảng dạy, cung cấp thông tin, sự chăm sóc, giúp đỡ, hoặc huấn luyện cho người khác.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/xahoi_r3e6bf.png','Ngành nghề phù hợp với nhóm này bao gồm: sư phạm, giảng viên; huấn luyện viên điền kinh; tư vấn - hướng nghiệp; công tác xã hội, sức khỏe cộng đồng, thuyền trưởng, thầy tu, thư viện, bác sĩ, chuyên khoa, thẩm định giá, nghiên cứu quy hoạch đô thị, kinh tế gia đình, tuyển dụng nhân sự, cảnh sát, xã hội học, bà đỡ, chuyên gia về X - quang, chuyên gia dinh dưỡng,...','Social - Người có tính xã hội','2023-10-08 08:08:59','Khả năng giao tiếp, giáo dục.','Thủ công, kỹ thuật.'),(5,'E','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: ngôn ngữ, giảng giải, thích làm những việc như giảng dạy, cung cấp thông tin, sự chăm sóc, giúp đỡ, hoặc huấn luyện cho người khác.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/quanly_nk9rff.png','Ngành nghề phù hợp với nhóm này bao gồm: Các ngành về quản trị kinh doanh (quản lý khách sạn, quản trị nhân sự,…), thương mại, marketing, kế toán – tài chính, luật sư, dịch vụ khách hàng, tiếp viên hàng không, thông dịch viên, pha chế rượu, kỹ sư công nghiệp (ngành kỹ thuật hệ thống công nghiệp), bác sĩ cấp cứu, quy hoạch đô thị, bếp trưởng (nấu ăn), báo chí (phóng viên, biên tập viên…).','Enterprising - Người quản lý','2023-10-09 00:55:31','Lãnh đạo, giao tiếp, thuyết phục.','Khoa học.'),(6,'C','2023-09-30 07:52:42','Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về: số học, thích thực hiện những công việc chi tiết, thích làm việc với những số liệu, công việc chi tiết, thích làm việc với những số liệu, theo chỉ dẫn của người khác hoặc các công việc văn phòng.','https://res.cloudinary.com/dduhlnft3/image/upload/v1696059441/backend/nghiepvu_snp4np.png','Ngành nghề phù hợp với nhóm này bao gồm: Các ngành nghề về hành chính, thống kê, thanh tra ngành, người giữ trẻ, điện thoại viên...','Conventional - Người nghiệp vụ, công chức','2023-10-09 00:58:43','Công việc lặp đi lặp lại, chăm chỉ, cần mẫn.','Khả năng sáng tạo, giao tiếp,…');
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
  CONSTRAINT `FK5bmv46so2y5igt9o9n9w4fh6y` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES (16,'Có tính tự lập.',11,'2023-10-09 00:40:35',NULL),(17,'Có đầu óc suy nghĩ thực tế.',11,'2023-10-09 00:40:35',NULL),(18,'Dễ thích nghi với môi trường mới.',11,'2023-10-09 00:40:35',NULL),(19,'Có khả năng điều khiển các máy móc, thiết bị.',11,'2023-10-09 00:40:35',NULL),(20,'Làm tốt các công việc thủ công như gấp giấy, cắt, dán, đan, móc.',11,'2023-10-09 00:40:35',NULL),(21,'Thích tiếp xúc với thiên nhiên, động, thực vật.',11,'2023-10-09 00:40:35',NULL),(22,'Thích làm các công việc thực hành, tay chân.',11,'2023-10-09 00:40:35',NULL),(23,'Thích làm những công việc thực tế.',11,'2023-10-09 00:40:35',NULL),(24,'Thích làm việc ngoài trời.',11,'2023-10-09 00:40:35',NULL),(25,'Thích tìm hiểu, khám phá vấn đề mới.',13,'2023-10-09 00:47:10',NULL),(26,'Có khả năng phân tích vấn đề.',13,'2023-10-09 00:47:10',NULL),(27,'Có tư duy logic, suy nghĩ mạch lạc, chặt chẽ.',13,'2023-10-09 00:47:10',NULL),(28,'Thích quan sát, nghiên cứu.',13,'2023-10-09 00:47:10',NULL),(29,'Có khả năng tổng hợp, khái quát, suy đoán.',13,'2023-10-09 00:47:10',NULL),(30,'Thích hoạt động điều tra, phân loại, kiểm tra, đánh giá.',13,'2023-10-09 00:47:10',NULL),(31,'Biết tự tổ chức, sắp xếp công việc.',13,'2023-10-09 00:47:10',NULL),(32,'Thích thử thách, khó khăn.',13,'2023-10-09 00:47:10',NULL),(33,'Có khả năng giải quyết vấn đề.',13,'2023-10-09 00:47:10',NULL),(34,'Dễ xúc động.',14,'2023-10-09 00:51:41',NULL),(35,'Giàu trí tưởng tượng.',14,'2023-10-09 00:51:41',NULL),(36,'Thích tự do, không theo khuôn mẫu.',14,'2023-10-09 00:51:41',NULL),(37,'Giỏi thuyết trình, diễn xuất.',14,'2023-10-09 00:51:41',NULL),(38,'Thích chụp ảnh, vẽ, trang trí, điêu khắc.',14,'2023-10-09 00:51:41',NULL),(39,'Có năng khiếu âm nhạc.',14,'2023-10-09 00:51:41',NULL),(40,'Có khả năng viết, trình bày ý tưởng.',14,'2023-10-09 00:51:41',NULL),(41,'Thích sự mới mẻ, công việc sáng tạo.',14,'2023-10-09 00:51:41',NULL),(42,'Thoải mái biểu lộ những ý thích riêng.',14,'2023-10-09 00:51:41',NULL),(43,'Thân thiện, hay giúp đỡ người khác.',15,'2023-10-09 00:54:36',NULL),(44,'Thích gặp gỡ, làm việc với nhiều người.',15,'2023-10-09 00:54:36',NULL),(45,'Lịch thiệp, tử tế.',15,'2023-10-09 00:54:36',NULL),(46,'Thích khuyên bảo, giảng giải cho người khác.',15,'2023-10-09 00:54:36',NULL),(47,'Biết lắng nghe, chia sẻ.',15,'2023-10-09 00:54:36',NULL),(48,'Thích các công việc chăm sóc sức khỏe.',15,'2023-10-09 00:54:36',NULL),(49,'Thích các hoạt động công tác xã hội, phục vụ cộng đồng.',15,'2023-10-09 00:54:36',NULL),(50,'Mong muốn được đóng góp để xã hội tốt đẹp hơn.',15,'2023-10-09 00:54:36',NULL),(51,'Có khả năng hòa giải, giải quyết mâu thuẫn.',15,'2023-10-09 00:54:36',NULL),(52,'Thích phiêu lưu.',16,'2023-10-09 00:57:30',NULL),(53,'Có tính quyết đoán.',16,'2023-10-09 00:57:30',NULL),(54,'Năng động.',16,'2023-10-09 00:57:30',NULL),(55,'Có khả năng diễn đạt, tranh luận, thuyết phục.',16,'2023-10-09 00:57:30',NULL),(56,'Thích làm quản lý, chỉ đạo, nhận xét, đánh giá, đặt ra mục tiêu, kế hoạch.',16,'2023-10-09 00:57:30',NULL),(57,'Thích tạo ảnh hưởng đối với người khác.',16,'2023-10-09 00:57:30',NULL),(58,'Thích cạnh tranh để vượt qua người khác.',16,'2023-10-09 00:57:30',NULL),(59,'Muốn được mọi người kính trọng, vị nể.',16,'2023-10-09 00:57:30',NULL),(60,'Thích khám phá nhiều điều mới lạ.',16,'2023-10-09 00:57:30',NULL),(61,'Có đầu óc tổ chức, sắp xếp, ngăn nắp.',17,'2023-10-09 01:00:41',NULL),(62,'Cẩn thận, tỉ mỉ.',17,'2023-10-09 01:00:41',NULL),(63,'Chu đáo, chính xác, đáng tin cậy.',17,'2023-10-09 01:00:41',NULL),(64,'Có khả năng tính toán, so sánh, ghi chép số liệu.',17,'2023-10-09 01:00:41',NULL),(65,'Thích công việc lưu trữ, phân loại, cập nhật thông tin.',17,'2023-10-09 01:00:41',NULL),(66,'Thường dự kiến về chỉ tiêu, ngân sách.',17,'2023-10-09 01:00:41',NULL),(67,'Thích làm việc có nhiệm vụ, mục tiêu rõ ràng.',17,'2023-10-09 01:00:41',NULL),(68,'Có khả năng lên kế hoạch, điều phối công việc.',17,'2023-10-09 01:00:41',NULL),(69,'Thích làm việc với con số, theo hướng dẫn, quy trình.',17,'2023-10-09 01:00:41',NULL);
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
  CONSTRAINT `FKnf38uiy78c0g0tmo68btk3y0p` FOREIGN KEY (`survey_id`) REFERENCES `surveys` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (11,'Bạn có nhiều sở thích liên quan đến nhóm Realistic - Người thực tế?',5,'2023-10-09 00:40:35',NULL,1),(13,'Bạn có niềm đam mê NGHIÊN CỨU mọi thứ không?',5,'2023-10-09 00:47:10',NULL,2),(14,'Con người của NGHỆ THUẬT thường hay thả trôi bồng bềnh, có phải bạn không đấy?',5,'2023-10-09 00:51:41','2023-10-09 00:52:10',3),(15,'Người của XÃ HỘI chính là dễ dàng làm bạn với một ai đó. Bạn có phải là một “Bông hoa ngoại giao” không nào?',5,'2023-10-09 00:54:36',NULL,4),(16,'Bạn có tố chất của một người có khả năng QUẢN LÝ?',5,'2023-10-09 00:57:30',NULL,5),(17,'Nhóm sở thích liên quan đến NGHIỆP VỤ dành cho những người thực sự cẩn thận, nề nếp và quy cũ?',5,'2023-10-09 01:00:41',NULL,6);
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
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_details`
--

LOCK TABLES `response_details` WRITE;
/*!40000 ALTER TABLE `response_details` DISABLE KEYS */;
INSERT INTO `response_details` VALUES (9,NULL,16,5,55),(10,NULL,13,5,26),(11,NULL,14,5,37),(12,NULL,17,5,69),(13,NULL,11,5,24),(14,NULL,15,5,49),(40,NULL,16,8,57),(41,NULL,17,8,62),(42,NULL,13,8,27),(43,NULL,11,8,19),(44,NULL,14,8,37),(45,NULL,15,8,43),(46,NULL,15,9,49),(47,NULL,15,9,43),(48,NULL,15,9,44),(49,NULL,15,9,45),(50,NULL,17,9,65),(51,NULL,17,9,62),(52,NULL,14,9,34),(53,NULL,14,9,35),(54,NULL,14,9,38),(55,NULL,14,9,39),(56,NULL,14,9,41),(57,NULL,14,9,42),(58,NULL,16,9,52),(59,NULL,16,9,60),(60,NULL,11,9,17),(61,NULL,11,9,18),(62,NULL,11,9,21),(63,NULL,13,9,25),(64,NULL,13,9,29),(65,NULL,13,9,30),(66,NULL,14,10,34),(67,NULL,14,10,35),(68,NULL,14,10,40),(69,NULL,13,10,25),(70,NULL,13,10,26),(71,NULL,13,10,27),(72,NULL,13,10,28),(73,NULL,13,10,31),(74,NULL,17,10,69),(75,NULL,17,10,61),(76,NULL,17,10,62),(77,NULL,15,10,48),(78,NULL,15,10,49),(79,NULL,15,10,50),(80,NULL,15,10,51),(81,NULL,15,10,43),(82,NULL,15,10,44),(83,NULL,15,10,45),(84,NULL,15,10,46),(85,NULL,15,10,47),(86,NULL,16,10,53),(87,NULL,16,10,55),(88,NULL,11,10,17),(89,NULL,11,10,18),(90,NULL,11,10,19);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responses`
--

LOCK TABLES `responses` WRITE;
/*!40000 ALTER TABLE `responses` DISABLE KEYS */;
INSERT INTO `responses` VALUES (5,'2023-10-13 02:31:44',5,32,NULL),(8,'2023-10-13 07:15:34',5,32,NULL),(9,'2023-10-13 08:04:08',5,32,NULL),(10,'2023-10-13 08:30:06',5,32,NULL);
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
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `title` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `author` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveys`
--

LOCK TABLES `surveys` WRITE;
/*!40000 ALTER TABLE `surveys` DISABLE KEYS */;
INSERT INTO `surveys` VALUES (5,'2023-10-08 08:20:14','Trắc nghiệm Holland chính là cơ sở để bạn đối chiếu sở thích, năng lực tự nhiên của mình với yêu cầu của các nhóm ngành nghề. Từ đó bạn có thể định hướng nghề nghiệp theo nhóm ngành phù hợp nhất. Hãy thả lỏng tâm trí và thực hiện khảo sát một cách thoải mái nhất. Bắt đầu ngay nào!','Trắc Nghiệm Định Hướng Nghề Nghiệp Holland Code Test (RIASEC)','2023-10-11 07:55:44','John L.Holland','https://res.cloudinary.com/dduhlnft3/image/upload/v1697010930/backend/Untitled_design_fjjtx8.png');
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
INSERT INTO `users` VALUES (5,'https://res.cloudinary.com/dduhlnft3/image/upload/v1696908579/vi9xzhoeivk7wstsnyll.png','admin@gmail.com','viên','Quản trị','$2a$10$tZhElB4CQ7.A6GkJ9Xhple1Naak4ATawisFaoh7SBYk8gmoPld9UG','ROLE_ADMIN','2023-10-01 08:04:34',_binary '',_binary '\0','2023-10-10 04:19:24'),(6,'https://res.cloudinary.com/dduhlnft3/image/upload/v1696555687/frontend/blank-avatar_pnthgi.jpg','anh@gmail.com','Anh','Nguyen Van','$2a$10$BkaUNE08KXE.Oweqo2lal.OyBUuPVxfpWdSQO7hMVKRQZlZAKaVQy','ROLE_USER','2023-10-01 08:04:34',_binary '',_binary '\0','2023-10-10 04:19:24'),(32,'https://res.cloudinary.com/dduhlnft3/image/upload/v1696555687/frontend/blank-avatar_pnthgi.jpg','anhnguyen.per@gmail.com','Anh','Nguyễn Vân','$2a$10$Ex0DIKwKyDjVdOTbmtzcc.JY766RRGaxHn17fsXiIxZUGkauB9r1O','ROLE_USER','2023-10-01 08:04:34',_binary '',_binary '\0','2023-10-10 04:17:44');
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

-- Dump completed on 2023-10-13 15:33:44
