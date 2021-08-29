/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.ConexionJSP;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Pieza;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.Ajustar;
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
@WebServlet(name = "Modificar", urlPatterns = {"/Modificar"})
public class Modificar extends HttpServlet {

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
        String accion = request.getParameter("accion");
        if (!accion.isEmpty()) {
            ManejadorConexionMYQSL coneccion = new ManejadorConexionMYQSL(true);
            BuscadorExistencialPK lo = new BuscadorExistencialPK(coneccion.getConexion());
            Ajustar relizar = new Ajustar(coneccion.getConexion());
            boolean fueRealizado = false;
            switch (accion) {
                case "ventana":
                    String idPiezaModificar = request.getParameter("modificar");
                    if (lo.tablaPKInt(Integer.parseInt(idPiezaModificar), ListadoTabla.pieza)) {
                        Pieza mandar = (Pieza) lo.getEncontrado();
                        request.setAttribute("modificar", mandar);
                        request.getRequestDispatcher(request.getParameter("donde")).forward(request, response);
                    }
                    break;
                case "eliminar-pieza":
                    String idPieza = request.getParameter("modificar");
                    if (lo.tablaPKInt(Integer.parseInt(idPieza), ListadoTabla.pieza)) {
                        Pieza mandar = (Pieza) lo.getEncontrado();
                        fueRealizado = relizar.eliminarPK(ListadoTabla.pieza, mandar);
                        request.getRequestDispatcher(request.getParameter("donde")).forward(request, response);
                    }
                    break;
            }
        }

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

        String accion = request.getParameter("accion");
        if (!accion.isEmpty()) {
            ManejadorConexionMYQSL coneccion = new ManejadorConexionMYQSL(true);
            Ajustar relizar = new Ajustar(coneccion.getConexion());
            BuscadorExistencialPK lo = new BuscadorExistencialPK(coneccion.getConexion());
            boolean fueRealizado = false;
            switch (accion) {
                case "modificar-pieza":
                    String idPiezaModificar1 = request.getParameter("ajustar");
                    String tipoPiez = request.getParameter("tipo");
                    int costoPieza = Integer.valueOf(request.getParameter("costo"));
                    if (lo.tablaPKInt(Integer.parseInt(idPiezaModificar1), ListadoTabla.pieza) && !tipoPiez.isEmpty() && costoPieza > 0) {
                        Pieza mandar = (Pieza) lo.getEncontrado();
                        Pieza como = new Pieza(tipoPiez, costoPieza);
                        fueRealizado = relizar.modificarPK(ListadoTabla.pieza, mandar, como);
                    }
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;

            }
        }

    }

}
