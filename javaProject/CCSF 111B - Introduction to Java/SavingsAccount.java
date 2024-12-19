/*
 * Written by Matthew Means for CCSF - "Introduction to Java" 111B on 18/12/2024(d/m/y).
 * The purpose of this assignment is to work together with three other files to incorporate it to behave
 * in a way already predefined through the main class. 
 */

public class SavingsAccount extends BankAccount
{
    static private double rate;

    public SavingsAccount(int amount, String owner)
    {
        super(amount, owner);
    }

    public void compoundInterest() // it wasnt clear what is the time span we are compounding on 
    // so I made the assumption that we are compounding for a year and the rate is 2.5% accurued on an
    // annual rate.
    {
        deposit(balance*rate);
    }

    public static void setRate(double r)
    {
        rate = r;
    }

    @Override
    public String toString()
    {
        return super.toString();// + ".\nThe rate of interest is " + rate + "% each year.";
    }

} // end of SavingsAccount class

/*
 * Output from main:
After accruing interest, here are accounts 1 and 2:
Elvis has $510.0 in account number 1
Madonna has $512.5 in account number 2
And here's account 3:
Craig has $102.5 in account number 3
And account 3 after depositing $10:
Craig has $112.5 in account number 3
 */