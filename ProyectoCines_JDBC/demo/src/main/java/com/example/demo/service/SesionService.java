package com.example.demo.service;

import com.example.demo.dto.CineDTO;
import com.example.demo.dto.SalaDTO;
import com.example.demo.dto.SesionDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Sesiones
 */
public interface SesionService {
    /**
     *
     * @return
     * @throws SQLException
     */
    List<SesionDTO> obtenerSesiones() throws SQLException;

    /**
     *
     * @param sesion
     * @return
     * @throws SQLException
     */
    SesionDTO crearSesion(SesionDTO sesion) throws SQLException;
}
