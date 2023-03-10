public class Knight {
    private Position position;
    private final int color;

    public Knight(int color, Position position) {
        this.color = color;
        this.position = position;
    }

    public String toString() {
        return "N";
    }

    public int getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }
}
