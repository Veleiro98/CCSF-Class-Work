/* Assignment 4: Analyse Phrase from CCSF 111B - Introduction to Java
 * written by Matthew means, 6/10/24 (d/m/y)
 * 
 */

import java.util.Scanner;

public class analysePhrase
{
    public static void main(String[] args)
    {
        String phrase;
        int numWords;

        phrase = inputPhrase();

        numWords = analyzePhrase(phrase);

        System.out.println("Your phrase has " + numWords + " words in it.");
        System.out.println();
    }

  /**
    inputPhrase method
    Ask the user to input a phrase, and make sure it is at least 5 characters long.
    (Use a loop to make the user input a new phrase if it is too short.)
    @return the phrase
  */

    public static String inputPhrase()
    {   Scanner localInput = new Scanner(System.in);
        String outputString = "";
        System.out.print("Please input a phrase, and make sure that it is at least 5 characters long: ");
        outputString = localInput.nextLine();
        boolean i = true;
        while(i)
        {
            if(outputString.length() < 5)
            {
                System.out.print("Invalid entry, please try again and make sure its long enough: ");
                outputString = localInput.nextLine();
            }
            else
            {
                i = false;
            }
        }

        return outputString;
    }

  /**
     analyzePhrase method
     Count the number of words in a given string, and determine its longest word.
     Assume the string is well formed and doesn't have leading 
     or trailing spaces, or multiple spaces in a row.
     Return the number of words.
     Output the longest word on the screen (console).
     @param str string to analyze
     @return number of words in str
  */

    public static int analyzePhrase(final String phrase)
    {
        char space = ' ';
        int lastSpace = 0; // index of location of last detected space
        String word = "";
        String longestWord = "";
        int wordCount = 0;
        for(int i = 0; i < phrase.length(); i++)
        {
            if(phrase.charAt(i) == space)
            {   
                word = phrase.substring(lastSpace,i);
                wordCount++;
                lastSpace = i;
                if(word.length() >= longestWord.length())
                {
                    longestWord = word;
                }
            }
        }
        wordCount++;
        if(phrase.charAt(phrase.length()-1) == '.')
        {
            word = phrase.substring(lastSpace, phrase.length()-1);
        }
        else{
            word = phrase.substring(lastSpace, phrase.length());
        }
        if(word.length() >= longestWord.length())
        {
            longestWord = word;
        }
        else{}
        System.out.println(longestWord + " is the longest word in the phrase.");
        return wordCount;
    }
/* Hints:
You will get 5 points extra credit if you can do this without using the "split" method
or any other built-in functions to separate the words for you. The way I wrote my
extra-credit solution is described below:
To count words and determine their lengths, I recommend you use a for-loop to go 
through each character one at a time, using .charAt and then when you see a 
space ' ' count the word and set a variable to remember which character number 
that was, so you can calculate how long each word is. Use a variable for the 
longest word seen so far, and compare each word as you see it, to determine if 
it is longer than the longest word seen so far. If so, update that to the 
longest word seen so far. Don't forget about the final word, which doesn't 
end with a space.
*/

}

/* Sample Output:
 * 
 * Please input a phrase, and make sure that it is at least 5 characters long: hi 
 * Invalid entry, please try again and make sure its long enough: hey
 * Invalid entry, please try again and make sure its long enough: One bird in the hand is greater than two in the bush.
 * greater is the longest word in the phrase.
 * Your phrase has 12 words in it.
 * 
 * Sample Output 2:
 * Please input a phrase, and make sure that it is at least 5 characters long: She sells seashells by the seashore.
 *  seashells is the longest word in the phrase.
 * Your phrase has 6 words in it.
 */
