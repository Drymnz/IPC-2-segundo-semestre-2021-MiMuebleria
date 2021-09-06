/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.proyecto1.Objetos.primitivos;

/**
 *
 * @author Drymnz
 */
public class Cliente {

    private int id;
    private String nombre;
    private String NIT;
    private String direccion;
    private String municipio;
    private String departamento;

    //construcctor
    public Cliente(int id, String nombre, String NIT, String direccion, String municipio, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.NIT = NIT;
        this.direccion = direccion;
        this.municipio = municipio;
        this.departamento = departamento;
    }

    public Cliente(String nombre, String NIT, String direccion) {
        this(0, nombre, NIT, direccion, "", "");
    }

    public Cliente(String nombre, String NIT, String direccion, String municipio) {
        this(0, nombre, NIT, direccion, municipio, "");
    }
    public Cliente(String nombre, String NIT, String direccion, String municipio, String departamento) {
        this(0, nombre, NIT, direccion, municipio, departamento);
    }
    //fin construcctor

    // get
    public String getNombre() {
        return nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getDepartamento() {
        return departamento;

    }

    public int getId() {
        return id;
    }
    // fin get

    //set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setId(int id) {
        this.id = id;
    }
    //fin set

}
