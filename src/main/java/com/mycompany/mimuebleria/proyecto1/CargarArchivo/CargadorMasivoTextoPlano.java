/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.CargarArchivo;

import com.mycompany.mimuebleria.proyecto1.VerificadorTexto.VerificadorTexto;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;

/**
 *
 * @author drymnz
 */
public class CargadorMasivoTextoPlano {

    private String cargar;
    private String[] noCargo;
    private ListadoTabla tipoObjetoCargar;

    //constructor
    public CargadorMasivoTextoPlano(String cargar) {
        this.cargar = cargar;
        cargar();
    }

    //fin constructor
    //cargar texto
    private void cargar() {
        String[] cargarObjetos = (new OrdenarTexto(cargar)).componerTexto();
        noCargo = new String[cargarObjetos.length];
        for (int i = 0; i < cargarObjetos.length; i++) {
            String[] cargarMYQSL = null;
            boolean cargo = false;
            try {
                cargarMYQSL = verificar(cargarObjetos[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (cargarMYQSL != null) {
                cargo = (new CargarTextoPlanoMYQSL().cargarTexto(cargarMYQSL, tipoObjetoCargar));
            } else if (!cargarObjetos[i].isEmpty() && !cargo && !(cargarObjetos[i].equals("null"))) {
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
        ListadoTabla[] listado = ListadoTabla.values();
        for (ListadoTabla listadoTabla : listado) {
            if (!listadoTabla.getPalabraClaveCargaArchivo().isEmpty() && listadoTabla.getPalabraClaveCargaArchivo().equalsIgnoreCase(ver)) {
                tipoObjetoCargar = listadoTabla;
                return true;
            }
        }
        return false;
    }

    private boolean condicionesDeTablaMYQSL(String ver) {
        ver = ver.replaceAll("\"", "");
        String[] atributos = ver.split(",");
        VerificadorTexto usar = new VerificadorTexto();
        switch (tipoObjetoCargar) {
            case pieza:
                return (atributos.length == 2) && usar.verificarEsNumero(atributos[1]);
            case usuario:
                return (atributos.length == 3) && usar.verificarEsNumero(atributos[2]);
            case ensablePieza:
                return (atributos.length == 3) && usar.verificarEsNumero(atributos[2]);
            case ensableMueble:
                return (atributos.length == 3) && usar.verificarFecha(atributos[2]);
            case cliente:
                return (atributos.length >= 3 && atributos.length <= 5);
            case mueble:
                return (atributos.length == 2) && usar.verificarEsNumero(atributos[1]);
        }
        return false;
    }

    public String[] getNoCargo() {
        return noCargo;
    }

}
