/*
 * Written by Matthew Means on 25/11/2024 for CCSF - "Introduction to Java" 111B by Craig Persiko.
 * This is a component of a set of files used for the assignment "Assignment 10:Shape Hierarchy".
 */
public class Square extends Rectangle
 {
    protected double side;

    public Square(double side)
    {
        super(side,side);
    }

}

/* Sample output from main:
 * 
This program examines the ratio of area to perimeter
for a few different shapes.
(The larger the ratio, the greater the efficiency of space contained)
Shape #1 is a 10 unit radius Circle with ratio 5.0
Shape #2 is a 15x25 Rectangle with ratio 4.6875
Shape #3 is a 20 unit Square with ratio 5.0
Shape #4 is a 2 unit radius Circle with ratio 1.0
 */