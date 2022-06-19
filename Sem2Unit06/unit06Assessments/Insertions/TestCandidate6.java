
/**
 * This program demonstrates the concept of insertions and transverse.
 *
 * @author Sreeya Gambhirrao
 * @version 04/23/2020
 */
import java.util.ArrayList;
public class TestCandidate6
{
    public static ArrayList<Candidate> election = new ArrayList<Candidate>();

    public static void addCandidates()
    {
      Candidate c1 = new Candidate("John Smith", 5000);  
      Candidate c2 = new Candidate("Mary Miller", 4000);  
      Candidate c3 = new Candidate("Michael Duffy", 6000);  
      Candidate c4 = new Candidate("Tim Robinson", 2500);  
      Candidate c5 = new Candidate("Joe Ashtony", 1800);  
      Candidate c6 = new Candidate("Mickey Jones", 3000);
      Candidate c7 = new Candidate("Rebecca Morgan ", 2000);
      Candidate c8 = new Candidate("Kathleen Turner", 8000);
      Candidate c9 = new Candidate("Tory Parker", 500);
      Candidate c10 = new Candidate("Ashton Davis", 10000);
      
      election.add(c1);
      election.add(c2);
      election.add(c3);
      election.add(c4);
      election.add(c5);
      election.add(c6);
      election.add(c7);
      election.add(c8);
      election.add(c9);
      election.add(c10);
    }
    
    public static void printVotes()
    {
        for(Candidate c : election)
        {
            System.out.println(c.toString());
        }
        
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
    
    public static void replaceName(ArrayList<Candidate> candidate, String origName, String replaceName)
    {
        for(int i = 0; i < candidate.size(); i++)
        {
            if(candidate.get(i).getName().equals(origName))
            {
                candidate.get(i).setName(replaceName);
                break;
            }
        }
    }
    
    public static void replaceVotes(ArrayList<Candidate> candidate, String origName, int replaceVote)
    {
        for(int i = 0; i < candidate.size(); i++)
        {
            if(candidate.get(i).getName().equals(origName))
            {
                candidate.get(i).setVotes(replaceVote);
                break;
            }
        }
    }
    
    public static void replaceCandidate(ArrayList<Candidate> candidate, String origName, String replaceName, int replaceVote)
    {
        for(int i = 0; i < candidate.size(); i++)
        {
            if(candidate.get(i).getName().equals(origName))
            {
                candidate.get(i).setName(replaceName);
                candidate.get(i).setVotes(replaceVote);
                break;
            }
        }
    }
    
    public static void insertPosition(ArrayList<Candidate> candidate, int position, String nameAdd, int votesAdd)
    {
        candidate.add(position, new Candidate(nameAdd, votesAdd));
    }
    
    public static void insertCandidate(ArrayList<Candidate> candidate, String findName, String insertName, int insertVotes)
    {
        int position = 0;
        
        for(int i  = 0; i < candidate.size(); i++)
        {
            if(candidate.get(i).getName().equals(findName))
            {
                position = i;
            }
        }
        
        candidate.add(position, new Candidate(insertName, insertVotes));
    }
    
    public static void printResults()
    {
        System.out.printf("%-20s%-20s%-20s\n","Candidate", "Votes Recieved", "% of Total Votes");
        System.out.println("-------------------------------------------------------------------");
        int totalVotes = getTotal();
        for(Candidate c : election)
        {
            int votes = c.getVotes();
            int percent = votes * 100/totalVotes;
            System.out.printf("%-20s%-20d%-20d\n",c.getName(),c.getVotes(),percent);
        }
        
        
        System.out.println();
        System.out.printf("%s%25d\n","Total number of votes received:",getTotal());
    }
    
    public static void main(String[] args)
    {
        addCandidates();

        System.out.println("Original Results: ");
        System.out.println("************************************************************");
        
        printResults();
        
        //replaceName(election,"Michael Duffy","John Elmos");
        //replaceVotes(election,"Mickey Jones",2500); 
        //replaceCandidate(election,"Kathleen Turner","John Kennedy",8500);
        
        System.out.println("After Results: ");
        System.out.println("***********************************************************");
        System.out.println();
        
        insertPosition(election, 5,"Mickey Duck",14000);
        insertCandidate(election,"Kathleen Turner","Donald Mouse",2500);

        printResults();
        
    }
}
