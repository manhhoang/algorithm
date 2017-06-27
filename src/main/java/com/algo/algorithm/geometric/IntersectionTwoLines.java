package com.algo.algorithm.geometric;

/*
 Given points A and B corresponding to line AB and points P and Q corresponding to line PQ, find the point of intersection of these lines. The points are given in 2D Plane with their X and Y Coordinates.

 Examples:

 Input : A = (1, 1), B = (4, 4)
 C = (1, 8), D = (2, 4)
 Output : The intersection of the given lines
 AB and CD is: (2.4, 2.4)

 Input : A = (0, 1), B = (0, 4)
 C = (1, 8), D = (1, 4)
 Output : The given lines AB and CD are parallel.

 */
public class IntersectionTwoLines {

    private static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Method used to display X and Y coordinates
        // of a point
        static void displayPoint(Point p) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }

    static Point lineLineIntersection(Point A, Point B, Point C, Point D) {
        // Line AB represented as a1x + b1y = c1
        double a1 = B.y - A.y;
        double b1 = A.x - B.x;
        double c1 = a1 * (A.x) + b1 * (A.y);

        // Line CD represented as a2x + b2y = c2
        double a2 = D.y - C.y;
        double b2 = C.x - D.x;
        double c2 = a2 * (C.x) + b2 * (C.y);

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        } else {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            return new Point(x, y);
        }
    }

    // Driver method
    public static void main(String args[]) {
        Point A = new Point(1, 1);
        Point B = new Point(4, 4);
        Point C = new Point(1, 8);
        Point D = new Point(2, 4);

        Point intersection = lineLineIntersection(A, B, C, D);

        if (intersection.x == Double.MAX_VALUE &&
                intersection.y == Double.MAX_VALUE) {
            System.out.println("The given lines AB and CD are parallel.");
        } else {
            System.out.print("The intersection of the given lines AB" +
                    "and CD is: ");
            Point.displayPoint(intersection);
        }
    }
}
