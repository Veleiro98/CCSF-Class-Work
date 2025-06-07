/* This program was written by Matthew Means on 4/26/2025 as part of a homework assignment for Data
Structures and Algorithms from CCSF. The assignment is named "Programming Lab 3". The purpose of this 
program is to modify the isPalindrome method to work in main via the implementation of our OurStack ADT. 
The purpose of this is to exercise the implementation of stack. This code was written in Visual 
Studios, It uses OpenJDK runtime environment
21.0.6 of Java on Ubuntu(Linux).
 * 
 */
import java.util.Scanner;
public class PalindromeChecker 
{
   /** Tests whether a string is a palidrome, ignoring punctuation, spaces, and case. 
       @param aString  a string */
   public static boolean isPalindrome(String aString)
   {  
      int length = aString.length();
      OurStack<Character> myStack = new OurStack<Character>();
      String myComparisonString = "";
      for(int i = 0; i < length; i++)
      {
         if(isPunctuation(aString.charAt(i)) == false && Character.isWhitespace(aString.charAt(i)) == false)
         {
            myStack.push(Character.toLowerCase(aString.charAt(i)));
            myComparisonString = myComparisonString + Character.toLowerCase(aString.charAt(i));
            
         }
      }
      char myChar;
      length = myComparisonString.length();
      for(int j = 0; j < length; j++)
      {
         myChar = myStack.pop();
         if(myChar == myComparisonString.charAt(j))
         {
            System.out.println(myChar + " " + myComparisonString.charAt(j));
         }
         else
         {
            System.out.println(myChar + " " + myComparisonString.charAt(j));
            return false;
         }
      }
      return true;
   } // end isPalindrome
   

   /** Tests whether a character is a punctuation mark.  
       If a string contains a punctuation mark character, the
       character should be ignored when trying to determine whether the
       string is a palindrome
       @param aCharacter.   a single character */
   public static boolean isPunctuation(char aCharacter)
   {
    return (aCharacter == '.') || (aCharacter == ',') || (aCharacter == '?') ||
           (aCharacter == '!') || (aCharacter == '"');
   } // end isPunctuation
   
   // this is the main function that uses the method isPalindrome that we created earlier
   // to check and see if a stack popping a string backwards matches the original string.
   // it takes advantage of the fact that a stack is LIFO for our comparator.
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      //Describe the program and how it works
      System.out.println("This program determines whether a string");
      System.out.println("is a palindrome. A palindrome is spelled");
      System.out.println("the same from left to right as it is from right to left,");
      System.out.println("if we ignore punctuation, spaces, and case.");

      System.out.print("Enter a string that you want to check (or enter ! to exit): ");
      String aString = keyboard.nextLine();
      
      while (!aString.equals("!"))
      {
         if (isPalindrome(aString))
            System.out.println(aString + " is a palindrome!");
         else
            System.out.println(aString + " is not a palindrome!");
            
         System.out.print("Enter a string that you want to check (or enter ! to exit): ");
         aString = keyboard.nextLine();
      } // end while
      
      System.out.println("Done!");
   } // end main
} // end PalindromeChecker

/*
 * Sample output:
 * This program determines whether a string
is a palindrome. A palindrome is spelled
the same from left to right as it is from right to left,
if we ignore punctuation, spaces, and case.
Enter a string that you want to check (or enter ! to exit): CiVIc
c c
i i
v v
i i
c c
CiVIc is a palindrome!
Enter a string that you want to check (or enter ! to exit): rAdaR
r r
a a
d d
a a
r r
rAdaR is a palindrome!
Enter a string that you want to check (or enter ! to exit): m o m
m m
o o
m m
m o m is a palindrome!
Enter a string that you want to check (or enter ! to exit): Matthew 
w m
Matthew is not a palindrome!
Enter a string that you want to check (or enter ! to exit):
 */