/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.CargarArchivo;

import com.mycompany.mimuebleria.proyecto1.VerificadorTexto.VerificadorTexto;

/**
 *
 * @author drymnz
 */
public class CargardorMasivo {

    private String cargar;
    private String[] noCargo;
    private ListadoPalabrasClasvesCargarArchivo tipoObjetoCargar;

    //constructor
    public CargardorMasivo(String cargar) {
        this.cargar = cargar;
    }

    //fin constructor
    //cargar texto
    public void cargar() {
        String[] cargarObjetos = (new OrdenarTexto(cargar)).componerTexto();
        noCargo = new String[cargarObjetos.length];
        for (int i = 0; i < cargarObjetos.length; i++) {
            String[] cargarMYQSL = null;
            try {
                cargarMYQSL = verificar(cargarObjetos[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (cargarMYQSL != null) {
                System.out.println(new CargarObjetosMYQSL().cargarTexto(cargarMYQSL, tipoObjetoCargar));
            } else {
                noCargo[i] = "ERROR-->" + cargarObjetos[i];
            }
        }
    }

    //fin cargar texto
    // verificar contenido
    private String[] verificar(String verificar) {
        String[] verificarObjeto = verificar.split("\\(");
        if (verificarObjeto.length == 2 && tipoObjeto(verificarObjeto[0])) {
            if (condicionesDeTablaMYQSL(verificarObjeto[1])) {
                return verificarObjeto[1].split(",");
            }
        }
        return null;
    }

    //fin verificar contenido
    private boolean tipoObjeto(String ver) {
        ListadoPalabrasClasvesCargarArchivo[] listado = ListadoPalabrasClasvesCargarArchivo.values();
        for (int i = 0; i < listado.length; i++) {
            if (ver.equalsIgnoreCase(listado[i].getNombre())) {
                tipoObjetoCargar = listado[i];
                return true;
            }
        }
        return false;
    }

    private boolean condicionesDeTablaMYQSL(String ver) {
        String[] atributos = ver.split(",");
        VerificadorTexto usar = new VerificadorTexto();
        switch (tipoObjetoCargar) {
            case MUEBLE:
                return (atributos.length == 2) && usar.verificarVarchar(atributos[0]) && usar.verificarEsNumero(atributos[1]);
        }
        return false;
    }
}
