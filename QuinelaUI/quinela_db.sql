-- phpMyAdmin SQL Dump
-- version 4.7.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Aug 20, 2018 at 08:46 AM
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
(16, 'URY', 'Uruguay', NULL, '1018'),
(17, 'AFG', 'Afghanistan', NULL, '1000'),
(18, 'ALB', 'Albania', NULL, '1000'),
(19, 'ALG', 'Algeria', NULL, '1000'),
(20, 'ASA', 'American Samoa', NULL, '1000'),
(21, 'AND', 'Andorra', NULL, '1000'),
(22, 'ANG', 'Angola', NULL, '1000'),
(23, 'AIA', 'Anguilla', NULL, '1000'),
(24, 'ATG', 'Antigua and Barbuda', NULL, '1000'),
(25, 'ARM', 'Armenia', NULL, '1000'),
(26, 'ARU', 'Aruba', NULL, '1000'),
(27, 'AUS', 'Australia', NULL, '1000'),
(28, 'AUT', 'Austria', NULL, '1000'),
(29, 'AZE', 'Azerbaijan', NULL, '1000'),
(30, 'BAH', 'Bahamas', NULL, '1000'),
(31, 'BHR', 'Bahrain', NULL, '1000'),
(32, 'BAN', 'Bangladesh', NULL, '1000'),
(33, 'BRB', 'Barbados', NULL, '1000'),
(34, 'BLR', 'Belarus', NULL, '1000'),
(35, 'BEL', 'Belgium', NULL, '1000'),
(36, 'BLZ', 'Belize', NULL, '1000'),
(37, 'BEN', 'Benin', NULL, '1000'),
(38, 'BER', 'Bermuda', NULL, '1000'),
(39, 'BHU', 'Bhutan', NULL, '1000'),
(40, 'BOL', 'Bolivia', NULL, '1000'),
(41, 'BIH', 'Bosnia and Herzegovi', NULL, '1000'),
(42, 'BOT', 'Botswana', NULL, '1000'),
(43, 'BRU', 'Brunei', NULL, '1000'),
(44, 'BUL', 'Bulgaria', NULL, '1000'),
(45, 'BFA', 'Burkina Faso', NULL, '1000'),
(46, 'BDI', 'Burundi', NULL, '1000'),
(47, 'CAM', 'Cambodia', NULL, '1000'),
(48, 'CMR', 'Cameroon', NULL, '1000'),
(49, 'CAN', 'Canada', NULL, '1000'),
(50, 'CPV', 'Cape Verde', NULL, '1000'),
(51, 'CAY', 'Cayman Islands', NULL, '1000'),
(52, 'CTA', 'Central African Repu', NULL, '1000'),
(53, 'CHA', 'Chad', NULL, '1000'),
(54, 'CHN', 'China', NULL, '1000'),
(55, 'COL', 'Colombia', NULL, '1000'),
(56, 'COM', 'Comoros', NULL, '1000'),
(57, 'CGO', 'Congo', NULL, '1000'),
(58, 'CRO', 'Croatia', NULL, '1000'),
(59, 'CUB', 'Cuba', NULL, '1000'),
(60, 'CUW', 'Curaçao', NULL, '1000');

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
(5, 2018, 'Grupo #4', 'Mexico', 'Argentina', 'Chile', 'Spain'),
(6, 2018, 'Grupo #5', 'Afghanistan', 'Albania', 'Algeria', 'American Samoa'),
(7, 2018, 'Grupo #6', 'Andorra', 'Angola', 'Anguilla', 'Antigua and Barbuda'),
(8, 2018, 'Grupo #7', 'Armenia', 'Aruba', 'Australia', 'Austria'),
(14, 2018, 'Grupo #8', 'Azerbaijan', 'Bahamas', 'Bahrain', 'Bangladesh');

-- --------------------------------------------------------

--
-- Table structure for table `Juegos`
--

CREATE TABLE `Juegos` (
  `codigoJuego` int(11) NOT NULL,
  `codigoMundial` int(11) NOT NULL,
  `primero` varchar(20) NOT NULL,
  `segundo` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `ganador` varchar(20) DEFAULT NULL,
  `marcador` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Juegos`
--

INSERT INTO `Juegos` (`codigoJuego`, `codigoMundial`, `primero`, `segundo`, `fecha`, `ganador`, `marcador`) VALUES
(1, 2018, 'Alemania', 'Costa Rica', '2018-08-23', NULL, NULL),
(2, 2018, 'Alemania', 'Brasil', '2018-08-26', NULL, NULL),
(3, 2018, 'Alemania', 'Bélgica', '2018-08-29', NULL, NULL),
(4, 2018, 'Costa Rica', 'Brasil', '2018-09-01', NULL, NULL),
(5, 2018, 'Costa Rica', 'Bélgica', '2018-09-04', NULL, NULL),
(6, 2018, 'Brasil', 'Bélgica', '2018-09-07', NULL, NULL),
(7, 2018, 'Denmark', 'Uruguay', '2018-09-10', NULL, NULL),
(8, 2018, 'Denmark', 'USA', '2018-09-13', NULL, NULL),
(9, 2018, 'Denmark', 'Jamaica', '2018-09-16', NULL, NULL),
(10, 2018, 'Uruguay', 'USA', '2018-09-19', NULL, NULL),
(11, 2018, 'Uruguay', 'Jamaica', '2018-09-22', NULL, NULL),
(12, 2018, 'USA', 'Jamaica', '2018-09-25', NULL, NULL),
(13, 2018, 'France', 'Peru', '2018-09-28', NULL, NULL),
(14, 2018, 'France', 'Switzerland', '2018-10-01', NULL, NULL),
(15, 2018, 'France', 'Poland', '2018-10-04', NULL, NULL),
(16, 2018, 'Peru', 'Switzerland', '2018-10-07', NULL, NULL),
(17, 2018, 'Peru', 'Poland', '2018-10-10', NULL, NULL),
(18, 2018, 'Switzerland', 'Poland', '2018-10-13', NULL, NULL),
(19, 2018, 'Mexico', 'Argentina', '2018-10-16', NULL, NULL),
(20, 2018, 'Mexico', 'Chile', '2018-10-19', NULL, NULL),
(21, 2018, 'Mexico', 'Spain', '2018-10-22', NULL, NULL),
(22, 2018, 'Argentina', 'Chile', '2018-10-25', NULL, NULL),
(23, 2018, 'Argentina', 'Spain', '2018-10-28', NULL, NULL),
(24, 2018, 'Chile', 'Spain', '2018-10-31', NULL, NULL),
(25, 2018, 'Afghanistan', 'Albania', '2018-11-03', NULL, NULL),
(26, 2018, 'Afghanistan', 'Algeria', '2018-11-06', NULL, NULL),
(27, 2018, 'Afghanistan', 'American Samoa', '2018-11-09', NULL, NULL),
(28, 2018, 'Albania', 'Algeria', '2018-11-12', NULL, NULL),
(29, 2018, 'Albania', 'American Samoa', '2018-11-15', NULL, NULL),
(30, 2018, 'Algeria', 'American Samoa', '2018-11-18', NULL, NULL),
(31, 2018, 'Andorra', 'Angola', '2018-11-21', NULL, NULL),
(32, 2018, 'Andorra', 'Anguilla', '2018-11-24', NULL, NULL),
(33, 2018, 'Andorra', 'Antigua and Barbuda', '2018-11-27', NULL, NULL),
(34, 2018, 'Angola', 'Anguilla', '2018-11-30', NULL, NULL),
(35, 2018, 'Angola', 'Antigua and Barbuda', '2018-12-03', NULL, NULL),
(36, 2018, 'Anguilla', 'Antigua and Barbuda', '2018-12-06', NULL, NULL),
(37, 2018, 'Armenia', 'Aruba', '2018-12-09', NULL, NULL),
(38, 2018, 'Armenia', 'Australia', '2018-12-12', NULL, NULL),
(39, 2018, 'Armenia', 'Austria', '2018-12-15', NULL, NULL),
(40, 2018, 'Aruba', 'Australia', '2018-12-18', NULL, NULL),
(41, 2018, 'Aruba', 'Austria', '2018-12-21', NULL, NULL),
(42, 2018, 'Australia', 'Austria', '2018-12-24', NULL, NULL),
(43, 2018, 'Azerbaijan', 'Bahamas', '2018-12-27', NULL, NULL),
(44, 2018, 'Azerbaijan', 'Bahrain', '2018-12-30', NULL, NULL),
(45, 2018, 'Azerbaijan', 'Bangladesh', '2019-01-02', NULL, NULL),
(46, 2018, 'Bahamas', 'Bahrain', '2019-01-05', NULL, NULL),
(47, 2018, 'Bahamas', 'Bangladesh', '2019-01-08', NULL, NULL),
(48, 2018, 'Bahrain', 'Bangladesh', '2019-01-11', NULL, NULL);

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
  ADD PRIMARY KEY (`codigoJuego`);

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
  MODIFY `codigoEquipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
--
-- AUTO_INCREMENT for table `Grupos`
--
ALTER TABLE `Grupos`
  MODIFY `codigoGrupo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `Juegos`
--
ALTER TABLE `Juegos`
  MODIFY `codigoJuego` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
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
-- AUTO_INCREMENT for table `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `codigoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

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
