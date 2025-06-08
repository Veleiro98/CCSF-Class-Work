/* Written by Matthew Means 25/10/2024 (D/M/Y)
 * This code was written as part of the CCSF CS Course "Introduction To Java"
 * The purpose of this specific code is to explore class creation by creating a tile class file
 * that is accessible by another class file in order to produce a component in order to contribute
 * to the mimicry of a Scrabble tile game. This is the Tile class for the Chapter 12 Exercise
 *
 * Beyond what we did for Chapter 11, this
 * version should keep track of how many Tiles have
 * been created, and define .compareTo so
 * we can determine the most valuable Tile.
*/

class Tile
{
  private char letter;
  private int value;
  private static int tileCount = 0;

  public Tile(char letter, int value)
  {
    this.letter = letter; // this refers to the current object over the parameter
    this.value = value;
    // count each Tile we instantiate
    tileCount++;
  } // end of Tile object instantiazation

  public char getLetter()
  {
    return letter;
  } // end of getLetter

  public int getValue()
  {
    return value;
  } // end of getValue

  @Override
  public String toString()
  {
    return letter + " with value: " + value;
  } // end of toString

  // it is my personal preference to add a help method to every object to show how to use it
  public void help(){
    System.out.println("Available methods for use: getValue(),"
    + "getLetter(), toString(), equals(Tile other).");
  } // end of help

  // equal Tiles have the same letter and value
  public boolean equals(Tile other)
  {
     return letter == other.letter && value == other.value;
  } // end of equals

  public int compareTo(Tile other)
  {
    if(other.value < value)
    {
        return 1;
    }
    else if(other.value > value)
    {
        return -1;
    }
    else
    {
        return 0;
    }
  } // end of compareTo

  // static member function, to 
  // return count of Tiles created
  static int getTileCount()
  {
    return tileCount;
  } // end of getTileCount

} // end of tile class