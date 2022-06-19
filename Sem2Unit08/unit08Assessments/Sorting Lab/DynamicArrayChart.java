 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Provides a GUI frame that contains a dynamic chart representing an array
 * being sorted.
 */
public class DynamicArrayChart extends JFrame {
    private String sortName;
    private int[] array;
    private boolean includeBuffer;
    private int pauseInMs;
    private final int ARRAY_LOWER_BOUND = 1;
    private final int ARRAY_UPPER_BOUND = 50;
    private int maxArrayValue;
    private ArrayChart chart;

    /**
     * Creates a DynamicArrayChart with custom parameters.
     * @param sortName Name of the sorting algorithm being demonstrated.
     * @param array An array with 1-20 ints with values ranging from 1-50.
     * @param includeBuffer <code>true</code> if the sorting algorithm being
     * demonstrated involves storing a value while other values in the array
     * are being moved.
     * @param pauseInMs Number of milliseconds between each step of the 
     * demonstration. 250 milliseconds are recommended. 10 milliseconds are the
     * recommended minimum; a value less than 10 milliseconds would be too fast
     * to observe. Enter a higher number to observe the demonstration slowly.
     * @throws InvalidArgumentException Thrown if an argument is null.
     * @throws InvalidArrayException Thrown if the array does not meet the
     * above specifications.
     */
    public DynamicArrayChart(String sortName, int[] array, 
        boolean includeBuffer, int pauseInMs) {
        
        super("Sorting Labs");
        
        this.sortName = sortName;
        this.array = array;
        this.includeBuffer = includeBuffer;
        this.pauseInMs = pauseInMs;
        
        if (sortName == null) throw new IllegalArgumentException(
            "Sort name cannot be null.");
        
        if (array == null) throw new IllegalArgumentException(
            "Array cannot be null.");
        if (array.length == 0) throw new IllegalArgumentException(
            "Array must have at least one element.");
        if (array.length > 20) throw new IllegalArgumentException(
            "Array size cannot exceed 20.");
        
        for (int i : array) {
            if (i < ARRAY_LOWER_BOUND) throw new IllegalArgumentException(
                "Array values must be " + ARRAY_LOWER_BOUND + " or greater.");
            if (i > ARRAY_UPPER_BOUND) throw new IllegalArgumentException(
                "Array values cannot be greater than " + 
                ARRAY_UPPER_BOUND + ".");
            if (i > maxArrayValue) maxArrayValue = i;
        }
        
        setupGui();
    }
    
    /**
     * Sets up the JFrame, the sort label, and the array chart.
     */
    private void setupGui() {
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Title
        JLabel title = new JLabel(sortName);
        title.setFont(new Font(Font.SERIF, Font.ITALIC, 24));
        title.setBackground(Color.WHITE);
        title.setOpaque(true);
        Border paddingBorder = BorderFactory.createEmptyBorder(10,15,10,15);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        title.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
        title.setMaximumSize(new Dimension(800, 54));
        add(title, BorderLayout.NORTH);
        
        // Chart
        chart = new ArrayChart();
        add(chart);
        setVisible(true);
    }
    
    /**
     * Returns the length of the array being sorted.
     * @return The length of the array being sorted.
     */
    public int getArrayLength() {
        return array.length;
    }
    
    /**
     * Nested class that provides a graphical representation of the array.
     * Since the object created from this class is only useful to the
     * enclosing class, and can benefit from having access to the members of
     * the enclosing class, ArrayChart is designed as nested.
     */
    private class ArrayChart extends JPanel {
        private final Font NUMBER_FONT = new Font("Serif", Font.PLAIN, 22);
        private final FontMetrics fm = this.getFontMetrics(NUMBER_FONT);
        private final int BORDER = 20;
        private final int TEXT_SPACE = 20;
        private final int BUFFER_SPACE = 10;
        private final int X_SPACE = 794;
        private final int Y_SPACE = 518;
        private final int USABLE_X_SPACE = X_SPACE - BORDER * 2;
        private final int USABLE_Y_SPACE = Y_SPACE - BORDER * 2 - TEXT_SPACE;
        private final int COLUMN_WIDTH;
        private final int START_X_FOR_COLUMNS;
        private final int START_X_FOR_BUFFER;
        private final int Y_STEP;
        private final int Y_BASE = BORDER + TEXT_SPACE + USABLE_Y_SPACE;
        private final Color BASE_COLOR = Color.CYAN;
        private final Color Q1_COLOR = Color.YELLOW;
        private final Color Q2_COLOR = Color.ORANGE;
        private final Color MIN_COLOR = Color.PINK;
        private final Color BUFFER_COLOR = Color.WHITE;
        private final Color INSERT_COLOR = Color.WHITE;
        private final Color DONE_COLOR = Color.GREEN;
        private final Color BACKGROUND_COLOR = getBackground();
        
        public ArrayChart() {
            if (includeBuffer) {
                COLUMN_WIDTH = (USABLE_X_SPACE - BUFFER_SPACE) / 
                    (array.length + 1);
                START_X_FOR_BUFFER = (USABLE_X_SPACE - BUFFER_SPACE -
                    COLUMN_WIDTH * (array.length + 1)) / 2 + BORDER;
                START_X_FOR_COLUMNS = START_X_FOR_BUFFER + COLUMN_WIDTH +
                    BUFFER_SPACE;
            } else {
                COLUMN_WIDTH = USABLE_X_SPACE / array.length;
                START_X_FOR_BUFFER = 0;
                START_X_FOR_COLUMNS = (USABLE_X_SPACE - COLUMN_WIDTH * 
                    array.length) / 2 + BORDER;
            }
            Y_STEP = USABLE_Y_SPACE / maxArrayValue;
        }
        
        /**
         * Draws all of the content to this component.
         * 
         * @param g Graphics object supplied by the Swing framework.
         */
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(BACKGROUND_COLOR);
            Rectangle2D clear = 
                new Rectangle2D.Double(0, 0, X_SPACE, Y_SPACE);
            g2.fill(clear);
            
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) continue;
                int height = array[i] * Y_STEP;
                int xPos = START_X_FOR_COLUMNS + i * COLUMN_WIDTH;
                int yPos = Y_BASE - height;
                g2.setPaint(BASE_COLOR);
                if (lastAction.equals(Action.QUERY_FOR_SWAP)) {
                    if (i == indexA) g2.setPaint(Q1_COLOR);
                    else if (i == indexB) g2.setPaint(Q2_COLOR);
                    else if (i == minIndex) g2.setPaint(MIN_COLOR);
                } else if (lastAction.equals(Action.SWAP)) {
                    if (i == indexA) g2.setPaint(Q2_COLOR);
                    else if (i == indexB) g2.setPaint(Q1_COLOR);
                } else if (lastAction.equals(Action.COPY_TO_BUFFER)) {
                    if (i == bufferIndex) g2.setPaint(BUFFER_COLOR);
                } else if (lastAction.equals(Action.MOVE)) {
                } else if (lastAction.equals(Action.INSERT)) {
                    if (i == insertIndex) g2.setPaint(INSERT_COLOR);
                } else if (lastAction.equals(Action.DONE)) {
                    g2.setPaint(DONE_COLOR);
                }
                String message = "" + array[i];
                printColumn(g2, xPos, yPos, height, message);
            }
            if (bufferInUse) {
                int bufferHeight = Y_STEP * bufferValue;
                g2.setPaint(BUFFER_COLOR);
                printColumn(g2, START_X_FOR_BUFFER, Y_BASE - bufferHeight,
                    bufferHeight, "" + bufferValue);
            }
        }
        
        /**
         * Helper method that prints individual chart columns.
         * @param g2 Graphics object to draw to.
         * @param xPos X position of rectangle to draw.
         * @param yPos Y position of rectangle to draw.
         * @param height Height of rectangle to draw.
         * @param message Value to display above rectangle.
         */
        private void printColumn(Graphics2D g2, int xPos, int yPos, int height, 
                String message) {
            Rectangle2D rect = 
                new Rectangle2D.Double(xPos, yPos, COLUMN_WIDTH, height);
            g2.fill(rect);
            g2.setPaint(Color.BLACK);
            g2.draw(rect);
            g2.setFont(NUMBER_FONT);
            int messageWidth = fm.stringWidth(message);
            g2.drawString(message,
                xPos + (COLUMN_WIDTH - messageWidth) / 2, yPos - 5);
        }
    }
    
    /**
     * Enumeration providing different actions that are indicated as various
     * methods are called.
     */
    private enum Action {
        NONE, QUERY_FOR_SWAP, SWAP, COPY_TO_BUFFER, MOVE, INSERT, DONE
    }
    
    private Action lastAction = Action.NONE;
    private int indexA, indexB;
    private int minIndex;

    /**
     * To be called when performing a swap-based sort when comparing the first
     * of two values.
     * @param index Index of the first value being considered.
     * @return Value of array element at specified index.
     */
    public int getValueForSwap1(int index) {
        lastAction = Action.QUERY_FOR_SWAP;
        indexA = index;
        minIndex = indexA;
        return array[index];
    }
    
    /**
     * To be called when performing a swap-based sort when comparing the second
     * of two values. Triggers a painting of the two values being examined.
     * The first value will be yellow. The second value will be orange.
     * @param index Index of the first value being considered.
     * @return Value of array element at specified index.
     */
    public int getValueForSwap2(int index) {
        lastAction = Action.QUERY_FOR_SWAP;
        indexB = index;
        chart.repaint();
        pause();
        return array[index];
    }

    /**
     * To be called when performing a swap-based sort when scanning values and
     * keeping track of the minimum value encountered so far. The minimum value
     * will show up as a pink column in the chart.
     * @param index Index of element to be marked as the minimum value found
     * so far.
     */
    public void markAsMin(int index) {
        minIndex = index;
    }
    
    /**
     * Swaps two values during a swap-based sort. Triggers a painting of the
     * two values in swapped order.
     * @param indexA First value to be swapped.
     * @param indexB Second value to be swapped.
     */
    public void swap(int indexA, int indexB) {
        lastAction = Action.SWAP;
        this.indexA = indexA;
        this.indexB = indexB;
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        chart.repaint();
        pause();
    }
    
    /**
     * To be called when getting a value during a sort that involves shifting
     * array values. Does not trigger special coloring of the columns.
     * @param index Index of the array being examined.
     * @return Value of array element at specified index.
     */
    public int getValueForMove(int index) {
        return array[index];
    }

    private int bufferIndex;
    private int bufferValue;
    private boolean bufferInUse = false;
    
    /**
     * To be called when considering a new value during a sort that involves
     * shifting array values. This is the value being removed only to be
     * reinserted into a new position in the array after other elements have
     * been moved aside to make a space. Triggers a special drawing of the
     * buffered value off to the left of the rest of the chart.
     * @param index
     * @return
     */
    public int copyToBuffer(int index) {
        if (!includeBuffer) throw new InvalidConfigurationException();
        lastAction = Action.COPY_TO_BUFFER;
        bufferIndex = index;
        bufferValue = array[index];
        bufferInUse = true;
        chart.repaint();
        pause();
        return array[index];
    }
    
    /**
     * Moves a value from one index to another. Sets the value at the vacated
     * index to zero. Triggers a drawing of the new chart.
     */
    public void moveIndexElement(int indexFrom, int indexTo) {
        lastAction = Action.MOVE;
        array[indexTo] = array[indexFrom];
        array[indexFrom] = 0;
        chart.repaint();
        pause();
    }

    private int insertIndex;
    
    /**
     * Inserts a value at an index. Triggers a drawing of the inserted value.
     * @param insertIndex Location in array to insert the value.
     * @param value Value to insert.
     */
    public void insert(int insertIndex, int value) {
        lastAction = Action.INSERT;
        array[insertIndex] = value;
        this.insertIndex = insertIndex;
        bufferInUse = false;
        chart.repaint();
        pause();
    }
    
    /**
     * Tells the chart that sorting is done. Triggers a drawing of the chart
     * in the done color.
     */
    public void setDone() {
        lastAction = Action.DONE;
        bufferInUse = false;
        chart.repaint();
    }
    
    /**
     * Pauses the demonstration for the amount of milliseconds specified by 
     * pauseInMs.
     */
    private void pause() {
        try { 
            Thread.sleep(pauseInMs); 
        } catch (InterruptedException e) {
            System.out.println("Pause exception: " + e);
        } 
    }
}
