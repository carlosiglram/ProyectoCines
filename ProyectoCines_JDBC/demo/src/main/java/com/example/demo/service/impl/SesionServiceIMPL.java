package com.example.demo.service.impl;

import com.example.demo.dao.CineDAO;
import com.example.demo.dao.SesionDAO;
import com.example.demo.dao.impl.JdbcCineDAO;
import com.example.demo.dao.impl.JdbcSesionDAO;
import com.example.demo.dto.CineDTO;
import com.example.demo.dto.SesionDTO;
import com.example.demo.mapper.CineMapper;
import com.example.demo.mapper.SesionMapper;
import com.example.demo.model.Cine;
import com.example.demo.model.Sesion;
import com.example.demo.service.SesionService;

import java.sql.SQLException;
import java.util.List;

/**
 * Sesiones
 */
public class SesionServiceIMPL implements SesionService {

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public List<SesionDTO> obtenerSesiones() throws SQLException {
        SesionDAO ss = new JdbcSesionDAO();
        List<Sesion> sesiones = ss.listarSesiones();
        return SesionMapper.convertirLista(sesiones);
    }

    /**
     * @param sesion
     * @return
     * @throws SQLException
     */
    @Override
    public SesionDTO crearSesion(SesionDTO sesion) throws SQLException {
        SesionDAO ss = new JdbcSesionDAO();
        Sesion s = ss.crearSesion(SesionMapper.conversionDTOaSesion(sesion));
        return SesionMapper.convertirADTO(s);
    }
}
