package pt_2.new_contractes;

import java.time.LocalDate;
import java.util.ArrayList;

public class ContracteTest {
    private static ArrayList<pt_2.new_contractes.Empleat> empleatsDB = new ArrayList<>();

    public static void main(String[] args) {
        Empresa mcdonalds = new Empresa("99999999C", "McDonald's", "Hosteleria");
        Empresa mercadona = new Empresa("88888888Z", "Mercadona", "Ventas");

        Empleat diego = new Empleat("12312312A", "Diego");

        Contracte contracteDiego1 = new Contracte(mcdonalds, 78643782, LocalDate.of(2021,4,12), LocalDate.of(2023,12,22));
        diego.afegirNouContracte(contracteDiego1);

        Contracte contracteDiego2 = new Contracte(mercadona, 36884621, LocalDate.of(2024,1,1),LocalDate.of(2024,1,16));
        diego.afegirNouContracte(contracteDiego2);

        Empleat nuria = new Empleat("32132132B","Nuria");

        Contracte contracteNuria1 = new Contracte(mercadona, 86489212, LocalDate.of(2010,10,3), LocalDate.of(2023,4,27));
        nuria.afegirNouContracte(contracteNuria1);

        contracteDiego1.comptarDuradaContracte();
        System.out.println(diego.determinarQuantitatEmpresesTreballades());
        System.out.println(nuria.determinarQuantitatEmpresesTreballades());

        nuria.signarNouContracte(mercadona);
        System.out.println(nuria.determinarQuantitatEmpresesTreballades());

        Empresa ntt = new Empresa("79879879", "NTT", "Informàtica");
        diego.signarNouContracte(ntt);
        System.out.println(diego.determinarQuantitatEmpresesTreballades());

        contracteDiego2.determinarDuradaContracte(LocalDate.of(2019,10,28),LocalDate.of(2022,7, 14));
    }
    public static void imprimirEmpleats() {
        for (int i = 0; i < empleatsDB.size(); i++) {
            System.out.print(i + 1 + ": ");
            System.out.println(empleatsDB.get(i));
        }
    }
    public static Empleat buscarEmpleatBBDD(int numeroEmpleat) {
        return empleatsDB.get(numeroEmpleat - 1);
    }
}
