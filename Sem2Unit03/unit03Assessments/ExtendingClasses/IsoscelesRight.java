
/**
 * This program inherits properties and methods from the Triangle class.
 *
 * @author Sreeya Gambhirrao
 * @version 3/06/2022
 */
public class IsoscelesRight extends Triangle
{

    /**
     * Constructor for objects of class IsoscelesRight
     */
    public IsoscelesRight(double side)
    {
        super(side, side, Math.sqrt(2)*side);
    }

}
