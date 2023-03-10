public class Position {
    private final char column;
    private final int row;

    public Position(char column, int row){
        this.column = column;
        this.row = row;
    }

    public String toString() {
        String position = this.column + Integer.toString(this.row);
        return position;
    }
}
