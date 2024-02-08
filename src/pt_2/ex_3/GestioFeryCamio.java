package pt_2.ex_3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestioFeryCamio {
    private static ArrayList<Ferry> ferriesDisponibles = new ArrayList<>();
    public static void main(String[] args) {
        runApp();
    }
    static void runApp(){
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            try {
                runGUI();
                option = sc.nextInt();
                handleOption(option);
            } catch (InputMismatchException e) {
                System.out.println("NO ÉS UN CARÀCTER VÀLID");
            }
        }while (option != 0);
    }
    static void runGUI(){
        System.out.println();
    }
    static void handleOption(int option){
        switch (option){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:

                break;
            case 9:
                if (verificarFerriesDisponibles()) {
                    mostrarFerriesDisponibles();
                } else handleFerriesNoDisponibles();
                break;
            case 0:
                System.out.println("EL PROGRAMA ES TANCA...");
                System.exit(0);
                break;
            default:
                System.out.println("NO ÉS UNA OPCIÓ CORRECTA");
                break;
        }
    }
    public static void introduirNouFerry() {

    }
    public static void mostrarFerriesDisponibles() {
        for (int i = 0; i < ferriesDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + ferriesDisponibles.get(i));
        }
    }
    static boolean verificarFerriesDisponibles() {
        return !ferriesDisponibles.isEmpty();
    }
    static void handleFerriesNoDisponibles() {
        System.out.println("NO ES TROBEN FERRIES DISPONIBLES");
        System.out.println("TORNANT AL MENÚ...");
        runApp();
    }
}
