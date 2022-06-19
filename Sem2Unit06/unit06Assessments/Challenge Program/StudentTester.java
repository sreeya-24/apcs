
/**
 * This program demonstrates the concept of transverse, deletion, replacement, and insertion.
 *
 * @author Sreeya Gambhirrao
 * @version 04/24/2022
 */
import java.util.ArrayList;
public class StudentTester
{
    public static ArrayList<Student> myClass = new ArrayList<Student>();
    public static void addCandidates()
    {
      Student s1 = new Student("Mark Kennedy",70,80,90,100,90);  
      Student s2 = new Student("Max Gerad",90,85,90,85,80);  
      Student s3 = new Student("Jean Smith",50,70,89,99,100);  
      Student s4 = new Student("Betty Farm",85,80,85,88,89);  
      Student s5 = new Student("Dilbert Gamma",70,70,90,70,80);  
      
      myClass.add(s1);
      myClass.add(s2);
      myClass.add(s3);
      myClass.add(s4);
      myClass.add(s5);
    }
    
    public static void printBook()
    {
        System.out.println("Starting Gradebook:");
        System.out.printf("%-14s%7s%5s%5s%5s%5s\n","Student name","Q1","Q2","Q3","Q4","Q5");
        System.out.println("---------------------------------------------------------------");
        for (Student st : myClass) {
            System.out.println(st);
        }
    }
    
    public static void replaceName(String origName, String newName)
    {
        for (int i=0; i< myClass.size();i++) {
            if (myClass.get(i).getName().equals(origName)) {
                myClass.get(i).setName(newName);
            }
        }
        
    }
    
    public static void replaceQuiz(String origName, int quizNumber, int quizValue)
    {
        for (int i =0; i< myClass.size(); i++ ) {
            if (myClass.get(i).getName().equals(origName)) {
                myClass.get(i).setQuiz(quizNumber, quizValue);
            }
        }
        
    }
    
    public static void replaceStudent(String origName, String newName, int[] scores)
    {
        for (int i =0; i< myClass.size(); i++ ) {
            if (myClass.get(i).getName().equals(origName)) {
                myClass.get(i).setName(newName);
                for (int j = 0; j< 5;j++) {
                    //System.out.println("scores " + scores[j]);
                    myClass.get(i).setQuiz(j+1,scores[j]); 
                }
                break;
            }
        }
    }
    
    public static void insertStudent(ArrayList<Student> gradeBook, String origName, String newName, int [] scores)
    {
        Student st = new Student(newName, scores[0], scores[1], scores[2], scores[3], scores[4]);
        for (int i = 0; i< gradeBook.size(); i++) {
            if (gradeBook.get(i).getName().equals(origName)) {
                if (i == 0) {
                    gradeBook.add(0, st);
                } else {
                    gradeBook.add(i-1, st);
                }
            }
        }
    }
    
    public static void deleteStudent(ArrayList<Student> gradeBook, String origName)
    {
        for (int i = 0; i< gradeBook.size(); i++) {
            if (gradeBook.get(i).getName().equals(origName)) {
                gradeBook.remove(i);
            }
        }
    }
    
    
    public static void main(String[] args)
    {
        StudentTester testObject = new StudentTester();
        testObject.addCandidates();
        testObject.printBook();
        System.out.println("Change Betty Farm to Betty Boop");
        replaceName("Betty Farm", "Betty Boop");
        testObject.printBook();
        System.out.println("Change Jean Smith quiz1 to 80");
        replaceQuiz("Jean Smith", 1, 80);
        testObject.printBook();
        int[] scores = new int[] {80,80, 80, 90, 90};
        replaceStudent("Dilbert Gamma", "Mike Kappa", scores);
        testObject.printBook();
    }
}
