
/**
 * This is a child class of Homework.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022
 */
public class MyMath extends Homework
{
    /**
     * Constructor for objects of class MyMath
     */
    public MyMath(int pages, String type)
    {
        super(pages,type);
    }

    public void createAssignment(int p)
    {
        setPagesRead(p);
        setType("Math");
    }
    
    public String toString()
    {
        return getType() + " - " + "must read " + getPagesRead() + " pages.";
    }
}
