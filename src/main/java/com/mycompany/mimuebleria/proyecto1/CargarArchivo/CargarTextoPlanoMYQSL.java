/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.CargarArchivo;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarObjetoPrimitivo;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;

/**
 *
 * @author drymnz
 */
public class CargarTextoPlanoMYQSL {

    // constructor
    public CargarTextoPlanoMYQSL() {
    }

    // fin constructor
    public boolean cargarTexto(String[] texto, ListadoTabla tipo) {
        switch (tipo) {
            case mueble:
                Mueble cargarMueble = new Mueble(texto[0], Float.valueOf(texto[1]));
                return (new CargarObjetoPrimitivo((new ManejadorConexionMYQSL(true)).getConexion())).cargar(cargarMueble);
            case usuario:
                Usuario cargarUsuario = new Usuario(texto[0], texto[1], Integer.parseUnsignedInt(texto[2]));
                return (new CargarObjetoPrimitivo((new ManejadorConexionMYQSL(true)).getConexion())).cargar(cargarUsuario);
            case pieza:
                Pieza cargarPieza = new Pieza(texto[0], Float.valueOf(texto[1]));
                return (new CargarObjetoPrimitivo((new ManejadorConexionMYQSL(true)).getConexion())).cargar(cargarPieza);
            case cliente:
                break;
        }
        return false;
    }
}
