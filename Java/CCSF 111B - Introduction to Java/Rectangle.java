/*
 * Written by Matthew Means on 25/11/2024 for CCSF - "Introduction to Java" 111B by Craig Persiko.
 * This is a component of a set of files used for the assignment "Assignment 10:Shape Hierarchy".
 */

public class Rectangle extends Shape
{
    protected double length, height;

    public Rectangle(double length, double height)
    {
        super();
        this.length = length;
        this.height = height;
    }

    @Override
    public double area()
    {
        return height*length;
    }

    @Override
    public double perimeter()
    {
        return height*2 + length*2;
    }
}
