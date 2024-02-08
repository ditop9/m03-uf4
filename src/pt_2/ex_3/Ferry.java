package pt_2.ex_3;

import java.util.ArrayList;

public class Ferry {
    ArrayList<Camio> camionsEmbarcats = new ArrayList<>();
    private String matriculaFerry;
    private String nom;
    private String portDesti;
    private float preuPes;
    private float pesMaxim;
    private int camionsCarregats;
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
