/*
 * Written by Matthew Means for CCSF's 111B "Introduction to Java"
 * course for exercise 16. It's part of a package of classes to demonstrate
 * inheritance and interfaces through the analogy of different vehicles.
 * written on 2/12/2024 (d/m/y)
 */

public class Sailboat extends Vehicle {

    public Sailboat(String make, String model)
    {
        super(make,model);
    }
    
    @Override
    public boolean travel(int distance)
    {
        System.out.println("Weeeee!");
        return true;
    }
}
