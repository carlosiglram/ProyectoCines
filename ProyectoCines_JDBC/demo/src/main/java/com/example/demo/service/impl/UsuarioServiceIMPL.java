package com.example.demo.service.impl;

import com.example.demo.dao.CineDAO;
import com.example.demo.dao.UsuarioDAO;
import com.example.demo.dao.impl.JdbcCineDAO;
import com.example.demo.dao.impl.JdbcUsuarioDAO;
import com.example.demo.dto.CineDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.mapper.CineMapper;
import com.example.demo.mapper.UsuarioMapper;
import com.example.demo.model.Cine;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import java.sql.SQLException;

/**
 *
 */
public class UsuarioServiceIMPL implements UsuarioService {

    /**
     * @param usuario
     * @return
     * @throws SQLException
     */
    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws SQLException {
        UsuarioDAO uu = new JdbcUsuarioDAO();
        Usuario u = uu.crearUsuario(UsuarioMapper.conversionDTOaUsuario(usuario));
        return UsuarioMapper.convertirADTO(u);
    }

    /**
     * @param u
     * @throws SQLException
     */
    @Override
    public void actualizarClave(UsuarioDTO u) throws SQLException {
        UsuarioDAO dd = new JdbcUsuarioDAO();

        dd.actualizar(UsuarioMapper.conversionDTOaUsuario(u));
    }

}
