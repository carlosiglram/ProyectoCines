package com.example.demo.dao.impl;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.SalaDAO;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.model.Sala;

import java.sql.*;
import java.util.List;

/**
 * Salas
 */
public class JdbcSalaDAO implements SalaDAO {

    private DBConnector connector = new HikariDBConnector();

    /**
     * @return lista de salas
     * @throws SQLException
     */
    @Override
    public List<Sala> listarSalas() throws SQLException {

        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;
        try {
            s = c.prepareStatement("SELECT * FROM Salas");
            return SalaMapper.resALista(s.executeQuery());

        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException(e);
        } finally {
            if (s != null) s.close();
            ;
            if (c != null) c.close();
        }
    }

    /**
     * @param sala nueva sala
     * @return nueva sala
     * @throws SQLException
     */
    @Override
    public Sala crearSala(Sala sala) throws SQLException {
        Connection c = connector.obtenerConexion();
        PreparedStatement s = null;

        try {
            s = c.prepareStatement("INSERT INTO Salas (cineID,nombreSala,capacidad,filas,butacasPorFila) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            s.setInt(1, sala.getCineID());
            s.setString(2, sala.getNombreSala());
            s.setInt(3, sala.getCapacidad());
            s.setInt(4, sala.getFilas());
            s.setInt(5, sala.getButacasPorFila());
            s.executeUpdate();

            ResultSet id = s.getGeneratedKeys();

            if (id.next()) {
                sala.setSalaID(id.getInt(1));
            }
            return sala;

        } catch (SQLException e) {
            System.out.println("Consulta KO");
            throw new RuntimeException();
        } finally {
            if (s != null) s.close();
            if (c != null) c.close();
        }
    }
}