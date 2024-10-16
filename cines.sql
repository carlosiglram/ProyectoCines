CREATE DATABASE Cines;

USE Cines;
SET DATEFORMAT 'YMD';

CREATE TABLE Usuarios (
    usuarioID INT PRIMARY KEY IDENTITY(1,1),
    nombreUsuario NVARCHAR(50) NOT NULL,
    email NVARCHAR(100) NOT NULL,
    claveAcceso NVARCHAR(100) NOT NULL,
    rol NVARCHAR(50) NOT NULL
);

INSERT INTO Usuarios(nombreUsuario,email,claveAcceso,rol) VALUES
('caco','caco.i@gmail.com','clave123','admin'),
('manuel','manuel.c@gmail.com','clave321','user'),
('dani','dani.v@gmail.com','clave987','user'),
('simon','simon.s@gmail.com','clave789','user');

CREATE TABLE Cines (
    cineID INT PRIMARY KEY IDENTITY(1,1),
    nombreCine NVARCHAR(100) NOT NULL,
    direccion NVARCHAR(255) NOT NULL
);

INSERT INTO Cines(nombreCine,direccion) VALUES
('Cantones Cines','Av. Porto da Coruña, 3'),
('Cine Yelmo Rosales','Rda. de Outeiro, 419'),
('Cinesa Marineda City','Av. de Arteixo, 43');

CREATE TABLE Salas (
    salaID INT PRIMARY KEY IDENTITY(1,1),
    cineID INT FOREIGN KEY REFERENCES Cines(CineID),
    nombreSala NVARCHAR(50) NOT NULL,
    capacidad INT NOT NULL,
    filas INT NOT NULL,
    butacasPorFila INT NOT NULL
);

INSERT INTO Salas(cineID,nombreSala,capacidad,filas,butacasPorFila) VALUES
(1,'Sala 1',300,15,20),
(1,'Sala 2',300,15,20),
(2,'Sala 1',200,10,20),
(2,'Sala 2',200,10,20),
(3,'Sala Torre',500,20,25),
(3,'Sala Millenium',350,14,25);

CREATE TABLE Peliculas (
    peliculaID INT PRIMARY KEY IDENTITY(1,1),
    salaID INT FOREIGN KEY REFERENCES Salas(SalaID),
    titulo NVARCHAR(100) NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    genero NVARCHAR(50) NOT NULL,
    clasificacionEdad INT NOT NULL
);

INSERT INTO Peliculas(salaID,titulo,fechaInicio,fechaFin,genero,clasificacionEdad) VALUES
(1,'Harry Potter y la Piedra Filosofal','2024-02-10','2024-04-10','Fantasía','+7'),
(2,'El Señor de los Anillos: La Comunidad del Anillo','2024-02-12','2024-04-05','Fantasía','+13'),
(3,'Piratas del Caribe: La Maldición de la Perla Negra','2024-02-15','2024-03-20','Aventuras','+13'),
(4,'Kingsman: Servicio Secreto','2024-02-20','2024-03-20','Acción','+16'),
(5,'The Martian','2024-03-10','2024-04-20','Ciencia-ficción','+13'),
(6,'Cruella','2024-03-20','2024-04-30','Drama','+12'),
(1,'Operación UNCLE','2024-03-30','2024-04-30','Acción','+12'),
(2,'Titanic','2024-04-05','2024-06-01','Romántico','+12'),
(3,'Harry Potter y la Cámara Secreta','2024-04-10','2024-06-05','Fantasía','+7'),
(4,'El Señor de los Anillos: Las Dos Torres','2024-04-10','2024-06-05','Fantasía','+13'),
(5,'Piratas del Caribe: El Cofre del Hombre Muerto','2024-04-20','2024-05-30','Aventuras','+13'),
(6,'Kingsman: El Cícrulo Dorado','2024-04-30','2024-05-30','Acción','+16');

CREATE TABLE Sesiones (
    sesionID INT PRIMARY KEY IDENTITY(1,1),
    peliculaID INT FOREIGN KEY REFERENCES Peliculas(PeliculaID),
    horaInicio DATETIME NOT NULL,
    horaFin DATETIME NOT NULL
);

INSERT INTO Sesiones(peliculaID,horaInicio,horaFin) VALUES
(1,'2024-02-10 18:00:00','2024-02-10 20:00:00'),
(1,'2024-02-10 20:00:00','2024-02-10 22:00:00'),
(1,'2024-02-11 16:00:00','2024-02-11 18:00:00'),
(2,'2024-02-12 16:00:00','2024-02-12 18:00:00'),
(2,'2024-02-13 17:00:00','2024-02-13 19:00:00'),
(3,'2024-02-15 17:00:00','2024-02-15 19:00:00'),
(4,'2024-02-20 18:00:00','2024-02-20 20:00:00'),
(5,'2024-03-10 16:00:00','2024-03-10 18:00:00'),
(6,'2024-03-20 17:00:00','2024-03-20 19:00:00'),
(6,'2024-03-21 18:00:00','2024-03-21 20:00:00'),
(7,'2024-03-30 16:00:00','2024-03-30 18:00:00'),
(8,'2024-04-05 18:00:00','2024-04-05 20:00:00'),
(9,'2024-04-10 17:00:00','2024-04-10 19:00:00'),
(9,'2024-04-11 20:00:00','2024-04-11 22:00:00'),
(10,'2024-04-12 16:00:00','2024-04-12 18:00:00'),
(10,'2024-04-13 18:00:00','2024-04-13 20:00:00'),
(11,'2024-04-20 19:00:00','2024-04-20 21:00:00'),
(12,'2024-04-30 18:00:00','2024-04-30 20:00:00');

CREATE TABLE Reservas (
    reservaID INT PRIMARY KEY IDENTITY(1,1),
    usuarioID INT FOREIGN KEY REFERENCES Usuarios(UsuarioID),
    sesionID INT FOREIGN KEY REFERENCES Sesiones(SesionID),
    fila INT NOT NULL,
    butaca INT NOT NULL,
    estado NVARCHAR(50) NOT NULL,
    fechaHoraRegistro DATETIME NOT NULL
);