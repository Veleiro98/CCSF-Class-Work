
import java.util.Scanner;

public class ClientProgram {
    public static void main(String[] args)
    {
    Scanner input = new Scanner(System.in);
    AList<Integer> clientList = new AList(1);
    String[] tempArray;
    boolean running1 = true, running2 = true;
    int max;
    String inputString;
    char inputChar;
    while(running1)
    {
        while(running2)
        {
            System.out.println("Input a list of integers: ");
            tempArray = input.nextLine().split(" ");
            try{
                for(int i = 0; i < tempArray.length; i++)
                {
                    clientList.add(Integer.parseInt(tempArray[i])); 
                }
            running2 = !running2; // after its gone through all the for loops with 
            // no exceptions, flips to exit while loop
            }
            catch(NumberFormatException e)
            {
                System.out.println("Error in identifying one or more of your Integers. Please try again: "); 
            }
        } // end of while loop for taking input and parsing integer values from strings.
        max = clientList.recursiveMax(clientList, 1, clientList.getLength());
        System.out.println("The maximum value found by recursiveMax is: " + clientList.getEntry(max));
        System.out.println("Do you want to continue? (y/n): ");
        inputString = input.nextLine();
        inputChar = Character.toLowerCase(inputString.charAt(0)); // takes the first input character and
        // makes it lower case
        if(inputChar == 'n')
        {
            running1 = !running1;
        }
        else
        {
            for(int i = clientList.getLength(); i > 0; i--) // clears up client list for a rerun of the program
            {
                clientList.remove(i);
            }
            running2 = true;
        }
    } // end of greater while loop
    } // end of main method
} // end of ClientProgram
