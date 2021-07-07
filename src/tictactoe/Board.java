package tictactoe;

import java.util.Arrays;

public class Board {
    private final char[][] board;

    public Board() {
        this.board = new char[3][3];

        for (char[] row : this.board) {
            Arrays.fill(row, ' ');
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public char checkSymbol(int col, int row) {
        return board[col - 1][row - 1];
    }

    public void placeMove(int col, int row, char symbol) {
        this.board[col - 1][row - 1] = symbol;
    }


    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + this.board[i][0] + ' ' +
                    this.board[i][1] + ' ' + this.board[i][2] + " |");
        }
        System.out.println("---------");
    }

    //returns 1 if win, 0 if draw, -1 if game continues
    public GameState checkResult() {
        //check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return GameState.WIN;
            } else if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return GameState.WIN;
            }
        }
        //check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return GameState.WIN;
        } else if (board[2][0] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return GameState.WIN;
        }

        //check possibility to continue
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                if (board[col][row] == ' ') {
                    return GameState.GAME_CONTINUES;
                }
            }
        }
        return GameState.DRAW;
    }
}
