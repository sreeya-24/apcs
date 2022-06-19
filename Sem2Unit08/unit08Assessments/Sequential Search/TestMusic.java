
/**
 * This program demonstrates the concept of sequential searching.
 *
 * @author Sreeya Gambhirrao
 * @version 05/01/2022
 */
public class TestMusic
{
    // instance variables - replace the example below with your own
    public static Music[] myMusic = new Music[10];

    public static void searchTitle(Music[] music, String toFind)
    {
        int found = 0;
        
        for(int i = 0; i < music.length; i++)
        {
            if((music[i].getTitle() != null) && (toFind != null))
            {
                if(music[i].getTitle().compareTo(toFind) == 0)
                {
                    System.out.println(music[i]);
                    found++;
                }
            }
        }
        
        if (found == 0)
        {
            System.out.println("There are no listings for " + toFind);
            System.out.println();
        } else
        {
            System.out.println("There were " + found + " listings for " + toFind);
            System.out.println();
        }
    }
    
    public static void searchYear(Music[] music, int toFind)
    {
        int found = 0;
        
        for(int i = 0; i < music.length; i++)
        {
            if(music[i].getYear() == toFind)
            {
                System.out.println(music[i]);
                found++;
            }
        }
        
        if(found == 0)
        {
            System.out.println("There are no listings for " + toFind);
            System.out.println();
        } else
        {
            System.out.print("There were " + found + " listings for " + toFind);
            System.out.println();
        }
    }
    
    public static void searchSinger(Music[] music, String toFind)
    {
        int found = 0;
        
        for(int i = 0; i < music.length; i++)
        {
            if(music[i].getSinger() != null)
            {
                if(music[i].getSinger().compareTo(toFind) == 0)
                {
                    System.out.println(music[i]);
                    found++;
                }
            }
        }
        
        if(found == 0)
        {
            System.out.println("There are no listings for " + toFind);
            System.out.println();
        } else
        {
            System.out.print("There were " + found + " listings for " + toFind);
            System.out.println();
        }
    }
    
    public static void printMusic(Music[] music)
    {
        System.out.println("Time                     Location        Person");
	System.out.println("---------------------------------------------------");
	for(int i = 0; i < music.length; i++)
	{
	   if(music[i] != null)
	   {
	           System.out.println(music[i]);
	   }
	}
    }
    
    public static void main(String[] args)
    {   Music[] myMusic = new Music[10];
        myMusic[0] = new Music("Pieces of You",1994, "Jewel");
	myMusic[1] = new Music("Jagged Little Pill",1995,"Alanis Morissette");
        myMusic[2] = new Music("What If It's You", 1995,"Reba McEntired");
        myMusic[3] = new Music("Misunderstood",2001,"Pink");
	myMusic[4] = new Music("Laundry Service",2001,"Shakira");
	myMusic[5] = new Music("Taking the Long Way",2006,"Dixie Chicks");
	myMusic[6] = new Music("Under My Skin",2004,"Avril Lavigne");
	myMusic[7] = new Music("Let Go",2002,"Avril Lavigne");
	myMusic[8] = new Music("Let It Go",2007,"Tim McGraw");
	myMusic[9] = new Music("White Flag",2004,"Dido");
	
	printMusic(myMusic);
	System.out.println();
	
	System.out.println("Search - Title - Let Go");
	searchTitle(myMusic, "Let Go");
	System.out.println();
	
	System.out.println("Search - Title - Some Day");
	searchTitle(myMusic, "Some Day");
	System.out.println();
	
	System.out.println("Search - Year - 2001");
	searchYear(myMusic, 2001);
	System.out.println();
	
	System.out.println("Search - Singer - Avril Lavigne");
	searchSinger(myMusic,"Avril Lavigne");
	System.out.println();
	
	System.out.println("Search - Singer - Tony Curtis");
	searchSinger(myMusic, "Tony Curtis");
    }
}
