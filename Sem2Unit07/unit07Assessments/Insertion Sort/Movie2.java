
/**
 * This is the Movie2 class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/24/2022
 */
public class Movie2
{
    // instance variables - replace the example below with your own
    private String title;
    private int year;
    private String studio;

    /**
     * Constructor for objects of class Movie2
     */
    public Movie2(String title, int year, String studio)
    {
        // initialise instance variables
        this.title = title;
        this.year = year;
        this.studio = studio;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public String getStudio()
    {
        return studio;
    }
    
    public String toString()
    {
        return getTitle() + ", " + getYear() + ", " + getStudio();
    }
}
