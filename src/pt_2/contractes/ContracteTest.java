package pt_2.contractes;

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
        Scanner sc = new Scanner(System.in);

        int numeroEmpleat;
        Empleat empleat;

        switch (option) {
            case 1:
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
}
