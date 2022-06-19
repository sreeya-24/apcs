
/**
 * The program prints the word "blue" without using println() method.
 *
 * @author Sreeya Gambhirrao
 * @version 11/7/2021
 */
public class ArtWork
{
    public static void main(String[]args)
    {
        System.out.print("See below to see BLUE!\n");
        System.out.print("----------------------------------------------------\n");
        //local variables
                    //B            L             U             E 
        String row1 = "* * * *     *             *         *   * * * * * *";
        String row2 = "*       *   *             *         *   *          ";
        String row3 = "*       *   *             *         *   *          ";
        String row4 = "*       *   *             *         *   *          ";
        String row5 = "* * * *     *             *         *   * * * * * *";
        String row6 = "*       *   *             *         *   *          ";
        String row7 = "*       *   *             *         *   *          ";
        String row8 = "*       *   *             *         *   *          ";
        String row9 = "*       *   *             *         *   *          ";
        String row10= "* * * *     * * * * * *     * * * *     * * * * * *";
        
        //Printing rows
        System.out.print(row1 + "\n" + row2 + "\n" + row3 + "\n" + row4 + "\n" + row5 + "\n" + row5 + "\n" + row6 + "\n" + row7 + "\n" + row8 + "\n" + row9 + "\n" + row10);
    }
}
