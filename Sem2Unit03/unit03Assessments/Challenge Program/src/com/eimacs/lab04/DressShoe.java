package src.com.eimacs.lab04;

/**
 *
 * @author Sreeya Gambhirrao
 * @version 1.0 04/03/2022
 */
public class DressShoe extends Shoe
{
    public DressShoe(String style, double size, String sku )
    {
        super(style,size,sku);
    }
    
    public String getType()
    {
        return "Dress Shoe";
    }
}
