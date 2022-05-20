package com.sidphillips.controlador;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.sidphillips.modelo.Formato;
import com.sidphillips.modelo.ProductoAcademico;
import com.sidphillips.modelo.ReportePdf;
import com.sidphillips.modelo.Seccion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import java.util.ArrayList;

public class ManagerReporte {

    private String nombre;
    private Formato formato;
    private ProductoAcademico PA;
    private ManagerArchivo managerArchivo;
    private ArrayList<Seccion> seccionesFormato = null;
    private ArrayList<String> seccionesPA = null;
    private String ruta;
    private String extension;

    public ManagerReporte() {
        this.managerArchivo = new ManagerArchivo();
    }

    public void generarProceso(String formatIn, String productA) throws IOException{
        leerFormato(formatIn);
        leerPA(productA);
        comparar();

        generarReporte();
    }

    public Formato leerFormato(String archivo) {
        ruta = managerArchivo.corregirRuta(archivo);
        extension = managerArchivo.diferenciarFormato(ruta);

        formato = null;

        if (extension.compareTo("pdf") == 0) {
            formato = managerArchivo.tomarFormatoPDF(ruta);
            seccionesFormato = formato.getSecciones();
        } else if (extension.compareTo("docx") == 0) {
            formato = managerArchivo.tomarFormatoWord(ruta);
            seccionesFormato = formato.getSecciones();
        } else {
            System.err.println("No soportamos ese tipo de archivo");
        }
        return formato;
    }

    public ProductoAcademico leerPA(String archivo){
        ruta = managerArchivo.corregirRuta(archivo);
        extension = managerArchivo.diferenciarFormato(ruta);

        PA = null;

        if(extension.compareTo("pdf") == 0){
            PA = managerArchivo.tomarPAPDF(archivo);
            seccionesFormato = PA.getSeccionesFormato();
            seccionesPA = PA.getSeccionesPA();
        } else if(extension.compareTo("docx") == 0){
            PA = managerArchivo.tomarPAWord(archivo);
            seccionesPA = PA.getSeccionesPA();
            seccionesFormato = PA.getSeccionesFormato();
        } else{
            System.err.println("No soportamos ese tipo de archivo");
        }
        return PA;
    }

    public void comparar(){
        for (Seccion seccion : PA.getSeccionesFormato()){
            if(seccion.isCumplido() && seccion.getNumPalabras() == 0){
                seccion.setCumplido(false);
            }
        }
    }

    public void generarReporte() throws IOException{
        try{
            ReportePdf reporte = new ReportePdf();
            reporte.setNombrePA(".\\reportes\\reporte.pdf");
            reporte.setSeccionPA(PA.getSeccionesFormato());
            reporte.setRutaDestino(reporte.getNombrePA());


            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(reporte.getNombrePA()));
            Document document = new Document(pdfDocument);
            //3. Creando tabla
         // Table(2) -> Indica que la tabla tendra dos columnas
            Table table = new Table(2);
            table.addCell("Formato");
            table.addCell("Cumplido");

         
         //6. Añadimos la tabla al docuemento
         for(Seccion seccion : seccionesFormato){
             table.addCell(seccion.getNombre());
             if(seccion.isCumplido()){
                 table.addCell("Si");
             }else{
                 table.addCell("No");
             }
         }
         document.add(table);
         //7. Cerramos el documento
         document.close();
         
         File archivoPDF = new File(reporte.getNombrePA());
         
         // Se sustituye la ruta por la ruta absoluta obtenida del objeto File
            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,"
                    + "ShellExec_RunDLL " + archivoPDF.getAbsolutePath());
         
        } catch(FileNotFoundException e){
            System.err.println("No se pudo leer o escribir en el archivo");
        }
    }
}
