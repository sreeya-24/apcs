
/**
 * This is the parent homework2 class that implements processing.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022
 */
public abstract class Homework2 implements Processing
{
    // instance variables - replace the example below with your own
    private int pagesRead;
    private String typeHomework;

    /**
     * Constructor for objects of class Homework2
     */
    public Homework2()
    {
        pagesRead = 0;
        typeHomework = "None";
    }

    public int getPagesRead()
    {
        return pagesRead;
    }
    
    public void setPagesRead(int pages)
    {
        pagesRead = pages;
    }
    
    public String getType()
    {
        return typeHomework;
    }
    
    public void setType(String type)
    {
        typeHomework = type;
    }
    
    public abstract void createAssignment(int p);
}
