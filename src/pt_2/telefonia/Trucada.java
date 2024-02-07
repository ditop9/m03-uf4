package pt_2.telefonia;

import java.util.Random;

public class Trucada {
    private int localitzador;
    private int minuts;
    private String desti;
    public int getMinuts() {
        return minuts;
    }
    public Trucada(int minuts, String desti) {
        Random random = new Random();
        this.localitzador = random.nextInt(1000000);
        this.minuts = minuts;
        this.desti = desti;
    }

    @Override
    public String toString() {
        return "Trucada\n" +
                "Localitzador: " + localitzador + "\n" +
                "Minuts: " + minuts + "\n" +
                "Desti: " + desti + "\n";
    }
}
