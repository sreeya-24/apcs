
/**
 * This class encrypts the user message.
 *
 * @author Sreeya Gambhirrao
 * @version 04/10/2022
 */

public class CaesarShiftEncryption
{
    // instance variables
    private String message;
    private final int shiftKey;

    /**
     * Constructor for objects of class CaesarShiftEncryption
     */
    public CaesarShiftEncryption(String msg, int key)
    {
        message = msg;
        shiftKey = key;
    }

    /**
     * get method for message.
     */
    public String getMesssage()
    {
        return message;
    }
    
    /**
     * get method for the shift method
     */
    public int getShiftKey()
    {
        return shiftKey;
    }
    
    /**
     * method for encrypting
     */
    public String encrypt()
    {
        String output = "";
        
        for(int i =0; i < message.length(); i++)
        {
            char c = message.charAt(i);
            
            int shiftChar = (((int)c + shiftKey - 65)%26)+65;
            output += (char)shiftChar;
        }
        
        return output;
    }
    
    
}
