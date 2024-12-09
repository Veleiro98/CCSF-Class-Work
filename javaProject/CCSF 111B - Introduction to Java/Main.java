/* Craig Persiko
   TicTacToe project for Assignment 11 in CS 111B
*/

class Main 
{
  ///////  main  ////////
  // No changes needed in this function.
  // It declares the variables, initializes the game,
  // and plays until someone wins or the game becomes unwinnable.
  public static void main(String[] args)
  {
    TicTacBoard game = new TicTacBoard(3);
    game.playGame();
  }
}

/* Sample Output:

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

X| | 
-----
 | | 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

X| | 
-----
 | | 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

X| | 
-----
 |X| 
-----
O| | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

X| | 
-----
 |X| 
-----
O|O| 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

X| | 
-----
 |X| 
-----
O|O|X

Player X wins!

************************************************
*********** Running the program again **********
************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

X| | 
-----
 | | 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 1

X|O| 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

X|O|X
-----
 | | 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

X|O|X
-----
 |O| 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

X|O|X
-----
 |O| 
-----
 |X| 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 0

X|O|X
-----
O|O| 
-----
 |X| 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 2

X|O|X
-----
O|O|X
-----
 |X| 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

X|O|X
-----
O|O|X
-----
 |X|O

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

X|O|X
-----
O|O|X
-----
X|X|O

Nobody won. Game ends in a draw.

************************************************
*********** Running the program again **********
************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
-1 1
Invalid entry: row and column must both be between 0 and 2 (inclusive).
Please try again.
It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 3
Invalid entry: row and column must both be between 0 and 2 (inclusive).
Please try again.
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
1 1
Invalid entry: Row 1 at Column 1 already contains: X
Please try again.
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
0 0

X| | 
-----
 |X| 
-----
O| | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

X| | 
-----
 |X| 
-----
O| |O

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

X| |X
-----
 |X| 
-----
O| |O

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

X| |X
-----
 |X| 
-----
O|O|O

Player O wins!

************************************************
*********** Running the program again **********
************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

 | | 
-----
 | | 
-----
 | |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

O| | 
-----
 | | 
-----
 | |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

O| |X
-----
 | | 
-----
 | |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

O| |X
-----
 |O| 
-----
 | |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 2

O| |X
-----
 |O|X
-----
 | |X

Player X wins!

************************************************
*********** Running the program again **********
************************************************
* Following is Extra Credit: determine if unwinnable *
*************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

X| | 
-----
 | | 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

X| | 
-----
 | | 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

X| |X
-----
 | | 
-----
O| | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 1

X|O|X
-----
 | | 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

X|O|X
-----
 | | 
-----
O| |X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 1

X|O|X
-----
 |O| 
-----
O| |X

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

X|O|X
-----
 |O| 
-----
O|X|X

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
1 2

X|O|X
-----
 |O|O
-----
O|X|X

Nobody can win now. Game ends in a draw.

************************************************
*********** Running the program again **********
************************************************
* Above and below examples are Extra Credit: determine if unwinnable *
*************************************************

 | | 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 0

X| | 
-----
 | | 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 1

X|O| 
-----
 | | 
-----
 | | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
0 2

X|O|X
-----
 | | 
-----
 | | 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 0

X|O|X
-----
 | | 
-----
O| | 

It is now X's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 1

X|O|X
-----
 | | 
-----
O|X| 

It is now O's turn.
Please enter your move in the form row column.
So 0 0 would be the top left, and 0 2 would be the top right.
2 2

X|O|X
-----
 | | 
-----
O|X|O

Nobody can win now. Game ends in a draw.

************************************************
* Above 2 examples are Extra Credit: determine if unwinnable *
*************************************************
*/