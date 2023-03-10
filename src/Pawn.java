public class Pawn {
    private Position position;
    private final int color;

    public Pawn(int color, Position position) {
        this.color = color;
        this.position = position;
    }

    public String toString() {
        return "P";
    }

    public int getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }
}
