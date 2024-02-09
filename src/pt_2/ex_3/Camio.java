package pt_2.ex_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Camio {
    private String matriculaCamio;
    private int pes;

    public int getPes() {
        return pes;
    }

    public String getMatriculaCamio() {
        return matriculaCamio;
    }

    public static Camio generarCamio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUEIX LA MATRÍCULA DEL CAMIÓ");
        String matriculaCamio = sc.nextLine();
        System.out.println("INTRODUEIX EL PES TOTAL DEL CAMIÓ EN Tm");
        int pes = sc.nextInt();
        return new Camio(matriculaCamio, pes);
    }
    public Camio(String matriculaCamio, int pes) {
        this.matriculaCamio = matriculaCamio;
        this.pes = pes;
    }
}
