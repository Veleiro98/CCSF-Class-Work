/* This code was written by Matthew Means 5/17/2025 for CS 111C Data Structures and Algorithms from
CCSF. It was written in Visual Studios Code with Java21.0.6 on Ubuntu24.04.2 LTS. The purpose of this
file is to interact with the Queens.class file for finding solutions to the 8 queen's problem and printing
the results of the solution after. The Queens.class file is modified from the original provided such that
it also includes completed methods named displayBoard and clearBoard. Private methods were malso ade public
for their utilization here.
 */

public class programmingLab7Main {

    private static int runCount = 0; // keeps track of how many solutions there are
    public static void main(String[] args) {
        Queens eightQueens = new Queens();
        solve(eightQueens, 1);
        System.out.println("Amount of iterations: " + runCount);
    }

    public static boolean solve(Queens board, int column) {
        if (column > Queens.BOARD_SIZE) { // base case for when we run out of columns
            board.displayBoard(); // Display the solution when all queens are placed
            System.out.println();
            runCount++;
            return true; // Indicate a solution was found in this branch
        }

        for (int row = 1; row <= Queens.BOARD_SIZE; row++) { // traversing through every row
            board.setQueen(row, column);
            if (!board.isUnderAttack(row, column)) { // if it is a safe play, continue recursion
                if (solve(board, column + 1)) { // traversing through the columns
                    // A solution was found down this path.
                    // We *don't* want to stop here. Returning true here would unwind
                    // the recursion prematurely.
                }
            }
            board.removeQueen(row, column); // Backtrack: Remove the queen to try the next row
        }

        return false; // No valid placement found in this column
    }
}

/*
 * Sample output is so comically long that it will not be provided here as normal.
 */