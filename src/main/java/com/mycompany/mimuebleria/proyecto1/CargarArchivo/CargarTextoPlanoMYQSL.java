/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.CargarArchivo;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarEnsable;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarObjetoPrimitivo;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;
import java.time.LocalDate;

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
        try {
            switch (tipo) {
                case usuario:
                    Usuario cargarUsuario = new Usuario(texto[0], texto[1], Integer.parseUnsignedInt(texto[2]));
                    return (new CargarObjetoPrimitivo((new ManejadorConexionMYQSL(true)).getConexion())).cargar(cargarUsuario);
                case pieza:
                    Pieza cargarPieza = new Pieza(texto[0], Float.valueOf(texto[1]));
                    return (new CargarObjetoPrimitivo((new ManejadorConexionMYQSL(true)).getConexion())).cargar(cargarPieza);
                case mueble:
                    Mueble cargarMueble = new Mueble(texto[0], Float.valueOf(texto[1]));
                    return (new CargarObjetoPrimitivo((new ManejadorConexionMYQSL(true)).getConexion())).cargar(cargarMueble);
                case ensablePieza:
                    return (new CargarEnsable(new ManejadorConexionMYQSL(true).getConexion())).cargarEnsablePiezas(new Pieza(texto[1], 0), new Mueble(texto[0], 0), Integer.parseUnsignedInt(texto[2]));
                case ensableMueble:
                    return (new CargarEnsable(new ManejadorConexionMYQSL(true).getConexion())).cargarEnsableMueble(new Mueble(texto[0], 0), new Usuario(texto[1], "", 1), Fecha_String_A_Int(texto[2], "/"));
                case cliente:
                    Cliente cargarCliente = (texto.length == 3) ? new Cliente(texto[0], texto[1], texto[2]) : (texto.length == 4) ? new Cliente(texto[0], texto[1], texto[2], texto[3]) : new Cliente(texto[0], texto[1], texto[2], texto[3], texto[4]);
                    return (new CargarObjetoPrimitivo((new ManejadorConexionMYQSL(true)).getConexion())).cargar(cargarCliente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static LocalDate Fecha_String_A_Int(String Convertir, String Separador) {
        String Divirdir[] = Convertir.split(Separador);
        int Dia = Integer.parseInt(Divirdir[0]);
        int Mes = Integer.parseInt(Divirdir[1]);
        int A = Integer.parseInt(Divirdir[2]);
        return LocalDate.of(A, Mes, Dia);
    }
}
