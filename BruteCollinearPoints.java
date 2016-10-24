import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    private Point[] points;
    private ArrayList<LineSegment> lineSegment;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new NullPointerException("");
        for (Point point : points) {
            if (point == null)
                throw new NullPointerException("");
        }      
        int length = points.length;
        this.points = Arrays.copyOf(points, length);
        Arrays.sort(this.points);
        for (int i = 0; i < length - 1; i++) {
            if (this.points[i].compareTo(this.points[i + 1]) == 0) {
                throw new IllegalArgumentException("");
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        if (lineSegment == null)
            segments();
        return lineSegment.size();
    }

    // the line segments
    public LineSegment[] segments() {
        if(lineSegment != null )
            return lineSegment.toArray(new LineSegment[0]);
        int length = points.length;
        lineSegment = new ArrayList<LineSegment>();
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    for (int l = k + 1; l < length; l++) {
                        if(isLine(points[i],points[j],points[k],points[l])){
                            LineSegment segment = createSegment(points[i],points[j],points[k],points[l]);
                            lineSegment.add(segment);
                        }
                    }
                }
            }
        }
        return lineSegment.toArray(new LineSegment[0]);
    }
    private boolean isLine(Point point1, Point point2, Point point3, Point point4){
        double slope1 = point4.slopeTo(point1);
        double slope2 = point4.slopeTo(point2);
        if(slope1 != slope2) return false;
        double slope3 = point4.slopeTo(point3);
        if(slope1 != slope3) return false;
        return true;
    }
    private LineSegment createSegment(Point point1, Point point2, Point point3, Point point4){
        Point[] pointsArray = new Point[]{point1, point2, point3, point4};
        Arrays.sort(pointsArray);
        LineSegment segment = new LineSegment(pointsArray[0],pointsArray[3]);
        return segment;
    }
    public static void main(String [] args) {
        String current = System.getProperty("user.dir");
//        In in = new In(current + "\\src\\collinear\\input6.txt");
        In in = new In(".\\src\\collinear\\input8.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
        
        
    }
}