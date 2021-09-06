/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.ConexionJSP;

import com.mycompany.mimuebleria.proyecto1.Objetos.EnsablePiezas;
import com.mycompany.mimuebleria.proyecto1.Objetos.SalaVenta;
import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.Ajustar;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarEnsable;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Cargar.CargarObjetosTienda;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.BuscadorExistencialPK;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.ConsultaTablasEspecifica;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta.ListadoFilasTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ManejadorConexionMYQSL;
import java.io.IOException;
import java.time.LocalDate;
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
                    if (buscador.tablaPKVarchar(request.getParameter("tipo-pieza"), ListadoTabla.pieza)) {
                        Pieza piezasEnsblePieza = (Pieza) buscador.getEncontrado();
                        buscador.tablaPKVarchar(request.getParameter("tipo-mueble"), ListadoTabla.mueble);
                        Mueble muebleArmar = (Mueble) buscador.getEncontrado();
                        try {
                            int cantidad = Integer.parseInt(request.getParameter("cantidad-piezas"));
                            cargo = (new CargarEnsable(coneccion.getConexion())).cargarEnsablePiezas(piezasEnsblePieza, muebleArmar, cantidad);
                            response.sendRedirect("ConexionJSP?accion=listadoEnsablePieza&donde=resources/jsp/sub-finaciera-administracion/listado-ensable-pieza.jsp");
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "mueble":
                    String mueble = request.getParameter("tipo-mueble").replaceAll("\\(", "");
                    if (buscador.tablaPKVarchar(mueble, ListadoTabla.mueble)) {
                        Mueble encontrado = (Mueble) buscador.getEncontrado();
                        if (buscador.tablaPKVarchar(request.getParameter("usuario"), ListadoTabla.usuario)) {
                            boolean todoBien = false;
                            Usuario ensablador = (Usuario) buscador.getEncontrado();
                            List<Pieza> piezasUsadas = new ArrayList<>();
                            List<Pieza> piezasDisponibles = new ListadoFilasTabla(coneccion.getConexion()).getTablaDB(ListadoTabla.pieza);
                            List<EnsablePiezas> listadoEnsables = (new ConsultaTablasEspecifica(coneccion.getConexion())).muebleEnsablePiezaExiste(encontrado, (new ListadoFilasTabla(coneccion.getConexion()).getTablaDB(ListadoTabla.ensablePieza)));
                            for (EnsablePiezas listadoEnsable : listadoEnsables) {
                                try {
                                    for (int i = 0; i < listadoEnsable.getCantidadPiezas(); i++) {
                                        boolean seguir = true;
                                        int j = 0;
                                        while (seguir) {
                                            Pieza revisar = piezasDisponibles.get(j);
                                            if (revisar.getTipo().equals(listadoEnsable.getPieza().getTipo())) {
                                                piezasUsadas.add(revisar);
                                                piezasDisponibles.remove(revisar);
                                                seguir = false;
                                            }
                                            j++;
                                        }
                                    }
                                    todoBien = true;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            if (todoBien) {

                                request.setAttribute("mueble", encontrado);
                                if (new CargarEnsable(coneccion.getConexion()).cargarEnsableMueble(encontrado, ensablador, LocalDate.now())) {
                                    int precioTotal = 0;
                                    for (Pieza piezasUsada : piezasUsadas) {
                                        precioTotal+= piezasUsada.getCosto();
                                        (new Ajustar(coneccion.getConexion())).eliminarPK(ListadoTabla.pieza, piezasUsada);
                                    }
                                    (new CargarObjetosTienda(coneccion.getConexion())).cargarSalaVenta(new SalaVenta(mueble, precioTotal));
                                }
                                request.setAttribute("listado", piezasUsadas);
                                response.sendRedirect("/resources/jsp/sub-fabrica/resultado-mueble-ensablado.jsp");
                            } else {
                                response.sendRedirect("index.jsp");
                            }
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
