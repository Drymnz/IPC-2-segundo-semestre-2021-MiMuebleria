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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
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

    private final ManejadorConexionMYQSL coneccion = new ManejadorConexionMYQSL(true);

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
        System.out.println("tenes que liminar unas cosas");
        BuscadorExistencialPK buscador = new BuscadorExistencialPK(coneccion.getConexion());
        if ((buscador).tablaPKVarchar(request.getParameter("usuario"), ListadoTabla.usuario) && buscador.getEncontrado() != null) {
            Usuario encontre = (Usuario) buscador.getEncontrado();
            if (request.getParameter("password").equals(encontre.getPassword())) {
                switch (encontre.getTipo()) {
                    case 0:// administrado RECORDAR ELIMINAR ESTO SOLO ES PRUEVAS <--------------------
                        response.sendRedirect("resources/jsp/sub-finaciera-administracion/crear-usuario.jsp");
                        break;
                    case 1:// Fabrica
                        break;
                    case 2:// Venta
                        break;
                    case 3:// Finaciero
                        response.sendRedirect("resources/jsp/sub-finaciera-administracion/crear-usuario.jsp");
                        break;
                    default:
                        response.sendRedirect("../../index.jsp");
                        break;
                }
            }
        } else {
            response.sendRedirect("../../index.jsp");
        }
        coneccion.cerrarConexion();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("listadoUsuario")) {
            List<Usuario> re = new ArrayList<Usuario>();
            List<Usuario> p = (new ListadoFilasTabla(a.getConexion())).getTablaDB(ListadoTabla.usuario);
            request.setAttribute("listadoUsuario", p);
            request.getRequestDispatcher("resources/includes/tabla/usuario.jsp").forward(request, response);
        }
        /* RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);*/
    }

}
