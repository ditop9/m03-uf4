package pt_2.casa;

import java.util.Objects;

public class Sala {
    private int numeroDeTelevisions = 0;
    private String tipusSala = "desconegut";

    public int getNumeroDeTelevisions() {
        return numeroDeTelevisions;
    }

    public String getTipusSala() {
        return tipusSala;
    }

    public void setNumeroDeTelevisions(int numeroDeTelevisions) {
        this.numeroDeTelevisions = numeroDeTelevisions;
    }

    public void setTipusSala(String tipusSala) {
        this.tipusSala = tipusSala;
    }

    public Sala(int numeroDeTelevisions, String tipusSala){
        setNumeroDeTelevisions(numeroDeTelevisions);
        setTipusSala(tipusSala);
    }
    public Sala() {
        numeroDeTelevisions = getNumeroDeTelevisions();
        tipusSala = getTipusSala();
    }

    @Override
    public String toString() {
        return tipusSala + "\n" +
                "Numero de televisions: " + numeroDeTelevisions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sala sala = (Sala) o;

        if (numeroDeTelevisions != sala.numeroDeTelevisions) return false;
        return Objects.equals(tipusSala, sala.tipusSala);
    }

    @Override
    public int hashCode() {
        int result = numeroDeTelevisions;
        result = 31 * result + (tipusSala != null ? tipusSala.hashCode() : 0);
        return result;
    }
}
