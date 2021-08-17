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
public class CargarObjetosMYQSL {

    // constructor
    public CargarObjetosMYQSL() {
    }

    // fin constructor
    public boolean cargarTexto(String[] texto, ListadoPalabrasClasvesCargarArchivo tipo) {
        System.out.println("me llego ---"+texto[0]);
        switch (tipo) {
            case USUARIO:
                break;
        }
        return false;
    }

    public String[] limpiarTexto(String texto) {
        String[] regresar = null;
        texto = texto.trim();
        texto = texto.replaceAll("\\)", "");
        regresar = texto.split("\\(");
        return regresar;
    }

    public String[] limpiarAtributos(String texto) {
        String[] regresar = null;
        texto = texto.trim();
        regresar = texto.split("\\,");
        return regresar;
    }
}
