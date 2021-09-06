/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.Objetos;

import java.time.LocalDate;

/**
 *
 * @author drymnz
 */
public class SalaVenta {

    private int id;
    private String nombreProducto;
    private float precioEnsablado;
    private boolean disponible;

    // constructor
    public SalaVenta(int id, String nombreProducto, float precioEnsablado, boolean disponible) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioEnsablado = precioEnsablado;
        this.disponible = disponible;
    }

    public SalaVenta(String nombreProducto, float precioEnsablado, boolean disponible,LocalDate fechaIngreso) {
        this(0, nombreProducto, precioEnsablado, disponible);
    }

    public SalaVenta(String nombreProducto, float precioEnsablado) {
        this(0, nombreProducto, precioEnsablado, true);
    }
    // fin constructor
    //get 

    public int getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public float getPrecioEnsablado() {
        return precioEnsablado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    //fin get 
    // set
    public void setId(int id) {
        this.id = id;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioEnsablado(float precioEnsablado) {
        this.precioEnsablado = precioEnsablado;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    // fin set

}
