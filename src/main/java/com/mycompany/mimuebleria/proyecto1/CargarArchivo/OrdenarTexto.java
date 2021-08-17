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
public class OrdenarTexto {

    private String cargar;
    private String[] dividor;

    //constructor
    public OrdenarTexto(String cargar) {
        this.cargar = cargar;
    }

    //fin constructor
    public String[] componerTexto() {
        dividor = cargar.split("\\)");
        ordenar();
        return dividor;
    }

    // metodo que ordena
    private void ordenar() {
        int[] guia = new int[dividor.length];
        for (int i = 0; i < guia.length; i++) {
            guia[i] = asignar(dividor[i]);
        }
        dividor = ordenarRespectoInt(dividor, guia);
    }

    private String[] ordenarRespectoInt(String[] ordenar, int[] respecto) {
        int selecion = 0;
        int posicion = 0;
        String mover = "";
        for (int i = 0; i < ordenar.length; i++) {
            selecion = respecto[i];
            mover = ordenar[i];
            posicion = i;
            for (int j = i + 1; j < ordenar.length; j++) {
                if (selecion > respecto[j]) {
                    selecion = respecto[j];
                    mover = ordenar[j];
                    posicion = j;
                }
            }
            respecto[posicion] = respecto[i];
            respecto[i] = selecion;
            ordenar[posicion] = ordenar[i];
            ordenar[i] = mover;
        }
        return ordenar;
    }

    // asigna una jerarquie para que carge de los primitido hasta lo complejo(post)
    private int asignar(String ver) {
        ver = ver.toUpperCase();
        ListadoPalabrasClasvesCargarArchivo[] palabras = ListadoPalabrasClasvesCargarArchivo.values();
        for (int i = 0; i < palabras.length; i++) {
            if ((ver.indexOf(palabras[i].getNombre().toUpperCase()) == 0)) {
                return palabras[i].getNumero();
            }
        }
        return palabras.length;
    }
}
