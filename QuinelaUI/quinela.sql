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
  `favorito` int(11) NOT NULL,
  `avatar` varchar(50) DEFAULT NULL,
  `userName` varchar(20) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `tipoUsuario` decimal(2,0) NOT NULL,
  CONSTRAINT PK_Usuarios PRIMARY KEY (codigoUsuario),
  CONSTRAINT FK_Equipos FOREIGN KEY (favorito) REFERENCES Equipos(codigoEquipo));

CREATE TABLE `Juegos` (
  `codigoJuego` int(11) NOT NULL AUTO_INCREMENT,
  `primero` int(11) NOT NULL,
  `segundo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `ganador` int(11) DEFAULT NULL,
  `marcador` varchar(20) DEFAULT NULL,
  CONSTRAINT PK_Juego PRIMARY KEY (codigoJuego),
  CONSTRAINT FK_Primero FOREIGN KEY (primero) REFERENCES Equipos(codigoEquipo),
  CONSTRAINT FK_Segundo FOREIGN KEY (segundo) REFERENCES Equipos(codigoEquipo),
  CONSTRAINT FK_Ganador FOREIGN KEY (ganador) REFERENCES Equipos(codigoEquipo));


CREATE TABLE `Grupos` (
  `codigoGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` char(20) NOT NULL,
  CONSTRAINT PK_Grupos PRIMARY KEY (codigoGrupo)
)

CREATE TABLE `FaseGrupos` (
  `codigoGrupo` int(11) NOT NULL,
  `codigoEquipo` int(11) NOT NULL,
  `codigoFaseGrupo` int(11) NOT NULL,
  CONSTRAINT PK_Grupos PRIMARY KEY (codigoFaseGrupo),
  CONSTRAINT FK_CodigoGrupo FOREIGN KEY (codigoGrupo) REFERENCES Grupos(codigoGrupo),
  CONSTRAINT FK_CodigoEquipo FOREIGN KEY (codigoEquipo) REFERENCES Equipos(codigoEquipo)
)

  INSERT INTO `Equipos` (`codigoPais`, `nombrePais`, `ranking`) VALUES
('DEU', 'Alemania', '1558'),
('BRA', 'Brasil', '1431'),
('BEL', 'Bélgica', '1298');

INSERT INTO `Usuarios` (`tipoUsuario`, `nombre`, `apellidos`, `correo`, `puntos`, `favorito`, `avatar`, `userName`, `clave`) VALUES
(0, 'Carolina', 'Perez', 'carolina@gmail.com', '0', 1, NULL, 'carolinaLL', 'carolina000'),
(1, 'Mario', 'Perez', 'maria@gmail.com', '0', 1, NULL, 'marioPP', 'mario100'),
(1, 'Carlos', 'Paz', 'carlos@gmail.com', '0', 2, NULL, 'carlos07', 'carlos1898');

INSERT INTO `Juego` (`primero`, `segundo`, `fecha`, `ganador`, `marcador`) VALUES 
('1', '2', '2018-08-08', '1', '2-1');

INSERT INTO `Grupos` (`nombre`) VALUES ('Grupo 1'), ('Grupo 2'), ('Grupo 3');