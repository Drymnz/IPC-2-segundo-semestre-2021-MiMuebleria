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
public class Usuario {
        private String nombre;
    private String password;
    // constructor
    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
    //fin constructor

    // get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // fin get y set
}
