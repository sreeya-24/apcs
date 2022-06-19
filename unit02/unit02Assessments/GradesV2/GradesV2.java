
/**
 * Write a description of class GradesV2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GradesV2
{
    public static void main(String[ ] args)
    {
        //Declaration and Intialization of local variables
        int totalPoints = 0;  //total points for all tests
        int numTests = 0;     //counts the number of tests
        int testGrade = 0;    //individual test grade
        double average = 0.0; //average grade
        
        //Grade1
        testGrade = 97;
        totalPoints += testGrade;
        numTests ++;
        average = (double)totalPoints/(double)numTests;
        System.out.println("n = " + numTests + "  New Test Grade: " + testGrade + "  Total Points: " + totalPoints + "  Average Score: " + average);
        System.out.println();
        
        //Grade2
        testGrade = 79;
        totalPoints += testGrade;
        numTests ++;
        average = (double)totalPoints/(double)numTests;
        System.out.println("n = " + numTests + "  New Test Grade: " + testGrade + "  Total Points: " + totalPoints + "  Average Score: " + average);
        System.out.println();
        
        //Grade3
        testGrade = 83;
        totalPoints += testGrade;
        numTests ++;
        average = (double)totalPoints/(double)numTests;
        System.out.println("n = " + numTests + "  New Test Grade: " + testGrade + "  Total Points: " + totalPoints + "  Average Score: " + average);
        System.out.println();
        
        //Grade4
        testGrade = 88;
        totalPoints += testGrade;
        numTests ++;
        average = (double)totalPoints/(double)numTests;
        System.out.println("n = " + numTests + "  New Test Grade: " + testGrade + "  Total Points: " + totalPoints + "  Average Score: " + average);
        System.out.println();
        
        //Grade5
        testGrade = 50;
        totalPoints += testGrade;
        numTests ++;
        average = (double)totalPoints/(double)numTests;
        System.out.println("n = " + numTests + "  New Test Grade: " + testGrade + "  Total Points: " + totalPoints + "  Average Score: " + average);
        System.out.println();
        
        //Grade6
        testGrade = 100;
        totalPoints += testGrade;
        numTests ++;
        average = (double)totalPoints/(double)numTests;
        System.out.println("n = " + numTests + "  New Test Grade: " + testGrade + "  Total Points: " + totalPoints + "  Average Score: " + average);
        System.out.println();
        
        //Grade7
        testGrade = 80;
        totalPoints += testGrade;
        numTests ++;
        average = (double)totalPoints/(double)numTests;
        System.out.println("n = " + numTests + "  New Test Grade: " + testGrade + "  Total Points: " + totalPoints + "  Average Score: " + average);
    }
    
}
