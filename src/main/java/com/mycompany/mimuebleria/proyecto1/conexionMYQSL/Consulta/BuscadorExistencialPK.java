/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author drymnz
 */
public class BuscadorExistencialPK<T> {

    private Connection conexion;
    private ResultSet resultado;
    private PreparedStatement buscar;
    private T encontrado;

    //constructor
    public BuscadorExistencialPK(Connection conexion) {
        this.conexion = conexion;
    }

    //fin constructor
    public boolean tablaPKVarchar(String nombre, ListadoTabla verificar) {
        String columna = "";
        try {
            switch (verificar) {
                case usuario:
                    buscar = conexion.prepareStatement("select * from usuario WHERE nombre=?");
                    columna = "nombre";
                    break;
                case pieza:
                    buscar = conexion.prepareStatement("select * from pieza WHERE tipo=?");
                    columna = "tipo";
                    break;
                case mueble:
                    buscar = conexion.prepareStatement("select * from mueble WHERE nombre=?");
                    columna = "nombre";
                    break;
            }
            buscar.setString(1, nombre);
            resultado = buscar.executeQuery();
            resultado.next();
            if (resultado.getString(columna).equalsIgnoreCase(nombre)) {
                encontro(verificar);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean tablaPKInt(int numero, ListadoTabla verificar) {
        try {
            String columna = "";
            switch (verificar) {
                case cliente:
                    buscar = conexion.prepareStatement("select * from cliente WHERE id=?");
                    columna = "id";
                    break;
                case factura:
                    buscar = conexion.prepareStatement("select * from factura WHERE codigo=?");
                    columna = "codigo";
                    break;
            }
            buscar.setInt(1, numero);
            resultado = buscar.executeQuery();
            resultado.next();
            if (resultado.getInt(columna) == numero) {
                encontro(verificar);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void encontro(ListadoTabla verificar) throws SQLException {
        switch (verificar) {
            case cliente:
                break;
            case factura:
                break;
            case mueble:
                String nombreMueble = resultado.getString("nombre");
                float precioMueble = resultado.getFloat("precio");
                encontrado = (T) new Mueble(nombreMueble, precioMueble);
                break;
            case pieza:
                String tipoPieza = resultado.getString("tipo");
                float precio = resultado.getFloat("precio");
                encontrado = (T) new Pieza(tipoPieza, precio);
                break;
            case usuario:
                String nombre = resultado.getString("nombre");
                String password = resultado.getString("password");
                int tipo = resultado.getInt("tipo");
                encontrado = (T) new Usuario(nombre, password, tipo);
                break;
        }
    }

    // get de lo que obtuvo en la busqueda
    public T getEncontrado() {
        return encontrado;
    }

}
