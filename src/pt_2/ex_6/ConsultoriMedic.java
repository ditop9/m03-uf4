package pt_2.ex_6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        System.out.println("\n1. PROGRAMAR UNA VISITA");
        System.out.println("2. COMPTAR VISITES PROGRAMADES");
        System.out.println("3. COMPTAR VISITES PROGRAMADES ENTRE DUES DATES");
        System.out.println("4. DESPROGRAMAR UNA VISITA");
        System.out.println("5. DESPROGRAMAR TOTES LES VISITES");
        System.out.println("0. TANCAR EL PROGRAMA");
    }
    public static void handleOption(int option) {
        switch (option) {
            case 1:
                programVisit();
                break;
            case 2:
                if (verifyEmptyConsultories()) {
                    int totalVisits = countVisits();
                    System.out.println("TOTAL DE VISITES: " + totalVisits);
                } else System.out.println("NO HI HAN VISITES PROGRAMADES");
                break;
            case 3:
                if (verifyEmptyConsultories()) {
                    countVisitsBetweenTwoDates();
                } else System.out.println("NO HI HAN VISITES PROGRAMADES");
                break;
            case 4:
                if (verifyEmptyConsultories()) {
                    deprogramVisit();
                } else System.out.println("NO HI HAN VISITES PROGRAMADES");
                break;
            case 5:
                if (verifyEmptyConsultories()) {
                    deprogramAllVisits();
                } else System.out.println("NO HI HAN VISITES PROGRAMADES");
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
    public static int countVisits() {
        showConsultories();
        Consultori consultori = chooseConsultory();
        return consultori.countVisits();
    }
    public static void deprogramVisit() {
        showConsultories();
        Consultori consultori = chooseConsultory();
        if (consultori.countVisits() > 0) {
            consultori.showVisits();
            int visitIndex = consultori.chooseVisitIndex();
            consultori.deprogramVisit(visitIndex);
        } else {
            System.out.println("ERROR: NO S'HAN TROBAT VISITES PROGRAMADES PEL CONSULTORI");
        }
    }
    public static void deprogramAllVisits() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ESCULL UNA OPCIÓ:");
        System.out.println("1. DESPROGRAMAR TOTES LES VISITES DEL SISTEMA");
        System.out.println("2. DESPROGRAMAR TOTES LES VISITES D'UN CONSULTORI");
        System.out.println("0. TORNAR AL MENÚ");
        int option = 0;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
            runApp();
        }
        switch (option) {
            case 1:
                for (Consultori c : availableConsultori) {
                    for (int i = 0; i < c.getProgrammedVisits().size(); i++) {
                        c.deprogramVisit(i);
                    }
                }
                break;
            case 2:
                deprogramAllVisitsOneConsultory();
                break;
            case 0:
                runApp();
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
        }
    }
    static void deprogramAllVisitsOneConsultory() {
        showConsultories();
        Consultori consultori = chooseConsultory();
        for (int i = 0; i < consultori.getProgrammedVisits().size(); i++) {
            consultori.deprogramVisit(i);
        }
    }
    public static void countVisitsBetweenTwoDates() {
        System.out.println("INTRODUEIX LA PRIMERA DATA");
        LocalDate firstDay = Visita.introduceDate();
        long startDay = ChronoUnit.DAYS.between(LocalDate.now(), firstDay);
        System.out.println("INTRODUEIX LA SEGONA DATA");
        LocalDate secondDay = Visita.introduceDate();
        long endDay = ChronoUnit.DAYS.between(LocalDate.now(), secondDay);
        if (startDay < endDay) {
            System.out.println("VISITES ENTRE " + firstDay + " i " + secondDay);
            int countVisits = countVisits(startDay, endDay);
            if (countVisits > 0) {
                System.out.println("TOTAL DE VISITES TROBADES ENTRE LES DADES: " + countVisits);
            } else {
                System.out.println("NO S'HAN TROBAT VISITES");
            }
        } else {
            System.out.println("ERROR: L'ORDRE DE DATES NO ÉS CORRECTE");
            System.out.println("TORNANT AL MENÚ...");
            runApp();
        }
    }
    static int countVisits(long startDay, long endDay) {
        int countVisits = 0;
        for (Consultori c : availableConsultori) {
            System.out.println(c);
            for (Visita v : c.getProgrammedVisits()) {
                long currentVisitDay = ChronoUnit.DAYS.between(LocalDate.now(), v.getVisitDate());
                if (startDay < currentVisitDay && endDay > currentVisitDay) {
                    System.out.println(v);
                    countVisits++;
                }
            }
        }
        return countVisits;
    }
    static boolean verifyEmptyConsultories() {
        for (Consultori c : availableConsultori) {
            if (!c.getProgrammedVisits().isEmpty()) {
                return true;
            }
        }
        return false;
    }
    static void showConsultories() {
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
