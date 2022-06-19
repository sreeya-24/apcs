
/**
 * Write a description of class ShapesV4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShapesV4
{
    //default constructor
    ShapesV4()
    {
    }
    
    //calculate area of a triangle
    public double calcRectArea(int length, int width)
    {
        return length * width;
    }
    //calculate the hypoteneuse of a right triangle
    public double calcRectPerimeter(int length, int width)
    {
        return (2 * length) + (2 * width);
    }
    
    public double calcCircumference(int r)
    {
        return 2 * Math.PI * r;
    }
    
    //main method
    public static void main(String[] args)
    {
        //declaration of variables
        int length, width, radius;
        //double triArea, hypoteneuse;
        double rectArea, rectPerimeter, circumference;
        
        //initialization of variables
        length = 10; width = 5; radius = 2;
        rectArea = 0; 
        rectPerimeter = 0;
        circumference = 0;
        
        ShapesV4 shapes = new ShapesV4();
        
        //call methods
        rectArea = shapes.calcRectArea(length, width); 
        rectPerimeter = shapes.calcRectPerimeter(length, width);
        circumference = shapes.calcCircumference(radius);

        //print results
        System.out.printf(" Rectangle Area = %8.2f%n", rectArea);
        System.out.printf("  Rectangle Perimeter = %8.2f%n", rectPerimeter);
        System.out.printf("  Circumference = %8.2f%n", circumference);
    }
}