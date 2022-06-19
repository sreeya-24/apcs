
/**
 * This project demonstrates the concept of abstraction, interfaces, 
 * implementation, and the comparable interface.
 *
 * @author Sreeya Gambhirrao
 * @version 04/18/2022
 */
import java.util.ArrayList;
public class InventoryDemo
{
    public static ArrayList<Product> product = new ArrayList<Product>();

    public static void main(String[] args)
    {
        
        Car car1 = new Car("Jaguar",1000000.00);
        Car car2 = new Car("Neon",17000.00);
        
        Tool tool1 = new Tool("Jigsaw",149.18);
        
        Car car3 = new Car("Jaguar",110000.00);
        Car car4 = new Car("Neon",17500.00);
        Car car5 = new Car("Neon",17875.32);
        
        Truck truck1 = new Truck("RAM",35700.00);
        
        Tool tool2 = new Tool("CircularSaw",200.00);
        Tool tool3 = new Tool("CircularSaw",150.00);
        
        product.add(car1);
        product.add(car2);
        product.add(tool1);
        product.add(car3);
        product.add(car4);
        product.add(car5);
        product.add(truck1);
        product.add(tool2);
        product.add(tool3);
        
        takeInventory("Jigsaw");
        takeInventory("Neon");
        takeInventory("Jaguar");
        takeInventory("RAM");
        takeInventory("CircularSaw");
        
        if(tool1.compareTo(tool2) == 1)
        {
            System.out.println("The first saw is more expensive.");
        } else if(tool1.compareTo(tool2) == 0)
        {
            System.out.println("They are the same price.");
        } else
        {
            System.out.println("The second saw is more expensive.");
        }
        
    }
    
    public static void takeInventory(String name)
    {
        int counter = 0;
        double totalCost = 0.0;
        
        for(Product p : product)
        {
            if(p.getName().equalsIgnoreCase(name))
            {
            counter++;
            totalCost += p.getCost();
            }
        }
        
        System.out.println(name + ": Quantity = " + counter + ", Total Cost = " + totalCost);
    }
}
