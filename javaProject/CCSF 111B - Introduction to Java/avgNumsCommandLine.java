/* written by Matthew Means beginning of 7/10/2024 (d/m/y)
 * The purpose of this program is to take an array of input numbers as command line arguements and to
 * output the average value for all of them.
 * 
 */

 public class avgNumsCommandLine {

    public static void main(String[] args){ // simply the main statement that handles the print statements
        double[] input = new double[args.length];
        for(int i = 0; i < args.length; i++){
            input[i] = Double.parseDouble(args[i]);
        } // end of for loop for converting string arguement to float values
        if(args == null || args.length < 1)
        {  // if nothing on command line
          System.out.println("usage: java avgNumsCommandLine 5 4 2 -4 8%nTo return average values from the array: 3");
          return;  // exit the program
        } // end of if statement
        System.out.println("You entered: ");
        for(int i = 0; i < input.length-1; i++)
        {
            System.out.print(input[i]);
            System.out.print(" , ");
        } // end of for loop
        System.out.print(input[input.length-1]); // this last one is out of the loop to not add an extra comma
        System.out.printf("%nThe average value is %.2f truncated to the hundredths place", getAverage(input));
    } // end of main
    
    private static double getAverage(double[] input){ // inputs the converted arguements from console and
        // returns the average value as a double.
        double average = 0;
        for(int i = 0; i <= input.length-1; i++){
            average += input[i];
        } // end of for loop
         average = average / input.length;
        return average;
    } // end of getAverage method
} // end of class

/*
 * Example output 1:
 * You entered: 
 * 25.0 , 91.0 , 54.0 , 104.0
 * The average value is 68.50 truncated to the hundredths place
 * 
 * Example output 2:
 * You entered: 
 * 85.54 , 91.6 , 95.71 , 78.9
 * The average value is 87.94 truncated to the hundredths place
*/