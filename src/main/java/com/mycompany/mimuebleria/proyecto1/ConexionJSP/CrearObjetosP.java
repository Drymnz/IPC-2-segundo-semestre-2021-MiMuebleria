/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.ConexionJSP;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarObjetoPrimitivo;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.BuscadorExistencialPK;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drymnz
 */
@WebServlet(name = "CrearObjetosP", urlPatterns = {"/resources/jsp/CrearObjetosP"})
public class CrearObjetosP extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ManejadorConexionMYQSL coneccion = new ManejadorConexionMYQSL(true);
        try {
            String realizar = request.getParameter("accion");
            if (!realizar.isEmpty()) {
                BuscadorExistencialPK buscador = new BuscadorExistencialPK(coneccion.getConexion());
                boolean loRealizo = false;
                switch (realizar) {
                    case "usuario":
                        loRealizo = crearUsuario(request, response, coneccion.getConexion(), buscador);
                        response.sendRedirect("../../ConexionJSP?accion=listadoUsuario&donde=resources/jsp/sub-finaciera-administracion/listado-usuarios.jsp");
                        break;
                    case "mueble":
                        loRealizo = crearMueble(request, response, coneccion.getConexion(), buscador);
                        response.sendRedirect("../../ConexionJSP?accion=listadoMueble&donde=resources/jsp/sub-finaciera-administracion/listado-mueble.jsp");
                        break;
                    case "pieza":
                        loRealizo = crearPieza(request, response, coneccion.getConexion(), buscador);
                        response.sendRedirect("../../ConexionJSP?accion=listadoPiezaYlistado-resumen&donde=/resources/jsp/sub-fabrica/listado-piezas.jsp");
                        break;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private boolean crearUsuario(HttpServletRequest request, HttpServletResponse response, Connection conexion, BuscadorExistencialPK buscador) {
        boolean creado = false;
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        if (!(buscador).tablaPKVarchar(nombre, ListadoTabla.usuario) && buscador.getEncontrado() == null & (!nombre.trim().equals("") && !password.trim().equals(""))) {
            int tipo = -1;
            switch (request.getParameter("tipo")) {
                case "Fabrica":
                    tipo = 1;
                    break;
                case "Venta":
                    tipo = 2;
                    break;
                case "Finaciero":
                    tipo = 3;
                    break;
            }
            if (tipo != -1 && password.length() == 6) {
                Usuario nuevo = new Usuario(nombre, password, tipo);
                creado = (new CargarObjetoPrimitivo(conexion)).cargar(nuevo);
            }
        }
        return creado;
    }

    private boolean crearMueble(HttpServletRequest request, HttpServletResponse response, Connection conexion, BuscadorExistencialPK buscador) {
        boolean creado = false;
        String tipo = request.getParameter("mueble");
        String precio = request.getParameter("precio");
        if (!(buscador).tablaPKVarchar(tipo, ListadoTabla.mueble) && buscador.getEncontrado() == null & (!tipo.trim().equals("") && !precio.trim().equals(""))) {
            float precioMueble = -1;
            try {
                precioMueble = Float.parseFloat(precio);
            } catch (Exception e) {
            }
            if (precioMueble >= 0) {
                Mueble nuevo = new Mueble(tipo, precioMueble);
                creado = (new CargarObjetoPrimitivo(conexion)).cargar(nuevo);
            }
        }
        return creado;
    }

    private boolean crearPieza(HttpServletRequest request, HttpServletResponse response, Connection conexion, BuscadorExistencialPK buscador) {
        boolean creado = false;
        String tipo = request.getParameter("tipo");
        String precio = request.getParameter("precio");
        String cantidad = request.getParameter("cantidad");
        float precioPieza = -1;
        int cantidadColocar = -1;
        try {
            cantidadColocar = Integer.parseInt(cantidad);
            precioPieza = Float.parseFloat(precio);
        } catch (Exception e) {
        }
        if (precioPieza >= 0 && cantidadColocar > 0) {
            Pieza nuevo = new Pieza(tipo, precioPieza);
            (new Thread((new CargarObjetoPrimitivo(conexion, cantidadColocar, nuevo)))).start();
            creado = true;
        }
        return creado;
    }
}
