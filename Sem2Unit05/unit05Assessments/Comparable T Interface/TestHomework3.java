
/**
 * This program demonstrates the concept of the Comparable T Interface.
 *
 * @author Sreeya Gambhirrao
 * @version 04/18/2022
 */
import java.util.ArrayList;
public class TestHomework3
{
    public static void main(String[] args)
    {
         MyMath3 math3 = new MyMath3();
         math3.createAssignment(4);
         
         MyScience3 science3 = new MyScience3();
         science3.createAssignment(6);
         
         MyEnglish3 english3 = new MyEnglish3();
         english3.createAssignment(4);
         
         MyJava3 java3 = new MyJava3();
         java3.createAssignment(5);
         
         ArrayList<Homework3> homework3 = new ArrayList<Homework3>();
         homework3.add(math3);
         homework3.add(science3);
         homework3.add(english3);
         homework3.add(java3);
         
         for(Homework3 c : homework3)
         {
             System.out.println(c.toString());
         }
         
         int compare = english3.compareTo(math3);
         
         if(compare == 0)
         {
             System.out.println(math3.getType() + " and " + english3.getType() + " have the same number of pages.");
         } else if(compare == 1)
         {
             System.out.println(math3.getType() + " has more work than " + english3.getType());
         } else
         {
             System.out.println(math3.getType() + " has less work than " + english3.getType());
         }
         
    }
}
