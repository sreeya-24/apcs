
/**
 * This is the candidate class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/23/2022
 */
public class Candidate
{
    // instance variables - replace the example below with your own
    private String name;
    private int numVotes;

    /**
     * Constructor for objects of class Candidate
     */
    public Candidate(String name, int numVotes)
    {
        // initialise instance variables
        this.name = name;
        this.numVotes = numVotes;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    
    public void setVotes(int numVotes)
    {
        this.numVotes = numVotes;
    }
    
    public int getVotes()
    {
        return numVotes;
    }
    
    public String toString()
    {
        return getName() + " received " + getVotes() + " votes.";
    }
    
}
