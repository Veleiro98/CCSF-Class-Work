/* Mayors Names

  See instructions in Canvas
*/

import java.io.*;
import java.util.*;

class Main 
{
  public static void main(String[] args)
  {
    Scanner inFile = null, keyboard;
    String first, middle, last;
    ArrayList<FullName> mayorList = new ArrayList<FullName>();
    keyboard = new Scanner(System.in);

    System.out.println("We have a new mayor:");
    System.out.println("Please enter first name");
    first = keyboard.nextLine();
    System.out.println("Please enter middle name");
    middle = keyboard.nextLine();
    System.out.println("Please enter last name");
    last = keyboard.nextLine();

    
    // DO NOT CHANGE ANY OF THE ABOVE CODE.

    boolean loopCheck = true;
    try
    {
      if(checkFilehealth("Mayors.txt") == false)
      {
        System.out.println("Error reading or writing file: Mayors.txt. This file may not be in the " +
        "correct format"); // I added a check to see if the file is of the right format
        System.out.println("Please correct or replace the file and try again. Program ending");
        System.exit(0);
      }
      mayorList.add(new FullName(first,middle,last));
      inFile = new Scanner(new File("javaProject\\CCSF 111B - Introduction to Java\\" + "Mayors.txt"));
      String[] placeHolder = new String[3];
    
      while(inFile.hasNextLine())
      {
        placeHolder = inFile.nextLine().split(" ");
        mayorList.add(new FullName(placeHolder[0],placeHolder[1],placeHolder[2]));
      }
      inFile.close();
      keyboard.close();

    }
    catch(Exception e)
    {
      System.out.println("Please try again.");
    }
    

    // DO NOT CHANGE ANY OF THE BELOW CODE.
   

    Collections.sort(mayorList);
    System.out.println("Here is the list of mayors, sorted by last name:");
    for(FullName mayorName : mayorList)
      System.out.println(mayorName);
  }

  private static boolean checkFilehealth(String fileToCheck)
  {
    try
    {
    Scanner scan = new Scanner(new File("javaProject\\CCSF 111B - Introduction to Java\\" + fileToCheck));
    while(scan.hasNextLine())
    {
      if(scan.nextLine().split(" ").length == 3)
        {
          //does nothing as this is fine
        }
      else
        {
          scan.close();
          return false; // flags as bad file if line length isn't five
        }
    } // end of while loop
    scan.close();
    return true;
    } // end of try
    catch(IOException e)
    {
      System.out.println("IOException raised. Please double check the file name and try again.");
      return false;
    }
    catch(Exception e)
    {
      System.out.println("Exception raised. Please double check the file name and try again.");
      return false;
    }
  }
}

/*
 * Sample Outputput 1:
 * We have a new mayor:
Please enter first name
Matthew
Please enter middle name
Buchanan 
Please enter last name
Means
Here is the list of mayors, sorted by last name:
Arthur Christ Agnos
London Nicole Breed
Willie Lewis Brown
Dianne Goldman Feinstein
Francis Michael Jordan
Edwin Mah Lee
Matthew Buchanan Means
George Richard Moscone
Gavin Christopher Newsom

Sample Output 2:
/* 
We have a new mayor:
Please enter first name
Corrupt
Please enter middle name
Politician
Please enter last name
Mcgee
Here is the list of mayors, sorted by last name:
Arthur Christ Agnos
London Nicole Breed
Willie Lewis Brown
Dianne Goldman Feinstein
Francis Michael Jordan
Edwin Mah Lee
Corrupt Politician Mcgee
George Richard Moscone
Gavin Christopher Newsom
*/

/* 
 * Just for funsies I also incorporated a fileHealthChecker function 
 * incase if Mayors.txt is in the wrong format much like the I/O
 * assignment we did.
 * 
 * I.E. if Mayors.txt looks like this:
London Nicole Breed
Edwin Mah Lee
Gavin Christopher Newsom
Willie Lewis Brown
Francis Michael Jordan
Arthur Christ Agnos
Dianne Goldman Feinstein George Richard Moscone

it will output this results:
We have a new mayor:
Please enter first name
Matthew
Please enter middle name
Buchanan
Please enter last name
Means
Error reading or writing file: Mayors.txt. This file may not be in the correct format
Please correct or replace the file and try again. Program ending

I had a great semester with this class. Thank you!
 */
