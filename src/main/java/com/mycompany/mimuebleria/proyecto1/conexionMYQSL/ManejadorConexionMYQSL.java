/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author drymnz
 */
public class ManejadorConexionMYQSL {

    private final static String usuario = "muebleadmin";
    private final static String usuarioPassword = "Password123@";
    private final static String URL = "jdbc:mysql://localhost:3306/mimuebleria";
    public static Connection conexion;

    public ManejadorConexionMYQSL(boolean inicarConexionMYQSL) {
        if (inicarConexionMYQSL) {
            try {
                iniciarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getErrorCode());
            }
        }
    }

    // inicar y cerrar la conecxion manual
    public void iniciarConexion() throws SQLException {
        conexion = DriverManager.getConnection(URL, usuario, usuarioPassword);
    }

    public void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    // fin inicar y  cerrar la conecxion manual

    public Connection getConexion() {
        return conexion;
    }

}
