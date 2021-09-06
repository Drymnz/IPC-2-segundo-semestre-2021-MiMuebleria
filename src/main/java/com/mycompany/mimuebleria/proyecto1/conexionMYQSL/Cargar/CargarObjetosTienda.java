/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar;

import com.mycompany.mimuebleria.proyecto1.Objetos.SalaVenta;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author drymnz
 */
public class CargarObjetosTienda extends CargadorMYQSL {

    // construccotres
    public CargarObjetosTienda(Connection conexion, PreparedStatement ingresar) {
        super(conexion, ingresar);
    }

    public CargarObjetosTienda(Connection conexion) {
        super(conexion);
    }

    // fin construccotres
    public boolean cargarSalaVenta(SalaVenta cargar) {
        try {
            ingresar = conexion.prepareStatement("INSERT INTO " + ListadoTabla.salaVenta.getNombre() + " VALUES (?,?,?,?)");
            ingresar.setInt(1, cargar.getId());
            ingresar.setString(2, cargar.getNombreProducto());
            ingresar.setFloat(3, cargar.getPrecioEnsablado());
            ingresar.setBoolean(4, cargar.isDisponible());
            return ingresar.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }
    }

}
