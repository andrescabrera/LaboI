-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.27-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bdpeliculas
--

CREATE DATABASE IF NOT EXISTS bdpeliculas;
USE bdpeliculas;

--
-- Definition of table `funcion`
--

DROP TABLE IF EXISTS `funcion`;
CREATE TABLE `funcion` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(80) character set latin1 default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `funcion`
--

/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;


--
-- Definition of table `funcionstaffpelicula`
--

DROP TABLE IF EXISTS `funcionstaffpelicula`;
CREATE TABLE `funcionstaffpelicula` (
  `idPelicula` int(11) NOT NULL default '0',
  `idStaff` int(11) NOT NULL default '0',
  `idFuncion` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idPelicula`,`idStaff`,`idFuncion`),
  KEY `idFuncion` (`idFuncion`),
  KEY `idStaff` (`idStaff`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_1` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_2` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`id`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_3` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`id`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_4` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `FuncionStaffPelicula_ibfk_5` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `funcionstaffpelicula`
--

/*!40000 ALTER TABLE `funcionstaffpelicula` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionstaffpelicula` ENABLE KEYS */;


--
-- Definition of table `genero`
--

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(45) character set latin1 NOT NULL,
  `descripcion` varchar(350) character set latin1 default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `genero`
--

/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` (`id`,`nombre`,`descripcion`) VALUES 
 (2,'Terror','Peliculas de miedo'),
 (4,'Belico','Cine de guerra'),
 (5,'Drama','Cine que trata los conflictos entre los personajes.'),
 (26,'Comedia','Cine que da risa'),
 (30,'Accion','El cine de accion es un genero cinematografico en el que prima la espectacularidad de las imagenes por medio de efectos especiales dejando al margen cualquier otra consideraciÃ³n.'),
 (31,'Ciencia Ficcion','La ciencia ficcion es la denominacion popular con que se conoce a uno de los generos derivados de la literatura de ficcion, junto con la literatura fantastica y la narrativa de terror.');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;


--
-- Definition of table `generodelapelicula`
--

DROP TABLE IF EXISTS `generodelapelicula`;
CREATE TABLE `generodelapelicula` (
  `idPeliculas` int(11) NOT NULL default '0',
  `idGenero` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idPeliculas`,`idGenero`),
  KEY `idGenero` (`idGenero`),
  CONSTRAINT `GeneroDeLaPelicula_ibfk_1` FOREIGN KEY (`idPeliculas`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `GeneroDeLaPelicula_ibfk_2` FOREIGN KEY (`idPeliculas`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `GeneroDeLaPelicula_ibfk_3` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `generodelapelicula`
--

/*!40000 ALTER TABLE `generodelapelicula` DISABLE KEYS */;
INSERT INTO `generodelapelicula` (`idPeliculas`,`idGenero`) VALUES 
 (1,2),
 (6,2),
 (1,4),
 (3,4),
 (6,4),
 (3,5),
 (6,5),
 (8,5),
 (3,26),
 (1,30),
 (1,31);
/*!40000 ALTER TABLE `generodelapelicula` ENABLE KEYS */;


--
-- Definition of table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
CREATE TABLE `pelicula` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(80) character set latin1 default NULL,
  `fechaEstreno` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `pelicula`
--

/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` (`id`,`nombre`,`fechaEstreno`) VALUES 
 (1,'La Patagonia Rebelde','1974-06-13'),
 (3,'La Historia Oficial','1982-01-01'),
 (6,'Tangos, el exilio de Gardel','1995-07-05'),
 (8,'el turista','2011-01-01');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;


--
-- Definition of table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(45) character set latin1 default NULL,
  `apellido` varchar(45) character set latin1 default NULL,
  `nacionalidad` varchar(45) character set latin1 default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `staff`
--

/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
