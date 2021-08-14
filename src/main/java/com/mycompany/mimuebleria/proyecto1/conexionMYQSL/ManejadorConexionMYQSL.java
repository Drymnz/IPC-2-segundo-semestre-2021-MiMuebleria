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

    private final String usuario = "muebleadmin";
    private final String usuarioPassword = "Password123@";
    private final String URL = "JDBC:MYSQL://LOCALHOST:3306/mimuebleria;";
    public static Connection conexion;

    public ManejadorConexionMYQSL() {
        try {
            conexion = DriverManager.getConnection(URL, usuario, usuarioPassword);
        } catch (SQLException e) {
            
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                
            }

        }
    }

}
