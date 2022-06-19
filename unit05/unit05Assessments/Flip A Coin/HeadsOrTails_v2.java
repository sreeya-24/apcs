
/**
 * This program models flipping an unbiased coin and counting the
 * number of times heads or tails occurs.
 * 
 * @author B. Jordan 
 * @version 04/01/08
 */
import java.util.Scanner;
public class HeadsOrTails_v2
{
    public static void main(String[] args)
    {
        String doYouWantToContinue = "Y";
        Scanner in = new Scanner(System.in);
    
        while(doYouWantToContinue.equalsIgnoreCase("Y"))
        {
            System.out.println("Enter your height in feet");
            int height = in.nextInt();
            
            int inches = height * 12;
            System.out.println("Your height in inches = " + inches);
            System.out.println("Do you want to continue? (Y/N)");
            
            doYouWantToContinue = in.next();
        }
        
        System.out.println("OKAY Good Bye!");
        
    }
}
