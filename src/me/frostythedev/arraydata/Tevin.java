package me.frostythedev.arraydata;

import me.frostythedev.arraydata.core.GroupMember;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Tevin extends GroupMember {
    public Tevin(int rows, int columns, int[][] values, int[] rowData, int[] colData) {
        super(rows, columns, values, rowData, colData);
    }

    @Override
    public void test() {
       /* generate();
        product(10,100);
        print(2,2);
        System.out.println("\n");*/
        //System.out.println("Checkered Odd: " + checkeredOdd());
    }

    // TEVIN'S CORNER

    double checkeredOdd() {

        double oddSum = 0, evenSum = 0;

        for(int y =  0; y < getRows(); y++){
            for(int x = 0; x < getColumns(); x++) {

                if(y % 2 == 0) { // This means the row is EVEN

                    if(x % 2 == 0) { // This means the column is EVEN
                        evenSum += getValues()[y][x];

                    } else { // The column is ODD

                        oddSum += getValues()[y][x];
                    }

                }else { // This Row is ODD

                    if(x % 2 == 0) { // This column is EVEN
                        oddSum += getValues()[y][x];

                    } else { // The Column is ODD

                        evenSum += getValues()[y][x];
                    }
                }
            }
        }

        return (oddSum / evenSum);
    }


    void randDecrementRow(int rowIndex){
        if(rowIndex > getRows() || rowIndex < 0) {
            // error
            System.out.printf("rowIndex exceeds available range [0-%d]. Please supply another number.\n", getRows());
            return;
        }

        Random rnd = ThreadLocalRandom.current();
        int ranIndex = rnd.nextInt(getColumns());

        //System.out.println("randIndex: " + ranIndex + " | old: " + (getValues()[rowIndex][ranIndex]) +  " | new: " + (getValues()[rowIndex][ranIndex]-1));

        getValues()[rowIndex][ranIndex] = (getValues()[rowIndex][ranIndex]-1);
    }

    void randDecrementCol(int colIndex){
        if(colIndex > getRows() || colIndex < 0) {
            // error
            System.out.printf("colIndex exceeds available range [0-%d]. Please supply another number.\n", getColumns());
            return;
        }

        Random rnd = ThreadLocalRandom.current();
        int ranIndex = rnd.nextInt(getRows());

        //System.out.println("randIndex: " + ranIndex + " | old: " + (getValues()[rowIndex][ranIndex]) +  " | new: " + (getValues()[rowIndex][ranIndex]-1));

        getValues()[ranIndex][colIndex] = (getValues()[ranIndex][colIndex]-1);
    }

    int rowProduct(int rowIndex){
        int rowProd = 1;
        for(int i = 0; i < getColumns(); i++) {
            //System.out.println("[" + i + "] " + " Multiplying " + rowProd + " by " + getValues()[rowIndex][i]);
            rowProd*= getValues()[rowIndex][i];
        }
        return rowProd;
    }

    int colProduct(int colIndex){
        int colProd = 1;
        for(int i = 0; i < getRows(); i++) {
            //System.out.println("[" + i + "] " + " Multiplying " + rowProd + " by " + getValues()[rowIndex][i]);
            colProd*= getValues()[i][colIndex];
        }
        return colProd;
    }
    void product (int min, int max){

        // Product of the columns two

        for(int y = 0; y < getRows(); y++) {
            int rowProd = rowProduct(y);

            while (rowProd > (min-1) && rowProd < (max+1)) {
                //System.out.println("rowProd is within range");
                randDecrementRow(y);
                rowProd = rowProduct(y);
            }

            getRowData()[y] = rowProd;
        }

        // Product of the rows

        for(int x = 0; x < getColumns(); x++) {
            int colProd = colProduct(x);

            while (colProd > (min-1) && colProd < (max+1)) {
                //System.out.println("rowProd is within range");
                randDecrementCol(x);
                colProd = colProduct(x);
            }

            getColData()[x] = colProd;
        }
    }

    void print() {
        print(getRows(), getColumns());
    }

    void print(int rows, int columns){

        if(rows > getRows() || columns > getColumns()){
            // error
            System.out.println("You have entered a row or column that is greater than the maximum limit allowed.");
            return;
        }

        for (int y = 0; y < rows; y++){
            for(int x = 0; x < columns; x++) {

                if(x != (columns-1) ) {
                    System.out.print(getValues()[y][x] + "|");
                }else{
                    System.out.print(getValues()[y][x] + "||" + getRowData()[y] + "\n");
                }
            }
        }

        System.out.print("\n");

        for(int i = 0; i < columns; i++){
            if(i != (columns-1)) {
                System.out.print(getColData()[i] + "|");
            }else{
                System.out.print(getColData()[i] + "");
            }
        }
    }

    @Deprecated
    public void generate() {
        Random rnd = ThreadLocalRandom.current();
        for (int y = 0; y < getRows(); y++){
            for(int x = 0; x < getColumns(); x++) {

                getValues()[y][x] = rnd.nextInt(1, 11);
            }
        }
    }
}
