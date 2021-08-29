/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL;

/**
 *
 * @author drymnz
 */
public enum ListadoTabla {

    cliente("cliente", ""),
    detallesFactura("detallesFactura", ""),
    devolucion("devolucion", ""),
    ensableMueble("ensableMueble", ""),
    ensablePieza("ensablePieza", ""),
    factura("factura", ""),
    mueble("mueble", "nombre"),
    pieza("pieza", "id"),
    salaVenta("salaVenta", ""),
    usuario("usuario", "nombre");

    //constructor
    private String nombre;
    private String pk;

    private ListadoTabla(String nombre, String pk) {
        this.nombre = nombre;
        this.pk = pk;
    }

    //fin constructor
    // get
    public String getNombre() {
        return nombre;
    }

    public String getPk() {
        return pk;
    }

    //fin get 
}
