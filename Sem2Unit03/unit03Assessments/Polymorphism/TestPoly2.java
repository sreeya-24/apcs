
/**
 * This program shows the center of the circle, oval, cylinder, and oval cylinder by using 
 * polymorphism.
 *
 * @author Sreeya Gambhirrao
 * @version 03/20/2022
 */
public class TestPoly2
{
    public static void main(String[] args)
    {
        Circle2 circle = new Circle2(2,4,6);
        
        Cylinder2 cylinder = new Cylinder2(10,15,4,2);
        
        Oval2 oval = new Oval2(25,10,6,4);
        
        OvalCylinder2 ovalCylinder = new OvalCylinder2(40,10,6,7,8);
        
        
        polymorph(circle);
        System.out.println();
        
        polymorph(cylinder);
        System.out.println();
        
        polymorph(oval);
        System.out.println();
        
        polymorph(ovalCylinder);
    }
    
    public static void polymorph(Circle2 s)
    {
        System.out.println("For " + s.getClass().getName() + " : ");
        System.out.println("The " + s.center() );
    }
}
