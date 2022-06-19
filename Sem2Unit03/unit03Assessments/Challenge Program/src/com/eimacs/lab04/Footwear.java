package src.com.eimacs.lab04;

/**
 *
 * @author Sreeya Gambhirrao
 * @version 1.0 04/03/2022
 */
public class Footwear
{
    private String myStyle;
    private double mySize;
    private String mySKU;
    
    public Footwear(String style, double size, String sku)
    {
        myStyle = style;
        mySize = size;
        mySKU = sku;
    }
    
    public String getStyle()
    {
        return myStyle;
    }
    
    public double getSize()
    {
        return mySize;
    }
    
    public String getSKU()
    {
        return mySKU;
    }

    public String getType()
    {
        return "Unspecified";
    }
    
    public String printSize()
  {
      if(mySize % 1 != 0)
      {
          int size = (int)(mySize - 0.5);
          return (Integer.toString(size)) + "\u00bd";
      } else
      {
          return Integer.toString((int)mySize);
      }
  }
  
  public String toString()
  {
    String type = getType();
    String stem = "";
    if ( !"Unspecified".equals( type ) )
      stem = type + " - ";
    return stem + getStyle() + " (size " + printSize() + ")";
  }
   
}


