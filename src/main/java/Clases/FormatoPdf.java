package Clases;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FormatoPdf extends AbstractFormato implements StrategyFormato {

    /**
     *
     * @param archivo - La ruta del archivo a leer
     */
    public FormatoPdf(String archivo) {
        this.nombreArchivo = archivo;
        secciones = new ArrayList<>();
    }

    /**
     *
     * @return Este metodo devuelve la lista de secciones por las que esta conformado este formato,
     *         en caso de una falla, regresa un ArrayList nulo;
     */
    @Override
    public ArrayList<Seccion> leerFormato() {
        try{
            ArrayList<String> bookmarks = obtenerBookmarks();
            construirSecciones(bookmarks);
            return this.secciones;
        }catch (IOException e){
            System.err.println("Error al leer o escribir en el archivo con la ruta especificada");
        }catch (NullPointerException e){
            System.err.println("Error al leer los bookmarks del archivo");
        }
        return null;
    }

    /**
     * Método que se utiliza para recuperar un ArrayList con los bookmarks definidos en PDF, este método tambien
     * construye a partir de este ArrayList la lista de secciones la cual es un atributo de la clase AbstractFormato
     *
     * @return Regresa un ArrayList con los bookmarks definidos en el archivo PDF
     * @throws IOException - En caso de que el archivo no pueda ser leido.
     */
    public ArrayList<String> obtenerBookmarks() throws IOException {
        PDDocument document = PDDocument.load(new File(nombreArchivo));
        PDDocumentOutline outline = document.getDocumentCatalog().getDocumentOutline();
        ArrayList<String> resultado = new ArrayList<>();

        printBookmark(outline, resultado);
        document.close();
        int id = 1;
        for (String seccion : resultado) {
            Seccion seccion1 = new Seccion(id, seccion);
            secciones.add(seccion1);
            id++;
        }
        return resultado;
    }

    /**
     * Método que se utiliza para crear la lista de bookmarks a partir del outline de un documento PDF
     *
     * @param bookmark - El outline de un documento PDF que sirve para obtener los bookmarks a partir de nodos y sus hijos
     * @param lista - ArrayList el cual será utilizado para agregar los títulos de los bookmarks
     *                obtenidos a partir del outline
     */
    public void printBookmark(PDOutlineNode bookmark, ArrayList<String> lista){
        PDOutlineItem current = bookmark.getFirstChild();
        while (current != null) {
            lista.add(current.getTitle());
            printBookmark(current, lista);
            current = current.getNextSibling();

        }
    }

    /**
     * Método que se utiliza para construir el contenido de los objetos sección de la lista de secciones
     *
     * @param bookmarks - ArrayList que contiene el nombre en String de cada uno de los bookmarks del archivo PDF
     * @throws IOException - En caso de que haya un error en la lectura del archivo PDF
     */
    public void construirSecciones(ArrayList<String> bookmarks) throws IOException {
        File file = new File(nombreArchivo);
        PDDocument document = PDDocument.load(file);

        PDFTextStripper pdfTextStripper = new PDFTextStripper();

        String text = pdfTextStripper.getText(document);
        StringTokenizer parrafos = new StringTokenizer(text, "\n");
        StringBuilder textoSeccion = new StringBuilder();
        Seccion seccion = null;
        int numPalabras = 0;
        while (parrafos.hasMoreTokens()) {
            String parrafo = parrafos.nextToken().trim();
            StringTokenizer palabras = new StringTokenizer(parrafo, " ");
            if (bookmarks.contains(parrafo)) {
                if(seccion != null){
                    seccion.setNumPalabras(numPalabras);
                    seccion.setTexto(textoSeccion.toString());
                    textoSeccion = new StringBuilder();
                }
                seccion = findSeccion(parrafo);
                numPalabras = 0;
                bookmarks.remove(parrafo);
            } else if(seccion != null){
                while (palabras.hasMoreTokens()) {
                    String palabra = palabras.nextToken();
                    textoSeccion.append(palabra).append(" ");
                    numPalabras++;
                }
                textoSeccion.append("\n");
            }
        }
        if(!textoSeccion.toString().isEmpty() && seccion!=null){
            seccion.setNumPalabras(numPalabras);
            seccion.setTexto(textoSeccion.toString());
        }
    }


    /**
     *
     * @param name - nombre de la seccion a buscar
     * @return objeto Seccion, si no se encuentra el objeto se regresa nulo
     */
    public Seccion findSeccion(String name) {
        for (Seccion seccion :
                secciones) {
            if (name.equals(seccion.getNombre())) {
                return seccion;
            }
        }
        return null;
    }
}
