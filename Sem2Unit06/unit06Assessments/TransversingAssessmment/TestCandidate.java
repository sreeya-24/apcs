
/**
 * This project demonstrates the concept of transversing.
 *
 * @author Sreeya Gambhirrao
 * @version 04/23/2020
 */
import java.util.*;
public class TestCandidate
{
    public static List<Candidate> election = new ArrayList<Candidate>();
    public static void addCandidates()
    {
      Candidate c1 = new Candidate("John Smith", 5000);  
      Candidate c2 = new Candidate("Mary Miller", 4000);  
      Candidate c3 = new Candidate("Michael Duffy", 6000);  
      Candidate c4 = new Candidate("Tim Robinson", 2500);  
      Candidate c5 = new Candidate("Joe Ashtony", 1800);  
      
      election.add(c1);
      election.add(c2);
      election.add(c3);
      election.add(c4);
      election.add(c5);
    }
    
    public static void printVotes()
    {
        for(Candidate c : election)
        {
            System.out.println(c.toString());
        }
        System.out.println();
    }
    
    public static int getTotal()
    {
        int votes = 0;
        for(Candidate c : election)
        {
            votes = votes + c.getVotes();
        }
        
        return votes;
    }
    
    public static void main(String[] args)
    {
        addCandidates();
        printVotes();
        
    }
}
