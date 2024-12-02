/*
 * Written by Matthew Means for CCSF's 111B "Introduction to Java"
 * course for exercise 16. It's part of a package of classes to demonstrate
 * inheritance and interfaces through the analogy of different vehicles.
 * written on 2/12/2024 (d/m/y)
 */

public class ElectricCar extends Vehicle implements LimitedRange
{
    private int range;

    public ElectricCar(String make, String model, int range)
    {
        super(make,model);
        this.range = range;
    }
    
    @Override
    public int getCurrentRange()
    {
        return range;
    }
    
    @Override
    public boolean travel(int distance)
    {
        if(range >= distance)
        {   
            System.out.println("Zooom!");
            range = range - distance;
            return true;
        }
        else
        {
            return false;
        }
    }
}

/*
 * Sample output from main:
 * Going 20 miles: Zooom!
I can go 242 miles farther.
Going 40 miles: Zooom!
I can go 202 miles farther.

Going 20 miles: Whooosh!
I can go 25 miles farther.
Going 40 miles: Can't make it.

Going 20 miles: Weeeee!
Going 40 miles: Weeeee!

 */