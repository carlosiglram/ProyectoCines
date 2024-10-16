package com.example.demo.dao;

import com.example.demo.dto.CineDTO;
import com.example.demo.model.Cine;

import java.sql.SQLException;
import java.util.List;

public interface CineDAO {
    List<Cine> listarCines() throws SQLException;

    Cine crearCine(Cine c) throws SQLException;


}
