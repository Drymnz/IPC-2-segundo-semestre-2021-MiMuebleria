/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.ListadoFilasTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author drymnz
 */
public class CargarEnsable extends CargadorMYQSL {

    // constructor 
    public CargarEnsable(Connection conexion, PreparedStatement ingresar) {
        super(conexion, ingresar);
    }

    public CargarEnsable(Connection conexion) {
        super(conexion);
    }

    // fin constructor 
    // ingresar al mysql
    public boolean cargarEnsablePiezas(Pieza pieza, Mueble mueble, int cantidad) {
        try {
            ingresar = conexion.prepareStatement("INSERT INTO "+ListadoTabla.ensablePieza.getNombre()+" VALUES (?,?,?)");
            ingresar.setString(1, pieza.getTipo());
            ingresar.setString(2, mueble.getNombre());
            ingresar.setInt(3, cantidad);
            return ingresar.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean cargarEnsableMueble(Mueble mueble, Usuario ensablador, LocalDate fecha) {
        try {
            ingresar = conexion.prepareStatement("INSERT INTO "+ListadoTabla.ensableMueble.getNombre()+" VALUES (?,?,?)");
            ingresar.setString(1, mueble.getNombre());
            ingresar.setString(2, ensablador.getNombre());
            ingresar.setDate(3, Date.valueOf(fecha));
            return ingresar.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }
    }
    //fin ingresar al mysql
}
