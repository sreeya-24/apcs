
/**
 * This project will take user imput of name, social security number, 
 * book title, the number of days the book is late, and the daily fine and calculate the 
 * total fine of the late book.
 *
 * @author Sreeya Gambhirrao
 * @version 11/14/2021
 */
import java.util.Scanner;
public class Fines
{
    public static void main(String[] args)
    {
        //Scanner in = new Scanner(System.in);
        int average;
        average = 50;
        int a;
        a = 91;
        
        if(a%2 == 0) {
            System.out.println("a is even.");
        }   else {
            System.out.println("a is odd");
        }
        
        
        /*if (average >= 90 ) {
            System.out.println("This is Sreeya.");
            System.out.println (":Grade = A");
        }       else {
            System.out.println("Oh It's Praneetha!");
        }*/
        System.out.print("Please enter your name (Last, First) and Social Security Number(###-##-####): ");
        String customerInformation = in.nextLine();
        int index1 = customerInformation.indexOf(" ");
        
        String lastName = customerInformation.substring(0,index1);
        
        String remainingString = customerInformation.substring(index1 + 1, customerInformation.length());
        
        int index2 = remainingString.indexOf(" ");
        
        String firstName = remainingString.substring(0, index2);
        
        String remainingString2 = remainingString.substring(index2 + 1, remainingString.length());
        
        String lastFour = remainingString2.substring(7,11);
        
        String firstName2 = firstName.substring(0, 3);
        System.out.print("\n");
        
        System.out.print("Enter the title of the book: ");
        String bookTitle = in.nextLine();
        System.out.print("\n");
        
        System.out.print("Enter the date checked out(mm/dd/yyyy): ");
        String dateChecked = in.nextLine();
        System.out.print("\n");
        
        System.out.print("Days late: ");
        String daysLate = in.nextLine();
        System.out.print("\n");
        
        System.out.print("Daily fine: ");
        String dailyFine = in.nextLine();
        System.out.print("\n");
        
        in.close();
        
        System.out.println("To: " + lastName + " " + firstName + "                              " + "Account: " + lastName.replace(",", "") + firstName2 + "-" + lastFour);
        System.out.println("From: Sreeya");
        System.out.println("Subject: Overdue Notice");
        System.out.println("*****************************************************************************************************************************");
        System.out.println("The " + bookTitle + " was checked out on " + dateChecked + ".");
        System.out.println("This book is currently " + daysLate + " days" + " late.");
        
        double totalFine = Integer.parseInt(daysLate) * Double.parseDouble(dailyFine);
        System.out.print("Your accumulated fine is: " + totalFine + " dollars");
        
    }
}
