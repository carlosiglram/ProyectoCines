package com.example.demo.dto;

public class AccesoDTO {

    private String nombreUsuario;
    private String claveAcceso;

    public AccesoDTO(String nombreUsuario, String claveAcceso) {
        this.nombreUsuario = nombreUsuario;
        this.claveAcceso = claveAcceso;
    }

    public AccesoDTO() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    @Override
    public String toString() {
        return "AccesoDTO{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", claveAcceso='" + claveAcceso + '\'' +
                '}';
    }
}
