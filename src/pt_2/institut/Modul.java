package pt_2.institut;

public class Modul {
    private String nomModul;

    public String getNomModul() {
        return nomModul;
    }

    public void setNomModul(String nomModul) {
        this.nomModul = nomModul;
    }
    public Modul(String nomModul){
        setNomModul(nomModul);
    }
}
