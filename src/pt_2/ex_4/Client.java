package pt_2.ex_4;

import java.util.ArrayList;

public class Client {
    private final ArrayList<Trucada> trucadesClient = new ArrayList<>();
    private String nom;
    private String dni;
    private float preuMinut;
    public String getDni() {
        return dni;
    }
    public float getPreuMinut() {
        return preuMinut;
    }
    public ArrayList<Trucada> getTrucadesClient() {
        return trucadesClient;
    }
    public void afegirTrucada(int minuts, String desti) {
        Trucada trucada = new Trucada(minuts, desti);
        trucadesClient.add(trucada);
    }
    public void generarFactura() {
        float preuTotal = 0;
        int minutsTotals = 0;
        for (Trucada trucada : trucadesClient) {
            preuTotal += trucada.getMinuts() * preuMinut;
            minutsTotals += trucada.getMinuts();
        }
        System.out.println(this);
        for (int i = 0; i < trucadesClient.size(); i++) {
            System.out.println((i + 1 + ". " + trucadesClient.get(i)));
        }
        System.out.println("Preu total factura: " + preuTotal + "€\n" +
                "Minuts totals trucades: " + minutsTotals + " minuts\n");
    }
    public Client(String nom, String dni, float preuMinut) {
        this.nom = nom;
        this.dni = dni;
        this.preuMinut = preuMinut;
    }

    @Override
    public String toString() {
        return "Client\n" +
                "Nom: " + nom + "\n" +
                "Dni: " + dni + "\n" +
                "Preu per minut: " + preuMinut + "\n";
    }
}
