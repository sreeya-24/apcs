package tictactoe;

/**
 * Exception for valid input, but illegal moves.
 */
public class IllegalMoveException extends Exception {
    public IllegalMoveException() {
        super("That space is already occupied.");
    }
}
