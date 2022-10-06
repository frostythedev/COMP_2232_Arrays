package me.frostythedev.arraydata;

import me.frostythedev.arraydata.core.GroupMember;
import java.lang.Math;
public class Simone extends GroupMember {

    public Simone(int rows, int columns, int[][] values, int[] rowData, int[] colData) {
        super(rows, columns, values, rowData, colData);
    }

    @Override
    public void test() {
        System.out.println("This is Simone's class");


    }


    void sum () //function to calculate the sums of individual rows and columns
    {
        int rsum;
        int csum;

            for(int i=0;i<this.getRows();i++)                   //For loop to traverse array and find the sum of rows and columns
            {
                rsum=0;
                csum=0;
                for(int x=0;x<i;x++)
                {
                    rsum = rsum + this.getValues()[i][x];
                    csum= csum +this.getValues()[x][i];
                }
                this.getRowData()[i]=rsum;
                this.getColData()[i]=csum;
                /*System.out.println("Row"+this.getRowData()[i]);
                System.out.println("Column"+this.getColData()[i]);*/
            }

    }

    void occurrence(int num)                    //function to determine the number of times a number or a multiple occurs
    {
        int rowcounter;
        int colcounter;
        for(int i=0;i<this.getRows();i++)
        {
            rowcounter=0;
            colcounter=0;
            for(int x=0;x<this.getRows();x++)
            {
                if(this.getValues()[i][x]==num || this.getValues()[i][x] % num==0)
                {
                    colcounter++;   //columns, if it or its multiple is not found, the counter is incremented

                }
                else
                {
                    rowcounter++;   //rows, if it or its multiple is found, the counter is incremented
                }
                this.getRowData()[i]=rowcounter;
                this.getColData()[i]=colcounter;

            }

        }
    }

    void standardDeviation() //function to calculate the standard deviation in each row and column
     {
         int sumr;  //row sum
         int sumc;  //column sum
         int mean;
         int sqr;
         double div;
        for(int i=0;i<getRows();i++) //traversing the array
        {
            mean=this.getRowData()[i]/getRows();
            sumr=0;
            for(int x=0;x<getColumns();x++)
            {
                sumr=this.getColData()[i];
            }
            div=(Math.pow((sumr-mean),2))/this.getRows();
            sqr=(int)Math.sqrt(div);                    //converting the value from a double to int to be stored in RowData array
            getRowData()[i]=sqr;

        }
         for(int a=0;a<getColumns();a++)                //calculating the standard deviation of each column
         {
             mean=this.getColData()[a]/getColumns();
             sumc=0;
             for (int b = 0; b < getRows(); b++) {
                 sumc = this.getColData()[b];
             }
             div = (Math.pow((sumc-mean),2))/this.getRows();
             sqr = (int)Math.sqrt(div);                 //converting the value from a double to int to be stored in ColData array
             getColData()[a] = sqr;
         }


    }
}
