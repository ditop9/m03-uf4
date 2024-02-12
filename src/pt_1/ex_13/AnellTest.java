package pt_1.ex_13;

import java.util.Scanner;

public class AnellTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Anell anell = new Anell(19.3, 10, 40);
        System.out.println("INTRODUEIX EL RADI DE SECCIÓ DE L'ANELL");
        double diametreSeccio = sc.nextDouble();
        anell.setDiametreSeccio(diametreSeccio);
        System.out.println("INTRODUEIX EL RADI DE DIT DE L'ANELL");
        double diametreDit = sc.nextDouble();
        anell.setDiametreDit(diametreDit);
        anell.setPreuVenda(anell.calcularPreuTotalAnell());
        System.out.println("EL PREU DE VENDA TOTAL DE L'ANELL ÉS: " + anell.getPreuVenda() + '€');
    }
}
