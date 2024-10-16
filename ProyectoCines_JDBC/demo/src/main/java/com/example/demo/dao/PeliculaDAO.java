package com.example.demo.dao;

import com.example.demo.model.Cine;
import com.example.demo.model.Sesion;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Pelicula;

public interface PeliculaDAO {

    List<Pelicula> listarPeliculas(int cineID) throws SQLException;

    Pelicula crearPeli(Pelicula p) throws SQLException;
}
