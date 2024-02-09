package pt_2.ex_1;

public class Cuina {
    private boolean esIndependent = false;
    private int nombreDeFogons = 0;
    public boolean isEsIndependent() {
        return esIndependent;
    }
    public int getNombreDeFogons() {
        return nombreDeFogons;
    }
    public void setEsIndependent(boolean esIndependent) {
        this.esIndependent = esIndependent;
    }

    public void setNombreDeFogons(int nombreDeFogons) {
        this.nombreDeFogons = nombreDeFogons;
    }

    public Cuina(boolean esIndependent, int nombreDeFogons) {
        setEsIndependent(esIndependent);
        setNombreDeFogons(nombreDeFogons);
    }
    public Cuina() {
        esIndependent = isEsIndependent();
        nombreDeFogons = getNombreDeFogons();
    }

    @Override
    public String toString() {
        return   esIndependent? "És independent":"No és independent \n" +
                "Nombre de fogons: " + nombreDeFogons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cuina cuina = (Cuina) o;

        if (esIndependent != cuina.esIndependent) return false;
        return nombreDeFogons == cuina.nombreDeFogons;
    }

    @Override
    public int hashCode() {
        int result = (esIndependent ? 1 : 0);
        result = 31 * result + nombreDeFogons;
        return result;
    }
}
