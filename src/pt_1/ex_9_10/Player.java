package pt_1.ex_9_10;

public class Player {
    private final String NAME;
    private Position position;
    public Player(String name, int x, int y) {
        this.NAME = name;
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void moveRight() {
        position.incX();
    }
    public void moveLeft() {
        position.decX();
    }
    public void jump() {
        position.incY();
    }
    public void fall() {
        position.decY();
    }

    @Override
    public String toString() {
        return "Player: " + NAME;
    }
}
