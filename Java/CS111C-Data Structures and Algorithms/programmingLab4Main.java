/* This code was written by Matthew Means 5/5/2025 for CS 111C Data Structures and Algorithms from
CCSF. It was written in Visual Studios Code with Java21.0.6 on Ubuntu24.04.2 LTS. The purpose of this code
is to take input from the command line for an array of inputs, inputting the array into a Linked-List Queue
implementation, and to ask the user to pick an input of the array established to move to the back. The method
to accomplish this is implemented in the LinkedQueue class. QueueInterface.java contains a modification to
help aid this situation by checking for whether or not something is within the queue via the checkForEntry()
helper-method. I also added a private integer value for easily finding length of the queue, adding 
or subtracting depending on the different methods, and a public accessor for this value called getLength().
This doesn't require us to dequeue the entire array and enqueue it again each time to traverse it in order
to count the length this way.
 */
import java.util.Scanner;

public class programmingLab4Main {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        boolean active = true;
        LinkedQueue<String> myLinkedQueue = new LinkedQueue<String>();
        String[] myArray;
        String itemToMove;
        while(active)
        {
            try{
                System.out.print("Input a list of items to be placed into a queue: ");
                myArray = input.nextLine().split(" ");
                if(myArray.length == 1 && myArray[0].isEmpty())
                {
                    System.out.println("No items were placed in the queue. Please try again.");
                }
                else
                {
                    for(int i = 0; i < myArray.length ; i ++)
                    {
                        myLinkedQueue.enqueue(myArray[i]);
                    }
                    System.out.println("\nInput the item that is to be moved to the back: ");
                    itemToMove = input.nextLine();
                    if(myLinkedQueue.checkForEntry(itemToMove))
                    {
                        myLinkedQueue.moveToBack(itemToMove);
                        System.out.print("\nItems in queue after one item was moved to the back: ");
                        for(int i = 0; i < myArray.length; i++)
                        {
                            System.out.print(myLinkedQueue.dequeue() + " ");
                        }
                        }
                    else
                    {
                        System.out.println("The item you asked to moved to the back was not "
                        + "ever present in the queue.");
                    }
                    System.out.print("\nDo you want to continue?(y/n): ");
                    if(Character.toLowerCase(input.nextLine().charAt(0)) == 'n')
                    {
                        active = false;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception: " + e + "\nPlease try again. Program restarting . . .");
            }
        }
        
        input.close();
    } // end of main
} // end of class

/*
 * Sample output:
Input a list of items to be placed into a queue: 5 3 4 1 2

Input the item that is to be moved to the back: 
3

Items in queue after one item was moved to the back: 5 4 1 2 3 
Do you want to continue?(y/n): y
Input a list of items to be placed into a queue: Jonathan Matthew Ellie Kurt Brand

Input the item that is to be moved to the back: 
Matthew

Items in queue after one item was moved to the back: Jonathan Ellie Kurt Brand Matthew 
Do you want to continue?(y/n): y
Input a list of items to be placed into a queue: 
No items were placed in the queue. Please try again.
Input a list of items to be placed into a queue: 1.4 32 54 86 94.12

Input the item that is to be moved to the back: 
1.4

Items in queue after one item was moved to the back: 32 54 86 94.12 1.4 
Do you want to continue?(y/n): n
 */