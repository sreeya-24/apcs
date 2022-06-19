
/**
 * This program counts the number of times each letter appears and convert it to ciphertext 
 * which is used to decode an encrypted message.
 *
 * @author Sreeya Gambhirrao
 * @version 04/16/2022
 */
import java.io.File;
import java.io.IOException;

public class FrequencyAnalysisTester
{
    public static void main(String[] args) throws IOException
    {
        FrequencyAnalysis frequency = new FrequencyAnalysis("plaintext.txt");
        
        frequency.analyzeFile();
        
        
    }
}
