package Clases;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManagerArchivo {
    public ManagerArchivo() {

    }

    public AbstractFormato tomarFormatoWord(String archivo) throws IOException {
        AbstractFormato formato = new FormatoWord(archivo, archivo);
        try {
            ArrayList<Seccion> secciones = new ArrayList<>();
            HashMap<Integer, ArrayList<String>> content = new HashMap<>();

            XWPFDocument documento = new XWPFDocument(new FileInputStream(archivo));

            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(documento);

            String contenido = xwpfWordExtractor.getText();

            List<XWPFParagraph> paragraphs = documento.getParagraphs();
            int i = 0;

            for (XWPFParagraph para : paragraphs) {
                ArrayList<String> parrafo = new ArrayList<String>();
                Seccion seccion = null;


                if (para.getStyleID() == null) {
                    System.out.println("Contenido: " + i + "    " + para.getParagraphText());
                    parrafo.add(para.getText());
                    content.get(i).add(para.getText());


                } else if (para.getStyleID().compareTo("Ttulo") == 0
                        || para.getStyleID().compareTo("Ttulo1") == 0
                        || para.getStyleID().compareTo("Ttulo2") == 0
                        || para.getStyleID().compareTo("Ttulo3") == 0
                        || para.getStyleID().compareTo("Subttulo") == 0) {
                    //se recupera la seccion
                    i++;
                    seccion = new Seccion();
                    seccion.setId(i);
                    seccion.setNombre(para.getText());
                    seccion.setNumPalabras(0);

                    System.out.println("Seccion:  " + para.getText());
                    //Añadimos la seccion al formato
                    secciones.add(seccion);

                    parrafo.add(para.getText());
                    content.put(i, parrafo);
                    seccion.setTexto(String.valueOf(content));


                }

                formato.setSecciones(secciones);
                formato.setContenidoSeccion(content);

            }
        }catch(Exception ignored){ }
            return formato;
        }
    }