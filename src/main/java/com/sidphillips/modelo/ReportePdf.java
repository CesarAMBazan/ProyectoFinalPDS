package com.sidphillips.modelo;

import java.util.ArrayList;

/**
 * @author Cesar Arturo Mejia Bazan - 2182005565
 * @author Enrique Ramirez Martinez - 2182000079
 * @author Rojas Piña Efraín Ulises - 2172001457
 */
public class ReportePdf {
    /**
     * Atributos de la clase
     */
    private ArrayList<Seccion> seccionPA;
    private String nombrePA;
    private String rutaDestino;

    /**
     * Constructor
     */
    public ReportePdf() {
    }

    /**
     * Getters y Setters
     */
    public ArrayList<Seccion> getSeccionPA() {
        return seccionPA;
    }

    public void setSeccionPA(ArrayList<Seccion> seccionPA) {
        this.seccionPA = seccionPA;
    }

    public String getNombrePA() {
        return nombrePA;
    }

    public void setNombrePA(String nombrePA) {
        this.nombrePA = nombrePA;
    }

    public String getRutaDestino() {
        return rutaDestino;
    }

    public void setRutaDestino(String rutaDestino) {
        this.rutaDestino = rutaDestino;
    }

    /**
     * Método toString
     */
    @Override
    public String toString() {
        return "El nombre del archivo es: " + nombrePA + "\nCon la ruta: " + rutaDestino;
    }
}
