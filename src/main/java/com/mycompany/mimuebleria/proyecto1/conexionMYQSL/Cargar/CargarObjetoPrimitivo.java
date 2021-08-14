/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar;

import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import java.sql.Connection;

/**
 *
 * @author drymnz
 */
public class CargarObjetoPrimitivo {

    private Connection coneccion;
    private ListadoTabla listado[] = {ListadoTabla.usuario, ListadoTabla.mueble, ListadoTabla.usuario};

    // constructor 
    public CargarObjetoPrimitivo(Connection coneccion) {
        this.coneccion = coneccion;
    }
    // fin constructor 
    // ingresar al mysql
    //fin ingresar al mysql
    
}
