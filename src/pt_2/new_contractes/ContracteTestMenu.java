package pt_2.new_contractes;

import java.util.ArrayList;
import java.util.Scanner;

public class ContracteTestMenu {
    private static final ArrayList<Empleat> EMPLEATS_DB = new ArrayList<>();

    public static void main(String[] args) {
        runApp();
    }
    public static void runApp() {
        Scanner sc = new Scanner(System.in);

        char option;
        do {
            runGUI();
            option = sc.next().charAt(0);
            if (option != '1' && option != '2' && option != '3' && option != '4' && option != '5'){
                System.out.println("NO ES UN CARÀCTER VÀLID");
                runApp();
            }
            runMenu(option);
        }while(option != '0');
    }

    public static void runGUI() {
        System.out.println("1. Introduir nou empleat");
        System.out.println("2. Calcular durada dels contractes");
        System.out.println("3. Determinar en quantes empreses ha treballat");
        System.out.println("4. Signar un nou contracte");
        System.out.println("5. Determinar la durada d'un contracte");
        System.out.println("0. Tancar programa");
    }
    public static void runMenu(int option) {
        Scanner sc = new Scanner(System.in);

        int numeroEmpleat;
        Empleat empleat;

        switch (option) {
            case '1':
                introduirNouEmpleatBBDD();
                break;
            case 2:
                System.out.println("Quin és l'empleat?");
                imprimirEmpleats();
                numeroEmpleat = sc.nextInt();
                empleat = buscarEmpleatBBDD(numeroEmpleat);
                signarNouContracte(empleat);
                break;
            case 0:
                System.out.println("El programa es tanca...");
                System.exit(0);
                break;
            default:
                System.out.println("No és una opció vàlida");
                break;
        }
    }
    public static void introduirNouEmpleatBBDD() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el DNI del nou empleat");
        String dni = sc.nextLine();
        if (verificarDuplicacioDni(dni)) {
            System.out.println("Aquest DNI ja existeix");
            System.out.println("1. Introduir un altre DNI");
            System.out.println("2. Sortir al menú");
            char option = sc.next().charAt(0);
            if (option == 1) {
                introduirNouEmpleatBBDD();
            } else  {
                runApp();
            }
        }
        System.out.println("Introdueix el nom del nou empleat");
        String nom = sc.nextLine();
        Empleat empleat = new Empleat(dni, nom);
        EMPLEATS_DB.add(empleat);
    }
    public static boolean verificarDuplicacioDni(String dni) {
        for (Empleat empleat : EMPLEATS_DB) {
            if (empleat.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }
    public static void imprimirEmpleats() {
        for (int i = 0; i < EMPLEATS_DB.size(); i++) {
            System.out.print(i + 1 + ": ");
            System.out.println(EMPLEATS_DB.get(i));
        }
    }
    public static Empleat buscarEmpleatBBDD(int numeroEmpleat) {
        return EMPLEATS_DB.get(numeroEmpleat - 1);
    }
    public static void signarNouContracte(Empleat empleat) {
        Empresa empresa = generarEmpresa();
        Contracte contracte = new Contracte(empresa);
        empleat.afegirNouContracte(contracte);
    }
    public static Empresa generarEmpresa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el CIF de la empresa");
        String cif = sc.nextLine();
        System.out.println("Introdueix el nom de la empresa");
        String nomEmpresa = sc.nextLine();
        System.out.println("Introdueix el sector empresarial");
        String sectorEmpresarial = sc.nextLine();

        return new Empresa(cif, nomEmpresa, sectorEmpresarial);
    }
}
