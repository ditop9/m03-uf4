package pt_2.ex_1;

public class CasaTest {
    public static void main(String[] args) {
        Sala sala1 = new Sala(1, "Menjador");

        Cuina cuina1 = new Cuina(true, 4);

        Casa casa1 = new Casa(120, "Carrer monjes con escopeta", sala1, cuina1);

        System.out.println(casa1);

        Sala sala2 = new Sala();

        Cuina cuina2 = new Cuina();

        Casa casa2 = new Casa(75, "Carrer del maremàgnum", sala2, cuina2);

        System.out.println(casa2);
    }
}
