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

    private String numero = "\\d";

    //constructor
    public VerificadorTexto() {
    }
    //fin constructor
    // verificadores
    public boolean verificarEsNumero(String verifcar){
        if (verificador(numero, verifcar)) {
            return true;
        }else{
            return false;
        }
    }
    // fin verificadores
    // usando 
    public boolean verificador(String parametro, String verificar){
        Pattern objetoparametro = Pattern.compile(parametro);
        Matcher analizador = objetoparametro.matcher(verificar);
        return analizador.matches();
    }
}
