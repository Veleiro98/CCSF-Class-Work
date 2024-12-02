/*
 * 
 * 
 */

class Dog extends ANimal implements Talker
{
    public Dog()
    {
        super("Fido");
    }

    public Dog(String name)
    {
        super(name);
    }

    @Overridepublic void speak()
    {
        System.out.print("Woof")
    }
} // end of class 