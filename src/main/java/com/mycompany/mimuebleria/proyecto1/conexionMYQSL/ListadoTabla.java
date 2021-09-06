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
    factura("factura", "", ""),
    salaVenta("salaVenta", "id", ""),
    detallesFactura("detallesFactura", "", ""),
    cliente("cliente", "", "CLIENTE"),
    devolucion("devolucion", "", ""),
    ensableMueble("ensablaMueble", "", "ENSAMBLAR_MUEBLE"),
    ensablePieza("ensablepieza", "", "ENSAMBLE_PIEZAS"),
    mueble("mueble", "nombre", "MUEBLE"),
    pieza("pieza", "id", "PIEZA"),
    usuario("usuario", "nombre", "USUARIO");

    //constructor
    private String nombre;
    private String pk;
    private String palabraClaveCargaArchivo;

    private ListadoTabla(String nombre, String pk, String palabraClaveCargaArchivo) {
        this.nombre = nombre;
        this.palabraClaveCargaArchivo = palabraClaveCargaArchivo;
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

    public String getPalabraClaveCargaArchivo() {
        return palabraClaveCargaArchivo;
    }
    //fin get 

}
