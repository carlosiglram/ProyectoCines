package com.example.demo.mapper;

import com.example.demo.dao.CineDAO;
import com.example.demo.dto.CineDTO;
import com.example.demo.model.Cine;
import com.example.demo.dao.impl.JdbcCineDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cines
 */
public class CineMapper {

    /**
     * @param c
     * @return
     * @throws SQLException
     */
    public static Cine conversionDTOaCine(CineDTO c) throws SQLException {
        Cine cine = new Cine(c.getCineID(), c.getNombreCine(), c.getDireccion());
        return cine;
    }

    /**
     * @param cine
     * @return
     * @throws SQLException
     */
    public static CineDTO convertirADTO(Cine cine) throws SQLException {
        CineDAO cc = new JdbcCineDAO();

        return new CineDTO(cine.getCineID(), cine.getNombreCine(), cine.getDireccion());
    }

    /**
     * @param cines
     * @return
     * @throws SQLException
     */
    public static List<CineDTO> convertirLista(List<Cine> cines) throws SQLException {

        List<CineDTO> listaDTO = new ArrayList<CineDTO>();

        for (Cine cine : cines) {
            listaDTO.add(convertirADTO(cine));
        }
        return listaDTO;
    }

    /**
     * @param res
     * @return
     * @throws SQLException
     */
    public static List<Cine> resALista(ResultSet res) throws SQLException {
        List<Cine> cines = new ArrayList<Cine>();
        while (res.next()) {
            cines.add(new Cine(res.getInt("cineID"), res.getString("nombreCine"), res.getString("direccion")));
        }
        return cines;
    }
}
