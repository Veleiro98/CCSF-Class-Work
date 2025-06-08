/* This program was written by Matthew Means on 3/11/2025 as part of a homework assignment for Data
Structures and Algorithms from CCSF. The assignment is named "Programming Lab 2". The purpose of this 
program is to take an input list of integers from the user and to tell the user back whether or not 
the list has a repeating value somewhere in said list. The purpose of this is to exercise the 
implementation of a linked list. This code was written in Visual Studios, It uses OpenJDK runtime environment
21.0.6 of Java on Ubuntu(Linux).
 * 
 */
import java.util.Scanner;

public class ProgrammingLab2ClientProgram {
    
    public static void main(String[] args) // this is the only method being used in this program. It does as
    // described above in the program description.
    {   boolean running = true;
        while(running)
        {
            Scanner input = new Scanner(System.in); // for taking user input via the Scanner object class
            LList<Integer> myList = new LList(); // the linked list being instantiated.
            String[] myStringArray = new String[0]; // these two arrays(here and below) are for converting the user input from 
            // a string input to a more usable Integer format.
            Integer[] myIntegerArray = new Integer[0];
            boolean makingList = true; // the second while loop for making sure that the list was properly created.
            while(makingList)
            {
                try
                {   System.out.print("Input a list of Integers: ");
                    myStringArray = input.nextLine().split(" ");
                    myIntegerArray = new Integer[myStringArray.length];
                    System.out.println("\n"); // new line after input
                    for(int i = 0; i < myStringArray.length; i ++)
                    {
                        myIntegerArray[i] = Integer.parseInt(myStringArray[i]);
                    }
                    makingList = false;
                } // this try block is here to catch any problems with the parsing and to allow the user to
                // try again
                catch (Throwable e)
                {
                    System.out.println("An error occured with your list, try again.");
                }
            } // end of loop for parsing the array from a string to an Integer wrapper class
            assert myList.getLength() == 0 : "myList is not of empty and has contents."; // this is here for you
            // to see that I'm making the assumption that the list is empty at this point prior to filling it.
            for(int i = 0; i < myStringArray.length; i++)
            {
                myList.add(myIntegerArray[i]);
            } // end of loop adding contents from array into the LList class object
            if(myList.hasNoRepeats())
            {
                System.out.println("The list does not have repeated values");
            }
            else
                System.out.println("The list has repeated values");
            System.out.print("Do you want to continue (y/n): ");
            char myResponse = Character.toLowerCase(input.nextLine().charAt(0)); // this gets the first lowercase character
            // from the user input. If they type in "No", "no", or "Nah" etc it will end the program loop.
            System.out.println("\n"); // new line for visual clarity
            if(myResponse == 'n')
                running = false;
            else
            {
                for(int i = myList.getLength(); i >= 1; i--)
                {
                    myList.remove(i);
                } // this empties the list so it can be used again for the next run of the while loop
            }
        } // end of main while loop
        System.out.println("Program ended");
    } // end of main method

    public T[] sortLowToHigh(LList<T> myList)
    {
        Object[] myListAsObj = new Object[myList.length];
        LList 
    }
}

/* sample output:
Input a list of Integers: 1 1 0 13 4


The list has repeated values
Do you want to continue (y/n): y


Input a list of Integers: 0 0 3 3 4


The list has repeated values
Do you want to continue (y/n): y


Input a list of Integers: 1.2 32 3/4


An error occured with your list, try again.
Input a list of Integers: 3 4 5 9 12


The list does not have repeated values
Do you want to continue (y/n): n


Program ended
*/