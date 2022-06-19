/**
 * MeasuermentConverter_v1 converts to and from Metric and English
 * units of measure.
 * 
 *      Sample Calculation:
 *        1 mile = 5280 ft, therefore    6230 ft / 5280 = 1.7992 miles
 *                      
 * �FLVS 2021
 * @author Sreeya Gambhirrao
 * @version 10/20/21
 * 
 * Modified by: (Sreeya Gambhirrao)
 * Date: (10/24/2021)
 * This program converts selected units of measurements.
 */
public class MeasurementConverterV1
{
    public static void main(String[ ] args)
    {    
        //local variable declarations - assign actual values below
        double miles;                   // distance in miles
        double feet; // distance in feet
        double kilometers;
        double pounds;
        double kilograms;
        double liters;
        double gallons;
        double inches;
        //...finish declaring local variables here, including end of line 
        //...comments doccumenting purpose of each variable
       
        System.out.println("****************************************************");
        System.out.println();
        System.out.println("            This program converts between \n            selected units of measurment.");
        System.out.println();
        System.out.println("****************************************************");
        
        //convert feet to miles
        feet = 6230;
        miles = feet / 5280;
        System.out.println(feet + " ft. = " + miles + " mi.");
        
        
        //convert miles to feet
        feet = miles * 5280;
        System.out.println(miles + " mi. = " + feet + " ft. ");
        
        //convert miles to kilometers
        kilometers = 0.62 * miles;
        System.out.println(miles + " mi. = " + kilometers + " km. ");
        
        //convert kilometers to miles
        miles = kilometers/0.62;
        System.out.println(kilometers + " km. = " + miles + " mi. ");
       
        //convert pounds to kilograms
        pounds = 100;
        kilograms = pounds * 2.3;
        System.out.println(pounds + " lbs. = " + kilograms + " kg. ");
        
        //convert kilograms to pounds
        pounds = kilograms/2.3;
        System.out.println(kilograms + " kg. = " + pounds + " lbs. ");
        
        //convert gallons to liters
        gallons = 200;
        liters = gallons * 0.26;
        System.out.println(gallons + " g. = " + liters + " L. ");
        
        //convert liters to gallons
        gallons = liters/0.26;
        System.out.println(liters + " L. = " + gallons + " g. ");
        
        //convert feet to inches
        feet = 50;
        inches = feet * 12;
        System.out.println(feet + " ft. = " + inches + " in. ");
        
        //convert inches to feet
        feet = inches/12;
        System.out.println(inches + " in. = " + feet + " ft. ");
        
    }//end of main method
}//end of class

