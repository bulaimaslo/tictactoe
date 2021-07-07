package tictactoe;

import java.util.Random;

public class EasyBot extends Player {

    public EasyBot(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        Random random = new Random();

        int x, y;
        char[][] b = board.getBoard();

        System.out.println("Making move level \"easy\"");

        while (true) {
            y = random.nextInt(3) + 1;
            x = random.nextInt(3) + 1;

            if (b[y - 1][x - 1] == ' ') {
                return new int[]{y, x};
            }
        }
    }
}
