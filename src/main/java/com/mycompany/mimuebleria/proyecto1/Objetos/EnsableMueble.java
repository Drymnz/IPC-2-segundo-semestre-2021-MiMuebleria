/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.Objetos;

import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Mueble;
import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.Usuario;
import java.time.LocalDate;

/**
 *
 * @author drymnz
 */
public class EnsableMueble {
     private Mueble mueble;
    private Usuario ensablador;
    private LocalDate fecha;
    // constructor
    public EnsableMueble(Mueble mueble, Usuario ensablador, LocalDate fecha) {
        this.mueble = mueble;
        this.ensablador = ensablador;
        this.fecha = fecha;
    }
    // fin constructor
    // get y set
    public Mueble getMueble() {
        return mueble;
    }
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }
    public Usuario getEnsablador() {
        return ensablador;
    }
    public void setEnsablador(Usuario ensablador) {
        this.ensablador = ensablador;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    //fin get y set
}
