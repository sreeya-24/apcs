
/**
 * This program prints the rectangle's, box's, and cube's domensions and compares them with 
 * each other.
 *
 * @author Sreeya Gambhirrao
 * @version 03/20/2022
 */
public class TestNew
{
    public static void main(String[] args)
    {
        //creating objects
        Rectangle3 rect3 = new Rectangle3(5,20);
        Box3 box3 = new Box3(4,4,4);
        Box3 box4 = new Box3(4,10,5);
        Cube3 cube3 = new Cube3(4,4,4);
        
        // calling showEffectBoth method on objects
        showEffectBoth(rect3);
	showEffectBoth(box3);
	showEffectBoth(box4);
	showEffectBoth(cube3);
	
	boolean isBoxEqualsCube = box3.equals(cube3);
	
	if (isBoxEqualsCube) 
	{
	    System.out.println(box3 + " same as " + cube3);
	}
	
	isBoxEqualsCube = box4.equals(cube3);
	
	if (!isBoxEqualsCube) 
	{
	    System.out.println(box4 + "is not the same as "+ cube3);
	}
    }
    
    // showEffectBoth method
    public static void showEffectBoth(Rectangle3 r)
    {
	     System.out.println(r);
    }
}
