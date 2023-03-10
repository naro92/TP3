public class Player {
    private final String name;
    private final int color;
    public Player(String name , int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public int getColor() {
        return this.color;
    }
}
