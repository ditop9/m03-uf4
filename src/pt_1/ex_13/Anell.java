package pt_1.ex_13;

public class Anell {
    private String model;
    private double diametreDit;
    private double diametreSeccio;
    private double pes;
    private double preuOr;
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

    public double getDiametreSeccio() {
        return diametreSeccio;
    }

    public void setDiametreSeccio(double getDiametreSeccio) {
        this.diametreSeccio = getDiametreSeccio;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public double getPreuOr() {
        return preuOr;
    }

    public void setPreuOr(int preuOr) {
        this.preuOr = preuOr;
    }

    public double getPreuVenda() {
        return preuVenda;
    }

    public void setPreuVenda(double preuVenda) {
        this.preuVenda = preuVenda;
    }

    public int getPreuFabricacio() {
        return preuFabricacio;
    }

    public void setPreuFabricacio(int preuFabricacio) {
        this.preuFabricacio = preuFabricacio;
    }
    public double calcularRadiPetit() {
        return diametreDit / 2;
    }
    public double calcularRadiGran() {
        return  diametreSeccio / 2;
    }
    public double calcularVolumAnell(){
        return (2 * Math.PI * calcularRadiGran()) * (Math.PI * Math.pow(calcularRadiPetit(), 2));
    }
    public double calcularQuantitatOr() {
        return calcularVolumAnell() * pes;
    }
    public double calcularPreuTotalAnell() {
        return (preuFabricacio + (calcularQuantitatOr() * preuOr)) * 210 / 100;
    }
    public Anell(double pes, float preuOr, int preuFabricacio) {
        this.pes = pes;
        this.preuOr = preuOr;
        this.preuFabricacio = preuFabricacio;
    }
}
