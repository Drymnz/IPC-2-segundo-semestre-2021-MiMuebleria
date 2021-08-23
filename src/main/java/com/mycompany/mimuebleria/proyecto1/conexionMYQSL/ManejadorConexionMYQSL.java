/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drymnz
 */
public class ManejadorConexionMYQSL {

    private final static String usuario = "muebleadmin";
    private final static String usuarioPassword = "Password123@";
    private final static String URL = "jdbc:mysql://localhost:3306/mimuebleria";
    private final static String TOMCAT = "com.mysql.cj.jdbc.Driver";
    public static Connection conexion;

    public ManejadorConexionMYQSL(boolean inicarConexionMYQSL) {
        if (inicarConexionMYQSL) {
            try {
                iniciarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("--->" + e.getMessage());
                System.out.println(e.getErrorCode());
            } catch (ClassNotFoundException ex) {
                System.out.println("tomcat-->" + ex.getMessage());
                Logger.getLogger(ManejadorConexionMYQSL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // inicar y cerrar la conecxion manual
    public void iniciarConexion() throws SQLException, ClassNotFoundException {
        Class.forName(TOMCAT);
        conexion = DriverManager.getConnection(URL, usuario, usuarioPassword);
    }

    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorConexionMYQSL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // fin inicar y  cerrar la conecxion manual

    public Connection getConexion() {
        return conexion;
    }

}
