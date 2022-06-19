
/**
 * This is a child class of Homework.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022
 */
public class MyJava extends Homework
{
    /**
     * Constructor for objects of class MyJava
     */
    public MyJava(int pages, String type)
    {
        super(pages,type);
    }

    public void createAssignment(int p)
    {
        setPagesRead(p);
        setType("Java");
    }
    
    public String toString()
    {
        return getType() + " - " + "must read " + getPagesRead() + " pages.";
    }
}
