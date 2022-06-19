
/**
 * This is the Item class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/30/2022
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemID;
    private String itemName;
    private int inStore;
    private double price;

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemID, String itemName, int inStore, double price)
    {
        // initialise instance variables
        this.itemID = itemID;
        this.itemName = itemName;
        this.inStore = inStore;
        this.price = price;
    }

    public String getItemID()
    {
        return itemID;
    }
    
    public void setItemID(String itemID)
    {
        this.itemID = itemID;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    
    public int getInStore()
    {
        return inStore;
    }
    
    public void setInStore(int inStore)
    {
        this.inStore = inStore;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public String toString()
    {
        return String.format("%s%16s%9d$6s%5.2f", itemID, itemName, inStore, "$", price);
    }
}
