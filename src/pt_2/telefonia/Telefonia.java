package pt_2.telefonia;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Telefonia {
    private static final ArrayList<Client> CLIENTS_DB = new ArrayList<>();
    public static void main(String[] args) {
        runApp();
    }
    public static void runApp() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            try {
                System.out.println("Introdueix una opció");
                runGUI();
                option = sc.nextInt();
                runMenu(option);
            }catch (InputMismatchException e) {
                System.out.println("No és una opció vàlida");
                runApp();
            }
        }while (option != 0);
    }
    public static void runGUI(){
        System.out.println("1. Afegir nou client");
        System.out.println("2. Afegir una trucada a un client");
        System.out.println("3. Mostrar factura d'un client");
        System.out.println("4. Mostrar tots el clients");
        System.out.println("0. Tancar el programa");
    }
    public static void runMenu(int option) {
        Client client;
        switch (option) {
            case 1:
                afegirNouClient();
                break;
            case 2:
                if (verificarDBNoBuida()) {
                    client = seleccionarClient();
                    int minuts = introduirMinutsTrucada();
                    if (minuts > 0) {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Introdueix el destí de la trucada.");
                        String destiTrucada = sc.nextLine();
                        client.afegirTrucada(minuts, destiTrucada);
                    } else {
                        System.out.println("Una trucada no pot durar menys d'un minut");
                        runApp();
                    }
                } else {
                    System.out.println("No es troben clients al sistema. \n" +
                            "Tornant al menú...");
                    runApp();
                }
                break;
            case 3:
                if (verificarDBNoBuida()) {
                    client = seleccionarClient();
                    client.generarFactura();
                } else {
                    System.out.println("No es troben clients al sistema. \n" +
                            "Tornant al menú...");
                    runApp();
                }
                break;
            case 4:
                if (verificarDBNoBuida()) {
                    generarLlistatClients();
                } else {
                    System.out.println("No es troben clients al sistema.\n" +
                            "Tornant al menú...");
                    runApp();
                }
                break;
            case 0:
                System.out.println("El programa es tanca...");
                System.exit(0);
                break;
            default:
                break;
        }
    }
    static boolean verificarDBNoBuida() {
        return !CLIENTS_DB.isEmpty();
    }
    public static void afegirNouClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el nom.");
        String nom = sc.nextLine();
        String dni = introduirDni();
        float preuMinut = 0;
        try {
            System.out.println("Introdueix el preu per minut de trucades en euros.");
            preuMinut = sc.nextFloat();
        }catch (InputMismatchException e) {
            System.out.println("No és un caràcter vàlid.\n" +
                    "Tornant al menú.");
            runApp();
        }

        Client client = new Client(nom, dni, preuMinut);
        CLIENTS_DB.add(client);
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
    static boolean verificarDuplicacioDni(String dni) {
        for (Client client : CLIENTS_DB) {
            if (dni.equals(client.getDni())) {
                return true;
            }
        }
        return false;
    }
    static int introduirMinutsTrucada() {
        Scanner sc = new Scanner(System.in);
        int minuts = 0;
        try {
            System.out.println("Introdueix els minuts que ha durat la trucada");
            minuts = sc.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("No és un caràcter vàlid.\n" +
                    "Es torna al menú.");
            runApp();
        }
        return minuts;
    }
    static Client seleccionarClient() {
        Scanner sc = new Scanner(System.in);
        mostrarClients();
        Client client = null;
        int indexClient = -1;
        try {
            indexClient = sc.nextInt() - 1;
        } catch (InputMismatchException e) {
            System.out.println("No és una opció vàlida. \n" +
                    "Tornant al menú...");
            runApp();
        }
        try {
            client = CLIENTS_DB.get(indexClient);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Aquest client no existeix.\n" +
                    "Tornant al menú...");
            runApp();
        }
        return client;
    }
    public static void mostrarClients() {
        for (int i = 0; i < CLIENTS_DB.size(); i++) {
            System.out.println((i + 1 + ". ") + CLIENTS_DB.get(i));
        }
    }
    public static void generarLlistatClients() {
        for (int i = 0; i < CLIENTS_DB.size(); i++) {
            int trucadesTotals = 0;
            int minutsTotals = 0;
            System.out.println((i + 1) + ". " + CLIENTS_DB.get(i));
            for (Trucada trucada : CLIENTS_DB.get(i).getTRUCADES()) {
                System.out.println(trucada);
                trucadesTotals++;
                minutsTotals += trucada.getMinuts();
            }
            float preuTotal = minutsTotals * CLIENTS_DB.get(i).getPreuMinut();
            System.out.println("Número de trucades totals: " + trucadesTotals + "\n" +
                    "Minuts totals de trucades: " + minutsTotals + "\n" +
                    "Preu total de la factura: " + preuTotal + "€\n");
        }
    }
}
