package com.example.demo.service;

import com.example.demo.dto.CineDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Cines
 */
public interface CineService {

    /**
     *
     * @return
     * @throws SQLException
     */
    List<CineDTO> obtenerCines() throws SQLException;

    /**
     *
     * @param cine
     * @return
     * @throws SQLException
     */
    CineDTO crearCine(CineDTO cine) throws SQLException;

}
