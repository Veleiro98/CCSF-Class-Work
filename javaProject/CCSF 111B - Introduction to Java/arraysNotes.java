import java.util.Arrays

public class arraysNotes
{

    public static void main(String[] args)
    {
        int[] counts = new int[4]; // new is required to declare an array size.
        int[] counts2; // this is null size.
        int[] counts3 = {1,2,3,4}; // you can also initialize it like this.
        counts[0] = 1; // this is how you access the elements, with square brackets.
        int[][] count4; // this is am multidimensional null array declaration.
        // to print the values of an array, you must either use .toString or print every
        // individual element after eachother
        System.out.println(Arrays.toString(counts3)); // this prints the whole array.
        // copying an array doesn't create a new array.
        counts2 = counts3; // if you change either of these they change eachother, because
        // its the array to consider first rather than the variable representing it.
        // you would need to copy every single element of an array to copy it or use this below
        int[] a = Arrays.copyOf(counts3,2); // which copies the array up to the length 2
        int[] b = Arrays.copyOf(counts3, counts3.length); // this copies the whole array
        int[] c = {1, 2, 3, 4, 5};
        for (int i = 0; i < c.length; i++) {
            c[i] *= c[i];
        } // this is called a "traversal" in that it loops through the array, performing an
        //  operation on each element
        search(c, (int) 3);
    }
        public static int search(int[] array, int target) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == target) {
                    return i;
                }
            }
            return -1;  // not found
        } // this acts as a search, going through each element and returning if it's the target
}