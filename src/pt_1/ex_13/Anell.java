package pt_1.ex_13;

public class Anell {
    private String model;
    private double diametreDit;
    private double getDiametreSeccio;
    private double pes;
    private float preuOr;
    private float preuVenda;
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

    public float getPreuOr() {
        return preuOr;
    }

    public void setPreuOr(int preuOr) {
        this.preuOr = preuOr;
    }

    public double getPreuVenda() {
        return preuVenda;
    }

    public void setPreuVenda(float preuVenda) {
        this.preuVenda = preuVenda;
    }

    public int getPreuFabricacio() {
        return preuFabricacio;
    }

    public void setPreuFabricacio(int preuFabricacio) {
        this.preuFabricacio = preuFabricacio;
    }
    public float calcularPreuTotal() {
        return ;
    }
    public Anell(double pes, float preuOr) {
        this.pes = pes;
        this.preuOr = preuOr;
    }
}
