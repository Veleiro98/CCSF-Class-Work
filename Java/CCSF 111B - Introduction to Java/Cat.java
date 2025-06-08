class Cat extends Animal implements Talker
{
    public Cat(String name)
    {
        super(name);
    }

    @Override
    public void speak()
    {
        System.out.println("Meow");
    }
}