/* This file is part of a practice assignment for CCSF 111B - "Introduction to Java". The
 * assignment is for the second assignment named "Names and Ages Program".
 * This was written by Matthew Means on 21/9/24 (d/m/y). The purpose of this assignment is to
 * practice conditional statements and using multiple functions. The prompt is to "write a
 * program which inputs two people's names and ages, and then outputs if one or both people
 * are between 18 and 65 years old." 
 * Because this assignment is being turned in late. I incorporated aspects that are taught
 * later on in the class, such as arrays. I took the liberty to not just mention when somebody
 * is from a different age category, but to mention it. There also is an error check. I
 * could not figure out how to get around the scanner bug without adding "input.nextLine()".
 * That was ruins the flow of the program I feel. If you have an alternative method,
 * then please comment it.
  */

import java.util.Scanner;
  
 public class namesAndAges 
 {
 
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the \"Name and Age\" program.");
        System.out.print("Please enter the first person's name: ");
        String firstPerson = input.nextLine();
        final int firstPersonAge = getAge(firstPerson);
        final boolean[] firstAgeMarker = getAgeMarkers(firstPersonAge);
        input.nextLine(); // scanner bug after getInt()
        System.out.print("Please enter the second person's name:");
        String secondPerson = input.nextLine();
        final int secondPersonAge = getAge(secondPerson);
        final boolean[] secondAgeMarker = getAgeMarkers(secondPersonAge);
        System.out.println(ageInfo(firstPerson,secondPerson,firstAgeMarker,secondAgeMarker));
    } // end of main method
    
    public static int getAge(String name)
    /* giving a print statement with an input error check
    for getting this person's age */
    {   Scanner localInput = new Scanner(System.in);
        char x = 's';
        char y = (name.charAt(name.length() - 1 )); // getting the last 
        // character of their name
        if (y == x)
            {System.out.printf("Please enter %s' age: ",name);}  // for the English
            // possesion differentiation
            else
            {System.out.printf("Please enter %s's age: ", name);}
        int age = localInput.nextInt();
        while ( age < 0 || age == 0) // use of logical OR as demanded in assignment prompt ! 
            {System.out.println("Incorrect input, please try again.");
            age = localInput.nextInt();} // use of the return of a variable as demanded in assignment prompt !     
        return age;
    } // end of getAge method

    public static boolean[] getAgeMarkers(int age) /* used to determine aquire the young,
    middle age, or old boolean markers for this person */
    {   boolean Young;
        boolean Mid;
        boolean Old;
        if(age < 18)  
        {Young = true;}
        else
        {Young = false;}
        if(age >= 18 && age <= 65)
        {Mid = true;}
        else
        {Mid = false;}
        if(age > 65)
        {Old = true;}
        else
        {Old = false;}
        boolean[] array = {Young, Mid, Old};
        return array;
    } // end of compareAge method

    public static String ageInfo(String name1 , String name2 , boolean[] ageMarker1 , boolean[] ageMarker2)
    {   Scanner localInput = new Scanner(System.in);
        String prefix = "";
        String midfix = "";
        String suffix = "";
        boolean runMarker = true;
        for (int i = 0  ; i <= 2; i++ ){
               for ( int j = 0; j<=2 ; j++ ){
                   if( runMarker && i == j && ageMarker1[i] == true && ageMarker2[j] == true){
                        prefix = "Both " + name1 + " and " + name2 + " are "; 
                        //System.out.printf("Both %s and %s are ", name1, name2);
                        if(i == 0 || j == 0){
                            midfix = "less than 18.";}
                        else if(i == 1 || j == 1){
                            midfix = "between 18 and 65.";}
                        else if(i == 2 || j == 2){
                            midfix = "older than 65.";}
                        suffix = "";
                   runMarker = false;
                    } // end of larger if statement
                   if( runMarker == true){
                    midfix = ""; // midfix is only used when both people have the same age range
                        if(ageMarker1[0] == true && i == 0){
                            prefix = name1 + " is less than 18, and ";
                        }
                        if (ageMarker1[1] == true && i == 1){
                            prefix = name1 + " is between the ages of 18 and 65, and ";
                        }
                        if (ageMarker1[2] == true && i == 2){
                            prefix = name1 + " is older than 65, and ";
                        }
                        if(ageMarker2[0] == true && j == 0){
                            suffix = name2 + " is less than 18.";
                        }
                        if(ageMarker2[1] == true && j == 1){
                            suffix = name2 + " is between the ages of 18 and 65";
                        }
                        if(ageMarker2[2] == true && j == 2){
                            suffix = name2 + " is older than 65";
                        }
                   } // end of else statement
                } // end of second for loop

            }// end of first for loop
        //System.out.println(prefix); // scafolding
        //System.out.println(midfix);
        //System.out.println(suffix);
        return prefix+midfix+suffix;
    }
} // end of class

/* sample output 1:
 * Welcome to the "Name and Age" program.
 * Please enter the first person's name: James
 * Please enter James' age: 15
 * 
 * Please enter the second person's name:Charlie
 * Please enter Charlie's age: 67
 * James is less than 18, and Charlie is older than 65
 * 
 * sample output 2:
 * Welcome to the "Name and Age" program.
 * Please enter the first person's name: Jake
 * Please enter Jake's age: -4
 * Incorrect input, please try again.
 * -4
 * Incorrect input, please try again.
 * -3
 * Incorrect input, please try again.
 * 0
 * Incorrect input, please try again.
 * 14
 * 
 * Please enter the second person's name:Charles
 * Please enter Charles' age: 35
 * Jake is less than 18, and Charles is between the ages of 18 and 65
 * 
 * sample output 3:
 * Welcome to the "Name and Age" program.
 * Please enter the first person's name: Donald Trump
 * Please enter Donald Trump's age: 78
 * 
 * Please enter the second person's name:Joe Biden
 * Please enter Joe Biden's age: 81
 * Both Donald Trump and Joe Biden are older than 65
  */