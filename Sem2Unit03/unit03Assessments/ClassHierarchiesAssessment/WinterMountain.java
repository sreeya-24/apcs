
/**
 * This is a subclass of Mountain Class.
 *
 * @author Sreeya Gambhirrao
 * @version 03/19/2022
 */
public class WinterMountain extends Mountain
{
    private double temp;
    /**
     * Constructor for objects of class WinterMountain
     */
    public WinterMountain(int l, int w, int numberOfMountains, double temperature)
    {
        super(l,w,numberOfMountains);
        temp = temperature;
       
    }

    /**
     * A get method for the temperature
     * no parameters
     */
    public double getTemperature()
    {
        return temp;        
    }
}
