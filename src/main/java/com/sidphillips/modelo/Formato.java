package com.sidphillips.modelo;

import java.util.ArrayList;

/**
 * @author Cesar Arturo Mejia Bazan - 2182005565
 * @author Enrique Ramirez Martinez - 2182000079
 * @author Rojas Piña Efraín Ulises - 2172001457
 */
public class Formato {
    /**
     * Atributos de la clase
     */
    private String nombreArchivo;
    private ArrayList<Seccion> secciones;

    /**
     * Constructores
     */
    public Formato() {
    }

    public Formato(String nombreArchivo, ArrayList<Seccion> secciones) {
        this.nombreArchivo = nombreArchivo;
        this.secciones = secciones;
    }

    /**
     * Getters y Setters
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(ArrayList<Seccion> secciones) {
        this.secciones = secciones;
    }

    /**
     * Método toString
     */
    @Override
    public String toString() {
        return "El nombre del archivo es: " + nombreArchivo + " \nCon secciones: \n";
    }

}
