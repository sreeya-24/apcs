/**
 * This program demonstrates the concept of abstraction.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022;
 */
import java.util.ArrayList;
public class testHomework
{
    public static void main(String[] args)
    {
        ArrayList<Homework> homework = new ArrayList<Homework>();
        
        MyMath math = new MyMath(4, "Math");
        MyScience science = new MyScience(6, "Science");
        MyEnglish english = new MyEnglish(10, "English");
        MyJava java = new MyJava(5, "Java");
        
        homework.add(math);
        homework.add(science);
        homework.add(english);
        homework.add(java);
        
        for(Homework c : homework)
        {
            System.out.println(c.toString());
        }
        
    }
}
