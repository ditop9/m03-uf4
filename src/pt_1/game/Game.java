package pt_1.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static ArrayList<Player> playerDB = new ArrayList<>();

    public static void main(String[] args) {
        runApp();
    }
    public static void runApp() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            runGUI();
            option = sc.nextInt();
            runSelectOption(option);
        }while (option != 0);
    }
    public static void runGUI(){
        System.out.println("1. Afegir nou jugador");
        System.out.println("2. Eliminar jugador");
        System.out.println("3. Reset partida");
        System.out.println("4. Mostrar jugadors");
        System.out.println("5. Moure jugador");
        System.out.println("0. Tancar programa");
    }
    public static void runSelectOption(int option) {
        switch (option) {
            case 1:
                afegirNouJugador();
                break;
            case 2:
                eliminarJugador();
                break;
            case 3:
                resetPartida();
                break;
            case 4:
                mostrarJugador();
                break;
            case 5:
                moureJugador();
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
    public static void afegirNouJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom del jugador:");
        Player player = new Player(sc.nextLine(),30, 12);
        playerDB.add(player);
    }
    public static void eliminarJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quin és el jugador que voleu eliminar?");
        for (int i = 0; i < playerDB.size(); i++) {
            System.out.println((i + 1) + ". " + playerDB.get(i));
        }
        int jugadorAEliminar = ((sc.nextInt() - 1));
        System.out.println("S'ha eliminat el jugador " + playerDB.get(jugadorAEliminar));
        playerDB.remove(jugadorAEliminar);

    }
    public static void resetPartida() {
        for (int i = 0; i < playerDB.size(); i++) {
            //noinspection SuspiciousListRemoveInLoop
            playerDB.remove(i);
        }
    }
    public static void mostrarJugador() {
        for (int i = 0; i < playerDB.size(); i++) {
            System.out.println((i + 1) + ". " + playerDB.get(i));
        }
        System.out.println();
    }
    public static void moureJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Com quin jugador voleu jugar");
        mostrarJugador();
        int player = (sc.nextInt() - 1);
        char option;
        do {
            option = sc.next().charAt(0);
            switch (option) {
                case 'w':
                    playerDB.get(player).jump();
                    mostrarPosicio(playerDB.get(player));
                    break;
                case 'a':
                    playerDB.get(player).moveLeft();
                    mostrarPosicio(playerDB.get(player));
                    break;
                case 's':
                    playerDB.get(player).fall();
                    mostrarPosicio(playerDB.get(player));
                    break;
                case 'd':
                    playerDB.get(player).moveRight();
                    mostrarPosicio(playerDB.get(player));
                    break;
                case '0':
                    runApp();
                    break;
                default:
                    break;
            }
            System.out.println(playerDB.get(player).getPosition());
        }while (option != 0);

    }
    public static void mostrarPosicio(Player player) {
        Position position = player.getPosition();
        int x = position.getX();
        int y = position.getY();
        Screen.crearPantalla(x, y);
    }
}
