package com.example.demo.model;

import java.io.Serializable;

public class Cine implements Serializable {
    private int cineID;
    private String nombreCine;
    private String direccion;


    public Cine(int cineID, String nombreCine, String direccion) {
        this.cineID = cineID;
        this.nombreCine = nombreCine;
        this.direccion = direccion;
    }

    public Cine() {
    }

    public int getCineID() {
        return cineID;
    }

    public void setCineID(int cineID) {
        this.cineID = cineID;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cine{" +
                "cineID=" + cineID +
                ", nombreCine='" + nombreCine + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}