/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.conexionMYQSL.Consulta;

import com.mycompany.mimuebleria.proyecto1.Objetos.EnsablePiezas;
import com.mycompany.mimuebleria.proyecto1.Objetos.primitivos.*;
import com.mycompany.mimuebleria.proyecto1.conexionMYQSL.ListadoTabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author drymnz
 */
public class ConsultaTablasEspecifica extends ListadoFilasTabla {
    
    public ConsultaTablasEspecifica(Connection conexion, ResultSet resultado, PreparedStatement buscar) {
        super(conexion, resultado, buscar);
    }
    
    public ConsultaTablasEspecifica(Connection conexion) {
        super(conexion, null, null);
    }
    
    public List getListadoDisponiblesConstruccionEnsableMueble() {
        List<EnsablePiezas> ensablePosiblesPieza = new ArrayList<EnsablePiezas>();
        List<EnsablePiezas> noMaterialSuficiente = new ArrayList<EnsablePiezas>();
        List<Mueble> listadoMueble = (List<Mueble>) getTablaDB(ListadoTabla.mueble);
        List<EnsablePiezas> listadoEnsable = getTablaDB(ListadoTabla.ensablePieza);
        List<Pieza> listadoPiezasCantidad = getTablaContarDB(ListadoTabla.pieza, "tipo");
        // revisa si el mueble aun existe tanto como la piesa, tambien si hay mayor cantidad de piezas para construir
        if (!listadoEnsable.isEmpty()) {
            for (EnsablePiezas ensablePiezas : listadoEnsable) {
                for (Mueble mueble : listadoMueble) {
                    if (ensablePiezas.getMueble().getNombre().equalsIgnoreCase(mueble.getNombre())) {
                        for (Pieza pieza : listadoPiezasCantidad) {
                            if (ensablePiezas.getPieza().getTipo().equalsIgnoreCase(pieza.getTipo()) && pieza.getCosto() >= ensablePiezas.getCantidadPiezas()) {
                                ensablePosiblesPieza.add(ensablePiezas);
                            } else if (pieza.getCosto() < ensablePiezas.getCantidadPiezas()) {
                                noMaterialSuficiente.add(ensablePiezas);
                            }
                        }
                    }
                }
            }
            if (!noMaterialSuficiente.isEmpty()) {
                for (EnsablePiezas ensablePiezas : noMaterialSuficiente) {
                    for (EnsablePiezas ensablePiezas1 : ensablePosiblesPieza) {
                        if (ensablePiezas.getMueble().getNombre() == ensablePiezas1.getMueble().getNombre()) {
                            ensablePosiblesPieza.remove(ensablePiezas1);
                        }
                    }
                }
            }
        }
        return ensablePosiblesPieza;
    }
    
    @Override
    public List getTablaDB(ListadoTabla cual) {
        return super.getTablaDB(cual); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List getTablaContarDB(ListadoTabla cual, String columna) {
        return super.getTablaContarDB(cual, columna); //To change body of generated methods, choose Tools | Templates.
    }
    
}
