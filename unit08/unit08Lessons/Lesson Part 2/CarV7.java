
/**
 * Write a description of class CarV7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarV7 {

    private String carType;
    private int endMiles;
    private int startMiles;
    private double gallonsUsed;
    private double pricePerGallon;
    private double costOfTrip;
    private double milesPerGallon;
    private double gallonsPerMile;

    public CarV7(String type, int endMi, int startMi, double galUsed, double pricePerGal, double costOfGals) {
        carType = type;
        endMiles = endMi;
        startMiles = startMi;
        gallonsUsed = galUsed;
        pricePerGallon = pricePerGal;
        costOfTrip = costOfGals;
        milesPerGallon = milesPerGallon;
        gallonsPerMile = gallonsPerMile;
    }

    public int calcDistance() {
        return endMiles - startMiles;
    }

    public String getType() {
        return carType;
    }

    public int getStartMiles() {
        return startMiles;
    }

    public int getEndMiles() {
        return endMiles;
    }

    public double getGallonsUsed() {
        return gallonsUsed;
    }

    public double getPricePerGallon() {
        return pricePerGallon;
    }

    public double calcGPM() {
        return gallonsUsed / calcDistance();
    }

    public double calcMPG() {
        return calcDistance() / gallonsUsed;
    }

    public double calcCost() {
        double cost = (gallonsUsed * pricePerGallon);
        return cost;
    }

}