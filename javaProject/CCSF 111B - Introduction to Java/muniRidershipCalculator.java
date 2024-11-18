import java.util.Scanner; // all imports are prior to the main class declaration

public class muniRidershipCalculator
/* GradeAverage is also the file name
(note to self) */
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);  // initializing scanner object
	    String route; // declaring variables for later
	    float average;
	    int duration;
	    int count;
	    System.out.println("Welcome to the Muni Ridership Calculator.\n"
	    + "Which Muni line did you survery?");
	    route = input.nextLine();
		System.out.println("How many days did you survey ridership?");
		duration = input.nextInt();
		System.out.println("How many riders did you count?");
		count = input.nextInt();
		average = (float)count / duration; // type casting to accurately divide
		System.out.printf("According to your survey, an average of %,.2f"
		+ " people\nrode the %s per day.", average, route); /*A concatenating
		printf statement */
	}
}
/* First example output resulted:
Welcome to the Muni Ridership Calculator.
Which Muni line did you survery?
M-Ocean View
How many days did you survey ridership?
5
How many riders did you count?
358
According to your survey, an average of 71.60 people
rode the M-Ocean View per day.

--------------------------------------------------------------------------------

    Second example output resulted:
Welcome to the Muni Ridership Calculator.
Which Muni line did you survery?
N-Judah
How many days did you survey ridership?
8
How many riders did you count?
1263
According to your survey, an average of 157.88 people
rode the N-Judah per day.
*/

