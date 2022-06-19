 

/**
 * The following is a short program that tests the coding of class
 * TicTacToeBoard from Lab Exercise 1.
 */
import java.util.Scanner;
public class TicTacToeBoardTest1 {
    /**
     * Use the special main method for testing the TicTacToeBoard class only.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac toe.");
        System.out.println("****New Game****");
        
        TicTacToeBoard testBoard = new TicTacToeBoard();
        testBoard.display();
        System.out.println();

        testGridSpace(testBoard, 0, 0);
        testGridSpace(testBoard, 2, 2);
        
        String test = "null input string";
        try { 
            testBoard.move(null, 'X');
            printErrorMessage(test);
        } catch (InvalidInputException e) {
            printGoodMessage(test);
        } catch (IllegalMoveException f) {}

        test = "Short input string";
        try { 
            testBoard.move("a", 'X');
            printErrorMessage(test);
        } catch (InvalidInputException e) {
            printGoodMessage(test);
        } catch (IllegalMoveException f) {}

        test = "Long input string";
        try { 
            testBoard.move("abc", 'X');
            printErrorMessage(test);
        } catch (InvalidInputException e) {
            printGoodMessage(test);
        } catch (IllegalMoveException f) {}
    
        test = "Invalid characters test 1";
        try { 
            testBoard.move("C0", 'X');
            printErrorMessage(test);
        } catch (InvalidInputException e) {
            printGoodMessage(test);
        } catch (IllegalMoveException f) {}
    
        test = "Invalid characters test 2";
        try { 
            testBoard.move("2A", 'X');
            printErrorMessage(test);
        } catch (InvalidInputException e) {
            printGoodMessage(test);
        } catch (IllegalMoveException f) {}
    }

    private static void testGridSpace(TicTacToeBoard board, int row, int col) {
        if (board.getSpace(row, col) != TicTacToeBoard.SPACE) 
            System.out.println("Error: char at grid(" + row + ", " + col +
                ") is not a space. Retrieved decimal Unicode value: " + 
                (int)board.getSpace(row, col) + ". Expected: " + 
                (int)TicTacToeBoard.SPACE + ".");
        else
            System.out.println("Good: char at grid(" + row + ", " + col +
                ") is a space.");
    }
    
    private static void printErrorMessage(String s) {
        System.out.println("Error: " + s + " not handled.");
    }
    
    private static void printGoodMessage(String s) {
        System.out.println("Good: " + s + " handled.");
    }
    
}

