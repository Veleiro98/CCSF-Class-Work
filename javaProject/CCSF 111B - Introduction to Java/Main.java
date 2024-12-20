/* Starter project for Assignment 14 File I/O for Grade Average
   CS 111B, Craig Persiko's class.  
   
   Your job is to write a program to read the grades.txt file
   in this project, to produce output like shown here.

   "grades.txt" is the file your program should read.
   "badformat.txt" is an example of a file that your program can't read, 
   so a clear error message should be generated, as shown in the sample output.
*/
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.*;

class Main
{
  private static final int NUM_SCORES = 4;
  // named constant for the number of scores per student in file

  public static void main(String[] args)
  {
    System.out.println("Welcome to the grade average calculator program!");
    System.out.print("Please enter the name of your file (txt format): ");
    Scanner userScan = new Scanner(System.in);
    String inputFileName = null;
    String outputFileName = null;
    boolean lineNeeded = true;
    String[][] inputFile = null;
    while(lineNeeded)
    {
      try
       {
         inputFileName = userScan.nextLine();
         lineNeeded = false;
       }
       catch(Exception e)
        {
          System.out.println("Unexpected input. Please try again.");
       }
    } // end of while loop


    //PrintWriter printer = new PrintWriter(new File("inputFile"));
    boolean fileHealth = false; // assumed bad until proven otherwise
    fileHealth = checkFilehealth(inputFileName); // handles exceptions internally
    if(fileHealth == false)
    {
      System.out.println("Warning, this file is not of  correct format and may be bad. Ending program now. \n" +
      " Please correct the file and/or try again.");
      System.exit(0);
    }
    // now that we know that the file is healthy we can continue as normal.
    // we will start by 
    long lineCount = 1;
    try
    {
      lineCount = Files.readAllLines(Paths.get("javaProject\\CCSF 111B - Introduction to Java\\" +
        inputFileName)).size();
    }
    catch(Exception e)
    {
      System.out.println("Unexpected error handling the file. Ending program.");
      System.exit(0);
    }
    // Below we actually open the file and insert all of its string data into an array.
    String[][] fileData = new String[(int)lineCount][];
    try
    {
      Scanner fileScanner = new Scanner(new File("javaProject\\CCSF 111B - Introduction to Java\\" +
      inputFileName));
      for(int i = 0 ; i < lineCount ; i++)
      {
        fileData[i] = fileScanner.nextLine().split(" ");
      }
      fileScanner.close();
    }
    catch(Exception e)
    {
      System.out.println("Unexpected error handling the file. Ending program.");
      System.exit(0);
    }
    /// now we work on creating the output file
    System.out.print("Please enter the name of the output file you want to create: ");
    boolean loopCheck = true;
    while(loopCheck)
    {
      try
      {
        outputFileName = userScan.nextLine();
        File outputFile = new File("javaProject\\CCSF 111B - Introduction to Java\\" + outputFileName);
        userScan.close();
      }
      catch(Exception e)
      {
        System.out.println("Unable to create output file. Please remember to put the file type after " +
        " (such as .txt). Please try again: ");
      }
    loopCheck = false;
    }

    try
    {
      PrintWriter outputWriter = new PrintWriter(new File(outputFileName));
      for(int i = 0 ; i < lineCount; i++)
      {
        outputWriter.println(fileData[i][0] + " " + (Integer.parseInt(fileData[i][1]) +
         Integer.parseInt(fileData[i][2]) +
         Integer.parseInt(fileData[i][3]) + 
         Integer.parseInt(fileData[i][4]))/NUM_SCORES);
      }
      System.out.println("File created successfully. Program ending.");
      outputWriter.close();
      
    }
    catch(Exception e)
    {
      System.out.println("Failed to create new file and write data.");
    }




  } // end of main method

  private static boolean checkFilehealth(String fileToCheck)
  {
    try
    {
    Scanner scan = new Scanner(new File("javaProject\\CCSF 111B - Introduction to Java\\" + fileToCheck));
    while(scan.hasNextLine())
    {
      if(scan.nextLine().split(" ").length == 5)
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
      System.out.println("Exception raised. Please double check the file name and try again.");
      return false;
    }
    catch(Exception e)
    {
      System.out.println("Exception raised. Please double check the file name and try again.");
      return false;
    }
  }
}

/* Sample Output 1:

 Welcome to the grade average calculator program!
Please enter the name of your file (txt format): grades.txt
Please enter the name of the output file you want to create: out2.txt
File created successfully. Program ending.

Sample output 2:
Welcome to the grade average calculator program!
Please enter the name of your file (txt format): badFormat.txt
Warning, this file is not of  correct format and may be bad. Ending program now.
 Please correct the file and/or try again.

grades.txt file contains:
Biden 85 90 95 98
Trump 50 70 75 80
Obama 90 95 98 97
Bush 80 70 75 85
Clinton 90 95 85 99
Bush 85 95 90 94

badFormat.txt file contains:
Biden 85 90
Trump 50 70 75 
Obama 90 95 98 97
Bush 80 70 75 85
Clinton 90 95 85 99Bush 85 95 90 94

Here are the average grades produced when done correctly:
Biden 92
Trump 68
Obama 95
Bush 77
Clinton 92
Bush 91

*/
