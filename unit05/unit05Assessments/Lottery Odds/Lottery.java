/**
 * This program produces a random number from 000 to 999 and asks the user to guess the number.
 * 
 * @author Sreeya Gambhirrao
 * @version 12/28/2021
 */
 
import java.util.Scanner;
public class Lottery
{
    public static void main(String[] args)
    {
        //declare and initialized variables and objects
        Scanner input = new Scanner(System.in);
        
        String lotteryNum = "";
        String userGuess = "";
        int lottery=0;
        
        //Generate a 3-digit "lottery" number composed of random numbers
        //Simulate a lottery by drawing one number at a time and 
        //concatenating it to the string
        //Identify the repeated steps and use a for loop structure
        //356 => 300 +50+6
        for(int i = 1; i<=3; i++){
           lottery += Math.random()*Math.pow(10,i);
            
        }
        lotteryNum = Integer.toString(lottery);
        //System.out.println("Lottery Number: " + lotteryNum);
        //Input: Ask user to guess 3 digit number
        System.out.println("Please enter your three number (e.g 123): ");
        userGuess = input.nextLine();
        String FirstTwo = userGuess.substring(0,2);
        String LastTwo = userGuess.substring(1,3);
        
        String FirstTwoRand = lotteryNum.substring(0,2);
        String LastTwoRand = lotteryNum.substring(1,3);
        
        if(userGuess.equals(lotteryNum))
        {
            System.out.println("Winner: " + lotteryNum);
            System.out.println("Congratulations! You correctly guessed the number!");
        } else if(FirstTwo.equals(FirstTwoRand)){
            System.out.println("Winner: " + lotteryNum);
            System.out.println("Congratulations! The first pairs matched!");
        } else if(LastTwo.equals(LastTwoRand)) {
            System.out.println("Winner: " + lotteryNum);
            System.out.println("Congratulations! The end pairs matched!");
        } else{
            System.out.println("Sorry, no matches!");
        }
        
        
        
        
        
        
        
      
      
      
      
        //Compare the user's guess to the lottery number and report results
        
        
        
        

        
    } //end main
}//end class Lottery