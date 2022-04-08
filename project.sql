CREATE DATABASE  IF NOT EXISTS `lanhkhanh` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lanhkhanh`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: lanhkhanh
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lastName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Nguyễn ','Đạt','DatNQ30','$2a$12$kCVQYJdG36OVbSH/aADaBuDUWL9bdAMIh5vPkeWRvLlkDbxJmCMPa','Datnguyen122000@gmail.com',22,'0948854268','Nam Định','ROLE_ADMIN',_binary ''),(2,'Nguyễn','Vượng','VuongNQ68','$2a$12$eej7xzr.fnGkTAPSZL9ZpePd6bGtSUhuEhGILwq7nh5bUN1z0.gBy','Vuongnguyen23012003@gmailcom',18,'0999999999','Nam Đinh','ROLE_USER',_binary '');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id_brand` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_brand`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Trek',_binary ''),(2,'Giant',_binary ''),(3,'Shimano',_binary ''),(4,'Việt Long',_binary ''),(7,'Việt Long',_binary '');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id_category` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `created_date` timestamp(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Trẻ em',_binary '',NULL),(2,'Đường phố',_binary '',NULL),(3,'Thể thao',_binary '',NULL),(4,'LK',_binary '',NULL),(14,'sdfsdf',_binary '','2022-02-17 07:59:26.75500'),(15,'sdfsdfsdf',_binary '','2022-02-17 08:03:08.18100');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'16-03-do-1-1-1-720x497.jpg',_binary ''),(2,'Mini-05-24-1-4-720x480.jpg',_binary ''),(3,'MTB-20-04-tem-xanh-duong-720x480.jpg',_binary ''),(4,'GN 06 – 20.jpg',_binary ''),(5,'marvel-test.jpg',_binary ''),(6,'MTB 20″ – 03.jpg',_binary ''),(7,'MTB-20-04.jpg',_binary ''),(8,'Neo 20″ – 02.jpg',_binary ''),(9,'Neo 20″ – 03.jpg',_binary ''),(10,'TE 16″ – 04.jpg',_binary ''),(11,'1.jpg',_binary ''),(12,'2.jpg',_binary ''),(13,'3.jpg',_binary ''),(14,'4.jpg',_binary ''),(15,'5.jpg',_binary ''),(16,'6.jpg',_binary ''),(17,'7.jpg',_binary ''),(18,'8.jpg',_binary ''),(19,'t1.jpg',_binary ''),(20,'t2.jpg',_binary ''),(21,'t3.jpg',_binary ''),(22,'t4.jpg',_binary ''),(23,'t5.jpg',_binary ''),(24,'t6.jpg',_binary ''),(25,'t7.png',_binary ''),(26,'t8.jpg',_binary ''),(27,'tt1.jpg',_binary ''),(28,'tt2.jpg',_binary ''),(29,'tt3.jpg',_binary ''),(30,'tt4.jpg',_binary ''),(31,'tt5.jpg',_binary ''),(32,'tt6.jpg',_binary ''),(33,'tt7.jpg',_binary ''),(34,'tt8.jpg',_binary '');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `accId` int DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_acc_idx` (`accId`),
  CONSTRAINT `order_acc` FOREIGN KEY (`accId`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='status 1 2 3 là gì';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `id` int NOT NULL,
  `orderId` int DEFAULT NULL,
  `productId` int DEFAULT NULL,
  `quatity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_product_idx` (`orderId`),
  KEY `order_product_idx1` (`productId`),
  CONSTRAINT `order_product` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`),
  CONSTRAINT `order_product2` FOREIGN KEY (`productId`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `detail` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  `star_evalue` int DEFAULT NULL,
  `size` int DEFAULT NULL,
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `main_img` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  KEY `product_category_idx` (`category_id`),
  KEY `product_brand_idx` (`brand_id`),
  KEY `product_image_idx` (`main_img`),
  CONSTRAINT `product_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id_brand`),
  CONSTRAINT `product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id_category`),
  CONSTRAINT `product_image` FOREIGN KEY (`main_img`) REFERENCES `image` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'TE 16” – 03','Three overhead signal faces for the motor-vehicle lanes are shown on a mast arm that extends out from a support pole on the northeast corner of the intersection. A bike signal face is shown mounted on the support pole on the northeast corner of the intersection. Three different optional arrangements are shown for the bike signal face, all of which have a Bike Signal (R10-10b) sign mounted below them (Attachment IA-16-3 describes the sign in more detail). The first arrangement is a four-section vertical signal','Three overhead signal faces for the motor-vehicle lanes are shown on a mast arm that extends out from a support pole on the northeast corner of the intersection. A bike signal face is shown mounted on the support pole on the northeast corner of the intersection. Three different optional arrangements are shown for the bike signal face, all of which have a Bike Signal (R10-10b) sign mounted below them (Attachment IA-16-3 describes the sign in more detail). The first arrangement is a four-section vertical signal',1400,7,0,16,'Đỏ',1,20,1,_binary ''),(2,'TE 16” – 02','Three overhead signal faces for the motor-vehicle lanes are shown on a mast arm that extends out from a support pole on the northeast corner of the intersection. A bike signal face is shown mounted on the support pole on the northeast corner of the intersecti','Three overhead signal faces for the motor-vehicle lanes are shown on a mast arm that extends out from a support pole on the northeast corner of the intersection. A bike signal face is shown mounted on the support pole on the northeast corner of the intersecti',2050,3,0,24,'Trắng',2,25,2,_binary '\0'),(3,'MTB 20″ – 04','Three overhead signal faces for the motor-vehicle lanes are shown on a mast arm that extends out from a support pole on the northeast corner of the intersection. A bike signal face is shown mounted on the support pole on the northeast corner of the intersecti','Three overhead signal faces for the motor-vehicle lanes are shown on a mast arm that extends out from a support pole on the northeast corner of the intersection. A bike signal face is shown mounted on the support pole on the northeast corner of the intersecti',2400,4,0,20,'Đen-Xanh',3,15,3,_binary ''),(4,'GN 06 – 20″','xxx','xxx',2342,3,0,23,'Đỏ',1,20,4,_binary ''),(5,'Marvel-test','xxx','xxx',4232,4,0,32,'Đen',3,23,5,_binary ''),(6,'MTB 20″ – 03','sds','sd',2342,4,0,32,'Hồng',1,323,6,_binary ''),(7,'MTB 20″ – 04','sd','sdf',2342,2,0,23,'Vàng',4,32,7,_binary ''),(8,'Neo 02','xss','sss',2344,2,0,23,'Tím',1,3234,8,_binary ''),(9,'Neo 03','sss','sss',5444,1,0,23,'Đen',2,23,9,_binary ''),(11,'Đường phố 1','Đường phố 1','Đường phố 1',2341,3,0,23,'Green',2,123,11,_binary ''),(12,'Đường phố 2 ','Đường phố 2 ','Đường phố 2',2341,3,0,23,'Black',2,234,12,_binary ''),(13,'Đường phố 3','Đường phố 3','Đường phố 3',423,4,0,34,'white',2,324,13,_binary ''),(14,'Đường phố 4','Đường phố 4','Đường phố 4',234,1,0,25,'Green',2,43,14,_binary ''),(15,'Đường phố 5','Đường phố 5','Đường phố 5',566,7,0,23,'Black',2,57,15,_binary ''),(16,'Đường phố 6','Đường phố 6','Đường phố 6',9034,2,0,23,'Green',2,23,16,_binary ''),(17,'Đường phố 7','Đường phố 7','Đường phố 7',903,4,0,23,'Yellow',2,66,17,_binary ''),(18,'Đường phố 8','Đường phố 8','Đường phố 8',899,3,0,65,'Blue',2,12,18,_binary ''),(19,'Trẻ em 1','Trẻ em 1','Trẻ em 1',879,2,0,34,'Pink',1,5,19,_binary ''),(20,'Trẻ em 2','Trẻ em 2','Trẻ em 2',98,2,0,23,'Purple',1,12,20,_binary ''),(21,'Trẻ em 3','Trẻ em 3','Trẻ em 3',87,1,0,23,'Blue',1,67,21,_binary ''),(22,'Trẻ em 4','Trẻ em 4','Trẻ em 4',891,2,0,23,'Green',1,55,22,_binary ''),(23,'Trẻ em 5','Trẻ em 5','Trẻ em 5',778,4,0,23,'Black',1,15,23,_binary ''),(24,'Trẻ em 6','Trẻ em 6','Trẻ em 6',235,3,0,23,'Đỏ',1,23,16,_binary ''),(25,'Trẻ em 7','Trẻ em 7','Trẻ em 7',664,2,0,23,'Black',1,345,25,_binary ''),(26,'Trẻ em 8','Trẻ em 8','Three overhead signal faces for the motor-vehicle lanes are shown on a mast arm that extends out from a support pole on the northeast corner of the intersection. A bike signal face is shown mounted on the support pole on the northeast corner of the intersecti',2342,3,0,15,'Pink',1,43,26,_binary ''),(27,'Thể thao 1','Thể thao 1','Thể thao 1',212,2,0,23,'Black',3,1324,27,_binary ''),(28,'Thể thao 2','Thể thao 2','Thể thao 2',324,2,0,26,'Pink',3,43,28,_binary ''),(29,'Thể thao 3','Thể thao 3','Thể thao 3',432,3,0,321,'Đỏ',3,212,29,_binary ''),(30,'Thể thao 4','Thể thao 4','Thể thao 4',2341,4,0,21,'Red',3,41,30,_binary ''),(31,'Thể thao 5','Thể thao 5','Thể thao 5',901,4,0,20,'Green',3,23,31,_binary ''),(32,'Thể thao 6','Thể thao 6','Thể thao 6',891,4,0,18,'Purpil',3,31,32,_binary ''),(33,'Thể thao 7','Thể thao 7','Thể thao 7',891,7,0,26,'Green',3,85,33,_binary ''),(34,'Thể thao 8','Thể thao 8','Thể thao 8',981,4,0,23,'Violet',3,32,34,_binary '');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idProduct` int DEFAULT NULL,
  `idImg` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_idx` (`idProduct`),
  KEY `image_idx` (`idImg`),
  CONSTRAINT `image` FOREIGN KEY (`idImg`) REFERENCES `image` (`id`),
  CONSTRAINT `product` FOREIGN KEY (`idProduct`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `accId` int DEFAULT NULL,
  `productId` int NOT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `starEvalue` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reveiew_acc_idx` (`accId`),
  KEY `review_product_idx` (`productId`),
  CONSTRAINT `review_acc` FOREIGN KEY (`accId`) REFERENCES `account` (`id`),
  CONSTRAINT `review_product` FOREIGN KEY (`productId`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-08  9:32:24
