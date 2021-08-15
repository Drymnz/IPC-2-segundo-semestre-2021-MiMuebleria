/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author drymnz
 */
public class CargarObjetoPrimitivo {

    private Connection conexion;
    private PreparedStatement ingresar;

    // constructor 
    public CargarObjetoPrimitivo(Connection coneccion) {
        this.conexion = coneccion;
    }

    // fin constructor 
    // ingresar al mysql
    public <T> boolean cargar(T cargar) {
        boolean funciono = false;
        try {
            switch ((cargar instanceof Mueble) ? 1 : (cargar instanceof Pieza) ? 2 : (cargar instanceof Usuario) ? 3 : 4) {
                case 1:
                    Mueble cargarMueble = (Mueble) cargar;
                    funciono = ingresarMueble(cargarMueble);
                    break;
                case 2:
                    Pieza cargarPieza = (Pieza) cargar;
                    funciono = ingresarPieza(cargarPieza);
                    break;
                case 3:
                    Usuario cargarUsuario = (Usuario) cargar;
                    funciono = ingresarUsuario(cargarUsuario);
                    break;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return funciono;
    }

    //fin ingresar al mysql
    private boolean ingresarMueble(Mueble cargar) throws SQLException {
        ingresar = conexion.prepareStatement("INSERT INTO mueble VALUES (?,?)");
        ingresar.setString(1, cargar.getNombre());
        ingresar.setFloat(2, cargar.getPrecio());
        return ingresar.executeUpdate() == 1;
    }

    private boolean ingresarPieza(Pieza cargar) throws SQLException {
        ingresar = conexion.prepareStatement("INSERT INTO pieza VALUES (?,?)");
        ingresar.setString(1, cargar.getTipo());
        ingresar.setFloat(2, cargar.getCosto());
        return ingresar.executeUpdate() == 1;
    }
    
    private boolean ingresarUsuario(Usuario cargar) throws SQLException {
        ingresar = conexion.prepareStatement("INSERT INTO usuario VALUES (?,?,?)");
        ingresar.setString(1, cargar.getNombre());
        ingresar.setString(2, cargar.getPassword());
        ingresar.setInt(3, cargar.getTipo());
        return ingresar.executeUpdate() == 1;
    }
}
