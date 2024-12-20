


public class FullName extends Name
{
    protected String mName;

    public FullName(String first,String middle, String last)
    {
        super(first, last);
        this.mName = middle;
    }

    @Override
    public String toString()
    {
        return super.fName + " " + mName + " " + super.lName;
    }

} // ends Fullname class
