
/**
 * This is a subclass of Terrain class.
 *
 * @author Sreeya Gambhirrao
 * @version 03/19/2022
 */
public class Forest extends Terrain
{
    private int numOfTrees;
    
    /**
     * Constructor for objects of class Forest
     */
    public Forest(int l, int w, int numberOfTrees)
    {
        super(l,w);
        numOfTrees = numberOfTrees;
    }

    /**
     * A get method for number of trees
     * no parameters
     */
    public int getNumOfTrees()
    {
       return numOfTrees;
    }
}
