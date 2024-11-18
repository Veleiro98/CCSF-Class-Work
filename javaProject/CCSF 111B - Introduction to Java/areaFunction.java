/* This file is part of a practice assignment for CCSF 111B - "Introduction to Java". The
 * assignment is for the "Programming Exercise for Chapter 4: Area Function" assignment.
 * This was written by Matthew Means on 13/9/24 (d/m/y). The purpose of this assignment is
 * to practice making an auxiliary method to calculate and return the area value for input
 * values from the scanner static function.
 */

import java.util.Scanner;

public class areaFunction
{
    public static void main(String[] args) {
    {
        Scanner input = new Scanner(System.in);  // initializing scanner object
        System.out.println("Welcome to the area calculator program");
        System.out.println("Please enter your width:");
        float width = input.nextFloat();
        System.out.println("Please enter your height:");
        float height = input.nextFloat();
        System.out.printf("Area is: % ,.2f, rounded to the nearest hundreths place\n", calcArea(width,height));
        System.out.println("end of program");
    }
    } // end of main method
    public static float calcArea(float x, float y)
    {
        return x*y;
    }
} // end of class declaration

/* Sample output 1:
 * Welcome to the area calculator program
 * Please enter your width:
 * 4.5
 * Please enter your height:
 * 9.2
 * Area is: 41.40, rounded to the nearest hundredths place
 * end of program
 *
 * Sample output 2:
 * Please enter your width:
 * 5.3
 * Please enter your height:
 * 3.8
 * Area is: 20.14, rounded to the nearest hundredths place
 * end of program
 */