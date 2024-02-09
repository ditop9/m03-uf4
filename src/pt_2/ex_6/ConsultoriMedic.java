package pt_2.ex_6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsultoriMedic {
    private static ArrayList<Consultori> availableConsultori = new ArrayList<>();
    public static void main(String[] args) {

        runApp();
    }
    public static void runApp() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            try {
                runGUI();
                option = sc.nextInt();
                handleOption(option);
            }catch (InputMismatchException e) {
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
                sc.nextLine();
            }
        }while (option != 0);
    }
    public static void runGUI() {
        System.out.println("0. TANCAR EL PROGRAMA");
    }
    public static void handleOption(int option) {
        switch (option) {
            case 1:
                break;
            case 2:
                programVisit();
                break;
            case 0:
                System.out.println("EL PROGRAMA ES TANCA...");
                System.exit(0);
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
                break;
        }
    }
    public static void programVisit() {
        Visita visita = Visita.generateVisit();

    }
}
