/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.ConexionJSP;

import com.mycompany.mimuebleria.proyecto1.CargarArchivo.CargadorMasivoTextoPlano;
import static com.mysql.cj.conf.PropertyKey.PATH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author drymnz
 */
@WebServlet(name = "ManejadorArchivo", urlPatterns = {"/ManejadorArchivo"})
public class ManejadorArchivo extends HttpServlet {

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
        Part filePart = request.getPart("datafile");
        String fileName = filePart.getName();
        InputStream fileStream = filePart.getInputStream();
        List noCargoBase = new ArrayList<String>();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(fileStream))) {
            String line = in.readLine();
            while (line != null) {
                String[] noCargo = (new CargadorMasivoTextoPlano(line)).getNoCargo();
                for (String string : noCargo) {
                    if (string != null && !string.isEmpty()) {
                        noCargoBase.add(string);
                    }
                }
                line = in.readLine();
            }
        } catch (Exception ex) {
            // no pudo leer el archivo
        }
    }
}
