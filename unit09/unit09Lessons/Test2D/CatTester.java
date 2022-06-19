
/**
 * Write a description of class CatTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CatTester {

    public static void main(String[] args) {

        Cat[][] catapults = new Cat[7][7];
        int speed;

        for(int row = 0; row < catapults.length; row++) {
            speed = 20 + 5 * row;
            for(int column = 0; column <catapults.length; column++)
            {
                catapults[row][column] = new Cat(speed, 25 + 5 * column);
            }
        }
        System.out.println("                      Projectile Distance (feet)                      ");
        System.out.println("MPH   25 Deg   30 Deg   35 Deg   40 Deg   45 Deg   50 Deg   55 Deg    ");
        System.out.println();
        System.out.println("======================================================================");

        for (Cat[] catapult : catapults) {
            System.out.printf("%2.0f ", catapult[0].getVelocity());
            for (int column = 0; column < catapults.length; column++) {
                catapult[column].calcDistance();
                System.out.printf("%8.1f ", catapult[column].getDistance());
            }
            System.out.printf("\n");
        }
    }

}