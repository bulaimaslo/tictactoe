package tictactoe;

import java.util.Scanner;

public class User extends Player {
    public User(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        int x, y;
        int[] input;
        char[][] b = board.getBoard();

        while (true) {
            System.out.println("Enter the coordinates: ");
            input = handleInput();
            y = input[0];
            x = input[1];

            if (x > 3 || x < 1 || y > 3 || y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (b[y - 1][x - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                return new int[]{y, x};
            }
        }
    }

    private static int[] handleInput() {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[2];

        for (int i = 0; i < 2; i++) {
            if (!sc.hasNextInt()) {
                System.out.println("You should enter numbers!");
                sc.next(); // discard
            } else {
                input[i] = sc.nextInt();
            }
        }
        return input;
    }
}
