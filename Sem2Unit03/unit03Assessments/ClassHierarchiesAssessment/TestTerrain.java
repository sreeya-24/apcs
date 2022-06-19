
/**
 * This project takes one super class, divides it into three different subclasses and uses class hierarchy to print out the 
 * dimensions and its attributes.
 *
 * @author Sreeya Gambhirrao
 * @version 03/19/2022
 */
public class TestTerrain
{
    public static void main(String[] args)
    {
        Terrain terrain = new Terrain(400,400);
        Mountain mountain = new Mountain(300,400,25);
        Forest forest = new Forest(100,200,100);
        WinterMountain winterMountain = new WinterMountain(500,600,15,10);
        
        System.out.println("Mountain " + mountain.terrainSize() + " and has " + mountain.getNumOfMountains() + " mountains.");
        System.out.println();
        System.out.println("Forest " + forest.terrainSize() + " and has " + forest.getNumOfTrees() + " trees.");
        System.out.println();
        System.out.println("Winter Mountain " + winterMountain.terrainSize() + " and has temperature of " + winterMountain.getTemperature() + " and has " + winterMountain.getNumOfMountains() + " mountains.");
        System.out.println();
    }
}
