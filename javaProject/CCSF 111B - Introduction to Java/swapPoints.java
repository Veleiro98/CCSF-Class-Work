/* CS 111B Starter Program for Assignment 6
   Written by Matthew Means
   Uses a function to swap the coordinates 
   stored in two Point objects, and another 
   function to input coordinates and return
   a Point object with those coordinates.
*/

import java.awt.Point;
import java.util.Scanner; 

class Main 
{
  public static void main(String[] args) // this is the main method. I'm required to give a description
  // for the grade, but honestly this one just feels too straight forward to give one.
  {
    Point player1_location, player2_location;

    player1_location = inputNewPlayerLocation();
    player2_location = inputNewPlayerLocation(); 
    
    System.out.println("Player1 location: (" + player1_location.x 
                        +"," + player1_location.y + ")");
    System.out.println("Player2 location: (" + player2_location.x
                        +"," + player2_location.y + ")");

    swapPoints(player1_location, player2_location);

    System.out.println("Player 1 and Player 2 have swapped locations!");
    System.out.println("Player1 location: (" + player1_location.x 
                        +"," + player1_location.y + ")");
    System.out.println("Player2 location: (" + player2_location.x
                        +"," + player2_location.y + ")");
  } // end of main method

  public static Point inputNewPlayerLocation() // this instantiates a new object and gives its instance
   // variables values from the user input.
  { Scanner localInput = new Scanner(System.in);
    Point location = new Point();
    System.out.println("Welcome, new player. Please enter your coordinates:");
    System.out.print("x: ");
    location.x = localInput.nextInt();
    System.out.print("y: ");
    location.y = localInput.nextInt();
    return location;
  } // end of inputNewPlayerLocation method

  public static void swapPoints( Point point1, Point point2) // swaps the values for each object, but
  // they do not need to return the new values back due to how references and arrays/objects store values.
  {
    int holder1x = point1.x;
    int holder1y = point1.y;
    point1.x = point2.x;
    point1.y = point2.y;
    point2.x = holder1x;
    point2.y = holder1y;
  } // end of swapPoints metehod

} // end of swapPoints class

/* 
sample output 1:
Welcome, new player. Please enter your coordinates:
x: 3
y: 10
Welcome, new player. Please enter your coordinates:
x: 4
y: 8
Player1 location: (3,10)
Player2 location: (4,8)
Player 1 and Player 2 have swapped locations!
Player1 location: (4,8)
Player2 location: (3,10)

sample output 2:
Welcome, new player. Please enter your coordinates:
x: 5
y: 9
Welcome, new player. Please enter your coordinates:
x: 13
y: -3
Player1 location: (5,9)
Player2 location: (13,-3)
Player 1 and Player 2 have swapped locations!
Player1 location: (13,-3)
Player2 location: (5,9)
*/