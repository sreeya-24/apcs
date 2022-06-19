
/**
 * This class adds randomly selected Integers to two ArrayLists
 * then calculates the sum of the values in the first and second 
 * ArrayList and adds the value to the third ArrayList.  Last, the
 * third ArrayList is printed out showing how each successive sum
 * is added to the answers ArrayList.
 * 
 * @author B. Jordan 
 * @version 06/05/07
 */
import java.util.*;                                         //import the ArrayList class
public class CalculationsWithArrayLists2
{
    public static void main(String[] args)                          //header for the main method
    {  
        List<Integer> numList1 = new ArrayList<Integer>();     //declares an ArrayList of Integers
        List<Integer> numList2 = new ArrayList<Integer>();     //declares an ArrayList of Integers
        List<Integer> answers = new ArrayList<Integer>();      //declares an ArrayList of Integers
        
        int rndNumber;                                              //declares a random number
        
        for(int i = 0; i < 20; i ++)                                //initializes, tests, and increments the loop index variable
        {
            rndNumber = (int)(Math.random() * 100);                 //select a random number from 0 - 99             
            numList1.add(rndNumber);                                //inserts the first random number into the first ArrayList                             
            rndNumber = (int)(Math.random() * 100);                 //select a random number from 0 - 99
            numList2.add(rndNumber);                                //inserts the second random number into the second ArrayList
        }
            
        System.out.println(numList1);                               //prints the first ArrayList                            
        System.out.println(numList2);                               //prints the second ArrayList
            
        for(int i = 0; i < numList1.size(); i++)                    //initializes, tests, and increments the loop index variable
        {
            answers.add(numList1.get(i) + numList2.get(i));         //gets a radom number from index position i in the first and second array, 
                                                                    //calculaetes the sum, and assigns the value to index position i in the answers ArrayList.
            System.out.println(answers);                            //prints the values one at a time as they are inserted into the third ArrayList
        }
    }
}<html>
    <head>
        <title>Runtime Error</title>
        <style>
         body {font-family:"Verdana";font-weight:normal;font-size: .7em;color:black;} 
         p {font-family:"Verdana";font-weight:normal;color:black;margin-top: -5px}
         b {font-family:"Verdana";font-weight:bold;color:black;margin-top: -5px}
         H1 { font-family:"Verdana";font-weight:normal;font-size:18pt;color:red }
         H2 { font-family:"Verdana";font-weight:normal;font-size:14pt;color:maroon }
         pre {font-family:"Lucida Console";font-size: .9em}
         .marker {font-weight: bold; color: black;text-decoration: none;}
         .version {color: gray;}
         .error {margin-bottom: 10px;}
         .expandable { text-decoration:underline; font-weight:bold; color:navy; cursor:hand; }
        </style>
    </head>

    <body bgcolor="white">

            <span><H1>Server Error in '/' Application.<hr width=100% size=1 color=silver></H1>

            <h2> <i>Runtime Error</i> </h2></span>

            <font face="Arial, Helvetica, Geneva, SunSans-Regular, sans-serif ">

            <b> Description: </b>An application error occurred on the server. The current custom error settings for this application prevent the details of the application error from being viewed remotely (for security reasons). It could, however, be viewed by browsers running on the local server machine.
            <br><br>

            <b>Details:</b> To enable the details of this specific error message to be viewable on remote machines, please create a &lt;customErrors&gt; tag within a &quot;web.config&quot; configuration file located in the root directory of the current web application. This &lt;customErrors&gt; tag should then have its &quot;mode&quot; attribute set to &quot;Off&quot;.<br><br>

            <table width=100% bgcolor="#ffffcc">
               <tr>
                  <td>
                      <code><pre>

&lt;!-- Web.Config Configuration File --&gt;

&lt;configuration&gt;
    &lt;system.web&gt;
        &lt;customErrors mode=&quot;Off&quot;/&gt;
    &lt;/system.web&gt;
&lt;/configuration&gt;</pre></code>

                  </td>
               </tr>
            </table>

            <br>

            <b>Notes:</b> The current error page you are seeing can be replaced by a custom error page by modifying the &quot;defaultRedirect&quot; attribute of the application's &lt;customErrors&gt; configuration tag to point to a custom error page URL.<br><br>

            <table width=100% bgcolor="#ffffcc">
               <tr>
                  <td>
                      <code><pre>

&lt;!-- Web.Config Configuration File --&gt;

&lt;configuration&gt;
    &lt;system.web&gt;
        &lt;customErrors mode=&quot;RemoteOnly&quot; defaultRedirect=&quot;mycustompage.htm&quot;/&gt;
    &lt;/system.web&gt;
&lt;/configuration&gt;</pre></code>

                  </td>
               </tr>
            </table>

            <br>

    </body>
</html>
