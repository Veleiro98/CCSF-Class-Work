/* /* This file is part of a practice assignment for CCSF 111B - "Introduction to Java". The
 * assignment is for the third assignment named "Writing Methods".
 * This was written by Matthew Means on 30/9/24 (d/m/y).
 * This is a simple calculator that takes two numbers and either divides, multiplies, adds, 
 * or subtracts.
 */
import java.util.Scanner;

public class writingMethods {

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to the calculator program.");
    printOutput(calculate(getArguements()));
    }
    
    static float calculate(float[] array) // returns a data type and also uses a parameter
        // this method takes those inputs from getArugments and outputs the resulted calculated value
    {   float firstNumber = array[0];
        float method = array[1];
        float secondNumber = array[2];
        if(method == 1)
        {
            return firstNumber / secondNumber;
        }
        else if(method == 2)
        {
            return firstNumber * secondNumber;
        }
        else if(method == 3)
        {
            return firstNumber + secondNumber;
        }
        else if(method == 4)
        {
            return firstNumber - secondNumber;
        }
        else
        {
            System.out.println("Error code 1");
            return 0;
        }
    } // end of method 1
    
    static float[] getArguements() // uses a return data type, but no parameters
        // this method gets the two numbers and what types of calculation they have.
    {   float firstNumber;
        float method; // this doesn't necessarily need to be a float, but in order to return multiple
        // components I needed them to be the same data type to fit in the array.
        float secondNumber;
        Scanner localInput = new Scanner(System.in);
        System.out.print("Please enter your first number: ");
        firstNumber = localInput.nextFloat();
        System.out.print("To divide, multiple, add, or subtract, either type" +
    " d,m,a,s, or their appropriate symboles(/, *, +, and -): ");
        localInput.nextLine();
        char means = localInput.nextLine().toLowerCase().charAt(0);
        method = 0;
        while(method <1)
        {   if(means == 'd' || means == '/')
            {
                method = 1;
            }
            else if(means == 'm' || means == '*')
            {
                method = 2;
            }
            else if(means == 'a' || means == '+')
            {
                method = 3;
            }
            else if(means == 's' || means == '-')
            {
                method = 4;
            }
            else
            {
                System.out.println("Invalid input, please try again.");
                method = 0;
                means = localInput.nextLine().toLowerCase().charAt(0);
            }
        }
        System.out.print("Please enter your second number: ");
        secondNumber = localInput.nextFloat();
        float[] a = {firstNumber, method, secondNumber};
        return a;
    } // end of method 2

    static void printOutput(float a) // this uses one parameter and void
    {   // this simply prints the output from the calculator method.
        System.out.printf("The result is %.2f", a);
    } // end of method three
    
}
/*
 * Sample output 1:
 * Welcome to the calculator program.
 * Please enter your first number: 12
 * To divide, multiple, add, or subtract, either type d,m,a,s, or their appropriate symboles(/, *, +, and -): /
 * Please enter your second number: 6
 * The result is 2.00
 * 
 * Sample output 2:
 * Welcome to the calculator program.
 * Please enter your first number: 6
 * To divide, multiple, add, or subtract, either type d,m,a,s, or their appropriate symboles(/, *, +, and -): multiply
 * Please enter your second number: 7
 * The result is 42.00
 * 
 * Sample output 3:
 * Welcome to the calculator program.
 * Please enter your first number: 8
 * To divide, multiple, add, or subtract, either type d,m,a,s, or their appropriate symboles(/, *, +, and -): -
 * Please enter your second number: 6
 * The result is 2.00
 * 
 * Sample output 4:
 * Welcome to the calculator program.
 * Please enter your first number: 12
 * To divide, multiple, add, or subtract, either type d,m,a,s, or their appropriate symboles(/, *, +, and -): bad input
 * Invalid input, please try again.
 * /
 * Please enter your second number: 4
 * The result is 3.00
 */