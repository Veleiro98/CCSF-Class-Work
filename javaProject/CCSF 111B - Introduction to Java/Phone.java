/* This code is for "Assignment 7: Phone Class" as part of CCSF 111B "Introduction to Java"
 * It was produced 29/10/2024 (d/m/y)
 * The purpose of this is to learn how to create a class with mutators, accessors, a .equals() and .toString()
 */
public class Phone extends Object{

    public String make, model, colour;
    public int capacity;

    public Phone(String make, String model, String colour, int capacity)
    {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.capacity = capacity;
    } // end of Phone object instantialization

    // below are the accessors
    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public String getColor()
    {
        return colour;
    }

    public int getCapacity()
    {
        return capacity;
    }

    // below is the only mutator
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public String toString()
    {
        return ("make: " + make + "\nmodel: " + model
        + "\ncolour: " + colour + "\ncapacity: " + capacity);
    }

    @Override
    public boolean equals(Object obj) // in order to override it must be
    // an Object parameter and then cast to the Phone class to check
    // if it is actually equal.
    {
        Phone other = (Phone)obj;
        if(other.make.equals(make) &&
        other.model.equals(model) &&
        other.colour.equals(colour) &&
        other.capacity == capacity)
        {
            return true;
        }
        else
        {
            return false;
        }
    } // end of equals method
} // end of phone class

/* Output in designated main file:
The brightest color here is: Phantom Violet
This phone:
make: Samsung
model: Galaxy S21 5G
colour: Phantom Violet
capacity: 256
has lower capacity than the:
make: Apple
model: iPhone 13 Pro
colour: Graphite
capacity: 512
We have two of these:
make: Apple
model: iPhone 13 Pro
colour: Graphite
capacity: 512
After upgrade they aren't equal, because this phone:
make: Apple
model: iPhone 13 Pro
colour: Graphite
capacity: 1000
has more capacity than:
make: Apple
model: iPhone 13 Pro
colour: Graphite
capacity: 512
 */