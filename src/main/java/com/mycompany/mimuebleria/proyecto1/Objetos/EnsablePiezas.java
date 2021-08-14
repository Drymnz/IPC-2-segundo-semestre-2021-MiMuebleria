/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.Objetos;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Mueble;
import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Pieza;

/**
 *
 * @author drymnz
 */
public class EnsablePiezas {
   private Mueble mueble;
    private Pieza pieza;
    private int cantidadPiezas;
    // constructor
    public EnsablePiezas(Mueble mueble, Pieza pieza, int cantidadPiezas) {
        this.mueble = mueble;
        this.pieza = pieza;
        this.cantidadPiezas = cantidadPiezas;
    }
    // fin constructor
    // get y set
    public Mueble getMueble() {
        return mueble;
    }
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }
    public Pieza getPieza() {
        return pieza;
    }
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    public int getCantidadPiezas() {
        return cantidadPiezas;
    }
    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }
    //fin get y set 
}
