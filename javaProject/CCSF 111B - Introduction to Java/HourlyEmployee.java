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

    public double getExpectedHoursPerWeek()
    {
        return expectedHoursPerWeek;
    }

    public void setExpectedHoursPerWeek(double x)
    {
        expectedHoursPerWeek = x;
    }
}
