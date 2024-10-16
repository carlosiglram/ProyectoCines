package com.example.demo.controller;

import com.example.demo.dao.AccesoDAO;
import com.example.demo.dao.impl.JdbcAccesoDAO;
import com.example.demo.dto.*;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.impl.UsuarioServiceIMPL;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Clase de gestión de usuarios
 */
@RestController
public class UsuarioController {

    /**
     * @param usuario nuevo usuario
     * @return crear nuevo usuario
     * @throws SQLException
     */
    @PostMapping("/api/usuarios")
    UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuario) throws SQLException {
        UsuarioService us = new UsuarioServiceIMPL();
        return us.crearUsuario(usuario);
    }

    /**
     * @param sesion datos de inicio de sesion
     * @return mensaje true/false según se ha iniciado sesión o no
     * @throws SQLException
     */
    @PostMapping("/api/iniciar-sesion")
    boolean iniciarSesion(@RequestBody AccesoDTO sesion) throws SQLException {
        AccesoDAO accesoDatos = new JdbcAccesoDAO();
        return accesoDatos.acceso(sesion);
    }

    /**
     * @param nuevaClaveAcceso nueva contraseña
     * @param usuarioID        identificador de usuario
     * @throws SQLException
     */
    @PutMapping("/api/usuarios/{usuarioID}/cambiar-contrasena")
    void cambiarPassword(@RequestBody String nuevaClaveAcceso, @PathVariable int usuarioID) throws SQLException {
        UsuarioService us = new UsuarioServiceIMPL();
        us.actualizarClave(new UsuarioDTO(nuevaClaveAcceso, usuarioID));
    }

}
