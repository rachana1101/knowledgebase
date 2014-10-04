package com.knowledgebase.company.tripadvisor;

public class PrintMatrixSpiral {
    
    public static void main(String[] args) {
       // int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        
        int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        
        //int[][] m = { { 1, 2 }, { 3,4 } };
        
        printInSprial(m);
        
        //sprial(m);

    }
    
    public static void printInSprial(int[][] m) {
            int xSize = m.length;
            int ySize = m[0].length;
            int col,  k = 0, l = 0;
            xSize--;  ySize--;      

            while(k <= xSize && l <= ySize){
                for(col = l; col <= ySize; ++col) {
                    System.out.print(m[k][col]+ " ");
                }           
                k++;

                for(col = k; col <= xSize; ++col) {
                    System.out.print(m[col][ySize] + " ");
                }
                ySize--;

                for(col = ySize; col >= l; --col) {
                        System.out.print(m[xSize][col] + " ");
                }
                xSize--;


                for(col = xSize; col >= k; --col) {
                    System.out.print(m[col][l] + " ");
                }
                l++;
            }
        }
    
    public static void sprial(int[][] m) {
        int length = m.length;
        for(int row =0;row<m.length/2;row++) {
            for(int col =0;col<(m[0].length+1)/2; col++) {
                int temp = m[row][col];
                m[row][col] = m[length-1-col][row];
                m[length-1-col][row] = m[length-1][length-1-col];
                m[length-1][length-1-col] = m[col][length-1];
                m[col][length-1] = temp;
            }
            
        }
        print(m);
    }
    
    public static void print(int[][] m) {
        for(int row =0;row<m.length;row++) {
            for(int col =0;col<m[0].length; col++) {
                System.out.print("[ "+m[row][col]+" ]");
            }
            System.out.println();
        }
        System.out.println();
    }
}
