-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-02-2023 a las 00:09:38
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `navesespaciales`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crear_nave_espacial`
--

CREATE TABLE `crear_nave_espacial` (
  `id` int(11) NOT NULL,
  `capacidad_transporte` int(11) DEFAULT NULL,
  `combustible` varchar(255) DEFAULT NULL,
  `empuje` double NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo_nave` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `crear_nave_espacial`
--

INSERT INTO `crear_nave_espacial` (`id`, `capacidad_transporte`, `combustible`, `empuje`, `nombre`, `tipo_nave`) VALUES
(1, 3, 'gasolina', 2.6, 'saturno ', 3),
(2, 0, 'ACPM', 2.6, 'Energia', 1),
(3, 3, 'aceite', 320, 'Mercury', 3),
(4, 3, 'aceite', 320, 'Mercury', 3),
(5, 3, 'aceite', 320, 'Mercury', 3),
(6, 3, 'aceite', 320, 'Mercury', 3),
(7, 3, 'Sin combustible', 320, 'Mercury', 2),
(8, 0, 'Gas', 320, 'Mercury', 1),
(52, 0, 'ACPM', 5, 'delta', 1),
(53, 0, 'Sin combustible', 10, 'Mariner', 2),
(54, 0, 'Sin combustible', 20, 'soho', 2),
(55, 0, 'Sin combustible', 50, 'explorer', 2),
(56, 7, 'acpm', 50, 'Apolo', 3),
(57, 10, 'gasolina', 125, 'Dragon', 3),
(58, 3, 'aceite', 320, 'Mercury', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `crear_nave_espacial`
--
ALTER TABLE `crear_nave_espacial`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
