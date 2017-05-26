-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generaciÃ³n: 01-04-2017 a las 19:20:18
-- VersiÃ³n del servidor: 5.6.21
-- VersiÃ³n de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `Botzzaroni`
--

CREATE DATABASE IF NOT EXISTS botzzaroni;
USE botzzaroni;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bebida`
--

DROP TABLE IF EXISTS `bebida`;

CREATE TABLE IF NOT EXISTS `bebida` (
`id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `bebida`
--

INSERT INTO `bebida` (`id`, `nombre`, `precio`) VALUES
(1, 'fanta de naranja', 3),
(2, 'cocacola', 3),
(3, 'nestea', 3),
(4, 'fanta de limon', 3),
(5, 'cerveza', 3.5),
(8, 'aquarius', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;

CREATE TABLE IF NOT EXISTS `ingrediente` (
`id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ingrediente`
--

INSERT INTO `ingrediente` (`id`, `nombre`) VALUES
(1, 'bacon'),
(2, 'pollo'),
(3, 'ternera'),
(4, 'bacon crispy'),
(5, 'jamon serrano'),
(6, 'champinion'),
(7, 'topping a base de mozzarella'),
(8, 'queso cheddar'),
(9, 'queso emmental'),
(10, 'queso edam'),
(11, 'queso provolone'),
(12, 'queso azul'),
(13, 'york'),
(14, 'pinia'),
(15, 'tomate natural'),
(16, 'tomate confitado'),
(17, 'oregano'),
(18, 'cebolla'),
(19, 'kitkat'),
(20, 'crema de cacao y avellanas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE IF NOT EXISTS `pedido` (
`id` int(11) NOT NULL,
  `aliasUsuario` varchar(30) NOT NULL,
  `metodoPago` enum('tarjeta','efectivo','','') NOT NULL,
  `cambio` int(3) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizza`
--

DROP TABLE IF EXISTS `pizza`;

CREATE TABLE IF NOT EXISTS `pizza` (
`id` int(11) NOT NULL,
  `aliasUsuario` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pizza`
--

INSERT INTO `pizza` (`id`, `aliasUsuario`, `nombre`, `precio`) VALUES
(1, 'botzzaroni', 'prosciutto', 10),
(2, 'botzzaroni', 'calzzone', 10),
(3, 'botzzaroni', 'carbonara', 10),
(4, 'botzzaroni', 'hawaiana', 10),
(5, 'botzzaroni', 'barbacoa', 10),
(6, 'botzzaroni', 'bacon crispy', 10),
(7, 'botzzaroni', 'kitkat nocilla', 10),
(8, 'botzzaroni', 'delicheese', 10),
(9, 'botzzaroni', 'diabola', 10),
(10, 'botzzaroni', 'vegetal', 10),
(11, 'botzzaroni', 'bolognesa', 10),
(12, 'botzzaroni', 'serrana', 10),
(13, 'botzzaroni', 'cuatro quesos', 10),
(14, 'botzzaroni', 'especial', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salsa`
--

DROP TABLE IF EXISTS `salsa`;

CREATE TABLE IF NOT EXISTS `salsa` (
`id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `salsa`
--

INSERT INTO `salsa` (`id`, `nombre`) VALUES
(1, 'carbonara'),
(2, 'barbacoa'),
(3, 'diabola'),
(4, 'tomate'),
(5, 'especial de la casa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tieneAlergia`
--
DROP TABLE IF EXISTS `tieneAlergia`;

CREATE TABLE IF NOT EXISTS `tieneAlergia` (
  `idPedido` int(11) NOT NULL,
  `idIngrediente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tieneBebida`
--
DROP TABLE IF EXISTS `tieneBebida`;

CREATE TABLE IF NOT EXISTS `tieneBebida` (
  `idPedido` int(11) NOT NULL,
  `idBebida` int(11) NOT NULL,
  `tamanyo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tieneIngrediente`
--
DROP TABLE IF EXISTS `tieneIngrediente`;

CREATE TABLE IF NOT EXISTS `tieneIngrediente` (
  `idPizza` int(11) NOT NULL,
  `idIngrediente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tieneingrediente` (`idPizza`, `idIngrediente`) VALUES 
('1', '7'), ('1', '13'), ('1', '15'),
 ('2', '8'), ('2', '1'),
 ('3', '15'), ('3', '1'), ('3', '6'), ('3', '7'),
 ('4', '15'), ('4', '13'), ('4', '14'), ('4', '7'), ('4', '3'),
 ('5', '15'), ('5', '1'), ('5', '2'),  ('5', '7'), ('5', '3'),
 ('6', '15'), ('6', '1'), ('6', '4'), ('6', '7'), 
 ('7', '19'), ('7', '20'),
 ('8', '8'), ('8', '9'), ('8', '10'), ('8', '11'), ('8', '7'),('8', '15'),
 ('9', '7'), ('9', '3'), ('9', '18'), ('9', '15'),
 ('10', '7'), ('10', '15'), ('10', '18'),  ('10', '6'), 
 ('11', '7'), ('11', '7'), ('11', '3'),  ('11', '18'), 
 ('12', '7'), ('12', '15'), ('12', '5'),
 ('13', '15'),  ('13', '7'),  ('13', '10'),  ('13', '19'),  ('13', '12'),  ('13', '11'),    
 ('14', '15'),  ('14', '7'),  ('14', '3'),  ('14', '1'),  ('14', '11')
 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienePizza`
--
DROP TABLE IF EXISTS `tienePizza`;

CREATE TABLE IF NOT EXISTS `tienePizza` (
  `idPedido` int(11) NOT NULL,
  `idPizza` int(11) NOT NULL,
  `tamanyo` enum('familiar','mediana','pequenia','') NOT NULL,
  `masa` enum('normal','fina','queso','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tieneSalsa`
--
DROP TABLE IF EXISTS `tieneSalsa`;

CREATE TABLE IF NOT EXISTS `tieneSalsa` (
  `idPizza` int(11) NOT NULL,
  `idSalsa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tienesalsa` (`idPizza`, `idSalsa`) VALUES ('1', '5'), ('2', '5'), ('3', '5'), ('4', '5'), ('5', '5'), ('6', '5'), ('7', '5'), ('8', '5'), ('9', '5'), ('10', '5'), ('11', '5'), ('12', '5'), ('13', '5'), ('14', '5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE IF NOT EXISTS `usuario` (
  `alias` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `calle` varchar(50) NOT NULL,
  `numero` int(3) NOT NULL,
  `piso` int(2) NOT NULL,
  `puerta` varchar(10) NOT NULL,
  `codPostal` int(5) NOT NULL,
  `movil` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`alias`, `password`, `nombre`, `calle`, `numero`, `piso`, `puerta`, `codPostal`, `movil`) VALUES
('botzzaroni', 'botzzaroni', 'botzza', 'Prof. JosÃ© G! Santesmases', 1, 1, 'A', 28040, 666666666);

--
-- Ãndices para tablas volcadas
--

--
-- Indices de la tabla `bebida`
--
ALTER TABLE `bebida`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
 ADD PRIMARY KEY (`id`), ADD KEY `aliasUsuario` (`aliasUsuario`);

--
-- Indices de la tabla `pizza`
--
ALTER TABLE `pizza`
 ADD PRIMARY KEY (`id`), ADD KEY `idUsuario` (`aliasUsuario`), ADD KEY `idUsuario_2` (`aliasUsuario`);

--
-- Indices de la tabla `salsa`
--
ALTER TABLE `salsa`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tieneAlergia`
--
ALTER TABLE `tieneAlergia`
 ADD KEY `idPedido` (`idPedido`,`idIngrediente`);

--
-- Indices de la tabla `tieneBebida`
--
ALTER TABLE `tieneBebida`
 ADD KEY `idPedido` (`idPedido`,`idBebida`);

--
-- Indices de la tabla `tieneIngrediente`
--
ALTER TABLE `tieneIngrediente`
 ADD KEY `idPizza` (`idPizza`,`idIngrediente`);

--
-- Indices de la tabla `tienePizza`
--
ALTER TABLE `tienePizza`
 ADD KEY `idPedido` (`idPedido`,`idPizza`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`alias`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bebida`
--
ALTER TABLE `bebida`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pizza`
--
ALTER TABLE `pizza`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `salsa`
--
ALTER TABLE `salsa`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`aliasUsuario`) REFERENCES `usuario` (`alias`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pizza`
--
ALTER TABLE `pizza`
ADD CONSTRAINT `pizza_ibfk_1` FOREIGN KEY (`aliasUsuario`) REFERENCES `usuario` (`alias`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
