package me.frostythedev.arraydata.core;

public class GroupMember {

    int rows;
    int columns;

    int values[][];
    int rowData[];
    int colData[];

    public GroupMember(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.values = new int[rows][columns];
        this.rowData = new int[rows];
        this.colData = new int[columns];
    }

    public GroupMember(int rows, int columns, int[][] values, int[] rowData, int[] colData) {
        this.rows = rows;
        this.columns = columns;
        this.values = values;
        this.rowData = rowData;
        this.colData = colData;
    }

    public void test() {

    }

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
