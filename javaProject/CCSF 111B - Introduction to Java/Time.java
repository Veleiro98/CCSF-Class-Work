/*
   Time.java by Craig Persiko orinally, modified to include 
   Code to CS 111B Assignment 8

   This class is used to store a time of day and output it.
   It also stores the current time of day and manipulates it.

   Your job is to write the rest of the code where commented below.
   DO NOT CHANGE ANY OF THE CODE PROVIDED.
   You should add your code below it.
*/

class Time
{
  // instance variables for an object to store a time of day:
  private int hours;
  private int minutes;

  // static Time object to store the current time of day,
  // defaults to midnight:
  private static Time curTime = new Time();

  // Default Constructor
  // initialize time to 00:00 (midnight)
  public Time()
  {
    hours = minutes = 0;
  }

  // Constructor to parse a string hh:mm as the Time
  public Time(String hourColonMinute)
  {
    int colonIdx = hourColonMinute.indexOf(':');
    hours = Integer.parseInt(hourColonMinute.substring(0, colonIdx));
    minutes = Integer.parseInt(hourColonMinute.substring(colonIdx+1));
    normalize();
  }

  // initialize time using parameters for hour and minute
  public Time(int hr, int min)
  {
    hours = hr;
    minutes = min;
    normalize();
  }

  // set current time to parameters
  public static void setCurTime(int hr, int min)
  {
    curTime = new Time(hr, min);
  }

  // set current time from a string in hh:mm format
  public static void setCurTime(String hourColonMinute)
  {
    curTime = new Time(hourColonMinute);
  }

  // return true if this object's time is after the current time
  public boolean isLaterToday()
  {
    return (this.compareTo(curTime) > 0);
  }

  // String representation, using 24-hour time in standard hh:mm format
  // Copied from ThinkJava textbook at:
  // https://books.trinket.io/thinkjava2/chapter11.html#sec139
  public String toString()
  {
    return String.format("%02d:%02d", hours, minutes);
  }

  // Private utility method to ensure that hours is 
  // between 0 and 23 and that minutes is between 0 and 59,
  // making logical adjustments if not.
  private void normalize()
  {
    if (hours >= 24 || minutes >= 60 || minutes < 0 || hours < 0)
    {  // handle extra minutes or hours, or negative minutes or hours
      int allMinutes = hours * 60 + minutes;
      allMinutes %= 1440; // 1440 minutes = 24 hours.  Remove any full days from our time
      if (allMinutes < 0) // if it's before midnight
        allMinutes += 1440;  // add a day to get the time it should be (yesterday)
      hours = allMinutes / 60; // integer division for integer result
      minutes = allMinutes % 60;
    }
  }
  
  // DO NOT CHANGE THE ABOVE CODE
  // WRITE YOUR CODE BELOW TO MAKE THIS CLASS
  // WORK WITH MAIN TO PRODUCE THE OUTPUT SHOWN THERE. 
  // The comments below can help you figure out what to do.
  // You need to write two methods here: 
  // showCurTime and compareTo

  public static void showCurTime()
  {
    System.out.println(curTime.toString());
  }

  public int compareTo(Time t)
  {
    int currentHour = Integer.parseInt(toString().substring(0,2));
    int tHour = Integer.parseInt(t.toString().substring(0,2));
    int currentMinuit = Integer.parseInt(toString().substring(3,5));
    int tMinuit = Integer.parseInt(t.toString().substring(3,5));

    if(currentHour > tHour)
      { 
        return 1;
      }
    else if(currentHour == tHour && currentMinuit > tMinuit)
      { 
        return 1;
      }
    else if(currentHour == tHour && currentMinuit == tMinuit)
      {
        return 0;
      }
    else
      {
        return -1;
      }
  } // end of compareTo

  // static showCurTime() function displays the current time
  // using its .toString() method.

  // standard .compareTo function to compare this Time to another Time,
  // returns 0 if they are equal, 
  // 1 if this time is later than the parameter,
  // -1 if this time is earlier than the parameter
}
