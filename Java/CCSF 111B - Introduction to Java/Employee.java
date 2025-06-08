/* Craig Persiko  -  Employee.java
   Defines a class to store data on an
   Employee, which is a kind of Person.
*/

import java.util.Scanner;

class Employee extends Person
{
  protected String SSN; // Social Security Number needed for employment taxes

  // default constructor:
  // use inherited constructor to assign an id and store null for names
  // then store null for SSN too
  public Employee()
  {
    super();  // optional: will automatically be called anyway
    SSN = null;
  }

  // constructor:
  // use inherited constructor to assign an id and store names
  // then store SSN
  public Employee(String first, String last, String socSecNum)
  {
    // call Person constructor with parameters:
    super(first, last);

    // set Employee instance variable too
    SSN = socSecNum;
  }

  // output function: fully overrides Person's output method
  // ( Notice we don't call super.output() )
  // to output all data on one line
  @Override  // annotation so compiler verifies we're overriding correctly
  public void output()
  {
    System.out.println(id + "\t\t" + firstName + "\t\t" + lastName
                          + "\t\t" + SSN);
  }

  // input function: calls inherited input function, then inputs SSN
  @Override
  public void input()
  {
    Scanner s = new Scanner(System.in);

    // Call Person's input function to input name:
    super.input();

    // now input SSN and country:
    System.out.print("Please enter Social Security Number: ");
    SSN = s.nextLine();
  }
}