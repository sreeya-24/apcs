package src.com.eimacs.lab04;

/**
 *
 * @author Sreeya Gambhirrao
 * @version 1.0 04/03/2022
 */
public class Shoe extends Footwear
{
    public Shoe(String style, double size, String sku)
    {
        super(style,size,sku);
    }
    
    public String getType()
    {
        return "Shoe";
    }
}
