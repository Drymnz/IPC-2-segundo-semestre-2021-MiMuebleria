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
        private String tipo;
    private float costo;
    // constructor
    public Pieza(String tipo, float costo) {
        this.tipo = tipo;
        this.costo = costo;
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
    
    //fin get y set
}
