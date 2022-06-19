
/**
 * This program calculates the trajectory of a projectile based on
 * launch angles and launch speed.
 *
 * @author Sreeya Gambhirrao
 * @version 1/23/2022
 */
public class Catapult
{
    //private instance variables 
    private double velocity;
    private double degrees;
    private double distance;

    /**
     * Constructor for objects of class Catapult
     */
    public Catapult(double velocity, double degrees)
    {
        // initialise instance variables
        this.velocity = velocity;
        this.degrees = degrees;
    }

    /**
     * This method calculates distance using velocity and degrees(no parameters)
     */
    public void calcDistance()
    {
        // put your code here
        distance = (Math.pow(velocity, 2) * Math.sin(2 * Math.toRadians(degrees))/9.8);
    }
    
    /**
     * getter method for velocity
     */
    public double getVelocity()
    {
        return this.velocity;
    }
    
    /**
     * getter method for degrees
     */
    public double getDegrees()
    {
        return this.degrees;
    }
    
    /**
     * getter method for distance calculated
     */
    public double getDistance()
    {
        return distance;
    }
}
