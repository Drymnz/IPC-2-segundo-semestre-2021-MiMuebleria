/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.VerificadorTexto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author drymnz
 */
public class VerificadorTexto {

    //constructor
    public VerificadorTexto() {
    }

    //fin constructor
    // verificadores
    public boolean verificarEsNumero(String verifcar) {
        return verificador("[0-9]+", verifcar);
    }

    public boolean verificarSimbolo(String verificar) {
        return verificador("[^A-Za-z0-9]+", verificar);
    }

    public boolean verificarVarchar(String verificar) {
        return verificador("[\"]?[A-Za-z0-9]+[\"]?", verificar);
    }

    public boolean verificarFecha(String verificar) {
        return verificador("[\"]?[0-9]{4}[^A-Za-z0-9][0|1]?[0-9][^A-Za-z0-9][0-3]?[0-9][\"]?", verificar);
    }

    // fin verificadores
    // usando 
    public boolean verificador(String parametro, String verificar) {
        Pattern objetoparametro = Pattern.compile(parametro);
        Matcher analizador = objetoparametro.matcher(verificar);
        return analizador.matches();
    }

}
