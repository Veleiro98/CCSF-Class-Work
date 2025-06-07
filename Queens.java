public class Queens {
    // squares per row or per column
    public static final int BOARD_SIZE = 8;

    //used to indicate empty square
    public static final int EMPTY = 0;

    //used to indicate square contains a queen
    public static final int QUEEN = 1;

    private int board[][];  // chess board
    public Queens() {
    // --------------------------------------------------
    //  Constructor:  Create an empty square board.
    // --------------------------------------------------
      board = new int[BOARD_SIZE][BOARD_SIZE];
    } // end constructor

    public void clearBoard(){
    // --------------------------------------------------
    // Clears the board.
    for(int i = 0; i < board.length;i++)
    {
      for(int j = 0 ; j < board[i].length; j++)
      {
        board[i][j] = 0;
      }
    }
    // Precondition:  None.
    // Postcondition:  Sets all squares to EMPTY
    // --------------------------------------------------
       // place your logic to implement this method here
    }  // end clearBoard

    public void displayBoard(){
    // --------------------------------------------------
    // Displays the board.
    // Precondition:  None.
    // Postcondition:  Board is written to standartd
    // output; zero is an EMPTY square, one is a square
    // containing a queen (QUEEN)
    // --------------------------------------------------
      for (int i=0; i<BOARD_SIZE; i++) {
 	  for (int j=0; j<BOARD_SIZE; j++) {
 		// place your logic to implement this method here
	        // that prints a single row of the chess board
	        // to the console window (i.e., standard output)
          System.out.print(board[i][j] + " ");
 	  }
	         System.out.print("\n");
		 // this newline prints after a row
		 // of the chess board has been printed
      }
    }  // end displayBoard

    public boolean placeQueens(int column) {
    // --------------------------------------------------
    // Place queens in columns of the board beginning
    // at the column specified.
    // Precondition:  Queens are placed correctly in
    // columns 1 thro coulumn-1.
    // Postcondition:  If a solution is found, each
    // column of the board contains one queen and method
    // returns true; otherwise retruns false (no
    // solution existis for a queen anywhere in column
    // specified).
    // --------------------------------------------------
    
	if (column > BOARD_SIZE) {
	  return true;  // base case
	}
	else {
	  boolean queenPlaced = false;
	  int row = 1;  // number of square in column

	  while ( !queenPlaced && (row <= BOARD_SIZE)  )  {
	    // if square can be attacked
	      if (isUnderAttack(row, column)) {
		  ++row;  // consider next square in column
	      } // end if
	      else {  // place queen and consider next column
		  setQueen(row, column);
		  queenPlaced = placeQueens(column+1);
		  // if no queen is possible in the next column,
		  if (!queenPlaced) {
		      // backtrack:  remove queen placed earliers
		      // and try next square in column
		      removeQueen(row, column);
		      ++row;
		  } // end if
	      } // end if
	  } // end while
	  return queenPlaced;
	} // end if
    } // end placeQueens

    public void setQueen(int row, int column) {
    // --------------------------------------------------
    // Set a queen at square indicated by row and
    // column.
    // Precondition:  None.
    // Postcondition:  Sets the square on the board in a
    // given row and column to QUEEN.
    // --------------------------------------------------
	board[row-1][column-1] = QUEEN;
    } // end setQueen

    public void removeQueen(int row, int column) {
    // --------------------------------------------------
    // Remove a queen at square indicated by row and
    // column.
    // Precondition:  None.
    // Postcondition:  Sets the square on the board in a
    // given row and column to EMPTY.
    // --------------------------------------------------
       board[row-1][column-1] = EMPTY;
    } // end setQueen

    public boolean isUnderAttack(int row, int column) {
    // --------------------------------------------------
    // Determines whether the square on the board at a
    // given row and column is under attack by any queens
    // in the columns 1 through column-1.
    // Precondition:  Each column between 1 and column-1
    // has a queen placed in a square at a specific row.
    // None of these queens can be attacked by any other
    // queen.
    // Postcondition:  If the deignated square is under
    // attack, returns true; otherwise, returns false.
    // --------------------------------------------------
    // check column
 	for (int i=0; i<row-1; i++){
 		if (board[i][column-1]==1){
 			return true;
 		}
 	}
    // check row
 	for (int i=0; i<column-1; i++) {
 		if (board[row-1][i] == 1){
 			return true;
 		}
 	}
 	
    // check lower diagnal
 	int lower_dir_row = row-2;
 	int lower_dir_column = column-2;
 	while (lower_dir_row>=0 && lower_dir_column>=0){
 			if (board[lower_dir_row][lower_dir_column]==1){
 				return true;
 			} else {
 				lower_dir_row = lower_dir_row -1;
 				lower_dir_column = lower_dir_column -1;
 			}
 		}
 		
 		
     // check upper diagnal
 	int upper_dir_row = row;
 	int upper_dir_column = column-2;
 	while (upper_dir_row<BOARD_SIZE && upper_dir_column>=0){
 		if(board[upper_dir_row][upper_dir_column] ==1){
 			return true;
 		}else{
 			upper_dir_row = upper_dir_row +1;
 			upper_dir_column = upper_dir_column -1;
 		}
 	}
 	return false;

    } // end isUnderAttack

} // end Queens




	
	    
    
    
