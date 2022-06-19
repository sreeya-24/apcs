
/**
 * This is a parent class, Vehicle.
 *
 * @author Sreeya Gambhirrao
 * @version 04/18/2022
 */
public class Vehicle implements Product
{
    // instance variables - replace the example below with your own
    private String name;
    private double cost;

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(String name, double cost)
    {
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
}
