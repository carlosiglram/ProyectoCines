package com.example.demo;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.impl.HikariDBConnector;
import com.example.demo.dto.CineDTO;
import com.example.demo.controller.CineController;
import com.example.demo.service.CineService;
import com.example.demo.service.impl.CineServiceIMPL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Clase principal donde declarar métodos
 */
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DemoApplication.class, args);

        crearTablas();
        insertarDatos();
    }

    public static void crearTablas() throws SQLException {
        DBConnector connector = new HikariDBConnector();
        Connection c = connector.obtenerConexion();
        Statement s = null;

        try {
            s = c.createStatement();
            String sentenciaDDL = "CREATE TABLE Usuarios (\n" +
                    "    usuarioID INT PRIMARY KEY IDENTITY(1,1),\n" +
                    "    nombreUsuario NVARCHAR(50) NOT NULL,\n" +
                    "    email NVARCHAR(100) NOT NULL,\n" +
                    "    claveAcceso NVARCHAR(100) NOT NULL,\n" +
                    "    rol NVARCHAR(50) NOT NULL\n" +
                    ");" +
                    "CREATE TABLE Cines (\n" +
                    "    cineID INT PRIMARY KEY IDENTITY(1,1),\n" +
                    "    nombreCine NVARCHAR(100) NOT NULL,\n" +
                    "    direccion NVARCHAR(255) NOT NULL\n" +
                    ");" +
                    "CREATE TABLE Salas (\n" +
                    "    salaID INT PRIMARY KEY IDENTITY(1,1),\n" +
                    "    cineID INT FOREIGN KEY REFERENCES Cines(CineID),\n" +
                    "    nombreSala NVARCHAR(50) NOT NULL,\n" +
                    "    capacidad INT NOT NULL,\n" +
                    "    filas INT NOT NULL,\n" +
                    "    butacasPorFila INT NOT NULL\n" +
                    ");" +
                    "CREATE TABLE Peliculas (\n" +
                    "    peliculaID INT PRIMARY KEY IDENTITY(1,1),\n" +
                    "    salaID INT FOREIGN KEY REFERENCES Salas(SalaID),\n" +
                    "    titulo NVARCHAR(100) NOT NULL,\n" +
                    "    fechaInicio DATE NOT NULL,\n" +
                    "    fechaFin DATE NOT NULL,\n" +
                    "    genero NVARCHAR(50) NOT NULL,\n" +
                    "    clasificacionEdad INT NOT NULL\n" +
                    ");" +
                    "CREATE TABLE Sesiones (\n" +
                    "    sesionID INT PRIMARY KEY IDENTITY(1,1),\n" +
                    "    peliculaID INT FOREIGN KEY REFERENCES Peliculas(PeliculaID),\n" +
                    "    horaInicio DATETIME NOT NULL,\n" +
                    "    horaFin DATETIME NOT NULL\n" +
                    ");" +
                    "CREATE TABLE Reservas (\n" +
                    "    reservaID INT PRIMARY KEY IDENTITY(1,1),\n" +
                    "    usuarioID INT FOREIGN KEY REFERENCES Usuarios(UsuarioID),\n" +
                    "    sesionID INT FOREIGN KEY REFERENCES Sesiones(SesionID),\n" +
                    "    fila INT NOT NULL,\n" +
                    "    butaca INT NOT NULL,\n" +
                    "    estado NVARCHAR(50) NOT NULL,\n" +
                    "    fechaHoraRegistro DATETIME NOT NULL\n" +
                    ");";
            s.executeUpdate(sentenciaDDL);
            System.out.println("Tablas creadas");
        } catch (SQLException e) {
            System.out.println("ERROR: Tablas NO creadas");
            throw new RuntimeException(e);
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }

    public static void insertarDatos() throws SQLException {
        DBConnector connector = new HikariDBConnector();
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;

        try {
            s = c.prepareStatement("SET DATEFORMAT 'YMD';" +
                    "INSERT INTO Usuarios(nombreUsuario,email,claveAcceso,rol) VALUES\n" +
                    "('caco','caco.i@gmail.com','clave123','admin'),\n" +
                    "('manuel','manuel.c@gmail.com','clave321','user'),\n" +
                    "('dani','dani.v@gmail.com','clave987','user'),\n" +
                    "('simon','simon.s@gmail.com','clave789','user');\n" +
                    "INSERT INTO Cines(nombreCine,direccion) VALUES\n" +
                    "('Cantones Cines','Av. Porto da Coruña, 3'),\n" +
                    "('Cine Yelmo Rosales','Rda. de Outeiro, 419'),\n" +
                    "('Cinesa Marineda City','Av. de Arteixo, 43');\n" +
                    "INSERT INTO Salas(cineID,nombreSala,capacidad,filas,butacasPorFila) VALUES\n" +
                    "(1,'Sala 1',300,15,20),\n" +
                    "(1,'Sala 2',300,15,20),\n" +
                    "(2,'Sala 1',200,10,20),\n" +
                    "(2,'Sala 2',200,10,20),\n" +
                    "(3,'Sala Torre',500,20,25),\n" +
                    "(3,'Sala Millenium',350,14,25);\n" +
                    "INSERT INTO Peliculas(salaID,titulo,fechaInicio,fechaFin,genero,clasificacionEdad) VALUES\n" +
                    "(1,'Harry Potter y la Piedra Filosofal','2024-02-10','2024-04-10','Fantasía',7),\n" +
                    "(2,'El Señor de los Anillos: La Comunidad del Anillo','2024-02-12','2024-04-05','Fantasía',13),\n" +
                    "(3,'Piratas del Caribe: La Maldición de la Perla Negra','2024-02-15','2024-03-20','Aventuras',13),\n" +
                    "(4,'Kingsman: Servicio Secreto','2024-02-20','2024-03-20','Acción',16),\n" +
                    "(5,'The Martian','2024-03-10','2024-04-20','Ciencia-ficción',13),\n" +
                    "(6,'Cruella','2024-03-20','2024-04-30','Drama',12),\n" +
                    "(1,'Operación UNCLE','2024-03-30','2024-04-30','Acción',12),\n" +
                    "(2,'Titanic','2024-04-05','2024-06-01','Romántico',12),\n" +
                    "(3,'Harry Potter y la Cámara Secreta','2024-04-10','2024-06-05','Fantasía',7),\n" +
                    "(4,'El Señor de los Anillos: Las Dos Torres','2024-04-10','2024-06-05','Fantasía',13),\n" +
                    "(5,'Piratas del Caribe: El Cofre del Hombre Muerto','2024-04-20','2024-05-30','Aventuras',13),\n" +
                    "(6,'Kingsman: El Cícrulo Dorado','2024-04-30','2024-05-30','Acción',16);\n" +
                    "INSERT INTO Sesiones(peliculaID,horaInicio,horaFin) VALUES\n" +
                    "(1,'2024-02-10 18:00:00','2024-02-10 20:00:00'),\n" +
                    "(1,'2024-02-10 20:00:00','2024-02-10 22:00:00'),\n" +
                    "(1,'2024-02-11 16:00:00','2024-02-11 18:00:00'),\n" +
                    "(2,'2024-02-12 16:00:00','2024-02-12 18:00:00'),\n" +
                    "(2,'2024-02-13 17:00:00','2024-02-13 19:00:00'),\n" +
                    "(3,'2024-02-15 17:00:00','2024-02-15 19:00:00'),\n" +
                    "(4,'2024-02-20 18:00:00','2024-02-20 20:00:00'),\n" +
                    "(5,'2024-03-10 16:00:00','2024-03-10 18:00:00'),\n" +
                    "(6,'2024-03-20 17:00:00','2024-03-20 19:00:00'),\n" +
                    "(6,'2024-03-21 18:00:00','2024-03-21 20:00:00'),\n" +
                    "(7,'2024-03-30 16:00:00','2024-03-30 18:00:00'),\n" +
                    "(8,'2024-04-05 18:00:00','2024-04-05 20:00:00'),\n" +
                    "(9,'2024-04-10 17:00:00','2024-04-10 19:00:00'),\n" +
                    "(9,'2024-04-11 20:00:00','2024-04-11 22:00:00'),\n" +
                    "(10,'2024-04-12 16:00:00','2024-04-12 18:00:00'),\n" +
                    "(10,'2024-04-13 18:00:00','2024-04-13 20:00:00'),\n" +
                    "(11,'2024-04-20 19:00:00','2024-04-20 21:00:00'),\n" +
                    "(12,'2024-04-30 18:00:00','2024-04-30 20:00:00');");
            s.executeUpdate();
            System.out.println("Datos insertados");
        } catch (SQLException e) {
            System.out.println("ERROR: Datos NO insertados");
            throw new RuntimeException(e);
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }
}


