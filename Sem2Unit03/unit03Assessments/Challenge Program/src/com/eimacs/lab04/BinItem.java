package src.com.eimacs.lab04;


/**
 * Write a description of class BinItem here.
 *
 * @author Sreeya Gambhirrao
 * @version 1.0 04/03/2022
 */
public class BinItem
{
  private String mySKU;
  private int myQuantity;
  
  public BinItem(String sku, int quantity)
  {
      mySKU = sku;
      myQuantity = quantity;
  }
  
  public String getSKU()
  {
      return mySKU;
  }
  
  public int getQuantity()
  {
      return myQuantity;
  }
  
  public String toString()
  {
      return "SKU " + getSKU() + ": " + getQuantity();
  } 
}