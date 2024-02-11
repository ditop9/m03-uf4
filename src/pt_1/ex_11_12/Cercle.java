package pt_1.ex_11_12;

public class Cercle {
    private double radi;
    private double perimetre;
    private double area;
    public Cercle(double radi){
        setRadi(radi);
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }

    public double getPerimetre() {
        return perimetre;
    }

    public double getArea() {
        return area;
    }
    public void calcularPerimetre() {
        this.perimetre = 2 * Math.PI * getRadi();
    }

    public void calcularArea() {
        this.area = Math.PI * Math.pow(getRadi(), 2);
    }

    public double getRadi() {
        return radi;
    }
    public static void determinarCercleMesGran(Cercle cercle1, Cercle cercle2){
        if (cercle1.getRadi() > cercle2.getRadi()) {
            System.out.println("El cercle 1 és més gran que el cercle 2");
        }else System.out.println("El cercle 2 és més gran que el cercle 1");
    }
}
