package com.sidphillips.modelo;

/**
 * @author Cesar Arturo Mejia Bazan - 2182005565
 * @author Enrique Ramirez Martinez - 2182000079
 * @author Rojas Piña Efraín Ulises - 2172001457
 */
public class Seccion {

    /**
     * Atributos de la clase
     */
    private int id;
    private String nombre;
    private int numPalabras;
    private String texto;
    private boolean cumplido;

    /**
     * Constructor
     *
     * @param id - id de la Sección
     */
    public Seccion(int id) {
        this(id, "NO DEFINIDA");
    }

    /**
     * Constructor
     *
     * @param id     - id de la Sección
     * @param nombre - nombre de la sección
     */
    public Seccion(int id, String nombre) {
        this(id, nombre, 0, "", false);
    }

    /**
     * Constructor
     *
     * @param id          - id de la Sección
     * @param nombre      - nombre de la seccion
     * @param numPalabras - número de palabras en la sección
     * @param texto       - texto de la sección
     * @param cumplido    - condición de si esta sección se encuentra al compararla con un formato
     */
    public Seccion(int id, String nombre, int numPalabras, String texto, boolean cumplido) {
        this.id = id;
        this.nombre = nombre;
        this.numPalabras = numPalabras;
        this.texto = texto;
        this.cumplido = cumplido;
    }

    /**
     * Getters y Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPalabras() {
        return numPalabras;
    }

    public void setNumPalabras(int numPalabras) {
        this.numPalabras = numPalabras;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }

    /**
     * Método toString
     */
    @Override
    public String toString() {
        return "Seccion{" + "id=" + id
                + ",\nnombre=" + nombre
                + ",\nnumPalabras=" + numPalabras
                + ",\ntexto=" + texto
                + ",\ncumplido=" + cumplido + '}' + "\n";
    }

}
