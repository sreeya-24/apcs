
/**
 * This program takes user input of name, weight in pounds, height in feet and inches, 
 * and converts weight to kilograms and height to meters and then calculates BMI and 
 * checks to see whether it's in the right range.
 *
 * @author Sreeya Gambhirrao
 * @version 11/28/2021
 */
import java.util.Scanner;
public class BMI
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name(first last): ");
        String name = in.nextLine();
        
        System.out.println("Enter your weight in pounds (e.g. 175): ");
        double weight = in.nextDouble();
        
        System.out.println("Enter your height in feet and inches (e.g. 5 11): ");
        int feet = in.nextInt();
        int inches = in.nextInt();
        
        // 1 kg = 2.2 pounds
        double conversionFactor = 2.2;
        double weightInKgs = weight/conversionFactor;
        
        // 1 ft = 12 inches, 1 meter = 39.39inches
        int heightTotalInches = feet*12 + inches;
        double heightInMeters = heightTotalInches/39.39;
        
        System.out.println();
        System.out.println("Body Mass Index Calculator");
        System.out.println("*******************************");
        System.out.println("Name: " + name);
        System.out.println("Height(m): " + heightInMeters);
        System.out.println("Weight(kg): " + weightInKgs);
        
        //BMI Calculation
        double BMI = weightInKgs/((heightInMeters)*(heightInMeters));
        System.out.println("BMI: " + BMI);
        
        // Getting BMI to 1 decinal point
        String bmiString = ""+BMI;
        int indexofDecimal = bmiString.indexOf('.');
        double BMI2 = Double.parseDouble(bmiString.substring(0, indexofDecimal+2));
        
        //Checking for BMI range
        if(BMI2 < 18.5){
            System.out.println("Category: Under Weight");
        } else if(BMI2>=18.5 && BMI2<=24.9){
            System.out.println("Category: Healthy Weight");
        } else if(BMI2>=25.0 && BMI2<=29.9){
            System.out.println("Category: Over Weight");
        } else if(BMI2>=30.0){
            System.out.println("Category: Obesity");
        }
        
        
    }
}
