package com.example.demo.dto;

public class UsuarioDTO {
    private int usuarioID;
    private String nombreUsuario;
    private String email;
    private String claveAcceso;
    private String rol;

    public UsuarioDTO(int usuarioID, String nombreUsuario, String email, String claveAcceso, String rol) {
        this.usuarioID = usuarioID;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.claveAcceso = claveAcceso;
        this.rol = rol;
    }

    public UsuarioDTO(String nombreUsuario, String email, String claveAcceso, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.claveAcceso = claveAcceso;
        this.rol = rol;
    }

    public UsuarioDTO(String claveAcceso, int usuarioID) {
        this.claveAcceso = claveAcceso;
        this.usuarioID = usuarioID;
    }

    public UsuarioDTO() {
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioID=" + usuarioID +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", email='" + email + '\'' +
                ", claveAcceso='" + claveAcceso + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
