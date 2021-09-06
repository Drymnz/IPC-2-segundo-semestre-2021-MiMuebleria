/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta;

import com.mycompany.mimuebleria.proyecto1.Objetos.EnsablePiezas;
import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author drymnz
 */
public class BuscadorExistencialPK<T> {

    private Connection conexion;
    private ResultSet resultado;
    private PreparedStatement buscar;
    private T encontrado;

    //constructor
    public BuscadorExistencialPK(Connection conexion) {
        this.conexion = conexion;
    }

    //fin constructor
    public boolean tablaPKVarchar(String nombre, ListadoTabla verificar) {
        String columna = verificar.getPk();
        try {
            switch (verificar) {
                case usuario:
                    buscar = conexion.prepareStatement("select * from usuario WHERE nombre=?");
                    break;
                case pieza:
                    buscar = conexion.prepareStatement("select * from pieza WHERE tipo=?");
                    columna = "tipo";
                    break;
                case mueble:
                    buscar = conexion.prepareStatement("select * from mueble WHERE nombre=?");
                    break;
            }
            buscar.setString(1, nombre);
            resultado = buscar.executeQuery();
            resultado.next();
            if (resultado.getString(columna).equalsIgnoreCase(nombre)) {
                encontro(verificar, this.resultado);
                return true;
            }
        } catch (SQLException e) {
            System.out.println("BuscadorExistencialPK" + e.getMessage());

        } catch (Exception e) {
            System.out.println("BuscadorExistencialPK" + e.getMessage());
        }
        return false;
    }

    public boolean tablaPKInt(int numero, ListadoTabla verificar) {
        try {
            switch (verificar) {
                case pieza:
                    buscar = conexion.prepareStatement("select * from pieza WHERE id=?");
                    break;
                case cliente:
                    buscar = conexion.prepareStatement("select * from cliente WHERE id=?");
                    break;
                case factura:
                    buscar = conexion.prepareStatement("select * from factura WHERE codigo=?");
                    break;
            }
            buscar.setInt(1, numero);
            resultado = buscar.executeQuery();
            resultado.next();
            if (resultado.getInt(verificar.getPk()) == numero) {
                encontro(verificar, this.resultado);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("BuscadorExistencialPK" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("BuscadorExistencialPK" + e.getMessage());
        }
        return false;
    }

    public T encontro(ListadoTabla verificar, ResultSet resultadoSET) throws SQLException {
        switch (verificar) {
            case ensablePieza:
                BuscadorExistencialPK buscar = new BuscadorExistencialPK(conexion);
                Mueble encontradoMueblePieza = (buscar.tablaPKVarchar(resultadoSET.getString("mueble"), ListadoTabla.mueble)) ? ((Mueble) buscar.getEncontrado()) : new Mueble(resultadoSET.getString("mueble"), 0);
                Pieza piezaEnsablePieza = (buscar.tablaPKVarchar(resultadoSET.getString("pieza"), ListadoTabla.pieza)) ? ((Pieza) buscar.getEncontrado()) : new Pieza(resultadoSET.getString("pieza"), 0);
                int cantidadPieza = resultadoSET.getInt("cantidad");
                encontrado = (T) new EnsablePiezas(encontradoMueblePieza, piezaEnsablePieza, cantidadPieza);
                break;
            case mueble:
                String nombreMueble = resultadoSET.getString("nombre");
                float precioMueble = resultadoSET.getFloat("precio");
                encontrado = (T) new Mueble(nombreMueble, precioMueble);
                break;
            case pieza:
                int idPieza = resultadoSET.getInt("id");
                String tipoPieza = resultadoSET.getString("tipo");
                float precio = resultadoSET.getFloat("precio");
                encontrado = (T) new Pieza(idPieza, tipoPieza, precio);
                break;
            case usuario:
                String nombre = resultadoSET.getString("nombre");
                String password = resultadoSET.getString("password");
                int tipo = resultadoSET.getInt("tipo");
                encontrado = (T) new Usuario(nombre, password, tipo);
                break;
        }
        return encontrado;
    }

    // get de lo que obtuvo en la busqueda
    public T getEncontrado() {
        return encontrado;
    }

}
