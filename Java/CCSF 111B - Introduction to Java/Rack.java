/* Written by Matthew  Means on 30/10/2024 (d/m/y)
 * The purpose of this code is to create a class called Rack to store an ArrayList of Tiles,
 * and to sort them using the Selection Sort algorith like the
 * SortingArrayList example, but using the Tile object's .compareTomethod. It also returns
 * them via .toString().
 */
import java.util.ArrayList;

public class Rack extends Object
{
    private ArrayList<Tile> tiles;

    public Rack()
    {
        tiles = new ArrayList<>();
    }

    public void addTile(Tile t)
    {
        tiles.add(t);
    }
    public int size()
    {
        return tiles.size();
    }

    // below are my contributed methods
    @Override
    public String toString()
    {
        String returnStatement = "Letters \t values\n";
        for(int i = 0; i < tiles.size(); i++)
        {
            returnStatement +=  Character.toString(tiles.get(i).getLetter()) + "\t\t" 
            + tiles.get(i).getValue() + "\n";
        }
        return returnStatement;
    }

    public void sortHighToLow()
    {
        int idxLarge, startIndex;
        for(startIndex = 0; startIndex < tiles.size() - 1; startIndex++)
        {
            idxLarge = indexOfLargest(startIndex);
            if(idxLarge > startIndex)
            {
                swapValues(idxLarge, startIndex);
            } // end of if
        } // end of for
    } // end of sortHighToLow

    public int indexOfLargest(int startIndex)
    {
        int indexOfMax = startIndex; // initialize min so we can compare and find smallest value.
        if(tiles == null || tiles.size() <= startIndex) // if empty tile or index too large returns a -1 for error
        return -1;

        for (int i = startIndex + 1; i < tiles.size(); i++)
        {
        if(tiles.get(i).getValue() > tiles.get(indexOfMax).getValue())  // if we find a bigger number than the max
            indexOfMax = i;         // then this is the new max.
        }

        return indexOfMax;
    } // end of indexOfLargest

    // these are not called in main, but are used for reference in design
    public void sortLowToHigh()
    {
      int idxSmall;
      int startIndex;
      // for each element that has another one after it:
      for(startIndex = 0; startIndex < tiles.size() - 1; startIndex++) // start index cannot be last index for -1
      {
        // search for the smallest element starting at element startIndex:
        idxSmall = indexOfSmallest(startIndex);
        // idxSmall is the index of the smallest element
        // from indexes startIndex and later. So it should
        // be at position startIndex.
        if(idxSmall > startIndex) // make sure we didn't get -1 above.
          swapValues(idxSmall, startIndex);
      }
    } // end of sortLowToHigh

    private int indexOfSmallest(int startIndex)
    {
        if(tiles == null || tiles.size() <= startIndex)
        return -1;

        int indexOfMin = startIndex; // initialize min so we can compare and find smallest value.

        for (int i = startIndex + 1; i < tiles.size(); i++)
        {
            if(tiles.get(i).getValue() < tiles.get(startIndex).getValue())  // if we find a smaller number than the min
                {
                    indexOfMin = i;         // then this is the new min.
                }
        } // end of indexOfSmallest
        return indexOfMin;
    }

    public void help()
    {
        System.out.println("Tiles class objects are available for manipulation and creation within the arrayList via " +
        " .indexOfSmallest(int startIndex),\n indexOfLargest(int startIndex), sortLowToHigh(), sortHighToLow(), " +
        "swapValues(int p1, int p2), and addTile(Tile t).");
    }
    // Exchange nums[p1] and nums[p2].  Because Integers are immutable,
    // we must modify the ArrayList to make the changes stick.
    private void swapValues(int p1, int p2)
    {
        Tile temp = tiles.get(p1);
        tiles.set(p1, tiles.get(p2)); 
        // above is like nums[p1] = nums[p2]
        tiles.set(p2, temp);
    }
} // end of Rack class

/*
 * Output from main:
 * Craig's rack of tiles, in order from most valuable to least:
 * Letters          values
 * Z               10
 * H               4
 * Y               4
 * L               1
 * O               1
 * E               1
 * L               1
 * 
 * Betto's rack of tiles, in order from most valuable to least:
 * Letters          values
 * W               4
 * D               2
 * S               1
 * A               1
 * E               1
 * T               1
 * N               1
 */