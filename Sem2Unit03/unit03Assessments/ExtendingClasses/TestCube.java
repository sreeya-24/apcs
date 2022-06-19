
/**
 * This program inherits properties and methods from the Rectangle class and prints out the dimensions.
 *
 * @author Sreeya Gambhirrao
 * @version 3/06/2022
 */
public class TestCube
{
    public static void main(String[] args)
    {
        Cube cube = new Cube(4,4,4);
        
        System.out.println("Cube's Dimensions: " + cube.getLength() + " X " + cube.getWidth() + " X " + cube.getHeight());
    }
}
