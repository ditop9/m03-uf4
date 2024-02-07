package pt_1.game;

public class Position {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void incX() {
        setX(getX() + 1);
    }
    public void incY() {
        setY(getY() + 1);
    }
    public void decX() {
        setX(getX() - 1);
    }
    public void decY() {
        setY(getY() - 1);
    }
    public void setXY(int x, int y){
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return y + " " + x;
    }
}
