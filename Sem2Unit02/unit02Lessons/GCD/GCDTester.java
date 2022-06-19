
/**
 * Write a description of class GCD here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

class GCD
{
    GCD()
    {   
    }
    
    public int GCDCalc(int x, int y)
    {
        if(x<y)
        {
            return GCDCalc(y,x);
        } else if(y == 00)
        {
            return x;
        } else 
        {
            return GCDCalc(y,x%y);
        }
    }
    
}
public class GCDTester
{
    public static void main(String[] args)
    {
    GCD gcdObject = new GCD();
    
    int gcdVal = gcdObject.GCDCalc(200,70);
    System.out.println("GCD: " + gcdVal);
    }
}
