/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author drymnz
 */
public class CargadorMYQSL {
    protected Connection conexion;
    protected PreparedStatement ingresar;

    public CargadorMYQSL(Connection conexion, PreparedStatement ingresar) {
        this.conexion = conexion;
        this.ingresar = ingresar;
    }

    public CargadorMYQSL(Connection conexion) {
        this.conexion = conexion;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public PreparedStatement getIngresar() {
        return ingresar;
    }

    public void setIngresar(PreparedStatement ingresar) {
        this.ingresar = ingresar;
    }
    
    
}
