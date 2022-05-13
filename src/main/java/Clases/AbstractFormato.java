package Clases;

import java.util.ArrayList;

public abstract class AbstractFormato {
    String nombreArchivo;
    ArrayList<Seccion> secciones;

    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }
}
