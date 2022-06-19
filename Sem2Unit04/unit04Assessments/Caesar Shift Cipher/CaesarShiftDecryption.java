
/**
 * This class decrypts the user's message.
 *
 * @author Sreeya Gambhirrao
 * @version 04/10/2022
 */
public class CaesarShiftDecryption
{
    // instance variables - replace the example below with your own
    private String message;
    private final int shiftKey;

    /**
     * Constructor for objects of class CaesarShiftEncryption
     */
    public CaesarShiftDecryption(String msg, int key)
    {
        message = msg;
        shiftKey = key;
    }

    /**
     * get method for message
     */
    public String getMesssage()
    {
        return message;
    }
    
    /**
     * get method for the shift key
     */
    public int getShiftKey()
    {
        return shiftKey;
    }
    
    /**
     * method for decrypting
     */
    public String decrypt()
    {
        String output = "";
        
        for(int i = 0; i < message.length(); i++)
        {
            char c = message.charAt(i);
            
            int shiftChar = (((int)c + (26-shiftKey) - 65)%26)+65;
            output += (char)shiftChar;
        }
        
        return output;
    }
    
    
}

