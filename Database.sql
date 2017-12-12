
--
-- Base de datos: `PI17`
--
CREATE DATABASE IF NOT EXISTS `PI17` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `PI17`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`villa`@`%` PROCEDURE `updateTicket` (IN `_No_Ticket` INT, `_Departamento` VARCHAR(20), `_Asunto` VARCHAR(30), `_Mensaje` VARCHAR(500), `_Contacto` VARCHAR(50))  BEGIN
	UPDATE PI17.Ticket set Departamento = _Departamento, Asunto = _Asunto, Mensaje = _Mensaje, Contacto = _Contacto WHERE No_Ticket = _No_Ticket;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Departamento`
--

CREATE TABLE `Departamento` (
  `Id_Departamento` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Departamento`
--

INSERT INTO `Departamento` (`Id_Departamento`, `Nombre`, `Descripcion`) VALUES
(1, 'Hardware', 'Departamento dedicado a problemas relacionados con los software de escritorio de la UCOL'),
(2, 'Redes', 'Departamento encargado de la red universitaria'),
(6, 'Programacion', 'Departamento para problemas de programacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Escuelas`
--

CREATE TABLE `Escuelas` (
  `Id_Escuela` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Escuelas`
--

INSERT INTO `Escuelas` (`Id_Escuela`, `Nombre`) VALUES
(29, 'BACHILLERATO # 18'),
(5, 'BACHILLERATO #1'),
(12, 'BACHILLERATO #16'),
(10, 'BACHILLERATO #2'),
(11, 'BACHILLERATO #3'),
(6, 'BACHILLERATO #4'),
(45, 'BACHILLERATO 20'),
(19, 'BACHILLERATO 22'),
(34, 'BACHILLERATO No 15'),
(43, 'BACHILLERATO No.29'),
(37, 'BACHILLERATO TEC NO.13'),
(16, 'BACHILLERATO TECNICO No. 30'),
(36, 'CENTRO UNIV. DE INVESTIGACIONES BIOMEDICAS'),
(27, 'CONALEP'),
(44, 'DIRECCION GENERAL DE RECURSOS HUMANOS'),
(38, 'DIRECCION GENERAL DE SERVICIOS BIBLIOTECARIOS'),
(24, 'ESCUELA DE LENGUAS EXTRANJERAS'),
(33, 'ESCUELA DE MERCADOTECNIA'),
(40, 'ESCUELA DE TURISMO'),
(23, 'FACULTAD DE ARQUITECTURA Y DISENO'),
(17, 'FACULTAD DE CIENCIAS'),
(20, 'FACULTAD DE CIENCIAS BIOLOGICAS Y AGROPECUARIAS'),
(22, 'FACULTAD DE CIENCIAS DE LA EDUCACION'),
(18, 'FACULTAD DE CIENCIAS POLITICAS Y SOCIALES'),
(9, 'FACULTAD DE CIENCIAS QUIMICAS'),
(7, 'FACULTAD DE CONTABILIDAD Y ADMINISTRACION'),
(25, 'FACULTAD DE DERECHO'),
(32, 'FACULTAD DE ECONOMIA'),
(3, 'FACULTAD DE ENFERMERIA'),
(35, 'FACULTAD DE INGENIERIA CIVIL'),
(15, 'FACULTAD DE INGENIERIA MECANICA Y ELECTRICA'),
(13, 'FACULTAD DE LETRAS Y COMUNICACION'),
(1, 'FACULTAD DE MEDICINA'),
(14, 'FACULTAD DE MEDICINA VETERINARIA Y ZOOTECNIA'),
(8, 'FACULTAD DE PEDAGOGIA'),
(2, 'FACULTAD DE PSICOLOGIA'),
(21, 'FACULTAD DE TELEMATICA'),
(4, 'FACULTAD DE TRABAJO SOCIAL'),
(30, 'INSTITUTO UNIV. DE BELLAS ARTES'),
(26, 'POSGRADO'),
(28, 'PROPEDEUTICO'),
(31, 'Trabajador de la UDC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Especialistas`
--

CREATE TABLE `Especialistas` (
  `No_Trabajador` int(11) NOT NULL,
  `Contraseña` varchar(80) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  `Departamento` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Especialistas`
--

INSERT INTO `Especialistas` (`No_Trabajador`, `Contraseña`, `Nombre`, `Correo`, `Departamento`) VALUES
(20000, 'c893bad68927b457dbed39460e6afd62', 'prueba', 'prueba@ucol.mx', 'Redes'),
(20124789, '827ccb0eea8a706c4c34a16891f84e7b', 'Santillan', 'santillan@ucol.mx', 'Hardware'),
(20158377, '2c351cf3ae59dddc026821c9be2f551a', 'Fidel Garcia Barajas', 'fgarcia14@ucol.mx', 'Programacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Ticket`
--

CREATE TABLE `Ticket` (
  `No_Ticket` int(11) NOT NULL,
  `Id_Usuario` int(11) NOT NULL,
  `Fecha` varchar(40) NOT NULL,
  `Departamento` varchar(20) DEFAULT NULL,
  `Asunto` varchar(100) NOT NULL,
  `Mensaje` varchar(500) NOT NULL,
  `Notas_Especialista` varchar(500) DEFAULT 'Sin notas',
  `Estado` varchar(100) DEFAULT 'Pendiente de revisión ',
  `Especialista` int(11) DEFAULT NULL,
  `Prioridad` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Ticket`
--

INSERT INTO `Ticket` (`No_Ticket`, `Id_Usuario`, `Fecha`, `Departamento`, `Asunto`, `Mensaje`, `Notas_Especialista`, `Estado`, `Especialista`, `Prioridad`) VALUES
(49, 20000, '2017-11-07', 'Redes', 'Fallo en conexión Wucol', 'Al momento de conectarme a la red Wucol, no me aparece el inicio de sesion', 'Se han detectado anomalias en su usuario y contraseña, favor de checar su correo proporcionado', 'Finalizado', 20000, 'Baja'),
(61, 20125018, '2017-11-11', 'Hardware', 'Error en inicio de sesión a moodle', 'Cada vez que entro a moodle, aparece que hay un error en la linea 5 de un archivo', 'Se ha detectado anomalias en tu usuario y contraseña, pedimos revisar su correo ', 'Resolviendo problematica', 20158377, 'Baja'),
(66, 20124789, '2017-11-16', 'Hardware', 'Mi computadora no enciende', 'Al momento de encender la computadora, hace 3 pitidos. ', 'Sin notas', 'Pendiente de revisión ', NULL, NULL),
(68, 20124448, 'Domingo-26-Noviembre-2017 Hora: 8:54:37', 'Redes', 'No tengo internet', 'Mi computadora no tiene internet. ', 'Sin notas', 'Pendiente de revisión ', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE `Usuarios` (
  `Id_Usuario` int(11) NOT NULL,
  `Contraseña` varchar(80) NOT NULL,
  `Nombre` varchar(35) NOT NULL,
  `Correo` varchar(40) NOT NULL,
  `Campus` varchar(15) NOT NULL,
  `Tipo_Usuario` varchar(10) NOT NULL,
  `Escuela` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Usuarios`
--

INSERT INTO `Usuarios` (`Id_Usuario`, `Contraseña`, `Nombre`, `Correo`, `Campus`, `Tipo_Usuario`, `Escuela`) VALUES
(1, 'c4ca4238a0b923820dcc509a6f75849b', '1', '1', 'Campus_Colima', '1', 'BACHILLERATO #2'),
(2, 'c81e728d9d4c2f636f067f89cc14862c', '2', '2', 'Campus_Colima', '2', 'BACHILLERATO #2'),
(3, 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '3', '3', 'Colima', 'Alumno', 'CONALEP'),
(20000, 'c893bad68927b457dbed39460e6afd62', 'prueba', 'prueba@ucol.mx', 'Colima', 'Trabajador', 'FACULTAD DE TELEMATICA'),
(2012000, '827ccb0eea8a706c4c34a16891f84e7b', 'Pedro', 'pedro@ucol.mx', 'Colima', 'Alumno', 'CONALEP'),
(20124448, '827ccb0eea8a706c4c34a16891f84e7b', 'Jose Luis', 'jvilla10@ucol.mx', 'Campus_Colima', 'Jose Luis', 'FACULTAD DE TELEMATICA'),
(20124789, '827ccb0eea8a706c4c34a16891f84e7b', 'Santillan', 'santillan@ucol.mx', 'Campus_Colima', 'Trabajador', 'FACULTAD DE TELEMATICA'),
(20125018, '1c7a92ae351d4e21ebdfb897508f59d6', 'Jesus Elmer', 'jpino@ucol.mx', 'Colima', 'Alumno', 'FACULTAD DE TELEMATICA'),
(20126597, '375f11857edccc7b9d3c583662bd99ff', 'Carlos Enrique', 'cmendez0@ucol.mx', 'Colima', 'Alumno', 'FACULTAD DE TELEMATICA'),
(20158377, '2c351cf3ae59dddc026821c9be2f551a', 'Fidel Garcia Barajas', 'fgarcia14@ucol.mx', 'Colima', 'Trabajador', 'FACULTAD DE TELEMATICA');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Departamento`
--
ALTER TABLE `Departamento`
  ADD PRIMARY KEY (`Id_Departamento`),
  ADD UNIQUE KEY `Nombre_2` (`Nombre`),
  ADD KEY `Nombre` (`Nombre`);

--
-- Indices de la tabla `Escuelas`
--
ALTER TABLE `Escuelas`
  ADD PRIMARY KEY (`Id_Escuela`),
  ADD UNIQUE KEY `Nombre_2` (`Nombre`),
  ADD KEY `No_Escuelas` (`Id_Escuela`),
  ADD KEY `Nombre` (`Nombre`);

--
-- Indices de la tabla `Especialistas`
--
ALTER TABLE `Especialistas`
  ADD PRIMARY KEY (`No_Trabajador`),
  ADD UNIQUE KEY `No_Trabajador` (`No_Trabajador`),
  ADD KEY `Departamento` (`Departamento`);

--
-- Indices de la tabla `Ticket`
--
ALTER TABLE `Ticket`
  ADD PRIMARY KEY (`No_Ticket`),
  ADD UNIQUE KEY `No_Ticket` (`No_Ticket`),
  ADD KEY `No_Ticket_2` (`No_Ticket`),
  ADD KEY `No_Ticket_3` (`No_Ticket`),
  ADD KEY `Departamento` (`Departamento`),
  ADD KEY `Id_Usuario` (`Id_Usuario`),
  ADD KEY `Especialista` (`Especialista`);

--
-- Indices de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`Id_Usuario`),
  ADD UNIQUE KEY `Id_Usuario` (`Id_Usuario`),
  ADD KEY `Tipo_Usuario` (`Tipo_Usuario`),
  ADD KEY `Escuela` (`Escuela`),
  ADD KEY `Escuela_2` (`Escuela`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Departamento`
--
ALTER TABLE `Departamento`
  MODIFY `Id_Departamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `Escuelas`
--
ALTER TABLE `Escuelas`
  MODIFY `Id_Escuela` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT de la tabla `Ticket`
--
ALTER TABLE `Ticket`
  MODIFY `No_Ticket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Especialistas`
--
ALTER TABLE `Especialistas`
  ADD CONSTRAINT `Especialistas_ibfk_3` FOREIGN KEY (`Departamento`) REFERENCES `Departamento` (`Nombre`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Especialistas_ibfk_4` FOREIGN KEY (`No_Trabajador`) REFERENCES `Usuarios` (`Id_Usuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `Ticket`
--
ALTER TABLE `Ticket`
  ADD CONSTRAINT `Ticket_ibfk_4` FOREIGN KEY (`Departamento`) REFERENCES `Departamento` (`Nombre`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Ticket_ibfk_6` FOREIGN KEY (`Id_Usuario`) REFERENCES `Usuarios` (`Id_Usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `Ticket_ibfk_7` FOREIGN KEY (`Especialista`) REFERENCES `Especialistas` (`No_Trabajador`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD CONSTRAINT `Usuarios_ibfk_1` FOREIGN KEY (`Escuela`) REFERENCES `Escuelas` (`Nombre`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
