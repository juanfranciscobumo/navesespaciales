-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-02-2023 a las 23:46:43
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
  `empuje` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo_nave` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `crear_nave_espacial`
--

INSERT INTO `crear_nave_espacial` (`id`, `capacidad_transporte`, `combustible`, `empuje`, `nombre`, `tipo_nave`) VALUES
(25, 7, 'petroleo', 145, 'Apolo IX', 3),
(26, 5, 'ACPM', 200, 'Mercury V', 3),
(27, 5, 'Sin combustible', 740, 'Apolo', 2),
(28, 0, 'Gasolina', 200, 'Mercury IX', 1),
(29, 0, 'Sin combustible', 200, 'Sofka 7', 2),
(30, 7, 'Sin combustible', 200, 'Sofka IX', 2),
(31, 0, 'Nitrogeno', 200, 'Sofka IX', 1),
(32, 0, 'Hidrogeno', 200, 'Sofka IX', 1),
(33, 9, 'Hidrogeno', 200, 'Karen V', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(34);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodenave`
--

CREATE TABLE `tipodenave` (
  `id` int(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipodenave`
--

INSERT INTO `tipodenave` (`id`, `descripcion`) VALUES
(1, 'Naves lanzadera'),
(2, 'Naves no tripuladas o roboticas'),
(3, 'Naves tripuladas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodenave_seq`
--

CREATE TABLE `tipodenave_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipodenave_seq`
--

INSERT INTO `tipodenave_seq` (`next_val`) VALUES
(1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `crear_nave_espacial`
--
ALTER TABLE `crear_nave_espacial`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipodenave`
--
ALTER TABLE `tipodenave`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tipodenave`
--
ALTER TABLE `tipodenave`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
