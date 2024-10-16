package com.example.demo.controller;

import com.example.demo.dto.PeliculaDTO;
import com.example.demo.dto.ReservaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase de gestión de reservas
 */
@RestController
public class ReservasController {

    /**
     * @param reserva nueva reserva
     * @return crear nueva reserva
     */
    @PostMapping("/api/reservas")
    ReservaDTO regitrarReserva(@RequestBody ReservaDTO reserva) {
        return null;
    }

    /**
     * @param reservaID identificador de reserva
     * @return confirmacion de una reserva concreta
     */
    @PutMapping("/api/reservas/{reservaID}/confirmar")
    List<PeliculaDTO> confirmarReserva(@PathVariable int reservaID) {
        return null;
    }

}
