package com.algo.data_structure.array;

/*
Imagine we have an image. We’ll represent this image as a simple 2D array where every pixel is a 1 or a 0.
The image you get is known to have a single rectangle of 0s on a background of 1s.
Write a function that takes in the image and returns the coordinates of the rectangle -- either top-left and bottom-right; or top-left, width, and height.

Here are sample images using Java.

// Java
int[][] image = {
  {1, 1, 1, 1, 1, 1, 1},
  {1, 1, 1, 1, 1, 1, 1},
  {1, 1, 1, 0, 0, 0, 1},
  {1, 1, 1, 0, 0, 0, 1},
  {1, 1, 1, 1, 1, 1, 1}
};

3,2 3 2

*/
public class Array2D {

    static int[][] image = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
    };

    private static void solution(int[][] image) {
        int ROW = image.length;
        int COL = image[0].length;
        int x = -1;
        int y = -1;
        int w = 0;
        int h = 0;
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL;) {
                int n = j;
                if(image[i][j] == 0) {
                    if(x == -1)
                        x = j;
                    if(y == -1)
                        y = i;

                    int count = 0;
                    while(n < COL) {
                        if(image[i][n] == 0) {
                            n++;
                            count++;
                        } else {
                            w = count;
                            break;
                        }
                    }
                    break;
                }
                if(n != j)
                    j = n;
                j++;
            }
            if(x != -1 && image[i][x] == 0) {
                continue;
            } else {
                h = i - y;
            }
        }
        System.out.println(x + "," + y + " " + w + " " + h);
    }

    public static void main(String[] args) {
        solution(image);
    }
}
