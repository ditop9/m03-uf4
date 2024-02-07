package pt_1.cotxe;

public class PermisConduir {
    private String nom;
    private String tipusPermis;
    private int punts;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipusPermis() {
        return tipusPermis;
    }

    public void setTipusPermis(String tipusPermis) {
        this.tipusPermis = tipusPermis;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public void imprimirPermis() {
        System.out.println(getNom());
        System.out.println(getTipusPermis());
        System.out.println(getPunts());
    }
    public void restarPunts(int puntsARestar) {
        setPunts(this.punts - puntsARestar);
    }
}
