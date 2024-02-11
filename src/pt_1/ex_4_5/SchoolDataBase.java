package pt_1.ex_4_5;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolDataBase {
    static ArrayList<UserSchool> userDB = new ArrayList<>();

    public static void setUser() {
        String name = introducirNombre();
        int age = introducirEdad();
        boolean rol = introducirRol();

        UserSchool user = new UserSchool(name, age, rol);
        System.out.println(user);

        userDB.add(user);
    }
    public static String introducirNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca los datos para el usuario");
        System.out.println("Introduzca el nombre:");
        return sc.nextLine();
    }
    public static int introducirEdad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la edad:");
        return sc.nextInt();
    }
    public static boolean introducirRol() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Es profesor?");
        System.out.println("TRUE | FALSE");
        return sc.nextBoolean();

    }
    public static void getUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que usuario desea buscar?");
        int option = (sc.nextInt() - 1);
        System.out.println(userDB.get(option));
    }
    public static void getUsers(){
        for (int i = 0; i < userDB.size(); i++) {
            System.out.println((i + 1) + ". " + userDB.get(i));
        }
    }
}
