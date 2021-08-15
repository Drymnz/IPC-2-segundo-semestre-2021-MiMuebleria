/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta;

import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author drymnz
 */
public class BuscadorExistencialPK {

    private Connection conexion;
    private PreparedStatement buscar;

    //constructor
    public BuscadorExistencialPK(Connection conexion) {
        this.conexion = conexion;
    }

    //fin constructor
    public boolean tablaPKVarchar(String nombre, ListadoTabla verificar) throws SQLException {
        String columna = "";
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
        ResultSet resultado = buscar.executeQuery();
        resultado.next();
        return resultado.getString(columna).equalsIgnoreCase(nombre);
    }

    public boolean tablaPKInt(int numero, ListadoTabla verificar) throws SQLException {
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
        ResultSet resultado = buscar.executeQuery();
        resultado.next();
        return resultado.getInt(columna) == numero;
    }
}
