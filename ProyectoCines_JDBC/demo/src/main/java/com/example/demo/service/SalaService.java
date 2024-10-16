package com.example.demo.service;

import com.example.demo.dto.CineDTO;
import com.example.demo.dto.SalaDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Salas
 */
public interface SalaService {

    /**
     *
     * @return
     * @throws SQLException
     */
    List<SalaDTO> obtenerSalas() throws SQLException;

    /**
     *
     * @param sala
     * @return
     * @throws SQLException
     */
    SalaDTO crearSala(SalaDTO sala) throws SQLException;

}