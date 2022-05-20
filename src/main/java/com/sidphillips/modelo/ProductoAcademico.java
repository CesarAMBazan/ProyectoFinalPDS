/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sidphillips.modelo;

import java.util.ArrayList;

/**
 *
 * @author Zerol
 */
public class ProductoAcademico {
    private String nombre;
    private ArrayList<Seccion> seccionesFormato;
    private ArrayList<String> seccionesPA;

    public ProductoAcademico() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Seccion> getSeccionesFormato() {
        return seccionesFormato;
    }

    public void setSeccionesFormato(ArrayList<Seccion> seccionesFormato) {
        this.seccionesFormato = seccionesFormato;
    }

    public ArrayList<String> getSeccionesPA() {
        return seccionesPA;
    }

    public void setSeccionesPA(ArrayList<String> seccionesPA) {
        this.seccionesPA = seccionesPA;
    }
    
    @Override
    public String toString()
    {
        return "El nombre del archivo es: " + nombre 
                + "con secciones: \n" + seccionesPA;
    }
}
