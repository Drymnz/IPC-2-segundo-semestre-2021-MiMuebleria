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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drymnz
 */
public class ListadoFilasTabla<T> {

    private final Connection conexion;
    private ResultSet resultado;
    private PreparedStatement buscar;
    //constructor

    public ListadoFilasTabla(Connection conexion, ResultSet resultado, PreparedStatement buscar) {
        this.conexion = conexion;
        this.resultado = resultado;
        this.buscar = buscar;
    }

    public ListadoFilasTabla(Connection conexion) {
        this(conexion, null, null);
    }

    //fin constructor
    public List getTablaDB(ListadoTabla cual) {
        List<T> listado = new ArrayList<>();
        try {
            buscar = conexion.prepareStatement("SELECT * FROM " + cual.getNombre());
            resultado = buscar.executeQuery();
            while (resultado.next()) {
                T a = (T) (new BuscadorExistencialPK(conexion)).encontro(cual, resultado);
                listado.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ListadoFilasTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listado;
    }

}
