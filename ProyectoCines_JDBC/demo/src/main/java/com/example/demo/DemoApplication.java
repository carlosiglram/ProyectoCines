package com.example.demo;

import com.example.demo.dao.DBConnector;
import com.example.demo.dao.impl.HikariDBConnector;
import com.example.demo.dto.CineDTO;
import com.example.demo.controller.CineController;
import com.example.demo.service.CineService;
import com.example.demo.service.impl.CineServiceIMPL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Clase principal donde declarar métodos
 */
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DemoApplication.class, args);

    }
}


