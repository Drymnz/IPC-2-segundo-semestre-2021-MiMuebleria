/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1;

import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.BuscadorExistencialPK;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;
import java.sql.SQLException;

/**
 *
 * @author drymnz
 */
public class CLASSPRUEVAS {

    public static void main(String[] args) {
        //(new ManejadorConexionMYQSL(true)).getConexion()
        try {
            System.out.println("1.." + new BuscadorExistencialPK(new ManejadorConexionMYQSL(true).getConexion()).
                    tablaPKInt(
                    1, ListadoTabla.factura));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
