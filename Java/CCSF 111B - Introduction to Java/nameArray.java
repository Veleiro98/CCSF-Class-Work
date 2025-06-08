/* Programming Exercise for Chapters 7: Name Array, for CS 111B
 * Written by Matthew Means, 1/10/24 d/m/y
 * Use an array of strings to store names of several people input by the user, and output
 * them in reverse order. Then output the longest name, and its length.  If there is more
 * than one name with that longest length, you can output either of them. 
 * 
 */
import java.util.Scanner;

public class nameArray {
    
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to the Name Array program.");
    System.out.println("How many people do you want to enter?");
    final int numPeople = input.nextInt();
    String[] names = new String[numPeople];
    input.nextLine();
    for(int i = 0; i < numPeople; i++ )
        {
            System.out.print("Please enter a name: ");
            names[i] = input.nextLine();
        } // end of for loop for getting the input
    String[] reversedStrings = flipThatThangAndReverseIt(names);
    System.out.println("Here are the names you entered, reversed in order:");
    for(int k = 0; k < reversedStrings.length;k++)
    {
        System.out.println(reversedStrings[k]);
    } // end of print loop
    longestString(reversedStrings);
    } // end of main method

    public static String[] flipThatThangAndReverseIt(String[] names){ /* This reverses the order of a the 
        input array of strings */
    String[] namesOut = new String[names.length];  // NOTE for future self. .length is for finding the
    // length of an array and .length() is a method for strings
    for(int i = 0; i < namesOut.length ; i++) // this removes the null from the declaration to make the 
    // string just empty
    {
        namesOut[i] = "";
    }
    int k = names.length-1;
    for(int i = 0 ; i < names.length && k >= 0 ; i++, k--)
        {
                namesOut[i] =  names[k];
        } // end of outer loop

    return namesOut;

    } // end of method1

    public static void longestString(String[] backwardsNames ){ /* this discerns which string in an array is
        the longest and prints it and its length*/
    int i = 0;
    String longest = "";
    int length = 0;
        while(i <= backwardsNames.length-2)
        {
            if(backwardsNames[i].length() < backwardsNames[i+1].length())
            {
                longest = backwardsNames[i+1];
                length = backwardsNames[i+1].length();
                i++;
            }
            else if (backwardsNames[i].length() == backwardsNames[i+1].length()) {
                longest = backwardsNames[i] + " and " + backwardsNames[i+1];
                length = backwardsNames[i].length();
                i++;
            }
            else{
                longest = backwardsNames[i];
                length = backwardsNames[i].length();
                i++;
            }
        }
    System.out.println("The longest name is : " + longest + " and its length is " + length);
    } // end of method 2

} // end of class

/* I accidently misread the prompt and thought it was asking to reverse the names originally, but I thought
 * that it was funny and kept one of the outputs for you.
 * Sample Output 1:
 * Welcome to the Name Array program.
 * How many people do you want to enter?
 * 3
 * Please enter a name: Sammy
 * Please enter a name: Kathy
 * Please enter a name: Matt
 * ymmaS
 * yhtaK
 * ttaM
 * The longest name is : yhtaK and its length is 5
 * 
 * Sample Output 2:
 * Welcome to the Name Array program.
* How many people do you want to enter?
* 3
* Please enter a name: Trump
* Please enter a name: Biden
* Please enter a name: Matt
* Here are the names you entered, reversed in order:
* Matt
* Biden
* Trump
* The longest name is : Biden and Trump and its length is 5
* 
* Sample Output 3:
* Welcome to the Name Array program.
* How many people do you want to enter?
* 3 
* Please enter a name: Beyonce
* Please enter a name: Taylor
* Please enter a name: Cher
* Here are the names you entered, reversed in order:
* Cher
* Taylor
* Beyonce
* The longest name is : Beyonce and its length is 7
 */