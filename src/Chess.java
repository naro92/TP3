import java.util.Scanner;

public class Chess {
    private Cell[][] board;
    private Player[] players;
    private Player currentPlayer;
    public void play() {
        while (true) {
            createPlayers();
            initialiseBoard();
            while (!isCheckMate()) {
                printBoard();
                String move;
                do {
                    move = askMove();
                }
                while (!isValidMove(move));
                updateBoard(move);
                switchPlayer();
            }
        }
    }

    public void createPlayers(){
        for (int i = 0; i < 2; i++) {
            System.out.println("Quel est le nom du joueur ?");
            String name = new Scanner(System.in).next();
            this.players[i] = new Player(name, i);
        }
    }

    public void initialiseBoard(){
        char[] columns = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        for (int i = 0 ; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = new Cell(new Position(columns[j], i));
                if (i == 0 || i == 7) {
                    if (j == 0 || j == 7) {
                        this.board[i][j].setPiece(new Rook(i/7, new Position(columns[j], i)));
                    } else if (j == 1 || j == 6) {
                        this.board[i][j].setPiece(new Knight(i/7, new Position(columns[j], i)));
                    } else if (j == 2 || j == 5) {
                        this.board[i][j].setPiece(new Bishop(i/7, new Position(columns[j], i)));
                    } else if (j == 3) {
                        this.board[i][j].setPiece(new Queen(i/7, new Position(columns[j], i)));
                    } else {
                        this.board[i][j].setPiece(new King(i/7, new Position(columns[j], i)));
                    }
                } else if (i == 1) {
                    this.board[i][j].setPiece(new Pawn(0, new Position(columns[j], i)));
                } else if (i == 6) {
                    this.board[i][j].setPiece(new Pawn(1, new Position(columns[j], i)));
                }
            }
        }
    }
}
