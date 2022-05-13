package Test;

import Clases.FormatoPdf;
import Clases.StrategyFormato;

public class Test {
    public static void main(String[] args) {
        FormatoPdf formatoPdf = new FormatoPdf("holin2.pdf");
        formatoPdf.leerFormato();
        System.out.println(formatoPdf.getSecciones());
    }
}
