import java.util.Scanner; // all imports are prior to the main class declaration

public class gradeAverage // GradeAverage is also the file name (note to self)
{
	public static void main(String[] args) {
	    float gradeAverage;
	    int firstGrade;
	    int secondGrade;
	    int thirdGrade;
	    Scanner input = new Scanner(System.in); 
	    
	    System.out.println("Please enter 3 integer grades, separated by "
	    + "spaces\n");
		firstGrade = input.nextInt();
		secondGrade = input.nextInt();
		thirdGrade = input.nextInt();
        gradeAverage = (float)( firstGrade + secondGrade + thirdGrade)/3;
		System.out.printf("Their average is: %.1f", gradeAverage);
	}
}
/* Example output resulted:
Please enter 3 integer grades, separated by spaces

83 92 76
Their average is: 83.7

...Program finished with exit code 0
Press ENTER to exit console.
*/
