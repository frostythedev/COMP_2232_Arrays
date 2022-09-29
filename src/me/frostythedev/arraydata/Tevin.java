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
        /*generate();
        print();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Checkered Odd: " + checkeredOdd());*/
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

    void product (int min, int max){

    }

    void print() {
        for (int y = 0; y < getRows(); y++){
            for(int x = 0; x < getColumns(); x++) {

                if(x != (getColumns()-1) ) {
                    System.out.print(getValues()[y][x] + " | ");
                }else{
                    System.out.print(getValues()[y][x] + "\n");
                }
            }
        }
    }

    void print(int rows, int columns){

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
