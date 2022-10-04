package me.frostythedev.arraydata;

import me.frostythedev.arraydata.core.GroupMember;
import java.util.Random;

public class Jalisa extends GroupMember {

    public Jalisa(int rows, int columns, int[][] values, int[] rowData, int[] colData) {
        super(rows, columns, values, rowData, colData);
    }

    @Override
    public void test()
    {
       ArrayData();
    }

    void ArrayData()
    {
        setRows(10);
        setColumns(10);

        setValues(new int[0][0]);
        setRowData(new int[0]);
        setColData(new int [0]);
    }

    void ArrayData(int nRows, int nColumns)
    {
         this.setRows(nRows);
         this.setColumns(nColumns);

        setValues(new int[0][0]);
        setRowData(new int[0]);
        setColData(new int [0]);
    }

    void ArrayData(int nRows, int nColumns, int startingValue)
    {
        this.setRows(nRows);
        this.setColumns(nColumns);

        for (int r =0; r < getRows(); r++)
        {
            for (int c = 0; c < getColumns(); c++)
            {
                getValues()[r][c] = startingValue;
            }
        }

        setRowData(new int[0]);
        setColData(new int [0]);
    }

    void generate(int newValue, int total, int minRow, int maxRow, int minCol, int maxCol)
    {
        Random rand = new Random();

        setValues(new int [total][total]);

         //Obtain a number between [0 - maxRow].
            total = rand.nextInt(maxRow);

            // Add minRow to the result to get a number from the required range
            // (i.e., [1 - 10]).
            total += minRow;


//        for( int r = 0; r < maxRow; r++)
//        {
//            // Obtain a number between [0 - maxRow].
//            int randomNum = rand.nextInt(maxRow);
//
//            // Add minRow to the result to get a number from the required range
//            // (i.e., [1 - 10]).
//            randomNum += minRow;
//
//            for (int c =0; c < maxCol; c++)
//            {
//                // Obtain a number between [0 - maxCol].
//                int randNum = rand.nextInt(maxCol);
//
//                // Add minRow to the result to get a number from     the required range
//                // (i.e., [1 - 10]).
//                randNum += minCol;
//
//            }
//        }

    }

    void flip(int num, int val) {

    }
}
