package com.example.demo.service.impl;

import com.example.demo.dao.PeliculaDAO;
import com.example.demo.dao.impl.JdbcPeliculaDAO;
import com.example.demo.dto.PeliculaDTO;
import com.example.demo.mapper.PeliculaMapper;
import com.example.demo.model.Pelicula;
import com.example.demo.service.PeliculaService;

import java.sql.SQLException;
import java.util.List;

/**
 * Peliculas
 */
public class PeliculaServiceIMPL implements PeliculaService {

    /**
     * @param cineID
     * @return
     * @throws SQLException
     */
    @Override
    public List<PeliculaDTO> obtenerPeliculas(int cineID) throws SQLException {
        PeliculaDAO pp = new JdbcPeliculaDAO();
        List<Pelicula> peliculas = pp.listarPeliculas(cineID);
        return PeliculaMapper.convertirLista(peliculas);
    }

    /**
     * @param pelicula
     * @return
     * @throws SQLException
     */
    @Override
    public PeliculaDTO crearPeli(PeliculaDTO pelicula) throws SQLException {
        PeliculaDAO pp = new JdbcPeliculaDAO();
        Pelicula insertar = PeliculaMapper.conversionDTOaPelicula(pelicula);
        Pelicula p = pp.crearPeli(insertar);
        return PeliculaMapper.convertirPeliADTO(p);
    }
}
