package pt_1.geometria;

public class Cilindre {
    private double radiBase;
    private double altura;
    private double area;
    private double volum;
    public Cilindre(double radiBase, double altura) {
        this.radiBase = radiBase;
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }
    public double getVolum() {
        return volum;
    }
    public double getRadiBase() {
        return radiBase;
    }

    public void setRadiBase(double radiBase) {
        this.radiBase = radiBase;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void determinarArea(){
        this.area = 2 * Math.PI * Math.pow(getRadiBase(),2) +
                2 * Math.PI * getRadiBase() * getAltura();
    }
    public void determinarVolum(){
        this.volum = Math.PI * Math.pow(getRadiBase(),2) * getAltura();
    }
    public static void determinarCilindreMesGran(Cilindre cilindre1, Cilindre cilindre2) {
        if (cilindre1.getVolum() > cilindre2.getVolum()) {
            System.out.println("El cilindre 1 és més gran que el cilindre 2");
        }else System.out.println("El cilindre 2 és més gran que el cilindre 1");
    }
}
