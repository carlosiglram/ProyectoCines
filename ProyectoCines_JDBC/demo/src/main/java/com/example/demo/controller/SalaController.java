package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.CineService;
import com.example.demo.service.SalaService;
import com.example.demo.service.impl.CineServiceIMPL;
import com.example.demo.service.impl.SalaServiceIMPL;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de gestión de salas
 */
@RestController
public class SalaController {

    /**
     * @param sala nueva sala
     * @return crear una nueva sala
     * @throws SQLException
     */
    @PostMapping("/api/admin/salas")
    SalaDTO crearSala(@RequestBody SalaDTO sala) throws SQLException {
        SalaService ss = new SalaServiceIMPL();
        return ss.crearSala(sala);
    }
}
