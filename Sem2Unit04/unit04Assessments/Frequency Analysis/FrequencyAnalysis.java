import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This program counts the number of times each letter appears and convert it to ciphertext 
 * which is used to decode an encrypted message.
 *
 * @author Sreeya Gambhirrao
 * @version 04/16/2022
 */
public class FrequencyAnalysis
{
    // instance variables - replace the example below with your own
    private String inputFile; 

    /**
     * Constructor for objects of class FrequencyAnalysis
     */
    public FrequencyAnalysis(String file)
    {
        // initialise instance variables
        inputFile = file;
    }

   
    public void analyzeFile() throws IOException
    {
        // put your code here
        Scanner inFile = new Scanner(new File(inputFile));
        ArrayList<Integer> upperAlphabetCounters = new ArrayList<Integer>();
        ArrayList<Integer> lowerAlphabetCounters = new ArrayList<Integer>();
        for(int i = 0; i < 26; i++)
        {
            upperAlphabetCounters.add(0);
            lowerAlphabetCounters.add(0);
        }
        
        while(inFile.hasNext())
        {
         String word = inFile.next(); 
         
         for(int i = 0; i < word.length(); i++)
         {
             char letter = word.charAt(i);
             int AsciiValue = (int)letter;
             if(Character.isUpperCase(letter))
             {
                 int counterIndex = AsciiValue - 65;
                 int existingCounter = upperAlphabetCounters.get(counterIndex);
                 upperAlphabetCounters.set(counterIndex, existingCounter + 1);
             } else if (Character.isLowerCase(letter)) {
                int counterIndex = AsciiValue - 97;
                 int existingCounter = upperAlphabetCounters.get(counterIndex);
                 upperAlphabetCounters.set(counterIndex, existingCounter + 1); 
             }
             
         }
        }
        inFile.close();
        System.out.println("Character            Frequency");
        System.out.println("-----------------------------");
        int sum = 0;
        
        for (int index = 0; index < 26; index++) {
            sum += upperAlphabetCounters.get(index);
        }
        
        for (int index = 0; index < 26; index++) {
            System.out.printf("%s %20.2f\n",(char)(index+65), (100 * (upperAlphabetCounters.get(index))/ (double) sum));

        }
        
        PrintWriter outFile = new PrintWriter (new File("plaintextfreq.txt"));

        outFile.println("Character            Frequency");
        outFile.println("-----------------------------");   
        
        for (int index = 0; index < 26; index++) {
            outFile.printf("%s %20.2f\n",(char)(index+65), (100 * (upperAlphabetCounters.get(index))/ (double) sum));

        }
        outFile.close();
    }
}
