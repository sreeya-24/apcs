package src.com.eimacs.lab04;
import java.util.ArrayList;

/**
 * Write a description of class Bin here.
 *
 * @author Sreeya Gambhirrao
 * @version 1.0 04/03/2022
 */
public class Bin
{
  private String myName;
  ArrayList<BinItem> myContents;
  
  public Bin(String name)
  {
      myName = name;
      myContents = new ArrayList<BinItem>();
  }
  
  public String getName()
  {
      return myName;
  }
  
  public ArrayList<BinItem> getContents()
  {
      return myContents;
  }
  
  public String toString()
  {
      String returnString = "Bin "+getName() +":";
      String binItem = "";
      
      for(int i = 0; i < myContents.size(); i++)
      {
          binItem += "\nSKU " + myContents.get(i).getSKU() + ": " + myContents.get(i).getQuantity();
      }
      String form = returnString + binItem;
      return form;
  }
  
  public void remove(int i)
  {
      myContents.remove(i);
  }
  
  public int totalQuantity()
  {
      int total = 0;
      for(int i = 0; i < myContents.size(); i++)
      {
         total += myContents.get(i).getQuantity();
      }
      return total;
  }
  
  public void add(BinItem b)
  {
      int tem = 0;
      boolean added = false;
   
      for( int i = 0; i < myContents.size(); i++)
      {
          if (myContents.get(i).getSKU().equals(b.getSKU()))
              {
                 tem = myContents.get(i).getQuantity() + b.getQuantity();
                 myContents.remove(i);
                 myContents.add(new BinItem(b.getSKU(), tem));
                 tem = 0;
                 added = true;
                 break;
              }
      }   
      if (!added)
      {
          myContents.add(b);
      }
  } 
}