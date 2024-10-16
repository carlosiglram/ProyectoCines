package com.example.demo.dao.impl;

import com.example.demo.dao.AccesoDAO;
import com.example.demo.dao.DBConnector;
import com.example.demo.dto.AccesoDTO;
import com.example.demo.model.Usuario;

import java.sql.*;

/**
 * Inicios de sesión
 */
public class JdbcAccesoDAO implements AccesoDAO {

    private DBConnector connector = new HikariDBConnector();

    /**
     * @param sesion
     * @return inicio de sesion
     * @throws SQLException
     */
    @Override
    public boolean acceso(AccesoDTO sesion) throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try {
            s = c.prepareStatement("SELECT * FROM Usuarios WHERE nombreUsuario LIKE ? AND claveAcceso LIKE ?");

            s.setString(1, sesion.getNombreUsuario());
            s.setString(2, sesion.getClaveAcceso());
            ResultSet res = s.executeQuery();

            return res.next();

        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException();
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }
}
