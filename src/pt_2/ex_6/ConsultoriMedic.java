package pt_2.ex_6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsultoriMedic {
    private static final ArrayList<Consultori> availableConsultori = new ArrayList<>();
    public static void main(String[] args) {
        Consultori consultori1 = new Consultori("Jose Martínez", "Pediatría");
        availableConsultori.add(consultori1);
        Consultori consultori2 = new Consultori("Elver Galarga", "Ginecología");
        availableConsultori.add(consultori2);
        Consultori consultori3 = new Consultori("Larry Capija", "Urgencias");
        availableConsultori.add(consultori3);
        Consultori consultori4 = new Consultori("Matías Prats", "Oftalmología");
        availableConsultori.add(consultori4);
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
        showConsultories();
        Consultori consultori = chooseConsultory();
        consultori.addConsultoryVisit(visita);
    }
    public static void showConsultories() {
        for (int i = 0; i < availableConsultori.size(); i++) {
            System.out.println((i + 1) + ". " + availableConsultori.get(i));
        }
    }
    public static Consultori chooseConsultory() {
        Scanner sc = new Scanner(System.in);
        int index = -1;
        do {
            try {
                System.out.println("ESCULL UN CONSULTORI");
                index = sc.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
            }
        } while (index < 0 || index > availableConsultori.size());
        return availableConsultori.get(index);
    }
}
