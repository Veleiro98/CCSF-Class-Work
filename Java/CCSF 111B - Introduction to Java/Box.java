// Box.java:
class Box implements Voluminous
{
  double length, width, height;

  public Box(double l, double w, double h)
  {
    length = l;
    width = w;
    height = h;
  }

  public double volume()
  {
    return (length * width * height);
  }
}