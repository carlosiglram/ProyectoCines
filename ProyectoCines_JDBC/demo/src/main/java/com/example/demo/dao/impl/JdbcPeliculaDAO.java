package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.PeliculaDAO;
import com.example.demo.mapper.PeliculaMapper;
import com.example.demo.model.Pelicula;

import java.sql.*;
import java.util.List;

/**
 * Peliculas
 */
public class JdbcPeliculaDAO implements PeliculaDAO {
    private DBConnector connector = new HikariDBConnector();

    /**
     * @param cineID identificador de cine
     * @return lista peliculas de un cine
     * @throws SQLException
     */
    @Override
    public List<Pelicula> listarPeliculas(int cineID) throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try {
            s = c.prepareStatement("SELECT p.peliculaID, p.salaID, p.titulo, p.fechaInicio, p.fechaFin, p.genero, p.clasificacionEdad FROM Peliculas AS p JOIN Salas AS s ON p.salaID = s.salaID JOIN Cines AS c ON s.cineID = c.cineID WHERE c.cineID = ?");
            s.setInt(1, cineID);

            return PeliculaMapper.resALista(s.executeQuery());

        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }

    /**
     * @param pelicula nueva pelicula
     * @return nueva pelicula
     * @throws SQLException
     */
    @Override
    public Pelicula crearPeli(Pelicula pelicula) throws SQLException {

        Connection c = connector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("INSERT INTO Peliculas (salaID,titulo,fechaInicio,fechaFin,genero,clasificacionEdad) VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            s.setInt(1, pelicula.getSalaID());
            s.setString(2, pelicula.getTitulo());
            s.setDate(3, pelicula.getFechaInicio());
            s.setDate(4, pelicula.getFechaFin());
            s.setString(5, pelicula.getGenero());
            s.setInt(6, pelicula.getClasificacionEdad());

            s.executeUpdate();

            ResultSet id = s.getGeneratedKeys();

            if (id.next()) {
                pelicula.setPeliculaID(id.getInt(1));
            }
            return pelicula;

        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException();
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }
}
