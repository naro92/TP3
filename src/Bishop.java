public class Bishop {
    private Position position;
    private final int color;

    public Bishop(int color, Position position) {
        this.color = color;
        this.position = position;
    }

    public String toString() {
        return "B";
    }

    public int getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }

}
