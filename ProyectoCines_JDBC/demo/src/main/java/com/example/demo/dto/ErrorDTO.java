package com.example.demo.dto;

import java.time.LocalDateTime;

public class ErrorDTO {
    private String error;
    private LocalDateTime hora;

    public ErrorDTO(String error, LocalDateTime hora) {
        this.error = error;
        this.hora = hora;
    }

    public ErrorDTO() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "error='" + error + '\'' +
                ", hora=" + hora +
                '}';
    }
}
