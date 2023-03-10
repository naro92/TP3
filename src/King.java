public class King {
    private Position position;
    private final int color;

    public King(int color, Position position) {
        this.color = color;
        this.position = position;
    }

    public String toString() {
        return "K";
    }

    public int getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }
}
