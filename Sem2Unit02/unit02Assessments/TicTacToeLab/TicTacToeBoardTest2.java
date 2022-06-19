 

/**
 * The following is a short program that tests the coding of class
 * TicTacToeBoard from Lab Exercise 2.
 */
public class TicTacToeBoardTest2 {
    /**
     * Use the special main method for testing the TicTacToeBoard class only.
     */
    public static void main(String[] args) {
        System.out.println("\nTicTacToeBoard test 2 results:");
        
        TicTacToeBoard testBoard = new TicTacToeBoard();
        try {
            testBoard.move(1, 1, 'X');
            testBoard.move(2, 2, 'O');
            testBoard.move(2, 0, 'X');
            System.out.println();  
            testBoard.display();
            printMessage("Not a win", !testBoard.isWin('X'));
        } catch (IllegalMoveException ime) {
            System.out.println("Error: illegal move not expected: " + ime);
        }
        
        testBoard = new TicTacToeBoard();
        try {
            testBoard.move(2, 0, 'X');
            testBoard.move(2, 1, 'X');
            testBoard.move(2, 2, 'X');
            System.out.println();
            testBoard.display();
            printMessage("Horizontal win", testBoard.isWin('X'));
        } catch (IllegalMoveException ime) {
            System.out.println("Error: illegal move not expected: " + ime);
        }
        
        testBoard = new TicTacToeBoard();
        try {
            testBoard.move(0, 1, 'O');
            testBoard.move(1, 1, 'O');
            testBoard.move(2, 1, 'O');
            System.out.println();  
            testBoard.display();
            printMessage("Vertical win", testBoard.isWin('O'));
        } catch (IllegalMoveException ime) {
            System.out.println("Error: illegal move not expected: " + ime);
        }

        testBoard = new TicTacToeBoard();
        try {
            testBoard.move(0, 0, 'X');
            testBoard.move(1, 1, 'X');
            testBoard.move(2, 2, 'X');
            System.out.println();
            testBoard.display();
            printMessage("Diagonal win 1", testBoard.isWin('X'));
        } catch (IllegalMoveException ime) {
            System.out.println("Error: illegal move not expected: " + ime);
        }
        
        testBoard = new TicTacToeBoard();
        try {
            testBoard.move(0, 2, 'X');
            testBoard.move(1, 1, 'X');
            testBoard.move(2, 0, 'X');
            System.out.println();
            testBoard.display();
            printMessage("Diagonal win 2", testBoard.isWin('X'));
        } catch (IllegalMoveException ime) {
            System.out.println("Error: illegal move not expected: " + ime);
        }
        
        testBoard = new TicTacToeBoard();
        try {
            char[] marks = {'O', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'X'};
            int index = 0;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    testBoard.move(row, col, marks[index]);
                    index++;
                }
            }
            System.out.println();
            testBoard.display();
            printMessage("Tie game not a win", !testBoard.isWin('X'));
            printMessage("Tie game", testBoard.isTie());
        } catch (IllegalMoveException ime) {
            System.out.println("Error: illegal move not expected: " + ime);
        }
    }
    
    private static void printMessage(String testCase, boolean passed) {
        System.out.println(testCase + "? " + passed);
        if (passed) {
            System.out.println("Good: " + testCase + " handled.");
        } else {
            System.out.println("Error: " + testCase + " not handled.");
        }
    }
}