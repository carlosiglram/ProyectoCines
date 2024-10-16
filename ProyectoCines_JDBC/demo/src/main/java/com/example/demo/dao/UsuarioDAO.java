package com.example.demo.dao;

import com.example.demo.model.Usuario;

import java.sql.SQLException;

public interface UsuarioDAO {

    Usuario crearUsuario(Usuario u) throws SQLException;

    Usuario actualizar(Usuario u) throws SQLException;
}
