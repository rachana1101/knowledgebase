package com.knowledgebase.company.tripadvisor;

public class NoOfIslandInMatrix {
    private static enum Direction {
       NW(-1,-1), N(0,-1), NE(1,-1), E(0,1), SE(1,1), S(1,0), SW(1,-1), W(-1,0);
       
       int rowDelta;
       int colDelta;

       Direction(int rowDelta, int colDelta) {
           this.rowDelta = rowDelta;
           this.colDelta = colDelta;
       }

       public int getRowDelta() {
           return rowDelta;
       }

       public int getColDelta() {
           return colDelta;
       }
        
    }
    public static void main(String... argv) {
        int[][] matrix =  { {1,1,0,0}, {0,0,0,1}, {0,0,1,1}};
        int ctr = count(matrix);
        System.out.println(" no of islands : "+ctr);
    }
    
    public static int count(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int ctr=0;
        for(int row=0;row<matrix.length;row++) {
            for(int column=0;column<matrix[0].length;column++) {
                if(matrix[row][column]==1 && !visited[row][column]) {
                    dfs(row, column, matrix, visited);
                    ctr++;
                }
            }
        }
        return ctr;
    }

    public static void dfs(int row, int column, int[][] m, boolean[][] visited) {
        //if we dont meet the bounry return.
        if(row<0 || row>=m.length || column <0 || column>=m[0].length) {
            return;
        }
        //check if visited 
        if(visited[row][column]){
            return;
        }
        // if not than mark it 
        visited[row][column] = true;
        // are we still on island
        if(m[row][column] ==0) {
            return;
        }
        // now we are still on island start
        for(Direction direction : Direction.values()) {
            dfs(row + direction.getRowDelta(),
                column + direction.getColDelta(), m, visited);
        }
        
    }
}
