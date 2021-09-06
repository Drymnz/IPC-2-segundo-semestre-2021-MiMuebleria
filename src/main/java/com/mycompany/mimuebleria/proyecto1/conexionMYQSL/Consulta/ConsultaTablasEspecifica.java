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
        List<Mueble> listadoMueble = (List<Mueble>) getTablaDB(ListadoTabla.mueble);
        List<EnsablePiezas> listadoEnsable = getTablaDB(ListadoTabla.ensablePieza);
        List<Pieza> listadoPiezasCantidad = getTablaContarDB(ListadoTabla.pieza, "tipo");
        // revisa si el mueble aun existe tanto como la piesa, tambien si hay mayor cantidad de piezas para construir
        for (Mueble mueble : listadoMueble) {
            List<EnsablePiezas> prueveas = muebleEnsablePiezaExiste(mueble, listadoEnsable);
            if (!prueveas.isEmpty() && estanTodasPiezas(prueveas, listadoPiezasCantidad)) {
                ensablePosiblesPieza = incrementarEnsablesDisponibles(ensablePosiblesPieza, prueveas);
            }
        }
        return ensablePosiblesPieza;
    }

    private List<EnsablePiezas> incrementarEnsablesDisponibles(List<EnsablePiezas> ensablePosiblesPieza, List<EnsablePiezas> añadir) {
        for (EnsablePiezas ensablePiezas : añadir) {
            ensablePosiblesPieza.add(ensablePiezas);
        }
        return ensablePosiblesPieza;
    }

    private boolean estanTodasPiezas(List<EnsablePiezas> prueveas, List<Pieza> listadoPiezasCantidad) {
        int contador = 0;
        for (Pieza pieza : listadoPiezasCantidad) {
            for (EnsablePiezas ensablePiezas : prueveas) {
                if (ensablePiezas.getPieza().getTipo().equals(pieza.getTipo()) && pieza.getCosto() >= ensablePiezas.getCantidadPiezas()) {
                    contador++;
                }
            }
        }
        return contador == prueveas.size();
    }

    public List<EnsablePiezas> muebleEnsablePiezaExiste(Mueble mueble, List<EnsablePiezas> listadoEnsablePieza) {
        List<EnsablePiezas> devolverEnsablePosiblesPieza = new ArrayList<EnsablePiezas>();
        for (EnsablePiezas ensablePiezas : listadoEnsablePieza) {
            if ((ensablePiezas.getMueble().getNombre().equals(mueble.getNombre()))) {
                devolverEnsablePosiblesPieza.add(ensablePiezas);
            }
        }
        return devolverEnsablePosiblesPieza;
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
