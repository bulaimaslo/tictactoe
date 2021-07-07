package tictactoe;

public abstract class Player {
    private final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public abstract int[] makeMove(Board board);

    public char getSymbol() {
        return symbol;
    }
}
