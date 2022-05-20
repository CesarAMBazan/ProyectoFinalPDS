package com.sidphillips.modelo;

import java.util.ArrayList;

/**
 * @author Cesar Arturo Mejia Bazan - 2182005565
 * @author Enrique Ramirez Martinez - 2182000079
 * @author Rojas Piña Efraín Ulises - 2172001457
 */
public class ProductoAcademico {
    /**
     * Atributos de la clase
     */
    private String nombre;
    private ArrayList<Seccion> seccionesFormato;
    private ArrayList<String> seccionesPA;

    /**
     * Constructor
     */
    public ProductoAcademico() {
    }

    /**
     * Getters y Setters
     */
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

    /**
     * Método toString
     */
    @Override
    public String toString() {
        return "El nombre del archivo es: " + nombre
                + "con secciones: \n" + seccionesPA;
    }
}
