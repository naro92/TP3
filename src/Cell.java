public class Cell {
    private final Position position;
    private boolean isEmpty;
    private String piece;

    public Cell(Position position) {
        this.position = position;
    }

    public void setPiece(String piece) {
        this.piece = piece;
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
}
