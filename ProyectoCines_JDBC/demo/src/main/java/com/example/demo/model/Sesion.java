package com.example.demo.model;

import java.security.Timestamp;
import java.time.OffsetDateTime;
import java.util.Date;

public class Sesion {
    private int sesionID;
    private int peliculaID;
    private java.sql.Timestamp horaInicio;
    private java.sql.Timestamp horaFin;

    public Sesion(int sesionID, int peliculaID, java.sql.Timestamp horaInicio, java.sql.Timestamp horaFin) {
        this.sesionID = sesionID;
        this.peliculaID = peliculaID;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Sesion() {

    }

    public int getSesionID() {
        return sesionID;
    }

    public void setSesionID(int sesionID) {
        this.sesionID = sesionID;
    }

    public int getPeliculaID() {
        return peliculaID;
    }

    public void setPeliculaID(int peliculaID) {
        this.peliculaID = peliculaID;
    }

    public java.sql.Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(java.sql.Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public java.sql.Timestamp getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(java.sql.Timestamp horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Sesion{" +
                "sesionID=" + sesionID +
                ", peliculaID=" + peliculaID +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                '}';
    }
}
