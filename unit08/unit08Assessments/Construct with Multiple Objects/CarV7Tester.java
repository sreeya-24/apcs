
/**
 * This program calculates the miles per gallon and gallons per mile for three different cars with different distances and gallons.
 *
 * @author Sreeya Gambhirrao
 * @version 1/16/2022
 */
public class CarV7Tester
{
    //main method
    public static void main(String[] args) {
        //declaring and intializing varibles of car1
        String carType1 = "2015 Toyota Camry";
        int sMiles1 = 44000;
        int eMiles1 = 44200;
        int distance1 = 0;
        double MPG1 = 0.0;
        double gallons1 = 8.5 ;
        double pricePerGallon1 = 2.98;
        double GPM1 = 0.0;
        
        //declaring and intializing varibles of car2
        String carType2 = "2015 Bentley GT";
        int sMiles2 = 44000;
        int eMiles2 = 44200;
        int distance2 = 0;
        double MPG2 = 0.0;
        double gallons2 = 7.5;
        double pricePerGallon2 = 3.03;
        double GPM2 = 0.0;
        
        //declaring and intializing varibles of car3
        String carType3 = "2012 Volkswagen Jetta";
        int sMiles3 = 44000;
        int eMiles3 = 44200;
        int distance3 = 0;
        double MPG3 = 0.0;
        double gallons3 = 10.0;
        double pricePerGallon3 = 4.03;
        double GPM3 = 0.0;
        
        //creating a new object of type CarV3
        CarV7 car1 = new CarV7(carType1, sMiles1,eMiles1, gallons1, pricePerGallon1);
        CarV7 car2 = new CarV7(carType2, sMiles2, eMiles2, gallons2, pricePerGallon2);
        CarV7 car3 = new CarV7(carType3, sMiles3, eMiles3, gallons3, pricePerGallon3);
        
        
        //calling the functions for 1st car
        distance1 = car1.calcDistance1();
        MPG1 = car1.calcMPG1();
        GPM1 = car1.calcGPM1(distance1);
        
        //calling the functions for 2nd car
        distance2 = car2.calcDistance1();
        MPG2 = car2.calcMPG1();
        GPM2 = car2.calcGPM1(distance2);
        
        //calling the functions for 3rd car
        distance3 = car3.calcDistance1();
        MPG3 = car3.calcMPG1();
        GPM3 = car3.calcGPM1(distance3);

        //Printing the results on the console
        System.out.printf("%80s\n", "Gas Mileage Calculations");
        System.out.printf("%s%20s%15s%15s%15s%15s%15s%15s%15s\n", "Type of Car", "Start Miles", "End Miles", "Distance", "Gallons", "Price", "Cost", "Miles/gal", "Gals/miles");
        System.out.println("=========================================================================================================================================");
        System.out.printf("%s%12d%15d%12d%16.1f%18.1f%16.1f%12.2f%14.4f\n", car1.getCarType1(), car1.getStartMiles1(), car1.getEndMiles1(), distance1, car1.getGallonsUsed1(), pricePerGallon1, car1.totalCost1(), MPG1, GPM1);
        System.out.printf("%s%14d%15d%12d%16.1f%18.1f%16.1f%12.2f%14.4f\n", car2.getCarType1(), car2.getStartMiles1(), car2.getEndMiles1(), distance2, car2.getGallonsUsed1(), pricePerGallon2, car2.totalCost1(), MPG2, GPM2);
        System.out.printf("%s%8d%15d%12d%16.1f%18.1f%16.1f%12.2f%14.4f\n", car3.getCarType1(), car3.getStartMiles1(), car3.getEndMiles1(), distance3, car3.getGallonsUsed1(), pricePerGallon3, car3.totalCost1(), MPG3, GPM3);
        
        
    }
}
