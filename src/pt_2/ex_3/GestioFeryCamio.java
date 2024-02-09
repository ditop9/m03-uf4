package pt_2.ex_3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestioFeryCamio {
    private static ArrayList<Ferry> ferriesDisponibles = new ArrayList<>();
    private static ArrayList<Camio> camionsExistents = new ArrayList<>();

    public static void main(String[] args) {
        runApp();
    }
    static void runApp(){
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            try {
                runGUI();
                option = sc.nextInt();
                handleOption(option);
            } catch (InputMismatchException e) {
                System.out.println("ERROR: NO ÉS UN CARÀCTER VÀLID");
                sc.nextLine();
            }
        }while (option != 0);
    }
    static void runGUI(){
        System.out.println("\n1. Determinar pes total càrrega ferry");
        System.out.println("2. Determinar si un camió està embarcat");
        System.out.println("3. Determinar si un camió pot embarcar");
        System.out.println("4. Embarcar un camió");
        System.out.println("5. Escollir camió embarcat");
        System.out.println("6. Determinar import de peatge d'un camió");
        System.out.println("7. Determinar peatge total");
        System.out.println("8. Introduïr nou ferry");
        System.out.println("9. Mostrar ferries disponibles");
        System.out.println("0. Tancar el programa");
    }
    static void handleOption(int option){
        Ferry ferry;
        switch (option){
            case 1:
                determinarPesTotalCamionsEmbarcats();
                break;
            case 2:
                determinarCamioEmbarcat();
                break;
            case 3:
                determinarCamioPotEmbarcar();
                break;
            case 4:
                embarcarCamio();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                introduirNouFerry();
                break;
            case 9:
                if (verificarVehiclesDisponibles(ferriesDisponibles)) {
                    mostrarVehiclesDisponibles(ferriesDisponibles);
                } else handleVehiclesNoDisponibles();
                break;
            case 0:
                System.out.println("EL PROGRAMA ES TANCA...");
                System.exit(0);
                break;
            default:
                System.out.println("NO ÉS UNA OPCIÓ CORRECTA");
                break;
        }
    }
    public static void determinarPesTotalCamionsEmbarcats() {
        if (verificarVehiclesDisponibles(ferriesDisponibles)) {
            mostrarVehiclesDisponibles(ferriesDisponibles);
            Ferry ferry = escollirFerry();
            float pesCarregaFerry = ferry.calcularPesCarregaFerry();
            System.out.println("Pes de la càrrega: " + pesCarregaFerry + "Tm\n" +
                    "Pes màxim del ferry: " + ferry.getPesMaxim() + " Tm");
        } else handleVehiclesNoDisponibles();
    }
    public static void determinarCamioEmbarcat() {
        if (verificarVehiclesDisponibles(ferriesDisponibles)) {
            if (verificarVehiclesDisponibles(camionsExistents)) {
                mostrarVehiclesDisponibles(camionsExistents);
                Camio camio = escollirCamio();
                if (camio != null) {
                    Ferry ferry = buscarCamioEmbarcat(camio);
                    if (ferry != null) {
                        System.out.println("CAMIÓ EMBARCAT");
                        System.out.println(ferry);
                        System.out.println(camio);
                    }
                }
            } else handleVehiclesNoDisponibles();
        } else handleVehiclesNoDisponibles();
    }
    public static void determinarCamioPotEmbarcar() {
        if (verificarVehiclesDisponibles(ferriesDisponibles)) {
            if (verificarVehiclesDisponibles(camionsExistents)) {
                mostrarVehiclesDisponibles(camionsExistents);
                Camio camio = escollirCamio();
                if (camio != null) {
                    Ferry ferry = buscarCamioEmbarcat(camio);
                    if (ferry == null) {
                        System.out.println("EL CAMIÓ POT EMBARCAR");
                    }
                }
            } else handleVehiclesNoDisponibles();
        } else handleVehiclesNoDisponibles();
    }
    public static void embarcarCamio() {
        if (verificarVehiclesDisponibles(ferriesDisponibles)) {
            mostrarVehiclesDisponibles(ferriesDisponibles);
            Ferry ferry = escollirFerry();
            Camio camio = Camio.generarCamio();
            camionsExistents.add(camio);
            ferry.embarcarCamio(camio);
        } else handleVehiclesNoDisponibles();
    }
    public static void introduirNouFerry() {
        Ferry ferry = Ferry.generarNouFerry();
        ferriesDisponibles.add(ferry);
    }
    static void mostrarVehiclesDisponibles(ArrayList<?> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println((i + 1) + ". " + arrayList.get(i));
        }
    }
    static Ferry escollirFerry() {
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUEIX EL NÚMERO DEL FERRY QUE VOLS ESCOLLIR");
        int ferryEscollit = -1;
        do {
            try {
                ferryEscollit = sc.nextInt() - 1;
            }catch (InputMismatchException e){
                System.out.println("ERROR: NO ÉS UN CARÀCTER VÀLID");
            }
        } while (verificarExistenciaFerry(ferryEscollit));
        return ferriesDisponibles.get(ferryEscollit);
    }
    static Camio escollirCamio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUEIX LA MATRÍCULA DEL CAMIÓ QUE VOLS ESCOLLIR");
        String matriculaCamio = sc.nextLine();
        for (Camio c : camionsExistents) {
            if (c.getMatriculaCamio().equals(matriculaCamio)) {
                return c;
            }
        }
        return null;
    }
    public static Ferry buscarCamioEmbarcat(Camio camio) {
        for (Ferry f : ferriesDisponibles) {
            if (f.verificarCamioEmbarcat(camio.getMatriculaCamio())) {
                return f;
            }
        }
        return null;
    }
    static boolean verificarExistenciaFerry(int index) {
        try {
            Ferry ferry = ferriesDisponibles.get(index);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: NO ÉS TROBA EL FERRY");
            return false;
        }
        return true;
    }
    static boolean verificarVehiclesDisponibles(ArrayList<?> arrayList) {
        return !arrayList.isEmpty();
    }
    static void handleVehiclesNoDisponibles() {
        System.out.println("NO ES TROBEN VEHICLES DISPONIBLES");
        System.out.println("TORNANT AL MENÚ...");
        runApp();
    }
}
