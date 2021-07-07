package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String command, player1Type, player2Type;
        String[] input;

        while (true) {
            input = selectDifficulty();

            command = input[0];
            if ("exit".equals(command)) {
                break;
            }

            player1Type = input[1];
            player2Type = input[2];

            Game game = new Game(player1Type, player2Type);
            game.start();
        }
    }

    private static String[] selectDifficulty() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input command: ");

        while (true) {
            String[] input = sc.nextLine().split("\\s+");

            if ("exit".equals(input[0])) {
                return input;
            }
            if (input.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            } else if (!"start".equals(input[0])) {
                System.out.println("Bad parameters!");
                continue;
            } else if (!("easy".equals(input[1]) || "user".equals(input[1]) || "medium".equals(input[1]) || "hard".equals(input[1]))) {
                if (!("easy".equals(input[2]) || "user".equals(input[2]) || "medium".equals(input[2]) || "hard".equals(input[2]))) {
                    System.out.println("Bad parameters!");
                    continue;
                }
            }
            return input;
        }
    }

}
