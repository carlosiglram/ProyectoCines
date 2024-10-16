package com.example.demo.mapper;

import com.example.demo.dao.SesionDAO;
import com.example.demo.dao.impl.JdbcSesionDAO;
import com.example.demo.dto.SalaDTO;
import com.example.demo.dto.SesionDTO;
import com.example.demo.model.Sala;
import com.example.demo.model.Sesion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Sesiones
 */
public class SesionMapper {

    /**
     * @param s
     * @return
     * @throws SQLException
     */
    public static Sesion conversionDTOaSesion(SesionDTO s) throws SQLException {
        Sesion sesion = new Sesion(s.getSesionID(), s.getPeliculaID(), s.getHoraInicio(), s.getHoraFin());
        return sesion;
    }

    /**
     * @param sesion
     * @return
     * @throws SQLException
     */
    public static SesionDTO convertirADTO(Sesion sesion) throws SQLException {
        SesionDAO ss = new JdbcSesionDAO();

        return new SesionDTO(sesion.getSesionID(), sesion.getPeliculaID(), sesion.getHoraInicio(), sesion.getHoraFin());
    }

    /**
     * @param sesiones
     * @return
     * @throws SQLException
     */
    public static List<SesionDTO> convertirLista(List<Sesion> sesiones) throws SQLException {

        List<SesionDTO> listaDTO = new ArrayList<SesionDTO>();

        for (Sesion sesion : sesiones) {
            listaDTO.add(convertirADTO(sesion));
        }
        return listaDTO;
    }

    /**
     * @param res
     * @return
     * @throws SQLException
     */
    public static List<Sesion> resALista(ResultSet res) throws SQLException {
        List<Sesion> sesiones = new ArrayList<Sesion>();
        while (res.next()) {
            sesiones.add(new Sesion(res.getInt("sesionID"), res.getInt("peliculaID"), res.getTimestamp("horaInicio"), res.getTimestamp("horaFin")));
        }
        return sesiones;
    }
}
