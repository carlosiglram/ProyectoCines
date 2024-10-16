package com.example.demo.dao;

import com.example.demo.dto.CineDTO;
import com.example.demo.dto.SalaDTO;
import com.example.demo.model.Cine;
import com.example.demo.model.Sala;

import java.sql.SQLException;
import java.util.List;

public interface SalaDAO {
    List<Sala> listarSalas() throws SQLException;

    Sala crearSala(Sala s) throws SQLException;


}
