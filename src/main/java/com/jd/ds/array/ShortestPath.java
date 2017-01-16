package com.jd.ds.array;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class ShortestPath {

    //No of rows and columns
    private static final int ROW = 5, COL = 5;

    public int bfs(int[][] map, Point start, Point end){
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

        return distTo[end.x][end.y];
    }

    // Driver method
    public static void main (String[] args) throws java.lang.Exception {
        int[][] map = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0}
        };
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);
        ShortestPath shortestPath = new ShortestPath();
        int path = shortestPath.bfs(map, start, end);
        System.out.println("Shortest path: " + path);
    }
}
