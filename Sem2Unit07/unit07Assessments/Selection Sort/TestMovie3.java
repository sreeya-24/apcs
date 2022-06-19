
/**
 * This program sorts an array of movies by their title, year, and studio using 
 * selection sorting.
 *
 * @author Sreeya Gambhirrao
 * @version 04/30/2022
 */
public class TestMovie3
{
   public static Movie3[] myMovies = new Movie3[10];
   
   public static void addMovies()
   {
          Movie3 m1 = new Movie3("The Muppets Take Manhattan",2001, "Columbia Tristar");  
          Movie3 m2 = new Movie3("Mulan Special Edition",2004, "Disney");  
          Movie3 m3 = new Movie3("Shrek 2",2004, "Dreamworks");  
          Movie3 m4 = new Movie3("The Incredibles",2004, "Pixar");  
          Movie3 m5 = new Movie3("Nanny McPhee",2006,"Universal");  
          Movie3 m6 = new Movie3("The Curse of the Were-Rabbit",2006, "Aardam");
          Movie3 m7 = new Movie3("Ice Age ",2002,"20th Century Fox");
          Movie3 m8 = new Movie3("Lilo & Stitch",2002,"Disney");
          Movie3 m9 = new Movie3("Robots",2005,"20th Century Fox");
          Movie3 m10 = new Movie3("Monsters Inc.",2001, "Pixar");
          
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
   
   public static String [] sortTitles(Movie3[] movies, int sortOrder)
   {
       int posmax, posmin;
       String temp;
       
       String [] titles = new String[movies.length];
       for (int i = 0; i< movies.length; i++) {
           titles[i] = movies[i].getTitle();
       }
       
        if (sortOrder == 1)
        {
             for(int i = titles.length - 1; i >=0; i--)
             {
                 posmax = 0;
                 
                 for(int k = 0; k <= i; k++)
                 {
                     if(titles[k].compareTo(titles[posmax]) >1 ) {
                         posmax = k;
                     } 
                 }
                 
                 temp = titles[i];
                 titles[i] = titles[posmax];
                 titles[posmax] = temp;
                 
             }
        } else if (sortOrder == 2) {
            for(int i = titles.length - 1; i >=0; i--)
             {
                 posmin = 0;
                 
                 for(int k = 0; k <= i; k++)
                 {
                     if(titles[k].compareTo(titles[posmin]) < 1 ) {
                         posmin = k;
                     } 
                 }
                 
                 temp = titles[i];
                 titles[i] = titles[posmin];
                 titles[posmin] = temp;
                 
             }
        }
        return titles;
   }
   
   public static Integer[] sortYears(Movie3[] movies, int sortOrder)
   {
       int posmax, posmin;
       int temp;
       
       Integer [] years = new Integer[movies.length];
       for (int i = 0; i< movies.length; i++) {
           years[i] = movies[i].getYear();
       }
       
        if (sortOrder == 1)
        {
             for(int i = years.length - 1; i >=0; i--)
             {
                 posmax = 0;
                 
                 for(int k = 0; k <= i; k++)
                 {
                     if(years[k] > years[posmax]) {
                         posmax = k;
                     } 
                 }
                 
                 temp = years[i];
                 years[i] = years[posmax];
                 years[posmax] = temp;
                 
             }
        } else if (sortOrder == 2) {
            for(int i = years.length - 1; i >=0; i--)
             {
                 posmin = 0;
                 
                 for(int k = 0; k <= i; k++)
                 {
                     if(years[k] < years[posmin]) {
                         posmin = k;
                     } 
                 }
                 
                 temp = years[i];
                 years[i] = years[posmin];
                 years[posmin] = temp;
                 
             }
        }
        return years;
   }
   
   public static String[] sortStudios(Movie3[] movies, int sortOrder)
   {
       int posmax, posmin;
       String temp;
       
       String [] studios = new String[movies.length];
       for (int i = 0; i< movies.length; i++) {
           studios[i] = movies[i].getStudio();
       }
       
        if (sortOrder == 1)
        {
             for(int i = studios.length - 1; i >=0; i--)
             {
                 posmax = 0;
                 
                 for(int k = 0; k <= i; k++)
                 {
                     if(studios[k].compareTo(studios[posmax]) >1 ) {
                         posmax = k;
                     } 
                 }
                 
                 temp = studios[i];
                 studios[i] = studios[posmax];
                 studios[posmax] = temp;
                 
             }
        } else if (sortOrder == 2) {
            for(int i = studios.length - 1; i >=0; i--)
             {
                 posmin = 0;
                 
                 for(int k = 0; k <= i; k++)
                 {
                     if(studios[k].compareTo(studios[posmin]) < 1 ) {
                         posmin = k;
                     } 
                 }
                 
                 temp = studios[i];
                 studios[i] = studios[posmin];
                 studios[posmin] = temp;
                 
             }
        }
        return studios;
   }
   
   public static void printMovies(Movie3[] movies)
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
        sortTitles(myMovies,1);
        printMovies(myMovies);
        System.out.println();
        
        System.out.println("Sorted by Year - descending:");
        sortYears(myMovies,2);
        printMovies(myMovies);
        System.out.println();
        
        System.out.println("Sorted by Studios:");
        sortStudios(myMovies,1);
        printMovies(myMovies);
   }
   
}
