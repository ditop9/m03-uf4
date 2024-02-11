package pt_1.ex_4_5;

import java.util.Scanner;

public class SchoolTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            showMenu();
            option = sc.nextInt();
            runMenu(option);
        }while (option != 0);

    }
    public static void showMenu(){
        System.out.println("1. Introducir nuevo usuario");
        System.out.println("2. Encontrar usuario en BBDD");
        System.out.println("3. Mostrar todos los usuarios");
        System.out.println("0. Cerrar el programa");
    }
    public static void runMenu(int option) {
        switch (option) {
            case 1:
                SchoolDataBase.setUser();
                break;
            case 2:
                SchoolDataBase.getUser();
                break;
            case 3:
                SchoolDataBase.getUsers();
                break;
            case 0:
                System.out.println("Cerrando el programa...");
                System.exit(0);
                break;
        }
    }
}
