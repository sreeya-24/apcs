package tictactoe;

/**
 * Exception for null user input.
 */
public class NullInputException extends InvalidInputException {
    public NullInputException() {
        super("Null input received.");
    }
}
