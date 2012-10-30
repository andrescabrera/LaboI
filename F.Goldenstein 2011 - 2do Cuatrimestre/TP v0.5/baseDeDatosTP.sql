-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: examenes
-- ------------------------------------------------------
-- Server version	5.5.12

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
-- Current Database: `examenes`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `examenes` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `examenes`;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `domicilio` varchar(80) DEFAULT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (18,'Oskarina','Gonzalez Sanchez','Azc8ejgasn123123','1987-06-18'),(22,'Raul','Sanchez','Alsina 170',NULL),(71,'','','','1900-01-01'),(72,'124r09u09j','124r09u09j','llkajdslk','2013-10-10'),(73,'Jose','Jose','santa fe 3256','1977-09-14'),(74,'Juan','Juan','juncal 2356','1978-12-11');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examen`
--

DROP TABLE IF EXISTS `examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nota` decimal(10,0) DEFAULT NULL,
  `id_Alumno` int(11) DEFAULT NULL,
  `id_ModeloDeExamen` int(11) DEFAULT NULL,
  `id_Examinador` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Alumno` (`id_Alumno`),
  KEY `id_ModeloDeExamen` (`id_ModeloDeExamen`),
  KEY `id_Examinador` (`id_Examinador`),
  CONSTRAINT `examen_ibfk_1` FOREIGN KEY (`id_Alumno`) REFERENCES `alumno` (`id`),
  CONSTRAINT `examen_ibfk_2` FOREIGN KEY (`id_ModeloDeExamen`) REFERENCES `modelodeexamen` (`id`),
  CONSTRAINT `examen_ibfk_3` FOREIGN KEY (`id_Examinador`) REFERENCES `examinador` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entiendase, un examen es: el examen que rinde un alumno. Muc';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examen`
--

LOCK TABLES `examen` WRITE;
/*!40000 ALTER TABLE `examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examinador`
--

DROP TABLE IF EXISTS `examinador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examinador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examinador`
--

LOCK TABLES `examinador` WRITE;
/*!40000 ALTER TABLE `examinador` DISABLE KEYS */;
/*!40000 ALTER TABLE `examinador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelodeexamen`
--

DROP TABLE IF EXISTS `modelodeexamen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelodeexamen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fechaDeCreacion` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelodeexamen`
--

LOCK TABLES `modelodeexamen` WRITE;
/*!40000 ALTER TABLE `modelodeexamen` DISABLE KEYS */;
/*!40000 ALTER TABLE `modelodeexamen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcion`
--

DROP TABLE IF EXISTS `opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcion`
--

LOCK TABLES `opcion` WRITE;
/*!40000 ALTER TABLE `opcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcionessobrepreguntas`
--

DROP TABLE IF EXISTS `opcionessobrepreguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcionessobrepreguntas` (
  `id_PreguntaMultipleChoice` int(11) NOT NULL DEFAULT '0',
  `id_Opcion` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_Opcion`,`id_PreguntaMultipleChoice`),
  KEY `id_PreguntaMultipleChoice` (`id_PreguntaMultipleChoice`),
  CONSTRAINT `opcionessobrepreguntas_ibfk_1` FOREIGN KEY (`id_PreguntaMultipleChoice`) REFERENCES `preguntamultiplechoice` (`id`),
  CONSTRAINT `opcionessobrepreguntas_ibfk_2` FOREIGN KEY (`id_Opcion`) REFERENCES `opcion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcionessobrepreguntas`
--

LOCK TABLES `opcionessobrepreguntas` WRITE;
/*!40000 ALTER TABLE `opcionessobrepreguntas` DISABLE KEYS */;
/*!40000 ALTER TABLE `opcionessobrepreguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntaabierta`
--

DROP TABLE IF EXISTS `preguntaabierta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preguntaabierta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `texto` mediumtext,
  `id_Tema` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Tema` (`id_Tema`),
  CONSTRAINT `preguntaabierta_ibfk_1` FOREIGN KEY (`id_Tema`) REFERENCES `tema` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntaabierta`
--

LOCK TABLES `preguntaabierta` WRITE;
/*!40000 ALTER TABLE `preguntaabierta` DISABLE KEYS */;
/*!40000 ALTER TABLE `preguntaabierta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntamultiplechoice`
--

DROP TABLE IF EXISTS `preguntamultiplechoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preguntamultiplechoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `texto` mediumtext,
  `id_Tema` int(11) DEFAULT NULL,
  `opcionCorrecta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Tema` (`id_Tema`),
  CONSTRAINT `preguntamultiplechoice_ibfk_1` FOREIGN KEY (`id_Tema`) REFERENCES `tema` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntamultiplechoice`
--

LOCK TABLES `preguntamultiplechoice` WRITE;
/*!40000 ALTER TABLE `preguntamultiplechoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `preguntamultiplechoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `domicilio` varchar(80) DEFAULT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  `id_Examinador` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Examinador` (`id_Examinador`),
  CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`id_Examinador`) REFERENCES `examinador` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestaabierta`
--

DROP TABLE IF EXISTS `respuestaabierta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuestaabierta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `texto` mediumtext,
  `id_Examen` int(11) DEFAULT NULL,
  `id_PreguntaAbierta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Examen` (`id_Examen`),
  KEY `id_PreguntaAbierta` (`id_PreguntaAbierta`),
  CONSTRAINT `respuestaabierta_ibfk_1` FOREIGN KEY (`id_Examen`) REFERENCES `examen` (`id`),
  CONSTRAINT `respuestaabierta_ibfk_2` FOREIGN KEY (`id_PreguntaAbierta`) REFERENCES `preguntaabierta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestaabierta`
--

LOCK TABLES `respuestaabierta` WRITE;
/*!40000 ALTER TABLE `respuestaabierta` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestaabierta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestamultiplechoice`
--

DROP TABLE IF EXISTS `respuestamultiplechoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuestamultiplechoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opcion` varchar(255) DEFAULT NULL,
  `id_Examen` int(11) DEFAULT NULL,
  `id_PreguntaMultipleChoice` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Examen` (`id_Examen`),
  KEY `id_PreguntaMultipleChoice` (`id_PreguntaMultipleChoice`),
  CONSTRAINT `respuestamultiplechoice_ibfk_1` FOREIGN KEY (`id_Examen`) REFERENCES `examen` (`id`),
  CONSTRAINT `respuestamultiplechoice_ibfk_2` FOREIGN KEY (`id_PreguntaMultipleChoice`) REFERENCES `preguntamultiplechoice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestamultiplechoice`
--

LOCK TABLES `respuestamultiplechoice` WRITE;
/*!40000 ALTER TABLE `respuestamultiplechoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestamultiplechoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tema`
--

DROP TABLE IF EXISTS `tema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigoTema` int(11) DEFAULT NULL,
  `descripcion` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tema`
--

LOCK TABLES `tema` WRITE;
/*!40000 ALTER TABLE `tema` DISABLE KEYS */;
/*!40000 ALTER TABLE `tema` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-11-24 13:48:18
