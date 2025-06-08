/* Written by Matthew Means 12/11/2024 (d/my/y) for the exercise for chapter 14 from CCSF 111B -
 * "Introduction to Java"
 * The purpose of this class is to exhibit inheretance and class heirarchy
 * 
 */

import java.util.Scanner;

class HourlyEmployee extends Employee
{
    protected double hourlyRate;
    protected double expectedHoursPerWeek;
    
    public HourlyEmployee()
    {
        super();
        hourlyRate = 0;
        expectedHoursPerWeek = 0;
    }

    public HourlyEmployee(String firstname, String lastname, String socSecNum,
     double hourlyRate, double expectedHoursPerWeek)
    {
        super(firstname,lastname,socSecNum);
        this.hourlyRate = hourlyRate;
        this.expectedHoursPerWeek = expectedHoursPerWeek;
    }

    @Override  // annotation so compiler verifies we're overriding correctly
    public void output()
    {
        super.output();
        System.out.print("\t\t" + hourlyRate + "\t\t"+ expectedHoursPerWeek);
    }

    @Override
    public void input()
    {
        Scanner in = new Scanner(System.in);
        super.input();
        System.out.println("Please enter the hourly rate of the employee");
        hourlyRate = in.nextDouble();
        System.out.println("Please enter the expected amount of hours per week worked");
        expectedHoursPerWeek = in.nextDouble();
    }

    public double weeksPay()
    {
        return (expectedHoursPerWeek * hourlyRate);
    }

    public double getHoursPerWeek()
    {
        return expectedHoursPerWeek;
    }

    public void setHoursPerWeek(double x)
    {
        expectedHoursPerWeek = x;
    }
}

/* sample main output:
 * This program allows you to enter info about people.
Is person #1 an employee? (Enter 'y' for Yes, 'n' for No, or 'q' to stop entering employees) y
Is this person on salary, hourly, or neither? (Enter 's', 'h', or 'n') h
Please enter first name: Bilie
Please enter last name: Eilish
Please enter Social Security Number: 111-11-1111
Please enter the hourly rate of the employee
18.5
Please enter the expected amount of hours per week worked
35
Good morning, Bilie Eilish
Your weekly pay is $647.5
If you worked 40 hours per week, your weekly pay would be $740.0
Is person #2 an employee? (Enter 'y' for Yes, 'n' for No, or 'q' to stop entering employees) y
Is this person on salary, hourly, or neither? (Enter 's', 'h', or 'n') s
Please enter first name: Chappell
Please enter last name: Roan
Please enter Social Security Number: 222-22-2222
Please enter salary: 65000
Good morning, Chappell Roan
Your salary is $5416.666666666667 per month.
Is person #3 an employee? (Enter 'y' for Yes, 'n' for No, or 'q' to stop entering employees) n
Please enter first name: Olivia
Please enter last name: Rodrigo 
Good morning, Olivia Rodrigo
Is person #4 an employee? (Enter 'y' for Yes, 'n' for No, or 'q' to stop entering employees) n
Please enter first name: Charli
Please enter last name: XCX
Good morning, Charli XCX
Is person #5 an employee? (Enter 'y' for Yes, 'n' for No, or 'q' to stop entering employees) q
Here are all the people:

1               Bilie           Eilish          111-11-1111
                18.5            35.0
2               Chappell                Roan            222-22-2222

3               Olivia          Rodrigo

4               Charli          XCX

 */