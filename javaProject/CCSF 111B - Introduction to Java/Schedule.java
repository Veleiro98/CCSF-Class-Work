/*
 * Written by Matthew Means 20/11/2024 (D/M/Y) for CCSF 111B "Introduction to Java" for assigment
 * 9: timeScheduleSorting whereas the objective is to create a schedule class using the time class to
 * store an ArrayList of time objects and to sort them.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Schedule extends Time {

    private ArrayList<Time> list;

    public Schedule()
    {   Scanner input = new Scanner(System.in);
        String endMarker = " ";
        System.out.println("Please enter the time for each meeting in hh:mm format, on a\r\n" +
        "separate line, and type 'end' on the final line to finish.");
        list = new ArrayList<>();
        while(!endMarker.equals("end"))
        {
            String x = input.nextLine().toLowerCase();
            if(!x.equals("end"))
            {
                list.add(new Time(x));
            }
            else
            {
                endMarker = "end";
            }
        }
    } // end of constructor

    @Override
    public String toString()
    {
        String returnString = "";
        for(int i = 0 ; i < list.size() ; i++)
        {
            returnString += list.get(i).toString() + "\n";
        }
        return returnString;
    } // end of toString method


    public void sort()
    {
      int idxSmall, startIndex;
      // for each element that has another one after it:
      for(startIndex = 0; startIndex < list.size() - 1; startIndex++)
      {
        // search for the smallest element starting at element startIndex:
        idxSmall = indexOfSmallest(startIndex);
        // idxSmall is the index of the smallest element
        // from indexes startIndex and later. So it should
        // be at position startIndex.
        if(idxSmall > startIndex) // make sure we didn't get -1 above.
          swapValues(idxSmall, startIndex);
      }
    }

    private int indexOfSmallest(int startIndex)
    {
        if(list == null || list.size() <= startIndex)
        return -1;

        int indexOfMin = startIndex; // initialize min so we can compare and find smallest value.

        for (int i = startIndex + 1; i < list.size(); i++)
        {
        if(list.get(i).compareTo(list.get(indexOfMin)) == -1)  // if we find a smaller number than the min
            indexOfMin = i;         // then this is the new min.
        }
    return indexOfMin;
    }
    
    private void swapValues(int p1, int p2)
    {
        Time temp = list.get(p1);
        list.set(p1, list.get(p2)); 
        // above is like nums[p1] = nums[p2]
        list.set(p2, temp);
    }
} // end of Schedule class

/*
 * Example of main.java run 1:
 * Please enter the time for each meeting in hh:mm format, on a
 * separate line, and type 'end' on the final line to finish.
 * 9:30
 * 5:45
 * 6:25
 * 2:30
 * 14:35
 * end
 * Here is your schedule, sorted in order:
 * 02:30
 * 05:45
 * 06:25
 * 09:30
 * 14:35
 * 
 * Example 2:
 * Please enter the time for each meeting in hh:mm format, on a
 * separate line, and type 'end' on the final line to finish.
 * 9:30
 * 15:25
 * 8:45
 * 16:45
 * end
 * Here is your schedule, sorted in order:
 * 08:45
 * 09:30
 * 15:25
 * 16:45
 */