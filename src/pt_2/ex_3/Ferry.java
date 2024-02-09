package pt_2.ex_3;

import com.sun.source.tree.CompilationUnitTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Ferry {
    ArrayList<Camio> camionsEmbarcats = new ArrayList<>();
    private String matriculaFerry;
    private String nom;
    private String portDesti;
    private float preuPes;
    private float pesMaxim;
    private int camionsCarregats;
    public static Ferry generarNouFerry(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introudeix la matrícula del Ferry");
        String matricula = sc.nextLine();
        System.out.println("Introdueix el nom del Ferry");
        String nom = sc.nextLine();
        System.out.println("Introdueix la destinació del Ferry");
        String portDesti = sc.nextLine();
        System.out.println("Introdueix el preu en euros per Tm de pes");
        float preuPes = sc.nextFloat();
        System.out.println("Introdueix el pes màxim del Ferry");
        float pesMaxim = sc.nextFloat();
        return new Ferry(matricula, nom, portDesti, preuPes, pesMaxim);
    }
    public void embarcarCamio(){
        float pesTotal = 0;
        Camio camio = Camio.generarCamio();
        if (verificarFerryBuit()) {
            for (Camio c : camionsEmbarcats) {
                pesTotal += c.getPes();
            }
        }
        pesTotal += camio.getPes();
        if (pesTotal > pesMaxim) {
            System.out.println("ERROR: NO ES POT EMBARCAR\n" +
                    "EL PES SUPERA EL MÀXIM DEL FERRY");
        } else camionsEmbarcats.add(camio);
    }
    private boolean verificarFerryBuit() {
        return !camionsEmbarcats.isEmpty();
    }
    public Ferry(String matriculaFerry, String nom, String portDesti, float preuPes, float pesMaxim){
        this.matriculaFerry = matriculaFerry;
        this.nom = nom;
        this.portDesti = portDesti;
        this.preuPes = preuPes;
        this.pesMaxim = pesMaxim;
    }

    @Override
    public String toString() {
        return "Ferry \n" +
                "Camions Embarcats: " + camionsEmbarcats + "\n" +
                "Matricula Ferry: " + matriculaFerry + '\'' + "\n" +
                "Nom: " + nom + "\n" +
                "Port Desti: " + portDesti + "\n" +
                "Preu Pes: " + preuPes + "\n" +
                "Pes Maxim: " + pesMaxim + "\n" +
                "Camions Carregats: " + camionsCarregats + "\n";
    }
}
