/* Craig Persiko
   CS 111B example program for Methods (Chapter 4)
   Variation of program from Think Java textbook at:
   https://books.trinket.io/thinkjava2/chapter4.html#sec50
*/

import java.util.Scanner;

public class printTimeFunction {
    static Scanner keyIn = new Scanner(System.in);
  
    // The main function inputs the hour and minute,
    // then outputs the time
    public static void main(String[] args) {
        System.out.println("Please enter hour, then minute:");
        int h = keyIn.nextInt();
        int m = keyIn.nextInt();
        String s;
        s = printTime(h, m);
        s = "The time is: " + s;
        System.out.println(s);
    }

    /* The printTime function returns the string representation
    of the time. (The original version outputted it instead of
    returning it, so it had "void" instead of "String" in the header below.) */
    public static String printTime(int hour, int minute) {
        return (hour + ":" + minute);
    }

}