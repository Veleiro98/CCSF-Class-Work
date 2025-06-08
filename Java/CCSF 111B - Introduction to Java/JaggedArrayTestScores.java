/* JaggedArrayTestScores by Craig Persiko, modified by Matthew Means on 4/11/2024 (d/m/y)
   program for CS 111B "Introduction to Java"
   Shows how a 2-D array can be jagged: have different numbers of columns for each row.
   Inputs test scores for courses - each course can have a different number of tests.
   UPDATE(12/11/2024(dmy)): This file is modified for the exception handling exercise by 
   Matthew Means
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class JaggedArrayTestScores
{
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    int numCourses = 0;
    int numTests = 0;
    double[][] testScores;

    boolean courseNumCheck = true;
    while(courseNumCheck)
    {
      try{
        System.out.println("How many courses are you taking? ");
        numCourses= s.nextInt();
        courseNumCheck = false;
      }
      catch(InputMismatchException e)
      {
        System.out.println("You must enter an integer.");
        s.nextLine(); // for the "scanner bug"
      }
      finally
      {
        if((float)numCourses < 0)
        {
          courseNumCheck = true;
          System.out.println("Your entry must be positive");
        }
      }
    }
  
	  double[] average = new double[numCourses];
    
    testScores = new double[numCourses][]; 
    // allocate an array of references to 1-D arrays (rows) but leaving the columns of null size for now
	 boolean trueChecker = true;
    for(int i = 0; i < numCourses; i++) // traverses each column in row i
    {
      trueChecker = true;
      while(trueChecker)
      {
        try
        {
          System.out.print("How many tests are in course number " 
                         + (i+1) + "? ");
          numTests = s.nextInt();
          trueChecker = false;
        }
        catch(InputMismatchException e)
        {
          System.out.println("You must enter an integer.");
          s.nextLine(); // for the "scanner bug"
        }
        finally
        {
          if(numTests<0)
          {
           System.out.println("You must enter a positive integer.");
           trueChecker = true;
          }
        }
      }
      testScores[i] = new double[numTests];  // allocates the amount of columns for row i: a 1-D array of doubles
    }
	 boolean trueChecker2; // marker for the while loop below with internal exception handler
    for(int courseId=0; courseId < testScores.length; courseId++) // this for loop traverses the first testScores dimension
    {
      for(int testId=0; testId < testScores[courseId].length; testId++) // and this loop tranverses the second testScores dimension
        { trueChecker2 = true; // for every loop this restarts the while loop below
          while(trueChecker2) // this while loop is inside both loops to ensure each input is valid despite exceptions arising
          {
            System.out.print("What was your grade on test " 
               + (testId+1) + " for course " + (courseId+1) + "? ");
            try
            {
              testScores[courseId][testId] = s.nextDouble();
              trueChecker2 = false; // if an exception doesn't occur and break from the previous line, this line finishes the while loop
            }
            catch(InputMismatchException e)
            {
              System.out.println("Please enter a number.");
              s.nextLine(); // for the "scanner bug"
            }
            finally
            {
              if(testScores[courseId][testId] < 0)
              {
               System.out.println("You must enter a positive value.");
               trueChecker2 = true;
              }
            }
          }
        }
      System.out.println(); // blank line to separate courses
    }

    for(int i = 0 ; i < numCourses; i++) // sums up the values of tests for each course (prior to division)
    {
        for(int j = 0; j < testScores[i].length; j++)
        {
            average[i] += testScores[i][j];
        }
    }


    for(int i = 0 ; i < average.length ; i++) // averages out the sum for each course
    {
        average[i] = average[i] / testScores[i].length;
    }

    double highestAverage = 0;
    for(int i = 0; i < average.length ; i++) // finds the highest average
    {
        System.out.printf("the average value for course# %d is %.2f%n", i+1 , average[i]);
        if(average[i] > highestAverage)
            highestAverage = average[i];
    }
        System.out.println(); // for a space to separate average values from highest
        System.out.printf("The highest average value is %.2f", highestAverage);
  }
}

/* Sample Output:
How many courses are you taking? 
x
You must enter an integer.
How many courses are you taking? 
-1
Your entry must be positive
How many courses are you taking?
2
How many tests are in course number 1? x
You must enter an integer.
How many tests are in course number 1? -1
You must enter a positive integer.
How many tests are in course number 1? 1
How many tests are in course number 2? -1
You must enter a positive integer.
How many tests are in course number 2? x
You must enter an integer.
You must enter a positive integer.
How many tests are in course number 2? 2
What was your grade on test 1 for course 1? -1
You must enter a positive value.
What was your grade on test 1 for course 1? 110

What was your grade on test 1 for course 2? x
Please enter a number.
What was your grade on test 1 for course 2? 85
What was your grade on test 2 for course 2? 100

the average value for course# 1 is 110.00
the average value for course# 2 is 92.50

The highest average value is 110.00
*/