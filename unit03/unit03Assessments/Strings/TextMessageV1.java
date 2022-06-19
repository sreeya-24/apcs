
/**
 * This program takes a couple of phrases from one text message and abbreviates them in the same text message.
 *
 * @author Sreeya Gambhirrao
 * @version 11/7/2021
 */
public class TextMessageV1
{
    public static void main(String[] args)
    {
        //Printing original message and length
        String textMessage = "for your information, i don't know if i will be able to finish the homework because this weekend I am going out.";
        System.out.println("Original Message: " + textMessage);
        int stringLength = textMessage.length();
        System.out.println("Number of characters of Original Message: " + stringLength);
        
        //replace phrases 
        String textMessage1 = textMessage.replaceAll("for your information","FYI"  );   
        String textMessage2 = textMessage1.replaceAll("i don't know","idk");
        String textMessage3 = textMessage2.replaceAll("homework","hw");
        String textMessage4 = textMessage3.replaceAll("because","bc");
        String textMessage5 = textMessage4.replaceAll("weekend","wknd");
        System.out.println();
        
        //Printing out new message and length
        System.out.println("New Message: " + textMessage5);
        int stringLength1 = textMessage5.length();
        System.out.println("Number of characters of New Message: " + stringLength1);
        
        
        
    }
}
