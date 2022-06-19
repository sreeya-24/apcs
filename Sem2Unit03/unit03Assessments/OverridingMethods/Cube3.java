
/**
 * Write a description of class Cube3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cube3 extends Box3
{
    /**
     * Constructor for objects of class Cube3
     */
    public Cube3(int l, int w, int h)
    {
        // initialise instance variables
        super(l,w,h);
    }
   
    public String toString()
    {
        // put your code here
        return "Cube - " + getLength() + " X " + getWidth() + " X " + getHeight();
    }
}
