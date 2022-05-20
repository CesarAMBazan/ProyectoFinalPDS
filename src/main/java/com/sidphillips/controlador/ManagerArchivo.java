package com.sidphillips.controlador;

import com.sidphillips.modelo.Formato;
import com.sidphillips.modelo.ProductoAcademico;
import com.sidphillips.modelo.Seccion;
import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Cesar Arturo Mejia Bazan - 2182005565
 * @author Enrique Ramirez Martinez - 2182000079
 * @author Rojas Piña Efraín Ulises - 2172001457
 */
public class ManagerArchivo {
    /**
     * Atributos de la clase
     */
    private final ArrayList<String> seccionesPA = new ArrayList<>();
    private final ArrayList<Seccion> secciones = new ArrayList<>();
    private final Formato formato = new Formato();
    private final ProductoAcademico PA = new ProductoAcademico();
    private int id = 0;

    /**
     * Constructor
     */
    public ManagerArchivo() {
    }

    /**
     * Método para corregir donde se encuentra el archivo
     *
     * @param ruta - Cadena que representa la ruta donde se encuentra un archivo
     * @return ruta corregida
     */
    public String corregirRuta(String ruta) {
        return ruta.replaceAll("\\\\", "/");
    }

    /**
     * Método que se utiliza para diferenciar entre un formato pdf o docx
     *
     * @param archivo - La ruta donde se encuentra el arhivo
     * @return la extensión del archivo obtenido
     */
    public String diferenciarFormato(String archivo) {
        return FilenameUtils.getExtension(archivo);
    }

    /**
     * Se lee y se construyen las secciones de un formato pdf
     *
     * @param archivo - La ruta del archivo
     * @return Se regresa el formato de esta clase en caso de que sea utilizado
     */
    public Formato tomarFormatoPDF(String archivo) {
        try {
            PDDocument documentPDF = PDDocument.load(new File(archivo));
            PDDocumentOutline outline = documentPDF.getDocumentCatalog().getDocumentOutline();
            formatoSecciones(documentPDF, outline);
            documentPDF.close();
            formato.setSecciones(secciones);
            return formato;
        } catch (IOException e) {
            System.err.println("Error al leer o escribir en el archivo con la ruta especificada");
        } catch (NullPointerException e) {
            System.err.println("Error al leer los bookmarks del archivo");
        }
        return null;
    }

    /**
     * Se construyen las secciones de un formato PDF a partir de los bookmarks de este mismo
     *
     * @param document - El documento PDF abierto
     * @param bookmark - El outline del formato PDF que apunta a los bookmarks del archivo
     * @throws IOException - En caso de que haya un error en la lectura u escritura
     */
    public void formatoSecciones(PDDocument document, PDOutlineNode bookmark) throws IOException {
        PDOutlineItem current = bookmark.getFirstChild();
        while (current != null) {
            ++id;
            Seccion seccion = new Seccion(id, current.getTitle());
            secciones.add(seccion);
            formatoSecciones(document, current);
            current = current.getNextSibling();
        }
    }

    /**
     * Este construye las secciones a partir de un formato word
     *
     * @param archivo - La tura en la que se encuentra el archivo
     * @return El formato de esta clase construido en caso de que se utilice
     */
    public Formato tomarFormatoWord(String archivo) {
        formato.setNombreArchivo(archivo);
        try {
            XWPFDocument documento = new XWPFDocument(new FileInputStream(archivo));
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(documento);
            List<XWPFParagraph> paragraphs = documento.getParagraphs();

            int idSeccion = 1;
            for (XWPFParagraph para : paragraphs) {
                if (para.getStyleID() != null && (para.getStyleID().compareTo("Ttulo") == 0
                        || para.getStyleID().compareTo("Ttulo1") == 0
                        || para.getStyleID().compareTo("Ttulo2") == 0
                        || para.getStyleID().compareTo("Ttulo3") == 0
                        || para.getStyleID().compareTo("Subttulo") == 0)) {
                    Seccion seccion = new Seccion(idSeccion, para.getText());
                    secciones.add(seccion);
                    ++idSeccion;
                }
            }
            formato.setSecciones(secciones);
            return formato;
        } catch (IOException ex) {
            System.err.println("Error al leer o escribir en el archivo con la ruta especificada");
        }
        return formato;
    }

    /**
     * Este método construye un formato académico a partir de un documento word
     *
     * @param archivo - Ruta donde se encuentra el archivo
     * @return El objeto ProductoAcademico de esta clase en caso de que se utilice
     */
    public ProductoAcademico tomarPAWord(String archivo) {
        PA.setSeccionesFormato(secciones);
        try {
            XWPFDocument documento = new XWPFDocument(new FileInputStream(archivo));
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(documento);
            List<XWPFParagraph> paragraphs = documento.getParagraphs();

            for (XWPFParagraph para : paragraphs) {
                if (para.getStyleID() != null && (para.getStyleID().compareTo("Ttulo") == 0
                        || para.getStyleID().compareTo("Ttulo1") == 0
                        || para.getStyleID().compareTo("Ttulo2") == 0
                        || para.getStyleID().compareTo("Ttulo3") == 0
                        || para.getStyleID().compareTo("Subttulo") == 0)) {
                    seccionesPA.add(para.getText());
                }
            }
            construirSeccionesWord(archivo);
        } catch (IOException ex) {
            System.err.println("Error al leer o escribir en el archivo con la ruta especificada");
        }
        return PA;
    }

    /**
     * Este método que obtiene el texto de un documento word para despues tokenizar su contenido
     *
     * @param archivo - ruta donde se encuentra el archivo
     */
    public void construirSeccionesWord(String archivo) {
        try {
            XWPFDocument documento = new XWPFDocument(new FileInputStream(archivo));
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(documento);
            String contenido = xwpfWordExtractor.getText();
            construirParrafo(contenido);
        } catch (IOException ex) {
            System.err.println("Error al leer o escribir en el archivo con la ruta especificada");
        }

    }

    /**
     * Método para tokenizar y construir secciones de un String
     *
     * @param contenido - String a tokenizar
     */
    private void construirParrafo(String contenido) {
        StringTokenizer parrafos = new StringTokenizer(contenido, "\n");
        StringBuilder textoSeccion = new StringBuilder();
        Seccion seccion = null;
        int numPalabras = 0;

        while (parrafos.hasMoreTokens()) {
            String parrafo = parrafos.nextToken().trim();
            StringTokenizer palabras = new StringTokenizer(parrafo, " ");
            if (seccionesPA.contains(parrafo)) {
                if (seccion != null) {
                    seccion.setNumPalabras(numPalabras);
                    seccion.setTexto(textoSeccion.toString());
                    textoSeccion = new StringBuilder();
                }
                seccion = findSeccion(parrafo);
                numPalabras = 0;
                seccionesPA.remove(parrafo);
            } else if (seccion != null) {
                while (palabras.hasMoreTokens()) {
                    String palabra = palabras.nextToken();
                    textoSeccion.append(palabra).append(" ");
                    numPalabras++;
                }
                textoSeccion.append("\n");
            }
        }
        if (!textoSeccion.toString().isEmpty() && seccion != null) {
            seccion.setNumPalabras(numPalabras);
            seccion.setTexto(textoSeccion.toString());
        }
    }

    /**
     * Método que se utiliza para encontrar una sección dentro de la lista de secciones
     *
     * @param name - Nombre de la sección a buscar
     * @return el objeto Seccion encontrado
     */
    public Seccion findSeccion(String name) {
        for (Seccion seccion
                : secciones) {
            if (name.equals(seccion.getNombre())) {
                seccion.setCumplido(true);
                return seccion;
            }
        }
        return null;
    }

    /**
     * Este método construye un producto academico a partir de un formato PDF
     *
     * @param archivo - Ruta del archivo
     * @return El ProductoAcademico construido en caso de necesitarlo
     */
    public ProductoAcademico tomarPAPDF(String archivo) {
        try {
            PDDocument documentPDF = PDDocument.load(new File(archivo));
            PDDocumentOutline outline = documentPDF.getDocumentCatalog().getDocumentOutline();
            productoAcSecciones(documentPDF, outline);
            documentPDF.close();
            PA.setSeccionesFormato(secciones);
            construirSeccionesPDF(archivo);
        } catch (IOException e) {
            System.err.println("Error al leer o escribir en el archivo con la ruta especificada");
        } catch (NullPointerException e) {
            System.err.println("Error al leer los bookmarks del archivo");
        }
        return PA;
    }

    /**
     * Construcción de las secciones del producto academico a partir del outline de este mismo
     *
     * @param document - El documento PDF abierto
     * @param bookmark - El outline del documento PDF
     */
    private void productoAcSecciones(PDDocument document, PDOutlineNode bookmark) {
        PDOutlineItem current = bookmark.getFirstChild();
        while (current != null) {
            seccionesPA.add(current.getTitle());
            productoAcSecciones(document, current);
            current = current.getNextSibling();
        }
    }

    /**
     * Método que construye las secciones de un documento PDF
     *
     * @param archivo - Ruta del archivo a abrir
     */
    public void construirSeccionesPDF(String archivo) {
        try {
            File file = new File(archivo);
            PDDocument document = PDDocument.load(file);

            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String text = pdfTextStripper.getText(document);
            construirParrafo(text);
        } catch (IOException ex) {
            System.err.println("ProductoPDF : "
                    + "Error al leer o escribir en el archivo con la ruta especificada");
        }
    }
}
