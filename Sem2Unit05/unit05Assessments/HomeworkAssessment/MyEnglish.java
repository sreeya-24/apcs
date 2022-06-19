
/**
 * This is a child class of Homework.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022
 */
public class MyEnglish extends Homework
{
    /**
     * Constructor for objects of class MyEnglish
     */
    public MyEnglish(int pages, String type)
        {
            super(pages,type);
        }

    public void createAssignment(int p)
        {
            setPagesRead(p);
            setType("English");
        }
    
    public String toString()
        {
            return getType() + " - " + "must read " + getPagesRead() + " pages.";
        }
    
}
