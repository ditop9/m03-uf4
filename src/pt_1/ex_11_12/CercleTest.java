package pt_1.ex_11_12;

import java.text.DecimalFormat;

public class CercleTest {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("#,##");

        Cercle cercle1 = new Cercle(5);

        cercle1.calcularPerimetre();
        cercle1.calcularArea();

        double perimetreCercle1 = cercle1.getPerimetre();
        double areaCercle1 = cercle1.getArea();

        System.out.println(format.format(perimetreCercle1));
        System.out.println(format.format(areaCercle1));

        Cercle cercle2 = new Cercle(8);

        cercle2.calcularPerimetre();
        cercle2.calcularArea();

        double perimetreCercle2 = cercle2.getPerimetre();
        double areaCercle2 = cercle2.getArea();

        System.out.println(format.format(perimetreCercle2));
        System.out.println(format.format(areaCercle2));

        Cercle.determinarCercleMesGran(cercle1, cercle2);
    }

}
