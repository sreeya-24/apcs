
/**
 * This is a subclass of Terrain class.
 *
 * @author Sreeya Gambhirrao
 * @version 03/19/2022
 */
public class Mountain extends Terrain
{
    public int numOfMountains;

    /**
     * Constructor for objects of class Mountain
     */
    public Mountain(int l, int w, int numberOfMountains)
    {
        // initialise instance variables
        super(l,w);
        numOfMountains = numberOfMountains;
    }

    /**
     * A get method for number of mountains
     * no parameters
     */
    public int getNumOfMountains()
    {
        return numOfMountains;
        
    }
}
