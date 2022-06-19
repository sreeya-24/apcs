
/**
 * This program demonstrates the concept of binary search.
 *
 * @author Sreeya Gambhirrao
 * @version 05/01/2022
 */
public class TestMusic2
{
    // instance variables - replace the example below with your own
    private static Music[] myMusic = new Music[10];

    public static Music[] insertionSort(Music[] music)
    {
        Music[] sorted = new Music[music.length];
        
        for(int i = 0; i < music.length; i++)
        {
            String next = music[i].getTitle();
            int insertindex = 0;
            int k = i;
            
            while((k>0) && (insertindex == 0))
            {
                if ( next.compareTo( sorted[k - 1].getTitle() ) > 0 )
                {
                    insertindex = k;
                }
                else
                {
                    sorted[k] = sorted[k - 1];
                }
                k--;
            }
            sorted[ insertindex ] = music[i];
        }
        return sorted;
    }
    
    public static int searchTitle(Music[] music, String toFind)
    {
        int high = music.length;
        int low = -1;
        int probe;

        while ( high - low > 1 )
        {
            probe = ( high + low ) / 2;
            if ( music[probe].getTitle().compareTo(toFind) > 0)
            {    
                high = probe;
            }
            else
            {
                low = probe;
            }
        }
        if ( (low >= 0) && (music[low].getTitle().compareTo(toFind) == 0 ))
        {
            return low;
        }
        else
        {
            return -1;
        }
    }
    
    public static void searchYear(Music[] music, int toFind)
    {
        int found = 0;
        
        System.out.println("Search - Year - " + toFind);
        for(int i = 0; i < music.length; i++)
        {
            if (music[i].getYear() == toFind)
            {
                System.out.println("Found: " + music[i].getTitle() + ", " + music[i].getYear() + ", " + music[i].getSinger());
                found++;
            }
        }
        if (found == 0)
        {
            System.out.println("Not found.");
        }
        System.out.println();
    }
    
    public static void searchSinger(Music[] music, String toFind)
    {
        int found = 0;
        
        System.out.println("Search - Singer - " + toFind);
        for(int i = 0; i < music.length; i++)
        {
            if (music[i].getSinger().compareTo(toFind) == 0)
            {
                System.out.println("Found: " + music[i].getTitle() + ", " + music[i].getYear() + ", " + music[i].getSinger());
                found++;
            }
        }
        if (found == 0)
        {
            System.out.println("Not found.");
        }
        System.out.println();
    }
    
    public static void printMusic(Music[] music)
    {
        System.out.printf("%-25s%-6s%-20s\n", "Title", "Year", "Singer");
        System.out.println("---------------------------------------------------");
        for(int i = 0; i < music.length; i++)
        {
           System.out.println(music[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        int test = 0;
    
        myMusic[0] = new Music("Pieces of You", 1994, "Jewel");
        myMusic[1] = new Music("Jagged Little Pill", 1995, "Alanis Morissette");        
        myMusic[2] = new Music("What If It's You", 1995, "Reba McEntire");     
        myMusic[3] = new Music("Misunderstood", 2001, "Pink");
        myMusic[4] = new Music("Laundry Service", 2001, "Shakira");     
        myMusic[5] = new Music("Taking the Long Way", 2006, "Dixie Chicks");        
        myMusic[6] = new Music("Under My Skin", 2004, "Avril Lavigne");
        myMusic[7] = new Music("Let Go", 2002, "Avril Lavigne");     
        myMusic[8] = new Music("Let It Go", 2007, "Tim McGraw");     
        myMusic[9] = new Music("White Flag", 2004, "Dido");
        printMusic(myMusic);
        myMusic = insertionSort(myMusic);
        test = searchTitle(myMusic, "Misunderstood");
        System.out.println("Search - Title - Misunderstood");
        if (test != -1)
        {
            System.out.println("Found: " + myMusic[test].getTitle() + ", " + myMusic[test].getYear() + ", " + myMusic[test].getSinger());
        }
        else
        {   
            System.out.println("Not found.");
        }
        System.out.println();
        test = searchTitle(myMusic, "Under Paid");
        System.out.println("Search - Title - Under Paid");
        if (test != -1)
        {
            System.out.println("Found: " + myMusic[test].getTitle() + ", " + myMusic[test].getYear() + ", " + myMusic[test].getSinger());
        }
        else
        {   
            System.out.println("Not found.");
        }
        System.out.println();
        searchYear(myMusic, 2005);
        searchYear(myMusic, 2006);
        searchSinger(myMusic, "Darth Maul");
        searchSinger(myMusic, "Dido");
    }
}
