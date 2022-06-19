
/**
 * The purpose of this program is to demonstrate the use of several 
 * methods of the String class.
 * 
 * FLVS 2007
 * @author B. Jordan 
 * @version 03/08/07
 */
public class StringPractice
{
    public static void main(String[ ] args)
    {
        //determine the length of the String object called odString
        String oldString = "Four score and seven years ago";
        //String input1 = "407-317-3326";
        System.out.println("Old string: " + oldString);
        int stringLength = oldString.length();
        System.out.println("Number of characters: " + stringLength);        
        System.out.println();
           
        //replace characters within the String object
        String replaceCharacters = oldString.replace("Four", "4");
        replaceCharacters = replaceCharacters.replace("seven", "7");
        System.out.println("Replacement characters: " + replaceCharacters);
        System.out.println();
        
        //split the String object and reassemble in reverse
         oldString = "407-317-3326";
        stringLength = oldString.length();
        int halfwayPoint = stringLength /2; // 6
        String firstHalf = "(" + oldString.substring(0, 3); //(407
        
        String secondHalf = ")" + oldString.substring(3, stringLength);//)-317-3326
        
        String splitString = firstHalf + secondHalf;
        System.out.println("Split string: " + splitString);
        System.out.println(); 
        
        System.out.println(oldString.substring(0,3) + "." + oldString.substring(4, 7) + "." + oldString.substring(8, stringLength));
        System.out.println(oldString.replaceAll("-", "."));
        
        oldString = "03/07/2007";
        System.out.println(oldString.replaceAll("/", "-"));
        
       
        
    }//end of main method
}//end of class
