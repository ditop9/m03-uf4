package pt_1.ex_4_5;

public class Alumne {
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void saluda() {
        System.out.println("Hola el meu nom es " + getNom());
    }
}
