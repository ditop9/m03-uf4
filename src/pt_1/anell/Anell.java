package pt_1.anell;

public class Anell {
    private String model;
    private double diametreDit;
    private double getDiametreSeccio;
    private double pes;
    private int preuOr;
    private double preuVenda;
    private int preuFabricacio;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDiametreDit() {
        return diametreDit;
    }

    public void setDiametreDit(double diametreDit) {
        this.diametreDit = diametreDit;
    }

    public double getGetDiametreSeccio() {
        return getDiametreSeccio;
    }

    public void setGetDiametreSeccio(double getDiametreSeccio) {
        this.getDiametreSeccio = getDiametreSeccio;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public int getPreuOr() {
        return preuOr;
    }
    public void setPreuOr(int preuOr) {
        this.preuOr = preuOr;
    }
    public double getPreuVenda() {
        return preuVenda;
    }

    public void setPreuVenda(double preuVenda) {
        this.preuVenda = preuVenda * getPreuFabricacio() / 100;
    }

    public int getPreuFabricacio() {
        return preuFabricacio;
    }
    public void setPreuFabricacio(int preuFabricacio) {
        this.preuFabricacio = preuFabricacio;
    }
}
