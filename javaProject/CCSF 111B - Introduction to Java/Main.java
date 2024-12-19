/* File I/O Exercise for CS 111B
   Written by Matthew Means 13/12/2024(d/m/y)
   The purpose of this assignment "Robust Array" for CCSF 111B - Introduction to Java is:
   "Write a program to:
"Input one or more integers on a line (as a String), and copy them into an array of integers.
Prompt the user to enter the index of the element they want to see, then show that element, and 
multiply it times two. Make your program handle all possible problems with user input, using at 
least one try..catch block to do so. Your program should never throw an unhandled exception. 
It should deal appropriately with invalid input"
*/


import java.io.*;
import java.util.Scanner;
import java.nio.file.*;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner scan = new Scanner(System.in);
    int[] list = null;
    String[] stringList;
    String numbers;
    boolean loopChecker = true;
    int indexWanted = -1;
    while(loopChecker) // this loop is to ensure the array is properly created before asking for an index
    {                  // in the next while loop
      try
      {
        System.out.println("Enter some integers, separated by spaces:");
        numbers = scan.nextLine();
        stringList = numbers.split("\\s+");
        boolean needToRemove = true;
        int i = 0;
        
        list = new int[stringList.length];
        for(int k = 0 ; k < list.length ; k++ )
        {
          list[k] = Integer.parseInt(stringList[k]);
        }

        loopChecker = false;        // if all the code is executed without any exceptions ruining it.
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
        System.out.println("You must enter one or more integers, with one space separating each integer.");
      }
      catch(NumberFormatException e)
      {
        System.out.println("You must enter one or more integers, with one space separating each integer.");
      }
      catch(java.util.InputMismatchException e)
      {
        System.out.println("You must enter one or more integers, with one space separating each integer.");
      }
    }


    boolean loopChecker2 = true;
    while(loopChecker2) // this while-loop/try-block combo is to ensure the index can be properly requested
    {
      try
      {
        System.out.print("Enter the index of the number you want to see:");
        indexWanted = scan.nextInt(); // this needs its own try-and-catch blocks and while-loop.
        System.out.printf("\nYou chose index %d, who's value is %d\n", indexWanted, list[indexWanted-1]);
        System.out.printf("If you double it, that is %d\n", list[indexWanted-1]*2);
        loopChecker2 = false;

      }
      catch(java.util.InputMismatchException e)
      {
        System.out.printf("The index must be an integer between 0 and %d. Please try again.\n", list.length );
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
        System.out.printf("The index must be an integer between 0 and %d. Please try again.\n", list.length);
      }
    
    }
  System.out.println("end of program");
  } // end of main method

  static private void printArray(int[] array)
  {
    for(int i = 0 ; i < array.length ; i++)
    {
      System.out.print(array[i] + " ");
    }
    System.out.println("\n");
  }
  static private void printArray(String[] array)
  {
    for(int i = 0 ; i < array.length ; i++)
    {
      System.out.print(array[i] + " ");
    }
    System.out.println("\n");
  }
} // end of class

/*
  Sample output:
Enter some integers, separated by spaces:

You must enter one or more integers, with one space separating each integer.
Enter some integers, separated by spaces:
1.5
You must enter one or more integers, with one space separating each integer.
Enter some integers, separated by spaces:
3 4   5 -10
Enter the index of the number you want to see:4

You chose index 4, who's value is -10
If you double it, that is -20
end of program
 */