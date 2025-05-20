-- Desactivamos autocommit y comenzamos una transacción
SET AUTOCOMMIT=0;
START TRANSACTION;

-- Eliminamos la base de datos si existe
DROP DATABASE IF EXISTS portal;

-- Creamos la base de datos
CREATE DATABASE IF NOT EXISTS portal;

-- Usamos la base de datos
USE portal;

-- Creamos las tablas

-- Tabla usuarios (1)
CREATE TABLE usuarios (
    ID_Usuario INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Correo VARCHAR(50) UNIQUE NOT NULL,
    Contrasena VARCHAR(20) NOT NULL
);

-- Tabla organizadores (2)
CREATE TABLE organizadores (
    ID_Organizador INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    TLF VARCHAR(9) NOT NULL,
    Correo VARCHAR(50) UNIQUE NOT NULL
);

-- Tabla categorías (3)
CREATE TABLE categorias (
    ID_Categoria INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL
);

-- Tabla ubicaciones (4)
CREATE TABLE ubicaciones (
    ID_Ubicacion INT PRIMARY KEY AUTO_INCREMENT,
    tipo ENUM('Presencial', 'Online', 'Semipresencial') NOT NULL,
    direccion VARCHAR(50)
);

-- Tabla eventos (5)
CREATE TABLE eventos (
    ID_Evento INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Fecha DATE NOT NULL,
    Lugar VARCHAR(30) NOT NULL,
    Duracion SMALLINT NOT NULL,
    ID_Organizador INT NOT NULL,
    ID_Ubicacion INT NOT NULL,
    ID_Categoria INT NOT NULL,

    -- Definimos las claves foráneas
    CONSTRAINT FK_Eventos_Ubicacion FOREIGN KEY (ID_Ubicacion) REFERENCES ubicaciones(ID_Ubicacion) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Eventos_Categoria FOREIGN KEY (ID_Categoria) REFERENCES categorias(ID_Categoria) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Eventos_Organizador FOREIGN KEY (ID_Organizador) REFERENCES organizadores(ID_Organizador) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tabla inscripciones (6)
CREATE TABLE inscripciones (
    ID_Usuario INT NOT NULL,
    ID_Evento INT NOT NULL,

    PRIMARY KEY (ID_Usuario, ID_Evento),

    CONSTRAINT FK_Inscripciones_Usuario FOREIGN KEY (ID_Usuario) REFERENCES usuarios(ID_Usuario) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Inscripciones_Evento FOREIGN KEY (ID_Evento) REFERENCES eventos(ID_Evento) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Finalizamos la transacción
COMMIT;
