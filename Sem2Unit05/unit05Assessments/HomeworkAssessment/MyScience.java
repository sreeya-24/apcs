
/**
 * This is a child class of Homework.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022
 */
public class MyScience extends Homework
{
    /**
     * Constructor for objects of class MyScience
     */
    public MyScience(int pages, String type)
    {
        super(pages,type);
    }

    public void createAssignment(int p)
    {
        setPagesRead(p);
        setType("Science");
    }
    
    public String toString()
    {
        return getType() + " - " + "must read " + getPagesRead() + " pages.";
    }
}
