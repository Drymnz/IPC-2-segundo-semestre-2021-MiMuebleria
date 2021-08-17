/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1;

import com.mycompany.mimuebleria.proyecto1.CargarArchivo.CargarObjetosMYQSL;
import com.mycompany.mimuebleria.proyecto1.CargarArchivo.CargardorMasivo;
import com.mycompany.mimuebleria.proyecto1.CargarArchivo.OrdenarTexto;
import com.mycompany.mimuebleria.proyecto1.VerificadorTexto.VerificadorTexto;
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
        CargarObjetosMYQSL a = new CargarObjetosMYQSL();
        CargardorMasivo d = new CargardorMasivo("ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "USUARIO(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "MUEBLE(\"clasico\",15)"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_pieza(\"clasico\",15,\"2018/5/24\")"
                + "USUARIO(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "ENSABLAR_MUEBLE(\"clasico\",15,\"2018/5/24\")"
                + "pieza(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "PIEZA(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "ensablar_mueble(\"clasico\",15,\"2018/5/24\")"
                + "");
        d.cargar();
        
        /*System.out.println("los atributos son");
        for (int i = 0; i < b.length; i++) {
        b[i] = b[i].replaceAll("\"", "");
        System.out.println("-------------->" + b[i]);
        System.out.println("numero------->" + new VerificadorTexto().verificarEsNumero(b[i]));
        System.out.println("varchar------->" + new VerificadorTexto().verificarVarchar(b[i]));
        System.out.println("date------->" + new VerificadorTexto().verificarDate(b[i]));
        }*/
    }
}
