package me.frostythedev.arraydata;

import me.frostythedev.arraydata.core.GroupMember;

public class Jalisa extends GroupMember {

    public Jalisa(int rows, int columns, int[][] values, int[] rowData, int[] colData) {
        super(rows, columns, values, rowData, colData);
    }

    @Override
    public void test() {
       ArrayData();
    }

    void ArrayData() {
        setRows(10);
        setColumns(10);

        setValues(new int[0][0]);
        setRowData(new int[0]);
        setColData(new int [0]);
    }

    void ArrayData(int nRows, int nColumns) {
         this.setRows(nRows);
         this.setColumns(nColumns);

        setValues(new int[0][0]);
        setRowData(new int[0]);
        setColData(new int [0]);
    }

    void ArrayData(int nRows, int nColumns, int startingValue) {
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

    void generate(int newValue, int total, int minRow, int maxRow, int minCol, int maxCol) {

    }

    void flip(int num, int val) {

    }
}
