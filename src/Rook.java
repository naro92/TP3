public class Rook {
    private Position position;
    private final int color;

    public Rook(int color, Position position) {
        this.color = color;
        this.position = position;
    }

    public String toString() {
        return "R";
    }

    public int getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }
}
