class Testing
{
    private String language;
    private double version;
    
    Testing(String language, double version)
    {
        this.language = language;
        this.version = version;
    }
    
    public String toString()
    {
        return(this.language + "  " + this.version);
    }
}

public class Tester
{
    public static void main(String[] args)
    {
        Testing example1 = new Testing("Java", 5.0); 
        Testing example2 = new Testing("Java", 6.0);
        
        System.out.println("Ex 1: " + example1); //uses toString() method
        System.out.println("Ex 2: " + example2); //uses toString() method
    }
}
