
/**
 * This program sort movies by title, year, and studio by using merge sorting.
 *
 * @author Sreeya Gambhirrao
 * @version 04/30/2022
 */
public class TestMovie4
{
    public static Movie4[] myMovies = new Movie4[10];
   
   public static void addMovies()
   {
          Movie4 m1 = new Movie4("The Muppets Take Manhattan",2001, "Columbia Tristar");  
          Movie4 m2 = new Movie4("Mulan Special Edition",2004, "Disney");  
          Movie4 m3 = new Movie4("Shrek 2",2004, "Dreamworks");  
          Movie4 m4 = new Movie4("The Incredibles",2004, "Pixar");  
          Movie4 m5 = new Movie4("Nanny McPhee",2006,"Universal");  
          Movie4 m6 = new Movie4("The Curse of the Were-Rabbit",2006, "Aardam");
          Movie4 m7 = new Movie4("Ice Age ",2002,"20th Century Fox");
          Movie4 m8 = new Movie4("Lilo & Stitch",2002,"Disney");
          Movie4 m9 = new Movie4("Robots",2005,"20th Century Fox");
          Movie4 m10 = new Movie4("Monsters Inc.",2001, "Pixar");
          
          myMovies[0] = m1;
          myMovies[1] = m2;
          myMovies[2] = m3;
          myMovies[3] = m4;
          myMovies[4] = m5;
          myMovies[5] = m6;
          myMovies[6] = m7;
          myMovies[7] = m8;
          myMovies[8] = m9;
          myMovies[9] = m10;       
   }
   
   public static void sortTitles(Movie4[] movies, int low, int high)
   {
       if(low == high)
       {
           return;
       }
       
       
       int mid = (low + high)/2;
       sortTitles(movies, low, mid);
       sortTitles(movies, mid + 1, high);
       
       mergeTitles(movies, low, mid, high);
       
   }
   
   public static void sortYears(Movie4[] movies, int low, int high)
   {
       if(low == high)
       {
           return;
       }
       
       
       int mid = (low + high)/2;
       sortTitles(movies, low, mid);
       sortTitles(movies, mid + 1, high);
       
       mergeYears(movies, low, mid, high);
   }
   
   public static void sortStudios(Movie4[] movies, int low, int high)
   {
       if(low == high)
       {
           return;
       }
       
       
       int mid = (low + high)/2;
       sortTitles(movies, low, mid);
       sortTitles(movies, mid + 1, high);
       
       mergeStudios(movies, low, mid, high);
   }
   
   public static void mergeTitles( Movie4[] movies, int low, int mid, int high )
    {
        Movie4[] temp = new Movie4[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while ( i <= mid || j <= high )
        {
            if ( i > mid )
            {
                temp[ n ] = movies[ j ];
                j++;
            }
            else if ( j > high )
            {
                temp[ n ] = movies[ i ];
                i++;
            }
            else if ( movies[ i ].getTitle().compareTo(movies[ j ].getTitle()) > 1)
            {
                temp[ n ] = movies[ i ];
                i++;
            }
            else
            {
                temp[ n ] = movies[ j ];
                j++;
            }
            n++;
        }

        for ( int k = low ; k <= high ; k++ )
            movies[ k ] = temp[ k - low ];

    }
    
   public static void mergeYears( Movie4[] movies, int low, int mid, int high )
    {
        Movie4[] temp = new Movie4[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while ( i <= mid || j <= high )
        {
            if ( i > mid )
            {
                temp[ n ] = movies[ j ];
                j++;
            }
            else if ( j > high )
            {
                temp[ n ] = movies[ i ];
                i++;
            }
            else if ( movies[ i ].getYear() < movies[ j ].getYear())
            {
                temp[ n ] = movies[ i ];
                i++;
            }
            else
            {
                temp[ n ] = movies[ j ];
                j++;
            }
            n++;
        }

        for ( int k = low ; k <= high ; k++ )
            movies[ k ] = temp[ k - low ];

    }
    
   public static void mergeStudios( Movie4[] movies, int low, int mid, int high )
    {
        Movie4[] temp = new Movie4[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while ( i <= mid || j <= high )
        {
            if ( i > mid )
            {
                temp[ n ] = movies[ j ];
                j++;
            }
            else if ( j > high )
            {
                temp[ n ] = movies[ i ];
                i++;
            }
            else if ( movies[ i ].getTitle().compareTo(movies[ j ].getTitle()) > 1)
            {
                temp[ n ] = movies[ i ];
                i++;
            }
            else
            {
                temp[ n ] = movies[ j ];
                j++;
            }
            n++;
        }

        for ( int k = low ; k <= high ; k++ )
            movies[ k ] = temp[ k - low ];

    }  
    
   public static void printMovies(Movie4[] movies)
   {
       for(int i = 0; i < movies.length; i++)
       {
           System.out.println(movies[i].toString());
       }
   }
    
   public static void main(String[] args)
   {
       System.out.println("Before Sorting:");
       printMovies(myMovies);
       System.out.println();
        
        System.out.println("Sorted by Title - ascending:");
        sortTitles(myMovies,0,9);
        printMovies(myMovies);
        System.out.println();
        
        System.out.println("Sorted by Year - descending:");
        sortYears(myMovies,0,9);
        printMovies(myMovies);
        System.out.println();
        
        System.out.println("Sorted by Studios:");
        sortStudios(myMovies,0,9);
        printMovies(myMovies);
   }

}
