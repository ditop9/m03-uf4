package pt_2.ex_5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContracteTest {
    private static final ArrayList<Empleat> EMPLEATS_DB = new ArrayList<>();

    public static void main(String[] args) {
        runApp();
    }
    public static void runApp() {
        Scanner sc = new Scanner(System.in);
        int option = - 1;
        do {
            try {
                runGUI();
                option = sc.nextInt();
                runMenu(option);
            }catch (InputMismatchException e) {
                System.out.println("No és una opció vàlida.");
                runApp();
            }
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
        Empleat empleat;

        switch (option) {
            case 1:
                introduirNouEmpleatBBDD();
                break;
            case 2:
                if (verificarDBBuida()) {
                    empleat = escollirEmpleat();
                    long diesTotalsTreballats = empleat.determinarDuradaTotalContractes();
                    System.out.println(diesTotalsTreballats);
                } else controlarDBBuida();
                break;
            case 3:
                if (verificarDBBuida()) {
                    empleat = escollirEmpleat();
                    System.out.println(empleat.determinarQuantitatEmpresesTreballades());
                } else controlarDBBuida();
                break;
            case 4:
                if (verificarDBBuida()) {
                    empleat = escollirEmpleat();
                    empleat.signarNouContracte();
                } else controlarDBBuida();
                break;
            case 5:
                if (verificarDBBuida()) {
                    empleat = escollirEmpleat();
                    System.out.println("Quin és el contracte del que voleu determinar la durada?");
                    empleat.imprimirContractes();
                    long duradaContracte ;
                } else controlarDBBuida();
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
    static Empleat escollirEmpleat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quin és l'empleat?");
        imprimirEmpleats();
        int index = -1;
        try {
            index = sc.nextInt() - 1;
        }catch (InputMismatchException e) {
            System.out.println("No és una opció vàlida.\n" +
                    "Tornant al menú...");
            runApp();
        }
        return EMPLEATS_DB.get(index);
    }
    static void imprimirEmpleats() {
        for (int i = 0; i < EMPLEATS_DB.size(); i++) {
            System.out.println((i + 1) + ". " + EMPLEATS_DB.get(i));
        }
    }
    public static String introduirDni() {
        Scanner sc = new Scanner(System.in);
        String dni;
        do {
            System.out.println("Introdueix el DNI");
            dni = sc.nextLine();
            if (verificarDuplicacioDni(dni)) {
                System.out.println("Aquest DNI ja es troba registrat");
            }
        }while (verificarDuplicacioDni(dni));
        return dni;
    }
    public static void introduirNouEmpleatBBDD() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom de l'empleat.");
        String nom = sc.nextLine();
        String dni = introduirDni();
        Empleat empleat = new Empleat(dni, nom);
        EMPLEATS_DB.add(empleat);
    }
    static boolean verificarDuplicacioDni(String dni) {
        for (Empleat empleat : EMPLEATS_DB) {
            if (dni.equals(empleat.getDni())) {
                return true;
            }
        }
        return false;
    }
    static boolean verificarDBBuida() {
        return EMPLEATS_DB.isEmpty();
    }
    static void controlarDBBuida() {
        System.out.println("No hi ha dades d'empleats al sistema");
        runApp();
    }
}
