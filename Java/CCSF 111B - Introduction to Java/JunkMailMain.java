/* RobustJunkMail  -  Craig Persiko  -  CS 111B
   Junk Mail Personalizer - sample program using file i/o
   and exception handling
*/
import java.io.*;
import java.util.Scanner;

class JunkMailMain
{
  public static void main(String[] args)
  {
    String inFileName, outFileName, customerName;
    boolean loopNeeded;
    Scanner inFile = null, keyboard;
    PrintWriter outFile = null;
    // = null added above because otherwise we get
    // a compiler error that inFile and outFile
    // might not have been initialized (since code
    // in a try block doesn't always get executed)

    System.out.println("Welcome to the Junk Mail Personalizer.");

    // Set up keyboard input reader:
    keyboard = new Scanner(System.in);

    do
    {
      System.out.println("Enter name of file with text of template letter using name codes");
      inFileName = keyboard.nextLine();
      try
      {
        // Set up file input reader and open file:
        inFile = new Scanner(new File(inFileName));
        loopNeeded = false; // if no exception from above
      }
      catch(IOException e)
      {
        System.out.println("Unable to open file: " + inFileName);
        loopNeeded = true;
      }
    }while(loopNeeded);

    do
    {
      System.out.println("Enter name of output file to create with complete letter");
      outFileName = keyboard.nextLine();

      try
      {
        // the function openNewOutputFile is defined below
        outFile = openNewOutputFile(outFileName);
        loopNeeded = false; // above line worked
      }
      catch(IOException e)
      {
        System.out.println("Unable to open file: " + outFileName);
        loopNeeded = true;
      }
    }while(loopNeeded);

    System.out.println("Please enter the name of letter recipient");
    customerName = keyboard.nextLine();

    try
    {
      mergeName(inFile, outFile, customerName);
      inFile.close();
      outFile.close();
      System.out.println("Personalized letter has been saved!");
    }
    catch(Exception e)
    {
      System.out.println("Error reading or writing file: " + e.getMessage());
      System.out.println("Personalized letter is probably incomplete.");
    }
  }

  // Set up file output stream and open file with specified name
  // This function doesn't catch the checked exceptions that might occur,
  // so the compiler requires us to declare that with a "throws" clause
  static PrintWriter openNewOutputFile(String name) throws IOException
  {
    return new PrintWriter(new File(name));
  }
  
  // read the text from "fin", outputting it to "fout",
  // replacing #N# with "name" wherever it is found.
  static void mergeName(Scanner fin, PrintWriter fout, String name)
  {
    final String NAME_CODE = "#N#";
    String lineIn;
    int name_idx;

    while (fin.hasNextLine()) // while there are lines in the file
    {
      lineIn = fin.nextLine();
      name_idx = lineIn.indexOf(NAME_CODE);
      while (name_idx > -1) // while NAME_CODE is in lineIn
      {
        // output text before name:
        fout.print(lineIn.substring(0, name_idx));
        fout.print(name); // output name
        // cut off that beginning part of lineIn that we've handled already:
        lineIn = lineIn.substring(name_idx + NAME_CODE.length());
        name_idx = lineIn.indexOf(NAME_CODE);
      }
      // print remainder of line (entire line if NAME_CODE not found)
      fout.println(lineIn);
    }
  }
}

/*  Sample Output ('$ cat' below is a Linux prompt followed by the 
                   'cat' command to display a text file. 
                   You may display the file a different way.):

Welcome to the Junk Mail Personalizer.
Enter name of file with text of template letter using name code
trash
Unable to open file: trash
Enter name of file with text of template letter using name code
iguanaLetter.txt
Enter name of output file to create with complete letter
trash/trash
Unable to open file: trash/trash
Enter name of output file to create with complete letter
myIggy.txt
Please enter the name of letter recipient
Gloria
Personalized letter has been saved!

$ cat iguanaLetter.txt
Hello, #N#!

Have you heard yet about the Bay Area's #1 iguana trainers?
Don't you think it's time your friends said, "What a talented
iguana you have, #N#!"  Well, #N#, look no further.
We will teach your iguana to do flips in the air, jump
backwards, and do the moonwalk, all on command!

Call now, and we'll include a free book, "Iguana Psychology",
to help you, #N#, and your iguana really become close.
Just mention offer #N-P.

Iguana Lovers - (415) LUV-IGUANA

$ cat myIggy.txt
Hello, Gloria!

Have you heard yet about the Bay Area's #1 iguana trainers?
Don't you think it's time your friends said, "What a talented
iguana you have, Gloria!"  Well, Gloria, look no further.
We will teach your iguana to do flips in the air, jump
backwards, and do the moonwalk, all on command!

Call now, and we'll include a free book, "Iguana Psychology",
to help you, Gloria, and your iguana really become close.
Just mention offer #N-P.

Iguana Lovers - (415) LUV-IGUANA

*/
