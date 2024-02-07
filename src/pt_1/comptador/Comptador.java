package pt_1.comptador;

public class Comptador {
    private int digit = 0;
    public int getDigit() {
        return digit;
    }
    public void setDigit(int digit) {
        this.digit = digit;
    }
    public void posarComptadorAZero() {
        this.setDigit(0);
    }
    public void incrementarValor() {
        this.setDigit(getDigit() + 1);
    }
    public void consultarValor(){
        System.out.println(getDigit());
    }
}
