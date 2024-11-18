/* JaggedArrayTestScores by Craig Persiko, modified by Matthew Means on 4/11/2024 (d/m/y)
   program for CS 111B "Introduction to Java"
   Shows how a 2-D array can be jagged: have different numbers of columns for each row.
   Inputs test scores for courses - each course can have a different number of tests.
*/

import java.util.Scanner;

public class JaggedArrayTestScores
{
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    int numCourses, numTests;
    double[][] testScores;

    System.out.print("How many courses are you taking? ");
    numCourses = s.nextInt();
	double[] average = new double[numCourses];
    
    testScores = new double[numCourses][]; 
    // allocate an array of references to 1-D arrays (rows)
	 
    for(int i = 0; i < numCourses; i++)
    {
      System.out.print("How many tests are in course number " 
                       + (i+1) + "? ");
      numTests = s.nextInt();
      testScores[i] = new double[numTests];  // allocate this row: a 1-D array of doubles
    }
	 
    for(int courseId=0; courseId < testScores.length; courseId++)
    {
      for(int testId=0; testId < testScores[courseId].length; testId++)
        {
          System.out.print("What was your grade on test " 
                           + (testId+1) + " for course "
                           + (courseId+1) + "? ");
          testScores[courseId][testId] = s.nextDouble();
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

How many courses are you taking? 3
How many tests are in course number 1? 3
How many tests are in course number 2? 4
How many tests are in course number 3? 5
What was your grade on test 1 for course 1? 93
What was your grade on test 2 for course 1? 88
What was your grade on test 3 for course 1? 79

What was your grade on test 1 for course 2? 83
What was your grade on test 2 for course 2? 89
What was your grade on test 3 for course 2? 93
What was your grade on test 4 for course 2? 77

What was your grade on test 1 for course 3? 68
What was your grade on test 2 for course 3? 73
What was your grade on test 3 for course 3? 84
What was your grade on test 4 for course 3? 79
What was your grade on test 5 for course 3? 92

the average value for course# 1 is 86.67
the average value for course# 2 is 85.50
the average value for course# 3 is 79.20

The highest average value is 86.67

*/