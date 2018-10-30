-- MySQL dump 10.13  Distrib 5.7.22, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: assignment2
-- ------------------------------------------------------
-- Server version	5.7.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `basic_charge`
--

DROP TABLE IF EXISTS `basic_charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basic_charge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `local_data_charge` double NOT NULL,
  `domestic_data_charge` double NOT NULL,
  `call_charge` double NOT NULL,
  `message_charge` double NOT NULL,
  `effective_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basic_charge`
--

LOCK TABLES `basic_charge` WRITE;
/*!40000 ALTER TABLE `basic_charge` DISABLE KEYS */;
INSERT INTO `basic_charge` VALUES (1,2,5,0.5,0.1,'2018-10-09');
/*!40000 ALTER TABLE `basic_charge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `call_record`
--

DROP TABLE IF EXISTS `call_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `call_record` (
  `start_time` datetime NOT NULL,
  `duration` int(11) NOT NULL,
  `expense` double NOT NULL,
  `user_phone` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `call_record`
--

LOCK TABLES `call_record` WRITE;
/*!40000 ALTER TABLE `call_record` DISABLE KEYS */;
INSERT INTO `call_record` VALUES ('2018-10-30 01:17:48',10,1,'18851822896'),('2018-09-30 01:17:48',10,1,'18851822896'),('2018-08-30 01:17:48',10,1,'18851822896'),('2018-07-30 01:17:48',10,1,'18851822896'),('2018-06-30 01:17:48',10,1,'18851822896'),('2018-10-30 01:17:48',10,1,'18851822896'),('2018-10-30 01:17:48',10,1,'18851822896'),('2018-10-30 01:17:48',10,1,'18851822896'),('2018-10-30 01:17:48',10,1,'18851822896'),('2018-10-30 01:17:48',10,1,'11111111111'),('2018-10-30 01:17:48',10,1,'11111111111'),('2018-10-30 01:17:48',10,1,'11111111111'),('2018-10-30 01:17:48',10,1,'11111111111'),('2018-10-30 01:17:48',10,1,'11111111111'),('2018-10-30 01:17:48',10,1,'11111111111'),('2018-10-30 01:17:48',10,1,'18851822896'),('2018-10-30 01:17:48',10,1,'18851822896'),('2018-09-21 01:17:48',10,1,'18851822896'),('2018-10-29 01:17:48',10,1,'11111111111'),('2018-10-30 01:17:48',10,1,'11111111111'),('2018-10-30 01:17:48',10,1,'11111111111'),('2018-08-30 01:17:48',10,1,'11111111111'),('2018-08-30 01:17:48',10,1,'11111111111'),('2018-08-30 01:17:48',10,1,'11111111111'),('2018-08-30 01:17:48',10,1,'11111111111'),('2018-09-30 01:17:48',10,1,'18851822896'),('2018-09-30 01:17:48',10,1,'18851822896'),('2018-06-30 01:17:48',10,1,'11111111111'),('2018-06-30 01:17:48',10,1,'11111111111'),('2018-06-30 01:17:48',10,1,'11111111111');
/*!40000 ALTER TABLE `call_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_usage_record`
--

DROP TABLE IF EXISTS `data_usage_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_usage_record` (
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `consumption` double NOT NULL,
  `type` enum('Domestic','Local') NOT NULL,
  `expense` double NOT NULL,
  `user_phone` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_usage_record`
--

LOCK TABLES `data_usage_record` WRITE;
/*!40000 ALTER TABLE `data_usage_record` DISABLE KEYS */;
INSERT INTO `data_usage_record` VALUES ('2018-10-30 07:06:17','2018-10-30 12:06:33',50.86,'Domestic',150,'18851822896'),('2018-10-29 07:06:17','2018-10-29 12:06:33',50.86,'Domestic',200,'18851822896'),('2018-10-28 07:06:17','2018-10-28 12:06:33',50.86,'Domestic',100,'18851822896'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'18851822896'),('2018-11-30 07:06:17','2018-11-30 12:06:33',50.86,'Local',0,'18851822896'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'18851822896'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'11111111111'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'11111111111'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'18851822896'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'22222222222'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'22222222222'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'22222222222'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'22222222222'),('2018-09-27 07:06:17','2018-09-27 12:06:33',50.86,'Local',0,'18851822896'),('2018-11-30 07:06:17','2018-11-30 12:06:33',50.86,'Local',0,'18851822896'),('2018-11-30 07:06:17','2018-11-30 12:06:33',50.86,'Local',0,'18851822896'),('2018-11-30 07:06:17','2018-11-30 12:06:33',50.86,'Local',0,'11111111111'),('2018-11-30 07:06:17','2018-11-30 12:06:33',50.86,'Local',0,'11111111111'),('2018-11-30 07:06:17','2018-11-30 12:06:33',50.86,'Local',0,'11111111111'),('2018-11-30 07:06:17','2018-11-30 12:06:33',50.86,'Local',0,'18851822896'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'18851822896'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'11111111111'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'11111111111'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'11111111111'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'11111111111'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'11111111111'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'18851822896'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'18851822896'),('2018-08-30 07:06:17','2018-08-30 12:06:33',50.86,'Domestic',0,'18851822896');
/*!40000 ALTER TABLE `data_usage_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_record`
--

DROP TABLE IF EXISTS `message_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_record` (
  `send_time` datetime NOT NULL,
  `expense` double NOT NULL,
  `user_phone` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_record`
--

LOCK TABLES `message_record` WRITE;
/*!40000 ALTER TABLE `message_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expense` double NOT NULL,
  `call_minutes` int(11) NOT NULL,
  `messages` int(11) NOT NULL,
  `local_data` double NOT NULL,
  `domestic_data` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (1,20,100,300,1000,3000),(2,30,200,300,10000,40000),(3,15,150,300,1000,20000),(4,20,200,300,1000,10000),(5,43,300,300,1000,3000),(6,44,200,300,1000,3000),(7,100,100,300,1000,2000),(8,88,400,300,1000,4000),(9,90,600,300,1000,500),(10,200,100,300,1000,6000),(11,50,100,300,1000,7000),(12,60,100,300,1000,8000),(13,70,100,300,1000,3000),(14,20,100,0,0,0),(15,10,0,200,0,0),(16,20,0,0,2048,0),(17,30,0,0,0,2048);
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_orders`
--

DROP TABLE IF EXISTS `package_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `package_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_time` datetime NOT NULL,
  `effective_time` datetime NOT NULL,
  `user_phone` char(11) NOT NULL,
  `package_id` int(11) NOT NULL,
  `state` enum('effective','waiting_effective','out','waiting_out') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_orders`
--

LOCK TABLES `package_orders` WRITE;
/*!40000 ALTER TABLE `package_orders` DISABLE KEYS */;
INSERT INTO `package_orders` VALUES (1,'2018-10-28 02:48:37','2018-10-28 02:48:48','18851822896',1,'out'),(3,'2018-10-28 11:18:17','2018-10-28 11:18:17','11111111111',2,'effective'),(4,'2018-10-28 11:19:29','2018-10-28 11:19:29','11111111111',3,'out'),(5,'2018-10-28 11:19:42','2018-10-28 11:19:42','11111111111',4,'waiting_out'),(6,'2018-10-28 12:58:29','2018-10-28 12:58:29','22222222222',5,'out'),(7,'2018-10-28 12:58:49','2018-10-28 12:58:49','22222222222',6,'waiting_effective'),(8,'2018-10-28 12:59:06','2018-10-28 12:59:06','18851822896',7,'waiting_out'),(13,'2018-10-29 20:44:55','2018-10-29 20:44:55','22222222222',8,'effective'),(14,'2018-10-29 20:47:28','2018-10-29 20:47:28','18851822896',9,'out'),(15,'2018-10-29 20:50:05','2018-10-29 20:50:05','18851822896',10,'waiting_out'),(20,'2018-10-29 22:18:30','2018-10-29 22:18:30','33333333333',11,'effective'),(21,'2018-10-29 22:18:47','2018-11-01 22:18:47','33333333333',12,'waiting_effective'),(22,'2018-10-29 22:40:11','2018-11-01 22:40:11','33333333333',13,'waiting_effective'),(23,'2018-10-30 12:38:50','2018-11-01 12:38:50','18851822896',14,'waiting_effective'),(24,'2018-10-30 12:39:40','2018-11-01 12:39:40','11111111111',15,'waiting_effective'),(25,'2018-10-30 12:44:40','2018-11-01 00:44:40','18851822896',16,'waiting_effective'),(26,'2018-10-30 15:10:35','2018-10-30 15:10:35','18851822896',10,'effective'),(27,'2018-10-30 15:25:52','2018-11-01 00:00:00','18851822896',10,'waiting_effective'),(28,'2018-10-30 16:58:52','2018-11-01 00:00:00','11111111111',12,'waiting_effective'),(29,'2018-10-30 15:25:52','2018-11-01 00:00:00','11111111111',10,'effective'),(30,'2018-10-30 15:25:52','2018-11-01 00:00:00','11111111111',9,'waiting_effective'),(31,'2018-10-30 15:25:52','2018-11-01 00:00:00','11111111111',8,'effective'),(32,'2018-10-30 15:25:52','2018-11-01 00:00:00','11111111111',7,'waiting_effective'),(33,'2018-10-30 15:25:52','2018-11-01 00:00:00','22222222222',6,'effective'),(34,'2018-10-30 15:25:52','2018-11-01 00:00:00','22222222222',5,'waiting_effective'),(35,'2018-10-30 15:25:52','2018-11-01 00:00:00','22222222222',4,'waiting_effective'),(36,'2018-10-30 15:25:52','2018-11-01 00:00:00','22222222222',4,'effective'),(37,'2018-10-30 15:25:52','2018-11-01 00:00:00','33333333333',3,'out'),(38,'2018-10-30 15:25:52','2018-11-01 00:00:00','33333333333',2,'waiting_out');
/*!40000 ALTER TABLE `package_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `phone_number` char(11) NOT NULL,
  `call_minutes` int(11) NOT NULL,
  `messages` int(11) NOT NULL,
  `local_data` double NOT NULL,
  `domestic_data` double NOT NULL,
  `balance` double NOT NULL,
  `out_call` int(11) NOT NULL,
  `out_messages` int(11) NOT NULL,
  `out_local_data` double NOT NULL,
  `out_domestic_data` double NOT NULL,
  PRIMARY KEY (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('11111111111',10,20,1000,10000,100,0,0,0,0),('18851822888',0,0,0,10000,16591,0,0,5000,5000),('18851822896',0,0,0,4500,-2310,0,0,5500,5500),('22222222222',10,20,1000,10000,100,0,0,0,0),('33333333333',10,20,1000,10000,100,0,0,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-30 19:16:29
