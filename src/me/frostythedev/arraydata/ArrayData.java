package me.frostythedev.arraydata;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayData {

    /*
    PROGRAMMERS: Tevin Cole | Jalisa Thompson | Simone Doughlin-Welsh
     */

    /**
     *  Represents the maximum number of rows the program will have
     */
    private int rows;

    /**
     * Represents the maximum number of columns the values array will have
     */
    private int columns;

    // Is the storage 'container' of all data that will be used in our program
    private int[][] values;

    // Contains relevant data corresponding to a row of the values array
    private int[] rowData;

    // Contains relevant data corresponding to a column of the values array
    private int[] colData;

    /**
     * DEFAULT CONSTRUCTOR - Initializes the variables and arrays used within the program to their default values.
     * Returns an instance of this class
     */
    public ArrayData() {
        this.setRows(10);
        this.setColumns(10);

        this.setValues(new int[rows][columns]);
        this.setRowData(new int[rows]);
        this.setColData(new int[columns]);

        for (int r = 0; r < getRows(); r++) {
            getRowData()[r] = 0;
        }
        for (int c = 0; c < getColumns(); c++) {
            getColData()[c] = 0;
        }

        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getColumns(); c++) {
                getValues()[r][c] = 0;
            }
        }
    }


    /**
     * @param nRows - Specifies the amount of rows to have in the values array
     * @param nColumns - Specifies the amount of columns to have in the values array
     * @param startingValue - Specifies the initial value of all members of the values array
     */
    public ArrayData(int nRows, int nColumns, int startingValue) {

        this.setRows(nRows);
        this.setColumns(nColumns);
        this.setValues(new int[rows][columns]);
        this.setRowData(new int[rows]);
        this.setColData(new int[columns]);

        for (int r = 0; r < getRows(); r++) {
            getRowData()[r] = 0;
        }
        for (int c = 0; c < getColumns(); c++) {
            getColData()[c] = 0;
        }

        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getColumns(); c++) {
                getValues()[r][c] = startingValue;
            }
        }

    }

    // SIMONE'S CORNER

    /**
     * This function calculates the sum of each row and column of the values array and store that data in the corresponding
     * index of the rowData or colData array
     */
    void sum() //function to calculate the sums of individual rows and columns
    {

        for (int r = 0; r < getRows(); r++) {
            int rowSum = 0;
            int colSum = 0;

            for (int c = 0; c < getColumns(); c++) {
                rowSum += getValues()[r][c];
                colSum += getValues()[c][r];
            }

            getRowData()[r] = rowSum;
            getColData()[r] = colSum;
        }

    }

    /**
     * @param num - represents the integer to be checked by the function
     *
     * This function will calculate the number of times the integer num or a
     * multiple of num DOES NOT appear in each row and places it in the
     * rowData array. Perform the same action for each column and place
     * the results in the colData array. However, for the columns count
     * the number of times integer num or a multiple of num DOES occur in
     * the columns.
     */
    void occurrence(int num)                    //function to determine the number of times a number or a multiple occurs
    {
        for (int r = 0; r < getRows(); r++) {
            int rOccur = 0;
            int cOccur = 0;

            for (int c = 0; c < getColumns(); c++) {
                if (getValues()[r][c] != num || getValues()[r][c] % num != 0) {
                    rOccur++;
                }

                if (getValues()[c][r] == num || getValues()[c][r] % num == 0) {
                    cOccur++;
                }

                getRowData()[r] = rOccur;
                getColData()[r] = cOccur;
            }
        }
    }

    /**
     * This method will calculate the standard deviation of the integers in
     * each row and place it in the rowData array. It will also calculate the standard deviation of the integers in each row
     * and place it in the colData array.
     */
    void standardDeviation() //function to calculate the standard deviation in each row and column
    {

        double[] rAvg = new double[getRows()], cAvg = new double[getColumns()];
        double[] rSum = new double[getRows()], cSum = new double[getColumns()];
        double[] rDSum = new double[getRows()], cDSum = new double[getColumns()];

        /*double rAvg = 0.0, cAvg = 0.0;
        double rSum = 0, cSum = 0;
        double rDSum = 0, cDSum=0;*/

        // Generates the sum of each column and each row and their averages
        for (int r = 0; r < getRows(); r++) {

            for (int c = 0; c < getColumns(); c++) {
                rSum[r] += getValues()[r][c];
            }
            rAvg[r] = rSum[r] / getRows();
        }

        for (int c = 0; c < getColumns(); c++) {

            for (int r = 0; r < getRows(); r++) {
                cSum[c] += getValues()[r][c];
            }
            cAvg[c] = cSum[c] / getColumns();
        }

        for (int r = 0; r < getRows(); r++) {

            for (int c = 0; c < getColumns(); c++) {

                rDSum[r] += Math.pow((getValues()[r][c] - rAvg[r]), 2);
                //cDSum+= Math.pow((getValues()[c][r]-cAvg), 2);
            }

            double sDevRow = Math.sqrt((rDSum[r] / getRows()));
            getRowData()[r] = (int) sDevRow;
        }

        //double sDevCol = Math.sqrt((cDSum / getColumns()));

        for (int c = 0; c < getColumns(); c++) {

            for (int r = 0; r < getRows(); r++) {

                cDSum[c] += Math.pow((getValues()[r][c] - cAvg[c]), 2);

            }
            double sDevCol = Math.sqrt((cDSum[c] / getColumns()));
            getColData()[c] = (int) sDevCol;
        }

    }

    // JALISA'S CORNER

    /**
     * @param newValue - Represents the default value to put in the newely generated
     * @param total - represents how many times a new value will be generated for placement into the values array
     * @param minRow - represents the index of the minimum row which would be considered for replacement,
     *               a row lower than this value will not be considered
     * @param maxRow - represents the index of the maximum row which would be considered for replacement,
     *               a row higher than this value will not be considered
     * @param minCol - represents the index of the minimum column which would be considered for replacement,
     *      *               a column lower than this value will not be considered
     * @param maxCol - represents the index of the maximum row which would be considered for replacement,
     *      *               a column higher than this value will not be considered
     *
     *  This method will randomly choose 'total' positions in the values
     * array and change the value to newValue.
     */
    void generate(int newValue, int total, int minRow, int maxRow, int minCol, int maxCol) {
        Random rnd = new Random();

        for (int i = 0; i < total; i++) {

            int randR = rnd.nextInt((minRow), (maxRow + 1));
            int randC = rnd.nextInt((minCol), (maxCol + 1));

            getValues()[randR][randC] = newValue;

        }
    }

    /**
     * @param num - Represents the total number of values that will be changed to the value 'val'
     * @param val - Represents the new value that would replace selected integers of the values array
     */
    void flip(int num, int val) {
        Random rand = new Random();

        for (int i = 0; i < num; i++) {
            int rowPosition = rand.nextInt(getRows());
            int columnPosition = rand.nextInt(getColumns());

            getValues()[rowPosition][columnPosition] = val;
        }
    }

    // TEVIN'S CORNER

    /**
     * @return a double representing the quotient of the odd and even 'checked' values of the values array
     *
     * This method will sum the values in the odd positions within the
     * values array. This is followed by summing the values I, the even
     * positions. The method will return the result of dividing the odd sum
     * by the even sum.
     */
    double checkeredOdd() {

        double oddSum = 0, evenSum = 0;

        for (int y = 0; y < getRows(); y++) {
            for (int x = 0; x < getColumns(); x++) {

                if (y % 2 == 0) { // This means the row is EVEN

                    if (x % 2 == 0) { // This means the column is EVEN
                        evenSum += getValues()[y][x];

                    } else { // The column is ODD

                        oddSum += getValues()[y][x];
                    }

                } else { // This Row is ODD

                    if (x % 2 == 0) { // This column is EVEN
                        oddSum += getValues()[y][x];

                    } else { // The Column is ODD

                        evenSum += getValues()[y][x];
                    }
                }
            }
        }

        return (oddSum / evenSum);
    }

    /**
     * @param min Sets the minimum threshold that the product of the row should NOT fall in
     * @param max sets the maximum threshold that the product of the row should NOT fall in
     *
     * This method will calculate the product of each row and column. The
     * method starts with the rows then the columns i.e. multiply all the
     * numbers in the row or column. If the product (multiplication) in the
     * row is between min and max (including min and max) then this
     * method will randomly decrement a member of the row, by 1, until
     * the product is less than min. A similar procedure is used for the product of the Columns as
     */
    void product(int min, int max) {

        // Product of the columns two

        for (int y = 0; y < getRows(); y++) {
            int rowProd = rowProduct(y);

            while (rowProd > (min - 1) && rowProd < (max + 1)) {
                //System.out.println("rowProd is within range");
                randDecrementRow(y);
                rowProd = rowProduct(y);
            }

            getRowData()[y] = rowProd;
        }

        // Product of the rows

        for (int x = 0; x < getColumns(); x++) {
            int colProd = colProduct(x);

            while (colProd > (min - 1) && colProd < (max + 1)) {
                //System.out.println("rowProd is within range");
                randDecrementCol(x);
                colProd = colProduct(x);
            }

            getColData()[x] = colProd;
        }
    }

    /**
     * This method formats the specified the maximum rows and columns of the values array into a readable format as well as the
     * latest corresponding rowData and colData calculations
     */
    void print() {
        print(getRows(), getColumns());
    }

    /**
     * @param rows - Specifies how many rows to print
     * @param columns - Specifies how many columns to print
     *
     * This method formats the specified rows and columns of the values array into a readable format as well as the
     *                latest corresponding rowData and colData calculations
     */
    void print(int rows, int columns) {

        if (rows > getRows() || columns > getColumns()) {
            // error
            System.out.println("You have entered a row or column that is greater than the maximum limit allowed.");
            return;
        }

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {

                if (x != (columns - 1)) {
                    System.out.print(getValues()[y][x] + "|");
                } else {
                    System.out.print(getValues()[y][x] + "||" + getRowData()[y] + "\n");
                }
            }
        }

        System.out.print("\n");

        for (int i = 0; i < columns; i++) {
            if (i != (columns - 1)) {
                System.out.print(getColData()[i] + "|");
            } else {
                System.out.print(getColData()[i] + "");
            }
        }

        System.out.print("\n");
    }

    /**
     * @param rowIndex - Corresponding rowIndex from values array to decrement from
     *
     * This method randomly decrements a member value of the specified row
     */
    // UTILITY FUNCTIONS
    private void randDecrementRow(int rowIndex) {
        if (rowIndex > getRows() || rowIndex < 0) {
            // error
            System.out.printf("rowIndex exceeds available range [0-%d]. Please supply another number.\n", getRows());
            return;
        }

        Random rnd = new Random();
        int ranIndex = rnd.nextInt(getColumns());

        //System.out.println("randIndex: " + ranIndex + " | old: " + (getValues()[rowIndex][ranIndex]) +  " | new: " + (getValues()[rowIndex][ranIndex]-1));

        getValues()[rowIndex][ranIndex] = (getValues()[rowIndex][ranIndex] - 1);
    }

    /**
     * @param colIndex - Corresponding colIndex from values array to decrement from
     *
     * This method randomly decrements a member value of the specified column
     */
    private void randDecrementCol(int colIndex) {
        if (colIndex > getRows() || colIndex < 0) {
            // error
            System.out.printf("colIndex exceeds available range [0-%d]. Please supply another number.\n", getColumns());
            return;
        }

        Random rnd = new Random();
        int ranIndex = rnd.nextInt(getRows());

        //System.out.println("randIndex: " + ranIndex + " | old: " + (getValues()[rowIndex][ranIndex]) +  " | new: " + (getValues()[rowIndex][ranIndex]-1));

        getValues()[ranIndex][colIndex] = (getValues()[ranIndex][colIndex] - 1);
    }

    /**
     * @param rowIndex - Specifies the row of the values array to perform calculations on
     * @return an int representing the product of all members of the row
     */
    private int rowProduct(int rowIndex) {
        int rowProd = 1;
        for (int i = 0; i < getColumns(); i++) {
            //System.out.println("[" + i + "] " + " Multiplying " + rowProd + " by " + getValues()[rowIndex][i]);
            rowProd *= getValues()[rowIndex][i];
        }
        return rowProd;
    }

    /**
     * @param colIndex - Specifies the column of the values array to perform calculations on
     * @return an int representing the product of all members of the colum
     */
    private int colProduct(int colIndex) {
        int colProd = 1;
        for (int i = 0; i < getRows(); i++) {
            //System.out.println("[" + i + "] " + " Multiplying " + rowProd + " by " + getValues()[rowIndex][i]);
            colProd *= getValues()[i][colIndex];
        }
        return colProd;
    }


    /*
    * GETTERS AND SETTERS FOR THE FIELDS AND VARIABLES OF OUR ARRAYDATA CLASS
     */
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    public int[] getRowData() {
        return rowData;
    }

    public void setRowData(int[] rowData) {
        this.rowData = rowData;
    }

    public int[] getColData() {
        return colData;
    }

    public void setColData(int[] colData) {
        this.colData = colData;
    }
}
