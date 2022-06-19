
/**
 * This class implements the Product and is also a Comparable interface.
 *
 * @author Sreeya Gamhirrao
 * @version 04/18/2022
 */
public class Tool implements Product, Comparable<Tool>
{
    // instance variables - replace the example below with your own
    private String name;
    private double cost;

    /**
     * Constructor for objects of class Tool
     */
    public Tool(String name, double cost)
    {
        // initialise instance variables
        this.name = name;
        this.cost = cost;
    }

    public String getName()
    {
        return name;
    }
    
    public double getCost()
    {
        return cost;
    }
    
    public int compareTo(Tool t)
    {
        if(cost > t.cost)
        {
            return 1;
        } else if(cost == t.cost)
        {
            return 0;
        } else
        {
            return -1;
        }
    }
}
