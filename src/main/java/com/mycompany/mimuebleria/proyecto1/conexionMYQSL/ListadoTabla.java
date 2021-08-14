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

    cliente("cliente"),
    detallesFactura("detallesFactura"),
    devolucion("devolucion"),
    ensableMueble("ensableMueble"),
    ensablePieza("ensablePieza"),
    factura("factura"),
    materiaPrima("materiaPrima"),
    mueble("mueble"),
    pieza("pieza"),
    salaVenta("salaVenta"),
    usuario("usuario");

    //constructor
    private String nombre;

    private ListadoTabla(String nombre) {
        this.nombre = nombre;
    }

    //fin constructor
    // get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //fin get y set

}
