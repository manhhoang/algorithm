package com.algo.algorithm.search;

public class DepthFirstSearch {

    private static final int ROW = 5, COL = 5;
    private static int max = 0;

    private int dfs(int m[][], int i, int j, boolean visited[][]) {
        // These arrays are used to get row and column numbers of 8 neighbors of a given cell
        int x[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int y[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        int no = 1;
        visited[i][j] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k){
            int a = i + x[k];
            int b = j + y[k];
            if (a >= 0 && a < ROW && b >= 0 && b < COL && m[a][b]==1 && !visited[a][b]){
                int c = dfs(m, a, b, visited);
                no += c;
            }
        }
        return no;
    }

    private int countIslands(int m[][]) {
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and traverse through the all cells of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (m[i][j]==1 && !visited[i][j]) {
                    // If a cell with value 1 is not visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    int no = dfs(m, i, j, visited);
                    if(no > max)
                        max = no;
                    ++count;
                }

        return count;
    }

    // Driver method
    public static void main (String[] args) throws Exception {
        int[][] m = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        DepthFirstSearch dfs = new DepthFirstSearch();
        System.out.println("Number of islands is: "+ dfs.countIslands(m));
        System.out.println("Largest islands is: "+ max);
    }
}
