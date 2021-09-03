/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.Objetos.primitivos;

/**
 *
 * @author drymnz
 */
public class Mueble {

    private String nombre;
    private float precio;

    // constructor
    public Mueble(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // fin constructor
    // get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    //fin get y set
}
