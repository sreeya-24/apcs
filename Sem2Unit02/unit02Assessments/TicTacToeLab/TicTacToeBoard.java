 

/**
 * Represents and maintains a Tic-Tac-Toe board. Accepts move input in various 
 * forms and throws exceptions for invalid or illegal entries. Places
 * valid moves and determines if the game has been won. Displays the board
 * contents.
 */
public class TicTacToeBoard {
    private final char[][] grid = new char[3][3];
    public static final char SPACE = ' ';
    
    /**
     * Fills the grid with space characters.
     */
    public TicTacToeBoard() {
        /** Make a call to clearGrid() here. */
        clearGrid();

    }
    
    /**
     * Validates a human player's String input for a mExample: A2
     * 
     * ove. 
     * @param input A string that is expected to be a two-character keyboard
     * entry from the user representing a row and a column.
     * @param mark The mark (X or O) the calling Player wishes to place on the
     * board.
     * @return <code>true</code> if the move resulted in a winning game, 
     * <code>false</code> otherwise.
     * @throws InvalidInputException if the input is not two characters 
     * long and does not contain a valid letter for the first character 
     * and a valid number for the second character, both within the range 
     * of the board.
     * @throws IllegalMoveException if the move attempts to place a mark 
     * on a space that is already occupied.
     */
    public boolean move(String input, char mark) throws InvalidInputException,
            IllegalMoveException, NullInputException {
        /**
         * Check for the following cases.
         * 1. If the input is null, throw a NullInputException.
         * 2. The input must have exactly two characters. If it does not, 
         *    throw a default InvalidInputException.
         * 3. The first character of the input must be a letter indicating a
         *    row on the board: 'A' through 'C'. The user can enter this data
         *    as uppercase or lowercase. The second character of the input must
         *    be a number indicating a column on the board: '1' through '3'. If
         *    the characters do not meet these specifications, throw a
         *    default InvalidInputException.
         */

        if (input == null) {
            throw new NullInputException();
        }
        
        if (input.length() != 2) {
            throw new InvalidInputException();
        }
        
        String firstChar=input.substring(0,1).toUpperCase();

        if (!firstChar.equals("A") && !firstChar.equals("B") && !firstChar.equals("C")) {
            throw new InvalidInputException();
        }
        
        String secondChar=input.substring(1,2);
        if (!secondChar.equals("1") && !secondChar.equals("2") && !secondChar.equals("3")) {
            throw new InvalidInputException();
        }
        /** 
         * Find a way to convert the characters in the input to variables of
         * type int that correspond to rows and columns in the grid. Assign
         * these values to variables row and col. For example, if the input
         * is "A3", the row would be 0 and the col would be 2.
         */
        int row=0;
        int col=0;
        
        if(firstChar.equalsIgnoreCase("A"))
        {
         row = 0; 
        } else if(firstChar.equalsIgnoreCase("B")) {
          row = 1; 
        } else if(firstChar.equalsIgnoreCase("C")) {
          row = 2;
        }
        
        col = Integer.parseInt(secondChar) - 1;  
        // Now that we have converted the input to variables of type int for
        // row and col, call the move method that processes these values and
        // return the results.
        /** Uncomment the line below when the code listed above is complete. */
        return move(row, col, mark);

    }
    
    /**
     * Validates and processes row and column int values for a move. 
     * @param row Value representing the row.
     * @param col Value representing the column.
     * @param mark The mark (X or O) the calling Player wishes to place on the
     * board.
     * @return <code>true</code> if the move resulted in a winning game, 
     * <code>false</code> otherwise
     * @throws IllegalMoveException if the move attempts to place a
     * mark on a space that is already occupied.
     */
    public boolean move(int row, int col, char mark) 
            throws IllegalMoveException {
        /**
         * 1. Check to see if the incoming move tries to place a mark on a
         *    space that is already occupied with X or O. If it is, throw 
         *    a default IllegalMoveException.
         * 
         * 2. If no exception was thrown, change the grid character at the
         *    row, col coordinates to the passed in mark.
         * 
         * 3. Call isWin() and isTie(). If either of these methods returns
         *    true, return true from move().
         */


        /** Temporary return statement. Remove when code above is complete. */
        if (grid[row][col] == 'X' || grid[row][col] == 'O') {
            throw new IllegalMoveException(); 
        }
        
        grid[row][col] = mark;
        
        if (isWin(mark) || isTie()) {
            return true;
        }
        return false;
    }
    
    /**
     * Returns the character at a specified grid location.
     * @param row Value representing the row.
     * @param col Value representing the column.
     * @return Character at grid location specified by row and column.
     */
    public char getSpace(int row, int col) {
        /** Return the mark stored at the specified location. */
        return grid[row][col];
    }
    
    // The isWin() method records if a game has been won here so isTie()
    // can check the result without running isWin() again.
    private boolean gameHasBeenWon = false;
    /**
     * Determines if the board has been won with a specified mark.
     * @param mark A mark to search for (X or O).
     * @return <code>true</code> if the board has been won by the specified 
     * mark.
     */
    boolean isWin(char mark) {
        // If the game has already been recorded as won, return true.
        if (gameHasBeenWon) return true;
        /**
         * Using the incoming mark, implement nested loops to loop through the
         * columns and diagonals, checking each character in every column and
         * diagonal o see if there are three marks in a line. If any
         * winning line is found, complete the following directives:
         *   1. Set gameHasBeenWon to true.
         *   2. Return the value of gameHasBeenWon. 
         *
         * The check for horizontal wins is provided for you.
         */
        // Check for horizontal wins.
        for (int row = 0; row < 3; row++) {
            boolean win = true;
            for (int col = 0; col < 3; col++) {
                if (grid[row][col] != mark) win = false;
            }
            if (win) {
                gameHasBeenWon = true;
                return gameHasBeenWon;
            }
        }
        
          // Check for vertical wins.
        for (int row = 0; row < 3; row++) {
            boolean win = true;
            for (int col = 0; col < 3; col++) {
                if (grid[col][row] != mark) win = false;
            }
            if (win) {
                gameHasBeenWon = true;
                return gameHasBeenWon;
            }
        }
        
        // diagnal left- right
        boolean win = true;
           for (int row = 0; row < 3; row++) {
              if(grid[row][row] != mark) {
                 win=false;
              }
           } 

        if (win) {
            gameHasBeenWon = true;
            return gameHasBeenWon;
        }
        
        // diagoal right-left
         win = true;
         int col = 2;
           for (int row = 0; row < 3; row++) {
              if(grid[row][col] != mark) {
                 win=false;
              }
              col -= 1;
           } 

        if (win) {
            gameHasBeenWon = true;
            return gameHasBeenWon;
        }
        // Return false if you have not returned true anywhere.
        return false;
    }
    
    /**
     * Determines if the game has resulted in a tie.
     * @return <code>true</code> if the game is a tie.
     */
    boolean isTie() {
        // If game has already been recorded as won, then it cannot be a tie.
        if (gameHasBeenWon) return false;
        
        // If there are any spaces on the board, return false, because it is
        // not a tie.
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col] == SPACE) return false;
            }
        }
        
        // If the game was not won, but all the spaces are full, it is a tie.
        return true;
    }
    
    final String SPACER = "   ";
    /**
     * Displays the board.
     */
    public void display() {
        final String CROSSBAR = SPACER + "-----------";
        System.out.println("    1   2   3");
        for (int row = 0; row < 2; row++) {
            printRow(row);
            System.out.println(CROSSBAR);
        }
        printRow(2);
    }

    /**
     * Utility method called by display.
     * @param row The row to be displayed.
     */
    private void printRow(int row) {
        System.out.print((char)('A' + row) + SPACER + grid[row][0]);
        for (int col = 1; col < 3; col++) {
            System.out.print(" | " + grid[row][col]);
        }
        System.out.println();
    }
    
    /**
     * Fills the grid with SPACE characters.
     */
    private void clearGrid() {
        /** 
         * Use a nested loop to loop through all the elements of the grid
         * and fill every element with the SPACE character.
         */
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = SPACE;
            }
        }
    }
}
