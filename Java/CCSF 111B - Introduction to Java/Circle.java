/*
 * Written by Matthew Means on 25/11/2024 for CCSF - "Introduction to Java" 111B by Craig Persiko.
 * This is a component of a set of files used for the assignment "Assignment 10:Shape Hierarchy".
 */

public class Circle extends Shape
{   protected int radius;
    protected double pie = Math.PI;
    public Circle(int radius)
    {
        super();
        this.radius = radius;   
    }

    @Override
    public double area()
    {
        return radius*radius*pie;
    }

    @Override
    public double perimeter()
    {
        return 2*pie*radius;
    }
}
