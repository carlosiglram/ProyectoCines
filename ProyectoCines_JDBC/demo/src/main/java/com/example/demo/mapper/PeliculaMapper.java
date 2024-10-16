package com.example.demo.mapper;

import com.example.demo.dao.PeliculaDAO;
import com.example.demo.dao.impl.JdbcPeliculaDAO;
import com.example.demo.dto.PeliculaDTO;
import com.example.demo.model.Pelicula;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Peliculas
 */
public class PeliculaMapper {

    /**
     * @param p
     * @return
     * @throws SQLException
     */
    public static Pelicula conversionDTOaPelicula(PeliculaDTO p) throws SQLException {
        return new Pelicula(p.getPeliculaID(), p.getSalaID(), p.getTitulo(), p.getFechaInicio(), p.getFechaFin(), p.getGenero(), p.getClasificacionEdad());
    }

    /**
     * @param pelicula
     * @return
     * @throws SQLException
     */
    public static PeliculaDTO convertirPeliADTO(Pelicula pelicula) throws SQLException {
        return new PeliculaDTO(pelicula.getPeliculaID(), pelicula.getSalaID(), pelicula.getTitulo(), pelicula.getFechaInicio(), pelicula.getFechaFin(), pelicula.getGenero(), pelicula.getClasificacionEdad());
    }

    /**
     * @param peliculas
     * @return
     * @throws SQLException
     */
    public static List<PeliculaDTO> convertirLista(List<Pelicula> peliculas) throws SQLException {

        List<PeliculaDTO> listaDTO = new ArrayList<PeliculaDTO>();

        for (Pelicula pelicula : peliculas) {
            listaDTO.add(convertirPeliADTO(pelicula));
        }
        return listaDTO;
    }

    /**
     * @param res
     * @return
     * @throws SQLException
     */
    public static List<Pelicula> resALista(ResultSet res) throws SQLException {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        while (res.next()) {
            peliculas.add(new Pelicula(res.getInt("peliculaID"), res.getInt("salaID"), res.getString("titulo"), res.getDate("fechaInicio"), res.getDate("fechaFin"), res.getString("genero"), res.getInt("clasificacionEdad")));
        }
        return peliculas;
    }
}
