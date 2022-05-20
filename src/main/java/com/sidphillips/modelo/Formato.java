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
public class Formato {
    String nombreArchivo;
    ArrayList<Seccion> secciones;

    public Formato() {
    }

    public Formato(String nombreArchivo, ArrayList<Seccion> secciones) {
        this.nombreArchivo = nombreArchivo;
        this.secciones = secciones;
    }

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
    
    @Override
   public String toString()
   {
       return "El nombre del archivo es: " +  nombreArchivo  + " \nCon secciones: \n" ;
   }
    
}
