
/**
 * This is the student class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/24/2022
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String name;
    private int qz1;
    private int qz2;
    private int qz3;
    private int qz4;
    private int qz5;

    /**
     * Constructor for objects of class Student
     */
    public Student(String name, int quiz1, int quiz2, int quiz3, int quiz4, int quiz5)
    {
        this.name = name;
        qz1 = quiz1;
        qz2 = quiz2;
        qz3 = quiz3;
        qz4 = quiz4;
        qz5 = quiz5;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuiz(int quizNumber)
    {
       if (quizNumber == 1) {
           return qz1;
       } else if (quizNumber == 2) 
       {
           return qz2;
        } else if (quizNumber == 3)
        {
           return qz3;
        } else if (quizNumber == 4)
        {
           return qz4;
        } else if (quizNumber == 5)
        {
           return qz5;
        }
        else {
            System.out.println("Unknown quiz number ");
            return 0;
        }
    }
    
    public void setQuiz(int quizNumber, int score)
    {
      if (quizNumber == 1) {
           this.qz1 = score;
       } else if (quizNumber == 2) 
       {
           this.qz2 = score;
        } else if (quizNumber == 3)
        {
           this.qz3 = score;
        } else if (quizNumber == 4)
        {
           this.qz4 = score;
        } else if (quizNumber == 5)
        {
           this.qz5 = score;
        }
        else {
            System.out.println("Unknown quiz number ");
        }        
    }
    
    public String toString()
    {
        return String.format("%-14s%7s%5s%5s%5s%5s",this.getName(), this.qz1,this.qz2,this.qz3,this.qz4,this.qz5);
    }

}
