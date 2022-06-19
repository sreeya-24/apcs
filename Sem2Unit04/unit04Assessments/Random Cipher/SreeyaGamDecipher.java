
/**
 * This class is for decryption.
 *
 * @author Sreeya Gambhirrao
 * @version 4/15/2022
 */
public class SreeyaGamDecipher
{
    // instance variables - replace the example below with your own
    private String message;
    private final int shiftKey;

    /**
     * Constructor for objects of class CaesarShiftEncryption
     */
    public SreeyaGamDecipher(String msg, int key)
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
            if (c != ' ') {
                int shiftChar = (((int)c + (26-shiftKey) - 65)%26)+65;
                output += (char)shiftChar;
            } else {
                output += c;
            }
        }
        
        return output;
    }
}
