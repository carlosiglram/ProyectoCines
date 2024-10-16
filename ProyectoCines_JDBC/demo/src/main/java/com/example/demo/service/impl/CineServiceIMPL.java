package com.example.demo.service.impl;

import com.example.demo.dao.CineDAO;
import com.example.demo.dao.impl.JdbcCineDAO;
import com.example.demo.dto.CineDTO;
import com.example.demo.mapper.CineMapper;
import com.example.demo.model.Cine;
import com.example.demo.service.CineService;

import java.sql.SQLException;
import java.util.List;

import static com.example.demo.mapper.CineMapper.convertirADTO;

/**
 * Cines
 */
public class CineServiceIMPL implements CineService {

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<CineDTO> obtenerCines() throws SQLException {
        CineDAO cc = new JdbcCineDAO();
        List<Cine> cines = cc.listarCines();
        return CineMapper.convertirLista(cines);
    }

    /**
     *
     * @param cine
     * @return
     * @throws SQLException
     */
    @Override
    public CineDTO crearCine(CineDTO cine) throws SQLException {
        CineDAO cc = new JdbcCineDAO();
        Cine c = cc.crearCine(CineMapper.conversionDTOaCine(cine));
        return CineMapper.convertirADTO(c);
    }
}
