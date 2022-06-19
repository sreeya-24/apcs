
/**
 * This is an abstract parent class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/18/2022
 */
public abstract class Homework3 implements Comparable<Homework3>
{
    // instance variables - replace the example below with your own
    private int pagesRead;
    private String typeHomework;

    /**
     * Constructor for objects of class Homework3
     */
    public Homework3()
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
    
    public abstract void createAssignment(int p );
    
    public int compareTo(Homework3 hw)
    {
        if(pagesRead < hw.pagesRead)
        {
            return 1;
        } else if(pagesRead == hw.pagesRead)
        {
            return 0;
        } else
        {
            return -1;
        }
    }
    
    public abstract String toString();
}
