abstract class Animal
{
    private String name;
    
    // constructor
    public Animal(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }
}
    
/* sample output:
 * What do you have? Enter 'd' for dog, 'c' for cat, 'f' for fish, or 'r' for radio: d
What is your dog's name?
Do you want to enter another? Type y or n: y
What do you have? Enter 'd' for dog, 'c' for cat, 'f' for fish, or 'r' for radio: d
What is your dog's name? taxEvader
Do you want to enter another? Type y or n: y
What do you have? Enter 'd' for dog, 'c' for cat, 'f' for fish, or 'r' for radio: c
What is your cat's name? Meowza Minneli
Do you want to enter another? Type y or n: y
What do you have? Enter 'd' for dog, 'c' for cat, 'f' for fish, or 'r' for radio: f
What is your fish's name? Sushi
Do you want to enter another? Type y or n: y
What do you have? Enter 'd' for dog, 'c' for cat, 'f' for fish, or 'r' for radio: r
Do you want to enter another? Type y or n: n
Hello Fido
Hello taxEvader
Hello Meowza Minneli
Hello Sushi
Woof
Woof
Meow

blahblahblah

 */