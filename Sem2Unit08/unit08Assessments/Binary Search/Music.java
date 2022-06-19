
/**
 * This is the music class.
 *
 * @author Sreeya Gambhirrao
 * @version 05/01/2022
 */
public class Music
{
    // instance variables - replace the example below with your own
    private String title;
    private int year;
    private String singer;

    /**
     * Constructor for objects of class Music
     */
    public Music(String t, int y, String s)
    {
        // initialise instance variables
        title = t;
        year = y;
        singer = s;
    }

    public void setTitle(String t)
    {
        title = t;
    }
    
    public void setYear(int y)
    {
        year = y;
    }
    
    public void setSinger(String s)
    {
        singer = s;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public String getSinger()
    {
        return singer;
    }
    
    public String toString()
    {
        return String.format("%-18s", title) + "\t" + String.format("%-10s", year) +"\t" + String.format("%-15s", singer);
    }
}