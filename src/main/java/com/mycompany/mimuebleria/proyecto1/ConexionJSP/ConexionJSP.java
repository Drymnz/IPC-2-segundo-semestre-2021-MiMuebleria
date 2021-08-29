/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.ConexionJSP;

import static com.mycompany.mimuebleria.proyecto1.CLASSPRUEVAS.a;
import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Usuario;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.BuscadorExistencialPK;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.ListadoFilasTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drymnz
 */
@WebServlet(name = "ConexionJSP", urlPatterns = {"/ConexionJSP"})
public class ConexionJSP extends HttpServlet {

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
        BuscadorExistencialPK buscador = new BuscadorExistencialPK(coneccion.getConexion());
        if ((buscador).tablaPKVarchar(request.getParameter("usuario"), ListadoTabla.usuario) && buscador.getEncontrado() != null) {
            Usuario encontre = (Usuario) buscador.getEncontrado();
            if (request.getParameter("password").equals(encontre.getPassword())) {
                switch (encontre.getTipo()) {
                    case 1:// Fabrica
                        response.sendRedirect("resources/jsp/sub-fabrica/pieza.jsp");
                        break;
                    case 2:// Venta
                        break;
                    case 3:// Finaciero
                        request.getMethod();
                        request.setAttribute("accion", "listado-una-columna-menu-crear-finaciero");
                        request.setAttribute("donde", "resources/jsp/sub-finaciera-administracion/crear.jsp");
                        response.sendRedirect("ConexionJSP?accion=listado-una-columna-menu-crear-finaciero&donde=resources/jsp/sub-finaciera-administracion/crear.jsp");
                        break;
                    default:
                        response.sendRedirect("../../index.jsp");
                        break;
                }
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {
            if (!accion.isEmpty()) {
                List<Object> ListadoCompleto = new ArrayList<Object>();
                List<Object> Distinto = new ArrayList<Object>();
                switch (accion) {
                    case "listadoUsuario":
                        ListadoCompleto = (new ListadoFilasTabla(a.getConexion())).getTablaDB(ListadoTabla.usuario);
                        accion = "usuario";
                        break;
                    case "listadoPieza":
                        ListadoCompleto = (new ListadoFilasTabla(a.getConexion())).getTablaDB(ListadoTabla.pieza);
                        accion = "pieza";
                    case "listadoPiezaYlistado-resumen":
                        ListadoCompleto = (new ListadoFilasTabla(a.getConexion())).getTablaDB(ListadoTabla.pieza);
                        Distinto = (new ListadoFilasTabla(a.getConexion())).getTablaDistintoDB(ListadoTabla.pieza, "tipo,precio");
                        accion = "pieza";
                        request.setAttribute("listado-resumen", Distinto);
                        break;
                    case "listadoMueble":
                        ListadoCompleto = (new ListadoFilasTabla(a.getConexion())).getTablaDB(ListadoTabla.mueble);
                        accion = "mueble";
                        break;
                    case "listado-una-columna-menu-crear-finaciero":
                        ListadoCompleto = (new ListadoFilasTabla(a.getConexion())).getTablaColumnatoDB(ListadoTabla.mueble, "nombre", false, "nombre");
                        Distinto = (new ListadoFilasTabla(a.getConexion())).getTablaColumnatoDB(ListadoTabla.pieza, "tipo,precio", true, "tipo");
                        request.setAttribute("listado-resumen", Distinto);
                        break;
                }
                if (!ListadoCompleto.isEmpty()) {
                    request.setAttribute("listado", ListadoCompleto);
                    request.setAttribute("nombreListado", accion);
                    request.getRequestDispatcher(request.getParameter("donde")).forward(request, response);
                }

            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
