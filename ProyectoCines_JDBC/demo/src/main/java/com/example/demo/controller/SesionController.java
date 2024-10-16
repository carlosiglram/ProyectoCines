package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.SalaService;
import com.example.demo.service.SesionService;
import com.example.demo.service.impl.SalaServiceIMPL;
import com.example.demo.service.impl.SesionServiceIMPL;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de gestión de sesiones
 */
@RestController
public class SesionController {

    /**
     * @param sesionID identificador de una sesion
     * @return lista de reservas de una sesion concreta
     */
    @GetMapping("/api/sesiones/{sesionID}/reservas")
    List<ReservaDTO> devolverListaSesiones(@PathVariable int sesionID) {
        return null;
    }

    /**
     * @param sesion nueva sesion
     * @return crear una nueva sesión
     * @throws SQLException
     */
    @PostMapping("/api/admin/sesiones")
    SesionDTO crearSesion(@RequestBody SesionDTO sesion) throws SQLException {
        SesionService ss = new SesionServiceIMPL();
        return ss.crearSesion(sesion);
    }
}
