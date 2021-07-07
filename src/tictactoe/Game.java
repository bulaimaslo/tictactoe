package tictactoe;

public class Game {

    private boolean finished = false;
    private int moveCount = 0;
    private Player currentPlayer, player1, player2;   //user, easy, medium
    private final Board board;

    public Game(String p1, String p2) {

        board = new Board();

        switch (p1) {
            case "user":
                player1 = new User('X');
                break;
            case "easy":
                player1 = new EasyBot('X');
                break;
            case "medium":
                player1 = new MediumBot('X');
                break;
            case "hard":
                player1 = new HardBot('X');
                break;
        }
        switch (p2) {
            case "user":
                player2 = new User('O');
                break;
            case "easy":
                player2 = new EasyBot('O');
                break;
            case "medium":
                player2 = new MediumBot('O');
                break;
            case "hard":
                player2 = new HardBot('O');
                break;
        }
        currentPlayer = player1;
    }

    public void start() {
        int[] position;
        board.printBoard();

        //while (!finished) {
        while (!finished) {
            position = currentPlayer.makeMove(board);
            board.placeMove(position[0], position[1], currentPlayer.getSymbol());
            moveCount++;

            finished = checkWin(board);
            if (finished) {
                System.out.println(currentPlayer.getSymbol() + " wins");
                System.out.println();
            } else if (moveCount == 9) {
                finished = true;
                System.out.println("Draw");
                System.out.println();
            }

            currentPlayer = currentPlayer == player1 ? player2 : player1;
            board.printBoard();
        }

    }

    private static boolean checkWin(Board b) {
        char[][] board = b.getBoard();
        //check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            } else if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }
        //check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        } else
            return board[2][0] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0];
    }
}
