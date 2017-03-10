-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.17-log


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
-- Definition of table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` (`id_departamento`,`departamento`) VALUES 
 (1,'Recursos Humanos');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;


--
-- Definition of table `documento`
--

DROP TABLE IF EXISTS `documento`;
CREATE TABLE `documento` (
  `numero_protocolo` int(11) NOT NULL AUTO_INCREMENT,
  `id_requerente` int(11) NOT NULL,
  `data_entrada` date DEFAULT NULL,
  `origem` varchar(45) DEFAULT NULL,
  `descricao_assunto` varchar(45) DEFAULT NULL,
  `id_natureza_assunto` int(11) NOT NULL,
  `id_tipo_expediente` int(11) NOT NULL,
  `url_ficheiro_documento` varchar(100) DEFAULT NULL,
  `conteudo_documento` longblob,
  PRIMARY KEY (`numero_protocolo`),
  KEY `fk_documento_natureza_assunto_idx` (`id_natureza_assunto`),
  KEY `fk_documento_tipo_expediente1_idx` (`id_tipo_expediente`),
  KEY `fk_documento_solicitante1_idx` (`id_requerente`),
  CONSTRAINT `fk_documento_natureza_assunto` FOREIGN KEY (`id_natureza_assunto`) REFERENCES `natureza_assunto` (`id_natureza_assunto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_solicitante1` FOREIGN KEY (`id_requerente`) REFERENCES `requerente` (`id_requerente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
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
  `id_requerente` int(11) NOT NULL,
  `flag_activo` bit(1) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `fk_endereco_provincia1_idx` (`id_provincia`),
  KEY `fk_endereco_requerente1_idx` (`id_requerente`),
  CONSTRAINT `fk_endereco_provincia1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_requerente1` FOREIGN KEY (`id_requerente`) REFERENCES `requerente` (`id_requerente`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `numero_protocolo` int(11) NOT NULL,
  PRIMARY KEY (`id_movimento_progressivo`),
  KEY `fk_movimento_documento_departamento1_idx` (`id_departamento`),
  KEY `fk_movimento_documento_documento1_idx` (`numero_protocolo`),
  CONSTRAINT `fk_movimento_documento_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimento_documento_documento1` FOREIGN KEY (`numero_protocolo`) REFERENCES `documento` (`numero_protocolo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `movimento_documento`
--

/*!40000 ALTER TABLE `movimento_documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimento_documento` ENABLE KEYS */;


--
-- Definition of table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
CREATE TABLE `municipio` (
  `id_municipio` int(11) NOT NULL AUTO_INCREMENT,
  `municipio` varchar(45) DEFAULT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_municipio`),
  KEY `fk_municipio_provincia1_idx` (`id_provincia`),
  CONSTRAINT `fk_municipio_provincia1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `municipio`
--

/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` (`id_municipio`,`municipio`,`id_provincia`) VALUES 
 (1,'Ambriz',1),
 (2,'Bula Atumba',1),
 (3,'Dande',1),
 (4,'Dembos',1),
 (5,'Nambuangongo',1),
 (6,'Pango Aluquém',1),
 (7,'Balombo',2),
 (8,'Baia Farta',2),
 (9,'Benguela',2),
 (10,'Bocoio',2),
 (11,'Caimbambo',2),
 (12,'Catumbela',2),
 (13,'Chongoroi',2),
 (14,'Cubal',2),
 (15,'Ganda',2),
 (16,'Lobito',2),
 (17,'Andulo',3),
 (18,'Camacupa',3),
 (19,'Catabola',3),
 (20,'Chinguar',3),
 (21,'Chitembo',3),
 (22,'Cuemba',3),
 (23,'Cunhinga',3),
 (24,'Kuito',3),
 (25,'Nharea',3),
 (26,'Belize',4),
 (27,'Buco-Zau',4),
 (28,'Cabinda',4),
 (29,'Cacongo',4),
 (30,'Calai',5),
 (31,'Cuangar',5),
 (32,'Cuchi',5),
 (33,'Cuito Cuanavale',5),
 (34,'Dirico',5),
 (35,'Mavinga',5),
 (36,'Menongue',5),
 (37,'Nancova',5),
 (38,'Rivungo',5),
 (39,'Cahama',8),
 (40,'Cuanhama',8),
 (41,'Curoca',8),
 (42,'Cuvelai',8),
 (43,'Namacunde',8),
 (44,'Ombadja',8),
 (45,'Bailundo',9),
 (46,'Catchiungo',9),
 (47,'Caala',9),
 (48,'Ekuma',9),
 (49,'Huambo',9),
 (50,'Londuimbale',9),
 (51,'Longonjo',9),
 (52,'Mungo',9),
 (53,'Tchicala-Tchiloanga',9),
 (54,'Tchindjenje',9),
 (55,'Ucuma',9),
 (56,'Caconda',10),
 (57,'Cacula',10),
 (58,'Caluquembe',10),
 (59,'Gambos',10),
 (60,'Chibia',10),
 (61,'Chicomba',10),
 (62,'Chipindo',10),
 (63,'Cuvango',10),
 (64,'Humpata',10),
 (65,'Jamba',10),
 (66,'Lubango',10),
 (67,'Matala',10),
 (68,'Quilengues',10),
 (69,'Quipungo',10),
 (70,'Ambaca',6),
 (71,'Banga',6),
 (72,'Bolongongo',6),
 (73,'Cambambe',6),
 (74,'Cazengo',6),
 (75,'Golungo Alto',6),
 (76,'Gonguembo',6),
 (77,'Lucala',6),
 (78,'Quiculungo',6),
 (79,'Samba Caju',6),
 (80,'Cassongue',7),
 (81,'Conda',7),
 (82,'Ebo',7),
 (83,'Libolo',7),
 (84,'Mussende',7),
 (85,'Porto Amboin',7),
 (86,'Quibala',7),
 (87,'Quilenda',7),
 (88,'Seles',7),
 (89,'Sumbe',7),
 (90,'Waku Kungo',7),
 (91,'Belas',11),
 (92,'Cacuaco',11),
 (93,'Cazenga',11),
 (94,'Icolo e Bengo',11),
 (95,'Luanda',11),
 (96,'Quiçama',11),
 (97,'Viana',11),
 (98,'Cambulo',12),
 (99,'Capenda-Camulemba',12),
 (100,'Caungula',12),
 (101,'Chitato',12),
 (102,'Cuango',12),
 (103,'Cuilo',12),
 (104,'Lubalo',12),
 (105,'Lukapa',12),
 (106,'Xá-Muteba',12),
 (107,'Cacolo',13),
 (108,'Dala',13),
 (109,'Muconda',13),
 (110,'Saurimo',13),
 (111,'Cacuso',14),
 (112,'Calandula',14),
 (113,'Cambundi-Catembo',14),
 (114,'Cangandala',14),
 (115,'Caombo',14),
 (116,'Cuaba Nzogo',14),
 (117,'Cunda-Dia-Baze',14),
 (118,'Luquembo',14),
 (119,'Malange',14),
 (120,'Marimba',14),
 (121,'Massango',14),
 (122,'Mucari',14),
 (123,'Quela',14),
 (124,'Quirima',14),
 (125,'Alto Zambeze',15),
 (126,'Bundas',15),
 (127,'Camanongue',15),
 (128,'Léua',15),
 (129,'Luau',15),
 (130,'Luacano',15),
 (131,'Luchazes',15),
 (132,'Lumeje',15),
 (133,'Moxico',15),
 (134,'Bibala',16),
 (135,'Camucuio',16),
 (136,'Namibe',16),
 (137,'Tômbua',16),
 (138,'Virei',16),
 (139,'Alto Cauale',17),
 (140,'Ambuila',17),
 (141,'Bembe',17),
 (142,'Buengas',17),
 (143,'Bungo',17),
 (144,'Damba',17),
 (145,'Macocola',17),
 (146,'Mucaba',17),
 (147,'Negage',17),
 (148,'Puri',17),
 (149,'Quimbele',17),
 (150,'Quitexe',17),
 (151,'Sanza Pombo',17),
 (152,'Songo',17),
 (153,'Uige',17),
 (154,'Zombo',17),
 (155,'Cuimba',18),
 (156,'M\'Banza Kongo',18),
 (157,'Noqui',18),
 (158,'N\'Zeto',18),
 (159,'Soyo',18),
 (160,'Tomboco',18);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;


--
-- Definition of table `natureza_assunto`
--

DROP TABLE IF EXISTS `natureza_assunto`;
CREATE TABLE `natureza_assunto` (
  `id_natureza_assunto` int(11) NOT NULL AUTO_INCREMENT,
  `natureza_assunto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_natureza_assunto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `natureza_assunto`
--

/*!40000 ALTER TABLE `natureza_assunto` DISABLE KEYS */;
INSERT INTO `natureza_assunto` (`id_natureza_assunto`,`natureza_assunto`) VALUES 
 (2,'A1');
/*!40000 ALTER TABLE `natureza_assunto` ENABLE KEYS */;


--
-- Definition of table `pais`
--

DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,
  `nome_pais` varchar(50) DEFAULT NULL,
  `name_pais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pais`
--

/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` (`id_pais`,`nome_pais`,`name_pais`) VALUES 
 (1,'AFEGANISTÃO','AFGHANISTAN'),
 (2,'ACROTÍRI E DECELIA','AKROTIRI E DEKÉLIA'),
 (3,'ÁFRICA DO SUL','SOUTH AFRICA'),
 (4,'ALBÂNIA','ALBANIA'),
 (5,'ALEMANHA','GERMANY'),
 (6,'AMERICAN SAMOA','AMERICAN SAMOA'),
 (7,'ANDORRA','ANDORRA'),
 (8,'ANGOLA','ANGOLA'),
 (9,'ANGUILLA','ANGUILLA'),
 (10,'ANTÍGUA E BARBUDA','ANTIGUA AND BARBUDA'),
 (11,'ANTILHAS NEERLANDESAS','NETHERLANDS ANTILLES'),
 (12,'ARÁBIA SAUDITA','SAUDI ARABIA'),
 (13,'ARGÉLIA','ALGERIA'),
 (14,'ARGENTINA','ARGENTINA'),
 (15,'ARMÉNIA','ARMENIA'),
 (16,'ARUBA','ARUBA'),
 (17,'AUSTRÁLIA','AUSTRALIA'),
 (18,'ÁUSTRIA','AUSTRIA'),
 (19,'AZERBAIJÃO','AZERBAIJAN'),
 (20,'BAHAMAS','BAHAMAS, THE'),
 (21,'BANGLADECHE','BANGLADESH'),
 (22,'BARBADOS','BARBADOS'),
 (23,'BARÉM','BAHRAIN'),
 (24,'BASSAS DA ÍNDIA','BASSAS DA INDIA'),
 (25,'BÉLGICA','BELGIUM'),
 (26,'BELIZE','BELIZE'),
 (27,'BENIM','BENIN'),
 (28,'BERMUDAS','BERMUDA'),
 (29,'BIELORRÚSSIA','BELARUS'),
 (30,'BOLÍVIA','BOLIVIA'),
 (31,'BÓSNIA E HERZEGOVINA','BOSNIA AND HERZEGOVINA'),
 (32,'BOTSUANA','BOTSWANA'),
 (33,'BRASIL','BRAZIL'),
 (34,'BRUNEI DARUSSALAM','BRUNEI DARUSSALAM'),
 (35,'BULGÁRIA','BULGARIA'),
 (36,'BURQUINA FASO','BURKINA FASO'),
 (37,'BURUNDI','BURUNDI'),
 (38,'BUTÃO','BHUTAN'),
 (39,'CABO VERDE','CAPE VERDE'),
 (40,'CAMARÕES','CAMEROON'),
 (41,'CAMBOJA','CAMBODIA'),
 (42,'CANADÁ','CANADA'),
 (43,'CATAR','QATAR'),
 (44,'CAZAQUISTÃO','KAZAKHSTAN'),
 (45,'CENTRO-AFRICANA REPÚBLICA','CENTRAL AFRICAN REPUBLIC'),
 (46,'CHADE','CHAD'),
 (47,'CHILE','CHILE'),
 (48,'CHINA','CHINA'),
 (49,'CHIPRE','CYPRUS'),
 (50,'COLÔMBIA','COLOMBIA'),
 (51,'COMORES','COMOROS'),
 (52,'CONGO','CONGO'),
 (53,'CONGO REPÚBLICA DEMOCRÁTICA','CONGO DEMOCRATIC REPUBLIC'),
 (54,'COREIA DO NORTE','KOREA NORTH'),
 (55,'COREIA DO SUL','KOREA SOUTH'),
 (56,'COSTA DO MARFIM','IVORY COAST'),
 (57,'COSTA RICA','COSTA RICA'),
 (58,'CROÁCIA','CROATIA'),
 (59,'CUBA','CUBA'),
 (60,'DINAMARCA','DENMARK'),
 (61,'DOMÍNICA','DOMINICA'),
 (62,'EGIPTO','EGYPT'),
 (63,'EMIRADOS ÁRABES UNIDOS','UNITED ARAB EMIRATES'),
 (64,'EQUADOR','ECUADOR'),
 (65,'ERITREIA','ERITREA'),
 (66,'ESLOVÁQUIA','SLOVAKIA'),
 (67,'ESLOVÉNIA','SLOVENIA'),
 (68,'ESPANHA','SPAIN'),
 (69,'ESTADOS UNIDOS','UNITED STATES'),
 (70,'ESTÓNIA','ESTONIA'),
 (71,'ETIÓPIA','ETHIOPIA'),
 (72,'FAIXA DE GAZA','GAZA STRIP'),
 (73,'FIJI','FIJI'),
 (74,'FILIPINAS','PHILIPPINES'),
 (75,'FINLÂNDIA','FINLAND'),
 (76,'FRANÇA','FRANCE'),
 (77,'GABÃO','GABON'),
 (78,'GÂMBIA','GAMBIA'),
 (79,'GANA','GHANA'),
 (80,'GEÓRGIA','GEORGIA'),
 (81,'GIBRALTAR','GIBRALTAR'),
 (82,'GRANADA','GRENADA'),
 (83,'GRÉCIA','GREECE'),
 (84,'GRONELÂNDIA','GREENLAND'),
 (85,'GUADALUPE','GUADELOUPE'),
 (86,'GUAM','GUAM'),
 (87,'GUATEMALA','GUATEMALA'),
 (88,'GUERNSEY','GUERNSEY'),
 (89,'GUIANA','GUYANA'),
 (90,'GUIANA FRANCESA','FRENCH GUIANA'),
 (91,'GUINÉ','GUINEA'),
 (92,'GUINÉ EQUATORIAL','EQUATORIAL GUINEA'),
 (93,'GUINÉ-BISSAU','GUINEA-BISSAU'),
 (94,'HAITI','HAITI'),
 (95,'HONDURAS','HONDURAS'),
 (96,'HONG KONG','HONG KONG'),
 (97,'HUNGRIA','HUNGARY'),
 (98,'IÉMEN','YEMEN'),
 (99,'ILHA BOUVET','BOUVET ISLAND'),
 (100,'ILHA CHRISTMAS','CHRISTMAS ISLAND'),
 (101,'ILHA DE CLIPPERTON','CLIPPERTON ISLAND'),
 (102,'ILHA DE JOÃO DA NOVA','JUAN DE NOVA ISLAND'),
 (103,'ILHA DE MAN','ISLE OF MAN'),
 (104,'ILHA DE NAVASSA','NAVASSA ISLAND'),
 (105,'ILHA EUROPA','EUROPA ISLAND'),
 (106,'ILHA NORFOLK','NORFOLK ISLAND'),
 (107,'ILHA TROMELIN','TROMELIN ISLAND'),
 (108,'ILHAS ASHMORE E CARTIER','ASHMORE AND CARTIER ISLANDS'),
 (109,'ILHAS CAIMAN','CAYMAN ISLANDS'),
 (110,'ILHAS COCOS (KEELING)','COCOS (KEELING) ISLANDS'),
 (111,'ILHAS COOK','COOK ISLANDS'),
 (112,'ILHAS DO MAR DE CORAL','CORAL SEA ISLANDS'),
 (113,'ILHAS FALKLANDS (ILHAS MALVINAS)','FALKLAND ISLANDS (ISLAS MALVINAS)'),
 (114,'ILHAS FEROE','FAROE ISLANDS'),
 (115,'ILHAS GEÓRGIA DO SUL E SANDWICH DO SUL','SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS'),
 (116,'ILHAS MARIANAS DO NORTE','NORTHERN MARIANA ISLANDS'),
 (117,'ILHAS MARSHALL','MARSHALL ISLANDS'),
 (118,'ILHAS PARACEL','PARACEL ISLANDS'),
 (119,'ILHAS PITCAIRN','PITCAIRN ISLANDS'),
 (120,'ILHAS SALOMÃO','SOLOMON ISLANDS'),
 (121,'ILHAS SPRATLY','SPRATLY ISLANDS'),
 (122,'ILHAS VIRGENS AMERICANAS','UNITED STATES VIRGIN ISLANDS'),
 (123,'ILHAS VIRGENS BRITÂNICAS','BRITISH VIRGIN ISLANDS'),
 (124,'ÍNDIA','INDIA'),
 (125,'INDONÉSIA','INDONESIA'),
 (126,'IRÃO','IRAN'),
 (127,'IRAQUE','IRAQ'),
 (128,'IRLANDA','IRELAND'),
 (129,'ISLÂNDIA','ICELAND'),
 (130,'ISRAEL','ISRAEL'),
 (131,'ITÁLIA','ITALY'),
 (132,'JAMAICA','JAMAICA'),
 (133,'JAN MAYEN','JAN MAYEN'),
 (134,'JAPÃO','JAPAN'),
 (135,'JERSEY','JERSEY'),
 (136,'JIBUTI','DJIBOUTI'),
 (137,'JORDÂNIA','JORDAN'),
 (138,'KIRIBATI','KIRIBATI'),
 (139,'KOWEIT','KUWAIT'),
 (140,'LAOS','LAOS'),
 (141,'LESOTO','LESOTHO'),
 (142,'LETÓNIA','LATVIA'),
 (143,'LÍBANO','LEBANON'),
 (144,'LIBÉRIA','LIBERIA'),
 (145,'LÍBIA','LIBYAN ARAB JAMAHIRIYA'),
 (146,'LISTENSTAINE','LIECHTENSTEIN'),
 (147,'LITUÂNIA','LITHUANIA'),
 (148,'LUXEMBURGO','LUXEMBOURG'),
 (149,'MACAU','MACAO'),
 (150,'MACEDÓNIA','MACEDONIA'),
 (151,'MADAGÁSCAR','MADAGASCAR'),
 (152,'MALÁSIA','MALAYSIA'),
 (153,'MALAVI','MALAWI'),
 (154,'MALDIVAS','MALDIVES'),
 (155,'MALI','MALI'),
 (156,'MALTA','MALTA'),
 (157,'MARROCOS','MOROCCO'),
 (158,'MARTINICA','MARTINIQUE'),
 (159,'MAURÍCIA','MAURITIUS'),
 (160,'MAURITÂNIA','MAURITANIA'),
 (161,'MAYOTTE','MAYOTTE'),
 (162,'MÉXICO','MEXICO'),
 (163,'MIANMAR','MYANMAR BURMA'),
 (164,'MICRONÉSIA','MICRONESIA'),
 (165,'MOÇAMBIQUE','MOZAMBIQUE'),
 (166,'MOLDÁVIA','MOLDOVA'),
 (167,'MÓNACO','MONACO'),
 (168,'MONGÓLIA','MONGOLIA'),
 (169,'MONTENEGRO','MONTENEGRO'),
 (170,'MONTSERRAT','MONTSERRAT'),
 (171,'NAMÍBIA','NAMIBIA'),
 (172,'NAURU','NAURU'),
 (173,'NEPAL','NEPAL'),
 (174,'NICARÁGUA','NICARAGUA'),
 (175,'NÍGER','NIGER'),
 (176,'NIGÉRIA','NIGERIA'),
 (177,'NIUE','NIUE'),
 (178,'NORUEGA','NORWAY'),
 (179,'NOVA CALEDÓNIA','NEW CALEDONIA'),
 (180,'NOVA ZELÂNDIA','NEW ZEALAND'),
 (181,'OMÃ','OMAN'),
 (182,'PAÍSES BAIXOS','NETHERLANDS'),
 (183,'PALAU','PALAU'),
 (184,'PALESTINA','PALESTINE'),
 (185,'PANAMÁ','PANAMA'),
 (186,'PAPUÁSIA-NOVA GUINÉ','PAPUA NEW GUINEA'),
 (187,'PAQUISTÃO','PAKISTAN'),
 (188,'PARAGUAI','PARAGUAY'),
 (189,'PERU','PERU'),
 (190,'POLINÉSIA FRANCESA','FRENCH POLYNESIA'),
 (191,'POLÓNIA','POLAND'),
 (192,'PORTO RICO','PUERTO RICO'),
 (193,'PORTUGAL','PORTUGAL'),
 (194,'QUÉNIA','KENYA'),
 (195,'QUIRGUIZISTÃO','KYRGYZSTAN'),
 (196,'REINO UNIDO','UNITED KINGDOM'),
 (197,'REPÚBLICA CHECA','CZECH REPUBLIC'),
 (198,'REPÚBLICA DOMINICANA','DOMINICAN REPUBLIC'),
 (199,'ROMÉNIA','ROMANIA'),
 (200,'RUANDA','RWANDA'),
 (201,'RÚSSIA','RUSSIAN FEDERATION'),
 (202,'SAHARA OCCIDENTAL','WESTERN SAHARA'),
 (203,'SALVADOR','EL SALVADOR'),
 (204,'SAMOA','SAMOA'),
 (205,'SANTA HELENA','SAINT HELENA'),
 (206,'SANTA LÚCIA','SAINT LUCIA'),
 (207,'SANTA SÉ','HOLY SEE'),
 (208,'SÃO CRISTÓVÃO E NEVES','SAINT KITTS AND NEVIS'),
 (209,'SÃO MARINO','SAN MARINO'),
 (210,'SÃO PEDRO E MIQUELÃO','SAINT PIERRE AND MIQUELON'),
 (211,'SÃO TOMÉ E PRÍNCIPE','SAO TOME AND PRINCIPE'),
 (212,'SÃO VICENTE E GRANADINAS','SAINT VINCENT AND THE GRENADINES'),
 (213,'SEICHELES','SEYCHELLES'),
 (214,'SENEGAL','SENEGAL'),
 (215,'SERRA LEOA','SIERRA LEONE'),
 (216,'SÉRVIA','SERBIA'),
 (217,'SINGAPURA','SINGAPORE'),
 (218,'SÍRIA','SYRIA'),
 (219,'SOMÁLIA','SOMALIA'),
 (220,'SRI LANCA','SRI LANKA'),
 (221,'SUAZILÂNDIA','SWAZILAND'),
 (222,'SUDÃO','SUDAN'),
 (223,'SUÉCIA','SWEDEN'),
 (224,'SUÍÇA','SWITZERLAND'),
 (225,'SURINAME','SURINAME'),
 (226,'SVALBARD','SVALBARD'),
 (227,'TAILÂNDIA','THAILAND'),
 (228,'TAIWAN','TAIWAN'),
 (229,'TAJIQUISTÃO','TAJIKISTAN'),
 (230,'TANZÂNIA','TANZANIA'),
 (231,'TERRITÓRIO BRITÂNICO DO OCEANO ÍNDICO','BRITISH INDIAN OCEAN TERRITORY'),
 (232,'TERRITÓRIO DAS ILHAS HEARD E MCDONALD','HEARD ISLAND AND MCDONALD ISLANDS'),
 (233,'TIMOR-LESTE','TIMOR-LESTE'),
 (234,'TOGO','TOGO'),
 (235,'TOKELAU','TOKELAU'),
 (236,'TONGA','TONGA'),
 (237,'TRINDADE E TOBAGO','TRINIDAD AND TOBAGO'),
 (238,'TUNÍSIA','TUNISIA'),
 (239,'TURKS E CAICOS','TURKS AND CAICOS ISLANDS'),
 (240,'TURQUEMENISTÃO','TURKMENISTAN'),
 (241,'TURQUIA','TURKEY'),
 (242,'TUVALU','TUVALU'),
 (243,'UCRÂNIA','UKRAINE'),
 (244,'UGANDA','UGANDA'),
 (245,'URUGUAI','URUGUAY'),
 (246,'USBEQUISTÃO','UZBEKISTAN'),
 (247,'VANUATU','VANUATU'),
 (248,'VENEZUELA','VENEZUELA'),
 (249,'VIETNAME','VIETNAM'),
 (250,'WALLIS E FUTUNA','WALLIS AND FUTUNA'),
 (251,'ZÂMBIA','ZAMBIA'),
 (252,'ZIMBABUÉ','ZIMBABWE');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;


--
-- Definition of table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(45) DEFAULT NULL,
  `id_pais` int(11) NOT NULL,
  PRIMARY KEY (`id_provincia`),
  KEY `fk_provincia_pais1_idx` (`id_pais`),
  CONSTRAINT `fk_provincia_pais1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` (`id_provincia`,`provincia`,`id_pais`) VALUES 
 (1,'Bengo',8),
 (2,'Benguela',8),
 (3,'Bié',8),
 (4,'Cabinda',8),
 (5,'Cuando Cubango',8),
 (6,'Cuanza Norte',8),
 (7,'Cuanza Sul',8),
 (8,'Cunene',8),
 (9,'Huambo',8),
 (10,'Huila',8),
 (11,'Luanda',8),
 (12,'Lunda Norte',8),
 (13,'Lunda Sul',8),
 (14,'Malange',8),
 (15,'Moxico',8),
 (16,'Namibe',8),
 (17,'Uige',8),
 (18,'Zaire',8);
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;


--
-- Definition of table `requerente`
--

DROP TABLE IF EXISTS `requerente`;
CREATE TABLE `requerente` (
  `id_requerente` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_juridica` char(20) DEFAULT NULL,
  `nome_requerente` varchar(45) DEFAULT NULL,
  `sobrenome_requerente` varchar(45) DEFAULT NULL,
  `telefone_principal` varchar(45) DEFAULT NULL,
  `telefone_alternativo_requerente` varchar(45) DEFAULT NULL,
  `email_principal_requerente` varchar(45) DEFAULT NULL,
  `email_alternativo_requerente` varchar(45) DEFAULT NULL,
  `home_page_requerente` varchar(45) DEFAULT NULL,
  `sexo_requerente` char(20) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  PRIMARY KEY (`id_requerente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `requerente`
--

/*!40000 ALTER TABLE `requerente` DISABLE KEYS */;
INSERT INTO `requerente` (`id_requerente`,`categoria_juridica`,`nome_requerente`,`sobrenome_requerente`,`telefone_principal`,`telefone_alternativo_requerente`,`email_principal_requerente`,`email_alternativo_requerente`,`home_page_requerente`,`sexo_requerente`,`data_nascimento`) VALUES 
 (1,'A1','André','José','123456','456789','andre@gmail.com','123@hotmail.com','www.andre.co.ao',NULL,NULL);
/*!40000 ALTER TABLE `requerente` ENABLE KEYS */;


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
