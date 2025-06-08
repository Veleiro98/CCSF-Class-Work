/*
 * Written by Matthew Means for CCSF's 111B "Introduction to Java"
 * course for exercise 16. It's part of a package of classes to demonstrate
 * inheritance and interfaces through the analogy of different vehicles.
 * written on 2/12/2024 (d/m/y)
 */

public class Motorboat extends Vehicle implements LimitedRange
{

    private int range;

    public Motorboat(String make, String model, int range)
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
            System.out.println("Whooosh!");
            range = range - distance;
            return true;
        }
        else
        {
            return false;
        }
    }
}
