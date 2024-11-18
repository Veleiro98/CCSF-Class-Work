/* 
This code is for the midterm assignemtn for CCSF 111B - Introduction to Java
It was written 14/10/2024 (d/m/y) by Matthew Means
The purpose of this program is to take four names from the user and to substitute one them with
a desired alernative person's name.
*/

import java.util.Scanner;

class subTeam
{
  static Scanner keyIn = new Scanner(System.in);
  
  public static void main(String[] args)
  {
    String[] team;
    String nameToRemove, nameToAdd;
  
    System.out.println("Please enter 4 names for this team:"); 
    team = inputTeam(4);

    System.out.print("Now please enter one of those names again: ");
    nameToRemove = keyIn.next();
    System.out.print("Please enter a new name to substitute instead of that one: ");
    nameToAdd = keyIn.next();
    System.out.println("Okay, replacing " + nameToRemove
                       + " with " + nameToAdd);
    substitute(team, nameToRemove, nameToAdd);

    System.out.println("Here is your team:");
    outputArray(team);
  }

  public static String[] inputTeam(int size){ // this creates the array and checks user input for error
    String[] output = new String[size];
    Scanner localInput = new Scanner(System.in);
    for(int i = 0; i < size ; i++)
    {
      System.out.print("name: ");
      output[i] = localInput.nextLine();
      while(output[i] == null || output[i].length() <= 1) // while loop to verify names input is valid
      {
        System.out.print("Error: Please enter a valid name: ");
        output[i] = localInput.nextLine();
      } // end of while loop
    } // end of for loop
    return output;
  } // end of inputTeam method

  public static void substitute(String[] team, String nameToRemove, String nameToAdd) // this replaces the 
  // name that we want to remove with the alternative name
  { for(int i = 0 ; i < team.length ; i++)
    { 
      if(team[i].equals(nameToRemove))
      {
        team[i] = nameToAdd;
      }
    }

  } // end of substitute method

  public static void outputArray(String[] team) // this method just prints out the array for console
  {
    for(int i = 0 ; i < team.length ; i++)
    {
      System.out.print(team[i]);
      if(i != team.length -1)
      {
        System.out.print(", ");
      } // this for loop just gives it commas, but not an extra after the last one
    }
  } // end of outputArray method
}

/* 
Sample output 1:
Please enter 4 names for this team:
name: Craig
name: Sam
name: Matt 
name: Doug
Now please enter one of those names again: Doug
Please enter a new name to substitute instead of that one: Selma
Okay, replacing Doug with Selma
Here is your team:
Craig, Sam, Matt, Selma

Sample output 2:
Please enter 4 names for this team:
name: Kylie
name: Daniel
name:
Error: Please enter a valid name: Samantha
name: Joey
Now please enter one of those names again: Daniel
Please enter a new name to substitute instead of that one: Esmerleda
Okay, replacing Daniel with Esmerleda
Here is your team:
Kylie, Esmerleda, Samantha, Joey
*/