package pt_1.school;

public class AlumneTest {
    public static void main(String[] args) {

        Alumne alumne1 = null;
        Alumne alumne2 = null;
        Alumne alumne3 = null;

        alumne1 = new Alumne();
        alumne1.setNom("Ramon");

        alumne2 = new Alumne();
        alumne2.setNom("Sonia");

        alumne3 = alumne1;
        alumne3.saluda();
        alumne1.saluda();

        alumne2.setNom("Moncho");
        alumne1.saluda();
    }
}
