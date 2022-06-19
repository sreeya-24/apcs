
/**
 * This program demonstates abstraction, implementation, and the concept of interface.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022
 */
import java.util.ArrayList;
public class TestHomework2
{
    public static void main(String[] args)
    {
        MyMath2 math2 = new MyMath2();
        math2.createAssignment(4);
        
        MyScience2 science2 = new MyScience2();
        science2.createAssignment(6);
        
        MyEnglish2 english2 = new MyEnglish2();
        english2.createAssignment(10);

        MyJava2 java2 = new MyJava2();
        java2.createAssignment(5);
        
        ArrayList<Homework2> homework = new ArrayList<Homework2>();
        homework.add(math2);
        homework.add(science2);
        homework.add(english2);
        homework.add(java2);
        
        for(Homework2 c : homework)
        {
            c.doReading();
        }
    }
}
