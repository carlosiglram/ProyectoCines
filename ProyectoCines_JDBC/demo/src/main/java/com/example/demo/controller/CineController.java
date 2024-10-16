package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.Sala;
import com.example.demo.service.CineService;
import com.example.demo.service.PeliculaService;
import com.example.demo.service.SalaService;
import com.example.demo.service.impl.CineServiceIMPL;
import com.example.demo.service.impl.PeliculaServiceIMPL;
import com.example.demo.service.impl.SalaServiceIMPL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de gestión de cines
 */
@RestController
public class CineController {

    /**
     * @return lista de cines
     * @throws SQLException
     */
    @GetMapping("/api/cines")
    ResponseEntity<?> devolverCines() throws SQLException {

        CineService cs = new CineServiceIMPL();
        List<CineDTO> lista = cs.obtenerCines();
        boolean cinesEncontrados = false;

        for (CineDTO cine : lista) {
            System.out.println(cine.toString());
            cinesEncontrados = true;
        }

        if (!cinesEncontrados) {
            return ResponseEntity.badRequest().body(new ErrorDTO("ERROR", LocalDateTime.now()));
        }

        return ResponseEntity.ok(lista);
    }

    /**
     * @param cineID identificador del cine
     * @return lista de peliculas en un cine concreto
     * @throws SQLException
     */
    @GetMapping("/api/cines/{cineID}/peliculas")
    public static ResponseEntity<?> devolverPeliculasCine(@PathVariable int cineID) throws SQLException {
        PeliculaService ps = new PeliculaServiceIMPL();
        List<PeliculaDTO> lista = ps.obtenerPeliculas(cineID);
        boolean peliculasEncontradas = false;

        for (PeliculaDTO peli : lista) {
            System.out.println(peli.toString());
            peliculasEncontradas = true;
        }

        if (!peliculasEncontradas) {
            return ResponseEntity.badRequest().body(new ErrorDTO("ERROR", LocalDateTime.now()));
        }

        return ResponseEntity.ok(lista);
    }

    /**
     * @param cineID identificador del cine
     * @return lista de salas de un cine concreto
     * @throws SQLException
     */
    @GetMapping("/api/cines/{cineID}/salas")
    ResponseEntity<?> devolverSalasCine(@PathVariable int cineID) throws SQLException {

        SalaService ss = new SalaServiceIMPL();
        List<SalaDTO> lista = ss.obtenerSalas();
        List<SalaDTO> listaSalas = new ArrayList<SalaDTO>();
        boolean salasEncontradas = false;

        for (SalaDTO sala : lista) {
            if (sala.getCineID() == cineID) {
                listaSalas.add(sala);
                salasEncontradas = true;
            }
        }

        if (!salasEncontradas) {
            return ResponseEntity.badRequest().body(new ErrorDTO("ERROR", LocalDateTime.now()));
        }

        return ResponseEntity.ok(listaSalas);
    }

    /**
     * @param cine nuevo cine
     * @return crear un nuevo cine
     * @throws SQLException
     */
    @PostMapping("/api/admin/cines")
    CineDTO crearCine(@RequestBody CineDTO cine) throws SQLException {
        CineService cs = new CineServiceIMPL();
        return cs.crearCine(cine);
    }
}
