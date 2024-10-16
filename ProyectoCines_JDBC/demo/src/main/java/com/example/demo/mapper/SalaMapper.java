package com.example.demo.mapper;

import com.example.demo.dao.SalaDAO;
import com.example.demo.dao.impl.JdbcSalaDAO;
import com.example.demo.dto.SalaDTO;
import com.example.demo.model.Sala;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Salas
 */
public class SalaMapper {

    /**
     * @param s
     * @return
     * @throws SQLException
     */
    public static Sala conversionDTOaSala(SalaDTO s) throws SQLException {
        Sala sala = new Sala(s.getSalaID(), s.getCineID(), s.getNombreSala(), s.getCapacidad(), s.getFilas(), s.getButacasPorFila());
        return sala;
    }

    /**
     * @param sala
     * @return
     * @throws SQLException
     */
    public static SalaDTO convertirADTO(Sala sala) throws SQLException {
        SalaDAO ss = new JdbcSalaDAO();
        return new SalaDTO(sala.getSalaID(), sala.getCineID(), sala.getNombreSala(), sala.getCapacidad(), sala.getFilas(), sala.getButacasPorFila());
    }

    /**
     * @param salas
     * @return
     * @throws SQLException
     */
    public static List<SalaDTO> convertirLista(List<Sala> salas) throws SQLException {
        List<SalaDTO> listaDTO = new ArrayList<SalaDTO>();

        for (Sala sala : salas) {
            listaDTO.add(convertirADTO(sala));
        }
        return listaDTO;
    }

    /**
     * @param res
     * @return
     * @throws SQLException
     */
    public static List<Sala> resALista(ResultSet res) throws SQLException {
        List<Sala> salas = new ArrayList<Sala>();
        while (res.next()) {
            salas.add(new Sala(res.getInt("salaID"), res.getInt("cineID"), res.getString("nombreSala"), res.getInt("capacidad"), res.getInt("filas"), res.getInt("butacasPorFila")));
        }
        return salas;
    }
}
