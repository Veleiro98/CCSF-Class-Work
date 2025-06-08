import java.util.Scanner; // all imports are prior to the main class declaration

public class FirstScanner //FirstScanner is also the file name
{
	public static void main(String[] args) { // this is almost always the same
		String message;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your first input using the \"scanner\" ");
		message = input.nextLine();
		System.out.print("Your input was \"" + message +"\"\n");
	}
}
