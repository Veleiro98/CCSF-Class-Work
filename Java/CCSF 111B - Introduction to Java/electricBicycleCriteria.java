/* This file is part of a practice assignment for CCSF 111B - "Introduction to Java". The
 * assignment is for the "Programming Exercise for Chapter 5: Electric Bicycle Criteria.
 * This was written by Matthew Means on 18/9/24 (d/m/y). The purpose of this assignment is
 * to practice conditional statements and 
 */

import java.util.Scanner;

public class electricBicycleCriteria
{
    
    public static void main(String[] args)
    { 
        System.out.println("I'm going to help you choose an electric bicycle.\nPlease enter the"+
        " following for a bike model:");
        Scanner input = new Scanner(System.in);
        System.out.println("How much does it cost?");
        float cost = input.nextFloat();
        System.out.println("How much does it weight in pounds?");
        float weight = input.nextFloat();
        System.out.println("How many watt hours is the battery?");
        float power = input.nextFloat();
        checkViability(cost,weight,power);
    } // end of main


    public static void checkViability(float cost, float weight, float power)
    {   // this method checks to see if the inputs fit the conditions and outputs different strings depending on viability.
        final int MAX_PRICE = 3000;
        final int MAX_WEIGHT = 60;
        final int MIN_BATTERY = 400;
        if (cost > MAX_PRICE)
        {
            System.out.println("This is too expensive.");
        }
        if (weight > MAX_WEIGHT)
        {
            System.out.println("This is too heavy.");
        }
        if (power < MIN_BATTERY)
        {
            System.out.println("This battery is too weak.");
        }
        if (cost < MAX_PRICE && weight < MAX_WEIGHT && power > MIN_BATTERY)
        {
            System.out.println("This is a good choice.");
        }
        else
        {
            System.out.println("This is not a good choice. Please try again.");
        }
    } // end of checkViability method
} // end of class

/* First Sample output:
 * I'm going to help you choose an electric bicycle.
 * Please enter the following for a bike model:
 * How much does it cost?
 * 2900
 * How much does it weight in pounds?
 * 70
 * How many watt hours is the battery?
 * 300
 * This is too heavy.
 * This battery is too weak.
 * This is not a good choice
 * 
 * Second Sample output:
 * I'm going to help you choose an electric bicycle.
 * Please enter the following for a bike model:
 * How much does it cost?
 * 2500
 * How much does it weight in pounds?
 * 50.54
 * How many watt hours is the battery?
 * 550
 * This is a good choice.
 */
