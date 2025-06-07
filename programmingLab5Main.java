/* This code was written by Matthew Means 5/11/2025 for CS 111C Data Structures and Algorithms from
CCSF. It was written in Visual Studios Code with Java21.0.6 on Ubuntu24.04.2 LTS. The purpose of this code
is to take input from the the user for four different commands: adding an item to a queue, returning the even
indexed elements, returning the odd index elements, and ending the program. The method
to accomplish this is implemented in the LinkedQueue class. QueueInterface.java contains a modification to
help aid this situation by checking for whether or not something is within the queue via the checkForEntry()
helper-method. I also added a private integer value for easily finding length of the queue, adding 
or subtracting this global value depending on the different methods, and a public accessor for this value
called getLength(). This doesn't require us to dequeue the entire array and enqueue it again each time to 
traverse it in order to count the length this way.
*/

import java.util.Scanner;

public class programmingLab5Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean active = true;
        LinkedQueue<String> myLinkedQueue = new LinkedQueue<String>();
        String[] myArray;
        int userChoice = -1;
        String itemToAdd = null;
        while(active)
        {
            // try catch block for console input
            try{
                System.out.print("1.) Add item\n2.)Show Queue items in odd positions\n"+
                "3.)Show Queue items in even positions\n4.)Exit program\nEnter your choice (1-3): ");
                userChoice = input.nextInt();
            }
            catch(java.util.InputMismatchException e)
            {
                System.out.println("Please try again with an integer between 1 and 3.");
                input.next(); // clears input
            }
            if(userChoice == 1)
            {
                input.nextLine();
                // another try catch block for second console input per loop
                try{
                    System.out.print("Enter item: ");
                    itemToAdd = input.nextLine();   
                }
                catch(Exception e)
                {
                    System.out.println("Unknown error has occured. Please try again");
                }
                myLinkedQueue.enqueue(itemToAdd);
            }
            else if(userChoice == 2)
            {
                int myQueueLength = myLinkedQueue.getLength();
                input.nextLine();
                myArray = new String[myQueueLength];
                System.out.print("Queue items in odd positions: ");
                // dequeues the contents into a temporary array to handle
                for(int i = 0; i < myQueueLength ; i++)
                {
                    myArray[i] = myLinkedQueue.dequeue();
                    if((i+1) % 2 == 1)
                    {
                        System.out.print(myArray[i] + " ");
                    }
                }
                // puts the contents of the temporary array back into the queue
                for(int i = 0; i < myArray.length; i++)
                {
                    myLinkedQueue.enqueue(myArray[i]);
                }
                System.out.println();
            }
            else if(userChoice == 3)
            {
                int myQueueLength = myLinkedQueue.getLength();
                input.nextLine(); 
                myArray = new String[myQueueLength];
                System.out.print("Queue items in even positions: ");
                // dequeues the contents into a temporary array to handle
                for(int i = 0; i < myQueueLength ; i++)
                {
                    myArray[i] = myLinkedQueue.dequeue();
                    if((i+1) % 2 == 0)
                    {
                        System.out.print(myArray[i] + " ");
                    }
                }
                // puts the contents of the temporary array back into the queue
                for(int i = 0; i < myArray.length; i++)
                {
                    myLinkedQueue.enqueue(myArray[i]);
                }
                System.out.println();
            }
            else if(userChoice == 4)
            {
                System.out.println("Goodbye");
                active = false; // ends program loop
            }
            else // if the choice is not between 1 and 4
            {
                System.out.println("Please try again with an integer between 1 and 3");
            }
        }
        
        input.close(); // closes input stream
    } // end of main method
} // end of programmingLab5Main class

/*
 * Sample output:
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): f
Please try again with an integer between 1 and 3.
Please try again with an integer between 1 and 3
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): -1
Please try again with an integer between 1 and 3
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): 1
Enter item: Apple
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): 1
Enter item: Mango
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): 1
Enter item: Raspberry
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): 1
Enter item: Strawberry
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): 1
Enter item: Pear
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): 2
Queue items in odd positions: Apple Raspberry Pear 
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): 3
Queue items in even positions: Mango Strawberry 
1.) Add item
2.)Show Queue items in odd positions
3.)Show Queue items in even positions
4.)Exit program
Enter your choice (1-3): 4
Goodbye
 */