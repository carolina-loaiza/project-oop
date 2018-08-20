-- phpMyAdmin SQL Dump
-- version 4.7.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Aug 20, 2018 at 02:09 AM
-- Server version: 5.6.35
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `quinela`
--

-- --------------------------------------------------------

--
-- Table structure for table `Equipos`
--

CREATE TABLE `Equipos` (
  `codigoEquipo` int(11) NOT NULL,
  `codigoPais` varchar(3) NOT NULL,
  `nombrePais` varchar(20) NOT NULL,
  `bandera` varchar(50) DEFAULT NULL,
  `ranking` decimal(7,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Equipos`
--

INSERT INTO `Equipos` (`codigoEquipo`, `codigoPais`, `nombrePais`, `bandera`, `ranking`) VALUES
(1, 'DEU', 'Alemania', '', '1558'),
(2, 'CRI', 'Costa Rica', '', '1200'),
(3, 'BRA', 'Brasil', '', '1431'),
(4, 'BEL', 'Bélgica', '', '1298'),
(5, 'MEX', 'Mexico', NULL, '989'),
(6, 'USA', 'USA', NULL, '873'),
(7, 'JAM', 'Jamaica', NULL, '588'),
(8, 'ARG', 'Argentina', NULL, '1241'),
(9, 'CHE', 'Switzerland', NULL, '1199'),
(10, 'FRA', 'France', NULL, '1198'),
(11, 'POL', 'Poland', NULL, '1183'),
(12, 'CHL', 'Chile', NULL, '1135'),
(13, 'ESP', 'Spain', NULL, '1126'),
(14, 'PER', 'Peru', NULL, '1125'),
(15, 'DNK', 'Denmark', NULL, '1051'),
(16, 'URY', 'Uruguay', NULL, '1018');

-- --------------------------------------------------------

--
-- Table structure for table `Grupos`
--

CREATE TABLE `Grupos` (
  `codigoGrupo` int(11) NOT NULL,
  `codigoMundial` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `equipo1` varchar(20) NOT NULL,
  `equipo2` varchar(20) NOT NULL,
  `equipo3` varchar(20) NOT NULL,
  `equipo4` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Grupos`
--

INSERT INTO `Grupos` (`codigoGrupo`, `codigoMundial`, `nombre`, `equipo1`, `equipo2`, `equipo3`, `equipo4`) VALUES
(1, 2018, 'Grupo #1', 'Alemania', 'Costa Rica', 'Brasil', 'Bélgica'),
(2, 2018, 'Grupo #2', 'Denmark', 'Uruguay', 'USA', 'Jamaica'),
(3, 2018, 'Grupo #3', 'France', 'Peru', 'Switzerland', 'Poland'),
(4, 2018, 'Grupo #4', 'Argentina', 'Jamaica', 'Spain', 'France');

-- --------------------------------------------------------

--
-- Table structure for table `Juegos`
--

CREATE TABLE `Juegos` (
  `codigoJuego` int(11) NOT NULL,
  `codigoMundial` int(11) NOT NULL,
  `primero` int(11) NOT NULL,
  `segundo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `ganador` int(11) DEFAULT NULL,
  `marcador` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Juegos`
--

INSERT INTO `Juegos` (`codigoJuego`, `codigoMundial`, `primero`, `segundo`, `fecha`, `ganador`, `marcador`) VALUES
(1, 1, 1, 2, '2018-08-09', 1, '2-1');

-- --------------------------------------------------------

--
-- Table structure for table `Liga`
--

CREATE TABLE `Liga` (
  `codigoLiga` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `torneo` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `administrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Liga`
--

INSERT INTO `Liga` (`codigoLiga`, `nombre`, `fechaCreacion`, `torneo`, `estado`, `administrador`) VALUES
(1, 'Liga #1', '2018-06-09', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `LigaPrediccion`
--

CREATE TABLE `LigaPrediccion` (
  `codigoLigaPrediccion` int(11) NOT NULL,
  `codigoLiga` int(11) NOT NULL,
  `codigoPrediccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `LigaPrediccion`
--

INSERT INTO `LigaPrediccion` (`codigoLigaPrediccion`, `codigoLiga`, `codigoPrediccion`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `LigaUsuario`
--

CREATE TABLE `LigaUsuario` (
  `codigoLigaUsuario` int(11) NOT NULL,
  `codigoLiga` int(11) NOT NULL,
  `codigoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `LigaUsuario`
--

INSERT INTO `LigaUsuario` (`codigoLigaUsuario`, `codigoLiga`, `codigoUsuario`) VALUES
(1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Mundial`
--

CREATE TABLE `Mundial` (
  `codigoMundial` int(11) NOT NULL,
  `year` int(4) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Mundial`
--

INSERT INTO `Mundial` (`codigoMundial`, `year`, `pais`, `estado`) VALUES
(3, 2022, 'USA', 0),
(4, 2018, 'Japón', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Prediccion`
--

CREATE TABLE `Prediccion` (
  `codigoPrediccion` int(11) NOT NULL,
  `jugador` int(11) NOT NULL,
  `partido` int(11) NOT NULL,
  `prediccionGanador` int(11) NOT NULL,
  `prediccionMarcador` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Prediccion`
--

INSERT INTO `Prediccion` (`codigoPrediccion`, `jugador`, `partido`, `prediccionGanador`, `prediccionMarcador`) VALUES
(1, 2, 1, 1, '2-1');

-- --------------------------------------------------------

--
-- Table structure for table `Usuarios`
--

CREATE TABLE `Usuarios` (
  `codigoUsuario` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `correo` varchar(20) NOT NULL,
  `puntos` decimal(7,0) DEFAULT NULL,
  `favorito` int(11) DEFAULT NULL,
  `avatar` varchar(50) DEFAULT NULL,
  `userName` varchar(20) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `tipoUsuario` decimal(2,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Usuarios`
--

INSERT INTO `Usuarios` (`codigoUsuario`, `nombre`, `apellidos`, `correo`, `puntos`, `favorito`, `avatar`, `userName`, `clave`, `tipoUsuario`) VALUES
(1, 'Carolina', 'Perez', 'carolina@gmail.com', '0', 1, NULL, 'carolinaLL', 'carolina000', '0'),
(2, 'Mario', 'Perez', 'maria@gmail.com', '0', 1, NULL, 'marioPP', 'mario100', '1'),
(3, 'Carlos', 'Paz', 'carlos@gmail.com', '0', 2, NULL, 'carlos07', 'carlos1898', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Equipos`
--
ALTER TABLE `Equipos`
  ADD PRIMARY KEY (`codigoEquipo`);

--
-- Indexes for table `Grupos`
--
ALTER TABLE `Grupos`
  ADD PRIMARY KEY (`codigoGrupo`);

--
-- Indexes for table `Juegos`
--
ALTER TABLE `Juegos`
  ADD PRIMARY KEY (`codigoJuego`),
  ADD KEY `FK_Primero` (`primero`),
  ADD KEY `FK_Segundo` (`segundo`);

--
-- Indexes for table `Liga`
--
ALTER TABLE `Liga`
  ADD PRIMARY KEY (`codigoLiga`),
  ADD KEY `FK_Administrador` (`administrador`);

--
-- Indexes for table `LigaPrediccion`
--
ALTER TABLE `LigaPrediccion`
  ADD PRIMARY KEY (`codigoLigaPrediccion`),
  ADD KEY `FK_LigaPrediccionLiga` (`codigoLiga`),
  ADD KEY `FK_LigaPrediccionPrediccion` (`codigoPrediccion`);

--
-- Indexes for table `LigaUsuario`
--
ALTER TABLE `LigaUsuario`
  ADD PRIMARY KEY (`codigoLigaUsuario`),
  ADD KEY `FK_LigaUsuarioLiga` (`codigoLiga`),
  ADD KEY `FK_LigaUsuarioUsuario` (`codigoUsuario`);

--
-- Indexes for table `Mundial`
--
ALTER TABLE `Mundial`
  ADD PRIMARY KEY (`codigoMundial`);

--
-- Indexes for table `Prediccion`
--
ALTER TABLE `Prediccion`
  ADD PRIMARY KEY (`codigoPrediccion`),
  ADD KEY `FK_PartidoPrediccion` (`partido`),
  ADD KEY `FK_PrediccionGanador` (`prediccionGanador`);

--
-- Indexes for table `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`codigoUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Equipos`
--
ALTER TABLE `Equipos`
  MODIFY `codigoEquipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `Grupos`
--
ALTER TABLE `Grupos`
  MODIFY `codigoGrupo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Juegos`
--
ALTER TABLE `Juegos`
  MODIFY `codigoJuego` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Liga`
--
ALTER TABLE `Liga`
  MODIFY `codigoLiga` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `LigaPrediccion`
--
ALTER TABLE `LigaPrediccion`
  MODIFY `codigoLigaPrediccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `LigaUsuario`
--
ALTER TABLE `LigaUsuario`
  MODIFY `codigoLigaUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Mundial`
--
ALTER TABLE `Mundial`
  MODIFY `codigoMundial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Prediccion`
--
ALTER TABLE `Prediccion`
  MODIFY `codigoPrediccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `codigoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Juegos`
--
ALTER TABLE `Juegos`
  ADD CONSTRAINT `FK_Primero` FOREIGN KEY (`primero`) REFERENCES `Equipos` (`codigoEquipo`),
  ADD CONSTRAINT `FK_Segundo` FOREIGN KEY (`segundo`) REFERENCES `Equipos` (`codigoEquipo`);

--
-- Constraints for table `Liga`
--
ALTER TABLE `Liga`
  ADD CONSTRAINT `FK_Administrador` FOREIGN KEY (`administrador`) REFERENCES `Usuarios` (`codigoUsuario`);

--
-- Constraints for table `LigaPrediccion`
--
ALTER TABLE `LigaPrediccion`
  ADD CONSTRAINT `FK_LigaPrediccionLiga` FOREIGN KEY (`codigoLiga`) REFERENCES `Liga` (`codigoLiga`),
  ADD CONSTRAINT `FK_LigaPrediccionPrediccion` FOREIGN KEY (`codigoPrediccion`) REFERENCES `Prediccion` (`codigoPrediccion`);

--
-- Constraints for table `LigaUsuario`
--
ALTER TABLE `LigaUsuario`
  ADD CONSTRAINT `FK_LigaUsuarioLiga` FOREIGN KEY (`codigoLiga`) REFERENCES `Liga` (`codigoLiga`),
  ADD CONSTRAINT `FK_LigaUsuarioUsuario` FOREIGN KEY (`codigoUsuario`) REFERENCES `Usuarios` (`codigoUsuario`);

--
-- Constraints for table `Prediccion`
--
ALTER TABLE `Prediccion`
  ADD CONSTRAINT `FK_PartidoPrediccion` FOREIGN KEY (`partido`) REFERENCES `Juegos` (`codigoJuego`),
  ADD CONSTRAINT `FK_PrediccionGanador` FOREIGN KEY (`prediccionGanador`) REFERENCES `Equipos` (`codigoEquipo`);
