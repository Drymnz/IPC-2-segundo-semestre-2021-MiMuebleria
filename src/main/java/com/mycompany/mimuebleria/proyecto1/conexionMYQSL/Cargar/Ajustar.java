/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drymnz
 */
public class Ajustar {

    private Connection conexion;
    private PreparedStatement ingresar;

    // constructor 
    public Ajustar(Connection coneccion) {
        this.conexion = coneccion;
    }

    // fin constructor 
    public <T> boolean eliminarPK(ListadoTabla donde, T quien) {
        boolean eliminado = false;
        try {
            ingresar = conexion.prepareStatement("delete from " + donde.getNombre() + " where " + donde.getPk() + "=?");
            switch (donde) {
                case pieza:
                    Pieza eliminarPieza = (Pieza) quien;
                    ingresar.setInt(1, eliminarPieza.getId());
                    break;
            }
            return ingresar.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.out.println("eliminar " + ex.getMessage());
            Logger.getLogger(Ajustar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    public <T> boolean modificarPK(ListadoTabla donde, T quien, T cual) {
        boolean eliminado = false;
        try {
            String semodifica = "";
            String pk = "";
            switch (donde) {
                case pieza:
                    Pieza modificarPieza = (Pieza) quien;
                    Pieza porCual = (Pieza) cual;
                    pk = String.valueOf(modificarPieza.getId());
                    semodifica = "tipo='" + porCual.getTipo() + "',precio='" + porCual.getCosto()+"'";
                    break;
            }
            ingresar = conexion.prepareStatement("UPDATE " + donde.getNombre() + " SET " + semodifica + " where " + donde.getPk() + "=" + pk);
            return ingresar.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.out.println("eliminar " + ex.getMessage());
            Logger.getLogger(Ajustar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }
}
