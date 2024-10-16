package com.example.demo.service;

import com.example.demo.dto.CineDTO;
import com.example.demo.dto.PeliculaDTO;
import com.example.demo.dto.SesionDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Peliculas
 */
public interface PeliculaService {

    /**
     *
     * @param cineID
     * @return
     * @throws SQLException
     */
    List<PeliculaDTO> obtenerPeliculas(int cineID) throws SQLException;

    /**
     *
     * @param pelicula
     * @return
     * @throws SQLException
     */
    PeliculaDTO crearPeli(PeliculaDTO pelicula) throws SQLException;

}
