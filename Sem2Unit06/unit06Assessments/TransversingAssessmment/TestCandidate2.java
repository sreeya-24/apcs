
/**
 * This project demonstrates the concept of transversing.
 *
 * @author Sreeya Gambhirrao
 * @version 04/23/2022
 */
import java.util.ArrayList;
public class TestCandidate2
{
    public static void main(String[] args)
    {
        int sum = 0;
        int counter = 0;
        
        ArrayList<Candidate> candidate = new ArrayList<Candidate>();
        
        Candidate john = new Candidate("John Smith", 5000);
        candidate.add(john);
        
        Candidate mary = new Candidate("Mary Miller", 4000);
        candidate.add(mary);
        
        Candidate michael = new Candidate("Michael Duffy", 6000);
        candidate.add(michael);
        
        Candidate tim = new Candidate("Tim Robinson", 2500);
        candidate.add(tim);
        
        Candidate joe = new Candidate("Joe Ashtonyh", 1800);
        candidate.add(joe);
        
        
        System.out.println("Results Per Candidate: ");
        System.out.println("-----------------------");
        System.out.println();
        
        for(Candidate t : candidate)
        {
            System.out.println(t.toString());
            sum += t.getVotes();
            counter++;
        }
        
        System.out.println();
        System.out.println("Candidate                         Votes Recieved                       % of Total Votes");
        for(Candidate t : candidate)
        {
            System.out.printf("%s%30d%38.1f\n", t.getName(), t.getVotes(), ((double)t.getVotes()/sum * 100));
        }
    }
}
