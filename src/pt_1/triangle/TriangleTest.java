package pt_1.triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle();

        triangle1.setSide1(3);
        triangle1.setSide2(4);
        triangle1.setSide3(5);

        System.out.println(triangle1.calcularPerimetreTriangle());
        System.out.println(triangle1.calcularAreaTriangle());

        Triangle triangle2 = new Triangle(8, 10, 6);

        System.out.println(triangle2.calcularPerimetreTriangle());
        System.out.println(triangle2.calcularAreaTriangle());
    }
}
