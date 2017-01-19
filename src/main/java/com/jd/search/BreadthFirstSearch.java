package com.jd.search;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class BreadthFirstSearch {

    //No of rows and columns
    private static final int ROW = 5, COL = 5;

    public int[][] bfs(int[][] map, Point start){
        int[] x = {0,  0, 1, -1}; //This represent 4 directions right, left, down , up
        int[] y = {1, -1, 0,  0}; //This represent 4 directions right, left, down , up
        LinkedList<Point> q = new LinkedList<>();
        q.add(start);
        boolean[][] visited = new boolean[COL][ROW];
        for(boolean[] v : visited){
            Arrays.fill(v, false);
        }
        int[][] distTo = new int[COL][ROW];
        distTo[start.x][start.y] = 0;
        visited[start.x][start.y] = true;
        while(!q.isEmpty()){
            Point p = q.removeFirst();
            for(int i = 0; i < 4; i++){
                int a = p.x + x[i];
                int b = p.y + y[i];
                if(a >= 0 && b >= 0 && a < ROW && b < COL && !visited[a][b] && map[a][b] == 0){
                    distTo[a][b] = distTo[p.x][p.y] + 1;
                    visited[a][b] = true;
                    q.add(new Point(a,b));
                }
            }
        }

        return distTo;
    }

    private static void printSolution(int map[][]) {
        for (int x = 0; x < ROW; x++) {
            for (int y = 0; y < COL; y++)
                System.out.print(map[x][y] + " ");
            System.out.println();
        }
    }

    // Driver method
    public static void main (String[] args) throws Exception {
        int[][] map = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0}
        };
        Point start = new Point(0, 0);
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        int[][] distTo = breadthFirstSearch.bfs(map, start);
        printSolution(distTo);
    }
}
