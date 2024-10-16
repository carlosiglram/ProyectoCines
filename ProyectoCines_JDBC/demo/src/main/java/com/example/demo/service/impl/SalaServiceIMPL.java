package com.example.demo.service.impl;

import com.example.demo.dao.SalaDAO;
import com.example.demo.dao.impl.JdbcSalaDAO;
import com.example.demo.dto.SalaDTO;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.model.Sala;
import com.example.demo.service.SalaService;

import java.sql.SQLException;
import java.util.List;

/**
 * Salas
 */
public class SalaServiceIMPL implements SalaService {

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public List<SalaDTO> obtenerSalas() throws SQLException {
        SalaDAO ss = new JdbcSalaDAO();
        List<Sala> salas = ss.listarSalas();
        return SalaMapper.convertirLista(salas);
    }

    /**
     * @param sala
     * @return
     * @throws SQLException
     */
    @Override
    public SalaDTO crearSala(SalaDTO sala) throws SQLException {
        SalaDAO ss = new JdbcSalaDAO();
        Sala s = ss.crearSala(SalaMapper.conversionDTOaSala(sala));
        return SalaMapper.convertirADTO(s);
    }
}