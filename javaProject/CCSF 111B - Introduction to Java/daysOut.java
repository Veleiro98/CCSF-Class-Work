/* Programming Exercise for Chapters 4-6: Days Out, for CS 111B
 * Written by Matthew Means, 25/9/24 d/m/y
 * 
 * It outputs the average number of days a company's employees are absent using user
 * input regarding how many employees there are and how many days each miss.
*/
import java.util.Scanner;

public class daysOut
{
  static Scanner keyIn = new Scanner(System.in);

  public static void main(String args[])
  {
    int   employees,            // The number of employees
          daysAbsent;           // Total days misssed by all employees

    employees = getNumEmps();
    daysAbsent = getDaysMissed(employees);
    showAvgDaysMissed(employees, daysAbsent);
  } // End of main function

  static int getNumEmps() /* A method called by main that asks the user for the number
   of employees in the company. This value should be returned as an int. (The method 
   accepts no arguments.) */
  { 
    Scanner localInput = new Scanner(System.in);
    System.out.print("How many employees does the company have? ");
    int output;
    output = localInput.nextInt();
    while(output < 0 || output == 0)
    {
      System.out.println("Invalid input, please enter a positive integer value.");
      output = localInput.nextInt();
    }
    return output;
  } // end of function getNumEmps

  static int getDaysMissed( int numbOfEmployees) /*A method called by main that accepts
   one argument: the number of employees in the company. The method should ask the user 
   to enter the number of days each employee missed during the past year. The total of 
   these days should be returned as an int.*/
  {
    Scanner localInput = new Scanner(System.in);
    int totalDays = 0;
    for( int i = 0; i < numbOfEmployees; i++)
    {
      System.out.printf("Days missed by employee #%d: ", i+1);
      int temp = localInput.nextInt();
      if (temp >= 0)
        {totalDays += temp;}
      else
        {while(temp < 0)
          {System.out.print("Invalid input, please try again : ");
          temp = localInput.nextInt();
          } // end of while loop
          totalDays += temp;
        } // end of else
    } // end of for loop
    return totalDays;
  } // end of getDaysMissed method

  static void showAvgDaysMissed(int numbOfEmployees , int totalDaysMissed) /*A method
   called by main that takes two arguments: the number of employees in the company and
    the total number of days absent for all employees during the year. This should be 
    a void method (with no return value). It should output on the screen the average 
    number of days missed per employee. */

  {
    float avg;
    avg = (float) totalDaysMissed / numbOfEmployees;
    System.out.printf("The average number of days missed per employee is: %.1f",  avg);
  } // end of showAvgDaysMissed method

} // End of class Main

/*
 * sample output #1
 * How many employees does the company have? 5
 * Days missed by employee #1: 4
 * Days missed by employee #2: 3
 * Days missed by employee #3: 2
 * Days missed by employee #4: 5
 * Days missed by employee #5: 1
 * The average number of days missed per employee is: 3.0
 * 
 * sample output #2
 * How many employees does the company have? 0
 * Invalid input, please enter a positive integer value.
 * 3
 * Days missed by employee #1: -3
 * Invalid input, please try again :
 * 0
 * Days missed by employee #2: 6
 * Days missed by employee #3: 3
 * The average number of days missed per employee is: 3.0
 */