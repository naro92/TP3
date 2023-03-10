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
            for (int j = 0; j < 8; i++) {
                this.board[i][j] = new Cell(new Position(columns[j], i));
            }
        }
    }
}
