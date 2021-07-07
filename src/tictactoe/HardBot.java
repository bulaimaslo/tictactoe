package tictactoe;

public class HardBot extends Player {

    public HardBot(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        int x = 0, y = 0, bestVal = Integer.MIN_VALUE, result;
        char symbol = getSymbol();

        System.out.println("Making move level \"hard\"");

        //check if there's a winning move (already two symbols in a row)
        for (int col = 1; col < 4; col++) {
            for (int row = 1; row < 4; row++) {
                if (board.checkSymbol(col, row) == ' ') {
                    board.placeMove(col, row, symbol);
                    result = minimax(board, symbol, false);
                    if (result > bestVal) {
                        x = row;
                        y = col;
                        bestVal = result;
                    }
                    board.placeMove(col, row, ' ');
                }
            }
        }
        return new int[]{y, x};
    }

    private static int minimax(Board board, char symbol, boolean isMaximizing) {
        char opponentSymbol = symbol == 'X' ? 'O' : 'X';
        int bestVal;


        if (board.checkResult() == GameState.WIN) {
            if (isMaximizing) {
                return -1;
            } else {
                return 1;
            }
        } else if (board.checkResult() == GameState.DRAW) {
            return 0;
        }

        if (isMaximizing) {
            bestVal = -2;
            for (int col = 1; col < 4; col++) {
                for (int row = 1; row < 4; row++) {
                    if (board.checkSymbol(col, row) == ' ') {
                        board.placeMove(col, row, symbol);
                        bestVal = Math.max(bestVal, minimax(board, symbol, false));
                        board.placeMove(col, row, ' ');
                    }
                }
            }
        } else {
            bestVal = 2;
            for (int col = 1; col < 4; col++) {
                for (int row = 1; row < 4; row++) {
                    if (board.checkSymbol(col, row) == ' ') {
                        board.placeMove(col, row, opponentSymbol);
                        bestVal = Math.min(bestVal, minimax(board, symbol, true));
                        board.placeMove(col, row, ' ');
                    }
                }
            }
        }
        return bestVal;
    }

}