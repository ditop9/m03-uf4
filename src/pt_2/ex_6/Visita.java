package pt_2.ex_6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Visita {
    private LocalDate visitDate;
    private LocalTime visitHour;
    private String patientName;

    public LocalDate getVisitDate() {
        return visitDate;
    }
    public LocalTime getVisitHour() {
        return visitHour;
    }
    public static Visita generateVisit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUEIX EL NOM DEL PACIENT");
        String patientName = sc.nextLine();
        return new Visita(introduceDate(), introduceHour(), patientName);
    }
    private static LocalDate introduceDate() {
        int day;
        int month;
        int year;
        do {
            System.out.println("INTRODUEIX EL DIA DE LA VISITA");
            day = introduceDateValues();
        } while (day < 1 || day > 31);
        do {
            System.out.println("INTRODUEIX EL MES DE LA VISITA");
            month = introduceDateValues();
        } while (month < 1 || month > 12);
        do {
            System.out.println("INTRODUEIX L'ANY DE LA VISITA");
            year = introduceDateValues();
        } while (year < LocalDate.now().getYear() || year > 2100);
        return LocalDate.of(year, month, day);
    }
    private static LocalTime introduceHour() {
        int hour;
        int minute;
        do {
            System.out.println("INTRODUEIX LA HORA DE LA VISITA");
            hour = introduceDateValues();
        } while (hour < 0 || hour > 23);
        do {
            System.out.println("INTRODUEIX EL MINUT DE LA VISITA");
            minute = introduceDateValues();
        } while (minute < 0 || minute > 59);
        return LocalTime.of(hour, minute);

    }
    private static int introduceDateValues() {
        Scanner sc = new Scanner(System.in);
        int data;
        try {
            data = sc.nextInt();
            return data;
        } catch (InputMismatchException e){
            System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
            return -1;
        }
    }
    public Visita(LocalDate visitDate, LocalTime visitHour, String patientName) {
        this.visitDate = visitDate;
        this.visitHour = visitHour;
        this.patientName = patientName;
    }
}
