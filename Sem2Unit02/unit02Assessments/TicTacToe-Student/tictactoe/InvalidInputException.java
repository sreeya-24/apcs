package tictactoe;

/**
 * Exception for invalid user input.
 */
public class InvalidInputException extends Exception {
    /**
     * Default InvalidInputException.
     */
    public InvalidInputException() {
        super("Invalid input. Please enter a two-character move that " +
              "indicates a row and a column. Example: A2");
    }
    
    /**
     * Allows creation of an InvalidInputException with a custom message.
     * @param message Message detailing the cause of the exception.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
