/**
 * This assessment runs various methods like getting the longest and shortest string in an 
 * array and getting the substring. It also calculates hypotenuse and gets the min and max 
 * between two numbers.
 * 
 * @author Sreeya Gambhirrao 
 * @version 02/05/2022
 */ 
import java.util.List;

public class ApiPractice {
 /**
  * Finds the hypotenuse of a right triangle given sides a and b.
  * @param a Length of side a.
  * @param b Length of side b.
  * @return Length of hypotenuse.
  */
 public static double hypotenuse(double a, double b) {
  /* Add code here. Fix placeholder return statement. */
  double hypotenuse = Math.sqrt((Math.pow(a,2)) + (Math.pow(b,2)));
  return hypotenuse;
 }
 
 /**
  * Returns the greater of two values. If the values are exactly the same,
  * it returns one of them.
  * @param a First value.
  * @param b Second value.
  * @return Largest value.
  */
 public static double max(double a, double b) {
  /* Add code here. Fix placeholder return statement. */
  double c = 0.0;
  if(a < b)
  {
     c = b; 
  } else if(a > b)
  {
      c = a;
  }
  return c;
 }
 
 /**
  * Returns the smaller of two values. If the values are exactly the same,
  * it returns one of them.
  * @param a First value.
  * @param b Second value.
  * @return Smallest value.
  */
 public static double min(double a, double b) {
  /* Add code here. Fix placeholder return statement. */
  double c = 0.0;
  if(a < b)
  {
   c = a;
  } else if (b < a)
  {
      c = b;
  }
  return c;
 }

 /**
  * Returns the lexicographically greater of two strings. If the values are
  * exactly the same, it returns one of them.
  * @param a First string.
  * @param b Second string.
  * @return Lexicographically greatest string.
  */
 public static String max(String a, String b) {
  /* Add code here. Fix placeholder return statement. */
  int value = a.compareTo(b);
  String string = "";
  if(value < 0)
  {
      string = b;
  } else if(value > 0)
  {
      string = a;
  } else {
     string = a; 
  }
  return string;
 }
 
 /**
  * Returns the lexicographically lesser of two strings. If the values are
  * exactly the same, it returns one of them.
  * @param a First string.
  * @param b Second string.
  * @return Lexicographically lesser string.
  */
 public static String min(String a, String b) {
  /* Add code here. Fix placeholder return statement. */
  int value = a.compareTo(b);
  String string = "";
  if(value < 0)
  {
      string = a;
  } else if(value > 0)
  {
      string = b;
  } else {
      string = a;
  }
  return string;
 }
 
 /**
  * Compares two strings to see if they contain the same text.
  * @param a First string.
  * @param b Second string.
  * @return <code>true</code> if the strings contain the same text,
  * <code>false</code> otherwise.
  */
 public static boolean isSameText(String a, String b) {
  /* Add code here. Fix placeholder return statement. */
  if(a.equals(b))
  {
     return true; 
  } 
  return false;
 }
 
 /**
  * Returns the longest string (the string with the greatest number of
  * characters) out of three strings. If two or more strings have the same
  * number of characters, it returns the first one.
  * @param a First string.
  * @param b Second string.
  * @param c Third string.
  * @return String with the fewest characters.
  */
 public static String getLongestString(String a, String b, String c) {
  /* Add code here. Fix placeholder return statement. */
  if(b.length() <= a.length())
  {
    if(c.length() <= a.length())
    {
        return a;
    } else {
        return c;
    }
  } else{
      if(c.length() <= b.length())
      {
          return b;
      } else {
          return c;
      }
  }
 }
 
 /**
  * Returns the shortest string (the string with the lowest number of 
  * characters) from a list of strings. If two or more strings have the
  * same number of characters, it returns the first one.
  * 
  * If the incoming list is <code>null</code> or contains zero strings, 
  * this method returns <code>null</code>.
  * 
  * @param list List of incoming strings.
  * @return String with the fewest characters.
  */
 public static String getShortestString(List<String> list) {
  /* Add code here. Fix placeholder return statement. */
  String item = "";
  int itemLength = 0;
  int shortestLength = Integer.MAX_VALUE;
  String shortestString = "";
  for(int i = 0; i < list.size(); i++)
  {
      item = list.get(i);
      itemLength = item.length();
      
      if(itemLength < shortestLength)
      {
          shortestLength = itemLength;
          shortestString = item;
      }
  }
  return shortestString;
 }
 
 /**
  * Returns a substring of the incoming string that contains all of the 
  * characters leading up to, but not including, the comma found
  * in the string.
  * @param s A string with a comma somewhere inside of it.
  * @return The substring leading up to the comma.
  */
 public static String getStringBeforeComma(String s) {
  /* Add code here. Fix placeholder return statement. */
  int indexOfComma = s.indexOf(",");
  String stringTillComma = s.substring(0,indexOfComma);
  return stringTillComma;
 }
 
 /**
  * Returns a substring of the incoming string that contains all of the 
  * characters after the comma found inside the string.
  * @param s A string with a comma somewhere inside of it.
  * @return The substring after the comma.
  */
 public static String getStringAfterComma(String s) {
  /* Add code here. Fix placeholder return statement. */
  int indexOfComma = s.indexOf(",");
  String stringAfterComma = s.substring(indexOfComma + 1, s.length());
  return stringAfterComma;
 }
}
