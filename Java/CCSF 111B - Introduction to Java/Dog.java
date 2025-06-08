class Dog extends Animal implements Talker
{
    public Dog()
    {
        super("Fido");
    }

    public Dog(String name)
    {
        super(name);
    }

    @Override
    public void speak()
    {
        System.out.print("Woof");
    }
} // end of class 