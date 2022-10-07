package me.frostythedev.arraydata;

public class OldArrayData {

    private static int rows = 10;
    private static int columns = 10;
    
    private static int values[][] = new int[rows][columns];
    
    private static int rowData[] = new int[rows];
    
    private static int colData[] = new int[columns];

    public static void main(String[] args){

        Tevin tevin = new Tevin(rows, columns, values, rowData, colData);
        Jalisa jalisa = new Jalisa(rows, columns, values, rowData, colData);
        Simone simone = new Simone(rows, columns, values, rowData, colData);

        System.out.println("TEVIN'S TESTING OUTPUT:");
        tevin.test();
        System.out.println("========== \n");

        System.out.println("JALISA'S TESTING OUTPUT:");
        jalisa.test();
        System.out.println("========== \n");

        System.out.println("SIMONE'S TESTING OUTPUT:");
        simone.test();
        System.out.println("========== \n");
    }

}
