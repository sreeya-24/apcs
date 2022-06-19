
/**
 * Write a description of class Box3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Box3 extends Rectangle3
{
    // instance variables - replace the example below with your own
    private int height;

    /**
     * Constructor for objects of class Box3
     */
    public Box3(int l, int w, int h)
    {
        // initialise instance variables
        super(l,w);
        height = h;
    }

    /**
     * a getter method for height
     */
    public int getHeight()
    {
        // put your code here
        return height;
    }
    
    public String toString()
    {
        return "Box - " + getLength() + " X " + getWidth() + " X " + height;
    }
    
    /**
     * equals method
     */
    public boolean equals(Box3 box)
    {
        if ((box.equals(box.getLength(), box.getWidth())) && (box.getHeight() == height)) {
            return true;
        } else {
            return false;
        }
    }
}
