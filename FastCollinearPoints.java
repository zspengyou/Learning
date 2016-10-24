import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    private Point[] points;
    private double[] slope;
    private ArrayList<LineSegment> lineSegment;
    private HashSet<String> pointSlopes;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new NullPointerException("");
        for (Point point : points) {
            if (point == null)
                throw new NullPointerException("");
        }        
        int length = points.length;
        Arrays.sort(points);
        for (int i = 0; i < length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("");
            }
        }
        this.points = points;
    }

    // the number of line segments
    public int numberOfSegments() {
        if (lineSegment == null) 
            segments();
        return lineSegment.toArray(new LineSegment[0]).length;
    }

    // the line segments
    public LineSegment[] segments() {
        if(lineSegment!= null) 
            return lineSegment.toArray(new LineSegment[0]);
        int length = points.length;
        if(length < 4) return new LineSegment[0];
        slope = new double[length + 1];
        lineSegment = new ArrayList<LineSegment>();
        pointSlopes = new HashSet<String>();
        String pointSlope;
        for(int pointIndex = 0; pointIndex < length; pointIndex ++){
            Arrays.sort(points);
            Arrays.sort(points, points[pointIndex].slopeOrder());
            for (int i = 0; i < length; i++)
                slope[i] = points[0].slopeTo(points[i]);
            slope[length] = slope[length-1]+1;
            int count = 0;
            double previous = slope[1];
            for (int i = 1; i < length; i++) {
                if (slope[i] == previous) {
                    count++;
                } else {
                    if (count >= 3) {
                        if(points[0].compareTo(points[i -1])>0){
                            pointSlope = points[0].toString()+slope[i-1];
                        }else{
                            pointSlope = points[i -1].toString()+slope[i-1];
                        }                        
                        if(!pointSlopes.contains(pointSlope)){
                            pointSlopes.add(pointSlope);
                            LineSegment seg = new LineSegment(points[0], points[i-1]);
                            lineSegment.add(seg);
                        }
                    }
                    previous = slope[i];
                    count = 1;
                }
            }
        }
        
        return lineSegment.toArray(new LineSegment[0]);
    }    
    public static void main(String[] args) {
      String current = System.getProperty("user.dir");
      In in = new In(".\\src\\collinear\\input40.txt");
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
      FastCollinearPoints collinear = new FastCollinearPoints(points);
      for (LineSegment segment : collinear.segments()) {
          StdOut.println(segment);
          segment.draw();
      }
      StdDraw.show();
    }
}