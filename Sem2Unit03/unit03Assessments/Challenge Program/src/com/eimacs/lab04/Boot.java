package src.com.eimacs.lab04;

/**
 *
 * @author Sreeya Gambhirrao
 * @version 1.0 04/03/2022
 */
public class Boot extends Footwear
{
    public Boot(String style, double size, String sku)
    {
        super(style,size,sku);
    }
    
    public String getType()
    {
        return "Boot";
    }
}
