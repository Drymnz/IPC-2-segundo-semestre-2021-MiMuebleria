/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.ConstruccionLibro;

import com.mycompany.mimuebleria.proyecto1.Objetos.EnsablePiezas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author drymnz
 */
public class Libro {

    public List listaLibro(List ensables) {
        List<String> regresar = new ArrayList<>();
        List<String> listadoMuebles = listadoMueblesDisponibles(ensables);
        for (String listadoMueble : listadoMuebles) {
            boolean primeraVez = true;
            String anadir = "";
            for (Object ensable : ensables) {
                EnsablePiezas informacion = (EnsablePiezas) ensable;
                if (listadoMueble.equals(informacion.getMueble().getNombre())) {
                    anadir += (((primeraVez) ? primeraOracion(informacion) : segundaOracion(informacion)));
                    primeraVez = false;
                }
            }
            regresar.add(anadir);
        }
        return regresar;
    }

    private String segundaOracion(EnsablePiezas referente) {
        return "\n<br>" + referente.getCantidadPiezas() + " de " + referente.getPieza().getTipo() + ", ";
    }

    private String primeraOracion(EnsablePiezas referente) {
        return "(" + referente.getMueble().getNombre()+")"
                + "\n<br>El  \" " + referente.getMueble().getNombre() + " \" tiene un precio de venta de Q" + referente.getMueble().getPrecio() + " , y necesita:"
                + "\n<br>" + referente.getCantidadPiezas() + " de " + referente.getPieza().getTipo() + ", ";
    }

    private List<String> listadoMueblesDisponibles(List ensables) {
        List<String> listadoMuebles = new ArrayList<String>();
        if (ensables != null) {
            for (Object ensable : ensables) {
                EnsablePiezas informacion = (EnsablePiezas) ensable;
                if (listadoMuebles.isEmpty()) {
                    listadoMuebles.add(informacion.getMueble().getNombre());
                } else {
                    String añadirString = "";
                    boolean añadir = false;
                    for (String listdomueble : listadoMuebles) {
                        añadir = ((listdomueble.equalsIgnoreCase(informacion.getMueble().getNombre()))) ? false : true;
                        añadirString = (añadir) ? (informacion.getMueble().getNombre()) : "";
                    }
                    if (!añadirString.isEmpty()) {
                        listadoMuebles.add(añadirString);
                    }
                }
            }
        }
        return listadoMuebles;
    }
}
