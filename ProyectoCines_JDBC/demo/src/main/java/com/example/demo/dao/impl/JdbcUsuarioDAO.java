package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Usuario;

import java.sql.*;

/**
 * Usuarios
 */
public class JdbcUsuarioDAO implements UsuarioDAO {
    private DBConnector connector = new HikariDBConnector();

    /**
     * @param usuario nuevo usuario
     * @return nuevo usuario
     * @throws SQLException
     */
    @Override
    public Usuario crearUsuario(Usuario usuario) throws SQLException {

        Connection c = connector.obtenerConexion();

        PreparedStatement s = null;

        try {
            s = c.prepareStatement("INSERT INTO Usuarios (nombreUsuario, email, claveAcceso, rol) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            s.setString(1, usuario.getNombreUsuario());
            s.setString(2, usuario.getEmail());
            s.setString(3, usuario.getClaveAcceso());
            s.setString(4, usuario.getRol());

            s.executeUpdate();

            ResultSet id = s.getGeneratedKeys();

            if (id.next()) {
                usuario.setUsuarioID(id.getInt(1));
            }
            return usuario;


        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException();
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }

    /**
     * @param u usuario actualizado
     * @return usuario actualizado
     * @throws SQLException
     */
    @Override
    public Usuario actualizar(Usuario u) throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;

        try {
            s = c.prepareStatement("UPDATE Usuarios SET claveAcceso = ? WHERE UsuarioID = ?;");
            s.setString(1, u.getClaveAcceso());
            s.setInt(2, u.getUsuarioID());
            s.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("consulta ko");
            throw new RuntimeException();
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
        return u;
    }

}
