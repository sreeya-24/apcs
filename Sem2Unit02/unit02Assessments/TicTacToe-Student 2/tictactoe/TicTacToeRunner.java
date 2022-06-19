package tictactoe;

import java.util.Scanner;

/**
 * The starting point and controlling object for a Tic-Tac-Toe game.
 */
public class TicTacToeRunner {
    /**
     * Creates a game board, sets up players, and controls
     * the flow of the game.
     */
    public TicTacToeRunner() {
        // Display a welcome message. 
        System.out.println("Welcome to Tic Tac Toe.");
        
        boolean done = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!done) {
            // Display a new game message.
            System.out.println("\n***** New Game *****");

            // Create a board.
            TicTacToeBoard board = new TicTacToeBoard();

            // Decide who goes first. Based on the outcome of a coin toss,
            // place either the player or the computer in the first array
            // position and assign the X and O markers to the first and
            // second players, respectively. Pass the board to each player
            // so they can attempt moves.
            Player[] players = new Player[2];
            int coinToss = (int)(Math.random() * 2);
            if (coinToss == 0) {
                System.out.println("You are player X.");
                System.out.println("You move first.");
                players[0] = new HumanPlayer(board, 'X');
                players[1] = new ComputerPlayer(board, 'O');
                board.display(); // If the player is first, display an empty board.
            } else {
                System.out.println("You are player O.");
                System.out.println("The computer moves first.");
                players[0] = new ComputerPlayer(board, 'X');
                players[1] = new HumanPlayer(board, 'O');
            }

            // Have each player make moves until one of the moves results
            // in a win.
            boolean gameOver = false;
            int currentPlayer = 0;
            while (!gameOver) {
                gameOver = players[currentPlayer].makeMove();
                board.display();
                if (gameOver) {
                    if (board.isTie())
                        System.out.println("\nTie game!");
                    else 
                        System.out.println(
                        "\n" + players[currentPlayer].getName() + " wins!");
                }
                // Xor currentPlayer. If it's 0, make it 1.
                // If it's 1, make it 0.
                currentPlayer ^= 1;
            }
        
            boolean yesNoEntered = false;
            while (!yesNoEntered) {
                System.out.print("\nDo you wish to play again (y/n)? ");
                String retry = scanner.nextLine();
                if (retry.equalsIgnoreCase("y")) {
                    // Exit the y/n loop, boolean done stays false.
                    yesNoEntered = true;
                } else if (retry.equalsIgnoreCase("n")) {
                    // Exit the y/n loop, set boolean done to true.
                    yesNoEntered = true;
                    done = true;
                    System.out.println("\nGoodbye!");
                } else {
                    System.out.println("Invalid entry. Please enter y or n.");
                }
            }
        }
    }
    
    /**
     * Main method. Starts the program.
     */
    public static void main(String[] args) {
        TicTacToeRunner ticTacToe = new TicTacToeRunner();
    }
}
