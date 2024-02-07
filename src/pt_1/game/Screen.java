package pt_1.game;

public class Screen {
    public Screen(){
        Screen screen = new Screen();
    }
    public static void crearPantalla(int x, int y){
        char[][] screen = new char[25][60];
        for (int i = screen.length - 1; i >= 0; i--) {
            for (int j = 0; j < screen[i].length; j++) {
                if (i == y && j == x) {
                    screen[i][j] = 0x25A1;
                }else screen[i][j] = 0x25A0;
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}
