package com.example.demo.controller;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.dto.PeliculaDTO;
import com.example.demo.dto.SesionDTO;
import com.example.demo.service.PeliculaService;
import com.example.demo.service.SesionService;
import com.example.demo.service.impl.PeliculaServiceIMPL;
import com.example.demo.service.impl.SesionServiceIMPL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de gestión de películas
 */
@RestController
public class PeliculaController {

    /**
     * @param peliculaID identificador de la pelicula
     * @return lista de sesiones de una pelicula concreta
     * @throws SQLException
     */
    @GetMapping("/api/peliculas/{peliculaID}/sesiones")
    ResponseEntity<?> devolverSesionesPelicula(@PathVariable int peliculaID) throws SQLException {
        SesionService ss = new SesionServiceIMPL();
        List<SesionDTO> lista = ss.obtenerSesiones();
        List<SesionDTO> listaSesiones = new ArrayList<SesionDTO>();
        boolean sesionEncontrada = false;

        for (SesionDTO sesion : lista) {
            if (sesion.getPeliculaID() == peliculaID) {
                listaSesiones.add(sesion);
                sesionEncontrada = true;
            }
        }

        if (!sesionEncontrada) {
            return ResponseEntity.badRequest().body(new ErrorDTO("ERROR", LocalDateTime.now()));
        }

        return ResponseEntity.ok(listaSesiones);
    }

    /**
     * @param pelicula nueva pelicula
     * @return crear una nueva pelicula
     * @throws SQLException
     */
    @PostMapping("/api/admin/peliculas")
    PeliculaDTO crearPelicula(@RequestBody PeliculaDTO pelicula) throws SQLException {
        PeliculaService ps = new PeliculaServiceIMPL();
        return ps.crearPeli(pelicula);
    }
}
