package me.frostythedev.arraydata.archive;

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


    // Missing implementation of key issues
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

        for( int r = 0; r < maxRow; r++)
        {
            //Generating a random row position between the minRow and maxRow
            int rowPosition = rand.nextInt(maxRow - minRow + 1) + minRow;

            for (int c =0; c < maxCol; c++)
            {
                //Generating a random column position between the minCol and maxCol
                int columnPosition = rand.nextInt(maxCol - minCol + 1) + minCol;

                for (int i = 0; i < total; i++)
                {
                   getValues()[r][c] = newValue;
                }
            }
        }
    }

    void flip(int num, int val)
    {
        Random rand = new Random();

        for (int i = 0; i < num; i++)
        {
            int rowPosition = rand.nextInt(getRows());
            int columnPosition = rand.nextInt(getColumns());

            getValues()[rowPosition][columnPosition] = val;
        }
    }
}
