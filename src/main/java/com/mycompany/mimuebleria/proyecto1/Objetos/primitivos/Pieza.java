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
public class Pieza {

    private int id;
    private String tipo;
    private float costo;

    // constructor
    
    public Pieza(int id, String tipo, float costo) {
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
    }

    public Pieza(String tipo, float costo) {
        this(0, tipo, costo);
    }

    // fin constructor
    // get y set
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //fin get y set

}
