package pt_1.geometria;

import java.text.DecimalFormat;

public class CilindreTest {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("#,##");

        Cilindre cilindre1 = new Cilindre(3, 4);

        cilindre1.determinarArea();
        cilindre1.determinarVolum();

        System.out.println(format.format(cilindre1.getArea()));
        System.out.println(format.format(cilindre1.getVolum()));

        Cilindre cilindre2 = new Cilindre(1,2);

        cilindre2.determinarArea();
        cilindre2.determinarVolum();

        System.out.println(format.format(cilindre2.getArea()));
        System.out.println(format.format(cilindre2.getVolum()));

        Cilindre.determinarCilindreMesGran(cilindre1,cilindre2);
    }
}
