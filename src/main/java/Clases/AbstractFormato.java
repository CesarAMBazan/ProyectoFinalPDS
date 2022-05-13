package Clases;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractFormato {
    String nombreArchivo;
    ArrayList<Seccion> secciones;
    HashMap<Integer , ArrayList<String>> contenidoSeccion;

    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setSecciones(ArrayList<Seccion> secciones) {
        this.secciones = secciones;
    }

    public void setContenidoSeccion(HashMap<Integer, ArrayList<String>> contenidoSeccion) {
        this.contenidoSeccion = contenidoSeccion;
    }
}
