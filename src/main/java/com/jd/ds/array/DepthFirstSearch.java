package com.jd.ds.array;

public class DepthFirstSearch {

    //No of rows and columns
    private static final int ROW = 5, COL = 5;

    // A function to check if a given cell (row, col) can be included in DFS
    private boolean isSafe(int m[][], int row, int col, boolean visited[][]) {
        // row number is in range, column number is in range and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (m[row][col]==1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    private void dfs(int m[][], int row, int col, boolean visited[][]) {
        // These arrays are used to get row and column numbers of 8 neighbors of a given cell
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(m, row + rowNbr[k], col + colNbr[k], visited) )
                dfs(m, row + rowNbr[k], col + colNbr[k], visited);
    }

    // The main function that returns count of islands in a given boolean 2D matrix
    private int countIslands(int m[][]) {
        // Make a bool array to mark visited cells. Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and traverse through the all cells of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (m[i][j]==1 && !visited[i][j]) {
                    // If a cell with value 1 is not visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    dfs(m, i, j, visited);
                    ++count;
                }

        return count;
    }

    // Driver method
    public static void main (String[] args) throws java.lang.Exception {
        int m[][]=  new int[][]
                {{1, 1, 0, 0, 0},
                 {0, 1, 0, 0, 1},
                 {1, 0, 0, 1, 1},
                 {0, 0, 0, 0, 0},
                 {1, 0, 1, 0, 1}
        };
        DepthFirstSearch dfs = new DepthFirstSearch();
        System.out.println("Number of islands is: "+ dfs.countIslands(m));
    }
}
