public class Queen {
    private Position position;
    private final int color;

    public Queen(int color, Position position) {
        this.color = color;
        this.position = position;
    }

    public String toString() {
        return "Q";
    }

    public int getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }
}
