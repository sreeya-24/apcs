
/**
 * This program demonstrates the concept of deletion and transverse.
 *
 * @author Sreeya Gambhirrao
 * @version 04/23/2022
 */
public class TestCandidate7
{
    // instance variable
    public static Candidate[] election = new Candidate[10];
    
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
      
      election[0] = c1;
      election[1] = c2;
      election[2] = c3;
      election[3] = c4;
      election[4] = c5;
      election[5] = c6;
      election[6] = c7;
      election[7] = c8;
      election[8] = c9;
      election[9] = c10;
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
            if (c != null) {
                votes = votes + c.getVotes();
            }

        }
        
        return votes;
    }
    
    /*public static void replaceName(Candidate[] candidate, String origName, String replaceName)
    {
        for(int i = 0; i < candidate.length; i++)
        {
            if(candidate[i].getName().equals(origName))
            {
                candidate[i].setName(replaceName);
                break;
            }
        }
    }*/
    
    /*public static void replaceVotes(Candidate[] candidate, String origName, int replaceVote)
    {
        for(int i = 0; i < candidate.length; i++)
        {
            if(candidate[i].getName().equals(origName))
            {
                candidate[i].setVotes(replaceVote);
                break;
            }
        }
    }*/
    
    /*public static void replaceCandidate(Candidate[] candidate, String origName, String replaceName, int replaceVote)
    {
        for(int i = 0; i < candidate.length; i++)
        {
            if(candidate[i].getName().equals(origName))
            {
                candidate[i].setName(replaceName);
                candidate[i].setVotes(replaceVote);
                            break;
            }
        }
    }*/
    
    /*public static void insertPosition(Candidate[] candidate, int position, String nameAdd, int votesAdd)
    {
        for(int i = candidate.length - 1; i > position; i--)
        {
            candidate[i] = candidate[i - 1];
        }
        
        candidate[position] = new Candidate(nameAdd, votesAdd);
    }*/
    
    /*public static void insertCandidate(Candidate[] candidate, String findName, String insertName, int insertVotes)
    {
        int position = 0;
        
        for(int i = 0; i < candidate.length; i++)
        {
            if(candidate[i].getName().equals(findName))
            {
                position = i;
            }
        }
        
        for(int i = candidate.length - 1; i > position; i--)
        {
            candidate[i] = candidate[i - 1];
        }
        
        candidate[position] = new Candidate(insertName, insertVotes);
    }*/
    
    public static void deleteByLoc(Candidate[] candidate, int position)
    {
        if((position > 0) && (position < candidate.length))
        {
            for(int i = position+1; i < candidate.length; i++)
            {
                candidate[i-1] = candidate[i];
            }
            
            candidate[candidate.length - 1] = null;
        }
    }
    
    public static void deleteByName(Candidate[] candidate, String findName)
    {
        int position = 0;
        int i;
        
        for(i = 0; i < candidate.length; i++)
        {
            if((candidate[i] != null) && (candidate[i].getName().equals(findName)))
            {
                position = i;
                break;
            } else if(candidate[i] == null)
            {
                position = -1;
                break;
            }
        }
        
        if((i != candidate.length) && (position >= 0))
        {
            for(i = position+1; i < candidate.length; i++)
            {
                candidate[i-1] = candidate[i];
            }
            
            candidate[candidate.length - 1] = null;
        }
    }
    
    public static void printResults()
    {
        System.out.printf("%-20s%-20s%-20s\n","Candidate", "Votes Recieved", "% of Total Votes");
        System.out.println("-------------------------------------------------------------------");
        int totalVotes = getTotal();
        for(Candidate c : election)
        {
            if (c != null) {
                int votes = c.getVotes();
                int percent = votes * 100/totalVotes;
                System.out.printf("%-20s%-20d%-20d\n",c.getName(),c.getVotes(),percent);
            }
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
        
        //insertPosition(election, 5,"Mickey Duck",14000);
        //insertCandidate(election,"Kathleen Turner","Donald Mouse",2500);
        
        deleteByLoc(election, 6);
        deleteByName(election, "Kathleen Turner");

        printResults();
        
    }
}
