
/**
 * This program converts an english statement to morse code format.
 *
 * @author Sreeya Gambhirrao
 * @version 04/09/2022
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class MorseCode
{
    private static ArrayList<Character> alphabet = new ArrayList<Character>();
    private static ArrayList<String> morseCode = new ArrayList<String>();
    private static String statement;
    
    /**
     * Constructor for objects of class MorseCode2
     */
    public MorseCode(String s) throws IOException
    {
       statement = s;
       getDataForArray();
    }

    /**
     * This method reads through the file and adds it to the array
     *
     */
    public static void getDataForArray() throws IOException
    {
        File data = new File("morsecode.txt");
        Scanner in = new Scanner(data);
        
        while(in.hasNext())
        {
            String morse = in.next();
            morseCode.add(morse);
        }
        in.close();
    }
    
    /**
     * This method converts the statement into morse code using ascii values.
     */
    public static void convStatement() 
    {
        statement = statement.toUpperCase();
        char[] statementCharArray = statement.toCharArray();
        String output = "";
        //System.out.println(morseCode);
        int index = 0;
        String morse=" ";
        for(int i = 0; i < statementCharArray.length; i++)
        {
            if(Character.isLetter(statementCharArray[i]))
            {
               index = (int)statementCharArray[i] - 65; 
               morse = morseCode.get(index);
            } else if(Character.isDigit(statementCharArray[i]))
            {
               index = (int)statementCharArray[i] - 22;
               morse = morseCode.get(index);
            } else {
                morse = " ";
            }
            
            output += morse;
        }
        
        System.out.println("In Morse: " + output);
    }
        
}
