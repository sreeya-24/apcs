
/**
 * This programs converst feet to miles, miles to feet, miles to kilometers, kilometers to miles, 
 * pounds to kilograms, kilograms to pounds, gallons to liters, and liters to gallons.
 * 
 * @author Sreeya Gambhirrao 
 * @version 1/5/2022
 */
public class MeasurementConverterV2
{
//Purpose of program
    public static void printPurpose( )  //notice that this method is void, nothing is returned
    {
        System.out.println("This program converts to and from");
        System.out.println("English and metric units of measure.");
        System.out.println("=====================================");
    }
        
    //convert feet to miles
    //the ft parameter receives the value of the feet argument passed from main method. 
    public static double convertFeetToMiles(double ft)
    {
        return ft / 5280;      
    } 
    
    //convert miles to feet
    public static double convertMilesToFeet(double mi)
    {
        return mi * 5280;      
    } 
    
    //convert miles to kilometers
    public static double convertMilesToKilometers(double mi)
    {
        //return statement calculate kilometers goes here      
        return mi * 1.60934;
    } 
    
    //convert kilometers to miles
    public static double convertKilometersToMiles(double km)
    {
        //return statement to calculate miles goes here   
        return km/1.60934;
    } 
    
    //convert pounds to kilograms
    //method header to convert pounds to kilograms goes here
    public static double convertPoundsToKilograms(double lbs)
    {
        //return statement to calculate kilograms goes here    
        return lbs * 0.453592;
    } 
    
    //convert kilograms to pounds
    // method header to convert kilograms to pounds goes here
    public static double convertKilogramsToPounds(double kg)
    {
        //return statement to calculate pounds goes here  
        return kg/0.453592;
    } 
    
    public static double convertGallonsToLiters(double g)
    {
        return g * 3.78541;
    }
    
    public static double convertLitersToGallons(double L)
    {
        return L/3.78541;
    }
    
    public static double convertInchesToFeet(double in)
    {
        return in/12;
    }
    
    public static double convertFeetToInches(double ft)
    {
        return ft * 12;
    }
    
    
    
        
    public static void main(String[ ] args)
    {
        //local variables
        //double miles, feet, inches, pounds, gallons;
        //double kilometers, kilograms, liters;
        
        //variable declaration and initialization
    
        printPurpose();                                    //invoke the printPurpose() method
        double feet = 6230;
        double miles = convertFeetToMiles(feet);            //invoke the convertFeetToMiles() static method and pass the feet variable as an argument
        System.out.printf("%8.1f ft. = %7.1f mi. %n", feet, miles);
        
        miles = 1.9;
        feet = convertMilesToFeet(miles);
        System.out.printf("%8.1f mi. = %7.1f ft. %n", miles, feet);
        
        miles = 22.3;
        double kilometers = convertMilesToKilometers(miles);
        System.out.printf("%8.1f mi. = %7.1f km. %n", miles, kilometers);
        
        kilometers = 1000.0;
        //call method to convert kilometers to miles goes here
        //print results goes here
        miles = convertKilometersToMiles(kilometers);
        System.out.printf("%8.1f km. = %7.1f m. %n", kilometers, miles);
        
        double pounds = 204;
         //call method to convert pounds to kilograms goes here
        //print results goes here
        double kilograms = convertPoundsToKilograms(pounds);
        System.out.printf("%8.1f lbs. = %7.1f kg. %n", pounds, kilograms);
        
        //declare and initialize the kilograms variable goes here
        kilograms = 1000.0;
        //call method to convert kilograms to pounds goes here
        //print results goes here
        pounds = convertKilogramsToPounds(kilograms);
        System.out.printf("%8.1f kg. = %7.1f lbs. %n", kilograms, pounds);
        
        //declare and initialize the gallons variable goes here
        double gallons = 100.0;
        //call method to convert gallons to liters goes here
        //print results goes here
        double liters = convertGallonsToLiters(gallons);
        System.out.printf("%8.1f gal. = %7.1f L. %n", gallons, liters);
        
        //declare and initialize the liters variable goes here
        liters = 100.0;
        //call method to convert liters to gallons goes here
        //print results goes here
        gallons = convertLitersToGallons(liters);
        System.out.printf("%8.1f L. = %7.1f gal. %n", liters, gallons);
        
        double inches = 48;
        feet = convertInchesToFeet(inches);
        System.out.printf("%8.1f in. = %7.1f ft. %n", inches, feet);
        
        feet = 10;
        inches = convertFeetToInches(feet);
        System.out.printf("%8.1f ft. = %7.1f in. %n", feet, inches);
           
    }//end of main method
    
}//end of class


