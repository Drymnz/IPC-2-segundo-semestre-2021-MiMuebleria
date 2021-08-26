/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Usuario;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.ListadoFilasTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author drymnz
 */
public class CLASSPRUEVAS<T> {

    public static ManejadorConexionMYQSL a = new ManejadorConexionMYQSL(true);

    public static void main(String[] args) {

        List<Usuario> listado = new CLASSPRUEVAS().fads();
        for (Usuario usuario : listado) {
            System.out.println(usuario.getNombre() + "----" + usuario.getPassword());
        }

        //(new ManejadorConexionMYQSL(true)).getConexion()
        /* 
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
        d.cargar();*/

 /*System.out.println("los atributos son");
        for (int i = 0; i < b.length; i++) {
        b[i] = b[i].replaceAll("\"", "");
        System.out.println("-------------->" + b[i]);
        System.out.println("numero------->" + new VerificadorTexto().verificarEsNumero(b[i]));
        System.out.println("varchar------->" + new VerificadorTexto().verificarVarchar(b[i]));
        System.out.println("date------->" + new VerificadorTexto().verificarDate(b[i]));
        }*/
    }

    public List<Usuario> fads() {
        List<Usuario> re = new ArrayList<Usuario>();
        List<T> p = (new ListadoFilasTabla(a.getConexion())).getTablaDB(ListadoTabla.usuario);
        for (T t : p) {
            re.add((Usuario) t);
        }
        return re;
    }
}
