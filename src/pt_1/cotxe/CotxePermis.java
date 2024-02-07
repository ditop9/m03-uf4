package pt_1.cotxe;

import java.util.Scanner;

public class CotxePermis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cotxe cotxe = new Cotxe();
        PermisConduir permis = new PermisConduir();

        int option;
        do {
            showMenu();
            option = sc.nextInt();
            runMenu(cotxe, permis, option);
        }while (option != 0);
    }
    public static void showMenu() {
        System.out.println("1. Modificar informació del pt_1.cotxe");
        System.out.println("2. Modificar informació del permís");
        System.out.println("3. Mostrar informació del pt_1.cotxe i permís");
        System.out.println("0. Tancar programa");
    }

    public static void runMenu(Cotxe cotxe, PermisConduir permis, int option) {
        switch (option){
            case 1:
                modificarInfoCotxe(cotxe);
                break;
            case 2:
                modificarInfoPermis(permis);
                break;
            case 3:
                mostrarInfo(cotxe, permis);
                break;
            case 0:
                System.out.println("El programa es tanca  ");
                System.exit(0);
                break;
        }
    }
    public static void modificarInfoCotxe(Cotxe cotxe) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quin és el model del pt_1.cotxe?");
        String model = sc.nextLine();
        System.out.println("Quina és la matrícula del pt_1.cotxe?");
        String matricula = sc.nextLine();

        cotxe.setModel(model);
        cotxe.setMatricula(matricula);
    }
    public static void modificarInfoPermis(PermisConduir permis) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quin és el nom?");
        String nom = sc.nextLine();
        System.out.println("Quin tipus de permís és?");
        String tipusPermis = sc.nextLine();
        System.out.println("Quants punts té?");
        int punts = sc.nextInt();

        permis.setNom(nom);
        permis.setTipusPermis(tipusPermis);
        permis.setPunts(punts);
    }
    public static void mostrarInfo(Cotxe cotxe, PermisConduir permis) {
        String model = cotxe.getModel();
        String matricula = cotxe.getMatricula();
        String nom = permis.getNom();
        String tipusPermis = permis.getTipusPermis();
        int punts = permis.getPunts();

        System.out.println("Model: " + model);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nom: " + nom);
        System.out.println("Tipus de permís: " + tipusPermis);
        System.out.println("Punts: " + punts);
    }
}
