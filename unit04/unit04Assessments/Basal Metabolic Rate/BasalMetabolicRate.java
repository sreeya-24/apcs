
/**
 * This program takes the user input of name, 
 * height, weight, and gender and calculates metabolic 
 * rate depending on gender.
 *
 * @author Sreeya Gambhirrao
 * @version 11/27/2021
 */
import java.util.Scanner;
public class BasalMetabolicRate
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        double BMR = 0;
        double kilograms;
        double pounds;
        double inches;
        double centimeters;
        
        System.out.println("Enter your name: ");
        String name = in.next();
        
        System.out.println("Enter your gender(M or F): ");
        String Gender = in.next();
        char gender = Gender.charAt(0);
        
        System.out.println("Enter your age: ");
        int age = in.nextInt();
        
        System.out.println("Enter height in inches: ");
        double height = in.nextDouble();
        
        System.out.println("Enter weight in pounds: ");
        double weight = in.nextDouble();
        System.out.println();
        
        inches = height;
        centimeters = inches*2.54;
        
        pounds = weight;
        kilograms = pounds/2.2;
        
        System.out.println("Calculate your Basal Metabolism");
        System.out.println();

        System.out.println("Name: " + name);
        System.out.println("Gender: " + Gender);
        System.out.println("Age: " + age);
        System.out.println("Weight(kg): " + kilograms);
        System.out.println("Height(cm): " + centimeters);
        
        boolean isGender = gender == 'M';
        
        if(isGender) {
            BMR = 88.362 + (13.397*weight)/1 + (4.799*height)/1 - (5.677*age)/1 +88.362;
            System.out.println("Basal Metabolic Rate: " + BMR + " calories per day.");
        }
        else{
            BMR = 447.593 + (9.247*weight)/1 + (3.098*height)/1 - (4.330*age)/1 + 447.593;
            System.out.println("Basal Metabolic Rate: " + BMR + " calories per day.");
        }
            
            
    }
}
