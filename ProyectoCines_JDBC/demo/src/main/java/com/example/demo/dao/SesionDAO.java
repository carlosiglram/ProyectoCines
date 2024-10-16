package com.example.demo.dao;

import com.example.demo.model.Cine;
import com.example.demo.model.Sala;
import com.example.demo.model.Sesion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SesionDAO {
    List<Sesion> listarSesiones() throws SQLException;

    Sesion crearSesion(Sesion s) throws SQLException;

}
