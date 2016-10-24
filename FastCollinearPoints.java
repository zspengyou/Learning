import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private Point[] points;
    private double[] slope;
    private ArrayList<LineSegment> lineSegment;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new NullPointerException("");
        for (Point point : points) {
            if (point == null)
                throw new NullPointerException("");
        }
        Arrays.sort(points);
        int length = points.length;
        for (int i = 0; i < length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("");
            }
        }
        this.points = points;
    }

    // the number of line segments
    public int numberOfSegments() {
        return 0;
    }

    // the line segments
    public LineSegment[] segments() {
        Arrays.sort(points, points[0].slopeOrder());
        int length = points.length;
        slope = new double[length];
        lineSegment = new ArrayList<LineSegment>();
        for(int pointIndex = 0; pointIndex < length; pointIndex ++){
            for (int i = 0; i < length; i++) {
                slope[i] = points[pointIndex].slopeTo(points[i]);
            }            
            int count = 0;
            double previous = slope[0];
            for (int i = 1; i < length; i++) {
                if (slope[i] == previous) {
                    count++;
                } else {
                    if (count >= 3) {
                        LineSegment seg = new LineSegment(points[i - count-1], points[i - 1]);
                        lineSegment.add(seg);
                    }
                    previous = slope[i];
                    count = 0;
                }
            }
            if (count >= 3) {
                LineSegment seg = new LineSegment(points[length - count], points[length - 1]);
                lineSegment.add(seg);
            }
        }
        
        return lineSegment.toArray(new LineSegment[0]);
    }
}