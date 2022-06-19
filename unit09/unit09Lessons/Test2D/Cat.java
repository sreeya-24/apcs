
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat {

    private double velocity, degrees, distance;

    public Cat(double v, double deg) {
        velocity = v;
        degrees = deg;
    }

    public double getVelocity(){
        return velocity;
    }

    public double getDegrees(){
        return degrees;
    }

    public double getDistance(){
        return distance;
    }

    public void calcDistance(){
        distance = (Math.pow(velocity, 2) * Math.sin( 2 * Math.toRadians(degrees)) / 9.8);
    }

}