package Clases;

import java.util.ArrayList;
import java.util.HashMap;

public class FormatoWord extends AbstractFormato implements StrategyFormato{
    String titulo;
    HashMap<Integer ,ArrayList<String>> contenidoSeccion;

    public FormatoWord(String nombreArchivo , String titulo  )
    {

        this.titulo=titulo;
        this.nombreArchivo=nombreArchivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public HashMap<Integer, ArrayList<String>> getContenidoSeccion() {
        return contenidoSeccion;
    }

    public void setContenidoSeccion(HashMap<Integer, ArrayList<String>> contenidoSeccion) {
        this.contenidoSeccion = contenidoSeccion;
    }

    @Override
    public ArrayList<Seccion> leerFormato() {
        return null;
    }
    @Override
    public String toString()
    {
        return "El archivo es:" + getNombreArchivo() + "el titulo es: " + getTitulo() + "  " + contenidoSeccion.get(4) ;
    }
}
