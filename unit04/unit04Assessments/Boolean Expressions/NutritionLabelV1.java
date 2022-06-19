int
/**
 * The purpose of this program is to have the user enter the number of calories, 
 * carbohydrates, fiber, protein, and fat of a type of food the user chooses 
 * and checks to see if it exeeds the daily value.
 * 
 * FLVS 2021
 * @author Sreeya Gambhirrao 
 * @version 11/25/2021
 */
import java.util.Scanner;
public class NutritionLabelV1
{
    public static void main(String[] args)
    {
        String foodItem;                            //food item
        
        int dailyTotalCalories = 2000;              //max daily calories
        int dailyValueGramsTotalFat = 65;           //fat DRV    
        int dailyValueTotalCarbs = 300;             //carbohydrates DRV       
        int dailyValueFiber = 25;                   //fiber DRV
        int dailyValueProtein = 50;                 //protein DRV
  
        //object to use the keyboard input methods
        Scanner in = new Scanner(System.in);
        
        //prompt user for input
        System.out.print("Enter the name of the food item: ");
        foodItem = in.nextLine();
        System.out.println();
        
        //serving size
        System.out.print("How many servings will you eat? ");
        int servingSize = in.nextInt();
        System.out.println();
        
        //calories
        System.out.print("Enter Calories per Serving: ");
        int totalCalories = in.nextInt();
        totalCalories = totalCalories * servingSize;
        int percentTotalCalories = totalCalories * 100 / dailyTotalCalories;
        boolean isTotalCalories = totalCalories < dailyTotalCalories;
        
        //fat
        System.out.print("Enter grams of Total Fat per Serving: ");
        int totalGramsFat = in.nextInt();
        totalGramsFat = totalGramsFat * servingSize;
        int percentTotalFat = totalGramsFat * 100 / dailyValueGramsTotalFat;
        boolean isTotalFat = totalGramsFat < dailyValueGramsTotalFat;
        
        //carbs
        System.out.print("Enter grams Carbohydrate per serving: ");
        int totalGramsCarbs = in.nextInt();
        totalGramsCarbs = totalGramsCarbs * servingSize;
        int percentTotalCarbs = totalGramsCarbs * 100 / dailyValueTotalCarbs;
        boolean isTotalCarbs = totalGramsCarbs < dailyValueTotalCarbs;
        
        //fiber
        System.out.print("Enter grams Fiber per serving: ");
        int totalGramsFiber = in.nextInt();
        totalGramsFiber = totalGramsFiber * servingSize;
        int percentTotalFiber = totalGramsFiber * 100 / dailyValueFiber;
        boolean isTotalFiber = totalGramsFiber < dailyValueFiber;
        
        //protein
        System.out.print("Enter grams Proteins per serving: ");
        int totalGramsProtein = in.nextInt();
        totalGramsProtein = totalGramsProtein * servingSize;
        int percentTotalProtein = totalGramsProtein * 100 / dailyValueProtein;
        boolean isTotalProtein = totalGramsProtein < dailyValueProtein;
        System.out.println();
        
        //output
        
        
        System.out.println("Food: " + foodItem);
        System.out.println("Serving Size: " + servingSize);
        System.out.println();
        
        System.out.println();
        System.out.println("Component           Total          Percent          Less than Daily Value ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Calories            " + totalCalories + "               " + percentTotalCalories + "                      " + isTotalCalories);
        System.out.println("Fat                 " + totalGramsFat + "                " + percentTotalFat      + "                      " + isTotalFat);
        System.out.println("Carbohydrates       " + totalGramsCarbs + "                " + percentTotalCarbs    + "                      " + isTotalCarbs);
        System.out.println("Fiber               " + totalGramsFiber + "                 " + percentTotalFiber    + "                      " + isTotalFiber);
        System.out.println("Protein             " + totalGramsProtein + "               " + percentTotalProtein  + "                      " + isTotalProtein);
        
       
        
       

       
        
        
    }//end of main method    
}//end of class
