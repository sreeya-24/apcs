 

/**
 * Parent class for all Player objects. 
 */
public abstract class Player {
    protected TicTacToeBoard board;
    protected char mark;
    
    /**
     * Accepts a reference to the game board and the player's mark.
     * @param board Reference to the game board.
     * @param mark The player's mark.
     */
    public Player(TicTacToeBoard board, char mark) {
        this.board = board;
        this.mark = mark;
    }
    
    /**
     * Attempts a move. 
     * @return True if the move results in a win.
     */
    public abstract boolean makeMove();

    /**
     * Returns the name of the Player.
     * @return Name of the player.
     */
    public abstract String getName();
}
