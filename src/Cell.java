public class Cell {
    private final Position position;
    private boolean isEmpty;
    private String piece;
    private int color;

    public Cell(Position position) {
        this.position = position;
    }

    public void setPiece(String piece, int color) {
        this.piece = piece;
        this.color = color;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getPiece() {
        return this.piece;
    }

    public int getColor() {return this.color;}

}
