-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sustentamais
-- ------------------------------------------------------
-- Server version	8.0.43
USE sustentamais;

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
-- Table structure for table `bairros`
--

DROP TABLE IF EXISTS `bairros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bairros` (
  `id_bairro` int NOT NULL,
  `nome_bairro` varchar(50) NOT NULL,
  PRIMARY KEY (`id_bairro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairros`
--

LOCK TABLES `bairros` WRITE;
/*!40000 ALTER TABLE `bairros` DISABLE KEYS */;
INSERT INTO `bairros` VALUES (1,'Lagoa Dourada 1'),(2,'Lagoa Dourada 2'),(3,'Vila São Crispim'),(4,'Vila Loyelo'),(5,'Vila Suely'),(6,'Alto da Boa Vista'),(7,'Vila Novaes'),(8,'Vila Paulo Romeu'),(9,'Jardim Primavera'),(10,'Retiro da Mantiqueira'),(11,'Vila Comerciários'),(12,'Parque Primavera'),(13,'Vila Biondi'),(14,'Conjunto Habitacional de Cruzeiro'),(15,'Vila Romana'),(16,'Jardim Paraíso'),(17,'Residencial das Palmeiras'),(18,'Residencial Vista Verde'),(19,'Vila Maria'),(20,'Vila Dr. João Batista (Baixa)'),(21,'Vila Angelina'),(22,'Vila Maria Antonieta'),(23,'Vila Dr. João Batista (Alta)'),(24,'Vila Virgílio A. de Oliveira'),(25,'Vilage Nesralla Rubez'),(26,'Vila Celestina Novaes'),(27,'Vila Expedicionários Cruzeirenses'),(28,'Vila Avelino J. Mariano'),(29,'Vila Canevari (Leste)'),(30,'Centro'),(31,'Vila Canevari (Oeste)'),(32,'Vila Paulista'),(33,'Vila Regina Célia'),(34,'Vila Rita Lucrécia Pinto'),(35,'Vila Conceição'),(36,'Vila Abgail'),(37,'Santa Luzia'),(38,'Vila Esmeralda'),(39,'Vila Washington Beleza'),(40,'Ecovale'),(41,'Santa Cecília'),(42,'Residencial Metalúrgicos'),(43,'Vila Pontilhão'),(44,'Reserva do Vale'),(45,'Vila Ana Rosa Novaes'),(46,'Vila Brasil'),(47,'Jardim Imperial'),(48,'Parque Dona Arminda'),(49,'Jardim São José'),(50,'Vila São Judas Tadeu'),(51,'Jardim Europa'),(52,'Bairro do Norte'),(53,'Itagaçaba'),(54,'Vila Operária'),(55,'Vila Clara'),(56,'Vila Julia'),(57,'Vila Isabel'),(58,'Vista Alegre'),(59,'Morro do Itagaçaba'),(60,'Vila Santo Antônio'),(61,'Jardim América'),(62,'Zona Rural'),(63,'Distrito Industrial 02');
/*!40000 ALTER TABLE `bairros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-10 23:02:21
