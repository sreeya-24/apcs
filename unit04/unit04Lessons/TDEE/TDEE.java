
/**
 * This program calculates the amount of calories a body is burned based on the user entered gender and the activity factor.
 *
 * @author Sreeya Gambhirrao
 * @version 12/12/2021
 */
import java.util.Scanner;
public class TDEE
{
     public static void main(String[] args)
     {
         Scanner in = new Scanner(System.in);
        
         
         System.out.println("Please enter your name: ");
         String name = in.nextLine();
         
         System.out.println("Please enter your BMR: ");
         double BMR = in.nextDouble();
         
         System.out.println("Please enter your gender(M/F): ");
         String gender = in.next();
         char gender2 = gender.charAt(0);
         
         boolean isGender = gender2 == 'M';
         
         System.out.println("Select Your Activity Level");
         System.out.println("[0] Resting (Sleeping, Reclining)");
         System.out.println("[1] Sedentary (Minimal Movement)");
         System.out.println("[2] Light ( Sitting, Standing)");
         System.out.println("[3] Moderate (Light Manual Labor, Dancing, Riding Bike)");
         System.out.println("[4] Very Active (Team Sports, Hard Manual Labor)");
         System.out.println("[5] Extremely Active (Full-time Athlete, Heavy Manual Labor)");
         System.out.println("Select a number that corresponds to a menu option");
         System.out.println("Select a number that corresponds to a menu option");
         System.out.print("Enter 0, 1, 2, 3, 4, or 5: ");
         String choice = in.next();
         System.out.println();
         
        
         
         
         if((isGender) && (choice.equals("0")))
         {
             System.out.println("You chose 0 for Resting (Sleeping, Reclining)");
             System.out.println();
             double ActivityFactor = 1.0;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender == false) && (choice.equals("0"))) 
         {
             System.out.println("You chose 0 for Resting (Sleeping, Reclining)");
             System.out.println();
             double ActivityFactor = 1.0;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender) && (choice.equals("1")))
         {
          System.out.println("You chose 1 for Sedentary (Minimal Movement)");
          System.out.println();
             double ActivityFactor = 1.3;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender == false) && (choice.equals("1")))
         {
             System.out.println("You chose 1 for Sedentary (Minimal Movement)");
             System.out.println();
             double ActivityFactor = 1.3;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender) && (choice.equals("2")))
         {
             System.out.println("You chose 2 for Light ( Sitting, Standing)");
             System.out.println();
             double ActivityFactor = 1.6;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
            System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender == false) && (choice.equals("2")))
         {
             System.out.println("You chose 2 for Light ( Sitting, Standing)");
             System.out.println();
             double ActivityFactor = 1.5;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender) && (choice.equals("3")))
         {
             System.out.println("You chose 3 for Moderate (Light Manual Labor, Dancing, Riding Bike)");
             System.out.println();
             double ActivityFactor = 1.7;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender == false) && (choice.equals("3")))
         {
             System.out.println("You chose 3 for Moderate (Light Manual Labor, Dancing, Riding Bike)");
             System.out.println();
             double ActivityFactor = 1.6;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " +"Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender) && (choice.equals("4")))
         {
             System.out.println("You chose 4 for Very Active (Team Sports, Hard Manual Labor)");
             System.out.println();
             double ActivityFactor = 2.1;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender == false) && (choice.equals("4")))
         {
             System.out.println("You chose 4 for Very Active (Team Sports, Hard Manual Labor)");
             System.out.println();
             double ActivityFactor = 1.9;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender) && (choice.equals("5")))
         {
             System.out.println("You chose 5 for Extremely Active (Full-time Athlete, Heavy Manual Labor)");
             System.out.println();
             double ActivityFactor = 2.4;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         } else if((isGender == false) && (choice.equals("5")))
         {
             System.out.println("You chose 5 for Extremely Active (Full-time Athlete, Heavy Manual Labor)");
             System.out.println();
             double ActivityFactor = 2.2;
             double TDEE = ActivityFactor * BMR;
             System.out.println("Name: " + name + "                              " + "Gender: " + gender2);
             System.out.println("BMR: " + BMR + " calories" + "                               " + "Activity Factor: " + ActivityFactor);
             System.out.println("TDEE: " + TDEE + " calories");
         }
     }
}
