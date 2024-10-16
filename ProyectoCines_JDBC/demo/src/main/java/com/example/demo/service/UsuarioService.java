package com.example.demo.service;

import com.example.demo.dto.CineDTO;
import com.example.demo.dto.UsuarioDTO;

import java.sql.SQLException;

/**
 * Usuarios
 */
public interface UsuarioService {

    /**
     *
     * @param usuario
     * @return
     * @throws SQLException
     */
    UsuarioDTO crearUsuario(UsuarioDTO usuario) throws SQLException;

    /**
     *
     * @param usuarioDTO
     * @throws SQLException
     */
    void actualizarClave(UsuarioDTO usuarioDTO) throws SQLException;
}
