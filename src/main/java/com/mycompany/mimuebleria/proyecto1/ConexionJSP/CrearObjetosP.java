/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.ConexionJSP;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Usuario;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarObjetoPrimitivo;
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
@WebServlet(name = "CrearObjetosP", urlPatterns = {"/resources/jsp/CrearObjetosP"})
public class CrearObjetosP extends HttpServlet {

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

        try {
            BuscadorExistencialPK buscador = new BuscadorExistencialPK(coneccion.getConexion());
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            if (!(buscador).tablaPKVarchar(nombre, ListadoTabla.usuario) && buscador.getEncontrado() == null & (!nombre.trim().equals("") && !password.trim().equals(""))) {
                int tipo = -1;
                switch (request.getParameter("tipo")) {
                    case "Fabrica":
                        tipo = 3;
                        break;
                    case "Venta":
                        tipo = 2;
                        break;
                    case "Finaciero":
                        tipo = 1;
                        break;
                }
                if (tipo != -1 && password.length() == 6) {
                    Usuario nuevo = new Usuario(nombre, password, tipo);
                    boolean cargoAlabase = (new CargarObjetoPrimitivo(coneccion.getConexion())).cargar(nuevo);
                }
            }
            coneccion.cerrarConexion();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        response.sendRedirect("sub-finaciera-administracion/crear-usuario.jsp");
    }
}
