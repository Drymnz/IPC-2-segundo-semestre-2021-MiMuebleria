/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.CargarArchivo;

/**
 *
 * @author drymnz
 */
public enum ListadoPalabrasClasvesCargarArchivo {
    /*
    el nombre el texto que puede representar en el texto plano
    el numero na jerarquía de los materias
     */
    USUARIO("usuario", 1),
    MUEBLE("mueble", 2),
    PIEZA("pieza", 3),
    ENSABLE_PIEZAS("ensable_pieza", 4),
    ENSABLAR_MUEBLE("ensamblar_mueble", 5);

    //constructor
    private String nombre;
    private int numero;

    private ListadoPalabrasClasvesCargarArchivo(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    //fin constructor
    // get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    //fin get y set

}
