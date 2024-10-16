package com.example.demo.dao.impl;

import com.example.demo.dao.CineDAO;
import com.example.demo.dao.DBConnector;
import com.example.demo.model.Cine;
import com.example.demo.mapper.CineMapper;

import java.sql.*;
import java.util.List;

/**
 * Cines
 */
public class JdbcCineDAO implements CineDAO {

    private DBConnector connector = new HikariDBConnector();

    /**
     * @return lista de cines
     * @throws SQLException
     */
    @Override
    public List<Cine> listarCines() throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try {
            s = c.prepareStatement("SELECT * FROM Cines");

            return CineMapper.resALista(s.executeQuery());

        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        } finally {
            if (s != null) s.close();
            ;
            if (c != null) c.close();
        }
    }

    /**
     * @param cine nuevo cine
     * @return nuevo cine
     * @throws SQLException
     */
    @Override
    public Cine crearCine(Cine cine) throws SQLException {

        Connection c = connector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("INSERT INTO Cines (nombreCine,direccion) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            s.setString(1, cine.getNombreCine());
            s.setString(2, cine.getDireccion());

            s.executeUpdate();

            ResultSet id = s.getGeneratedKeys();

            if (id.next()) {
                cine.setCineID(id.getInt(1));
            }
            return cine;


        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException();
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }
}
