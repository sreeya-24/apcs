
/**
 * This is parent class for all triangle. It has all of the mthods for each side of a triangle.
 *
 * @author Sreeya Gambhirrao
 * @version 3/06/2022
 */
public class Triangle
{
    // instance variables - replace the example below with your own
    private double sideA;
    private double sideB;
    private double sideC;

    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(double A, double B, double C)
    {
        sideA = A;
        sideB = B;
        sideC = C;
    }

    /**
     * Get methods for triangle class
     */
    public double getSideA() {
        return sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
}
