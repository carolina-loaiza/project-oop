
CREATE TABLE `Mundial` (
  `codigoMundial` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(4) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  CONSTRAINT PK_Mundial PRIMARY KEY (codigoMundial));

CREATE TABLE `Equipos` (
  `codigoEquipo` int(11) NOT NULL AUTO_INCREMENT,
  `codigoPais` varchar(3) NOT NULL,
  `nombrePais` varchar(20) NOT NULL,
  `bandera` varchar(50) DEFAULT NULL,
  `ranking` decimal(7,0) NOT NULL,
  CONSTRAINT PK_Equipos PRIMARY KEY (codigoEquipo));

CREATE TABLE `Usuarios` (
  `codigoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `correo` varchar(20) NOT NULL,
  `puntos` decimal(7,0) DEFAULT NULL,
  `favorito` int(11) DEFAULT NULL,
  `avatar` varchar(50) DEFAULT NULL,
  `userName` varchar(20) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `tipoUsuario` decimal(2,0) NOT NULL,
  CONSTRAINT PK_Usuarios PRIMARY KEY (codigoUsuario));

CREATE TABLE `Juegos` (
  `codigoJuego` int(11) NOT NULL AUTO_INCREMENT,
  `codigoMundial` int(11) NOT NULL,
  `primero` int(11) NOT NULL,
  `segundo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `ganador` int(11) DEFAULT NULL,
  `marcador` varchar(20) DEFAULT NULL,
  CONSTRAINT PK_Juego PRIMARY KEY (codigoJuego),
  CONSTRAINT FK_Primero FOREIGN KEY (primero) REFERENCES Equipos(codigoEquipo),
  CONSTRAINT FK_Segundo FOREIGN KEY (segundo) REFERENCES Equipos(codigoEquipo));


CREATE TABLE `Grupos` (
  `codigoGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `codigoMundial` int(11) NOT NULL,
  `nombre` char(20) NOT NULL,
  `equipo1` int(11) NOT NULL,
  `equipo2` int(11) NOT NULL,
  `equipo3` int(11) NOT NULL,
  `equipo4` int(11) NOT NULL,
  CONSTRAINT PK_Grupos PRIMARY KEY (codigoGrupo),
  CONSTRAINT FK_EPrimero FOREIGN KEY (equipo1) REFERENCES Equipos(codigoEquipo),
  CONSTRAINT FK_ESegundo FOREIGN KEY (equipo2) REFERENCES Equipos(codigoEquipo),
  CONSTRAINT FK_ETercero FOREIGN KEY (equipo3) REFERENCES Equipos(codigoEquipo),
  CONSTRAINT FK_ECuarto FOREIGN KEY (equipo4) REFERENCES Equipos(codigoEquipo));

CREATE TABLE `Prediccion` ( 
  `codigoPrediccion` INT(11) NOT NULL AUTO_INCREMENT,
  `jugador` INT(11) NOT NULL,
  `partido` INT(11) NOT NULL,
  `prediccionGanador` INT(11) NOT NULL,
  `prediccionMarcador` varchar(20) NOT NULL,
  CONSTRAINT PK_Prediccion PRIMARY KEY (`codigoPrediccion`),
  CONSTRAINT FK_PartidoPrediccion FOREIGN KEY (partido) REFERENCES Juegos(codigoJuego),
  CONSTRAINT FK_PrediccionGanador FOREIGN KEY (prediccionGanador) REFERENCES Equipos(codigoEquipo));

CREATE TABLE `Liga` ( 
  `codigoLiga` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(50) NOT NULL ,
  `fechaCreacion` DATE NOT NULL ,
  `torneo` INT(11) NOT NULL ,
  `estado` BOOLEAN NOT NULL ,
  `administrador` INT(11) NOT NULL ,
  CONSTRAINT PK_LigaPrivada PRIMARY KEY (`codigoLiga`),
  CONSTRAINT FK_Administrador FOREIGN KEY (administrador) REFERENCES Usuarios(codigoUsuario));

CREATE TABLE `LigaUsuario` (
  `codigoLigaUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `codigoLiga` int(11) NOT NULL,
  `codigoUsuario` int(11) NOT NULL,
  CONSTRAINT PK_LigaUsuario PRIMARY KEY (codigoLigaUsuario),
  CONSTRAINT FK_LigaUsuarioLiga FOREIGN KEY (codigoLiga) REFERENCES Liga(codigoLiga),
  CONSTRAINT FK_LigaUsuarioUsuario FOREIGN KEY (codigoUsuario) REFERENCES Usuarios(codigoUsuario));

CREATE TABLE `LigaPrediccion` (
  `codigoLigaPrediccion` int(11) NOT NULL AUTO_INCREMENT,
  `codigoLiga` int(11) NOT NULL,
  `codigoPrediccion` int(11) NOT NULL,
  CONSTRAINT PK_LigaPrediccion PRIMARY KEY (codigoLigaPrediccion),
  CONSTRAINT FK_LigaPrediccionLiga FOREIGN KEY (codigoLiga) REFERENCES Liga(codigoLiga),
  CONSTRAINT FK_LigaPrediccionPrediccion FOREIGN KEY (codigoPrediccion) REFERENCES Prediccion(codigoPrediccion));


INSERT INTO `Mundial`(`year`, `pais`, `estado`) VALUES
(2018,'Alemania', true),
(2015,'Brasil', false);


INSERT INTO `Equipos`(`codigoPais`, `nombrePais`, `bandera`, `ranking`) VALUES
('DEU', 'Alemania', '', '1558'),
('CRI', 'Costa Rica', '', '1200'),
('BRA', 'Brasil', '', '1431'),
('BEL', 'Bélgica', '', '1298');


INSERT INTO `Usuarios` (`tipoUsuario`, `nombre`, `apellidos`, `correo`, `puntos`, `favorito`, `avatar`, `userName`, `clave`) VALUES
(0, 'Carolina', 'Perez', 'carolina@gmail.com', '0', 1, NULL, 'carolinaLL', 'carolina000'),
(1, 'Mario', 'Perez', 'maria@gmail.com', '0', 1, NULL, 'marioPP', 'mario100'),
(1, 'Carlos', 'Paz', 'carlos@gmail.com', '0', 2, NULL, 'carlos07', 'carlos1898');


INSERT INTO `Juegos`(`codigoMundial`, `primero`, `segundo`, `fecha`, `ganador`, `marcador`) VALUES 
(1,1,2,'2018-08-09',1,'2-1');


INSERT INTO `Grupos`(`codigoMundial`, `nombre`, `equipo1`, `equipo2`, `equipo3`, `equipo4`) VALUES 
(1,'Grupo #1',1,2,3,4);


INSERT INTO `Liga`(`nombre`, `fechaCreacion`, `torneo`, `estado`, `administrador`) VALUES 
('Liga #1','2018-06-09',1,true,1);


INSERT INTO `Prediccion`(`jugador`, `partido`, `prediccionGanador`, `prediccionMarcador`) VALUES
(2,1,1,'2-1');


INSERT INTO `LigaUsuario`(`codigoLiga`, `codigoUsuario`) VALUES
(1,2);


INSERT INTO `LigaPrediccion`(`codigoLiga`, `codigoPrediccion`) VALUES
(1, 1);
