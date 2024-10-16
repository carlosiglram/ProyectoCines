package com.example.demo.model;

import com.example.demo.dto.SalaDTO;

import java.io.Serializable;

public class Sala implements Serializable {
    private int salaID;
    private int cineID;
    private String nombreSala;
    private int capacidad;
    private int filas;
    private int butacasPorFila;

    public Sala(int salaID, int cineID, String nombreSala, int capacidad, int filas, int butacasPorFila) {
        this.salaID = salaID;
        this.cineID = cineID;
        this.nombreSala = nombreSala;
        this.capacidad = capacidad;
        this.filas = filas;
        this.butacasPorFila = butacasPorFila;
    }

    public Sala() {

    }

    public int getSalaID() {
        return salaID;
    }

    public void setSalaID(int salaID) {
        this.salaID = salaID;
    }

    public int getCineID() {
        return cineID;
    }

    public void setCineID(int cineID) {
        this.cineID = cineID;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getButacasPorFila() {
        return butacasPorFila;
    }

    public void setButacasPorFila(int butacasPorFila) {
        this.butacasPorFila = butacasPorFila;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "salaID=" + salaID +
                ", cineID=" + cineID +
                ", nombreSala='" + nombreSala + '\'' +
                ", capacidad=" + capacidad +
                ", filas=" + filas +
                ", butacasPorFila=" + butacasPorFila +
                '}';
    }
}
