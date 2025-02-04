-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: storage
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `state_sales_tax`
--

DROP TABLE IF EXISTS `state_sales_tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_sales_tax` (
  `tax_key` int NOT NULL,
  `description` varchar(20) NOT NULL,
  `multiplier` double NOT NULL,
  PRIMARY KEY (`tax_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_sales_tax`
--

LOCK TABLES `state_sales_tax` WRITE;
/*!40000 ALTER TABLE `state_sales_tax` DISABLE KEYS */;
INSERT INTO `state_sales_tax` VALUES (0,'0%',1),(1,'1%',1.01),(2,'2%',1.02),(3,'3%',1.03),(4,'4%',1.04),(5,'5%',1.05),(6,'6%',1.06),(7,'7%',1.07),(8,'8%',1.08),(9,'9%',1.09),(10,'10%',1.1),(11,'11%',1.11),(12,'12%',1.12),(13,'13%',1.13),(14,'14%',1.14),(15,'15%',1.15),(16,'16%',1.16),(17,'17%',1.17),(18,'18%',1.18),(19,'19%',1.19),(20,'20%',1.2),(21,'21%',1.21),(22,'22%',1.22),(23,'23%',1.23),(24,'24%',1.24),(25,'25%',1.25),(26,'26%',1.26),(27,'27%',1.27),(28,'28%',1.28),(29,'29%',1.29),(30,'30%',1.3),(31,'31%',1.31),(32,'32%',1.32),(33,'33%',1.33),(34,'34%',1.34),(35,'35%',1.35),(36,'36%',1.36),(37,'37%',1.37),(38,'38%',1.38),(39,'39%',1.39),(40,'40%',1.4),(41,'41%',1.41),(42,'42%',1.42),(43,'43%',1.43),(44,'44%',1.44),(45,'45%',1.45),(46,'46%',1.46),(47,'47%',1.47),(48,'48%',1.48),(49,'49%',1.49),(50,'50%',1.5),(51,'51%',1.51),(52,'52%',1.52),(53,'53%',1.53),(54,'54%',1.54),(55,'55%',1.55),(56,'56%',1.56),(57,'57%',1.57),(58,'58%',1.58),(59,'59%',1.59),(60,'60%',1.6),(61,'61%',1.61),(62,'62%',1.62),(63,'63%',1.63),(64,'64%',1.64),(65,'65%',1.65),(66,'66%',1.66),(67,'67%',1.67),(68,'68%',1.68),(69,'69%',1.69),(70,'70%',1.7),(71,'71%',1.71),(72,'72%',1.72),(73,'73%',1.73),(74,'74%',1.74),(75,'75%',1.75),(76,'76%',1.76),(77,'77%',1.77),(78,'78%',1.78),(79,'79%',1.79),(81,'81%',1.81),(82,'82%',1.82),(83,'83%',1.83),(84,'84%',1.84),(85,'85%',1.85),(86,'86%',1.86),(87,'87%',1.87),(88,'88%',1.88),(89,'89%',1.89),(90,'90%',1.9),(91,'91%',1.91),(92,'92%',1.92),(93,'93%',1.93),(94,'94%',1.94),(95,'95%',1.95),(96,'96%',1.96),(97,'97%',1.97),(98,'98%',1.98),(99,'99%',1.99),(100,'100%',2);
/*!40000 ALTER TABLE `state_sales_tax` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-07 17:42:14
