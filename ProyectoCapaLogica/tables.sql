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

  INSERT INTO `Equipos` (`codigoPais`, `nombrePais`, `ranking`) VALUES
('DEU', 'Alemania', '1558'),
('BRA', 'Brasil', '1431'),
('BEL', 'Bélgica', '1298');

INSERT INTO `Usuarios` (`tipoUsuario`, `nombre`, `apellidos`, `correo`, `puntos`, `favorito`, `avatar`, `userName`, `clave`) VALUES
(0, 'Carolina', 'Perez', 'carolina@gmail.com', '0', 1, NULL, 'carolinaLL', 'carolina000'),
(1, 'Mario', 'Perez', 'maria@gmail.com', '0', 1, NULL, 'marioPP', 'mario100'),
(1, 'Carlos', 'Paz', 'carlos@gmail.com', '0', 2, NULL, 'carlos07', 'carlos1898');


