package com.example.demo.dao;

import com.example.demo.dto.AccesoDTO;
import com.example.demo.model.Usuario;

import java.sql.SQLException;

public interface AccesoDAO {

    boolean acceso(AccesoDTO sesion) throws SQLException;


}
