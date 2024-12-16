/* File I/O Exercise for CS 111B
   Written by Matthew Means 13/12/2024(d/m/y)
   The purpose of this exercise "File I/O" for CCSF 111B - Introduction to Java is:
   "From the computer and mathematical occupations in EmploymentDataSF_2023.csv, which occupation has the most workers, and what is their mean annual wage? 
   Print that on the screen.
   Also, save to a separate file: the header line and all data for occupations with more than 10,000 workers."
   
*/


import java.io.*;
import java.util.Scanner;
import java.nio.file.*;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner scan = new Scanner(System.in);
    /* sample PrintWriter code for later:
    try
    {
    PrintWriter printStream = new PrintWriter(new File("example.txt"));
    printStream.println("Sample output");
    printStream.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Failure to create output file.");
    }
    */
    String lineIn, lineOut, outputFileName; // To store one line at a time from the file
    String[][] lineData; // To store an array of data from one line of the file
    int numOfLines = 0; // just to instantiate it, this will be over written.
  

    System.out.println("Welcome to the employment data analyzer.");
    System.out.println("Enter name of output file to create:");
    outputFileName = scan.nextLine();
    
    numOfLines = lineCount("javaProject\\CCSF 111B - Introduction to Java\\" + "EmploymentDataSF_2023.csv"); //handles exception inside, returning 0 if unsolvable.
    lineData = new String[numOfLines][]; // making rows
    boolean loopCheck = true;
    do // this do-while loop takes the input file and puts it into the lineData[lineData.length][5] array.
    {
      try
      {
        // Set up file input reader and open file:
        scan = new Scanner(new File("javaProject\\CCSF 111B - Introduction to Java\\" + "EmploymentDataSF_2023.csv"));

        for(int i = 0; i < lineData.length; i++) // filling the lineData columns with data until no more
        {
        lineIn = scan.nextLine(); 
        // split on commas, put individual values into lineData array:
        lineData[i] = lineIn.split(","); 
        if(!scan.hasNextLine()) // checks if theres a next line, otherwise terminates the loop 
        {
          loopCheck = false;
        }
        }

        // THIS IS JUST A DEMO EXAMPLE FOR YOU TO CHANGE:

      }
      catch(IOException e)
      {  // handle file i/o errors:
        System.out.println("Unable to open file: EmploymentDataSF_2023.csv");
        System.out.println(e.getMessage());
       return; // end the program
      }
      catch(Exception e)
      {  // handle other errors:
        System.out.println("The file EmploymentDataSF_2023.csv isn't in the right format:");
        System.out.println(e.getMessage() + "\nOutput file is probably incomplete.");
      }
    
    } // end of do-loop
    while(loopCheck);

    int rowOfInterest = 0; // the row that we care about AKA which company
    int highestAmountOfWorkers = 0; // counter for highest amount of workers
    int numOfCompaniesAbove10KEmployees = 0;
    for(int i = 1 ; i < lineData.length ; i++) //starting index at 1 because the first line is the column titles.
    {
      if(lineData[i].length != 5)
      {
        System.out.println("The file EmploymentDataSF_2023.csv isn't in the right format:\n" + //
                    "5 values should be in each line, separated by commas.\n" + //
                    "Output file is probably incomplete.");
        try{
          scan.close();
        }
        catch(Exception e){}
        return; // if the data is invalid, closes input scanner and immediately stops after warning
      }
      if(Integer.parseInt(lineData[i][1]) >= highestAmountOfWorkers)
      {
        highestAmountOfWorkers = Integer.parseInt(lineData[i][1]);
        rowOfInterest = i;
      }
      if(Integer.parseInt(lineData[i][1]) >= 10000)
      {
        numOfCompaniesAbove10KEmployees++;
      }
    }
    System.out.printf("%s lead as the occupation with the most employees. Their mean annual wage is "
    + "$%s\n", lineData[rowOfInterest][0], lineData[rowOfInterest][4]);

    // this for loop is to print every row that is suitable

    try
    { 
      PrintWriter outputWriter = new PrintWriter(new File(outputFileName));
      outputWriter.println(lineData[0][0] + "," + lineData[0][1] + "," + lineData[0][2] + "," + 
      lineData[0][3] + "," + lineData[0][4]);
      for(int j = 1 ; j < lineData.length ; j++)
      {
        if(Integer.parseInt(lineData[j][1]) > 10000)
        {
          outputWriter.println(lineData[j][0] + "," + lineData[j][1] + "," + lineData[j][2] + "," + 
          lineData[j][3] + "," + lineData[j][4]);
        }
      }
      outputWriter.close();
      scan.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Failure to create output file.");
    }
} // end of main method


  static private int lineCount(String fileName) // this finds the linecount for a file
  {
    boolean check = true;
    do
    {
      try
      {
      Path filePath = Paths.get(fileName); // recommendation from chatGPT to use this class
      int lineCount = (int)Files.lines(filePath).count();
      check = false;
      return lineCount;
      }
      catch(IOException e)
      {
        System.out.println("Error with file name and could not find file path.");
        return 0;
      }
    } // end of do-while loop
    while(check);
  } // end of lineCount method
} // end of class
 
/*  
** When EmploymentDataSF_2023.csv is not saved in the right place: ** 
Welcome to the employment data analyzer.
Enter name of output file to create:
sampleOutput3.csv
Error with file name and could not find file path.
Unable to open file: EmploymentDataSF_2023.csv
javaProject\CCSF 111B - Introduction to Java\EmploymentDataSF_2023.csv (The system cannot find the file specified)
(thats just my relative path to where it normally would be)

** When EmploymentDataSF_2023.csv has an incomplete line: **
Welcome to the employment data analyzer.
Enter name of output file to create:
sample.txt
The file EmploymentDataSF_2023.csv isn't in the right format:
5 values should be in each line, separated by commas.
Output file is probably incomplete.

** When EmploymentDataSF_2023.csv is complete: **
Welcome to the employment data analyzer.
Enter name of output file to create:
sampleOutput.txt
Software developers lead as the occupation with the most employees. Their mean annual wage is $181220

within sampleOutput.txt is:
Occupation,Number of workers,Location quotient,Mean Hourly Wage,Mean Annual Wage
Computer systems analysts,10660,1.3,69.15,143830
Computer user support specialists,10100,0.9,42.61,88620
Software developers,83920,3.2,87.13,181220
Computer occupations (all other),20120,2.9,67.27,139930
*/
