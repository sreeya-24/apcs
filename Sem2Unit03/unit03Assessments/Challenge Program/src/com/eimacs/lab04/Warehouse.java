package src.com.eimacs.lab04;
import java.util.ArrayList;

/**
 * This is a class from the Lab04.
 *
 * @author Sreeya Gambhirrao
 * @version 1.0 04/03/2022
 */
public class Warehouse
{
  private int myBinMax;
  private ArrayList<Footwear> myCatalog;
  private ArrayList<Bin> myBins;

  public Warehouse( int binMax )
  {
    myBinMax = binMax;
    myCatalog = new ArrayList<Footwear>();
    myBins = new ArrayList<Bin>( 5 );
    for ( int i = 0; i < 5; i++ )
      addBin();
  }

  public void addBin()
  {
    myBins.add( new Bin( "B" + myBins.size() ) );
  }

  public String toString()
  {
    String s = "";
    for ( Bin bin : myBins )
    {
      if ( s.length() > 0 )
        s += "\n";
        s += "Bin " + bin.getName() + ":";
      for ( BinItem item : bin.getContents() )
      {
        s += "\n" + Lab04Runner.lookupFootwear( myCatalog,
                                                item.getSKU() )
              + ", " + item;
      }
    }
    return s;
  }
  
  public void receive(Footwear fw, int units) {
      boolean exists = false;
      for (Footwear item : myCatalog) {
          if (item.equals(fw)) {
              exists = true;
              break;
          }
      }
      if (!exists) {
          myCatalog.add(fw);
      }
      
      int maxquantity = myBinMax;
      Bin binToAdd = null;
      int tempunits = units;
      boolean flag= false;
      
      
          for (Bin bin: myBins) {
              int totalQuantity = 0;
              for (BinItem bItem : bin.getContents()) {
                  totalQuantity += bItem.getQuantity();
              }
              
              if (tempunits > 0 && totalQuantity < myBinMax) {
                      int te = myBinMax - totalQuantity;
                      if (tempunits < te) {
                          bin.add((new BinItem(fw.getSKU(), tempunits)));
                          tempunits = 0;
                      } else {
                        bin.add((new BinItem(fw.getSKU(), te)));
                        tempunits -= te;
                      }
  
                      
              }
          }

      while (tempunits > 0) {
          addBin();
          if (tempunits <= myBinMax) {
                myBins.get(myBins.size()-1).add((new BinItem(fw.getSKU(), tempunits)));
                  tempunits =0;
          } else {
                myBins.get(myBins.size()-1).add((new BinItem(fw.getSKU(), myBinMax)));
                  tempunits -= myBinMax;
          }

      }
      

}
}
