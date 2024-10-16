package com.example.demo.mapper;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.dao.impl.JdbcUsuarioDAO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Usuarios
 */
public class UsuarioMapper {

    /**
     * @param u
     * @return
     * @throws SQLException
     */
    public static Usuario conversionDTOaUsuario(UsuarioDTO u) throws SQLException {
        Usuario usuario = new Usuario(u.getUsuarioID(), u.getNombreUsuario(), u.getEmail(), u.getClaveAcceso(), u.getRol());
        return usuario;
    }

    /**
     * @param usuario
     * @return
     * @throws SQLException
     */
    public static UsuarioDTO convertirADTO(Usuario usuario) throws SQLException {
        UsuarioDAO uu = new JdbcUsuarioDAO();

        return new UsuarioDTO(usuario.getUsuarioID(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getClaveAcceso(), usuario.getRol());
    }

}
