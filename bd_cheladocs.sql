-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.10-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema cheladocs
--

CREATE DATABASE IF NOT EXISTS cheladocs;
USE cheladocs;

--
-- Definition of table `contato`
--

DROP TABLE IF EXISTS `contato`;
CREATE TABLE `contato` (
  `id_contato` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_juridica` varchar(45) DEFAULT NULL,
  `nome_contato` varchar(45) DEFAULT NULL,
  `sobrenome_contato` varchar(45) DEFAULT NULL,
  `telefone_principal` varchar(45) DEFAULT NULL,
  `telefone_alternativo_contato` varchar(45) DEFAULT NULL,
  `email_principal_contato` varchar(45) DEFAULT NULL,
  `email_alternativo_contato` varchar(45) DEFAULT NULL,
  `home_page_contato` varchar(45) DEFAULT NULL,
  `id_provincia` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  PRIMARY KEY (`id_contato`),
  KEY `fk_contato_provincia1_idx` (`id_provincia`),
  KEY `fk_contato_endereco1_idx` (`id_endereco`),
  CONSTRAINT `fk_contato_endereco1` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contato_provincia1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contato`
--

/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;


--
-- Definition of table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;


--
-- Definition of table `documento`
--

DROP TABLE IF EXISTS `documento`;
CREATE TABLE `documento` (
  `id_documento_progressivo` int(11) NOT NULL AUTO_INCREMENT,
  `numero_protocolo` varchar(45) DEFAULT NULL,
  `data_entrada` date DEFAULT NULL,
  `origem` varchar(45) DEFAULT NULL,
  `descricao_assunto` varchar(45) DEFAULT NULL,
  `id_natureza_assunto` int(11) NOT NULL,
  `id_tipo_expediente` int(11) NOT NULL,
  `solicitante` varchar(45) DEFAULT NULL,
  `id_contato` int(11) NOT NULL,
  `url_ficheiro_documento` varchar(100) DEFAULT NULL,
  `conteudo_documento` longblob,
  PRIMARY KEY (`id_documento_progressivo`),
  KEY `fk_documento_natureza_assunto_idx` (`id_natureza_assunto`),
  KEY `fk_documento_tipo_expediente1_idx` (`id_tipo_expediente`),
  KEY `fk_documento_contato1_idx` (`id_contato`),
  CONSTRAINT `fk_documento_contato1` FOREIGN KEY (`id_contato`) REFERENCES `contato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_natureza_assunto` FOREIGN KEY (`id_natureza_assunto`) REFERENCES `natureza_assunto` (`id_natureza_assunto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_tipo_expediente1` FOREIGN KEY (`id_tipo_expediente`) REFERENCES `tipo_expediente` (`id_tipo_expediente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `documento`
--

/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;


--
-- Definition of table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `caixa_postal` varchar(45) DEFAULT NULL,
  `rua_endereco` varchar(45) DEFAULT NULL,
  `casa_endereco` varchar(45) DEFAULT NULL,
  `bairro_endereco` varchar(45) DEFAULT NULL,
  `municipio_endereco` varchar(45) DEFAULT NULL,
  `cidade_endereco` varchar(45) DEFAULT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `fk_endereco_provincia1_idx` (`id_provincia`),
  CONSTRAINT `fk_endereco_provincia1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `endereco`
--

/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;


--
-- Definition of table `movimento_documento`
--

DROP TABLE IF EXISTS `movimento_documento`;
CREATE TABLE `movimento_documento` (
  `id_movimento_progressivo` int(11) NOT NULL AUTO_INCREMENT,
  `data_recepcao` datetime DEFAULT NULL,
  `data_reenvio` datetime DEFAULT NULL,
  `id_departamento` int(11) NOT NULL,
  `notas` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_movimento_progressivo`),
  KEY `fk_movimento_documento_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_movimento_documento_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `movimento_documento`
--

/*!40000 ALTER TABLE `movimento_documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimento_documento` ENABLE KEYS */;


--
-- Definition of table `natureza_assunto`
--

DROP TABLE IF EXISTS `natureza_assunto`;
CREATE TABLE `natureza_assunto` (
  `id_natureza_assunto` int(11) NOT NULL AUTO_INCREMENT,
  `natureza_assunto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_natureza_assunto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `natureza_assunto`
--

/*!40000 ALTER TABLE `natureza_assunto` DISABLE KEYS */;
/*!40000 ALTER TABLE `natureza_assunto` ENABLE KEYS */;


--
-- Definition of table `pais`
--

DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `id_pais` char(20) NOT NULL,
  `pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pais`
--

/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;


--
-- Definition of table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(45) DEFAULT NULL,
  `id_pais` char(20) NOT NULL,
  PRIMARY KEY (`id_provincia`),
  KEY `fk_provincia_pais1_idx` (`id_pais`),
  CONSTRAINT `fk_provincia_pais1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;


--
-- Definition of table `tipo_expediente`
--

DROP TABLE IF EXISTS `tipo_expediente`;
CREATE TABLE `tipo_expediente` (
  `id_tipo_expediente` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_expediente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_expediente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_expediente`
--

/*!40000 ALTER TABLE `tipo_expediente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_expediente` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
