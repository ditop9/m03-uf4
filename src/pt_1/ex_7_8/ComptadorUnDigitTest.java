package pt_1.ex_7_8;

import java.util.Scanner;

public class ComptadorUnDigitTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comptador comptador = new Comptador();

        int option;
        do {
            runGUI();
            option = sc.nextInt();
            runMenu(option, comptador);
            if (comptador.getDigit() == 10) {
                comptador.setDigit(0);
            }
        }while(option != 0);
    }
    public static void runGUI(){
        System.out.println("1. Posar comptador a 0");
        System.out.println("2. Incrementar el valor");
        System.out.println("3. Consultar valor del comptador");
        System.out.println("0. Tancar programa");
    }
    public static void runMenu(int option, Comptador comptador){
        switch (option){
            case 1:
                comptador.posarComptadorAZero();
                break;
            case 2:
                comptador.incrementarValor();
                break;
            case 3:
                comptador.consultarValor();
                break;
            case 0:
                System.out.println("El programa es tanca...");
                System.exit(0);
                break;
            default:
                System.out.println("No es una opción válida");
        }
    }
}
