
/**
 * This program inherits properties and methods from the Triangle class and prints the dimensions for each type of triangle.
 *
 * @author Sreeya Gambhirrao
 * @version 3/06/2022
 */
public class TestTriangles
{
    public static void main(String[] args)
    {
        Triangle tri = new Triangle(4.0, 5.0,6.0);
        
        System.out.println("Triangle has sides :  " + "A = " + tri.getSideA() + " B = " + tri.getSideB() + " C = " + tri.getSideC());
        
        tri = new Equilateral(5.0);
        
        System.out.println("Equilateral Triangle has sides :  " + "A = " + tri.getSideA() + " B = " + tri.getSideB() + " C = " + tri.getSideC());
        
        tri = new IsoscelesRight(1.5);
        
        System.out.println("Isosceles Right Triangle has sides :  " + "A = " + tri.getSideA() + " B = " + tri.getSideB() + " C = " + tri.getSideC());
        
    }
}
