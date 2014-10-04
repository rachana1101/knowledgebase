package com.knowledgebase.company.tripadvisor;
/**
 * number of 1's islands in a 2-d matrix
 * 
 * @author rachana
 *
 */
public class NoOfOneIn2dmatriz {
    
    private static enum Direction {
        NW(-1, -1), N(0, -1), NE(-1, 1), E(0, 1), SE(1, 1), S(1, 0), SW(1, -1), W(-1, 0);

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

    private static boolean isValid(int newRow, int newCol, Direction direction, int[][] m, boolean[][] visited) {
        // visited was constructed from matrix so we are sure that checking visitor for row lengh would do no harm.
        if (newRow < 0 || newRow >= visited.length) return false;
        if (newCol < 0 || newCol >= visited[0].length) return false;
        if (visited[newRow][newCol]) return false;
        return m[newRow][newCol] == 1;
    }

    private static void dfs(int row, int col, int[][] m, boolean[][] visited) {
        visited[row][col] = true;
        for (Direction direction : Direction.values()) {
            int newRow = row + direction.getRowDelta();
            int newCol = col + direction.getColDelta();
            if (isValid(newRow, newCol, direction, m, visited)) {
                dfs(newRow, newCol, m, visited);
            }
        }
    }

    private static void dfs1(int row, int col, int[][] m, boolean[][] visited) {
        // check recursion state... and expect it to have failures.
        if (row < 0 || row >= m.length || col < 0 || col >= m[0].length) {
            // invalid state, index-out-of-bounds
            return;
        }
        // OK, row/column are valid... more checks
        if (visited[row][col]) {
            // already seen this valid position.
            return;
        }
        // mark the position seen
        visited[row][col] = true;
        // if it's not an island....
        if (0 == m[row][col]) {
           return;
        }
        // OK, we are still on the island, let's optimistically search around....
        for (Direction direction : Direction.values()) {
            dfs1(row + direction.getRowDelta(), col + direction.getColDelta(), m, visited);
        }
    }
    /**
     * Returns the number of 1 islands.
     * 
     * @param m     the input matrix
     * @return      the number of 1 islands.
     */
    public static int count(int[][] m) {
        final boolean[][] visited = new boolean[m.length][m[0].length];
        int count = 0;

        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[0].length; col++) {
                if (m[row][col] == 1 && !visited[row][col]) {
                    dfs1(row, col, m, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 1 } };

        System.out.println("Expected 2, Actual " + count(m));

        int[][] m1 = { { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };

        System.out.println("Expected 1, Actual " + count(m1));

    }
}
