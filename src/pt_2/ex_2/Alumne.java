package pt_2.ex_2;

public class Alumne {
    private String nom;
    private String cognom;
    private int edat;
    private String dni;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public Alumne(String nom, String cognom, int edat, String dni) {
        setNom(nom);
        setCognom(cognom);
        setEdat(edat);
        setDni(dni);
    }
}
