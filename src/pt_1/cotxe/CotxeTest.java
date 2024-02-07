package pt_1.cotxe;

import java.util.Scanner;

public class CotxeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cotxe cotxe1 = new Cotxe();
        System.out.println("Model del pt_1.cotxe 1");
        String modelCotxe1 = sc.nextLine();
        System.out.println("Matrícula del pt_1.cotxe 1");
        String matriculaCotxe1 = sc.nextLine();
        cotxe1.setModel(modelCotxe1);
        cotxe1.setMatricula(matriculaCotxe1);

        Cotxe cotxe2 = new Cotxe();
        System.out.println("Model del pt_1.cotxe 2");
        String modelCotxe2 = sc.nextLine();
        System.out.println("Matrícula del pt_1.cotxe 2");
        String matriculaCotxe2 = sc.nextLine();
        cotxe2.setModel(modelCotxe2);
        cotxe2.setMatricula(matriculaCotxe2);

        System.out.println("El model del pt_1.cotxe 1 és: " + cotxe1.getModel());
        System.out.println("La matrícula del pt_1.cotxe 1 és: " + cotxe1.getMatricula());

        System.out.println("El model del pt_1.cotxe 2 és: " + cotxe2.getModel());
        System.out.println("La matrícula del pt_1.cotxe 2 és: " + cotxe2.getMatricula());
    }
}
