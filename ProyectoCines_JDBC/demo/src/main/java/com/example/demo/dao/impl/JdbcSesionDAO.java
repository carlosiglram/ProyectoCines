package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.SesionDAO;
import com.example.demo.mapper.SesionMapper;
import com.example.demo.model.Sala;
import com.example.demo.model.Sesion;

import java.sql.Timestamp;

import java.sql.*;
import java.util.List;
import java.sql.*;

/**
 * Sesiones
 */
public class JdbcSesionDAO implements SesionDAO {
    private DBConnector connector = new HikariDBConnector();

    /**
     * @return lista de sesiones
     * @throws SQLException
     */
    public List<Sesion> listarSesiones() throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try {
            s = c.prepareStatement("SELECT * FROM Sesiones");

            return SesionMapper.resALista(s.executeQuery());

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
     * @param sesion nueva sesion
     * @return nueva sesion
     * @throws SQLException
     */
    @Override
    public Sesion crearSesion(Sesion sesion) throws SQLException {

        Connection c = connector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("INSERT INTO Sesiones (peliculaID,horaInicio,horaFin) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            s.setInt(1, sesion.getPeliculaID());
            s.setTimestamp(2, sesion.getHoraInicio());
            s.setTimestamp(3, sesion.getHoraFin());
            s.executeUpdate();

            ResultSet id = s.getGeneratedKeys();

            if (id.next()) {
                sesion.setSesionID(id.getInt(1));
            }
            return sesion;

        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException();
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }
}
