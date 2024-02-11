package pt_1.ex_6;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;
    public Triangle() {
        this.side1 = 3;
        this.side2 = 4;
        this.side3 = 5;
    }
    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }
    public double calcularPerimetreTriangle() {
        return this.side1 + this.side2 + this.side3;
    }
    public double calcularAreaTriangle() {
        double semiperimetre = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(semiperimetre *
                (semiperimetre - this.side1) *
                (semiperimetre - this.side2) *
                (semiperimetre - this.side3));
    }
}
