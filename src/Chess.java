import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Chess {
    private final char[] columns = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private final char[] pieces = new char[]{'K', 'Q', 'R', 'B', 'N'};
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
        for (int i = 0 ; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = new Cell(new Position(this.columns[j], i));
                if (i == 0 || i == 7) {
                    if (j == 0 || j == 7) {
                        this.board[i][j].setPiece(new Rook(i/7, new Position(this.columns[j], i)));
                    } else if (j == 1 || j == 6) {
                        this.board[i][j].setPiece(new Knight(i/7, new Position(this.columns[j], i)));
                    } else if (j == 2 || j == 5) {
                        this.board[i][j].setPiece(new Bishop(i/7, new Position(this.columns[j], i)));
                    } else if (j == 3) {
                        this.board[i][j].setPiece(new Queen(i/7, new Position(this.columns[j], i)));
                    } else {
                        this.board[i][j].setPiece(new King(i/7, new Position(this.columns[j], i)));
                    }
                } else if (i == 1) {
                    this.board[i][j].setPiece(new Pawn(0, new Position(this.columns[j], i)));
                } else if (i == 6) {
                    this.board[i][j].setPiece(new Pawn(1, new Position(this.columns[j], i)));
                }
            }
        }
    }

    public void switchPlayer(){
        if (this.currentPlayer == this.players[0]) {
            this.currentPlayer = this.players[1];
        } else {
            this.currentPlayer = this.players[0];
        }
    }

    public String askMove() {
        SafeScanner sc = new SafeScanner(System.in);
        return sc.getString();
    }

    public boolean isValidMove(String move) {
        boolean result = false;
        int currentPlayerColor = this.currentPlayer.getColor();
        int otherPlayerColor = abs(currentPlayerColor - 1);
        for (char column : this.columns) {
            for (char piece : this.pieces) {
                for (int i = 0; i < 8; i++) {
                    if (move.contains(Character.toString(piece)) && move.contains(Character.toString(column)) && move.contains(Integer.toString(i+1))) {
                        for (int j = 0 ; j < 8; j++) {
                            for (Cell cell : this.board[j]) {
                                if (cell.getPiece().equals(Character.toString(piece))) {
                                    String pieceColumn = cell.getPiece().substring(0, 1);
                                    int pieceRow = Integer.parseInt(cell.getPiece().substring(1));
                                    String columnsAsString = new String(this.columns);
                                    if (columnsAsString.indexOf(column) == columnsAsString.indexOf(pieceColumn) && i == pieceRow) {
                                        System.out.println("Vous ne pouvez pas bouger une pièce sur la case où elle se trouve déja.");
                                    } else {
                                        if (piece == 'K') {
                                            if ((columnsAsString.indexOf(column) == columnsAsString.indexOf(pieceColumn) || columnsAsString.indexOf(column) == columnsAsString.indexOf(pieceColumn) + 1 || columnsAsString.indexOf(column) == columnsAsString.indexOf(pieceColumn) - 1) && (i == pieceRow || i == pieceRow + 1 || i == pieceRow - 1)) {
                                                result = true;
                                            } else {
                                                System.out.println("Ce coup n'est pas valide");
                                            }
                                        }

                                        else if (piece == 'Q') {
                                            if ((columnsAsString.indexOf(column) == columnsAsString.indexOf(pieceColumn) || i == pieceRow) || (abs(columnsAsString.indexOf(column) - columnsAsString.indexOf(pieceColumn)) == abs(i - pieceRow)) ) {
                                                result = true;
                                            } else {
                                                System.out.println("Ce coup n'est pas valide.");
                                            }
                                        }

                                        else if (piece == 'R') {
                                            if (columnsAsString.indexOf(column) == columnsAsString.indexOf(pieceColumn) || i == pieceRow) {
                                                result = true;
                                            } else {
                                                System.out.println("Ce coup n'est pas valide.");
                                            }
                                        }

                                        else if (piece == 'B') {
                                            if (abs(columnsAsString.indexOf(column) - columnsAsString.indexOf(pieceColumn)) == abs(i - pieceRow)) {
                                                result = true;
                                            } else {
                                                System.out.println("Ce coup n'est pas valide.");
                                            }
                                        }

                                        else if (piece == 'N') {
                                            if (abs(columnsAsString.indexOf(column) - columnsAsString.indexOf(pieceColumn)) + abs(i - pieceRow) == 3) {
                                                result = true;
                                            } else {
                                                System.out.println("Ce coup n'est pas valide.");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Le coup demandé n'est pas sous le bon format.");
                    }
                }
            }
        }
        return result;
    }
}
