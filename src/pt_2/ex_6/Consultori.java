package pt_2.ex_6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consultori {
    private ArrayList<Visita> programmedVisits = new ArrayList<>();
    private String doctorName;
    private String speciality;

    public ArrayList<Visita> getProgrammedVisits() {
        return programmedVisits;
    }

    public void addConsultoryVisit(Visita visita) {
        long newVisitToMinutes = minutesBetween(visita.getVisitDate(), visita.getVisitHour());
        boolean dateAvailable = true;
        for (Visita v : programmedVisits) {
            long currentVisitToMinutes = minutesBetween(v.getVisitDate(), v.getVisitHour());
            if ((currentVisitToMinutes - newVisitToMinutes) < 30 || (newVisitToMinutes + currentVisitToMinutes) < 30 ) {
                dateAvailable = false;
            }
        }
        if (dateAvailable) {
            System.out.println("S'HA AFEGIT LA VISITA");
            programmedVisits.add(visita);
        } else {
            System.out.println("ERROR: JA EXISTEIX UNA VISITA PROGRAMA PER AQUESTA HORA");
        }
    }
    public void showVisits() {
        for (int i = 0; i < programmedVisits.size(); i++) {
            System.out.println((i + 1) + ". " + programmedVisits.get(i));
        }
    }
    public int chooseVisitIndex() {
        Scanner sc = new Scanner(System.in);
        int index = -1;
        do {
            try {
                System.out.println("ESCULL UNA VISITA");
                index = sc.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
            }
        } while (index < 0 || index > programmedVisits.size());
        return index;
    }
    public void deprogramVisit(int index) {
        programmedVisits.remove(index);
    }
    public long minutesBetween(LocalDate dayVisit, LocalTime hourVisit) {
        LocalDateTime date = LocalDateTime.of(dayVisit, hourVisit);
        return ChronoUnit.MINUTES.between(LocalDateTime.now(), date);
    }
    public int countVisits() {
        int totalVisits = 0;
        for (Visita v : programmedVisits) {
            totalVisits++;
        }
        return totalVisits;
    }

    public Consultori(String doctorName , String speciality) {
        this.doctorName = doctorName;
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Consultori\n" +
                "Nom doctor: " + doctorName + "\n" +
                "Especialitat: " + speciality + "\n";
    }
}
