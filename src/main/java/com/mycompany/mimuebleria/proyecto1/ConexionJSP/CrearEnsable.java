/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.ConexionJSP;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarEnsable;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.BuscadorExistencialPK;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drymnz
 */
@WebServlet(name = "CrearEnsable", urlPatterns = {"/CrearEnsable"})
public class CrearEnsable extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

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
        String accion = request.getParameter("ensamble");
        if (!accion.isEmpty()) {
            ManejadorConexionMYQSL coneccion = new ManejadorConexionMYQSL(true);
            BuscadorExistencialPK buscador = new BuscadorExistencialPK(coneccion.getConexion());
            boolean cargo = false;
            switch (accion) {
                case "pieza":
                    buscador.tablaPKVarchar(request.getParameter("tipo-pieza"), ListadoTabla.pieza);
                    if (true) {
                        Pieza piezasEnsblePieza = (Pieza) buscador.getEncontrado();
                        buscador.tablaPKVarchar(request.getParameter("tipo-mueble"), ListadoTabla.mueble);
                        Mueble muebleArmar = (Mueble) buscador.getEncontrado();
                        try {
                            int cantidad = Integer.parseInt(request.getParameter("cantidad-piezas"));
                            cargo = (new CargarEnsable(coneccion.getConexion())).cargarEnsablePiezas(piezasEnsblePieza, muebleArmar, cantidad);
                            response.sendRedirect("ConexionJSP?accion=listado-una-columna-menu-crear-finaciero&donde=resources/jsp/sub-finaciera-administracion/crear.jsp");
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                default:
                    response.sendRedirect("index.jsp");
                    throw new AssertionError();
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

}
