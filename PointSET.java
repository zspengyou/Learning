import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {
    
    private TreeSet<Point2D> pointSet;
    // construct an empty set of points
    public PointSET() {
        pointSet = new TreeSet<Point2D>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return pointSet.isEmpty();
    }

    // number of points in the set
    public int size() {
        return pointSet.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if(p == null)
            throw new NullPointerException();
        pointSet.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if(p == null)
            throw new NullPointerException();
        return pointSet.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        for(Point2D point: pointSet)
            StdDraw.point(point.x(), point.y());
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        List<Point2D> innerPoints = new ArrayList<>();
        for(Point2D point: pointSet)
            if(rect.contains(point))
                innerPoints.add(point);
        return innerPoints;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        double minDistance = 0;
        Point2D nearestPoint = null;
        for(Point2D point: pointSet){
            double distance = point.distanceSquaredTo(p);
            if(distance > minDistance){
                nearestPoint = point;
                minDistance = distance;
            }
        }
        return nearestPoint;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
    }
}