
/**
 * This program models the concept of Insertion sorting.
 *
 * @author Sreeya Gambhirrao
 * @version 04/24/2022
 */
public class TestMovie2
{
    public static Movie2[] sortTitles(Movie2[] a, int b)
    {
        Movie2[] newList = new Movie2[a.length];
        
        if(b==1)
        {
                for(int i = 0; i < a.length; i++)
                {
                    String next = a[i].getTitle();
                    int insert = 0;
                    int k = i;
                    
                    while((k>0) && (insert == 0))
                    {
                        if(next.compareTo(newList[k-1].getTitle()) > 0)
                        {
                            insert = k;
                        } else
                        {
                            newList[k] = newList[k-1];
                        }
                        k--;
                    }
                    newList[insert] = a[i];
                }
                return newList;
        } else if(b==2)
        {
                for(int i = 0; i < a.length; i++)
                {
                    String next = a[i].getTitle();
                    int insert = 0;
                    int k = i;
                    
                    while((k>0) && (insert == 0))
                    {
                        if(next.compareTo(newList[k-1].getTitle()) < 0)
                        {
                            insert = k;
                        } else
                        {
                            newList[k] = newList[k-1];
                        }
                        k--;
                    }
                    newList[insert] = a[i];
                }
                return newList;
        } else
        {
                return newList;
        }

    }
    
    public static Movie2[] sortYears(Movie2[] a, int b)
    {
            Movie2[] newList = new Movie2[a.length];
            
            if(b==1)
            {
                for(int i = 0; i < a.length; i++)
                {
                    Movie2 next = a[i];
                    int insert = 0;
                    int k = i;
                    
                    while((k > 0) && (insert == 0))
                    {
                        if(next.getYear() < newList[k-1].getYear())
                        {
                            insert = k;
                        } else
                        {
                            newList[k] = newList[k-1];
                        }
                        k--;
                    }
                    newList[insert] = next;
                }
                return newList;
            } else if(b==2)
            {
                for(int i = 0; i < a.length; i++)
                {
                    Movie2 next = a[i];
                    int insert = 0;
                    int k = i;
                    
                    while((k > 0) && (insert == 0))
                    {
                        if(next.getYear() < newList[k-1].getYear())
                        {
                            insert = k;
                        } else
                        {
                            newList[k] = newList[k-1];
                        }
                        k--;
                    }
                    newList[insert] = a[i];
                }
                return newList;
            } else
            {
                return newList;
            }
    }
    
    public static Movie2[] sortStudios(Movie2[] a, int b)
    {
        Movie2[] newList = new Movie2[a.length];
        
        if(b==1)
        {
            for(int i = 0; i < a.length; i++)
            {
                String next = a[i].getStudio();
                int insert = 0;
                int k = i;
                
                while((k>0) && (insert == 0))
                {
                    if(next.compareTo(newList[k-1].getStudio()) > 0)
                    {
                        insert = k;
                    } else
                    {
                        newList[k] = newList[k-1];
                    }
                    k--;
                }
                newList[insert] = a[i];
            }
            return newList;
        } else if(b==2)
        {
            for(int i = 0; i < a.length; i++)
            {
                String next = a[i].getStudio();
                int insert = 0;
                int k = i;
                
                while((k > 0) && (insert == 0))
                {
                    if(next.compareTo(newList[k-1].getStudio()) < 0)
                    {
                        insert = k;
                    } else
                    {
                        newList[k] = newList[k-1];
                    }
                    k--;
                }
                newList[insert] = a[i];
            }
            return newList;
        } else
        {
            return newList;
        }
    }
    
    public static void printMovies(Movie2[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i].toString());
        }
    }
    
    
    public static void main(String[] args)
    {
        Movie2 muppets = new Movie2("The Muppets Take Mahattan",2001,"Columbia Tristar");
        Movie2 mulan = new Movie2("Mulan Special Edition",2004,"Disney");
        Movie2 shrek = new Movie2("Shrek 2",2004,"Dreamworks");
        Movie2 incredibles = new Movie2("The Incredibles",2004,"Pixar");
        Movie2 nanny = new Movie2("Nanny McPhee",2006,"Universal");
        Movie2 rabbit = new Movie2("The Curse of Were-Rabbit", 2006,"Aardman");
        Movie2 iceage = new Movie2("Ice Age",2002,"20th Century Fox");
        Movie2 lilo = new Movie2("Lilo & Stitch",2002,"Disney");
        Movie2 robots = new Movie2("Robots",2005,"20th Century Fox");
        Movie2 monsters = new Movie2("Monsters Inc.",2001,"Pixar");
        Movie2[] movies = new Movie2[] {muppets, mulan, shrek, incredibles, nanny, rabbit, iceage, lilo, robots, monsters};
        
        Movie2[] newmovies = new Movie2[movies.length];
        
        System.out.println("Before Sorting:");
        System.out.println("----------------------------------------------");
        printMovies(movies);
        System.out.println();
        
        System.out.println("Sorted by Title - ascending:");
        System.out.println("----------------------------------------------");
        newmovies = sortTitles(movies,1);
        printMovies(newmovies);
        System.out.println();
        
        System.out.println("Sorted by Year - descending:");
        System.out.println("----------------------------------------------");
        newmovies = sortYears(movies,2);
        printMovies(newmovies);
        System.out.println();
        
        System.out.println("Sorted by Studio:");
        System.out.println("----------------------------------------------");
        newmovies = sortStudios(movies,1);
        printMovies(newmovies);
    }
}
