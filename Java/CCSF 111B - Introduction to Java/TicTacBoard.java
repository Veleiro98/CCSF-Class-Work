/* Craig Persiko
   TicTacBoard.java
   Starter code for Assignment 11 in CS 111B

   A class representing a Tic Tac Toe board -
   both its user interface and its logical functionality.

   YOUR JOB IS TO WRITE THE BODY OF THE checkWinner METHOD BELOW
   SO THAT THE GAME STOPS WHEN SOMEONE WINS, OR WHEN THE BOARD IS FULL.
   LIKE SHOWN IN THE SAMPLE OUTPUT AT BOTTOM.
*/

import java.util.Scanner;

public class TicTacBoard
{
  private char[][] board;  // 2-D array of characters
  private char curPlayer; // the player whose turn it is (X or O)

  // Constructor: board will be size x size
  public TicTacBoard(int size)
  {
    board = new char[size][size];

    // initialize the board with all spaces:
    for(int row=0; row < board.length; row++)
      for(int col=0; col < board[row].length; col++)
        board[row][col] = ' ';

    curPlayer = 'X';  // X gets the first move
  }

  public void playGame()
  {
    display();
    do
    {
      takeTurn();
      display();
    }while(!checkWinner());
  }

  ///////  display  ////////
  // Display the current status of the board on the
  // screen, using hyphens (-) for horizontal lines
  // and pipes (|) for vertical lines.
  public void display()
  {
    System.out.println();
    dispRow(0);
    System.out.println("-----");
    dispRow(1);
    System.out.println("-----");
    dispRow(2);
    System.out.println();
  }

  // Display the current status of row r of the board
  // on the screen, using hyphens (-) for horizontal
  // lines and pipes (|) for vertical lines.
  private void dispRow(int r)
  {
    System.out.println(board[r][0] + "|" + board[r][1]
                       + "|" + board[r][2]);
  }

  ///////  takeTurn  ////////
  // Allow the curPlayer to take a turn.
  // Send output to screen saying whose turn
  // it is and specifying the format for input.
  // Read user's input and verify that it is a
  // valid move.  If it's invalid, make them
  // re-enter it.  When a valid move is entered,
  // put it on the board.
  public void takeTurn()
  {
    Scanner scan = new Scanner(System.in);
    int row, col;
    boolean invalid;

    do{
      invalid = false; // assume correct entry
      System.out.println("It is now " + curPlayer + "'s turn.");
      System.out.println("Please enter your move in the form row column.");
      System.out.println("So 0 0 would be the top left, and 0 2 would be the top right.");
      row = scan.nextInt();
      col = scan.nextInt();

      if(row < 0 || col < 0 || row > 2 || col > 2)
      {
        System.out.println("Invalid entry: row and column must both be between 0 and 2 (inclusive).");
        System.out.println("Please try again.");
        invalid = true;
      }
      else if(board[row][col] != ' ')
      {
        System.out.println("Invalid entry: Row " + row + " at Column " + col
                           + " already contains: " + board[row][col]);
        System.out.println("Please try again.");
        invalid = true;
      }
    }while(invalid);
    // Now that input validation loop is finished, put the move on the board:
    board[row][col] = curPlayer;

    // Switch to the other player (take turns):
    if(curPlayer == 'X')
      curPlayer = 'O';
    else
      curPlayer = 'X';
  }

  // If the game is over, print who won (if anyone),
  // and return true.  If the game is not over, return false.
  public boolean checkWinner()
  {
    char winner;
    for(int i = 0 ; i < board.length ; i++)
    {
      for(int j = 0 ; j < board[i].length; j++)
      {
        if(checkRow(i))
        {
          winner = board[i][0];
          System.out.printf("Game Over. Winner is " + winner);
          return true;
        }
        else if(checkColumn(j))
        {
          winner = board[0][j];
          System.out.printf("Game Over. Winner is " + winner);
          return true;
        }
        else if(checkDiagonal(-1) || checkDiagonal(1))
        {
          winner = board[1][1];
          System.out.printf("Game Over. Winner is " + winner);
          return true;
        }
        else
        {//nothing}
        }
      }
    }
    int boardCount = 0;
    for(int i = 0 ; i < board.length ; i++) // this checks to see if there is no more space
    {
      for(int j = 0 ; j < board[i].length ; j++)
      {
        if(board[i][j] == ' ')
        {
          boardCount++;
        }
      }
    }
    if(boardCount == 0)
    {
      System.out.println("Game Over. No one wins");
      return true;
    }
  return false; // must have a return here even though else-statement would handle it (java idk why dont ask me)
  }

  public boolean checkRow(int r)
  {
    if(board[r][0] == board[r][1] && board[r][1] == board[r][2] && (board[r][0] == 'X' || board[r][0] == 'O'))
    {
      return true;
    }
    else
      return false;
  }

  public boolean checkColumn(int c)
  {
    if(board[0][c] == board[1][c] && board[1][c] == board[2][c] && (board[0][c] == 'X' || board[0][c] == 'O'))
    {
      return true;
    }
    else
      return false;
  }

  public boolean checkDiagonal(int slope)
  {
    if(slope == -1)
    {
      if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == 'X' || board[0][0] == 'O'))
      {
        return true;
      }
      else
        return false;
    }
    else if(slope == 1)
    {
      if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && (board[2][0] == 'X' || board[2][0] == 'O'))
      {
        return true;
      }
      else
        return false;
    }
    else
      System.out.println("invalid input for slope. Please enter either -1 or 1");
      return false;
  }
}


/*
 * Sample output from main:
 * 
 | | 
-----
 | | 
-----
 | |

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

 | |
-----
 |X|
-----
 | |

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

 | |
-----
 |X|
-----
 |O|

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

 | |
-----
 |X|
-----
 |O|X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

O| |
-----
 |X|
-----
 |O|X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

O| |X
-----
 |X|
-----
 |O|X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 2

O| |X
-----
 |X|O
-----
 |O|X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

O| |X
-----
 |X|O
-----
X|O|X

Game Over. Winner is X

___________________________

Sample output 2:

 | |
-----
 | | 
-----
 | |

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

 | |
-----
 |X|
-----
 | |

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

 | |
-----
 |X|
-----
O| |

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

 | |
-----
 |X|
-----
O| |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

O| |
-----
 |X|
-----
O| |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 0 

O| |
-----
X|X|
-----
O| |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 2

O| |
-----
X|X|O
-----
O| |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 1

O|X|
-----
X|X|O
-----
O| |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

O|X|
-----
X|X|O
-----
O|O|X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

O|X|X
-----
X|X|O
-----
O|O|X

Game Over. No one wins

 */