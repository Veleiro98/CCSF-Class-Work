/* Ex10RandomPointsStarter
   CS 111B Starter Program for Exercise for Chapter 10

   Written by Matthew Means
   Your job is to write the loop condition and
   function body to complete the program below.

   The function should generate random (x,y)
   coordinates between 1-10, and return a Point object 
   with those coordinates.
   This program randomly generates locations for 
   two players, repeating until one of their 
   coordinates are the same for both players.
*/

import java.awt.Point;
import java.util.Random;

class randomPoints 
{
  public static void main(String[] args) 
  {
    Point player1_location, player2_location;

    System.out.println("This program randomly generates (x,y) locations");
    System.out.println("between 1-10 for two players, repeating until");
    System.out.println("one of their coordinates are the same for both players.");
    do
    {
      player1_location = randomNewPlayerLocation();
      player2_location = randomNewPlayerLocation(); 
      
      System.out.println("Player1 location: (" + player1_location.x 
                         +"," + player1_location.y + ")");
      System.out.println("Player2 location: (" + player2_location.x
                         +"," + player2_location.y + ")");
      System.out.println();

      // DON'T CHANGE ANY OF THE ABOVE CODE
    }while( player1_location.x != player2_location.x && player1_location.y != player2_location.y );

  }

  // Generates random (x,y) coordinates between 1-10, then
  // returns a Point object with those coordinates.
  static Point randomNewPlayerLocation()
  { Random rand = new Random();
    int randX = rand.nextInt(11);
    int randY = rand.nextInt(11);
    Point returnPoint = new Point();
    returnPoint.x = randX;
    returnPoint.y = randY;
    return returnPoint;
  }
}

/*
 Example output 1:
This program randomly generates (x,y) locations
between 1-10 for two players, repeating until
one of their coordinates are the same for both players.
Player1 location: (8,9)
Player2 location: (10,8)

Player1 location: (6,10)
Player2 location: (0,7)

Player1 location: (2,0)
Player2 location: (8,8)

Player1 location: (5,5)
Player2 location: (3,9)

Player1 location: (4,5)
Player2 location: (4,8)


Example output 2:
This program randomly generates (x,y) locations
between 1-10 for two players, repeating until
one of their coordinates are the same for both players.
Player1 location: (1,2)
Player2 location: (9,3)

Player1 location: (2,9)
Player2 location: (5,10)

Player1 location: (8,8)
Player2 location: (3,5)

Player1 location: (9,2)
Player2 location: (4,6)

Player1 location: (8,6)
Player2 location: (1,3)

Player1 location: (3,10)
Player2 location: (9,8)

Player1 location: (6,5)
Player2 location: (2,5)

*/