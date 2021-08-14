/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarObjetoPrimitivo;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;

/**
 *
 * @author drymnz
 */
public class CLASSPRUEVAS {
    
    public static void main(String[] args) {
        ManejadorConexionMYQSL s = new ManejadorConexionMYQSL(true);
        CargarObjetoPrimitivo p = new CargarObjetoPrimitivo(s.getConexion());
        Usuario prue = new Usuario("benjamin", "123456", 0);
        p.cargar(prue);
    }
}
