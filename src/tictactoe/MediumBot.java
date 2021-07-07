package tictactoe;

import java.util.Random;

public class MediumBot extends Player {

    public MediumBot(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        Random random = new Random();

        int x, y;
        //char[][] b = board.getBoard();
        char symbol = getSymbol();
        char opponentSymbol = symbol == 'X' ? 'O' : 'X';

        System.out.println("Making move level \"medium\"");

        //check if there's a winning move (already two symbols in a row)
        for (int col = 1; col < 4; col++) {
            for (int row = 1; row < 4; row++) {
                if (board.checkSymbol(col, row) == ' ') {
                    board.placeMove(col, row, symbol);
                    if (board.checkResult() == GameState.WIN) {
                        board.placeMove(col, row, ' ');
                        return new int[]{col, row};
                    }
                    board.placeMove(col, row, ' ');
                }
            }
        }
        //check if there's a winning move for the opponent
        for (int col = 1; col < 4; col++) {
            for (int row = 1; row < 4; row++) {
                if (board.checkSymbol(col, row) == ' ') {
                    board.placeMove(col, row, opponentSymbol);
                    if (board.checkResult() == GameState.WIN) {
                        board.placeMove(col, row, ' ');
                        return new int[]{col, row};
                    }
                    board.placeMove(col, row, ' ');
                }
            }
        }

        while (true) {
            x = random.nextInt(3) + 1;
            y = random.nextInt(3) + 1;

            if (board.checkSymbol(y, x) == ' ') {
                return new int[]{y, x};
            }
        }
    }

}