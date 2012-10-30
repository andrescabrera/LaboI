-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.46-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bdPeliculas
--

CREATE DATABASE IF NOT EXISTS bdPeliculas;
USE bdPeliculas;

--
-- Definition of table `Funcion`
--

DROP TABLE IF EXISTS `Funcion`;
CREATE TABLE `Funcion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(80) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `Funcion`
--

/*!40000 ALTER TABLE `Funcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Funcion` ENABLE KEYS */;


--
-- Definition of table `FuncionStaffPelicula`
--

DROP TABLE IF EXISTS `FuncionStaffPelicula`;
CREATE TABLE `FuncionStaffPelicula` (
  `idPelicula` int(11) NOT NULL DEFAULT '0',
  `idStaff` int(11) NOT NULL DEFAULT '0',
  `idFuncion` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idPelicula`,`idStaff`,`idFuncion`),
  KEY `idFuncion` (`idFuncion`),
  KEY `idStaff` (`idStaff`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_1` FOREIGN KEY (`idPelicula`) REFERENCES `Pelicula` (`id`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_2` FOREIGN KEY (`idStaff`) REFERENCES `Staff` (`id`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_3` FOREIGN KEY (`idFuncion`) REFERENCES `Funcion` (`id`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_4` FOREIGN KEY (`idPelicula`) REFERENCES `Pelicula` (`id`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_5` FOREIGN KEY (`idStaff`) REFERENCES `Staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `FuncionStaffPelicula`
--

/*!40000 ALTER TABLE `FuncionStaffPelicula` DISABLE KEYS */;
/*!40000 ALTER TABLE `FuncionStaffPelicula` ENABLE KEYS */;


--
-- Definition of table `Genero`
--

DROP TABLE IF EXISTS `Genero`;
CREATE TABLE `Genero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET latin1 NOT NULL,
  `descripcion` varchar(80) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `Genero`
--

/*!40000 ALTER TABLE `Genero` DISABLE KEYS */;
INSERT INTO `Genero` (`id`,`nombre`,`descripcion`) VALUES 
 (2,'Terror','Peliculas de miedo'),
 (3,'Social','Cine Social'),
 (4,'Belico','Cine de guerra'),
 (5,'Drama','Cine que trata los conflictos entre los personajes.'),
 (6,'Bizarro','Cine joda.'),
 (7,'Comedia Romantica','para dobolus'),
 (8,'Europeo','Cine Europeo de los 40s'),
 (9,'Pijas Ahumadas','asdioasdioj'),
 (10,'Boeroiar','AOSdijo'),
 (11,'Bergamatutus','soaidjoij'),
 (12,'Hueon','OASIjdoi'),
 (13,'2asoidj','\r\noiasjdoi'),
 (15,'asdoij','oiasjdoi'),
 (16,'PIjongas','oijasdoij');
/*!40000 ALTER TABLE `Genero` ENABLE KEYS */;


--
-- Definition of table `GeneroDeLaPelicula`
--

DROP TABLE IF EXISTS `GeneroDeLaPelicula`;
CREATE TABLE `GeneroDeLaPelicula` (
  `idPeliculas` int(11) NOT NULL DEFAULT '0',
  `idGenero` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idPeliculas`,`idGenero`),
  KEY `idGenero` (`idGenero`),
  CONSTRAINT `GeneroDeLaPelicula_ibfk_1` FOREIGN KEY (`idPeliculas`) REFERENCES `Pelicula` (`id`),
  CONSTRAINT `GeneroDeLaPelicula_ibfk_2` FOREIGN KEY (`idPeliculas`) REFERENCES `Pelicula` (`id`),
  CONSTRAINT `GeneroDeLaPelicula_ibfk_3` FOREIGN KEY (`idGenero`) REFERENCES `Genero` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `GeneroDeLaPelicula`
--

/*!40000 ALTER TABLE `GeneroDeLaPelicula` DISABLE KEYS */;
INSERT INTO `GeneroDeLaPelicula` (`idPeliculas`,`idGenero`) VALUES 
 (1,2),
 (1,3),
 (3,3),
 (4,3),
 (6,3),
 (1,4),
 (1,5),
 (3,5),
 (4,5),
 (5,5),
 (1,6);
/*!40000 ALTER TABLE `GeneroDeLaPelicula` ENABLE KEYS */;


--
-- Definition of table `Pelicula`
--

DROP TABLE IF EXISTS `Pelicula`;
CREATE TABLE `Pelicula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) CHARACTER SET latin1 DEFAULT NULL,
  `fechaEstreno` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `Pelicula`
--

/*!40000 ALTER TABLE `Pelicula` DISABLE KEYS */;
INSERT INTO `Pelicula` (`id`,`nombre`,`fechaEstreno`) VALUES 
 (1,'La Patagonia Rebelde','1974-06-13'),
 (3,'La Historia Oficial','1982-01-01'),
 (4,'Tiempo de Revancha','1978-08-06'),
 (5,'Dias Atras','1959-05-07'),
 (6,'Tangos, el exilio de Gardel','1995-07-05');
/*!40000 ALTER TABLE `Pelicula` ENABLE KEYS */;


--
-- Definition of table `Staff`
--

DROP TABLE IF EXISTS `Staff`;
CREATE TABLE `Staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `apellido` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `nacionalidad` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `Staff`
--

/*!40000 ALTER TABLE `Staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `Staff` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
