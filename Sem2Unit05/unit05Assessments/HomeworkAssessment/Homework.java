
/**
 * This is an abstract parent class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022
 */
public abstract class Homework
{
    // instance variables - replace the example below with your own
    private int pagesRead;
    private String typeHomework;

    /**
     * Constructor for objects of class Homework
     */
    public Homework(int pages, String type)
    {
        pagesRead = pages;
        typeHomework = type;
    }
    
    public Homework()
    {
        pagesRead = 0;
        typeHomework = "none";
    }
    
    public void setPagesRead(int pages)
    {
        pagesRead = pages;
    }
    
    public void setType(String type)
    {
        typeHomework = type;
    }
    
    public int getPagesRead()
    {
        return pagesRead;
    }
    
    public String getType()
    {
        return typeHomework;
    }
    
    public abstract void createAssignment(int p); 
}
