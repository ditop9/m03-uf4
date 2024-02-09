package pt_2.ex_6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Visites {
    private LocalDate visitDate;
    private LocalTime visitHour;
    private String patientName;
    public static void generateVisit() {
        Scanner sc = new Scanner(System.in);
        LocalDate visitDate = introduceDate();
        LocalTime visitHour =
    }
    private static LocalDate introduceDate() {
        Scanner sc = new Scanner(System.in);
        int day = -1;
        int month = -1;
        int year = -1;
        try {
            System.out.println("INTRODUEIX EL DIA DE LA VISITA");
            day = sc.nextInt();
        } catch (InputMismatchException e){
            System.out.println("ERROR: NO ÉS UN DÍA VÀLID");
        }
        try {
            System.out.println("INTRODUEIX EL MES DE LA VISITA");
            month = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: NO ÉS UN MES VÀLID");
        }
        try {
            System.out.println("INTRODUEIX L'ANY DE LA VISITA");
            year = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: NO ÉS UN ANY VÀLID");
        }
        return LocalDate.of(year, month, day);
    }
    private static int introduceDay() {
        Scanner sc = new Scanner(System.in);
        int day = -1;
        try {
            System.out.println("INTRODUEIX EL DIA DE LA VISITA");
            day = sc.nextInt();
        } catch (InputMismatchException e){
            System.out.println("ERROR: NO ÉS UN DÍA VÀLID");
            introduceDay();
        }
        return day;
    }
    private static LocalTime introduceHour() {

    }
    public Visites(LocalDate visitDate, LocalTime visitHour, String patientName) {
        this.visitDate = visitDate;
        this.visitHour = visitHour;
        this.patientName = patientName;
    }
}
