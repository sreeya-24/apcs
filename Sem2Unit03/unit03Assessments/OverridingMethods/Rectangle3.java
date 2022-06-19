
/**
 * Write a description of class Rectangle3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle3
{
    // instance variables - replace the example below with your own
    private int length;
    private int width;

    /**
     * Constructor for objects of class Rectangle3
     */
    public Rectangle3(int l, int w)
    {
        // initialise instance variables
        length = l;
        width = w;
    }

    /**
     * a getter method for length
     * no parameters
     */
    public int getLength()
    {
        // put your code here
        return length;
    }
    
    /**
     * a getter method for length
     * no parameters
     */
    public int getWidth()
    {
        return width;
    }
    
    public String toString()
    {
        return "Rectangle - " + length + " X " + width;
    }
    
    /**
     * equals method to comare boxes and cubes
     */
    public boolean equals(int length, int width)
    {
        if ((length == length) && (width == width)) {
            return true;
        } else {
            return false;
        }
    }
}
