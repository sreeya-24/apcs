
/**
 * This program calculates the miles per gallons and the total for each columns and the 
 * annual projection.
 *
 * @author Sreeya Gambhirrao
 * @version 1/16/2022
 */
public class AnnualFuelUseTester
{
    //Max and Min for max for distance, MPG,and price
    public static int minimumDistance(AnnuelFuelUse[] fillUpsArray) {
        int minDistance = Integer.MAX_VALUE;
        for (int i =0 ; i< fillUpsArray.length; i++) {
            if (fillUpsArray[i].getDistance() < minDistance) {
                minDistance = fillUpsArray[i].getDistance();
            }
        }
        return minDistance;
    }
    
    public static int maximumDistance(AnnuelFuelUse[] fillUpsArray) {
        int maxDistance = Integer.MIN_VALUE;
        for (int i =0 ; i< fillUpsArray.length; i++) {
            if (fillUpsArray[i].getDistance() > maxDistance) {
                maxDistance = fillUpsArray[i].getDistance();
            }
        }
        return maxDistance;
    }
    
    public static double minimumMPG(AnnuelFuelUse[] fillUpsArray) {
        double minMPG = Double.MAX_VALUE;
        for (int i = 0 ; i< fillUpsArray.length; i++) {
            if (fillUpsArray[i].getMPG() < minMPG) {
                minMPG = fillUpsArray[i].getMPG();
            }
        }
        return minMPG;
    }
    
    public static double maximumMPG(AnnuelFuelUse[] fillUpsArray) {
        double maxMPG = Double.MIN_VALUE;
        for (int i =0 ; i< fillUpsArray.length; i++) {
            if (fillUpsArray[i].getMPG() > maxMPG) {
                maxMPG = fillUpsArray[i].getMPG();
            }
        }
        return maxMPG;
    }
    
    public static double minimumPrice(AnnuelFuelUse[] fillUpsArray) {
        double minPrice = Double.MAX_VALUE;
        for (int i = 0 ; i < fillUpsArray.length; i++) {
            if (fillUpsArray[i].getPrice() < minPrice) {
                minPrice = fillUpsArray[i].getPrice();
            }
        }
        return minPrice;
    }
    
    public static double maximumPrice(AnnuelFuelUse[] fillUpsArray) {
       double maxPrice = Double.MIN_VALUE;
        for (int i =0 ; i < fillUpsArray.length; i++) {
            if (fillUpsArray[i].getPrice() > maxPrice) {
                maxPrice = fillUpsArray[i].getPrice();
            }
        }
        return maxPrice;
    }
    
    //calculating total distance, gallons, and cost
    public static int totalDistance(AnnuelFuelUse[] fillUpsArray) {
        int totalDistance = 0;
        for (int  i =0; i< fillUpsArray.length; i++) {
            totalDistance += fillUpsArray[i].getDistance();
        }
        return totalDistance;
    }
    
    public static double totalGallons(AnnuelFuelUse[] fillUpsArray) {
        int totalGallons = 0;
        for (int  i =0; i< fillUpsArray.length; i++) {
            totalGallons += fillUpsArray[i].getGallonsUsed();
        }
        return totalGallons;
    }
    
    public static double totalCost(AnnuelFuelUse[] fillUpsArray) {
        int totalcost = 0;
        for (int  i =0; i< fillUpsArray.length; i++) {
            totalcost += fillUpsArray[i].getTotalCost();
        }
        return totalcost;
    }
    
    //main function
    public static void main(String[] args) {
        //Array declarazation and intialzation 
        AnnuelFuelUse[] fillUpsArray = new AnnuelFuelUse[5];
        fillUpsArray[0] = new AnnuelFuelUse(1,12,44000, 44200,8.5, 2.95);
        fillUpsArray[1] = new AnnuelFuelUse(1,19,44200, 44415,9.0, 2.99);
        fillUpsArray[2] = new AnnuelFuelUse(3,25,44415, 44500,5.0, 3.01);
        fillUpsArray[3] = new AnnuelFuelUse(4,1,44500, 44590,9.0, 3.15);
        fillUpsArray[4] = new AnnuelFuelUse(5,9,44590, 44640,7.0, 2.95);
        
        System.out.printf("%s%10s%20s%20s%20s%20s%20s%20s%18s\n", "Fill Up", "Days", "Start Miles", "End Miles", "Distance", "Gallons Used", "MPG", "Price", "Cost");
        
        //printing out each column
        for(int index = 0; index < fillUpsArray.length; index++)
        {
            System.out.printf("%5d%10d%20d%20d%20d%15.2f%29.2f%18.2f%18.2f\n", fillUpsArray[index].getFillUp(), fillUpsArray[index].getDays(), fillUpsArray[index].getStartMiles(), fillUpsArray[index].getEndMiles(), fillUpsArray[index].getDistance(), fillUpsArray[index].getGallonsUsed(), fillUpsArray[index].getMPG(), fillUpsArray[index].getPrice(), fillUpsArray[index].getTotalCost());

        }
        System.out.println();
        System.out.printf("%s%67d%44.2f%18.2f\n","Minimum:",minimumDistance(fillUpsArray), minimumMPG(fillUpsArray), minimumPrice(fillUpsArray));
        System.out.printf("%s%67d%44.2f%18.2f\n\n","Maximum:",maximumDistance(fillUpsArray), maximumMPG(fillUpsArray), maximumPrice(fillUpsArray));
        System.out.printf("%s%69d%15.2f%66.2f\n","Total:",totalDistance(fillUpsArray), totalGallons(fillUpsArray), totalCost(fillUpsArray));

        //calculating annual projection
        int distanceProjection = (totalDistance(fillUpsArray)/fillUpsArray.length)*12;
        double gallonsProjection = (totalGallons(fillUpsArray)/fillUpsArray.length)*12;
        double mpgProjection = (double)distanceProjection/gallonsProjection;
        double totalCostProjection = (totalCost(fillUpsArray)/fillUpsArray.length)*12;
        
        //printing annual projection
        System.out.printf("%s%56d%15.2f%29.2f%37.2f\n","Annual Projections:",distanceProjection, gallonsProjection, mpgProjection, totalCostProjection);


        
        
    }
}
