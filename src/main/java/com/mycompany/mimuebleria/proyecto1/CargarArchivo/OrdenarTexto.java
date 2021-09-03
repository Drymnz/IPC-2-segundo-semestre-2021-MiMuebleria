/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.CargarArchivo;

import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;

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
            String[] ver = dividor[i].split("\\(");
            guia[i] = asignar(ver[0]);
        }
        dividor = ordenarRespectoIntUsandoShell(dividor, guia);
    }
    // ordenamiento numerico respecto a un arreglo que ordenar, del menor al mayor
    private String[] ordenarRespectoIntUsandoShell(String[] ordenar, int[] respecto) {
        int salto = (ordenar.length) / 2;
        int j, k;
        while ((salto > 0)) {
            for (int i = salto; i < ordenar.length; i++) {
                j = i - salto;
                while (j >= 0) {
                    k = j + salto;
                    if (respecto[j] <= respecto[k]) {
                        j = -1;
                    } else {
                        int auxiliar = respecto[j];
                        respecto[j] = respecto[k];
                        respecto[k] = auxiliar;
                        String cambiar = ordenar[j];
                        ordenar[j] = ordenar[k];
                        ordenar[k] = cambiar;
                        j -= salto;
                    }
                }
            }
            salto /= 2;
        }
        return ordenar;
    }

    // asigna una jerarquie para que carge de los primitido hasta lo complejo(post)
    private int asignar(String ver) {
        ver = ver.toUpperCase();
        ListadoTabla[] palabras = ListadoTabla.values();
        int asignar = palabras.length;
        for (ListadoTabla palabra : palabras) {
            if (!palabra.getPalabraClaveCargaArchivo().isEmpty() && palabra.getPalabraClaveCargaArchivo().equalsIgnoreCase(ver)) {
                switch (palabra) {
                    case usuario:
                        return 1;
                    case pieza:
                        return 2;
                    case cliente:
                        return 3;
                    case mueble:
                        return 4;
                    case ensablePieza:
                        return 5;
                    case ensableMueble:
                        return 6;
                }
            }
        }
        return asignar;
    }
}
