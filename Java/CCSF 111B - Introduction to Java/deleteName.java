/* Written by Matthew Means 11/10/2024 (d/m/y)
 * This code was written for assignment #5 names "DeleteName" as part of the CCSF class 111B
 * "Introduction to Java". The purpose of this assignment is for the user to input a list of names, have
 * the program ask the user which names from the list to remove, and to then print the list again without the
 * requested name for removal.
 */


import java.util.Scanner;

public class deleteName {
    
    public static void main(String[] args){
        System.out.println("Welcome to the \"Delete Name\" program.");
        String[] names = getNames();
        int length = names.length;
        int removalIndex;
        removalIndex = determineName(names);
        names = removeName(names,removalIndex);
        length -= 1;
        printNames(names,length);
        
    } // end of main

    private static String[] getNames(){ // gets user input for original array of names
        Scanner localInput = new Scanner(System.in);
        int numPeople;
        System.out.print("Please enter how many names you would like to input: ");
        numPeople = localInput.nextInt();
        localInput.nextLine(); // scanner bug
        String[] names = new String[numPeople];
        for(int i = 0; i < names.length; i++){
            System.out.print("Please enter a name: ");
            names[i] = localInput.nextLine();
                while(names[i] == null || names[i].length() <= 1) // while loop to verify names input is valid
                {
                    System.out.print("Error: Please enter a valid name: ");
                    names[i] = localInput.nextLine();
                } // end of while loop
        } // end of for loop
        return names;
    } // end of getNames method

    private static String[] removeName(String[] names, int index){ // takes the string and removes the name
    for(int i = index; i < names.length-1; i++ )
    {
        names[i] = names[i+1];
    }
    return names;
    } // end of removeName method

    private static int determineName(String[] names){ // asks user what they want to remove
        Scanner localInput = new Scanner(System.in);
        System.out.println("Which name would you like to remove?");
        String nameToRemove = localInput.nextLine();
        
        int indexOfRemoval = -1;
        while(indexOfRemoval == -1)
        {
            for(int i = 0; i < names.length; i++)
            {
                if(nameToRemove.equals(names[i]))
                {
                    indexOfRemoval = i;
                }
            }
            if(indexOfRemoval == -1)
            {
                System.out.println("I couldn't recognize this name. Please try entering it again: ");
                nameToRemove = localInput.nextLine();
            }
        } // end of while loop
        for(int i = 0; i < names.length; i++)
        {
            if(nameToRemove.equals(names[i]))
            {
                indexOfRemoval = i;
            }
        }
        if(indexOfRemoval == -1)
        {
            System.out.println("I couldn't recognize this name. Please try entering it again: ");
            nameToRemove = localInput.nextLine();
        }
        return indexOfRemoval;
    } // end of determineName method

    private static void printNames(String[] names, int length){ // obviously prints the names
        System.out.println("The list now resembles:");
        for(int i = 0; i < length; i++)
        {
            System.out.println(names[i]);
        }

    } // end of printNames
} // end of deleteName class

/*
 * Example output 1:
 * Welcome to the "Delete Name" program.
 * Please enter how many names you would like to input: 3
 * Please enter a name: Christina
 * Please enter a name:
 * Error: Please enter a valid name: Paul
 * Please enter a name: Matthew
 * Which name would you like to remove?
 * Jake
 * I couldn't recognize this name. Please try entering it again:
 * Christina
 * The list now resembles:
 * Paul
 * Matthew
 * 
 * Example output 2:
 * Welcome to the "Delete Name" program.
 * Please enter how many names you would like to input: 5
 * Please enter a name: Jake
 * Please enter a name: Paul
 * Please enter a name: Matthew
 * Please enter a name: Sierra
 * Please enter a name: Jackson
 * Which name would you like to remove?
 * 
 * I couldn't recognize this name. Please try entering it again:
 * Bad Name
 * I couldn't recognize this name. Please try entering it again:
 * Sierra
 * The list now resembles:
 * Jake
 * Paul
 * Matthew
 * Jackson
 */