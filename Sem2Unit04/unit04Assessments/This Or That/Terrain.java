
/**
 * This program displays use of the keyword this.
 *
 * @author Sreeya Gambhirrao
 * @version 04/16/2022
 */
public class Terrain
{
    // instance variables 
    private int length;
    private int width;

    /**
     * Constructor for objects of class terrain
     */
    public Terrain(int length, int width)
    {
        // initialise instance variables
        this.length = length;
        this.width = width;
    }


    public String terrainSize()
    {
        
        return "Land has dimensions " + length + " X " + width;
    }
}
